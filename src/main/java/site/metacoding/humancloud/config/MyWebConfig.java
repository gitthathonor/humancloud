package site.metacoding.humancloud.config;

import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD
=======
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
>>>>>>> 7abdc34b24506874c1167a19a88300d18c451ce1
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer{
<<<<<<< HEAD
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry regustry){
        regustry.addResourceHandler("/img/**")
        .addResourceLocations("file:///C:/temp/img/");
    }
=======

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**")
		.addResourceLocations("file:///C:/temp/img/");
	}

	
	
	
>>>>>>> 7abdc34b24506874c1167a19a88300d18c451ce1
}
