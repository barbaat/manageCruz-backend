package org.springframework.samples.manageCruz.service;

import java.util.List;

import org.springframework.samples.manageCruz.entity.Albaran;
import org.springframework.samples.manageCruz.repository.AlbaranRepository;
import org.springframework.stereotype.Service;



@Service
public class AlbaranService {

    private AlbaranRepository albaranRepository;

    public AlbaranService(AlbaranRepository albaranRepository) {
        super();
        this.albaranRepository = albaranRepository;
    }

    public Albaran findById(int id) {
        return albaranRepository.findById(id);
    }

    public List<Albaran> findAll() {
        return albaranRepository.findAll();
    }

}
