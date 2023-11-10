package org.springframework.samples.manageCruz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.manageCruz.dto.SigninRequestDTO;
import org.springframework.samples.manageCruz.dto.SigninResponseDTO;
import org.springframework.samples.manageCruz.entity.User;
import org.springframework.samples.manageCruz.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/signin")
    public ResponseEntity<?> token(HttpServletRequest request, @Valid @RequestBody SigninRequestDTO loginRequest) {

        try {
            SigninResponseDTO token = userService.authenticateUser(loginRequest);
            User user = userService.findByUsername(loginRequest.getUsername());
            if (user == null) {
                LOG.error("Cannot find the account: {}", loginRequest.getUsername());
                return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);
            } else {
                LOG.info("User logged with username {}:", loginRequest.getUsername());
                HttpHeaders headers = new HttpHeaders();
                headers.setBearerAuth(token.getToken());
                return new ResponseEntity<User>(user, headers, HttpStatus.OK);
            }
        } catch (Exception e) {
            LOG.error("Cannot find the account: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/token")
    public ResponseEntity<String> authenticateUser(HttpServletRequest request,
            @Valid @RequestBody SigninRequestDTO loginRequest) {


        try {
            SigninResponseDTO tokenResponse = userService.authenticateUser(loginRequest);
            String token = tokenResponse.getToken();
            User user = userService.findByUsername(loginRequest.getUsername());
            if (user == null) {
                LOG.error("Cannot find the account: {}", loginRequest.getUsername());
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else if (!user.getPassword().equals(loginRequest.getPassword())) {
                LOG.error("Password incorrect: {}", loginRequest.getUsername());
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                LOG.info("User loged with username {}:", loginRequest.getUsername());
                return new ResponseEntity<String>(token, HttpStatus.OK);
            }

        } catch (Exception e) {
            LOG.error("Cannot find the account: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

}
