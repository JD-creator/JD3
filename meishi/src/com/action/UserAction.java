package com.action;

import com.dao.TUserDAO;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class UserAction extends ActionSupport
{
  private Integer userId;
  private String userName;
  private String userPw;
  private String userRealname;
  private String userSex;
  private String userAddress;
  private String userTel;
  private String message;
  private String path;
  private TUserDAO userDAO;

  public String userReg()
  {
    TUser user = new TUser();

    user.setUserName(this.userName);
    user.setUserPw(this.userPw);

    user.setUserRealname(this.userRealname);
    user.setUserSex(this.userSex);
    user.setUserAddress(this.userAddress);
    user.setUserTel(this.userTel);

    user.setUserDel("no");

    this.userDAO.save(user);

    HttpServletRequest request = ServletActionContext.getRequest();
    request.setAttribute("msg", "注册成功,请登录");
    return "msg";
  }

  public String userEdit() {
    TUser user = this.userDAO.findById(this.userId);

    user.setUserName(this.userName);
    user.setUserPw(this.userPw);

    user.setUserRealname(this.userRealname);
    user.setUserSex(this.userSex);
    user.setUserAddress(this.userAddress);
    user.setUserTel(this.userTel);

    user.setUserDel("no");

    this.userDAO.attachDirty(user);

    HttpServletRequest request = ServletActionContext.getRequest();
    request.setAttribute("msg", "修改成功,重新登录后生效");
    return "msg";
  }

  public String userLogin()
  {
    String sql = "from TUser where userName=? and userPw=?";
    Object[] con = { this.userName, this.userPw };
    List userList = this.userDAO.getHibernateTemplate().find(sql, con);
    if (userList.size() == 0)
    {
      setMessage("用户名或密码错误");
      setPath("qiantai/default.jsp");
    }
    else
    {
      Map session = ServletActionContext.getContext().getSession();
      TUser user = (TUser)userList.get(0);
      session.put("user", user);

      setMessage("成功登录");
      setPath("qiantai/default.jsp");
    }
    return "succeed";
  }

  public String userLogout()
  {
    Map session = ServletActionContext.getContext().getSession();
    session.remove("user");
    return "success";
  }

  public String userDel()
  {
    TUser user = this.userDAO.findById(this.userId);
    user.setUserDel("yes");
    this.userDAO.attachDirty(user);
    setMessage("删除成功");
    setPath("userMana.action");
    return "succeed";
  }

  public String userXinxi()
  {
    TUser user = this.userDAO.findById(this.userId);
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("user", user);
    return "success";
  }

  public String userMana()
  {
    List userList = this.userDAO.findAll();
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("userList", userList);
    return "success";
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getPath() {
    return this.path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getUserAddress() {
    return this.userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }

  public TUserDAO getUserDAO() {
    return this.userDAO;
  }

  public void setUserDAO(TUserDAO userDAO) {
    this.userDAO = userDAO;
  }

  public Integer getUserId() {
    return this.userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPw() {
    return this.userPw;
  }

  public void setUserPw(String userPw) {
    this.userPw = userPw;
  }

  public String getUserRealname() {
    return this.userRealname;
  }

  public void setUserRealname(String userRealname) {
    this.userRealname = userRealname;
  }

  public String getUserSex() {
    return this.userSex;
  }

  public void setUserSex(String userSex) {
    this.userSex = userSex;
  }

  public String getUserTel() {
    return this.userTel;
  }

  public void setUserTel(String userTel) {
    this.userTel = userTel;
  }
}