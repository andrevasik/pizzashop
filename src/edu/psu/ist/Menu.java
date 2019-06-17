/*
Project: Lab 9 Solo Work Pizza Shop Ordering Application Using IntelliJ Draft Version
Purpose Details: To make an ordering program using inputs and outputs
Course: IST 242 - 611
Author: Andrej Vasik
Date Developed: 6/9/2019
Last Date Changed: 6/9/2019
Revision: N/A
*/

package edu.psu.ist;

import java.util.ArrayList;

public class Menu {

    //Class Level Variables - Protect the data
    private int menuId;
    private String menuItem;
    private double menuPrice;                                                                                //changed
    private int menuQuantity;

    //Constructor Method
    public Menu(int _menuId, String _menuItem, double _menuPrice) {
        this.menuId = _menuId;
        this.menuItem = _menuItem;
        this.menuPrice = _menuPrice;                                                                        //changed
        menuQuantity = 0;
    }

    //Setters and Getters
    public int getmenuId() {
        return menuId;
    }

    public void setmenuId(int _menuId) {
        this.menuId = _menuId;
    }

    public String getmenuItem() {
        return menuItem;
    }

    public void setmenuItem(String _menuItem) {
        this.menuItem = _menuItem;
    }

    public double getmenuPrice() {
        return menuPrice;
    }

    public void setmenuPrice(double _menuPrice) {
        this.menuPrice = _menuPrice;
    }                              //changed

    public int getMenuQuantity() {
        return menuQuantity;
    }

    public void setMenuQuantity(int menuQuantity) {
        this.menuQuantity = menuQuantity;
    }

    public static void listMenu(ArrayList<Menu> mList) {
        for (Menu menu : mList) {
            System.out.println(menu.getmenuItem() + " $" + String.format("%.2f", menu.getmenuPrice()));     //changed
        }
    }

    @Override
    public String toString() {
        return String.format("%20s %3.2f %d", menuItem, menuPrice, menuQuantity);
    }
}