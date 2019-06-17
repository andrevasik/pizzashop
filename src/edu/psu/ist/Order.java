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

import edu.psu.ist.Customer;

import edu.psu.ist.Menu;

public class Order {
    //Class Level Variables - Protect the data
    private int orderId;
    private Customer cust;
    private ArrayList<Menu> menuItem;
                                                                                                //changed


    //Constructor Method
    public Order(int _orderId) {
        this.orderId = _orderId;
    }

    public static ArrayList<Order> addOrders(Order order1, Customer customer, ArrayList<Menu> cMenu, ArrayList<Order> oList) {
        return oList;
    }

    // public static void addOrders(Order order1, Customer customer, ArrayList<Menu> cMenu) {               //
  //  }

    //Setters and Getters
    public int getorderId() {
        return orderId;
    }

    public void setorderId(int _orderId) {
        this.orderId = _orderId;
    }
// }



    public static void addOrders(Order order, Customer customer, ArrayList<Menu> mList){
        order.setorderId(order.getorderId());
        order.setCust(customer);
        order.setMenuItem(mList);
        order.setCust(customer);
        System.out.println("\nOrder added with order ID : " + order.getorderId());
        System.out.println("\nWith Menu : ");
        for(Menu menu : mList){
            System.out.println(menu.getmenuItem());
        }
        System.out.println("\nCustomer Name : " + order.getCust().getCustomerName()
                + ", Customer ID : " + order.getCust().getCustomerId());
    }

    public ArrayList<Menu> getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(ArrayList<Menu> menuItem) {
        this.menuItem = menuItem;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    @Override
    public String toString() {
        String string = "";
        string += "\nOrder ID: " + orderId + "\n";
        for(Menu menu : menuItem){
            System.out.println(menu);
        }
        return string;
    }
}