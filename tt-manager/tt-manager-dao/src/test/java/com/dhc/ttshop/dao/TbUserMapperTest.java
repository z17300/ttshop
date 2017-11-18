package com.dhc.ttshop.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)//让spring和juint连接必须的包
@ContextConfiguration({"classpath:spring/spring-dao-test.xml"})//扫描当前包生成对象 相当于been
public class TbUserMapperTest {
    @Autowired
    private TbUserMapper userDao;
    @Test
    public void selectByPrimaryKey() throws Exception {
        Object u=userDao.selectByPrimaryKey(5L);
        System.out.print(u);
    }

}