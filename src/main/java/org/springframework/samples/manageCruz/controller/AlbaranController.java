package org.springframework.samples.manageCruz.controller;

import java.util.List;

import javax.management.Notification;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.manageCruz.entity.Albaran;
import org.springframework.samples.manageCruz.entity.DetalleAlbaran;
import org.springframework.samples.manageCruz.service.AlbaranService;
import org.springframework.samples.manageCruz.service.DetalleAlbaranService;
import org.springframework.samples.manageCruz.service.ProductoService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albaran")
public class AlbaranController {

    private final AlbaranService albaranService;

    private final ProductoService productoService;

    private final DetalleAlbaranService detalleAlbaranService;

    public AlbaranController(AlbaranService albaranService, ProductoService productoService,
            DetalleAlbaranService detalleAlbaranService) {
        this.albaranService = albaranService;
        this.productoService = productoService;
        this.detalleAlbaranService = detalleAlbaranService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getAlbaranById(HttpServletRequest request, @PathVariable("id") int id) {

        String jwt = null;

        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
            jwt = headerAuth.substring(7, headerAuth.length());
        }

        if (jwt == null) {
            return new ResponseEntity<String>("JWT no valid to refresh", HttpStatus.BAD_REQUEST);
        }

        try {
            return ResponseEntity.ok(albaranService.findById(id));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-all-albaran")
    public ResponseEntity<?> getAllAlbaran(HttpServletRequest request) {

        String jwt = null;

        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
            jwt = headerAuth.substring(7, headerAuth.length());
        }

        if (jwt == null) {
            return new ResponseEntity<String>("JWT no valid to refresh", HttpStatus.BAD_REQUEST);
        }

        try {
            return ResponseEntity.ok(albaranService.findAll());
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<?> save(HttpServletRequest request, @RequestBody Albaran alb) {
        String jwt = null;

        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
            jwt = headerAuth.substring(7, headerAuth.length());
        }

        if (jwt == null) {
            return new ResponseEntity<String>("JWT no valid to refresh", HttpStatus.BAD_REQUEST);
        }
        try {
            Albaran albSave = albaranService.save(alb);
            return ResponseEntity.ok(albSave);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-all-productos")
    public ResponseEntity<?> getAllProductos(HttpServletRequest request) {

        String jwt = null;

        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
            jwt = headerAuth.substring(7, headerAuth.length());
        }

        if (jwt == null) {
            return new ResponseEntity<String>("JWT no valid to refresh", HttpStatus.BAD_REQUEST);
        }

        try {
            return ResponseEntity.ok(productoService.findAll());
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-producto/{nombre}")
    public ResponseEntity<?> getProdutcoById(HttpServletRequest request, @PathVariable("nombre") String nombre) {

        String jwt = null;

        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
            jwt = headerAuth.substring(7, headerAuth.length());
        }

        if (jwt == null) {
            return new ResponseEntity<String>("JWT no valid to refresh", HttpStatus.BAD_REQUEST);
        }

        try {
            return ResponseEntity.ok(productoService.findByNombre(nombre));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/new-da")
    public ResponseEntity<?> saveDA(HttpServletRequest request, @RequestBody DetalleAlbaran dAlb) {
        String jwt = null;

        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
            jwt = headerAuth.substring(7, headerAuth.length());
        }

        if (jwt == null) {
            return new ResponseEntity<String>("JWT no valid to refresh", HttpStatus.BAD_REQUEST);
        }
        try {
            DetalleAlbaran DASAVE = detalleAlbaranService.save(dAlb);
            return ResponseEntity.ok(DASAVE);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(HttpServletRequest request, @RequestBody Albaran albaran,
            @PathVariable("id") int id) {

        String jwt = null;

        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
            jwt = headerAuth.substring(7, headerAuth.length());
        }

        if (jwt == null) {
            return new ResponseEntity<String>("JWT no valid to refresh", HttpStatus.BAD_REQUEST);
        }

        try {
            albaranService.update(albaran, id);
            return ResponseEntity.ok("Updated");
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
