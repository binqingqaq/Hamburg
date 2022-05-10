/*
 * Created by JFormDesigner on Tue May 03 11:00:17 CST 2022
 */

package com.lanqiao.hamburg.MySaleShow.controller.Panel;

import com.lanqiao.hamburg.MySaleShow.controller.Dialog.ShopCarD;
import com.lanqiao.hamburg.MySaleShow.controller.Frame.ModShopCart;
import com.lanqiao.hamburg.MySaleShow.dao.Impl.ItemDaoImpl;
import com.lanqiao.hamburg.MySaleShow.dao.ItemDao;
import com.lanqiao.hamburg.MySaleShow.entity.Item;
import com.lanqiao.hamburg.MySaleShow.entity.ShopCar;
import com.lanqiao.hamburg.MySaleShow.util.ConnectionHandler;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author unknown
 */
public class MySalse2 extends JPanel {

    Frame frame; //����panel����������Frame��������������panel�еİ�ť��Frame����Ŀ���Ȩ
    public MySalse2(Frame frame) throws SQLException {
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
        label4 = new JLabel("ģ������:");
        jTextField = new JTextField();
        comboBox1 = new JComboBox();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton("��ʼ����");
        this.setPreferredSize(new Dimension(815,595));
        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("\u5929\u5929\u83dc\u5355");
        add(label1);
        label1.setBounds(new Rectangle(new Point(330,20), label1.getPreferredSize()));
        ItemDao itemDao1 =null;
        itemDao1=new ItemDaoImpl();

        TableInit(itemDao1.SelectItem());

        //---- label2 ----
        label2.setText("\u83dc\u5355\u5206\u7c7b");
        add(label2);
        label2.setBounds(new Rectangle(new Point(15, 380), label2.getPreferredSize()));
        add(comboBox1);
        comboBox1.setBounds(new Rectangle(70,380,80,25));
        comboBox1.addItem("ȫ����Ʒ");
        comboBox1.addItem("��ζСʳ");
        comboBox1.addItem("����ȫ��");
        comboBox1.addItem("��ֵ�ײ�");
        comboBox1.addItem("�ͷ���Ʒ");
        comboBox1.addItem("��ѡ��ʳ");
        comboBox1.addActionListener(a->{
            String str= String.valueOf(comboBox1.getSelectedItem());
            ItemDao itemDao = new ItemDaoImpl();
            ResultSet rs=null;
            DefaultTableModel tableModel1=null;
            //--�����ȶ�
            if(str.equals("ȫ����Ʒ")){
                System.out.println("all");
                try{

                    jPanelTable.setVisible(false);
                    ItemDao itemDao2 = new ItemDaoImpl();
                    TableInit(itemDao2.SelectItem());
                } catch (SQLException e) {
                    e.printStackTrace();
                } ;


            }else if(str.equals("��ζСʳ")){
                System.out.println("DeliciousStaple");
                try{
                    jPanelTable.setVisible(false);
                    ItemDao itemDao2 = new ItemDaoImpl();
                    TableInit(itemDao2.SelectFoodType(str));
                }catch (SQLException EX){
                    EX.printStackTrace();
                }
            }else if(str.equals("����ȫ��")){
                System.out.println("SignatureWholeChicken");
                try{
                    jPanelTable.setVisible(false);
                    ItemDao itemDao2 = new ItemDaoImpl();
                    TableInit(itemDao2.SelectFoodType(str));
                }catch (SQLException EX){
                    EX.printStackTrace();
                }
            }else if(str.equals("��ֵ�ײ�")){
                System.out.println("SignaturePackage");
                try{
                    jPanelTable.setVisible(false);
                    ItemDao itemDao2 = new ItemDaoImpl();
                    TableInit(itemDao2.SelectFoodType(str));
                }catch (SQLException EX){
                    EX.printStackTrace();
                }
            }else if(str.equals("�ͷ���Ʒ")){
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

        // --- ģ������---
        add(label4);
        label4.setBounds(new Rectangle(new Point(15,420),label4.getPreferredSize()));
        add(jTextField);
        jTextField.setBounds(70,420,90,25);
        add(button4);
        button4.setBounds(new Rectangle(new Point(170,420),button4.getPreferredSize()));
        button4.addActionListener(a->{
            JOptionPane.showMessageDialog(this,"������ܻ��ڿ�����","����",2);
        });
        //---- button1 ----
        button1.setText("\u52a0\u5165\u8d2d\u7269\u8f66");
        add(button1);
        button1.setBounds(new Rectangle(new Point(170, 380), button1.getPreferredSize()));
        button1.addActionListener(
                (e)->{
                    int rowNo = table1.getSelectedRow();//��ȡ��ѡ���кţ���ȡ��Ʒչʾ��ȫ����Ϣ�����ڴ��빺�ﳵ��
                    int Id=(int)table1.getValueAt(rowNo, 0);
                    String FoodName=(String)table1.getValueAt(rowNo, 1);
                    Float Price=(Float)table1.getValueAt(rowNo, 2);
                    Float ProPrice=(Float) table1.getValueAt(rowNo, 3);
                    int Sock=(int)table1.getValueAt(rowNo, 4);
                    String Tastes=(String)table1.getValueAt(rowNo, 5);
                    String FoodType=(String)table1.getValueAt(rowNo, 6);
                    //String ImgUrl=(String)table1.getValueAt(rowNo,7); //ת��ΪͼƬ��ҪJpanel������Jpanel����ת��ΪString��
                    /* Item item=new Item(id,title,price,description,sales,img_url,FoodType);*/
                    // �ֱ������Ĭ��ÿ����Ĭ������Ϊ1���ֶ��޸�������colnum��ʼ��Ϊ1�������ύ�Զ�����
                    //new һ�����ﳵ��Ԫ���󣬴��һ����Ʒ�Ĳ�����Ϣ
                    ShopCar shopCar = new ShopCar();
                    shopCar.setId(Id);
                    shopCar.setPrice(ProPrice);
                    shopCar.setNum(1); //Ĭ������Ϊ1,θ��Ӧ��û��ô��,���Ե�
                    shopCar.setTitle(FoodName);
                    ItemDao itemDao = new ItemDaoImpl();
                    new ShopCarD(shopCar,itemDao.SelectImgAdd(shopCar.getTitle())).setVisible(true); //���빺�ﳵ
                }
        );

        //---- button2 ----
        button2.setText("�ҵĹ��ﳵ");
        add(button2);
        button2.setBounds(new Rectangle(new Point(275, 380), button2.getPreferredSize()));
        button2.addActionListener(a->{
            try {
                ModShopCart modShopCar = new ModShopCart();
                modShopCar.setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        //---- button3 ----
        button3.setText("�˳���¼");
        add(button3);
        button3.setBounds(new Rectangle(new Point(390, 380), button3.getPreferredSize()));
        button3.addActionListener(a->{
            System.out.println("--------ע��--------");
            System.out.println("�����û���¼��Ϣ");
            //�����ǰ�û���¼��Ϣ��ÿ�ε�¼ֻ����һ���û������빺�ﳵʱ֧�����ɶ�������ɶ�����Ҫ
            // ���������û���¼Ӧ�����ݱ������������Լ�����
            //��ȡ��ǰFrame����--�������������--�´ε�¼���ݱ����
            String sql = "DELETE FROM currentuser";
            try {
                conn = ConnectionHandler.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate();
                ConnectionHandler.closeConnection();
                this.frame.setVisible(false);

            } catch (SQLException e) {
                e.printStackTrace();
            }


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
    public Object[][] getDataFromDatabase(ResultSet rs) throws SQLException {
        //�ⲿ�ṩ�����
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
        // �Ѽ��ϵ����ݣ���Ʒ��Ϣ��ת���ɶ�ά����
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
                data[i][7] = TmageFollower(list.get(i).getImg_url()) ; //���нػ����ݲ�����������ͼƬ
            }
        }
        return data;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel FoodLabel;
    private JLabel FoodJL;
    private JPanel jPanelTable;  //������
    private JPanel jPanelButton; //������
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;  //���ڷ��ö���ͼƬ
    private String head[] = {"id","��Ʒ����","Դ��","������","���","��ζ","����","ͼƬ"};
    private Object[][] data = null;
    private JTable table1;
    private JLabel label2;
    private JTextField jTextField;
    private JLabel label4;
    private JButton button4;
    private JLabel label3;  //ͼƬ����
    private JComboBox comboBox1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public Connection conn=null;
    private TableColumn column;

    //��������ʾ��ƷͼƬ
    public void ShowFood(String FoodUrl){
        JLabel FoodJL;
        ImageIcon image= new ImageIcon(FoodUrl);
        image.setImage(image.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
        FoodJL = new JLabel(image);
        this.add(FoodJL);  //��ӽ�Panel
        FoodJL.setBounds(new Rectangle(new Point(30, 250), FoodJL.getPreferredSize()));
    }
    //���ڵ�Ԫ���С
    public void JTRowSize(JTable table){
        table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// �������ñ���п�
        for (int i = 0; i < 8; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(50);
                table.setRowHeight(50);
            }
        }
    }
    //ͼƬ������--��Ԫ����ʾͼƬ
    //����ѡ��Icon����ʾͼ��
    //����ѡ��ImageIcon��ʾͼƬ
    public JPanel TmageFollower(String url){
        JLabel labelA = new JLabel();
        ImageIcon imageIcon = new ImageIcon(url);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT));
        labelA.setIcon(imageIcon);
        JPanel jPanel = new JPanel();
        jPanel.add(labelA);
        return jPanel;
    }
    //�������Ƕ�׹���
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
        table1.setBorder(BorderFactory.createLineBorder(Color.BLACK)); //չʾĬ���б�
        table1.setModel(tableModel);
        JTRowSize(table1);
        table1.getColumnModel().getColumn(7).setCellRenderer(new JTableCellRender());
        this.add(jPanelTable).setVisible(true);
        jPanelTable.setPreferredSize(new Dimension(815,595));
        //======== this ========
        jPanelTable.setLayout(null);
        jPanelTable.setBounds(10,45,800,320);
    }

    //ͼ��ػ������������ʹ��

    public static void main(String[] args) throws SQLException {
        // �������
        Frame frame=new Frame("MySalesPanel");
        frame.add(new MySalse2(frame),BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}

class JTableCellRender extends JPanel implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return (JPanel)value;
    }
}
