package com.baosi.ssm.service;

import com.baosi.ssm.domain.Honor;

import java.util.List;

public interface IHonorService {

    List<Honor> findAll(int page, int size);

    List<Honor> findAll();

    void save(Honor honor);

    Honor findById(int id);

    void deleteImageById(int id);
}
