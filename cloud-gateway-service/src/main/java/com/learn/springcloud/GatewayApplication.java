package com.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
 * 2020-03-29 16:08:31.743 ERROR 43107 --- [  restartedMain] o.s.b.d.LoggingFailureAnalysisReporter   :
 *
 * ***************************
 * APPLICATION FAILED TO START
 * ***************************
 *
 * Description:
 *
 * Parameter 0 of method modifyResponseBodyGatewayFilterFactory in org.springframework.cloud.gateway.config.GatewayAutoConfiguration required a bean of type 'org.springframework.http.codec.ServerCodecConfigurer' that could not be found.
 *
 *
 * Action:
 *
 * Consider defining a bean of type 'org.springframework.http.codec.ServerCodecConfigurer' in your configuration.
 *
 *
 * 取消了，commons-service依赖，因为里面依赖了web和actuator的依赖
 *
 * @author ct
 * @date 2020/3/29 3:57 下午
 */
@EnableEurekaClient
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
