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
    private int id;

    private String name;
    private int votes; // Try and tally up individual candidates' votes to calculate this.
    // private String municipality;

    @OneToMany(mappedBy = "party")
    private Set<Candidate> candidates = new HashSet<>();

    public Set<Candidate> addCandidates(Candidate candidate){
        candidates.add(candidate);
        return candidates;
    }

    public Party(String name, int votes) {
        this.name = name;
        this.votes = votes;
    }
}
