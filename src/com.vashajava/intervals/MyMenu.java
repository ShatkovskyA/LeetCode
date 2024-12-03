package com.vashajava.intervals;

import javax.swing.*;

/**
 * MyMenu.
 *
 * @author Anton Shatkovskiy
 * @created 21.11.2024 г.
 */
public class MyMenu {

  public MyMenu() {
    // Создаем панель меню
    JMenuBar menuBar = new JMenuBar();

    // Создаем меню
    JMenu fileMenu = new JMenu("File");

    // Создаем пункты меню
    JMenuItem openItem = new JMenuItem("Open");
    JMenuItem saveItem = new JMenuItem("Save");

    // Добавляем пункты в меню
    fileMenu.add(openItem);
    fileMenu.add(saveItem);

    // Добавляем меню в панель меню
    menuBar.add(fileMenu);

    // Устанавливаем панель меню
//    setJMenuBar(menuBar);
//
//    // Устанавливаем размер окна и делаем его видимым
//    setSize(300, 200);
//    setVisible(true);
  }

  public static void main(String[] args) {
    new MyMenu();
  }

}
