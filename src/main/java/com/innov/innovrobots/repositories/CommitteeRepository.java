package com.innov.innovrobots.repositories;

import com.innov.innovrobots.models.Committee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommitteeRepository extends JpaRepository<Committee, Long> {
    List<Committee> findAllByEventId(Long id);

}
