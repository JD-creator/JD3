package com.action;

import com.dao.TAdminDAO;
import com.model.TAdmin;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;

public class adminAction extends ActionSupport
{
  private int userId;
  private String userName;
  private String userPw;
  private String message;
  private String path;
  private int index = 1;
  private TAdminDAO adminDAO;

  public String adminAdd()
  {
    TAdmin admin = new TAdmin();
    admin.setUserName(this.userName);
    admin.setUserPw(this.userPw);
    this.adminDAO.save(admin);
    setMessage("操作成功");
    setPath("adminManage.action");
    return "succeed";
  }

  public String adminManage()
  {
    List adminList = this.adminDAO.findAll();
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("adminList", adminList);
    return "success";
  }

  public String adminDel()
  {
    this.adminDAO.delete(this.adminDAO.findById(Integer.valueOf(this.userId)));
    setMessage("删除成功");
    setPath("adminManage.action");
    return "succeed";
  }

  public TAdminDAO getAdminDAO()
  {
    return this.adminDAO;
  }

  public void setAdminDAO(TAdminDAO adminDAO)
  {
    this.adminDAO = adminDAO;
  }

  public String getMessage()
  {
    return this.message;
  }

  public int getIndex()
  {
    return this.index;
  }

  public void setIndex(int index)
  {
    this.index = index;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }

  public String getPath()
  {
    return this.path;
  }

  public void setPath(String path)
  {
    this.path = path;
  }

  public int getUserId()
  {
    return this.userId;
  }

  public void setUserId(int userId)
  {
    this.userId = userId;
  }

  public String getUserName()
  {
    return this.userName;
  }

  public void setUserName(String userName)
  {
    this.userName = userName;
  }

  public String getUserPw()
  {
    return this.userPw;
  }

  public void setUserPw(String userPw)
  {
    this.userPw = userPw;
  }
}