package org.springframework.samples.manageCruz.service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.samples.manageCruz.dto.SigninRequestDTO;
import org.springframework.samples.manageCruz.dto.SigninResponseDTO;
import org.springframework.samples.manageCruz.entity.User;
import org.springframework.samples.manageCruz.entity.types.RolUser;
import org.springframework.samples.manageCruz.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    private TokenService tokenService;

    public UserService(TokenService tokenService, UserRepository userRepository) {
        super();
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        Random rand = new Random();
        user.setId(rand.nextInt(1000));
        if (user.getAvatar() == "") {
            user.setAvatar("https://www.pngall.com/wp-content/uploads/12/Avatar-Profile-PNG-Images.png");
        }
        logger.info("Starting to save user with name={}", user.getUsername());
        try {
            logger.info("Saving user with name={}", user.getUsername());
            User userSave = userRepository.save(user);
            return userSave;
        } catch (Exception e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }

    public SigninResponseDTO authenticateUser(SigninRequestDTO userDto) {
        User user = userRepository.findByUsername(userDto.getUsername());

        if (user != null && user.getPassword().equals(userDto.getPassword())) {
            Authentication authentication = new UsernamePasswordAuthenticationToken(user, null,
                    Collections.emptyList());
            String token = tokenService.generateToken(authentication);
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(token);
            return new SigninResponseDTO(token);
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    public void deleteById(int id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public User updateUser(User user, int id) {
        User userToUpdate = userRepository.findById(id).get();
        if (userToUpdate != null) {
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setTelephone(user.getTelephone());
            userToUpdate.setName(user.getName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setCity(user.getCity());
            userToUpdate.setGender(user.getGender());
            userToUpdate.setAvatar(user.getAvatar());
            if (user.getAvatar() == "") {
                userToUpdate.setAvatar("https://www.pngall.com/wp-content/uploads/12/Avatar-Profile-PNG-Images.png");
            }
            userRepository.save(userToUpdate);
        }
        return userToUpdate;
    }

    public List<User> findByRolUser(RolUser rolUser) {
        return userRepository.findByRolUser(rolUser);
    }

}
