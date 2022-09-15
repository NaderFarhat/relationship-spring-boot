package com.relationship.relationship.Controller;


import com.relationship.relationship.Model.Photo;
import com.relationship.relationship.Service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService photoService;

    @GetMapping("/photos")
    public ResponseEntity<List<Photo>> getPhotos() {
        return ResponseEntity.ok().body(photoService.getPhotos());
    }

    @PostMapping("/photo/save")
    public ResponseEntity<Photo> saveUser(@RequestBody Photo photo) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/photo/save").toUriString());
        return ResponseEntity.created(uri).body(photoService.savePhoto(photo));
    }

}
