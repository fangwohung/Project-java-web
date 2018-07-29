/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Article.DAO;

import Article.Model.TaiKhoanModel;

/**
 *
 * @author quochung
 */

public interface TaiKhoanDAO {
    public int checkAccount(TaiKhoanModel taikhoan);
    public int Register(TaiKhoanModel taikhoan);
    public String getPassword(TaiKhoanModel taikhoan);
}
