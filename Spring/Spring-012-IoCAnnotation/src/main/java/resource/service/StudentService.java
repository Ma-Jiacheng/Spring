package resource.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import resource.dao.StudentDao;

@Service(value = "studentService")
public class StudentService {
    @Resource(name = "studentDaoImplForMySQL")
    private StudentDao studentDao;

    public void deleteStudent(){
        studentDao.deleteById();
    }
}
