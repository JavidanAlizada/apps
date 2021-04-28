package dms.model;

import java.sql.Date;

/**
 *
 * @author Javidan
 */
public class Order {

    private int id;
    private Product productId;
    private Account accountId;
    private Date orderDate;
    private boolean isActive;
    private float orderAmount;

    public Order(int id, Product productId, Account accountId, Date orderDate, boolean isActive, float orderAmount) {
        this.id = id;
        this.productId = productId;
        this.accountId = accountId;
        this.orderDate = orderDate;
        this.isActive = isActive;
        this.orderAmount = orderAmount;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public float getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(float orderAmount) {
        this.orderAmount = orderAmount;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", productId=" + productId + ", accountId=" + accountId + ", orderDate=" + orderDate + ", isActive=" + isActive + ", orderAmount=" + orderAmount + '}';
    }

}
