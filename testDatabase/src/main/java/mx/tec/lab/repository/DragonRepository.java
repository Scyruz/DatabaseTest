package mx.tec.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.tec.lab.entity.Dragon;

@Repository
public interface DragonRepository extends JpaRepository<Dragon, Long> {

}
