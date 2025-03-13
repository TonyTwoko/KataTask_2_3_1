package springCourse.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springCourse.service.UserService;
import springCourse.model.User;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String hello() {
        return "hello_world";
    }

    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "index";
    }

    @GetMapping("/show")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/users")
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PatchMapping("/update")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult, @RequestParam("id") int id) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userService.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
