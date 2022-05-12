package com.action;

import com.dao.TGoodsDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class indexAction extends ActionSupport
{
  private TGoodsDAO goodsDAO;

  public String index()
  {
    String sql = "from TGoods where goodsDel='no'";
    List goodsList = this.goodsDAO.getHibernateTemplate().find(sql);
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("goodsList", goodsList);

    return "success";
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