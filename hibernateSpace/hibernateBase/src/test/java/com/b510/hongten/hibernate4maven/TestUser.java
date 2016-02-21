/**
 *
 */
package com.b510.hongten.hibernate4maven;

import java.util.List;
import java.util.Random;

import junit.framework.Assert;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.b510.hongten.hibernate4maven.util.HibernateUtil;

/**
 * @author Hongten
 * @created 2014年11月1日
 */
public class TestUser {

    @Test
    public void testSave() {
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        User user = new User();
        user.setAge(250);
        user.setName("Hongten");
        user.setGender("M");
        user.setEmail("hongtenzone@foxmail.com");

        session.save(user);

        Assert.assertEquals(true, user.getId() > 0);

        session.getTransaction().commit();
    }

    @Test
    public void testUpdate() {
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        Query query = session.createQuery("from User");
        List<User> list = query.list();
        for (User u : list) {
            u.setAge(20);
            session.update(u);
            System.out.println("Id : " + u.getId() + " Name : " + u.getName()
                    + "  Gender : " + u.getGender() + "  Age : " + u.getAge()
                    + " email : " + u.getEmail());
        }
        session.getTransaction().commit();
    }


    @Test
    public void testQuery(){
        Session session = HibernateUtil.getOpenSession();
        session.beginTransaction();
        Query query = session.createQuery("from User u where u.age = 20");
        List<User> list = query.list();
        System.out.println(list.size());
        for (User u : list) {
            System.out.println("Id : " + u.getId() + " Name : " + u.getName()
                    + "  Gender : " + u.getGender() + "  Age : " + u.getAge()
                    + " email : " + u.getEmail());
        }

        session.getTransaction().commit();
    }

}
