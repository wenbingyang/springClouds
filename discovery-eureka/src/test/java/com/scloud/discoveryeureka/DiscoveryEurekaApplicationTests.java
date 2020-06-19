package com.scloud.discoveryeureka;

import com.scloud.discoveryeureka.dao.RoutInfoMapper;
import com.scloud.discoveryeureka.dao.UserMapper;
import com.scloud.discoveryeureka.entity.RoutInfo;
import com.scloud.discoveryeureka.entity.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.RouteMatcher;

import java.util.List;

//两个*代表任意两个包 com.demo.aaa.mapper,也可以扫到com.demo.aaa.bbb.mapper
@SpringBootTest
@MapperScan("com.scloud.**.dao")
class DiscoveryEurekaApplicationTests {

    private static Logger logger = LoggerFactory.getLogger(DiscoveryEurekaApplicationTests.class);

    @Resource
    UserMapper userMapper;

    @Resource
    RoutInfoMapper routInfoMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void queryByPrimaryKey() {
        User userInfo = userMapper.selectByPrimaryKey("00d2d1ec5fa711ea8f809c5c8e0ec292");
        logger.info("查询结果为：{}", userInfo);
    }

    @Test
    public void queryByExample(){
        RoutInfo routInfo = new RoutInfo();
        List<RoutInfo> routInfolist = routInfoMapper.selectAll();
        logger.info("查询结果为：{}", routInfolist);
    }


}
