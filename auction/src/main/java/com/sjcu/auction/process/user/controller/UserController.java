package com.sjcu.auction.process.user.controller;

import com.sjcu.auction.process.user.domain.entity.User;
import com.sjcu.auction.process.user.domain.request.UserCreateRequest;
import com.sjcu.auction.process.user.domain.request.UserModRequest;
import com.sjcu.auction.process.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/v1/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "user/list";
    }

    @GetMapping("/v1/users/save")
    public String saveUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/saveForm";
    }

    @PostMapping("/v1/users/save")
    public String saveUser(@ModelAttribute UserCreateRequest request) {
        userService.saveUser(request.toEntity());

        return "redirect:/v1/users";
    }

    @GetMapping("/v1/users/update/{userId}")
    public String updateUserForm(Model model, @PathVariable(name = "userId") Long userId) {
        model.addAttribute("user", userService.findUserById(userId));

        return "user/updateForm";
    }

    @PostMapping("/v1/users/update/{userId}")
    public String updateUser(@PathVariable(name = "userId") Long userId, @ModelAttribute UserModRequest request) {
        userService.updateUser(userId, request.toEntity());

        return "redirect:/v1/users";
    }

    @GetMapping("/v1/users/delete/{userId}")
    public String deleteUser(@PathVariable(name = "userId") Long userId) {
        userService.deleteUser(userId);

        return "redirect:/v1/users";
    }

}
