package com.sb.dao;

import com.sb.model.Meeting;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MeetingDAOImpl implements MeetingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addMeeting(Meeting meeting) {
        sessionFactory.getCurrentSession().saveOrUpdate(meeting);
    }

    @Override
    public List<Meeting> getAllMeeting() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Meeting.class);
        criteria.setMaxResults(1)
                .add( Restrictions.like("name", "s%"))
                .addOrder( Order.desc("name") );
        return criteria.list();
    }

    @Override
    public void deleteMeeting(Integer meetingId) {
        Meeting meeting= (Meeting) sessionFactory.getCurrentSession().load(
                Meeting.class, meetingId);
        if (null != meeting) {
            this.sessionFactory.getCurrentSession().delete(meeting);
        }
    }

    @Override
    public Meeting updateMeeting(Meeting meeting) {
        sessionFactory.getCurrentSession().update(meeting);
        return meeting;
    }

    @Override
    public Meeting getMeeting(int meetingId) {
        return (Meeting) sessionFactory.getCurrentSession().get(
                Meeting.class, meetingId);
    }
}
