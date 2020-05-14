package com.zp.dao;

import com.zp.entity.Admin;

public interface AdminDao {
    public Admin selectAdminByUsername(String username); //根据用户名查询管理员
}
