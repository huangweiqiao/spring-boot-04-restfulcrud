package com.hwq;

import groovy.util.logging.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot04RestfulCurdApplicationTest {
    Logger logger = LoggerFactory.getLogger(SpringBoot04RestfulCurdApplicationTest.class);
    @Autowired
    private DataSource dataSource;

    @Test
    public void contextLoads(){
        try {
            System.out.println(dataSource.getClass());
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testLog(){
        //日志级别，由低到高
        logger.trace("这是trace日志。。。");
        logger.debug("这是debu日志。。。");
        logger.info("这是info日志。。。");
        logger.warn("这是警告日志。。。");
        logger.error("这是error日志。。。");
    }
}
