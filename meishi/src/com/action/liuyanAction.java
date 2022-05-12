package com.action;

import com.dao.TLiuyanDAO;
import com.model.TLiuyan;
import com.model.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;

public class liuyanAction extends ActionSupport
{
  private int liuyanId;
  private String liuyanTitle;
  private String liuyanContent;
  private TLiuyanDAO liuyanDAO;
  private String message;
  private String path;

  public String liuyanMana()
  {
    List liuyanList = this.liuyanDAO.findAll();
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("liuyanList", liuyanList);
    return "success";
  }

  public String liuyanAdd()
  {
    TLiuyan liuyan = new TLiuyan();
    liuyan.setLiuyanContent(this.liuyanContent);
    liuyan.setLiuyanTitle(this.liuyanTitle);
    liuyan.setLiuyanDate(new Date().toLocaleString());
    Map session = ActionContext.getContext().getSession();

    if (session.get("user") != null)
    {
      TUser user = (TUser)session.get("user");
      liuyan.setLiuyanUser(user.getUserName());
    }

    this.liuyanDAO.save(liuyan);
    setMessage("留言成功");
    setPath("liuyanAll.action");
    return "succeed";
  }

  public String liuyanDel()
  {
    TLiuyan liuyan = this.liuyanDAO.findById(Integer.valueOf(this.liuyanId));
    this.liuyanDAO.delete(liuyan);
    setMessage("留言删除成功");
    setPath("liuyanMana.action");
    return "succeed";
  }

  public String liuyanAll()
  {
    List liuyanList = this.liuyanDAO.findAll();
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("liuyanList", liuyanList);
    return "success";
  }

  public String getLiuyanContent()
  {
    return this.liuyanContent;
  }

  public void setLiuyanContent(String liuyanContent)
  {
    this.liuyanContent = liuyanContent;
  }

  public TLiuyanDAO getLiuyanDAO()
  {
    return this.liuyanDAO;
  }

  public void setLiuyanDAO(TLiuyanDAO liuyanDAO)
  {
    this.liuyanDAO = liuyanDAO;
  }

  public int getLiuyanId()
  {
    return this.liuyanId;
  }

  public void setLiuyanId(int liuyanId)
  {
    this.liuyanId = liuyanId;
  }

  public String getMessage()
  {
    return this.message;
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

  public String getLiuyanTitle()
  {
    return this.liuyanTitle;
  }

  public void setLiuyanTitle(String liuyanTitle)
  {
    this.liuyanTitle = liuyanTitle;
  }
}