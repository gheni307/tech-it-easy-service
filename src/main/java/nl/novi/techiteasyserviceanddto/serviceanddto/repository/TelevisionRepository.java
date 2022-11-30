package nl.novi.techiteasyserviceanddto.serviceanddto.repository;

import nl.novi.techiteasyserviceanddto.serviceanddto.model.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
    List<Television> findAllTelevisionsByBrandEqualsIgnoreCase(String brand);
}
