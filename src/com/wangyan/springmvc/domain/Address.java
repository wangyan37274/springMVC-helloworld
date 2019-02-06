package com.wangyan.springmvc.domain;

/**
 * @Auther: wangyan
 * @Date: 2019/1/16
 * @Description: com.wangyan.springmvc.domain
 * @version: 1.0
 */
public class Address {

    private String province;
    private String city;

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
