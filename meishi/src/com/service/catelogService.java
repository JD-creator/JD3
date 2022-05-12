package com.service;

import java.util.List;

import com.dao.TCanguanDAO;
import com.dao.TCatelogDAO;

public class catelogService
{
    private TCatelogDAO catelogDAO;
    private TCanguanDAO canguanDAO;
    
    public List findAllCatelog()
    {
    	
    	
    	String sql="from TCatelog where catelogDel='no'";
		List cateLogList=catelogDAO.getHibernateTemplate().find(sql);
		return cateLogList;
    }
    
    public List findAllCanguan()
    {
    	
    	
		String sql="from TCanguan where canguanDel='no'";
		List canguanList=canguanDAO.getHibernateTemplate().find(sql);
		return canguanList;
    }

	public TCatelogDAO getCatelogDAO()
	{
		return catelogDAO;
	}

	public void setCatelogDAO(TCatelogDAO catelogDAO)
	{
		this.catelogDAO = catelogDAO;
	}

	public TCanguanDAO getCanguanDAO()
	{
		return canguanDAO;
	}

	public void setCanguanDAO(TCanguanDAO canguanDAO)
	{
		this.canguanDAO = canguanDAO;
	}
    
}
