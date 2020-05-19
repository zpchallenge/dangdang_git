package com.zp.service;

import com.zp.entity.Address;

import java.util.List;

public interface AddressService {
    //根据用户id查询该用户的所有收货地址
    public List<Address> selectAllByUserId(String userId);

    //添加新地址
    public void add(Address address);

}
