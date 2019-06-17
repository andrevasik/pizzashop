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
import java.util.Scanner;

public class Main {
    private static Order orderl;
    private int cCount = 1;

    private static Scanner scnr = new Scanner(System.in);                          //changed
    private Order order;

    public static void main(String[] args) {

        Main main = new Main();

        final char EXIT_CODE = 'E';
        final char CUST_CODE = 'C';
        final char MENU_CODE = 'M';
        final char ORDE_CODE = 'O';
        final char TRAN_CODE = 'T';
        final char CUST_PRNT = 'P';
        final char HELP_CODE = '?';
        char userAction;
        int order_count = 1;
        int transaction_count = 1;
        final String PROMPT_ACTION = "Add 'C'ustomer, 'P'rint Customer, List 'M'enu, Add 'O'rder, List 'T'ransaction or 'E'xit: ";
        ArrayList<Customer> cList = new ArrayList<>();
        ArrayList<Menu> mList = new ArrayList<>();
        ArrayList<Order> oList = new ArrayList<>();
        ArrayList<Transaction> tList = new ArrayList<>();


        Menu menu1 = new Menu(1, "Plain", 3.99);
        Menu menu2 = new Menu(2, "Meat", 5.79);
        Menu menu3 = new Menu(3, "Extra", 7.99);
        Menu menu4 = new Menu(4, "Veg", 4.50);

        mList.add(menu1);
        mList.add(menu2);
        mList.add(menu3);
        mList.add(menu4);


        userAction = getAction(PROMPT_ACTION);

        while (userAction != EXIT_CODE) {
            switch (userAction) {
                case CUST_CODE:
                    cList.add(main.addCustomer());
                    break;
                case CUST_PRNT:
                    Customer.printCustomer(cList);
                    break;
                case MENU_CODE:
                    Menu.listMenu(mList);
                    break;
                case ORDE_CODE: // Order.addOrders();                                                       CHANGED V
                    boolean valid = false;
                    if (cList.size() == 0) {
                        System.out.println("No customers stored.");
                        break;
                    }
                    Customer cust = null;
                    while (!valid) {
                        System.out.print("Enter customer ID : ");
                        int cid = scnr.nextInt();
                        for (Customer customer : cList) {
                            if (customer.getCustomerId() == cid) {
                                valid = true;
                                cust = customer;
                            } else {
                                System.out.println("Invalid customer ID.");                               // CHANGED ^
                            }
                        }
                    }
                    ArrayList<Menu> orderItems = selectMenu(mList);
                    Order order = new Order(order_count);
                    order_count++;
                    Transaction trans = new Transaction(transaction_count, order, PaymentType.unknown);
                    tList.add(trans);
                    transaction_count++;
                    Order.addOrders(order, cust, orderItems, oList);
                    oList.add(order);
                    break;
                case TRAN_CODE:
                    Transaction.listTransactions(tList);
                    break;
            }

            userAction = getAction(PROMPT_ACTION);
        }
    }


    public static ArrayList<Menu> selectMenu(ArrayList<Menu> menus) {                                //changed
        int flag;
        ArrayList<Menu> orderItems = new ArrayList<>();
        while (true) {
            System.out.println("Select menu using ID, 0 = exit :)");
            for (Menu menu : menus)
                System.out.println(menu.getmenuId() + ") " + menu.getmenuItem());
            flag = scnr.nextInt();
            if (flag == 0)
                break;
            Menu item = menus.get(flag - 1);
            boolean found = false;
            for (Menu orderItem : orderItems) {
                if (orderItem.getmenuId() == item.getmenuId()) {
                    orderItem.setMenuQuantity(orderItem.getMenuQuantity() + 1);
                    found = true;
                    break;
                }
            }
            if (!found) {
                item.setMenuQuantity(1);
                orderItems.add(item);
            }
            printSelectedItems(orderItems);
        }
        return orderItems;
    }

    public static void printSelectedItems(ArrayList<Menu> menuItems) {
        System.out.println("\nSelected Order Items: ");
        for (Menu menu : menuItems) {
            System.out.println(menu);
        }
    }
    public static char getAction(String prompt) {
        Scanner scnr = new Scanner(System.in);
        String answer = "";
        System.out.println(prompt);
        answer = scnr.nextLine().toUpperCase() + " ";
        char firstChar = answer.charAt(0);
        return firstChar;
    }

    public Customer addCustomer() {
        Customer cust = new Customer(cCount++);
        //  Scanner scnr = new Scanner(System.in);                                                    //changed
        System.out.println("Please Enter your Name: ");
        cust.setCustomerName(scnr.nextLine());
        System.out.println("Please Enter your Phone: ");
        cust.setCustomerPhoneNumber(scnr.nextLine());
        return cust;

    }
}
