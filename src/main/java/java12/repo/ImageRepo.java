package java12.repo;

import java12.entity.Image;

public interface ImageRepo {
    Image createImage(String image);

    void save(Long postId, Image image);
}
