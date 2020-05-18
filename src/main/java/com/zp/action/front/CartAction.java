package com.zp.action.front;

import com.zp.entity.Book;
import com.zp.entity.Cart;
import com.zp.entity.CartItem;
import com.zp.service.BookService;
import com.zp.service.impl.BookServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CartAction {
    private Integer id; //图书id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String addCart(){
        //查询出图书信息
        BookService bookService = new BookServiceImpl ();
        Book book = bookService.selectById (id);
        HttpSession session = ServletActionContext.getRequest ().getSession ();
        Cart cart = (Cart) session.getAttribute ("cart");
        Map<Integer,CartItem> itemMap = new HashMap<> ();
        if (cart == null){
            //没有创建购物车，则创建
            cart = new Cart (itemMap);
            session.setAttribute ("cart",cart);
        }

        //已有购物车
        itemMap = cart.getItemMap ();
        if (itemMap.containsKey (id)){
            CartItem cartItem = itemMap.get (id);
            cartItem.setCount (cartItem.getCount () + 1);
        } else {
             CartItem cartItem = new CartItem (book,1);
             itemMap.put (id,cartItem);
        }

        cart = getCart (cart);

        return "success";
    }

    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public static Cart getCart(Cart cart){
        Map<Integer, CartItem> itemMap = cart.getItemMap ();
        Collection<CartItem> values = itemMap.values ();

        double priceSave = 0.0;
        double totalPrice = 0.0;
        for (CartItem cartItem : values) {
            Double price = cartItem.getBook ().getPrice ();
            Double dprice = cartItem.getBook ().getDprice ();
            Integer count = cartItem.getCount ();
            priceSave += (price - dprice) * count;
            totalPrice += dprice * count;
        }
        cart.setPriceSave (priceSave);
        cart.setTotalPrice (totalPrice);
        return cart;
    }


    public String changeCount(){
        HttpSession session = ServletActionContext.getRequest ().getSession ();
        Cart cart = (Cart) session.getAttribute ("cart");
        Map<Integer, CartItem> itemMap = cart.getItemMap ();
        CartItem cartItem = itemMap.get (id);
        if (count == null){
            cartItem.setCount (cartItem.getCount ());
        }else {
            if (count < 1){
                count = 1;
            }
            cartItem.setCount (count);
        }
        cart = getCart (cart);
        return "success";
    }

    public String deleteById(){
        HttpSession session = ServletActionContext.getRequest ().getSession ();
        Cart cart = (Cart) session.getAttribute ("cart");
        Map<Integer, CartItem> itemMap = cart.getItemMap ();
        itemMap.remove (id);
        cart = getCart (cart);
        return "success";
    }
}
