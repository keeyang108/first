package com.extra.first.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Kee on 2016/10/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring/application-dao.xml"})
public class EncryptUtilTest {

    Logger logger = LoggerFactory.getLogger(EncryptUtil.class);
    @Test
    public void MD5Encrypt() throws Exception {
       String result =  EncryptUtil.MD5Encrypt("keeyang123456");
        logger.info(result.length()+"-"+result);
    }

}