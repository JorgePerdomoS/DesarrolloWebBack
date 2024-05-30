package com.poli.project.rh.persistent;

import com.poli.project.rh.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserDocument, String> {

    Optional<UserDocument> findByEmailAndPassword(String email, String password);

    Optional<UserDocument> findByEmail(String email);
}
