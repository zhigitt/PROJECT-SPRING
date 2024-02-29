package java12.controller;

import java12.entity.Post;
import java12.service.PostService;
import java12.service.UserService;
import java12.service.impl.UserSerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")

public class PostController {

    private final PostService postService;
    private final UserService userService;

    @GetMapping("/myPost/{userId}")
    public String getAllPosts(@PathVariable Long userId, Model model) {
        model.addAttribute("allPosts", postService.getAllPostsByUserId(UserSerImpl.currentUser.getId()));
        return "/myPosts";
    }

    @GetMapping("/posts")
    public String getAllPostsByUserId(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allPosts", postService.getAllPostsByUserId(UserSerImpl.currentUser.getId()));
        return "/profile";
    }

    @GetMapping("/allPostsL")
    public String getAllPosts(Model model) {
        model.addAttribute("allPostsLenta", postService.getAllPosts());
        return "/lenta";
    }

    @GetMapping("/newPost/{userId}")
    public String newPost(@PathVariable Long userId, Model model){
        model.addAttribute("newPost", new Post());
        model.addAttribute("userId",userId);
        return "/createPost";
    }

    @PostMapping("/savePost/{userId}")
    public String savePostt(@ModelAttribute("newPost") Post post,
                            @PathVariable Long userId){
        postService.createPost(userId, post);
        return "redirect:/"+post.getId()+"/image/new";
    }
}
