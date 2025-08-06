package blog.com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Springの設定をするクラスだと宣言
@Configuration
public class WebConfig implements WebMvcConfigurer{
	// addResourceHandlers(ResourceHandlerRegistry registry): 
	// このメソッドは、静的リソースのリソースハンドラーを追加するために使用
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("file:images/");
	}
}
