package localelection.programming24hr.controllers;

import localelection.programming24hr.entities.Candidate;
import localelection.programming24hr.entities.Party;
import localelection.programming24hr.services.CandidateService;
import localelection.programming24hr.services.PartyService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/parties")
public class PartyController {

    PartyService partyService;
    CandidateService candidateService;

    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @GetMapping("/all")
    public Iterable<Party> getParties(){
        return partyService.getAll();
    }

    @GetMapping("/{id}")
    public Party getPartyById(@PathVariable int id){
        return partyService.findById(id);
    }

    @PostMapping("/parties")
    public Party createNewParty(@RequestBody Party party) {
        return partyService.save(party);
    }

    @PutMapping("/addcandidate/{partyId}/{candidateId}")
    public Party addCandidateToParty(@PathVariable int partyId, @PathVariable int candidateId) {
        Party party = partyService.findById(partyId);
        Candidate candidate = candidateService.findById(candidateId);

        party.addCandidate(candidate);

        partyService.save(party);
        return getPartyById(partyId);
    }

//    @PutMapping("/addcandidate/{partyId}/{candidateId}")
//    public Party addCandidateToParty(@PathVariable int partyId, @PathVariable int candidateId){
//        Party party = partyService.findById(partyId);
//        Candidate candidate = candidateService.findCandidateById(candidateId);
//
//        partyService.addCandidate(party, candidate);
//        partyService.save(party);
//        return party;
//    }

//    @PutMapping("/parties/{partyId}/{candidateId}")
//    public Party editPartyMember(@PathVariable Integer partyId, @PathVariable Integer candidateId, @RequestBody String firstName, @RequestBody String surname, @RequestBody int xp){
//        Party party = partyService.findById(partyId);
//        Candidate candidate = candidateService.findById(candidateId);
//
//        candidate.setFirstName(firstName);
//        candidate.setSurname(surname);
//        candidate.setYearsExperience(xp);
//        party.editCandidate(candidate);
//        partyService.save(party);
//
//        return party;
//    }

}
