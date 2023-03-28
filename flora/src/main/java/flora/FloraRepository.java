package flora;

import org.springframework.data.jpa.repository.JpaRepository;

interface FloraRepository extends JpaRepository<Flora, Long> {
    
}
