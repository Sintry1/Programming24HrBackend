package localelection.programming24hr.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "candidate")
@NoArgsConstructor
@Getter @Setter
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String surname;
    private int yearsExperience;

    @JsonBackReference
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "party_id", referencedColumnName = "id")
    private Party party;


    public Candidate(String firstName, String surname, int yearsExperience) {
        this.firstName = firstName;
        this.surname = surname;
        this.yearsExperience = yearsExperience;
    }

//    public Candidate(String firstName, String surname, int yearsExperience, Party party) {
//        this.firstName = firstName;
//        this.surname = surname;
//        this.yearsExperience = yearsExperience;
//        this.party = party;
//    }
}
