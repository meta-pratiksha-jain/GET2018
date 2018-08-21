package storeFrontApplication;
import java.sql.*;

public class OrderDetail {
    private int orderId;
    private Date orderDate;
    private double orderTotal;
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public double getOrderTotal() {
        return orderTotal;
    }
    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }
    

}
