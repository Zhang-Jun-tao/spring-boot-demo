package com.yx.statistics.config;

import com.yx.statistics.common.ApplicationContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    	log.error(getStringImg(springProfile));
    	ApplicationContext.runEnv=springProfile;
    	return springProfile;
    }
    
    public String getStringImg(String str){
    	StringBuffer sb=new StringBuffer();
    	sb.append("\n");
    	if(str.trim().equals("text")){
    		sb.append(" *                 *\n");
    		sb.append("*****  **  ** ** *****\n");
    		sb.append(" *    *  *  * *    * \n");
    		sb.append(" *    ****   *     *\n");
    		sb.append(" *    *     * *    *\n");
    		sb.append(" ***   *** ** **   ***\n");
    	}else if(str.trim().equals("dev")){
    		sb.append("	   **               \n");
    		sb.append("	    *               \n");
    		sb.append("	    *               \n");
    		sb.append("	  ***   **  ** **   \n");
    		sb.append("	 *  *  *  *  * *    \n");
    		sb.append("	 *  *  ****  * *    \n");
    		sb.append("	 *  *  *      *     \n");
    		sb.append("	  ****  ***   *     \n");
    	}else if(str.trim().equals("prod")){
    		sb.append("			             **\n");
    		sb.append("			             *\n");
    		sb.append("			             *\n");
    		sb.append("****  ** **   **    ***\n");
    		sb.append("*  *  **    *  *  *  *\n");
    		sb.append("*  *  *     *  *  *  *\n");
    		sb.append("*  *  *     *  *  *  *\n");
    		sb.append("***  ***     **    ****\n");
    		sb.append("*\n");
    		sb.append("***\n");
    	}
    	return sb.toString();
    }
}

