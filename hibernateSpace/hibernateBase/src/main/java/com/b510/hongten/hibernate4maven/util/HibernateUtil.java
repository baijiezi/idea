/**
 *
 */
package com.b510.hongten.hibernate4maven.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author Hongten
 * @created 2014年11月1日
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new AnnotationConfiguration().configure()
                .buildSessionFactory();
    }

    public static Session getOpenSession() {
        return sessionFactory.openSession();
    }

    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
