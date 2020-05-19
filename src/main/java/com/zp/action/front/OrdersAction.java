package com.zp.action.front;

import com.zp.entity.*;
import com.zp.service.AddressService;
import com.zp.service.BookService;
import com.zp.service.ItemService;
import com.zp.service.OrdersService;
import com.zp.service.impl.AddressServiceImpl;
import com.zp.service.impl.BookServiceImpl;
import com.zp.service.impl.ItemServiceImpl;
import com.zp.service.impl.OrdersServiceImpl;
import com.zp.util.UUIDUtil;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class OrdersAction {
    private OrdersService ordersService = new OrdersServiceImpl ();
    private AddressService addressService = new AddressServiceImpl ();
    private ItemService itemService = new ItemServiceImpl ();
    private BookService bookService = new BookServiceImpl ();

    private Address address;
    private Double totalPrice;
    private String orderNo;
    private Integer selValue;

    public Integer getSelValue() {
        return selValue;
    }

    public void setSelValue(Integer selValue) {
        this.selValue = selValue;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //下订单
    public String addOrder(){
        HttpSession session = ServletActionContext.getRequest ().getSession ();
        Users u = (Users) session.getAttribute ("u");
        Cart cart = (Cart) session.getAttribute ("cart");

        //新添加的地址
        if (selValue == 0){
            address.setId (UUIDUtil.getUUID ());
            address.setUserId (u.getId ());
            addressService.add (address);
        }

        //添加订单
        Orders order = new Orders ();
        order.setId (UUIDUtil.getUUID ());
        order.setOrderNo (UUIDUtil.getUUID ());
        order.setUser (u);
        order.setTotal (cart.getTotalPrice ());
        order.setCreateDate (new Date ());
        order.setAddress (address);
        order.setStatus ("未支付");
        ordersService.add (order);

        //添加订单条目
        Map<Integer, CartItem> itemMap = cart.getItemMap ();
        Collection<CartItem> values = itemMap.values ();
        for (CartItem cartItem : values) {
            Item item = new Item ();
            item.setId (UUIDUtil.getUUID ());
            item.setBook (cartItem.getBook ());
            item.setCount (cartItem.getCount ());
            item.setCreateDate (new Date ());
            item.setOrder (order);
            //调用业务层 添加订单条目
            itemService.insert (item);
        }


        totalPrice = order.getTotal ();
        orderNo = order.getOrderNo ();
        return "addOrderSuccess";
    }



    //改变支付状态
    public String updateStatus(){
        Orders order = ordersService.selectByOrderNo (orderNo);
        if (order.getStatus ().equals ("未支付")){
            order.setStatus ("已支付");
        } else {
            order.setStatus ("未支付");
        }


        ordersService.updateStatus (orderNo, order.getStatus ());

        //支付成功，修改商品的销量
        HttpSession session = ServletActionContext.getRequest ().getSession ();
        Cart cart = (Cart) session.getAttribute ("cart");

        Map<Integer, CartItem> itemMap = cart.getItemMap ();
        Collection<CartItem> cartItems = itemMap.values ();
        for (CartItem cartItem : cartItems) {
            Book book = cartItem.getBook ();
            Integer sale = book.getSale ();
            book.setSale (sale + cartItem.getCount ());
            bookService.update (book);
        }


        //清空购物车
        session.removeAttribute ("cart");

        orderNo = order.getOrderNo ();
        totalPrice = order.getTotal ();

        return "updateStatusSuccess";
    }
}
