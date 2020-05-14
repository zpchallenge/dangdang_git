package com.zp.dao;

import com.zp.entity.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersDao {
    public Users selectUserByEmail(String email); //根据email查询用户

    public List<Users> selectAllByPage(@Param ("start") Integer start, @Param ("end") Integer end); //分页查询
    public int count();

    public void insert(Users user); //添加用户

    public void updateStatus(@Param ("status") String status,@Param ("id") String id); //改变用户状态  正常或冻结

}
