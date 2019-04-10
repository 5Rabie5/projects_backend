package at.nacs.drhousediagnoses.logic;

import at.nacs.drhousediagnoses.persistence.domain.Symptom;
import at.nacs.drhousediagnoses.persistence.repository.SymptomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class Assistant {
    private  final SymptomRepository symptomRepository;


    public void store(Symptom[] symptoms) {
        symptomRepository.saveAll(Arrays.asList(symptoms));
    }
}
