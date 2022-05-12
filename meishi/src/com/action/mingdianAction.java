package com.action;

import com.model.TMingdian;
import com.model.TMingdianDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class mingdianAction extends ActionSupport
{
  private int id;
  private String name;
  private String address;
  private String tel;
  private String beizhu;
  private String message;
  private String path;
  private TMingdianDAO mingdianDAO;

  public String mingdianAddMy()
  {
    TMingdian mingdian = new TMingdian();
    mingdian.setName(this.name);
    mingdian.setAddress(this.address);
    mingdian.setTel(this.tel);
    mingdian.setBeizhu(this.beizhu);
    mingdian.setZhuantai("noshenhe");
    mingdian.setDel("no");
    this.mingdianDAO.save(mingdian);

    return "success";
  }

  public String mingdianDel()
  {
    TMingdian mingdian = this.mingdianDAO.findById(Integer.valueOf(this.id));
    mingdian.setDel("yes");
    this.mingdianDAO.attachDirty(mingdian);

    setMessage("操作成功");
    setPath("mingdianMana.action");
    return "succeed";
  }

  public String mingdianMana()
  {
    String sql = "from TMingdian where del='no' order by zhuantai";
    List mingdianList = this.mingdianDAO.getHibernateTemplate().find(sql);
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("mingdianList", mingdianList);
    return "success";
  }

  public String mingdianAll()
  {
    String sql = "from TMingdian where del='no' and zhuantai='yishenhe'";
    List mingdianList = this.mingdianDAO.getHibernateTemplate().find(sql);
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("mingdianList", mingdianList);
    return "success";
  }

  public String mingdianShenhe()
  {
    TMingdian mingdian = this.mingdianDAO.findById(Integer.valueOf(this.id));
    mingdian.setZhuantai("yishenhe");
    this.mingdianDAO.attachDirty(mingdian);

    setMessage("操作成功");
    setPath("mingdianMana.action");
    return "succeed";
  }

  public String getAddress()
  {
    return this.address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getBeizhu()
  {
    return this.beizhu;
  }

  public void setBeizhu(String beizhu)
  {
    this.beizhu = beizhu;
  }

  public int getId()
  {
    return this.id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getMessage()
  {
    return this.message;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }

  public TMingdianDAO getMingdianDAO()
  {
    return this.mingdianDAO;
  }

  public void setMingdianDAO(TMingdianDAO mingdianDAO)
  {
    this.mingdianDAO = mingdianDAO;
  }

  public String getPath()
  {
    return this.path;
  }

  public void setPath(String path)
  {
    this.path = path;
  }

  public String getTel()
  {
    return this.tel;
  }

  public void setTel(String tel)
  {
    this.tel = tel;
  }
}