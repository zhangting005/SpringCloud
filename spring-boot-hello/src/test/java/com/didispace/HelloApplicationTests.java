//package com.didispace;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.didispace.web.HelloController;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)		//引入spring对Junit4的支持
//@SpringApplicationConfiguration(classes = HelloApplication.class)	//指定springboot的启动类
//@WebAppConfiguration	//开启web应用的配置，用于模拟ServletContext
//public class HelloApplicationTests {
//	
//	private MockMvc mvc;//MockMvc对象：用于模拟调用Controller的接口发起请求
//	
//	@Before //@Before:JUnit中定义在测试用例@Test内容执行前预加载的内容，这里用来初始化对HelloController的模拟。
//	public void setUp() throws Exception {
//		mvc=MockMvcBuilders.standaloneSetup(new HelloController()).build();
//	}
//
//	@Test
//	public void hello() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON)) //perform函数执行一次请求调用，accept用于执行接收的数据类型
//		.andExpect(status().isOk()) //andExpect用于判断接口返回的期望值。
//		.andExpect(content().string(equalTo("Hello World")));
//	}
//
//}
