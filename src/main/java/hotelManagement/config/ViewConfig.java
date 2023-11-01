package hotelManagement.config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class ViewConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry ){
        //super.addViewControllers(registry);// 기존의 view 아키텍처 사용 안함
        registry.addViewController("/{spring:\\w+}").setViewName("forward:/");
        //
        registry.addViewController("/**/{spring}:\\w+}").setViewName("forward:/");
        // spring 2.6 이상 [ 해당 패턴 경로 못찾음 ]
        // 해결방안 application.properties[spring.mvc.pathmatch.matching-strategy=ant_path_matcher]
        registry.addViewController( "/{spring:\\w+}/**{spring:?!(\\.js|\\.css)$}").setViewName("forward:/");
    }
}
