package com.gyt.springboot.config;

import com.gyt.springboot.component.LoginHandlerInterceptor;
import com.gyt.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        // 浏览器发送/haha 也来到 succcess
        registry.addViewController("/haha").setViewName("success");
    }

    @Bean
    // 所有的WebMvnConfigurationAdapter组件都会一起起作用
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                super.addViewControllers(registry);
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//            super.addInterceptors(registry);
//                registry.addInterceptor(new LoginHandlerInterceptor())
//                        .addPathPatterns("/**")
//                        .excludePathPatterns("/login.html", "/", "/user/login", "/login","/static/asserts/**");
            }
//            //静态文件
//            @Override
//            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                //静态文件
//                registry.addResourceHandler("/**").addResourceLocations("classpath:/**");
//                //webjar文件
//                registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
//            }
        };

        return webMvcConfigurerAdapter;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

}
