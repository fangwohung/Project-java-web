/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Article.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author quochung
 */
@Entity
@Table(name = "taikhoan")
public class TaiKhoanModel implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private String userName;
    @Column(name = "pass")
    private String password;

    public TaiKhoanModel() {
        userName = "abc";
        password = "xyz";
    }

    public TaiKhoanModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean equals(TaiKhoanModel taikhoan) {
        if (userName.equals(taikhoan.getUserName()) && password.equals(taikhoan.getPassword())) {
            return true;
        }
        return false;
    }
}
