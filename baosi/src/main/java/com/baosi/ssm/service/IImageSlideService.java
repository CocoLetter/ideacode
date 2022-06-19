package com.baosi.ssm.service;

import com.baosi.ssm.domain.ImageSlide;

import java.util.List;

public interface IImageSlideService {

    List<ImageSlide> findAll(int page, int size);

    List<ImageSlide> findAll();

    void save(ImageSlide imageSlide);

    ImageSlide findById(int id);

    void deleteImageById(int id);

    void unlockById(int[] arr);

    void lockById(int[] arr);
}
