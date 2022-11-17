package com.innov.innovrobots.repositories;

import com.innov.innovrobots.models.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Long> {
    List<Sponsor> findAllByEventId(Long id);
}
