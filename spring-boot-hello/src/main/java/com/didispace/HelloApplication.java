package com.didispace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 本项目来源于《SpringCloud微服务实战》
    * @ClassName: HelloApplication
    * @Description: TODO(启动类)
    * @author lenovo
    * @date 2020年1月3日
    *
 */

@EnableDiscoveryClient //激活Eureka中的Discoveryclient实现（自动化配置，创建Discoveryclient接口针对Eureka客户端的EurekaDiscoveryClient实例）
@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

}
