package org.springframework.samples.manageCruz.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.manageCruz.entity.User;
import org.springframework.samples.manageCruz.entity.UserDTO;
import org.springframework.samples.manageCruz.entity.types.City;
import org.springframework.samples.manageCruz.entity.types.RolUser;
import org.springframework.samples.manageCruz.entity.types.Gender;
import org.springframework.samples.manageCruz.service.UserService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> save(HttpServletRequest request, @RequestBody User user) {
        String jwt = null;

        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
            jwt = headerAuth.substring(7, headerAuth.length());
        }

        if (jwt == null) {
            return new ResponseEntity<String>("JWT no valid to refresh", HttpStatus.BAD_REQUEST);
        }
        try {
            logger.info("Starting to save user with name={}", user.getName());
            User userSave = userService.saveUser(user);
            logger.info("Course saved with name = {}", userSave.getName());
            return ResponseEntity.ok(userSave);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{username}")
    public ResponseEntity<?> getUserById(HttpServletRequest request, @PathVariable("username") String username) {

        String jwt = null;

        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
            jwt = headerAuth.substring(7, headerAuth.length());
        }

        if (jwt == null) {
            return new ResponseEntity<String>("JWT no valid to refresh", HttpStatus.BAD_REQUEST);
        }

        try {
            User user = userService.findByUsername(username);
            UserDTO userDTO = user.toDTO();
            return ResponseEntity.ok(userDTO);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/cities")
    public City[] getCiudades() {
         return City.values();
    }

    @GetMapping("/roles")
    public RolUser[] getRoles() {
        return RolUser.values();
    }

    @GetMapping("/gender")
    public Gender[] getRender() {
        return Gender.values();
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getUsers(HttpServletRequest request) {
        String jwt = null;

        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
            jwt = headerAuth.substring(7, headerAuth.length());
        }

        if (jwt == null) {
            return new ResponseEntity<String>("JWT no valid to refresh", HttpStatus.BAD_REQUEST);
        }

        try {
            List<User> lista = userService.findAll();
            return ResponseEntity.ok(lista.stream().map(User::toDTO).toList());
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/logged")
    public ResponseEntity<?> getUserLogeado(HttpServletRequest request, Principal principal) {

        String jwt = null;

        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
            jwt = headerAuth.substring(7, headerAuth.length());
        }

        if (jwt == null) {
            return new ResponseEntity<String>("JWT no valid to refresh", HttpStatus.BAD_REQUEST);
        }

        try {
            String userString = principal.getName();
            int usernameIndex = userString.indexOf("username=");
            int spaceIndex = userString.indexOf(" ", usernameIndex);
            String username = userString.substring(usernameIndex + 9, spaceIndex - 1);
            User user = userService.findByUsername(username);
            UserDTO userDTO = user.toDTO();
            return ResponseEntity.ok(userDTO);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(HttpServletRequest request, @PathVariable("id") int id) {

        String jwt = null;

        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
            jwt = headerAuth.substring(7, headerAuth.length());
        }

        if (jwt == null) {
            return new ResponseEntity<String>("JWT no valid to refresh", HttpStatus.BAD_REQUEST);
        }

        try {
            userService.deleteById(id);
            return ResponseEntity.ok("User deleted");
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(HttpServletRequest request, @RequestBody User user, @PathVariable("id") int id) {

        String jwt = null;

        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer")) {
            jwt = headerAuth.substring(7, headerAuth.length());
        }

        if (jwt == null) {
            return new ResponseEntity<String>("JWT no valid to refresh", HttpStatus.BAD_REQUEST);
        }

        try {
            userService.updateUser(user, id);
            return ResponseEntity.ok("User updated");
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
