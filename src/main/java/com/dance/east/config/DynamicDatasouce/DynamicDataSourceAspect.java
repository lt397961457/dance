package com.dance.east.config.DynamicDatasouce;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
/**
 * 一定要设置！！！否则动态数据源不会生效，只会使用里面的默认数据源
 * 设置AOP执行顺序(需要在事务之前，否则事务只发生在默认库中)
 */
@Order(1)
@Component
public class DynamicDataSourceAspect {

    @Before("@annotation(DS)")
    public void beforeSwitchDS(JoinPoint point){

        //获得当前访问的class
        Class<?> className = point.getTarget().getClass();

        //获得访问的方法名
        String methodName = point.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature)point.getSignature()).getParameterTypes();
        String dataSource = DataSourceContextHolder.DEFAULT_DS;
        try {
            // 得到访问的方法对象
            Method method = className.getMethod(methodName, argClass);

            // 判断是否存在@DS注解
            if (method != null && method.isAnnotationPresent(DS.class)) {
                DS annotation = method.getAnnotation(DS.class);
                // 取出注解中的数据源名
                dataSource = annotation.value();
                // 切换数据源
                DataSourceContextHolder.setDB(dataSource);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }


    @After("@annotation(DS)")
    public void afterSwitchDS(JoinPoint point){

        DataSourceContextHolder.clearDB();

    }
}