package com.action;

import com.dao.TCatelogDAO;
import com.dao.TGoodsDAO;
import com.model.TCatelog;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class catelogAction extends ActionSupport
{
  private int catelogId;
  private String catelogName;
  private String message;
  private String path;
  private TCatelogDAO catelogDAO;
  private TGoodsDAO goodsDAO;

  public String catelogMana()
  {
    String sql = "from TCatelog where catelogDel='no'";
    List cateLogList = this.catelogDAO.getHibernateTemplate().find(sql);
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("cateLogList", cateLogList);
    return "success";
  }

  public String catelogAll()
  {
    String sql = "from TCatelog where catelogDel='no'";
    List cateLogList = this.catelogDAO.getHibernateTemplate().find(sql);
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("cateLogList", cateLogList);
    return "success";
  }

  public String catelogAdd()
  {
    TCatelog catelog = new TCatelog();
    catelog.setCatelogName(this.catelogName);
    catelog.setCatelogDel("no");
    this.catelogDAO.save(catelog);
    setMessage("操作成功");
    setPath("catelogMana.action");
    return "succeed";
  }

  public String catelogDel()
  {
    String sql = "from TGoods where goodsDel='no' and goodsCatelogId=" + this.catelogId;
    List goodsList = this.goodsDAO.getHibernateTemplate().find(sql);
    if (goodsList.size() > 0)
    {
      setMessage("请先删除此类别下的商品");
      setPath("catelogMana.action");
    }
    else
    {
      TCatelog catelog = this.catelogDAO.findById(Integer.valueOf(this.catelogId));
      catelog.setCatelogDel("yes");
      this.catelogDAO.attachDirty(catelog);
      setMessage("操作成功");
      setPath("catelogMana.action");
    }
    return "succeed";
  }

  public TCatelogDAO getCatelogDAO()
  {
    return this.catelogDAO;
  }

  public void setCatelogDAO(TCatelogDAO catelogDAO)
  {
    this.catelogDAO = catelogDAO;
  }

  public int getCatelogId()
  {
    return this.catelogId;
  }

  public void setCatelogId(int catelogId)
  {
    this.catelogId = catelogId;
  }

  public String getCatelogName()
  {
    return this.catelogName;
  }

  public void setCatelogName(String catelogName)
  {
    this.catelogName = catelogName;
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

  public TGoodsDAO getGoodsDAO()
  {
    return this.goodsDAO;
  }

  public void setGoodsDAO(TGoodsDAO goodsDAO)
  {
    this.goodsDAO = goodsDAO;
  }
}