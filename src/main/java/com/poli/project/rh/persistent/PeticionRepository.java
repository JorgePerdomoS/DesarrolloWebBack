package com.poli.project.rh.persistent;

import com.poli.project.rh.document.PeticionDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeticionRepository extends MongoRepository<PeticionDocument, String> {
}
