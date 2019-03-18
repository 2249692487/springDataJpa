package com.test.api;

import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 描述： Persistence对象: 该对象是一个加载配置文件的工具类,并返回EntityManagerFactory对象
 * </p>
 *
 * @author QinLiNa
 * @data 2019/3/18
 */
public class PersistenceDemo {
    @Test
    public void fun1(){
        //加载配置文件的工具类,并返回EntityManagerFactory对象
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
    }
}
