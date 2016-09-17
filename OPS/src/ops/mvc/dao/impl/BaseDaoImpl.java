package ops.mvc.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import ops.mvc.dao.BaseDaoI;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository注解指定此类是一个容器类，是DA层类的实现。
@Repository
public class BaseDaoImpl<T> implements BaseDaoI<T> {
	//@Autowired注解告诉spring，这个字段是需要自动注入的
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 获得当前事物的session
	 * @return org.hibernate.Session
	 */
	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	//当前的方法定义将覆盖超类中的方法。
	//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public Serializable save(T o) {
		if (o != null) {
			return this.getCurrentSession().save(o);
		}
		return null;
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public T get(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public T get(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		List<T> l = (List<T>)q.list();
		if ((l != null) && (l.size() > 0)) {
			return l.get(0);
		}
		return null;
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public T get(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		List<?> l = (List<?>)q.list();
		if ((l != null) && (l.size() > 0)) {
			return (T)l.get(0);
		}
		return null;
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public void delete(T o) {
		if (o != null) {
			this.getCurrentSession().delete(o);
		}
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public void update(T o) {
		if (o != null) {
			this.getCurrentSession().update(o);
		}
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public void saveOrUpdate(T o) {
		if (o != null) {
			this.getCurrentSession().saveOrUpdate(o);
		}
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public List<T> find(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return (List<T>)q.list();
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public List<T> find(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (List<T>)q.list();
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
		Query q = this.getCurrentSession().createQuery(hql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (List<T>)q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public List<T> find(String hql, int page, int rows) {
		Query q = this.getCurrentSession().createQuery(hql);
		return (List<T>)q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public Long count(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return (Long) q.uniqueResult();
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public Long count(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (Long) q.uniqueResult();
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public int executeHql(String hql) {
		Query q = this.getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		Query q = this.getCurrentSession().createQuery(hql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public List<Object[]> findBySql(String sql) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		return (List<Object[]>)q.list();		
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public List<Object[]> findBySql(String sql, int page, int rows) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		return (List<Object[]>)q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public List<Object[]> findBySql(String sql, Map<String, Object> params) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (List<Object[]>)q.list();
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public List<Object[]> findBySql(String sql, Map<String, Object> params, int page, int rows) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (List<Object[]>)q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public int executeSql(String sql) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		return q.executeUpdate();
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public int executeSql(String sql, Map<String, Object> params) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public BigInteger countBySql(String sql) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		return (BigInteger) q.uniqueResult();
	}

	//当前的方法定义将覆盖超类中的方法。
		//如果你不小心拼写错误，或者方法签名对不上被覆盖的方法，编译器就会发出错误提示。
	@Override
	public BigInteger countBySql(String sql, Map<String, Object> params) {
		SQLQuery q = this.getCurrentSession().createSQLQuery(sql);
		if ((params != null) && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (BigInteger) q.uniqueResult();
	}

}
