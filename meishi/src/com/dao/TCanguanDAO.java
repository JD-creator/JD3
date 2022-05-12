package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TCanguan;

/**
 * Data access object (DAO) for domain model class TCanguan.
 * 
 * @see com.model.TCanguan
 * @author MyEclipse Persistence Tools
 */

public class TCanguanDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TCanguanDAO.class);

	// property constants
	public static final String CANGUAN_NAME = "canguanName";

	public static final String CANGUAN_ADD = "canguanAdd";

	public static final String CANGUAN_TEL = "canguanTel";

	public static final String CANGUAN_BEIZHU = "canguanBeizhu";

	public static final String CANGUAN_DEL = "canguanDel";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TCanguan transientInstance)
	{
		log.debug("saving TCanguan instance");
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

	public void delete(TCanguan persistentInstance)
	{
		log.debug("deleting TCanguan instance");
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

	public TCanguan findById(java.lang.Integer id)
	{
		log.debug("getting TCanguan instance with id: " + id);
		try
		{
			TCanguan instance = (TCanguan) getHibernateTemplate().get(
					"com.model.TCanguan", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TCanguan instance)
	{
		log.debug("finding TCanguan instance by example");
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
		log.debug("finding TCanguan instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TCanguan as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCanguanName(Object canguanName)
	{
		return findByProperty(CANGUAN_NAME, canguanName);
	}

	public List findByCanguanAdd(Object canguanAdd)
	{
		return findByProperty(CANGUAN_ADD, canguanAdd);
	}

	public List findByCanguanTel(Object canguanTel)
	{
		return findByProperty(CANGUAN_TEL, canguanTel);
	}

	public List findByCanguanBeizhu(Object canguanBeizhu)
	{
		return findByProperty(CANGUAN_BEIZHU, canguanBeizhu);
	}

	public List findByCanguanDel(Object canguanDel)
	{
		return findByProperty(CANGUAN_DEL, canguanDel);
	}

	public List findAll()
	{
		log.debug("finding all TCanguan instances");
		try
		{
			String queryString = "from TCanguan";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TCanguan merge(TCanguan detachedInstance)
	{
		log.debug("merging TCanguan instance");
		try
		{
			TCanguan result = (TCanguan) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TCanguan instance)
	{
		log.debug("attaching dirty TCanguan instance");
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

	public void attachClean(TCanguan instance)
	{
		log.debug("attaching clean TCanguan instance");
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

	public static TCanguanDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TCanguanDAO) ctx.getBean("TCanguanDAO");
	}
}