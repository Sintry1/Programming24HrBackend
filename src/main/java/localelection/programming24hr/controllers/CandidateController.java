package localelection.programming24hr.controllers;

import localelection.programming24hr.entities.Candidate;
import localelection.programming24hr.entities.Party;
import localelection.programming24hr.services.CandidateService;
import localelection.programming24hr.services.PartyService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
//@RequestMapping("/candidates")
public class CandidateController {

    CandidateService candidateService;
    PartyService partyService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/candidates/all")
    public Iterable<Candidate> getAllCandidates(){
        return candidateService.findAllCandidates();
    }

    @GetMapping("/candidates/name/{name}")
    public List<Candidate> getCandidateByName(@PathVariable String name){
        return candidateService.findCandidateByName(name);
    }

    @GetMapping("/candidates/{id}")
    public Candidate getCandidateById(@PathVariable Long id){
        return candidateService.findById(id);
    }

    @PostMapping("/candidates/createCandidate")
    public Candidate createCandidate(@RequestBody Candidate candidate) {
        return candidateService.saveCandidate(candidate);
    }

    @PutMapping("/candidates/editCandidate/{id}")
    public Candidate editCandidate(@PathVariable Long id, @RequestBody Candidate candidate) {
        candidate.setId(id);
        return candidateService.saveCandidate(candidate);
    }

    @Transactional
    @DeleteMapping("/cadndidates/delete/{id}")
    public Iterable<Candidate> deleteCandidate(@PathVariable Long id) {
        Candidate candidate = candidateService.findById(id);

        candidateService.removeCandidate(candidate);
        return candidateService.findAllCandidates();
    }

    @PutMapping("/parties/addcandidate/{candidateId}/{partyId}")
    public Party addCandidateToParty(@PathVariable Long candidateId, @PathVariable Long partyId){
        Candidate candidate = candidateService.findById(candidateId);
        Party party = partyService.findById(partyId);

        candidate.setParty(party);
        candidateService.saveCandidate(candidate);

        return party;
    }

//    @GetMapping("/parties/{partyId}")
//    public List<Candidate> findCandidatesByParty (@PathVariable Party partyId, @RequestBody int id) {
//        return partyService.findById(id);
//    }

}
