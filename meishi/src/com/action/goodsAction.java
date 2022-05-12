package com.action;

import com.dao.TCatelogDAO;
import com.dao.TGoodsDAO;
import com.model.TGoods;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class goodsAction extends ActionSupport
{
  private int goodsId;
  private String goodsName;
  private String goodsMiaoshu;
  private String fujian;
  private int goodsJiage = 0;
  private int goodsCatelogId;
  private int goodsCanguanId;
  private int catelogId;
  private String message;
  private String path;
  private TGoodsDAO goodsDAO;
  private TCatelogDAO catelogDAO;

  public String goodsAdd()
  {
    TGoods goods = new TGoods();
    goods.setGoodsName(this.goodsName);
    goods.setGoodsMiaoshu(this.goodsMiaoshu);
    goods.setGoodsPic(this.fujian);
    goods.setGoodsJiage(Integer.valueOf(this.goodsJiage));
    goods.setGoodsCatelogId(Integer.valueOf(this.goodsCatelogId));
    goods.setGoodsCanguanId(Integer.valueOf(this.goodsCanguanId));
    goods.setGoodsDel("no");
    this.goodsDAO.save(goods);
    setMessage("操作成功");
    setPath("goodsMana.action");
    return "succeed";
  }

  public String goodsDel()
  {
    TGoods goods = this.goodsDAO.findById(Integer.valueOf(this.goodsId));
    goods.setGoodsDel("yes");
    this.goodsDAO.attachDirty(goods);
    setMessage("操作成功");
    setPath("goodsMana.action");
    return "succeed";
  }

  public String goodsMana()
  {
    String sql = "from TGoods where goodsDel='no'";
    List goodsList = this.goodsDAO.getHibernateTemplate().find(sql);
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("goodsList", goodsList);
    return "success";
  }

  public String goodsDetail()
  {
    Map request = (Map)ServletActionContext.getContext().get("request");

    TGoods goods = this.goodsDAO.findById(Integer.valueOf(this.goodsId));
    request.put("goods", goods);
    return "success";
  }

  public String goodsAll()
  {
    String sql = "from TGoods where goodsDel='no'";
    List goodsList = this.goodsDAO.getHibernateTemplate().find(sql);
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("goodsList", goodsList);
    return "success";
  }

  public String goodsByCatelog()
  {
    Map request = (Map)ServletActionContext.getContext().get("request");

    String sql = "from TGoods where goodsDel='no' and goodsCatelogId=?";
    Object[] con = { Integer.valueOf(this.catelogId) };
    List goodsList = this.goodsDAO.getHibernateTemplate().find(sql, con);
    request.put("goodsList", goodsList);

    return "success";
  }

  public String goodSearch()
  {
    Map request = (Map)ServletActionContext.getContext().get("request");
    String sql = "";
    sql = "from TGoods where goodsDel='no' and goodsName like '%" + this.goodsName + "%'";

    List goodsList = this.goodsDAO.getHibernateTemplate().find(sql);
    request.put("goodsList", goodsList);

    return "success";
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

  public String getFujian()
  {
    return this.fujian;
  }

  public void setFujian(String fujian)
  {
    this.fujian = fujian;
  }

  public int getGoodsCanguanId()
  {
    return this.goodsCanguanId;
  }

  public void setGoodsCanguanId(int goodsCanguanId)
  {
    this.goodsCanguanId = goodsCanguanId;
  }

  public int getGoodsCatelogId()
  {
    return this.goodsCatelogId;
  }

  public void setGoodsCatelogId(int goodsCatelogId)
  {
    this.goodsCatelogId = goodsCatelogId;
  }

  public TGoodsDAO getGoodsDAO()
  {
    return this.goodsDAO;
  }

  public void setGoodsDAO(TGoodsDAO goodsDAO)
  {
    this.goodsDAO = goodsDAO;
  }

  public int getGoodsId()
  {
    return this.goodsId;
  }

  public void setGoodsId(int goodsId)
  {
    this.goodsId = goodsId;
  }

  public int getGoodsJiage()
  {
    return this.goodsJiage;
  }

  public void setGoodsJiage(int goodsJiage)
  {
    this.goodsJiage = goodsJiage;
  }

  public String getGoodsMiaoshu()
  {
    return this.goodsMiaoshu;
  }

  public void setGoodsMiaoshu(String goodsMiaoshu)
  {
    this.goodsMiaoshu = goodsMiaoshu;
  }

  public String getGoodsName()
  {
    return this.goodsName;
  }

  public void setGoodsName(String goodsName)
  {
    this.goodsName = goodsName;
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