package com.model;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * Data access object (DAO) for domain model class TMingdian.
 * 
 * @see com.model.TMingdian
 * @author MyEclipse Persistence Tools
 */

public class TMingdianDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TMingdianDAO.class);

	// property constants
	public static final String NAME = "name";

	public static final String ADDRESS = "address";

	public static final String TEL = "tel";

	public static final String BEIZHU = "beizhu";

	public static final String ZHUANTAI = "zhuantai";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TMingdian transientInstance)
	{
		log.debug("saving TMingdian instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TMingdian persistentInstance)
	{
		log.debug("deleting TMingdian instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TMingdian findById(java.lang.Integer id)
	{
		log.debug("getting TMingdian instance with id: " + id);
		try
		{
			TMingdian instance = (TMingdian) getHibernateTemplate().get(
					"com.model.TMingdian", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TMingdian instance)
	{
		log.debug("finding TMingdian instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TMingdian instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TMingdian as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name)
	{
		return findByProperty(NAME, name);
	}

	public List findByAddress(Object address)
	{
		return findByProperty(ADDRESS, address);
	}

	public List findByTel(Object tel)
	{
		return findByProperty(TEL, tel);
	}

	public List findByBeizhu(Object beizhu)
	{
		return findByProperty(BEIZHU, beizhu);
	}

	public List findByZhuantai(Object zhuantai)
	{
		return findByProperty(ZHUANTAI, zhuantai);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all TMingdian instances");
		try
		{
			String queryString = "from TMingdian";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TMingdian merge(TMingdian detachedInstance)
	{
		log.debug("merging TMingdian instance");
		try
		{
			TMingdian result = (TMingdian) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TMingdian instance)
	{
		log.debug("attaching dirty TMingdian instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TMingdian instance)
	{
		log.debug("attaching clean TMingdian instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TMingdianDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TMingdianDAO) ctx.getBean("TMingdianDAO");
	}
}