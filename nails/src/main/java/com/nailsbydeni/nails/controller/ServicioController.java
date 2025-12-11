package com.nailsbydeni.nails.controller;


import com.nailsbydeni.nails.dto.ServicioDto;
import com.nailsbydeni.nails.service.IServicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private IServicioService service;

    @GetMapping
    public ResponseEntity<List<ServicioDto>> getAllServicios() {
        return ResponseEntity.ok(service.findAll());
    }


   @GetMapping("/{id}")
    public ResponseEntity<ServicioDto> getServicioById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }


    @PostMapping
    public ResponseEntity<ServicioDto> createServicio(@Valid @RequestBody ServicioDto servicioDto) {
        return ResponseEntity.ok(service.save(servicioDto));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ServicioDto> updateServicio(@PathVariable Long id, @RequestBody ServicioDto servicioDto) {
        return ResponseEntity.ok(service.update(id, servicioDto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServicio(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
