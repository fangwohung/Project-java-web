/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Article.DAO;

import Article.DB.DBConnection;
import Article.Model.TaiKhoanModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author quochung
 */
@Repository
@Transactional
public class TaiKhoanDAOImpl implements TaiKhoanDAO {

    private static final long serialVersionUID = 1L;
    
    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Override
    public int Register(TaiKhoanModel taikhoan) {
        Session session = sessionFactory.getCurrentSession();
        String check = (String)session.save(taikhoan);
        if(check != null)
            return 1;
        return 0;
    }

    @Override
    public int checkAccount(TaiKhoanModel taikhoan) {
        Session session = sessionFactory.getCurrentSession();
        TaiKhoanModel tk = (TaiKhoanModel) session.get(TaiKhoanModel.class, taikhoan.getUserName());
        if (tk != null && tk.equals(taikhoan)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String getPassword(TaiKhoanModel taikhoan) {
        String pw = "";
        Session session = sessionFactory.getCurrentSession();
        TaiKhoanModel tk = (TaiKhoanModel) session.get(TaiKhoanModel.class, taikhoan.getUserName());
        pw = tk.getPassword();
        return pw;
    }
}
