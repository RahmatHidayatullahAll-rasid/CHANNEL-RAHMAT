package com.example.CHANNEL_RAHMAT.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.CHANNEL_RAHMAT.dto.NasabahRequest;
import com.example.CHANNEL_RAHMAT.dto.NasabahResponse;
import com.example.CHANNEL_RAHMAT.entity.Nasabah;
import com.example.CHANNEL_RAHMAT.repository.NasabahRepository;

@Service 
public class NasabahService {

    private final NasabahRepository nasabahRepository;

    public NasabahService(NasabahRepository nasabahRepository) {
        this.nasabahRepository = nasabahRepository;
    }


    public NasabahResponse createNasabah(NasabahRequest request) {
        if (nasabahRepository.findByNoKtp(request.getNoKtp()).isPresent()) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Nomor KTP Sudah Terdaftar!"
            );
        }

        Nasabah nasabah = new Nasabah();
        
        nasabah.setNamaLengkap(request.getNamaLengkap());
        nasabah.setAlamat(request.getAlamat());
        nasabah.setTempatLahir(request.getTempatLahir());
        nasabah.setTanggalLahir(request.getTanggalLahir());
        nasabah.setNoKtp(request.getNoKtp());
        nasabah.setNoHp(request.getNoHp());

        Nasabah savedNasabah = nasabahRepository.save(nasabah);

        return convertToResponse(savedNasabah);
        
    }

    public NasabahResponse getNasabahByNoKtp(Long noKtp) {
        Nasabah nasabah = nasabahRepository.findByNoKtp(noKtp)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Nasabah Tidak Ditemukan!"
            ));

        return convertToResponse(nasabah);
    }

    public List<NasabahResponse> getAllNasabah() {
        List<Nasabah> nasabahList = nasabahRepository.findAll();

        return nasabahList.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public NasabahResponse updateNasabah(
        Long id,
        NasabahRequest request
    ) {
        Nasabah nasabah = nasabahRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Nasabah Tidak Ditemukan!"
            ));

            if (!nasabah.getNoKtp().equals(request.getNoKtp())) {
                boolean ktpExists = nasabahRepository
                    .findByNoKtp(request.getNoKtp())
                    .isPresent();

                    if (ktpExists) {
                        throw new ResponseStatusException(
                            HttpStatus.CONFLICT,
                            "Nomor KTP Sudah Digunakan!"
                        );
                    }
            }

            nasabah.setNamaLengkap(request.getNamaLengkap());
            nasabah.setAlamat(request.getAlamat());
            nasabah.setTempatLahir(request.getTempatLahir());
            nasabah.setTanggalLahir(request.getTanggalLahir());
            nasabah.setNoKtp(request.getNoKtp());
            nasabah.setNoHp(request.getNoHp());

            Nasabah updatedNasabah = nasabahRepository.save(nasabah);

            return convertToResponse(updatedNasabah);
    }
    
    public NasabahResponse getNasabahById(Long id) {
    Nasabah nasabah = nasabahRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Nasabah dengan ID " + id + " tidak ditemukan"
            ));

    return convertToResponse(nasabah);
    }

    public void deleteNasabah(Long id) {
        Nasabah nasabah = nasabahRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Nasabah Tidak Ditemukan!"
            ));

        nasabahRepository.delete(nasabah);
    }

    

    private NasabahResponse convertToResponse(Nasabah nasabah) {
        NasabahResponse response = new NasabahResponse();
        response.setId(nasabah.getId());
        response.setNamaLengkap(nasabah.getNamaLengkap());
        response.setAlamat(nasabah.getAlamat());
        response.setTempatLahir(nasabah.getTempatLahir());
        response.setTanggalLahir(nasabah.getTanggalLahir());
        response.setNoKtp(nasabah.getNoKtp());
        response.setNoHp(nasabah.getNoHp());
        response.setCreatedAt(nasabah.getCreatedAt());

        return response;
    }
    
}
