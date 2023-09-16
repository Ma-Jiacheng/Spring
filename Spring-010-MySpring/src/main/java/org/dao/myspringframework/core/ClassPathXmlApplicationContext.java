package org.dao.myspringframework.core;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext{

    private static final Logger logger = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);

    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 解析myspring的配置文件，然后初始化所有bean对象
     * @param configLocation myspring配置文件的路径。注意：使用ClassPathXmlApplicationContext，配置文件应放到类路径下
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        try{
            //解析myspring.xml文件，然后实例化bean，将bean存放到singletonObjects集合当中
            SAXReader reader = new SAXReader();     //dom4j解析xml文件的核心对象
            //获取一个输入流，指向配置文件
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
            //读文件
            Document document = reader.read(in);
            //获取所有的bean标签
            List<Node> nodes = document.selectNodes("//bean");
            //遍历bean标签
            nodes.forEach(node -> {
                try {
                    //System.out.println(node);
                    //向下转型，使用Element接口中更丰富的方法
                    Element beanElt = (Element) node;
                    //获取id属性
                    String id = beanElt.attributeValue("id");
                    //获取class属性
                    String className = beanElt.attributeValue("class");
                    logger.info("beanID = " + id);
                    logger.info("className = " + className);
                    //通过反射机制创建对象，将其放到Map集合中，提前曝光
                    Class<?> aClass = Class.forName(className);     //获取Class
                    Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();   //获取无参数构造方法
                    Object bean = declaredConstructor.newInstance();    //调用无参数构造实例化Bean
                    singletonObjects.put(id, bean);     //将bean对象加入Map集合，提前曝光
                    logger.info(singletonObjects.toString());
                } catch (Exception exception){
                    exception.printStackTrace();
                }
            });

            //再次重新遍历所有的bean标签，给对象的属性赋值
            nodes.forEach(node -> {
                try {
                    Element beanElt = (Element) node;
                    //获取id及class名称
                    String id = beanElt.attributeValue("id");
                    String className = beanElt.attributeValue("class");

                    //获取class
                    Class<?> aClass = Class.forName(className);

                    //获取该bean标签下的所有属性property标签
                    List<Element> propertys = beanElt.elements("property");
                    propertys.forEach(property -> {
                        try{
                            //获取属性名
                            String propertyName = property.attributeValue("name");
                            logger.info("属性名：" + propertyName);
                            //获取属性类型
                            Field declaredField = aClass.getDeclaredField(propertyName);
                            //获取set方法名
                            String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                            //获取set方法
                            Method setMethod = aClass.getDeclaredMethod(setMethodName, declaredField.getType());
                            //获取具体值
                            String value = property.attributeValue("value");
                            String ref = property.attributeValue("ref");
                            Object actualValue = null;
                            //调用set方法
                            if(value != null){
                                //获取属性类型名
                                String propertyTypeSimpleName = declaredField.getType().getSimpleName();
                                switch (propertyTypeSimpleName){
                                    case "byte":
                                        actualValue = Byte.parseByte(value);
                                        break;
                                    case "short":
                                        actualValue = Short.parseShort(value);
                                        break;
                                    case "int":
                                        actualValue = Integer.parseInt(value);
                                        break;
                                    case "long":
                                        actualValue = Long.parseLong(value);
                                        break;
                                    case "float":
                                        actualValue = Float.parseFloat(value);
                                        break;
                                    case "double":
                                        actualValue = Double.parseDouble(value);
                                        break;
                                    case "boolean":
                                        actualValue = Boolean.parseBoolean(value);
                                        break;
                                    case "char":
                                        actualValue = value.charAt(0);
                                        break;
                                    case "Byte":
                                        actualValue = Byte.valueOf(value);
                                        break;
                                    case "Short":
                                        actualValue = Short.valueOf(value);
                                        break;
                                    case "Integer":
                                        actualValue = Integer.valueOf(value);
                                        break;
                                    case "Long":
                                        actualValue = Long.valueOf(value);
                                        break;
                                    case "Float":
                                        actualValue = Float.valueOf(value);
                                        break;
                                    case "Double":
                                        actualValue = Double.valueOf(value);
                                        break;
                                    case "Boolean":
                                        actualValue = Boolean.valueOf(value);
                                        break;
                                    case "Character":
                                        actualValue = Character.valueOf(value.charAt(0));
                                        break;
                                    case "String":
                                        actualValue = value;
                                        break;
                                }
                                setMethod.invoke(singletonObjects.get(id), actualValue);
                            }
                            if(ref != null){    //非简单类型，ref为对象的id，直接将Map集合中id对应的对象赋值
                                setMethod.invoke(singletonObjects.get(id), singletonObjects.get(ref));
                            }
                        } catch (Exception exception){
                            exception.printStackTrace();
                        }
                    });
                } catch (Exception exception){
                    exception.printStackTrace();
                }
            });
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }
}
