package com.example.CHANNEL_RAHMAT.dto;

import java.time.LocalDate;

public class NasabahRequest {

    private String namaLengkap;
    private String alamat;
    private String tempatLahir;
    private LocalDate tanggalLahir;
    private Long noKtp;
    private String noHp;


    public NasabahRequest() {

    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public String getAlamat() {
        return alamat;
    }

    private void setAlamat(String alamat) {
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

}
