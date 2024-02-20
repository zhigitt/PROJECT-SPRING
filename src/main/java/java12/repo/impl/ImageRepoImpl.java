package java12.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java12.entity.Image;
import java12.repo.ImageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Transactional
@RequiredArgsConstructor
@Repository

public class ImageRepoImpl implements ImageRepo {

    @PersistenceContext
    private final EntityManager entityManager;


    @Override
    public Image createImage(String image) {
        Image image1 = new Image();
        image1.setImageUrl(image);
        entityManager.persist(image1);
        return image1;
    }
}
