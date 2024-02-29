package java12.controller;

import java12.entity.User;
import java12.service.UserService;
import java12.service.impl.UserSerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")

public class UserController {

    private final UserService userService;

    @GetMapping
    public String getAllUsers(Model model){
        model.addAttribute("allUsers", userService.getAllUsers());
        return "/users";
    }

    @GetMapping("/newUser")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "/userForm";
    }

    @PostMapping("/saveUser")
    public String signUpUser(@ModelAttribute("newUser") User user) {
        userService.signUp(user);
            return "/users";
    }


    @GetMapping("/login")
    public String sigIn(Model model){
        model.addAttribute("newUser", new User());
        return "/login";
    }

    @PostMapping("/signIn")
    public String logIn(@ModelAttribute("newUser") User user, Model model){
        try {
            User currentUser = userService.signIn(user);
            if (currentUser != null){
                model.addAttribute("currentUser", currentUser);
                return "/profile";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "redirect:/users";
    }

    @GetMapping("/profilePage")
    public String profileee(Model model){
        model.addAttribute("newUser", userService.findById(UserSerImpl.currentUser.getId()));
        return "/profile";
    }

    @GetMapping("/search/{userId}")
    public String search(Model model, @PathVariable Long userId){
        model.addAttribute("userId", userId);
        model.addAttribute("allUsers", userService.getAllUsers());
        return "/searchPage";
    }

    @GetMapping("/searchUser/{userId}")
    public String searchUser(Model model, @RequestParam String name, @PathVariable Long userId){
        model.addAttribute("userId", userId);
        try {
            model.addAttribute("currentUser", userService.getUserByName(name));
            return "profSearchUser";
        }catch (Exception e){
            return "redirect:/users/searchPage";
        }

    }


}
