package ru.patrick.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.patrick.application.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);

}
