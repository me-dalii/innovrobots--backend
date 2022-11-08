package com.innov.innovrobots.repositories;

import com.innov.innovrobots.models.CustomFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomFileRepository extends JpaRepository<CustomFile, Long> {
}
