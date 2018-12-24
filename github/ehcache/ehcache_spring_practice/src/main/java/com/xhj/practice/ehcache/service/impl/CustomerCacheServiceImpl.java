package com.xhj.practice.ehcache.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.xhj.practice.ehcache.domain.Customer;
import com.xhj.practice.ehcache.service.CustomerCacheService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * 处理Customer缓存的服务类
 * @作者 xuhaojin
 * @version [版本号, 2018年12月18日]
 */
@Service
public class CustomerCacheServiceImpl implements CustomerCacheService
{
    
    Logger logger = Logger.getLogger(this.getClass());
    
    @Autowired
    private CacheManager cacheManager;

    /**
     * 设置cacheManager
     */
    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    /**
     * 将Customer数据保存在ehcache缓存中
     * @throws Exception 
     */
    public boolean saveCustomerCache(Customer customer) throws Exception {
        try {
            Cache customerCache = cacheManager.getCache("customer");
            customerCache.put(new Element(customer.getId(), customer));
            return true;
        }
        catch (Exception e) {
            logger.warn(String.format("customer加入缓存失败,%s", customer),e);
        }
        return false;
    }

    /**
     * 删除所有的customer缓存
     */
    public void removeAllCaches() {
        try {
            Cache customerCache = cacheManager.getCache("customer");
            customerCache.removeAll();
        }
        catch (Exception e) {
            logger.warn(String.format("删除customer所有缓存失败"),e);
        }
    }

    /**
     * 获取所有的customer缓存
     */
    @SuppressWarnings("unchecked")
    public List<Customer> getAllCustomerCaches() {
        Cache customerCache = cacheManager.getCache("customer");
        List<String> customerIds = customerCache.getKeys();
        List<Customer> customerList = Lists.newArrayList();
        for (String customerId : customerIds) {
            Customer c = (Customer) customerCache.get(customerId).getValue();
            customerList.add(c);
        }
        return customerList;
    }

}
