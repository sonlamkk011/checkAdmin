package com.example.checkadmin.controller.login;

import com.example.checkadmin.account.AccountService;
import com.example.checkadmin.entity.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private AccountService accountService;

    public LoginServlet() {
        this.accountService = new AccountService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/client/users/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = this.accountService.login(username, password);
        if (account != null) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            System.out.println("login success with username" + username);
            req.getRequestDispatcher("/client/admin/form.jsp").forward(req, resp);
        } else {
            req.setAttribute("message", "Invalid infomation");
            req.getRequestDispatcher("/client/users/login.jsp").forward(req, resp);
        }

    }

}
