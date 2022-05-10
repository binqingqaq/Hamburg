package com.lanqiao.hamburg;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.lanqiao.hamburg.Jform.MainForm;
import com.lanqiao.hamburg.Login.Login;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        /**
         * 给界面设置主题
         */
        //主题一
        //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        //主题二
       // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
        //主题三
       // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        //主题四
        //UIManager.setLookAndFeel( new FlatLightLaf() );
        //主题五：黑色
        UIManager.setLookAndFeel( new FlatDarculaLaf() );
        new Login();
    }
}
