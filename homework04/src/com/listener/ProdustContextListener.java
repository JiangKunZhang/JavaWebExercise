package com.listener; /**
 * @author PineappleSnow
 * @date 2020/5/12 16:54
 * @version 1.0
 */

import com.model.Product;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;

@WebListener()
public class ProdustContextListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    private ServletContext context = null;
    // 在上下文对象初始化时将商品信息存储到ArrayList对象中
    public void contextInitialized(ServletContextEvent sce){
        ArrayList<Product> productList = new ArrayList<Product>();
        productList.add(new Product(101, "单反相机",4159.95,10, "家用"));
        productList.add(new Product(102, "苹果手机",1199.95,8, "家用"));
        productList.add(new Product(103, "笔记本电脑",5129.95,20, "电子"));
        productList.add(new Product(104, "平板电脑",1239.95,20, "电子"));
        context = sce.getServletContext();
        // 将productList存储在应用作用域中
        context.setAttribute("productList",productList);   // 添加属性
    }
    public void contextDestroyed(ServletContextEvent sce){
        context = sce.getServletContext();
        context.removeAttribute("productList");
    }
}
