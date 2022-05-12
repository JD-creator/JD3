package com.action;

import com.dao.TCanguanDAO;
import com.model.TCanguan;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class canguanAction extends ActionSupport
{
  private int canguanId;
  private String canguanName;
  private String canguanAdd;
  private String canguanTel;
  private String canguanBeizhu;
  private String message;
  private String path;
  private TCanguanDAO canguanDAO;

  public String canguanAdd()
  {
    TCanguan canguan = new TCanguan();
    canguan.setCanguanName(this.canguanName);
    canguan.setCanguanAdd(this.canguanAdd);
    canguan.setCanguanTel(this.canguanTel);
    canguan.setCanguanBeizhu(this.canguanBeizhu);
    canguan.setCanguanDel("no");
    this.canguanDAO.save(canguan);
    setMessage("操作成功");
    setPath("canguanMana.action");
    return "succeed";
  }

  public String canguanDel()
  {
    this.canguanDAO.delete(this.canguanDAO.findById(Integer.valueOf(this.canguanId)));
    setMessage("操作成功");
    setPath("canguanMana.action");
    return "succeed";
  }

  public String canguanMana()
  {
    String sql = "from TCanguan where canguanDel='no'";
    List canguanList = this.canguanDAO.getHibernateTemplate().find(sql);
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("canguanList", canguanList);
    return "success";
  }

  public String canguanAll()
  {
    String sql = "from TCanguan where canguanDel='no'";
    List canguanList = this.canguanDAO.getHibernateTemplate().find(sql);
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("canguanList", canguanList);
    return "success";
  }

  public String getCanguanAdd()
  {
    return this.canguanAdd;
  }

  public void setCanguanAdd(String canguanAdd)
  {
    this.canguanAdd = canguanAdd;
  }

  public String getCanguanBeizhu()
  {
    return this.canguanBeizhu;
  }

  public void setCanguanBeizhu(String canguanBeizhu)
  {
    this.canguanBeizhu = canguanBeizhu;
  }

  public TCanguanDAO getCanguanDAO()
  {
    return this.canguanDAO;
  }

  public void setCanguanDAO(TCanguanDAO canguanDAO)
  {
    this.canguanDAO = canguanDAO;
  }

  public int getCanguanId()
  {
    return this.canguanId;
  }

  public void setCanguanId(int canguanId)
  {
    this.canguanId = canguanId;
  }

  public String getCanguanName()
  {
    return this.canguanName;
  }

  public void setCanguanName(String canguanName)
  {
    this.canguanName = canguanName;
  }

  public String getCanguanTel()
  {
    return this.canguanTel;
  }

  public void setCanguanTel(String canguanTel)
  {
    this.canguanTel = canguanTel;
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
}