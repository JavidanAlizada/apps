package dms.model;

import java.sql.Date;

/**
 *
 * @author Javidan
 */
public class Delivery {

    private int id;
    private Order orderId;
    private Account courerId;
    private Date startDate;
    private Date endDate;
    private boolean isCompleted;

    public Delivery() {
    }

    public Delivery(int id, Order orderId, Account courerId, Date startDate, Date endDate, boolean isCompleted) {
        this.id = id;
        this.orderId = orderId;
        this.courerId = courerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public Account getCourerId() {
        return courerId;
    }

    public void setCourerId(Account courerId) {
        this.courerId = courerId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public String toString() {
        return "Delivery{" + "id=" + id + ", orderId=" + orderId + ", courerId=" + courerId + ", startDate=" + startDate + ", endDate=" + endDate + ", isCompleted=" + isCompleted + '}';
    }

}
