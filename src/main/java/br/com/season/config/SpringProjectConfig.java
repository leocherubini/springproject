package br.com.season.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("br.com.season")
public class SpringProjectConfig extends WebMvcConfigurerAdapter {
    
//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/views/pages/");
//        viewResolver.setSuffix(".jsp");
//        
//        return viewResolver;
//    }
    
    @Bean
    public TilesConfigurer tilesConfigure() {
        TilesConfigurer tiles = new TilesConfigurer();
        tiles.setDefinitions(new String[] {"/WEB-INF/views/**/tiles.xml"});
        tiles.setCheckRefresh(true);
        
        return tiles;
    } 
    
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }
    
}
