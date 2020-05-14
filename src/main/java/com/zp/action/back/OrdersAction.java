package com.zp.action.back;

import com.sun.tools.corba.se.idl.constExpr.Or;
import com.zp.entity.Item;
import com.zp.entity.Orders;
import com.zp.service.ItemService;
import com.zp.service.OrdersService;
import com.zp.service.impl.ItemServiceImpl;
import com.zp.service.impl.OrdersServiceImpl;

import java.util.List;

public class OrdersAction {
    private OrdersService ordersService = new OrdersServiceImpl ();

    private Integer pageNum;
    private Integer pageSize;
    private Integer total;
    private Integer totalPage;
    private List<Orders> ordersList;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public String showAll(){
        if (pageNum == null){
            pageNum = 1;
        }
        if (pageSize == null){
            pageSize = 6;
        }
        ordersList = ordersService.selectAllByPage (pageNum, pageSize);
        total = ordersService.count ();
        totalPage = total%pageSize == 0 ? total/pageSize : total/pageSize + 1;
        return "showSuccess";
    }

    private String id;
    private List<Item> items;
    private Orders orders;

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String showDetailById(){
        orders = ordersService.selectById (id);
        ItemService itemService = new ItemServiceImpl ();
        items = itemService.selectByOrderId (id);
        return "showDetailByIdSuccess";
    }
}
