/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author quochung
 */
import java.util.Date;

public class Student {
    private int id;
    private String fullname;
    private Date ngaysinh;
    private String gioitinh;
    private String khoa;

    public Student() {
    }

    public Student(String fullname, Date ngaysinh, String gioitinh, String khoa) {
        this.fullname = fullname;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.khoa = khoa;
    }

    
    public Student(int id, String fullname, Date ngaysinh, String gioitinh, String khoa) {
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

