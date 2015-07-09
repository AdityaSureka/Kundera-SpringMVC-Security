package com.easytest.easytst.login.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.easytest.easytst.login.model.User;
import com.impetus.client.cassandra.common.CassandraConstants;

@Service
public class UserDaoImpl implements UserDao {
	private EntityManagerFactory entityManagerFactory;

	@Override
	public User findByUserName(String username) {
        Map propertyMap = new HashMap();
        propertyMap.put(CassandraConstants.CQL_VERSION, CassandraConstants.CQL_VERSION_3_0);

        entityManagerFactory = Persistence.createEntityManagerFactory("cassandra", propertyMap);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query q = entityManager.createQuery("select u from User u where u.username =:username",User.class);//where u.username = admin");
        q.setParameter("username", username);
	entityManager.close();
        if (users == null || users.isEmpty())
        {
        	System.out.println("We are fucked");
            return null;
        }
        else
        {
             return users.get(0);
        }
	}   
	
	public void close()
    {       
        if(entityManagerFactory != null) {
        	entityManagerFactory.close();
        }
    }
	
    public EntityManagerFactory getEntityManagerFactory()
    {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory)
    {
        this.entityManagerFactory = entityManagerFactory;
    }

}
