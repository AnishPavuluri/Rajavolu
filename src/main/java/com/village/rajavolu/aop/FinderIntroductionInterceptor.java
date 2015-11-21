package com.village.rajavolu.aop;

import com.village.rajavolu.dao.FinderExecutor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

/**
 * User: Seethayya
 * Date: 4/10/14
 * Time: 1:46 PM
 */
public class FinderIntroductionInterceptor implements IntroductionInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        FinderExecutor genericDao = (FinderExecutor) methodInvocation.getThis();

        String methodName = methodInvocation.getMethod().getName();
        if (methodName.startsWith("find")) {
            Object[] arguments = methodInvocation.getArguments();
            return genericDao.executeFinder(methodInvocation.getMethod(), arguments);
        } else {
            return methodInvocation.proceed();
        }
    }

    public boolean implementsInterface(Class intf) {
        return intf.isInterface() && FinderExecutor.class.isAssignableFrom(intf);
    }
}
