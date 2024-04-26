package com.example.movie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private RevRepo revrespo;

    @Autowired
    private MongoTemplate mongotemp;
    public Reviews createReview(String reviewBody,String imdbId){
    Reviews rev =new Reviews(reviewBody);
    revrespo.insert(rev);
     mongotemp.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId)).apply(new Update().push("reviewIds").value(rev));
     return  rev;
    }
}
