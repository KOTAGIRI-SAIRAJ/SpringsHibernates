package com.sb.dao;

import com.sb.model.Task;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskDAOImpl implements TaskDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addTask(Task task) {
        sessionFactory.getCurrentSession().saveOrUpdate(task);
    }

    @Override
    public List<Task> getAllTasks() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Task.class);
        criteria.setMaxResults(1)
                .add( Restrictions.like("name", "s%"))
                .addOrder( Order.desc("name") );
        return criteria.list();
    }

    @Override
    public void deleteTask(Integer taskId) {
        Task task= (Task) sessionFactory.getCurrentSession().load(
                Task.class, taskId);
        if (null != task) {
            this.sessionFactory.getCurrentSession().delete(task );
        }
    }

    @Override
    public Task updateTask(Task task) {
        sessionFactory.getCurrentSession().update(task);
        return task;
    }

    @Override
    public Task getTask(int taskId) {
        return (Task) sessionFactory.getCurrentSession().get(
                Task.class, taskId);
    }
}
