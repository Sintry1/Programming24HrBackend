package localelection.programming24hr.services;

import localelection.programming24hr.entities.Candidate;
import localelection.programming24hr.repositories.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {


    CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidate findById(int id){
        return candidateRepository.findCandidateById(id);
    }

    public Iterable<Candidate> findAllCandidates() {
        return candidateRepository.findAll();
    }

//    public List<Candidate> findCandidatesByParty(String party){
//        return candidateRepository.findCandidatesByPartyAllegiance(party);
//    }

    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public List<Candidate> findCandidateByName(String name){
        return candidateRepository.findCandidateByFirstName(name);
    }

    public void removeCandidate(Candidate candidate){
        candidateRepository.deleteCandidateById(candidate.getId());
    }
}
