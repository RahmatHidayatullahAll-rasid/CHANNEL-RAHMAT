package com.example.CHANNEL_RAHMAT.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CHANNEL_RAHMAT.dto.NasabahRequest;
import com.example.CHANNEL_RAHMAT.dto.NasabahResponse;
import com.example.CHANNEL_RAHMAT.service.NasabahService;

@RestController 
@RequestMapping("/api/nasabah")
public class NasabahController {

    private final NasabahService nasabahService;

    public NasabahController(NasabahService nasabahService) {
        
        this.nasabahService = nasabahService;
    }

    @PostMapping
    public ResponseEntity<NasabahResponse> createNasabah(
            @RequestBody NasabahRequest request) {
                
                NasabahResponse response = nasabahService.createNasabah(request);
                
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/ktp/{noKtp}")
    public ResponseEntity<NasabahResponse> getNasabahByNoKtp(@PathVariable Long noKtp){
        
        NasabahResponse response = nasabahService.getNasabahByNoKtp(noKtp);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<NasabahResponse>> getAllNasabah() {
        List<NasabahResponse> responseList = nasabahService.getAllNasabah();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id}") 
    public ResponseEntity<NasabahResponse> getNasabahById(
        @PathVariable Long id) {

    NasabahResponse response = nasabahService.getNasabahById(id);

    return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNasabah(@PathVariable Long id) {

        nasabahService.deleteNasabah(id);

        return ResponseEntity.noContent().build();
    }
}
