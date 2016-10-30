package com.extra.first.controller;

import com.extra.first.dto.BaseResult;
import com.extra.first.pojo.*;
import com.extra.first.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Kee on 2016/10/23.
 */
@Controller
@RequestMapping("/front/order")
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CityService cityService;
    @Autowired
    private AgencyService agencyService;
    @Autowired
    private CarService carService;


    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public BaseResult<Object> addOrder(@ModelAttribute Order order) {
        if (StringUtils.isEmpty(order.getUserName())) {
            return new BaseResult<Object>(false, "用户名不能为空");
        }
        if (StringUtils.isEmpty(order.getUserPhone())) {
            return new BaseResult<Object>(false, "手机号不能为空");
        }
        if (!order.getUserPhone().matches("\\d{11}")) {
            return new BaseResult<Object>(false, "请输入正确的手机号码");
        }
        int row = orderService.addOrder(order);
        if (row < 1) {
            return new BaseResult<Object>(false, "Internal Error");
        }
        return new BaseResult<Object>(true, null);
    }

    @RequestMapping(value = "/listprovince", method = RequestMethod.GET,produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public BaseResult<List<Province>> listProvince(Integer offset, Integer limit) {
        if (offset == null || offset <= 0) {
            offset = 1;
        }
        if (limit == null || limit <= 0) {
            limit = 10;
        }
        List<Province> provinces =  provinceService.listProvince((offset - 1) * limit, limit);
        if ( provinces == null || provinces.size() < 1 ){
            return new BaseResult<List<Province>>(false,"Internal Error");
        }
        return new BaseResult<List<Province>>(true,provinces);
    }

    @RequestMapping(value = "/listcity", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public BaseResult<List> listCity(Integer provinceId, Integer offset, Integer limit) {
        if (provinceId == null || provinceId <= 0) {
            return new BaseResult<List>(false, "非法参数");
        }
        if (offset == null || offset <= 0) {
            offset = 1;
        }
        if (limit == null || limit <= 0) {
            limit = 10;
        }
        List<City> cities = cityService.queryCitiesByProvinceId(provinceId, (offset - 1) * limit, limit);
        return new BaseResult<List>(true, cities);
    }

    @RequestMapping(value = "/listagency", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public BaseResult<List<Agency>> listAgency(Integer cityId, Integer offset, Integer limit) {
        if (cityId == null || cityId <= 0) {
            return new BaseResult<List<Agency>>(false, "非法参数");
        }
        if (offset == null || offset <= 0) {
            offset = 1;
        }
        if (limit == null || limit <= 0) {
            limit = 10;
        }
        List<Agency> agencies = agencyService.queryAgenciesByCityId(cityId, (offset - 1) * limit, limit);
        if (agencies == null || agencies.size() < 1) {
            return new BaseResult<List<Agency>>(false, "Internal Error");
        }
        return new BaseResult<List<Agency>>(true, agencies);
    }

    @RequestMapping(value = "/listcar", method = RequestMethod.GET, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public BaseResult<List<Car>> listCar(Integer currPage, Integer limit) {
        if (currPage == null || currPage <= 0) {
            currPage = 1;
        }
        if (limit == null || limit <= 0) {
            limit = 10;
        }
        List<Car> cars = carService.listCar((currPage - 1) * limit, limit);
        if (cars == null || cars.size() < 1) {
            return new BaseResult<List<Car>>(false, "Internal Error");
        }
        return new BaseResult<List<Car>>(true, cars);
    }


}
