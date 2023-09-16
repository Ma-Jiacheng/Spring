package jdbc;

import bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpringJdbcTest {
    @Test
    public void testJdbc() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(jdbcTemplate);
    }

    @Test
    public void testInsert() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        //insert语句
        String sql = "insert into t_user(real_name, age) values(?, ?)";
        int count = jdbcTemplate.update(sql, "王五", 20);
        System.out.println(count);
    }

    @Test
    public void testUpdate() {
        //根据id修改记录
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "update t_user set real_name = ?,  age = ? where id = ?";
        int count = jdbcTemplate.update(sql, "王五", 29, 3);
        System.out.println(count);
    }

    @Test
    public void testDelete() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "delete from t_user where id = ?";
        int count = jdbcTemplate.update(sql, 3);
        System.out.println(count);
    }

    @Test
    public void testQueryOne() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select id, real_name, age from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 2);
        System.out.println(user);
    }

    @Test
    public void testQueryAll() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select id, real_name, age from t_user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(users);
    }

    @Test
    public void testQueryOneValue() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select count(*) from t_user";
        Integer count = jdbcTemplate.queryForObject(sql, int.class);
        System.out.println("总记录条数：" + count);
    }

    @Test
    public void testAddBatchInsert() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into t_user(real_name, age) values(?, ?)";
        //准备数据
        Object[] objA = {"小花", 21};
        Object[] objB = {"小明", 23};
        Object[] objC = {"小强", 22};
        Object[] objD = {"小玉", 20};
        //添加到List集合
        List<Object[]> list = new ArrayList<>();
        list.add(objA);
        list.add(objB);
        list.add(objC);
        list.add(objD);
        //执行SQL语句
        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }

    @Test
    public void testBatchUpdate() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "update t_user set real_name = ?, age = ? where id = ?";
        Object[] objA = {"小王", 25, 6};
        Object[] objB = {"小李", 26, 7};

        List<Object[]> list = new ArrayList<>();
        list.add(objA);
        list.add(objB);

        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }

    @Test
    public void testBatchDelete(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "delete from t_user where id = ?";

        Object[] objA = {6};
        Object[] objB = {7};

        List<Object[]> list = new ArrayList<>();
        list.add(objA);
        list.add(objB);

        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }

    @Test
    public void testCallBack(){
        //编写JDBC代码，可以使用CallBack回调函数
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        //准备SQL语句
        String sql = "select id, real_name, age from t_user where id = ?";
        //注册回调函数，当execute方法执行时，回调函数中的doInPreparedStatement()方法会被调用
        User user = jdbcTemplate.execute(sql, new PreparedStatementCallback<User>() {
            @Override
            public User doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                User user = null;
                ps.setInt(1, 2);
                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String realName = resultSet.getString("real_name");
                    int age = resultSet.getInt("age");
                    user = new User(id, realName, age);
                }
                return user;
            }
        });
        System.out.println(user);
    }
}
