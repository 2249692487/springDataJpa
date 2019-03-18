package com.test.api;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/3/18
 */

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * EntityManagerFactory对象: 用于创建EntityManager的工厂对象
 * 注意事项: 1.该对象内存消耗较大
 * 2.该对象线程安全
 * 结论: 一个项目中确保只有一个EntityManagerFactory对象即可
 */
public class EntityManagerFactoryDemo {
    @Test
    public void fun1(){
        //加载配置文件的工具类,并返回EntityManagerFactory对象
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        //根据配置信息创建EntityManager
        EntityManager em = entityManagerFactory.createEntityManager();
    }
}
