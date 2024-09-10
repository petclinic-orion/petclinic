package org.springframework.samples.petclinic.math;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MathOperationRepository extends JpaRepository<MathOperation, Long> {

}
