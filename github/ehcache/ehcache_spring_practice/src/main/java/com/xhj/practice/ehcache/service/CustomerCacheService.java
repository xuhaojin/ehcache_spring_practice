package com.xhj.practice.ehcache.service;

import java.util.List;

import com.xhj.practice.ehcache.domain.Customer;

import net.sf.ehcache.CacheManager;

public interface CustomerCacheService
{
    public void setCacheManager(final CacheManager cacheManager);
    
    public boolean saveCustomerCache(Customer customer) throws Exception ;
    
    public void removeAllCaches();
    
    public List<Customer> getAllCustomerCaches();
}
