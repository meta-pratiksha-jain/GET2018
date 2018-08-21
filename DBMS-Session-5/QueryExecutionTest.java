package storeFrontApplication;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class QueryExecutionTest {

    @Test
    public void testExecuteQuery() {
        QueryExecution queryExecution=new QueryExecution();
        List<OrderDetail> list=queryExecution.getOrderDetails(1);
        for(OrderDetail order:list)
        {
            System.out.println(order.getOrderId()+" "+order.getOrderDate()+" "+order.getOrderTotal());
        }
    }

}
