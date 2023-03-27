package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.models.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {
}
