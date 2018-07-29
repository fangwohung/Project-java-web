/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Article.DAO;

import Article.Model.StudentModel;
import java.util.List;

/**
 *
 * @author quochung
 */
public interface StudentDAO {

    public List<StudentModel> getRecordsPerPage(int start, int total);

    public int tongsodong();

    public List<StudentModel> getListStudent();

    public int addStudent(StudentModel student);

    public int deleteStudent(StudentModel student);

    public int editStudent(StudentModel student);
}
