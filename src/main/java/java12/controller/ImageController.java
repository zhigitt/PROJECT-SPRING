package java12.controller;

import java12.entity.Image;
import java12.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/{postId}/image")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping("/new")
    String newImage(Model model, @PathVariable Long postId){
        model.addAttribute("newImage", new Image());
        return "/image/new-image";
    }

    @PostMapping("/save")
    String saveImage(@PathVariable Long postId, Image image){
        imageService.save(postId, image);
        return "redirect:/userInfos";
    }

}
