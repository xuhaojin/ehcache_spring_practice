package com.xhj.practice.ehcache.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xhj.practice.ehcache.domain.Customer;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * 启动服务时加入初始的customer缓存数据
 * @作者 xuhaojin
 * @version [版本号, 2018年12月18日]
 */
public class CustomerCacheListener implements ServletContextListener
{
    
    Logger logger = Logger.getLogger(this.getClass());

    public void contextInitialized(ServletContextEvent sce) {
        logger.info("servlet context initialized begin");
        ServletContext sc = sce.getServletContext();
        if(sc == null) {
            logger.warn("servlet context is null!");
            return;
        }
        
        ApplicationContext appcxt = WebApplicationContextUtils.getWebApplicationContext(sc);
        if(appcxt == null) {
            logger.warn("application context is null!");
            return;
        }
        
        CacheManager cacheManager = (CacheManager) appcxt.getBean("cacheManager");
        Cache customerCache = cacheManager.getCache("customer");
        Customer customer = new Customer("1","Smith","Smith Address");
        customerCache.put(new Element(customer.getId(),customer));
        Customer customerInstance = (Customer) customerCache.get("1").getObjectValue();
        logger.info(String.format("向缓存中添加customer：%s",customerInstance));
        logger.info("servlet context initialized end");
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

}
