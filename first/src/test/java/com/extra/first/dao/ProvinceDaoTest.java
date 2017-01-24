package com.extra.first.dao;

import com.extra.first.pojo.Province;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Kee on 2016/10/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring/application-dao.xml"})
public class ProvinceDaoTest {
    Logger logger = LoggerFactory.getLogger(ProvinceDaoTest.class);
    @Autowired
    private ProvinceDao provinceDao;

    @Test
    @Ignore
    public void addProvince() throws Exception {
        Province province = new Province();
        province.setProvinceName("北京");
        int result = provinceDao.addProvince(province);
        logger.info("result=" + result);
    }

    @Test
    public void listProvince() throws Exception {
        List<Province> provinces = provinceDao.listProvince(0, 10);
        for (Province province : provinces) {
            System.out.println(province.toString());
        }
    }

    @Test
    public void queryProvinceById() throws Exception {

    }

}