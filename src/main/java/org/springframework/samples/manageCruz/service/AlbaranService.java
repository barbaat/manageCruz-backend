package org.springframework.samples.manageCruz.service;

import java.util.List;

import javax.management.Notification;

import org.springframework.samples.manageCruz.entity.Albaran;
import org.springframework.samples.manageCruz.entity.DetalleAlbaran;
import org.springframework.samples.manageCruz.repository.AlbaranRepository;
import org.springframework.stereotype.Service;

@Service
public class AlbaranService {

    private AlbaranRepository albaranRepository;

    private DetalleAlbaranService detalleAlbaranService;

    public AlbaranService(AlbaranRepository albaranRepository, DetalleAlbaranService detalleAlbaranService) {
        this.albaranRepository = albaranRepository;
        this.detalleAlbaranService = detalleAlbaranService;
    }

    public Albaran findById(int id) {
        return albaranRepository.findById(id);
    }

    public List<Albaran> findAll() {
        return albaranRepository.findAll();
    }

    public Albaran save (Albaran albaran) {
        return albaranRepository.save(albaran);
    }

    public Albaran update(Albaran alb, int id) {
        Albaran lastAlb = albaranRepository.findById(id);
        if (lastAlb != null) {
            albaranRepository.save(alb);
        }
        return lastAlb;
    }
}
