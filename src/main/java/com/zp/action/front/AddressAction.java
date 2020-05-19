package com.zp.action.front;

import com.zp.entity.Address;
import com.zp.entity.Users;
import com.zp.service.AddressService;
import com.zp.service.impl.AddressServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.List;

public class AddressAction {
    private AddressService addressService = new AddressServiceImpl ();

    private List<Address> addressList;

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    //根据用户id查询该用户的所有收货地址
    public String showAllAddressByUserId(){
        HttpSession session = ServletActionContext.getRequest ().getSession ();
        Users u = (Users) session.getAttribute ("u");
        addressList = addressService.selectAllByUserId (u.getId ());
        return "showAllAddressByUserId";
    }
}
