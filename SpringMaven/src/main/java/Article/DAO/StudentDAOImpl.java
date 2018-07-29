/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Article.DAO;

import Article.Model.StudentModel;
import Article.DB.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author quochung
 */
@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public int deleteStudent(StudentModel student) {
        Session session = sessionFactory.getCurrentSession();
        if (student != null) {
            session.delete(student);
            return 1;
        }
        return 0;
    }

    @Override
    public int addStudent(StudentModel student) {
        Session session = sessionFactory.getCurrentSession();
        int check = (int) session.save(student);
        return check;
    }

    @Override
    public List<StudentModel> getListStudent() {
        Session session = sessionFactory.getCurrentSession();
        List<StudentModel> list = (List<StudentModel>) session.createQuery("from StudentModel").list();
        return list;
    }

    @Override
    public List<StudentModel> getRecordsPerPage(int start, int total) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Emp");
        query.setFirstResult(start);
        query.setMaxResults(total);
        List<StudentModel> list = (List<StudentModel>) query.list();
        return list;
    }

    @Override
    public int tongsodong() {
        int dem = 0;
        DBConnection db = new DBConnection();
        Connection con = db.getConnecttion();
        String sql = "SELECT count(*) FROM student";
        if (con != null) {
            try {
                PreparedStatement ptm = con.prepareStatement(sql);
                ResultSet rs = ptm.executeQuery();
                if (rs.next()) {
                    dem = rs.getInt(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dem;
    }

    @Override
    public int editStudent(StudentModel student) {
        Session session = sessionFactory.getCurrentSession();
        if (student != null) {
            session.update(student);
            return 1;
        }
        return 0;
    }
}
