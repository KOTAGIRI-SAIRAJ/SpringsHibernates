package com.sb.dao;

import com.sb.model.AccessCard;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccessCardDAOImpl implements AccessCardDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addAccessCard(AccessCard accessCard) {
        sessionFactory.getCurrentSession().saveOrUpdate(accessCard);
    }

    @Override
    public List<AccessCard> getAllAccessCards() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AccessCard.class);
        criteria.setMaxResults(1)
                .add( Restrictions.like("name", "s%"))
                .addOrder( Order.desc("name") );
        return criteria.list();
    }

    @Override
    public void deleteAccessCard(Integer accessCardId) {
        AccessCard accessCard= (AccessCard) sessionFactory.getCurrentSession().load(
                AccessCard.class, accessCardId);
        if (null != accessCard) {
            this.sessionFactory.getCurrentSession().delete(accessCard);
        }
    }

    @Override
    public AccessCard updateAccessCard(AccessCard accessCard) {
        sessionFactory.getCurrentSession().update(accessCard);
        return accessCard;
    }

    @Override
    public AccessCard getAccessCard(int accesscardId) {
        return (AccessCard) sessionFactory.getCurrentSession().get(
                AccessCard.class, accesscardId);
    }
}

