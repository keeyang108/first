package com.extra.first.util;

import org.junit.Test;

import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kee on 2017/6/13.
 */
public class JAXBUtilTest {
    @Test
    public void convertToXml() throws Exception {
        Shop shop = new Shop();
        shop.setCode("t1");
        shop.setName("t1");
        shop.setAddress("t1");
        shop.setTel("t1");

        Shop shop1 = new Shop();
        shop1.setCode("t1");
        shop1.setName("t1");
        shop1.setAddress("t1");
        shop1.setTel("t1");

        List<Shop> shops = new ArrayList<Shop>();
        shops.add(shop);
        shops.add(shop1);

        City city = new City();
        city.setId(1);
        city.setName("c1");
        city.setShops(shops);

        City city1 = new City();
        city1.setId(1);
        city1.setName("c1");
        city1.setShops(shops);

        List<City> cities = new ArrayList<City>();
        cities.add(city);
        cities.add(city1);

        Province p1 = new Province();
        p1.setName("p1");
        p1.setCities(cities);

        List<Province> provinces = new ArrayList<Province>();
        provinces.add(p1);

        Agency agency = new Agency();
        agency.setProvinces(provinces);

        String xml = JAXBUtil.convertToXml(agency);
        System.out.println(xml);
        
    }

    @Test
    public void converyToJavaBean() throws Exception {
        
        String path = "C:\\Users\\Kee\\Desktop\\ad\\5x.xml";
        StringBuffer xml = new StringBuffer();
        File file = new File(path);
        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar ;
            while ((tempchar = reader.read()) != -1){
                if (((char) tempchar) != '\r') {
                    xml.append((char)tempchar);
                }
            }
            reader.close();
        } catch (Exception e){
              e.printStackTrace();
        }
        Agency agency = JAXBUtil.converyToJavaBean(xml.toString(),Agency.class);
        System.out.println(agency.getProvinces().size());

    }
    
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "list")
class Agency{

    @XmlElement(name = "Province")
    private List<Province> provinces;

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }
}
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Province")
class Province{

    @XmlAttribute(name = "id")
    private Integer id;

    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name = "City")
    private List<City> cities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cities=" + cities +
                '}';
    }
}
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "City")
class City{
    
    @XmlAttribute
    private Integer id;

    @XmlAttribute
    private String name;

    @XmlElement(name = "Shop")
    private List<Shop> shops;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shops=" + shops +
                '}';
    }
}
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Shop")
class Shop{

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Code")
    private String code;

    @XmlElement(name = "Tel")
    private String tel;

    @XmlElement(name = "Address")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}