package java12.controller;

import java12.entity.Post;
import java12.service.PostService;
import java12.service.UserService;
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

    @GetMapping
    public String getAllPosts(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allPosts", postService.getAllPostsByUserId(userId));
        return "/profile";
    }

    @GetMapping("/newPost/{userId}")
    public String newPost(@PathVariable Long userId, Model model){
//        List<Post> posts = userService.findById(userId).getPosts();
        model.addAttribute("newPost", new Post());
        model.addAttribute("userId",userId);
        return "/createPost";
    }

    @PostMapping("/savePost/{userId}")
    public String savePostt(@ModelAttribute("newPost") Post post,
                            @PathVariable Long userId,String imageUrl){
        postService.createPost(userId, post);
        return "redirect:/userInfos";
    }
}
