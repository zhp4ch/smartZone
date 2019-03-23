package com;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.mass.core.framework.boot.CherryBootApplication;

@SpringBootApplication
//@EnableScheduling  //启动定时器
@EnableConfigurationProperties
public class MassApplication extends CherryBootApplication {

    public static void main(String[] args) { 
        SpringApplication.run(MassApplication.class, args);
    }
    
    /**  
     * 文件上传配置  
     * @return  
     */  
    @Bean  
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大  
        factory.setMaxFileSize("500MB"); //KB,MB  
        // 设置总上传数据总大小  
        factory.setMaxRequestSize("500MB");  
        return factory.createMultipartConfig();  
    } 
    
    @Primary
    @Bean
    public TaskExecutor primaryTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        return executor;
    }
    
}
