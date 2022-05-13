package com.lanqiao.hamburg.MySaleShow.controller.Panel;

import com.lanqiao.hamburg.MySaleShow.controller.Dialog.ShopCarD;
import com.lanqiao.hamburg.MySaleShow.controller.Frame.ModShopCart;
import com.lanqiao.hamburg.MySaleShow.dao.CurrentUserDao;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.CurrentUserDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.ItemDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.ShopCarDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.ItemDao;
import com.lanqiao.hamburg.MySaleShow.dao.ShopCarDao;
import com.lanqiao.hamburg.MySaleShow.entity.Item;
import com.lanqiao.hamburg.MySaleShow.entity.ShopCar;
import com.lanqiao.hamburg.MySaleShow.util.ConnectionHandler;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * @description: 菜品销售与微信支付主面板
 * @author: DavidNan
 * @date: 2022/5/1 20:36
 */

public class MySalse extends JPanel {

    Frame frame;  //传入目标窗体对象，便于控制
    public MySalse(Frame frame) throws SQLException {
        this.frame=frame;
        initComponents();
    }
    private void initComponents() throws SQLException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel(String.valueOf(JLabel.CENTER));
        scrollPane1 = new JScrollPane();
        scrollPane2 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();
        label4 = new JLabel("模糊查询:");  //-----暂不提供----//想要后期写一下
        jTextField = new JTextField();
        comboBox1 = new JComboBox();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton("OK");
        this.setPreferredSize(new Dimension(815,595));
        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("菜品销售");
        label1.setFont(new Font("宋体",Font.BOLD,18));
        label1.setForeground(Color.blue);
        add(label1);
        label1.setBounds(330,20,80,40);
        ItemDao itemDao1 =null;
        itemDao1=new ItemDaoImpl();
        //---- 默认初始化列表 ------
        TableInit(itemDao1.SelectItem());

        //---- label2 ----
        label2.setText("\u83dc\u5355\u5206\u7c7b");
        add(label2);
        label2.setBounds(new Rectangle(new Point(15, 380), label2.getPreferredSize()));
        add(comboBox1);
        comboBox1.setBounds(new Rectangle(70,380,80,25));

        //--------- 下拉菜单 ------------

        comboBox1.addItem("All");
        comboBox1.addItem("美味小食");
        comboBox1.addItem("招牌全鸡");
        comboBox1.addItem("超值套餐");
        comboBox1.addItem("缤纷饮品");
        comboBox1.addItem("精选主食");

        comboBox1.addActionListener(a->{
            String str= String.valueOf(comboBox1.getSelectedItem());
            if(str.equals("All")){
                System.out.println("all");
                try{
                    jPanelTable.setVisible(false);
                    ItemDao itemDao2 = new ItemDaoImpl();
                    TableInit(itemDao2.SelectItem());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else if(str.equals("美味小食")){
                System.out.println("DeliciousStaple");
                try{
                    jPanelTable.setVisible(false);
                    ItemDao itemDao2 = new ItemDaoImpl();
                    TableInit(itemDao2.SelectFoodType(str));
                }catch (SQLException EX){
                    EX.printStackTrace();
                }
            }else if(str.equals("招牌全鸡")){
                System.out.println("SignatureWholeChicken");
                try{
                    jPanelTable.setVisible(false);
                    ItemDao itemDao2 = new ItemDaoImpl();
                    TableInit(itemDao2.SelectFoodType(str));
                }catch (SQLException EX){
                    EX.printStackTrace();
                }
            }else if(str.equals("超值套餐")){
                System.out.println("SignaturePackage");
                try{
                    jPanelTable.setVisible(false);
                    ItemDao itemDao2 = new ItemDaoImpl();
                    TableInit(itemDao2.SelectFoodType(str));
                }catch (SQLException EX){
                    EX.printStackTrace();
                }
            }else if(str.equals("缤纷饮品")){
                System.out.println("ColorfulDrinks");
                try{
                    jPanelTable.setVisible(false);
                    ItemDao itemDao2 = new ItemDaoImpl();
                    TableInit(itemDao2.SelectFoodType(str));
                }catch (SQLException EX){
                    EX.printStackTrace();
                }
            }else{
                System.out.println("FeaturedStaples");
                try{
                    jPanelTable.setVisible(false);
                    ItemDao itemDao2 = new ItemDaoImpl();
                    TableInit(itemDao2.SelectFoodType(str));
                }catch (SQLException EX){
                    EX.printStackTrace();
                }
            }
        });


        add(label4);
        label4.setBounds(new Rectangle(new Point(15,420),label4.getPreferredSize()));
        add(jTextField);
        jTextField.setBounds(70,420,90,25);
        add(button4);
        button4.setBounds(175,420,80,30);
        button4.addActionListener(a->{
            JOptionPane.showMessageDialog(this,"To be developed","Warn",2);
        });
        //---- button1 ----
        button1.setText("AddCar");
        add(button1);
        button1.setBounds(175,380,80,30);
        button1.addActionListener(
                (e)->{
                    int rowNo = table1.getSelectedRow();
                    if(rowNo==-1){
                        JOptionPane.showMessageDialog(this,"请在表格选择商品","错误",0);
                    }else{
                        int Id=(int)table1.getValueAt(rowNo, 0);
                        String FoodName=(String)table1.getValueAt(rowNo, 1);
                        Float Price=(Float)table1.getValueAt(rowNo, 2);
                        Float ProPrice=(Float) table1.getValueAt(rowNo, 3);
                        int Sock=(int)table1.getValueAt(rowNo, 4);
                        String Tastes=(String)table1.getValueAt(rowNo, 5);
                        String FoodType=(String)table1.getValueAt(rowNo, 6);
                        ShopCar shopCar = new ShopCar();
                        shopCar.setId(Id);
                        shopCar.setPrice(ProPrice);
                        shopCar.setNum(1);
                        shopCar.setTitle(FoodName);
                        ItemDao itemDao = new ItemDaoImpl();
                        new ShopCarD(shopCar,itemDao.SelectImgAdd(shopCar.getTitle())).setVisible(true);
                    }
                }
        );

        //---- button2 ----
        button2.setText("ModCar");
        add(button2);
        button2.setBounds(275,380,80,30);
        button2.addActionListener(a->{
            try {
                ModShopCart modShopCar = new ModShopCart();
                modShopCar.setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        //---- button3 ----
        button3.setText("注销"); //
        add(button3);
        button3.setBounds(375,380,80,30);
        button3.addActionListener(a->{
            CurrentUserDao currentUserDao = new CurrentUserDaoImpl();
            currentUserDao.DelLoginData();  //当前用户退出并销除当前用户登录数据
            this.setVisible(false);   //控制关闭主窗体
        });

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    /**
     * @description: rs是查询到的
     * @param rs:
     * @return java.lang.Object[][]
     * @author: DavidNan
     * @date: 2022/5/13 19:46
     */

    public Object[][] getDataFromDatabase(ResultSet rs) throws SQLException {
        java.util.List<Item> list = new ArrayList<Item>();
        try {
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt(1));
                item.setPro_name(rs.getString(4));
                item.setPrice(rs.getFloat(5));
                item.setPrefer_price(rs.getFloat(6));
                item.setStock(rs.getInt(7));
                item.setTaste(rs.getString(10));
                item.setPro_cate(rs.getString(3));
                item.setImg_url(rs.getString(8));
                list.add(item);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
                ConnectionHandler.closeConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        data = new Object[list.size()][head.length];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getId();
                data[i][1] = list.get(i).getPro_name();
                data[i][2] = list.get(i).getPrice();
                data[i][3] = list.get(i).getPrefer_price();
                data[i][4] = list.get(i).getStock();
                data[i][5] = list.get(i).getTaste();
                data[i][6] = list.get(i).getPro_cate();
                data[i][7] = TmageFollower(list.get(i).getImg_url()) ;
            }
        }
        return data;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JPanel jPanelTable;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private String head[] = {"Id","FoodName","Price","CPrice","Stock","Taste","Type","Pic"};
    private Object[][] data = null;
    private JTable table1;
    private JLabel label2;
    private JTextField jTextField;
    private JLabel label4;
    private JButton button4;
    private JComboBox comboBox1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public Connection conn=null;
    private TableColumn column;


    public void JTRowSize(JTable table){
        table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        for (int i = 0; i < 8; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(50);
                table.setRowHeight(50);
            }
        }
    }
    /**
     * @description: 输入一个图片的地址位置，然后函数内对该路径下的图片
     * 进行一系列初始化，并装入一个label标签，label标签在装入一个panel容器并返回
     * @param url:
     * @return javax.swing.JPanel
     * @author: DavidNan
     * @date: 2022/5/13 19:10
     */

    public JPanel TmageFollower(String url){
        JLabel labelA = new JLabel();
        ImageIcon imageIcon = new ImageIcon(url);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        labelA.setIcon(imageIcon);
        JPanel jPanel = new JPanel();
        jPanel.add(labelA);
        return jPanel;
    }

    /**
     * @description: 输入一个游标，传入给getDataFromDatabase(rs)函数调用，内部设置单元格可重写便于改变
     * 单元格的大小，即每次将单元格刷新时都会重新初始化表格
     * @param rs: 游标数据，这里是有关与根据食物的类型查找到属于该类型的数据
     * @return void
     * @author: DavidNan
     * @date: 2022/5/13 19:15
     */

    public void TableInit(ResultSet rs) throws SQLException {
        jPanelTable = new JPanel();
        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        jPanelTable.add(scrollPane1);
        scrollPane1.setBounds(10, 45, 800, 320);
        DefaultTableModel tableModel = new DefaultTableModel(getDataFromDatabase(rs), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table1.setModel(tableModel);
        //重新设置单元格大小
        JTRowSize(table1);
        //将第八列的表格渲染成jpanel,便于装入图片
        table1.getColumnModel().getColumn(7).setCellRenderer(new JTableCellRender());
        this.add(jPanelTable).setVisible(true);
        jPanelTable.setPreferredSize(new Dimension(815,595));
        //======== this ========
        jPanelTable.setLayout(null);
        jPanelTable.setBounds(10,45,800,320);
    }

    //---------测试面板功能---------
    public static void main(String[] args) throws SQLException {
        Frame frame=new Frame("MySalesPanel");
        frame.add(new MySalse(frame),BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

}

//单元格渲染类,获取表格端元个渲染组件，因为最后一个表格需要需要刷新图片，因此需要将表格用一个容器来装载图片

class JTableCellRender extends JPanel implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return (JPanel)value;
    }
}

