package localelection.programming24hr.services;

import localelection.programming24hr.entities.Party;
import localelection.programming24hr.repositories.PartyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class PartyService {


    PartyRepository partyRepository;

    public PartyService(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    public Party findById(int id){
        return partyRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No party found for ID: " + id));
    }

    public Iterable<Party> getAll(){
        return partyRepository.findAll();
    }

//    public Party save(Party party){
//        return partyRepository.saveAndFlush(party);
//    }

}
