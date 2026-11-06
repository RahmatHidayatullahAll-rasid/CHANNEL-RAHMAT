package com.example.CHANNEL_RAHMAT.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NasabahResponse {

    private Long id;
    private String namaLengkap;
    private String alamat;
    private String tempatLahir;
    private LocalDate tanggalLahir;
    private Long noKtp;
    private String noHp;
    private LocalDateTime createdAt;

    public NasabahResponse() {
        
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
