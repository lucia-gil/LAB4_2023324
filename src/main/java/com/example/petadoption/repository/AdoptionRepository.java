package com.example.petadoption.repository;

import com.example.petadoption.model.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Integer> {

    @Modifying
    @Transactional
    @Query(value = """
        INSERT INTO adoptions (adopter_id, pet_id, adoption_date, status, notes)
        VALUES (:adopterId, :petId, :adoptionDate, :status, :notes)
        """, nativeQuery = true)
    void registrarAdopcion(@Param("adopterId") Integer adopterId,
                           @Param("petId") Integer petId,
                           @Param("adoptionDate") LocalDate adoptionDate,
                           @Param("status") String status,
                           @Param("notes") String notes);

}
