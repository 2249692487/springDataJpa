package com.test.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 描述：确保EntityManagerFactory只创建一次
 * </p>
 *
 * @author QinLiNa
 * @data 2019/3/18
 */
public class JpaUtils {
    private static EntityManagerFactory entityManagerFactory;
    static{
        //加载配置文件的工具类,并返回EntityManagerFactory对象
        entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
    }

    public static EntityManager createEntityManager(){

        //根据配置信息创建EntityManager
        EntityManager em = entityManagerFactory.createEntityManager();

        return  em;
    }

}
