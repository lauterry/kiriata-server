package fr.lau.kiriata.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
	private Class<T> type;

    protected HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
        hibernateTemplate = new HibernateTemplate(sessionFactory);
        hibernateTemplate.setAlwaysUseNewSession(false);
	}

	public GenericDaoImpl(Class<T> type) {
		this.type = type;
	}

	@Transactional(readOnly = false)
	public void saveOrUpdate(T user) {
		hibernateTemplate.saveOrUpdate(user);

	}

	@Transactional(readOnly = false)
	public void delete(T user) {
		hibernateTemplate.delete(user);

	}

	@SuppressWarnings("unchecked")
	public List<T> readAll() {
		return (List<T>) hibernateTemplate.find("from " + type.getName());
	}

    @Override
    public T load(PK id) {
        return hibernateTemplate.load(type, id);
    }

    @Override
    public void bulkUpdate(String query, Object[] params) {
        hibernateTemplate.bulkUpdate(query, params);
    }

    public T read(PK userId) {
		return hibernateTemplate.get(type, userId);
	}

}