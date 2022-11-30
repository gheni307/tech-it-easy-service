package nl.novi.techiteasyserviceanddto.serviceanddto.controller;

import nl.novi.techiteasyserviceanddto.serviceanddto.dto.TelevisionDto;
import nl.novi.techiteasyserviceanddto.serviceanddto.service.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService service;
    TelevisionController(TelevisionService s){
        this.service = s;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<TelevisionDto>> getTelevisions(){
        return ResponseEntity.ok(service.getTelevisions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable Long id){
        TelevisionDto televisionId = service.getTelevision(id);
        return ResponseEntity.ok(televisionId);
    }

    @PostMapping("")
    public ResponseEntity<String> createTelevision(@RequestBody TelevisionDto televisionDto){
        Long createId = service.createTelevision(televisionDto);

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/televisions/" + createId).toUriString());
        return ResponseEntity.created(uri).body("Television created!");
    }

}
