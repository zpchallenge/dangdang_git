package com.zp.service;

import com.zp.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersService {
    public List<Users> selectAllByPage(Integer pageNum, Integer pageSize); //分页查询
    public int count();

    public void insert(Users user); //添加用户

    public void updateStatus(String status, String id); //改变用户状态  正常或冻结

}
