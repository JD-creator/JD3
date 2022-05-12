package com.action;

import com.dao.TGonggaoDAO;
import com.model.TGonggao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;

public class gonggaoAction extends ActionSupport
{
  private int gonggaoId;
  private String gonggaoTitle;
  private String gonggaoContent;
  private String gonggaoData;
  private String message;
  private String path;
  private TGonggaoDAO gonggaoDAO;

  public String gonggaoAdd()
  {
    TGonggao gonggao = new TGonggao();
    gonggao.setGonggaoTitle(this.gonggaoTitle);
    gonggao.setGonggaoContent(this.gonggaoContent);
    gonggao.setGonggaoData(new Date().toLocaleString());
    this.gonggaoDAO.save(gonggao);
    setMessage("公告添加完毕");
    setPath("gonggaoMana.action");
    return "succeed";
  }

  public String gonggaoMana()
  {
    List gonggaoList = this.gonggaoDAO.findAll();
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("gonggaoList", gonggaoList);
    return "success";
  }

  public String gonggaoDel()
  {
    TGonggao gonggao = this.gonggaoDAO.findById(Integer.valueOf(this.gonggaoId));
    this.gonggaoDAO.delete(gonggao);
    setMessage("公告删除完毕");
    setPath("gonggaoMana.action");
    return "succeed";
  }

  public String gonggaoDetail()
  {
    TGonggao gonggao = this.gonggaoDAO.findById(Integer.valueOf(this.gonggaoId));
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("gonggao", gonggao);
    return "success";
  }

  public String gonggaoDetailQian()
  {
    TGonggao gonggao = this.gonggaoDAO.findById(Integer.valueOf(this.gonggaoId));
    Map request = (Map)ServletActionContext.getContext().get("request");
    request.put("gonggao", gonggao);

    return "success";
  }

  public String gonggaoQian5()
  {
    Map request = (Map)ServletActionContext.getContext().get("request");

    List gonggaoList = this.gonggaoDAO.findAll();
    if (gonggaoList.size() > 5)
    {
      gonggaoList = gonggaoList.subList(0, 5);
    }
    request.put("gonggaoList", gonggaoList);
    return "success";
  }

  public String getGonggaoContent()
  {
    return this.gonggaoContent;
  }

  public void setGonggaoContent(String gonggaoContent)
  {
    this.gonggaoContent = gonggaoContent;
  }

  public TGonggaoDAO getGonggaoDAO()
  {
    return this.gonggaoDAO;
  }

  public void setGonggaoDAO(TGonggaoDAO gonggaoDAO)
  {
    this.gonggaoDAO = gonggaoDAO;
  }

  public String getGonggaoData()
  {
    return this.gonggaoData;
  }

  public void setGonggaoData(String gonggaoData)
  {
    this.gonggaoData = gonggaoData;
  }

  public int getGonggaoId()
  {
    return this.gonggaoId;
  }

  public void setGonggaoId(int gonggaoId)
  {
    this.gonggaoId = gonggaoId;
  }

  public String getGonggaoTitle()
  {
    return this.gonggaoTitle;
  }

  public void setGonggaoTitle(String gonggaoTitle)
  {
    this.gonggaoTitle = gonggaoTitle;
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