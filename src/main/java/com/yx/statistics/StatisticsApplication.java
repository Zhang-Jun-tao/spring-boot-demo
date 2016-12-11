package com.yx.statistics;

import com.yx.statistics.common.StartProjectInfo;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class StatisticsApplication extends SpringBootServletInitializer {
	private static final Logger LOG=Logger.getLogger(StatisticsApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StatisticsApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(StatisticsApplication.class, args);
		LOG.debug(StartProjectInfo.getProjectProtector());
	}
}
