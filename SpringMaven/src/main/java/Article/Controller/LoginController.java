/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Article.Controller;

import Article.Model.TaiKhoanModel;
import Article.Service.TaiKhoanService;
import Article.Service.TaiKhoanServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author quochung
 */
@Controller
public class LoginController {

    @Autowired
    TaiKhoanService taiKhoanService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("Login");
        Cookie[] cookies = request.getCookies();
        String id = "", pass = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("id")) {
                    id = cookie.getValue();
                } else if (cookie.getName().equals("pass")) {
                    pass = cookie.getValue();
                } else {

                }
                System.out.println(cookie.getValue());
            }
            modelAndView.addObject("id", id);
            modelAndView.addObject("pass", pass);
        }
        TaiKhoanModel taiKhoanModel = new TaiKhoanModel();
        modelAndView.addObject("taikhoan", taiKhoanModel);
        return modelAndView;
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView submitLogin(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "remember-me", required = false) String checkboxValue,
            @ModelAttribute("taikhoan") TaiKhoanModel taiKhoanModel) {
        ModelAndView modelAndView = null;
        int check = taiKhoanService.checkAccount(taiKhoanModel);
        if (check != 0) {
            HttpSession session = request.getSession(true);
            session.setAttribute("id", "admin");
            if (checkboxValue != null) {
                Cookie ID_cookie = new Cookie("id", taiKhoanModel.getUserName());
                Cookie pass_cookie = new Cookie("pass", taiKhoanModel.getPassword());
                ID_cookie.setMaxAge(24 * 60 * 60);
                pass_cookie.setMaxAge(24 * 60 * 60);
                response.addCookie(ID_cookie);
                response.addCookie(pass_cookie);
                System.out.println("Checked");

            } else {
                System.out.println("not checked");

            }
            modelAndView = new ModelAndView("redirect:/MainMenu");
        } else {
            modelAndView = new ModelAndView("Login");
            modelAndView.addObject("taikhoan", new TaiKhoanModel());
            modelAndView.addObject("msg", "Tên tài khoản hoặc mật khẩu sai");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public ModelAndView showReg() {
        ModelAndView modelAndView = new ModelAndView("Register");
        TaiKhoanModel taiKhoanModel = new TaiKhoanModel();
        modelAndView.addObject("taikhoan", taiKhoanModel);
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView Register(HttpServletRequest request, @ModelAttribute("taikhoan") TaiKhoanModel taiKhoanModel) {
        ModelAndView modelAndView = null;
        int check = taiKhoanService.Register(taiKhoanModel);
        if (check != 0) {
            modelAndView = new ModelAndView("Login");
            modelAndView.addObject("msg", "Đăng ký thành công!");
        } else {
            modelAndView = new ModelAndView("Register");
            modelAndView.addObject("taikhoan", new TaiKhoanModel());
            modelAndView.addObject("msg", "Đăng ký thất bại");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/forgetpw", method = RequestMethod.GET)
    public ModelAndView showForgetpw() {
        ModelAndView modelAndView = new ModelAndView("Forgetpassword");      
        return modelAndView;
    }
    

    @RequestMapping(value = "/showpw", method = RequestMethod.POST)
    @ResponseBody
    public void Showpassword(@RequestParam("Username") String username,ModelMap  model) {        
        TaiKhoanModel tk = new TaiKhoanModel();
        tk.setUserName(username);
        String pw = taiKhoanService.getPassword(tk);
        model.addAttribute("password", "Your password is: " +pw);      
    }
}
