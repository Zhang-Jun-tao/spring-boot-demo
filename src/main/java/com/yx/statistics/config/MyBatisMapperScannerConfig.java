package com.yx.statistics.config;
import com.yx.statistics.common.Mapper;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AutoConfigureAfter(MyBatisConfig.class)  //在生成sqlSessionFactory实例后，才能初始化该config
public class MyBatisMapperScannerConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.yx.statistics.dao");  //设置mapper（dao）的jar路径
        
//      annotationClass：配置了该注解的dao才会被扫描器扫描，与basePackage是与的作用。
//      需要注意的是，两个过滤条件只能配一个。
        mapperScannerConfigurer.setAnnotationClass(Mapper.class);// annotationClass：配置了该注解的dao才会被扫描器扫描
        return mapperScannerConfigurer;
    }
}
