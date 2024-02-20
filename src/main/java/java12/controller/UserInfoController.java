package java12.controller;

import java12.entity.UserInfo;
import java12.service.UserInfoService;
import java12.service.UserService;
import java12.service.impl.UserSerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/userInfos")
public class UserInfoController {

    private final UserInfoService userInfoService;
    private final UserService userService;

//    @GetMapping
//    public String getAllUserInfo(Model model){
//        model.addAttribute("allUserInfos", userInfoService);
//        return "/userInfos";
//    }
    @GetMapping
    public String oftenProfile(Model model){
        model.addAttribute("currentUser", userService.getUserById(UserSerImpl.currentUser.getId()));
        return "/profile";
    }

    @GetMapping("/newUserInfo/{userId}")
    public String createNewInfo(@PathVariable Long userId, Model model) {
        UserInfo userInfo = userService.findById(userId).getUserInfo();
        model.addAttribute("foundUserInfo", userInfo);
        // изменено на "userInfo"
        return "/editProfil";
    }

    @PostMapping("/saveUserInfo/{userInfoId}")
    public String updateUserInfo(@ModelAttribute("foundUserInfo") UserInfo userInfo,
                                 @PathVariable Long userInfoId) {
        userInfoService.updateUserInfo(userInfoId, userInfo);
        return "redirect:/userInfos";
    }
}
