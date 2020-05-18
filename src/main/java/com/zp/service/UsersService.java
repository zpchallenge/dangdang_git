package com.zp.service;

import com.zp.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersService {
    public boolean login(String email, String password); //根据email查询用户

    public Users selectUserByEmail(String email); //根据email查询用户

    public List<Users> selectAllByPage(Integer pageNum, Integer pageSize); //分页查询
    public int count();

    public boolean register(Users user); //注册

    public void updateStatus(String status, String id); //改变用户状态  正常或冻结

}
