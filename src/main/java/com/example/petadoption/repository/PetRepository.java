package com.example.petadoption.repository;

import com.example.petadoption.dto.PetListItemDto;
import com.example.petadoption.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

    @Query(value = """
        SELECT p.pet_id AS petId, p.name AS name, s.name AS speciesName,
               p.breed AS breed, p.age AS age, p.sex AS sex, p.size AS size,
               sh.name AS shelterName, p.admission_date AS admissionDate
        FROM pets p
        JOIN species s ON p.species_id = s.species_id
        JOIN shelters sh ON p.shelter_id = sh.shelter_id
        WHERE p.status = 'Disponible'
        """, nativeQuery = true)
    List<PetListItemDto> listarDisponibles();
    @Query("SELECT p FROM Pet p WHERE p.petId = :id")
    Pet buscarPorId(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("""
        UPDATE Pet p
        SET p.name = :name, p.breed = :breed, p.age = :age,
            p.sex = :sex, p.size = :size
        WHERE p.petId = :id
        """)
    int actualizarDatosBasicos(@Param("id") Integer id,
                               @Param("name") String name,
                               @Param("breed") String breed,
                               @Param("age") Integer age,
                               @Param("sex") String sex,
                               @Param("size") String size);
    @Modifying
    @Transactional
    @Query("UPDATE Pet p SET p.status = 'Adoptado' WHERE p.petId = :id")
    int marcarComoAdoptado(@Param("id") Integer id);

}
