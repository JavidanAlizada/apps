package dms.model;

import java.sql.Date;

/**
 *
 * @author Javidan
 */
public class Report {

    private int id;
    private Delivery deliveryId;
    private Account accountId;
    private Order orderID;
    private String feedback;
    private Date reportDate;

    public Report(int id, Delivery deliveryId, Account accountId, Order orderID, String feedback, Date reportDate) {
        this.id = id;
        this.deliveryId = deliveryId;
        this.accountId = accountId;
        this.orderID = orderID;
        this.feedback = feedback;
        this.reportDate = reportDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Delivery getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Delivery deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public Order getOrderID() {
        return orderID;
    }

    public void setOrderID(Order orderID) {
        this.orderID = orderID;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    @Override
    public String toString() {
        return "Report{" + "id=" + id + ", deliveryId=" + deliveryId + ", accountId=" + accountId + ", orderID=" + orderID + ", feedback=" + feedback + ", reportDate=" + reportDate + '}';
    }

}
