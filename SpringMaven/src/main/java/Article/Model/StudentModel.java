/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Article.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author quochung
 */
@Entity
@Table(name = "student")
public class StudentModel implements Serializable{

    @Id
    private int id;
    @Column(name = "Fullname")
    private String fullname;
    @Column(name = "Ngaysinh")   
    private Date ngaysinh;
    @Column(name = "gioitinh")
    private String gioitinh;
    @Column(name = "khoa")
    private String khoa;

    public StudentModel() {
    }

    public StudentModel(int id) {
        this.id = id;
    }
    
    public StudentModel(String fullname, Date ngaysinh, String gioitinh, String khoa) {
        this.fullname = fullname;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.khoa = khoa;
    }

    public StudentModel(int id, String fullname, Date ngaysinh, String gioitinh, String khoa) {
        this.id = id;
        this.fullname = fullname;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.khoa = khoa;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the ngaysinh
     */
    public Date getNgaysinh() {
        return ngaysinh;
    }

    /**
     * @param ngaysinh the ngaysinh to set
     */
    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    /**
     * @return the gioitinh
     */
    public String getGioitinh() {
        return gioitinh;
    }

    /**
     * @param gioitinh the gioitinh to set
     */
    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    /**
     * @return the khoa
     */
    public String getKhoa() {
        return khoa;
    }

    /**
     * @param khoa the khoa to set
     */
    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }
}
