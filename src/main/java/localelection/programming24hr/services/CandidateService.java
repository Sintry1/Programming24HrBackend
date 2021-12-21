package localelection.programming24hr.services;

import localelection.programming24hr.entities.Candidate;
import localelection.programming24hr.entities.Party;
import localelection.programming24hr.repositories.CandidateRepository;
import localelection.programming24hr.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    private final PartyRepository partyRepository;
    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(PartyRepository partyRepository, CandidateRepository candidateRepository) {
        this.partyRepository = partyRepository;
        this.candidateRepository = candidateRepository;
    }

    public Candidate findById(Long id){
        return candidateRepository.findCandidateById(id);
    }

    public List<Candidate> findAllCandidates() {
        return candidateRepository.findAll();
    }

//    public List<Candidate> findAllPartyCandidates(Long partyId) {
//        return candidateRepository.findCandidateByPartyId(partyId);
//    }

    public List<Candidate> findCandidatesByParty(Long id){
        return candidateRepository.findCandidateByPartyId(id);
    }

    public Candidate editCandidate(Long id) {
        Candidate candidate = candidateRepository.findCandidateById(id);
        Party party = partyRepository.findById(candidate.getParty().getId());

        candidate.setFirstName(candidate.getFirstName());
        candidate.setSurname(candidate.getSurname());
        candidate.setYearsExperience(candidate.getYearsExperience());
        candidate.setParty(party);
        return candidateRepository.save(candidate);
    }

    public Candidate saveCandidate(Candidate candidate) {
        Party party = partyRepository.findById(candidate.getParty().getId());
        candidate = new Candidate(candidate.getFirstName(), candidate.getSurname(), candidate.getYearsExperience(), party);
        return candidateRepository.save(candidate);
    }

    public Candidate saveCandidateNoParty(Candidate candidate) {
        candidate.setFirstName(candidate.getFirstName());
        candidate.setSurname(candidate.getSurname());
        candidate.setYearsExperience(candidate.getYearsExperience());
        candidate.setParty(null);
        return candidateRepository.save(candidate);
    }

    public List<Candidate> findCandidateByName(String name){
        return candidateRepository.findCandidateByFirstName(name);
    }

    public void removeCandidate(Candidate candidate){
        candidateRepository.deleteCandidateById(candidate.getId());
    }
}
