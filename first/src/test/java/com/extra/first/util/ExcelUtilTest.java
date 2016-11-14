package com.extra.first.util;

import com.extra.first.dao.OrderDao;
import com.extra.first.pojo.Order;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by Kee on 2016/11/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring/application-*.xml"})
public class ExcelUtilTest {

    @Autowired
    private OrderDao orderDao;
    @Test
    public void createExcel() throws Exception {
        List<Map<String,Object>> data = orderDao.queryOrders(new Order(),0,10);
        HSSFWorkbook workbook = ExcelUtil.createExcel("test",new String[]{"用户名","电话","省份","城市","经销商","车型"},new String[]{"userName","userPhone","provinceName","cityName","agencyName","carName"},data);
        OutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
    }

}