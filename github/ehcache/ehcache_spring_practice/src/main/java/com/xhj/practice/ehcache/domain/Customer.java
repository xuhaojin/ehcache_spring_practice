package com.xhj.practice.ehcache.domain;

import java.io.Serializable;

/**
 * 顾客类
 * @作者 xuhaojin
 * @version [版本号, 2018年12月18日]
 */
public class Customer implements Serializable
{
    public Customer() {
        super();
    }

    public Customer(String id, String name, String address) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
    }

    private static final long serialVersionUID = -3018385665396078058L;

    private String id;
    
    private String name;
    
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
