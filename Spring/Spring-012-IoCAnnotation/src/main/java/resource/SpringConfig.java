package resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//编写一个类。代替Spring6的配置文件
@Configuration
@ComponentScan({"resource.dao", "resource.service"})
public class SpringConfig {
}
