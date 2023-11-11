package org.springframework.samples.manageCruz.service;

import org.springframework.samples.manageCruz.entity.DetalleAlbaran;
import org.springframework.samples.manageCruz.repository.DetalleAlbaranRepository;
import org.springframework.stereotype.Service;

@Service
public class DetalleAlbaranService {

    private DetalleAlbaranRepository detalleAlbaranService;

    public DetalleAlbaranService(DetalleAlbaranRepository detalleAlbaranService) {
        super();
        this.detalleAlbaranService = detalleAlbaranService;
    }

    public DetalleAlbaran save (DetalleAlbaran albaran) {
        return detalleAlbaranService.save(albaran);
    }

}
