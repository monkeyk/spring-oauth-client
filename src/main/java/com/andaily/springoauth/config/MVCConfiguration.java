package com.andaily.springoauth.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 2023/11/6
 * <p>
 * Spring MVC 扩展配置
 * <p>
 *
 * @author Shengzhao Li
 * @since 2.0.0
 */
@Configuration
public class MVCConfiguration implements WebMvcConfigurer {


//    /**
//     * 扩展拦截器
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        WebMvcConfigurer.super.addInterceptors(registry);
//    }


//    /**
//     * 解决乱码问题
//     * For UTF-8
//     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        WebMvcConfigurer.super.configureMessageConverters(converters);
//        converters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
//    }


}
