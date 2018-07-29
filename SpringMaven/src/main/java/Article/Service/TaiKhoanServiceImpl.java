/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Article.Service;

import Article.DAO.TaiKhoanDAO;
import Article.Model.TaiKhoanModel;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author quochung
 */
@Service
@Transactional
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    private TaiKhoanDAO taiKhoanDAO;

    @Override
    public int checkAccount(TaiKhoanModel taikhoan) {
        return taiKhoanDAO.checkAccount(taikhoan);
    }

    @Override
    public int Register(TaiKhoanModel taikhoan) {
        return taiKhoanDAO.Register(taikhoan);
    }

    @Override
    public String getPassword(TaiKhoanModel taikhoan) {
        return taiKhoanDAO.getPassword(taikhoan);
    }
}
