package com.example;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SessionFactory factory =
                new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("How many orders do you want to enter: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {

            System.out.println("\nEnter details for Order " + i);

            System.out.print("Enter Order ID: ");
            int orderId = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Item Name: ");
            String itemName = sc.nextLine();

            System.out.print("Enter Quantity: ");
            int quantity = sc.nextInt();

            System.out.print("Enter Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Date: ");
            String date = sc.nextLine();

            System.out.print("Enter User Name: ");
            String userName = sc.nextLine();

            Order order = new Order();

            order.setOrderId(orderId);
            order.setItemName(itemName);
            order.setQuantity(quantity);
            order.setAmount(amount);
            order.setDate(date);
            order.setUserName(userName);

            session.save(order);
        }

        tx.commit();

        session.close();
        factory.close();
        sc.close();

        System.out.println("\nOrders Saved Successfully!");
    }
}