package org.springframework.samples.manageCruz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.manageCruz.entity.User;
import org.springframework.samples.manageCruz.entity.types.RolUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u=?1")
    User findUser (User user);

    @Query("SELECT u FROM User u WHERE u.rolUser = ?1")
    List<User> findByRolUser(RolUser rolUser);
}
