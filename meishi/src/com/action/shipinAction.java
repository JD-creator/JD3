package com.action;

import com.dao.TShipinDAO;
import com.model.TShipin;
import com.opensymphony.xwork2.ActionContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class shipinAction
{
  private int shipinId;
  private String shipinName;
  private String shipinJianjie;
  private String fujian;
  private String fujianYuanshiming;
  private String message;
  private String path;
  private TShipinDAO shipinDAO;

  public String shipinAdd()
  {
    TShipin shipin = new TShipin();

    shipin.setShipinName(this.shipinName);
    shipin.setFujian(this.fujian);
    shipin.setShipinJianjie(this.shipinJianjie);
    shipin.setFujianYuanshiming(this.fujianYuanshiming);
    shipin.setShijian(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));

    this.shipinDAO.save(shipin);
    setMessage("操作成功");
    setPath("shipinMana.action");
    return "succeed";
  }

  public String shipinMana()
  {
    String sql = "from TShipin";
    List shipinList = this.shipinDAO.getHibernateTemplate().find(sql);
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("shipinList", shipinList);
    return "success";
  }

  public String shipinDel()
  {
    TShipin shipin = this.shipinDAO.findById(Integer.valueOf(this.shipinId));
    this.shipinDAO.delete(shipin);

    setMessage("操作成功");
    setPath("shipinMana.action");
    return "succeed";
  }

  public String shipinDetail()
  {
    TShipin shipin = this.shipinDAO.findById(Integer.valueOf(this.shipinId));
    this.shipinDAO.attachDirty(shipin);

    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("shipin", shipin);

    return "success";
  }

  public String shipinAll()
  {
    String sql = "from TShipin";
    List shipinList = this.shipinDAO.getHibernateTemplate().find(sql);
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("shipinList", shipinList);
    return "success";
  }

  public String shipinDetailQian()
  {
    TShipin shipin = this.shipinDAO.findById(Integer.valueOf(this.shipinId));
    this.shipinDAO.attachDirty(shipin);

    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("shipin", shipin);

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

  public void setFujianYuanshiming(String fujianYuanshiming)
  {
    this.fujianYuanshiming = fujianYuanshiming;
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

  public TShipinDAO getShipinDAO()
  {
    return this.shipinDAO;
  }

  public void setShipinDAO(TShipinDAO shipinDAO)
  {
    this.shipinDAO = shipinDAO;
  }

  public int getShipinId()
  {
    return this.shipinId;
  }

  public void setShipinId(int shipinId)
  {
    this.shipinId = shipinId;
  }

  public String getShipinJianjie()
  {
    return this.shipinJianjie;
  }

  public void setShipinJianjie(String shipinJianjie)
  {
    this.shipinJianjie = shipinJianjie;
  }

  public String getShipinName()
  {
    return this.shipinName;
  }

  public void setShipinName(String shipinName)
  {
    this.shipinName = shipinName;
  }
}