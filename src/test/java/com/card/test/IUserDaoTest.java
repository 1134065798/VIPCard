package com.card.test;

import com.card.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:Mybatis/mybatis-config.xml"})
public class IUserDaoTest {
    @Test
    public void testUser (){
        ApplicationContext context=new ClassPathXmlApplicationContext("Spring/springbean.xml");

        IUserService userService=context.getBean(IUserService.class);
        List list=userService.loadAll();
        for(Object o:list){
            System.out.println(o);
        }
    }
}
