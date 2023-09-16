package resource.dao.impl;

import org.springframework.stereotype.Repository;
import resource.dao.StudentDao;

@Repository(value = "studentDaoImplForMySQL")
public class StudentDaoImplForMySQL implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("MySQL数据库正在删除学生信息......");
    }
}
