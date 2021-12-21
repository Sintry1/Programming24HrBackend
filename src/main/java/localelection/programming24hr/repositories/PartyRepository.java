package localelection.programming24hr.repositories;

import localelection.programming24hr.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartyRepository extends JpaRepository<Party, Integer> {
//    Party findById(Long id);
}
