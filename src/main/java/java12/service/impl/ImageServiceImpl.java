package java12.service.impl;

import java12.entity.Image;
import java12.repo.ImageRepo;
import java12.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepo imageRepo;

    @Override
    public void save(Long postId, Image image) {
        imageRepo.save(postId, image);
    }
}
