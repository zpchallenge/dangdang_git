package com.zp.action.back;

import com.zp.entity.Users;
import com.zp.service.UsersService;
import com.zp.service.impl.UsersServiceImpl;

import java.util.List;

public class UsersAction {
    private UsersService usersService = new UsersServiceImpl ();

    private List<Users> users;
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;  //总页数
    private Integer total;  //总用户数

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

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

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String showAll(){
        if (pageNum == null){
            pageNum = 1;
        }
        if (pageSize == null){
            pageSize = 3;
        }
        users = usersService.selectAllByPage (pageNum,pageSize);
        total = usersService.count ();
        totalPage = total%pageSize == 0 ? total/pageSize : total/pageSize + 1;
        return "showSuccess";
    }

    private String id;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String updateStatus(){
        if (status.equals ("正常")){
            status = "冻结";
        } else if(status.equals ("冻结")){
            status = "正常";
        }
        usersService.updateStatus (status, id);
        return "success";
    }
}
