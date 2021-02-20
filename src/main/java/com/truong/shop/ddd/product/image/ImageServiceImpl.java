package com.truong.shop.ddd.product.image;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl {
    private final IImageRepository repository;
    public List<Image> getAllImageByProductId(UUID productId){
        return repository.getAllByProductId(productId);
    }
    public void create(String url){
        repository.save(Image.builder()
                .url(url)
                .build());
    }
    public void deleteById(UUID uuid){
        repository.deleteById(uuid);
    }
    public void update(Image img){
        repository.save(img);
    }
}
