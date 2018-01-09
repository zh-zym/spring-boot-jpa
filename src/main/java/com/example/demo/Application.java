package com.example.demo;

import com.google.common.base.Predicate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * 部署war包的时候使用
	 * @param builder
	 * @return
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		builder.sources(this.getClass());
		return super.configure(builder);
	}

	/**
	 * api文档配置   localhost:8080/swagger-ui.html
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
			@Override
			public boolean apply(RequestHandler requestHandler) {
				Class<?> declearingClass = requestHandler.declaringClass();
				if (declearingClass == BasicErrorController.class)
					return false;
				if (requestHandler.isAnnotatedWith(ResponseBody.class))
					return true;
				if (requestHandler.isAnnotatedWith(RestController.class))
					return true;
				if (requestHandler.isAnnotatedWith(PostMapping.class))
					return true;
				if (requestHandler.isAnnotatedWith(GetMapping.class))
					return true;
				return false;
			}
		};
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(predicate)
				.paths(PathSelectors.any())
				.build();
	}

	/**
	 * 文档的部分描述
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("demo系统接口文档 v1.0")  //标题
				.description("更多相关内容请联系：mail   ：  zh878998515@gmail.com")  //描述
				.version("1.0")  //版本
				.build();
	}


}
