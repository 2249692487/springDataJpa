package com.test.api;

import com.test.pojo.Customer;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 描述： EntityManager对象:  该对象是JPA中操作的核心对象. 一切增删改查操作都是通过该对象完成的. 以及获得事务操作对象
 * </p>
 *
 * @author QinLiNa
 * @data 2019/3/18
 */
public class EntityManagerDemo {
    @Test
    public void fun1() {
        //加载配置文件的工具类,并返回EntityManagerFactory对象
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        //根据配置信息创建EntityManager
        EntityManager em = entityManagerFactory.createEntityManager();
        //获得事务操作对象
        EntityTransaction tx = em.getTransaction();

        tx.begin(); //开启事务
        tx.commit(); //提交事务
        tx.rollback(); //回滚事务
    }

    @Test
    //查询演示 => 根据id查询
    //立即加载 => find方法执行立即查询数据库
    public void fun2() {
        //加载配置文件的工具类,并返回EntityManagerFactory对象
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        //根据配置信息创建EntityManager
        EntityManager em = entityManagerFactory.createEntityManager();
        //获得事务操作对象
        EntityTransaction tx = em.getTransaction();
        tx.begin(); //开启事务
        //-------------------------------------------------------------------------------------------------------------
        Customer customer = em.find(Customer.class, 1L);
        System.out.println("============================================================================");
        System.out.println(customer);
        //-------------------------------------------------------------------------------------------------------------
        tx.commit(); //提交事务
        em.close();//关闭资源(连接)
    }

    @Test
    //查询演示 => 根据id查询
    //延迟加载 => getReference方法执行时不会立即查询数据库.使用查询结果时才会查询
    public void fun3() {
        //加载配置文件的工具类,并返回EntityManagerFactory对象
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        //根据配置信息创建EntityManager
        EntityManager em = entityManagerFactory.createEntityManager();
        //获得事务操作对象
        EntityTransaction tx = em.getTransaction();
        tx.begin(); //开启事务
        //-------------------------------------------------------------------------------------------------------------
        Customer customer = em.getReference(Customer.class, 1L);
        System.out.println("============================================================================");
        System.out.println(customer);
        //-------------------------------------------------------------------------------------------------------------
        tx.commit(); //提交事务
        em.close();//关闭资源(连接)
    }

    @Test
    //修改演示 => 先查后改
    public void fun4() {
        //加载配置文件的工具类,并返回EntityManagerFactory对象
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        //根据配置信息创建EntityManager
        EntityManager em = entityManagerFactory.createEntityManager();
        //获得事务操作对象
        EntityTransaction tx = em.getTransaction();
        tx.begin(); //开启事务
        //-------------------------------------------------------------------------------------------------------------
        Customer customer = em.find(Customer.class, 1L);

        customer.setCustName("黑马程序员");

        em.merge(customer);
        //-------------------------------------------------------------------------------------------------------------
        tx.commit(); //提交事务
        em.close();//关闭资源(连接)
    }

    @Test
    //删除演示 => 先查后删
    public void fun5() {
        //加载配置文件的工具类,并返回EntityManagerFactory对象
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        //根据配置信息创建EntityManager
        EntityManager em = entityManagerFactory.createEntityManager();
        //获得事务操作对象
        EntityTransaction tx = em.getTransaction();
        tx.begin(); //开启事务
        //-------------------------------------------------------------------------------------------------------------
        Customer customer = em.find(Customer.class, 1L);

        em.remove(customer);
        //-------------------------------------------------------------------------------------------------------------
        tx.commit(); //提交事务
        em.close();//关闭资源(连接)
    }
}
