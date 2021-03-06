package com.unipe.barros.studio.orh.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.unipe.barros.studio.orh.interceptors.ControleAcessoInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.unipe.barros.studio.orh")
@EnableJpaRepositories("com.unipe.barros.studio.orh.repositories")
public class AppWebConfiguration extends WebMvcConfigurerAdapter
{

   @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
   {
      configurer.enable();
   }
   
   public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ControleAcessoInterceptor());
	};

   @Bean
   public InternalResourceViewResolver internalResourceViewResolver()
   {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
      return resolver;
   }
}
