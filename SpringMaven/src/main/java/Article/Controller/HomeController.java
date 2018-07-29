/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Article.Controller;

import Article.DAO.StudentDAO;
import Article.DAO.StudentDAOImpl;
import Article.Model.StudentModel;
import Article.Service.StudentService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * x
 *
 * @author quochung
 */
@Controller
public class HomeController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/MainMenu", method = RequestMethod.GET)
    public ModelAndView showHome(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("Home");
        modelAndView.addObject("studentlist", studentService.getListStudent());
        return modelAndView;
    }

    @RequestMapping(value = "/Logout", method = RequestMethod.GET)
    public String Logout() {
        return "Logout";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    @ResponseBody
    public void addStudent(@RequestParam("Fullname") String fullname,
            @RequestParam("Datepicker") String date,
            @RequestParam("Gioitinh") String gioitinh,
            @RequestParam("Khoa") String khoa) throws ParseException {       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaysinh = sdf.parse(date);
        StudentModel student = new StudentModel(fullname, ngaysinh, gioitinh, khoa);
        int x = studentService.addStudent(student);
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.POST)
    @ResponseBody
    public void deleteStudent(@RequestParam("ID_Student") String id) {
        System.out.println("" + id);
        StudentModel student = new StudentModel(Integer.valueOf(id.trim()));
        int x = studentService.deleteStudent(student);
    }

    @RequestMapping(value = "/editStudent", method = RequestMethod.POST)
    @ResponseBody
    public void editStudent(@RequestParam("ID") String id,
            @RequestParam("Fullname") String fullname,
            @RequestParam("Datepicker") String date,
            @RequestParam("Gioitinh") String gioitinh,
            @RequestParam("Khoa") String khoa) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaysinh = sdf.parse(date);
        StudentModel student = new StudentModel(Integer.valueOf(id.trim()),fullname, ngaysinh, gioitinh, khoa);        
        int x = studentService.editStudent(student);       
    }
}
