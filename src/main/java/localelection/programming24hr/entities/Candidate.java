package localelection.programming24hr.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private int id;

    private String firstName;
    private String surname;
    private int yearsExperience;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinTable(
            name = "candidates_in_parties",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "party_id")
    )
    private Party party;


    public Candidate(String firstName, String surname, int yearsExperience) {
        this.firstName = firstName;
        this.surname = surname;
        this.yearsExperience = yearsExperience;
    }

    public Candidate(String firstName, String surname, int yearsExperience, Party party) {
        this.firstName = firstName;
        this.surname = surname;
        this.yearsExperience = yearsExperience;
        this.party = party;
    }
}
