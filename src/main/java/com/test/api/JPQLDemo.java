package com.test.api;

import com.test.pojo.Customer;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/3/18
 * JPQL查询: 面向对象的查询语言
 */
public class JPQLDemo {
    @Test
    //查询所有客户
    public void fun1() {
        //加载配置文件的工具类,并返回EntityManagerFactory对象
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        //根据配置信息创建EntityManager
        EntityManager em = entityManagerFactory.createEntityManager();
        //获得事务操作对象
        EntityTransaction tx = em.getTransaction();
        tx.begin(); //开启事务
        //-------------------------------------------------------------------------------------------------------------
        // 书写jpql语句 => 查询所有客户
        String jpql = "  from Customer  ";
        // 将jpql语句封装为查询对象
        Query query = em.createQuery(jpql);
        // 查询并返回结果
        List<Customer> list = query.getResultList();

        System.out.println(list);
        //-------------------------------------------------------------------------------------------------------------
        tx.commit(); //提交事务
        em.close();//关闭资源(连接)
    }

    @Test
    //条件查询客户 => 模糊查询,查询客户名称中包含"健"
    public void fun2() {
        //加载配置文件的工具类,并返回EntityManagerFactory对象
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        //根据配置信息创建EntityManager
        EntityManager em = entityManagerFactory.createEntityManager();
        //获得事务操作对象
        EntityTransaction tx = em.getTransaction();
        tx.begin(); //开启事务
        //-------------------------------------------------------------------------------------------------------------
        // 书写jpql语句 => 查询所有客户
        String jpql = "  from Customer where custName like ? ";
        // 将jpql语句封装为查询对象
        Query query = em.createQuery(jpql);
        // 指定占位符参数
        query.setParameter(1, "%健%");
        // 查询并返回结果
        List<Customer> list = query.getResultList();

        System.out.println(list);
        //-------------------------------------------------------------------------------------------------------------
        tx.commit(); //提交事务
        em.close();//关闭资源(连接)
    }

    @Test
    //条件查询客户 => 模糊查询,查询客户名称中包含"健" => 命名占位符
    public void fun3() {
        //加载配置文件的工具类,并返回EntityManagerFactory对象
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        //根据配置信息创建EntityManager
        EntityManager em = entityManagerFactory.createEntityManager();
        //获得事务操作对象
        EntityTransaction tx = em.getTransaction();
        tx.begin(); //开启事务
        //-------------------------------------------------------------------------------------------------------------
        // 书写jpql语句 => 查询所有客户
        String jpql = "  from Customer where custName like :abc ";
        // 将jpql语句封装为查询对象
        Query query = em.createQuery(jpql);
        // 指定占位符参数
        query.setParameter("abc", "%健%");
        // 查询并返回结果
        List<Customer> list = query.getResultList();

        System.out.println(list);
        //-------------------------------------------------------------------------------------------------------------
        tx.commit(); //提交事务
        em.close();//关闭资源(连接)
    }

    @Test
    //分页
    public void fun4() {
        //加载配置文件的工具类,并返回EntityManagerFactory对象
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        //根据配置信息创建EntityManager
        EntityManager em = entityManagerFactory.createEntityManager();
        //获得事务操作对象
        EntityTransaction tx = em.getTransaction();
        tx.begin(); //开启事务
        //-------------------------------------------------------------------------------------------------------------
        // 书写jpql语句 => 查询所有客户
        String jpql = "  from Customer  ";
        // 将jpql语句封装为查询对象
        Query query = em.createQuery(jpql);
        //limit ?,?
        query.setFirstResult(2); //相当于limit的第一个问号
        query.setMaxResults(2); //相当于limit的第二个问号
        // 查询并返回结果
        List<Customer> list = query.getResultList();

        System.out.println(list);
        //-------------------------------------------------------------------------------------------------------------
        tx.commit(); //提交事务
        em.close();//关闭资源(连接)
    }

    @Test
    //排序
    public void fun5() {
        //加载配置文件的工具类,并返回EntityManagerFactory对象
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        //根据配置信息创建EntityManager
        EntityManager em = entityManagerFactory.createEntityManager();
        //获得事务操作对象
        EntityTransaction tx = em.getTransaction();
        tx.begin(); //开启事务
        //-------------------------------------------------------------------------------------------------------------
        // 书写jpql语句 => 查询所有客户
        String jpql = "  from Customer order by custId desc  ";
        // 将jpql语句封装为查询对象
        Query query = em.createQuery(jpql);
        // 查询并返回结果
        List<Customer> list = query.getResultList();

        System.out.println(list);
        //-------------------------------------------------------------------------------------------------------------
        tx.commit(); //提交事务
        em.close();//关闭资源(连接)
    }

    @Test
    //聚合函数 => sum count max min avg
    public void fun6() {
        //加载配置文件的工具类,并返回EntityManagerFactory对象
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        //根据配置信息创建EntityManager
        EntityManager em = entityManagerFactory.createEntityManager();
        //获得事务操作对象
        EntityTransaction tx = em.getTransaction();
        tx.begin(); //开启事务
        //-------------------------------------------------------------------------------------------------------------
        // 书写jpql语句 => 查询所有客户
        //String jpql = " select sum(c.custId) from Customer c ";
        // String jpql = " select count(c) from Customer c ";
        String jpql = " select avg(c.custId) from Customer c ";
        // 将jpql语句封装为查询对象
        Query query = em.createQuery(jpql);
        // 查询并返回结果
        Number number = (Number) query.getSingleResult();

        System.out.println(number);
        //-------------------------------------------------------------------------------------------------------------
        tx.commit(); //提交事务
        em.close();//关闭资源(连接)
    }
}
