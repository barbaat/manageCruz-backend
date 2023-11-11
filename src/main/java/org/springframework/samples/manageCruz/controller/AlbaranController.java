package org.springframework.samples.manageCruz.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.manageCruz.service.AlbaranService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/albaran")
public class AlbaranController {

    private final AlbaranService albaranService;

    public AlbaranController(AlbaranService albaranService) {
        this.albaranService = albaranService;
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

    @GetMapping("/get-all")
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

}
