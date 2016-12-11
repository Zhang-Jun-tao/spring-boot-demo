package com.yx.statistics.config;

import com.yx.statistics.common.ApplicationContext;
import com.yx.statistics.common.StartProjectInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	private static final Logger log= Logger.getLogger(WebMvcConfig.class);
	
	@Value("${spring.profiles.active}")
	private  String springProfile;   //必须使用非静态的
	
	@Value("#{systemProperties['os.name']}")
	private  String osName;   

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
    
    

//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        registry.enableContentNegotiation(new MappingJackson2JsonView());
//        registry.freeMarker().cache(false);
//    }
//
//    @Bean
//    public FreeMarkerConfigurer freeMarkerConfigurer() {
//        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//        configurer.setTemplateLoaderPath("/WEB-INF/templates");
//        return configurer;
//    }
    
    @Override
	public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController("/errorPage").setViewName("/errorPage");
    	//registry.addViewController("/login").setViewName("login");
	}



	@Bean
    public String printProfile(){
    	log.error("\t\tcurrnet environment: ꧁༺"+springProfile+"༻ ꧂   \tcurrnet paltform:"+osName );
    	log.error(StartProjectInfo.getProfileString(springProfile));
    	ApplicationContext.runEnv=springProfile;
    	return springProfile;
    }


	@Bean
    public RestTemplate restTemplate(){
    	return  new RestTemplate();
	}

}

