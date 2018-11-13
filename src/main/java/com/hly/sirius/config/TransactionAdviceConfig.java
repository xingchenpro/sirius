package com.hly.sirius.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/21
 */

@Aspect
@Component
public class TransactionAdviceConfig {

    @Autowired
    private PlatformTransactionManager transactionManager;

    /**
     * 配置数据库通知事务
     * @return
     */
    @Bean
    public TransactionInterceptor txAdvice(){
        DefaultTransactionAttribute txAttr_REQUIRED = new DefaultTransactionAttribute();
        txAttr_REQUIRED.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        DefaultTransactionAttribute txAttr_REQUIRED_READONLY = new DefaultTransactionAttribute();
        txAttr_REQUIRED_READONLY.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        //只读事务，不做更新操作
        txAttr_REQUIRED_READONLY.setReadOnly(true);
        //事务管理规则，声明具备事务管理的方法名
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();

        source.addTransactionalMethod("delete*",txAttr_REQUIRED);
        source.addTransactionalMethod("insert*",txAttr_REQUIRED);
        source.addTransactionalMethod("remove*",txAttr_REQUIRED);
        source.addTransactionalMethod("update*",txAttr_REQUIRED);
        source.addTransactionalMethod("edit*",txAttr_REQUIRED);
        source.addTransactionalMethod("save*",txAttr_REQUIRED);
        source.addTransactionalMethod("add*",txAttr_REQUIRED);
        source.addTransactionalMethod("new*",txAttr_REQUIRED);
        source.addTransactionalMethod("set*",txAttr_REQUIRED);
        source.addTransactionalMethod("change*",txAttr_REQUIRED);
        source.addTransactionalMethod("load*",txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("get*",txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("find*",txAttr_REQUIRED_READONLY);
        source.addTransactionalMethod("*",txAttr_REQUIRED_READONLY);

        return new TransactionInterceptor(transactionManager,source);
    }

    /**
     * 配置事务切面
     * @return
     */
    @Bean
    public Advisor txAdviceAdvisor(){
        //声明一个切点
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        //设置需要拦截的方法
        pointcut.setExpression("execution(* com.hly.sirius.service.*.*(..))");
        //设置切面=pointcut(切点)+advice(通知)
        return new DefaultPointcutAdvisor(pointcut,txAdvice());

    }
}
