package spring.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//如果将value完全省略，使用默认值，则bean的id会默认为首字母小写的类名
@Controller     //此时bean的id名为vip
public class Vip {
}
