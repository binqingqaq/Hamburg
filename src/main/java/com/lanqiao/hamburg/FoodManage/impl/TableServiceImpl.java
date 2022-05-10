package com.lanqiao.hamburg.FoodManage.impl;

import com.lanqiao.hamburg.Interface.service.TableService;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;

/**
 * @author Binqing
 * @类说明 实现TableService  接口  对表操作
 * @date 2022/5/7
 */
public class TableServiceImpl implements TableService {

    /**
     * @方法说明 进行表的优化，包括行列大小字体样式的设置
     * @author Binqing
     * @date 2022/5/7 22:05
     * @param table1 所要优化的表
     * @param head 表头信息
     * @return void
     */

    @Override
    public void tableOptimize(JTable table1, String[] head) {

        table1.setRowHeight(100);// 设置表格行宽
        Font font=new Font("宋体",Font.BOLD,20);
        table1.setFont(font);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// 以下设置表格列宽
        for (int i = 0; i < 8; i++) {
            TableColumn column = table1.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(20);
            }
            if (i== 7){
                column.setPreferredWidth(120);
            }
            if (i==6){
                column.setPreferredWidth(20);
            }
        }
        JTableHeader head1 = table1.getTableHeader(); // 创建表格标题对象
        head1.setPreferredSize(new Dimension(head1.getWidth(), 50));// 设置表头大小
        head1.setFont(new Font("楷体", Font.PLAIN, 18));// 设置表格字体
        DefaultTableCellRenderer ter = new DefaultTableCellRenderer()// 设置表格间隔色
        {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                // table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
                if (row % 2 == 0)
                    setBackground(Color.DARK_GRAY);
                else if (row % 2 == 1)
                    setBackground(Color.darkGray);
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        };
        for (int i = 0; i < 7; i++) {
            table1.getColumn(head[i]).setCellRenderer(ter);
        }
    }
}
