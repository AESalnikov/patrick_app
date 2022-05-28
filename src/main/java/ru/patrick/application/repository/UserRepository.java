package ru.patrick.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.patrick.application.entity.ApplicationUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ApplicationUser, Long> {

    Optional<ApplicationUser> findByLogin(String login);

}
