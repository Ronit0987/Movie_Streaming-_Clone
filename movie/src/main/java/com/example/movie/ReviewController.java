package com.example.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/revs")
public class ReviewController {

    @Autowired
    private ReviewService revser;

    @PostMapping
    public ResponseEntity<Reviews> createrev(@RequestBody Map<String,String>payload){
    return new ResponseEntity<Reviews>(revser.createReview(payload.get("reviewBody"),payload.get("imdbId")), HttpStatus.CREATED);
    }
}
