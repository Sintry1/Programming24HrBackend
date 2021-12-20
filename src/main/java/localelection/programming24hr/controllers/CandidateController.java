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

    @GetMapping("/all")
    public Iterable<Candidate> getAllCandidates(){
        return candidateService.findAllCandidates();
    }

    @GetMapping("/name/{name}")
    public List<Candidate> getCandidateByName(@PathVariable String name){
        return candidateService.findCandidateByName(name);
    }

    @GetMapping("/{id}")
    public Candidate getCandidateById(@PathVariable int id){
        return candidateService.findById(id);
    }

    @PostMapping("/createCandidate")
    public Candidate createCandidate(@RequestBody Candidate candidate) {
        return candidateService.saveCandidate(candidate);
    }

    @PutMapping("/editCandidate/{id}")
    public Candidate editCandidate(@PathVariable int id, @RequestBody Candidate candidate) {
        candidate.setId(id);
        return candidateService.saveCandidate(candidate);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public Iterable<Candidate> deleteCandidate(@PathVariable int id) {
        Candidate candidate = candidateService.findById(id);

        candidateService.removeCandidate(candidate);
        return candidateService.findAllCandidates();
    }

//    @PutMapping("/addparty/{candidateId}/{partyId}")
//    public Candidate editCandidateParty(@PathVariable int candidateId, @PathVariable int partyId, @RequestBody Candidate candidate){
//        candidate = candidateService.findById(candidateId);
//
//
//        return candidateService.saveCandidate(candidate);
//    }

//    @GetMapping("/parties/{partyId}")
//    public List<Candidate> findCandidatesByParty (@PathVariable Party partyId, @RequestBody int id) {
//        return partyService.findById(id);
//    }

}
