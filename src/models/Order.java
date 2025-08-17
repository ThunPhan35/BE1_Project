/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author Tcp35
 */
public class Orders {
    private String orderId;
    private Customers customer;
    private FeastMenu feastMenu;
    private int numberOfTable;
    private float totalPrince;
    private LocalDate orderDate;

    public Orders() {
    }

    public Orders(String orderId, Customers customer, FeastMenu feastMenu, int numberOfTable, float totalPrince, LocalDate orderDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.feastMenu = feastMenu;
        this.numberOfTable = numberOfTable;
        this.totalPrince = totalPrince;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public FeastMenu getFeastMenu() {
        return feastMenu;
    }

    public void setFeastMenu(FeastMenu feastMenu) {
        this.feastMenu = feastMenu;
    }

    public int getNumberOfTable() {
        return numberOfTable;
    }

    public void setNumberOfTable(int numberOfTable) {
        this.numberOfTable = numberOfTable;
    }

    public float getTotalPrince() {
        return totalPrince;
    }

    public void setTotalPrince(float totalPrince) {
        this.totalPrince = totalPrince;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    
    
    
}
