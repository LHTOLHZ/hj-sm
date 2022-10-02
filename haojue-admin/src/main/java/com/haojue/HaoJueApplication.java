package com.haojue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author liujie
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class HaoJueApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(HaoJueApplication.class, args);
    }
}
