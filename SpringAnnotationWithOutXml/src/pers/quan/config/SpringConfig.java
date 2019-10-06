package pers.quan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @Discription Spring配置类
 * @author John丶Woo
 * @date 2019年9月9日 下午12:25:54
 *
 */
@Configuration
@ComponentScan("pers.quan")
@Import({JDBCConfig.class})
public class SpringConfig {

}
