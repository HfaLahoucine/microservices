package com.ecommerce.microserviceproduits.repository;
import com.ecommerce.microserviceproduits.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends  JpaRepository<Voiture, Long> {
}
