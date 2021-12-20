package localelection.programming24hr.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "party")
@NoArgsConstructor
@Getter @Setter
public class Party {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int votes; // Try and tally up individual candidates' votes to calculate this.
    // private String municipality;

    @OneToMany (mappedBy = "party")
    private Set<Candidate> candidates = new HashSet<>();


    //    public void editCandidate(Candidate candidate){
//        candidate.setFirstName(candidate.getFirstName());
//        candidate.setSurname(candidate.getSurname());
//        candidate.setYearsExperience(candidate.getYearsExperience());
//        candidateList.add(candidate.getId(), candidate);
//    }

    public Party(String name, int votes) {
        this.name = name;
        this.votes = votes;
    }

//    public Party(String name, int votes, Set<Candidate> candidateList) {
//        this.name = name;
//        this.votes = votes;
//        this.candidateList = candidateList;
//    }
}
