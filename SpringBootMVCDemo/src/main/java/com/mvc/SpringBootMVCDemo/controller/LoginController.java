package com.mvc.SpringBootMVCDemo.controller;

import com.mvc.SpringBootMVCDemo.entity.Employee;
import com.mvc.SpringBootMVCDemo.exception.InvalidCredentialsException;
import com.mvc.SpringBootMVCDemo.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/login")
    public String loginPage(HttpServletRequest req ){
        System.out.println(req.getMethod());
        return "login";
    }
    @GetMapping("/register")
    public String registerPage(){

        return "register";
    }
//    @PostMapping("/login")
//    public String validateEmployee (@RequestParam("email") String email,
//                                    @RequestParam("password") String password){
//        System.out.println(email+" "+password);
//        return "";
//    }

    @PostMapping("/login")
    public String validateEmployee (Employee emp, Map<String, String > errorMap, HttpSession session ){
        System.out.println(emp);
        try {
            if(employeeService.loginEmployee(emp.getEmail(), emp.getPassword())) {
                System.out.println("login sucess");
                // URL Rewriting, cookies, hidden from fields
                // HttpSession
//                return "redirect:welcome?email="+emp.getEmail();
                session.setAttribute("email", emp.getEmail());
                return "redirect:welcome";
            }
        } catch (InvalidCredentialsException e) {
            System.out.println(e.getMessage());
            errorMap.put("error", "Invalid Credentials");
        }
        return "login";
    }
    @PostMapping("/register")
    public String registerEmployee(Employee emp)
    {
        System.out.println("register "+emp);
        try {
            if(this.employeeService.insertEmployee(emp) != null) {
                System.out.println("if");
                return "redirect:login";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("error ***********"+e.getMessage());
            return "redirect:register";
        }
        System.out.println("out ***********");
        return "redirect:register";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpSession session)
    {
        session.removeAttribute("email");
        session.invalidate();
        return "redirect:login";
    }



}
