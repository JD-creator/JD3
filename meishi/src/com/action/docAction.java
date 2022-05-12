package com.action;

import com.dao.TDocDAO;
import com.model.TDoc;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class docAction extends ActionSupport
{
  private int id;
  private String mingcheng;
  private String fujian;
  private String fujianYuanshiming;
  private String message;
  private String path;
  private TDocDAO docDAO;

  public String docAdd()
  {
    TDoc doc = new TDoc();
    doc.setMingcheng(this.mingcheng);
    doc.setFujian(this.fujian);
    doc.setFujianYuanshiming(this.fujianYuanshiming);
    doc.setDel("no");
    this.docDAO.save(doc);
    setMessage("操作成功");
    setPath("docMana.action");
    return "succeed";
  }

  public String docDel()
  {
    TDoc doc = this.docDAO.findById(Integer.valueOf(this.id));
    doc.setDel("yes");
    this.docDAO.attachDirty(doc);
    setMessage("删除成功");
    setPath("docMana.action");
    return "succeed";
  }

  public String docMana()
  {
    String sql = "from TDoc where del='no'";
    List docList = this.docDAO.getHibernateTemplate().find(sql);
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("docList", docList);
    return "success";
  }

  public String docAll()
  {
    String sql = "from TDoc where del='no'";
    List docList = this.docDAO.getHibernateTemplate().find(sql);
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("docList", docList);
    return "success";
  }

  public String getFujian()
  {
    return this.fujian;
  }

  public void setFujian(String fujian)
  {
    this.fujian = fujian;
  }

  public String getFujianYuanshiming()
  {
    return this.fujianYuanshiming;
  }

  public TDocDAO getDocDAO()
  {
    return this.docDAO;
  }

  public void setDocDAO(TDocDAO docDAO)
  {
    this.docDAO = docDAO;
  }

  public void setFujianYuanshiming(String fujianYuanshiming)
  {
    this.fujianYuanshiming = fujianYuanshiming;
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

  public String getMingcheng()
  {
    return this.mingcheng;
  }

  public void setMingcheng(String mingcheng)
  {
    this.mingcheng = mingcheng;
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