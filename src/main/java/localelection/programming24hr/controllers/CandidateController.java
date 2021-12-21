package localelection.programming24hr.controllers;

import localelection.programming24hr.entities.Candidate;
import localelection.programming24hr.services.CandidateService;
import localelection.programming24hr.services.PartyService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/candidates")
public class CandidateController {

    CandidateService candidateService;
    PartyService partyService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }


    // Required endpoint

    // Working - Though not displaying Party
    @GetMapping("/all")
    public List<Candidate> getAllCandidates(){
        return candidateService.findAllCandidates();
    }

    // Required endpoint

    // Currently the bane of my existence and of course not working
//    @PutMapping("/addparty/{candidateId}/{partyId}")
//    public Candidate addCandidateToParty(@PathVariable int candidateId, @PathVariable int partyId){
//        Candidate candidate = candidateService.findById(candidateId);
//        Party party = partyService.findById(partyId);
//
//        candidate.setParty(party);
//
//        return candidateService.saveCandidate(candidate);
//    }


    // This also doesn't work. Again the Party is null if attended to access from here
    @PutMapping("/addparty/{candidateId}/{partyId}")
    public Candidate addCandidateToParty(@RequestBody Candidate candidate){
        return candidateService.saveCandidate(candidate);
    }

    // Optional endpoint
    // Working
    @GetMapping("/name/{name}")
    public List<Candidate> getCandidateByName(@PathVariable String name){
        return candidateService.findCandidateByName(name);
    }

    // Optional endpoint

    // Working
    @GetMapping("/{id}")
    public Candidate getCandidateById(@PathVariable int id){
        return candidateService.findById(id);
    }

    //Optional Endpoint

    // Working
    @PostMapping("")
    public Candidate createCandidate(@RequestBody Candidate candidate) {
        return candidateService.saveCandidateNoParty(candidate);
    }

    // Optional Endpoint

    // Working
    @PutMapping("/editCandidate/{id}")
    public Candidate editCandidate(@PathVariable int id, @RequestBody Candidate candidate) {
        candidate.setId(id);
        candidate.setFirstName(candidate.getFirstName());
        candidate.setSurname(candidate.getSurname());
        candidate.setYearsExperience(candidate.getYearsExperience());
        candidate.setParty(candidate.getParty());

        return candidateService.saveCandidateNoParty(candidate);
    }

    // Optional Endpoint

    // Working
    @Transactional
    @DeleteMapping("/delete/{id}")
    public Iterable<Candidate> deleteCandidate(@PathVariable int id) {
        Candidate candidate = candidateService.findById(id);

        candidateService.removeCandidate(candidate);
        return candidateService.findAllCandidates();
    }

    // Required Endpoint

    // Working
    @GetMapping("/parties/{id}")
    public List<Candidate> getCandidatesByParty(@PathVariable int id){
        return candidateService.findCandidatesByParty(id);
    }

//    @GetMapping("/parties/{partyId}")
//    public List<Candidate> findCandidatesByParty (@PathVariable Party partyId, @RequestBody int id) {
//        return partyService.findById(id);
//    }

}
