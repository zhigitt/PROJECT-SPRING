package java12.service;

import java12.entity.Image;

public interface ImageService {
    void save(Long postId, Image image);
}
