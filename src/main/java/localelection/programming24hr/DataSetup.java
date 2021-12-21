package localelection.programming24hr;


import localelection.programming24hr.entities.Candidate;
import localelection.programming24hr.entities.Party;
import localelection.programming24hr.repositories.CandidateRepository;
import localelection.programming24hr.repositories.PartyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSetup implements CommandLineRunner {

    PartyRepository partyRepository;
    CandidateRepository candidateRepository;

    public DataSetup(PartyRepository partyRepository, CandidateRepository candidateRepository) {
        this.partyRepository = partyRepository;
        this.candidateRepository = candidateRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Party p1 = partyRepository.save(new Party("Social Democrats", 10418));
        Party p2 = partyRepository.save(new Party("Radical Left", 5686));
        Party p3 = partyRepository.save(new Party("The Conservative People's Party", 24607));
        Party p4 = partyRepository.save(new Party("SF - Social People's Party", 2852));
        Party p5 = partyRepository.save(new Party("Venstre Danmarks Liberale Party", 3603));
        Party p6 = partyRepository.save(new Party("Unity List", 10720));


        Candidate c1 = candidateRepository.save(new Candidate("Simon", "Aggesen", 3, p1));
        Candidate c2 = candidateRepository.save(new Candidate("Pelle", "Dragsted", 8, p1));
        Candidate c3 = candidateRepository.save(new Candidate("Michael", "Vindfelt", 20, p2));
        Candidate c4 = candidateRepository.save(new Candidate("Jan", "Jørgensen", 15, p5));
        Candidate c5 = candidateRepository.save(new Candidate("Lone", "Loklindt", 2, p5));
        Candidate c6 = candidateRepository.save(new Candidate("Laura", "Linadahl", 13, p5));
        Candidate c7 = candidateRepository.save(new Candidate("Brian", "Holm", 4, p5));
        Candidate c8 = candidateRepository.save(new Candidate("Nikolaj", "Bøgh", 7, p5));
        Candidate c9 = candidateRepository.save(new Candidate("Bent", "Isager-Nielsen", 9, null));
        Candidate c10 = candidateRepository.save(new Candidate("Mette", "Larsen", 1, null));
        Candidate c11 = candidateRepository.save(new Candidate("Freja", "Fokdal", 16, null));
        Candidate c12 = candidateRepository.save(new Candidate("Ruben", "Kidde", 2, null));
        Candidate c13 = candidateRepository.save(new Candidate("Alexandra", "Dessoy", 1, null));
        Candidate c14 = candidateRepository.save(new Candidate("Anders", "Storgaard", 3, null));
        Candidate c15 = candidateRepository.save(new Candidate("Sine", "Heltberg", 6, null));
        Candidate c16 = candidateRepository.save(new Candidate("Lotte", "Kofoed", 7, null));
        Candidate c17 = candidateRepository.save(new Candidate("Balder", "Andersen", 1, null));
        Candidate c18 = candidateRepository.save(new Candidate("Trine", "Labuhn", 18, null));
        Candidate c19 = candidateRepository.save(new Candidate("Merete", "Hildebrandt", 12, null));
        Candidate c20 = candidateRepository.save(new Candidate("Malte", "Løcke", 0, null));
        Candidate c21 = candidateRepository.save(new Candidate("Michael", "Brautsch", 1, null));
        Candidate c22 = candidateRepository.save(new Candidate("Alexandra", "Sasha", 13, null));
        Candidate c23 = candidateRepository.save(new Candidate("Gunvor", "Wibroe", 17, null));
        Candidate c24 = candidateRepository.save(new Candidate("Helle", "Sjelle", 5, null));
        Candidate c25 = candidateRepository.save(new Candidate("Fasael", "Rehman", 3, null));

    }
}
