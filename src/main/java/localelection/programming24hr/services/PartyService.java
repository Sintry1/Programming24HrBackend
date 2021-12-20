package localelection.programming24hr.services;

import localelection.programming24hr.entities.Candidate;
import localelection.programming24hr.entities.Party;
import localelection.programming24hr.repositories.PartyRepository;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class PartyService {


    PartyRepository partyRepository;

    public PartyService(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    public Party findById(Long id){
        return partyRepository.findPartyById(id);
    }

    public Set<Candidate> getPartyMembers(Party party){
        Set<Candidate> partyMembers;
        partyMembers = party.getCandidates();
        return partyMembers;
    }

    public Iterable<Party> getAll(){
        return partyRepository.findAll();
    }

    public Party save(Party party){
        return partyRepository.save(party);
    }

}
