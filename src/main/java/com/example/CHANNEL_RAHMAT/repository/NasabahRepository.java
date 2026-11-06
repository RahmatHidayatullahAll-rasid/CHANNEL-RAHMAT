package com.example.CHANNEL_RAHMAT.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CHANNEL_RAHMAT.entity.Nasabah;

@Repository
public interface NasabahRepository extends JpaRepository<Nasabah, Long> {

    Optional<Nasabah> findByNoKtp(Long noKtp);
}
