package com.kingfish.show.conf;

import com.kingfish.show.interceptor.RenderContextHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private RenderContextHandlerInterceptor renderContextHandlerInterceptor;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(renderContextHandlerInterceptor).addPathPatterns("/**");
    }
}