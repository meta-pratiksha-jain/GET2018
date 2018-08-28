package storeFrontApplication;

import java.sql.*;
import java.util.*;

public class StoreFront {
    
    public static void main(String args[])
    {
        System.out.println("order details of a user which is in shipped state");
        System.out.println("enter user id:");
        Scanner scanner=new Scanner(System.in);
        int userId=scanner.nextInt();
        List<OrderDetail> listOfOrders=DatabaseHelper.getOrderDetails(userId);
        for(OrderDetail orderDetail:listOfOrders)
        {
            System.out.println(orderDetail.getOrderId());
            System.out.println(orderDetail.getProductId());
            System.out.println(orderDetail.getOrderDate());
            System.out.println(orderDetail.getOrderTotal());
            System.out.println();
        }
        System.out.println();
        System.out.println("Insert Images Of Product");
        List<ProductImage> listOfImage=new ArrayList<ProductImage>();
        listOfImage.add(new ProductImage(6, 4, "image1.jpeg", "front"));
        listOfImage.add(new ProductImage(6, 5, "image2.jpeg", "left"));
        listOfImage.add(new ProductImage(4, 6, "image2.jpeg", "right"));
        listOfImage.add(new ProductImage(4, 7, "image3.jpeg", "top"));
        listOfImage.add(new ProductImage(7, 8, "image3.jpeg", "front"));
        listOfImage.add(new ProductImage(8, 9, "image1.jpeg", "left"));
        DatabaseHelper.insertImage(listOfImage);
        System.out.println();
        System.out.println();
        System.out.println("Mark Product status inactive for all those products which were not ordered by any Shopper in last 1 year");
        int updatedRows=DatabaseHelper.updateProductStatus();
        System.out.println("updated rows "+updatedRows);
        System.out.println();
        System.out.println();
        System.out.println("Top category details with their number of children");
        List<TopCategoryDetail> listOfTopCategories=DatabaseHelper.getTopCategoryDetails();
        for(TopCategoryDetail TopCategoryDetail:listOfTopCategories)
        {
            System.out.println(TopCategoryDetail.getName());
            System.out.println(TopCategoryDetail.getNumberOfChildren());
            System.out.println();
        }
    }

}
