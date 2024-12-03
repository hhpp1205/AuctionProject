package com.sjcu.auction.process.user.controller;

import com.sjcu.auction.process.user.domain.entity.User;
import com.sjcu.auction.process.user.domain.request.UserLoginRequest;
import com.sjcu.auction.process.user.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/v1/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "user/login";
    }

    @PostMapping("/v1/login")
    public String login(@ModelAttribute("user") UserLoginRequest request, HttpSession session) {
        User user = request.toEntity();
        if (loginService.login(user)) {
            session.setAttribute("user", user);
            return "redirect:/v1/users";
        } else {
            return "redirect:/v1/login";
        }
    }

    @GetMapping("v1/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/v1/login";
    }


}
