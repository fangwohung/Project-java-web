/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Article.Service;

import Article.DAO.StudentDAO;
import Article.Model.StudentModel;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author quochung
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public List<StudentModel> getRecordsPerPage(int start, int total) {
        return studentDAO.getRecordsPerPage(start, total);
    }

    @Override
    public int tongsodong() {
        return studentDAO.tongsodong();
    }

    @Override
    public List<StudentModel> getListStudent() {
        return studentDAO.getListStudent();
        
    }

    @Override
    public int addStudent(StudentModel student) {
        return studentDAO.addStudent(student);
    }

    @Override
    public int deleteStudent(StudentModel student) {
        return studentDAO.deleteStudent(student);
    }

    @Override
    public int editStudent(StudentModel student) {
        return studentDAO.editStudent(student);
    }

}
