package com.zp.dao;

import com.zp.entity.Address;

import java.util.List;

public interface AddressDao {
    public List<Address> selectAllByUserId(String userId);

    public Address selectByLocal(String local);

    public void deleteById(String id);

    public void insert(Address address);

    public void update(Address address);
}
