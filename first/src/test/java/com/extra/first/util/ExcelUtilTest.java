package com.extra.first.util;

import com.extra.first.dao.AgencyDao;
import com.extra.first.dao.CityDao;
import com.extra.first.dao.OrderDao;
import com.extra.first.dao.ProvinceDao;
import com.extra.first.pojo.Agency;
import com.extra.first.pojo.City;
import com.extra.first.pojo.Order;
import com.extra.first.pojo.Province;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Ignore;
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

    @Autowired
    private ProvinceDao provinceDao;

    @Autowired
    private CityDao cityDao;

    @Autowired
    private AgencyDao agencyDao;


    @Ignore
    @Test
    public void createExcel() throws Exception {
        List<Map<String, Object>> data = orderDao.queryOrders(new Order(), 0, 10);
        HSSFWorkbook workbook = ExcelUtil.createExcel("test", new String[]{"用户名", "电话", "省份", "城市", "经销商", "车型"}, new String[]{"userName", "userPhone", "provinceName", "cityName", "agencyName", "carName"}, data);
        OutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
    }

    @Ignore
    @Test
    public void  readTest(){
         List<List<String>> result =   ExcelUtil.readExcel("D:\\经销商信息.xlsx");
        Province province = null;
        City city = null;
        Agency agency = null;
        if (result != null) {
            for (int i = 0; i < result.size(); i++) {
                List<String> cellList = result.get(i);
                if (StringUtils.isNotBlank(cellList.get(0))){
                    province = new Province();
                    province.setProvinceName(cellList.get(0));
                    provinceDao.addProvince(province);
                }
                if (StringUtils.isNotBlank(cellList.get(1))){
                    city = new City();
                    city.setProvinceId(province.getId());
                    city.setCityName(cellList.get(1));
                    cityDao.addCity(city);
                }
                agency = new Agency();
                agency.setAgencyName(cellList.get(2));
                agency.setConnectPhone(cellList.get(3));
                agency.setAgencyAddress(cellList.get(4));
                agency.setCityId(city.getId());
                agencyDao.addAgency(agency) ;
            }
        }
    }

}

