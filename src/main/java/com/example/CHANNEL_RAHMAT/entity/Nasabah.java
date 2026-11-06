package com.example.CHANNEL_RAHMAT.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "nasabah")
public class Nasabah {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nama_lengkap", nullable = false, length = 150)
    private String namaLengkap;

    @Column (name = "alamat", nullable = false, length = 300)
    private String alamat;

    @Column (name = "tempat_lahir", nullable = false, length = 100)
    private String tempatLahir;

    @Column (name = "tanggal_lahir", nullable = false, length = 10)
    private LocalDate tanggalLahir;

    @Column (name = "no_ktp", nullable = false, length = 16)
    private Long noKtp;

    @Column (name = "no_hp", nullable = false, length = 15)
    private String noHp;

    @Column (name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Nasabah() {

    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public LocalDate getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(LocalDate tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public Long getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(Long noKtp) {
        this.noKtp = noKtp;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
