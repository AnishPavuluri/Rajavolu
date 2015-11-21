package com.village.rajavolu.aop;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * User: Seethayya
 * Date: 4/10/14
 * Time: 1:45 PM
 */
public class FinderIntroductionAdvisor extends DefaultIntroductionAdvisor {
    public FinderIntroductionAdvisor() {
        super(new FinderIntroductionInterceptor());
    }
}