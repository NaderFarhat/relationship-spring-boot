package com.relationship.relationship.Service;

import com.relationship.relationship.Model.Photo;
import com.relationship.relationship.Repository.BookRepo;
import com.relationship.relationship.Repository.PhotoRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PhotoService {
    private final PhotoRepo photoRepo;
    private final BookRepo bookRepo;

    public Photo getPhoto(Long photo_id) {
        log.info("Fetching photo {}", photo_id);
        return photoRepo.getById(photo_id);
    }

    public List<Photo> getPhotos() {
        log.info("Fetching all photos");
        return photoRepo.findAll();
    }

    public Photo savePhoto(Photo photo) {
        log.info("Saving photo {}", photo.getId());
        return photoRepo.save(photo);
    }
}
