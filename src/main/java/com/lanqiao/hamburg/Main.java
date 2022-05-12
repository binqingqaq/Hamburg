package com.lanqiao.hamburg;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.lanqiao.hamburg.Jform.MainForm;
import com.lanqiao.hamburg.MySaleShow.controller.MyLogin;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, SQLException {
        /**
         * ��������������
         */
        //����һ
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        //�����
       // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        //������
       // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        //������
        //UIManager.setLookAndFeel( new FlatLightLaf() );
        //�����壺��ɫ
        UIManager.setLookAndFeel( new FlatDarculaLaf() );
        new MyLogin();
    }
}
