package at.nacs.drhouseaccountancy.logic;

import at.nacs.drhouseaccountancy.DTO.PatientDTO;
import at.nacs.drhouseaccountancy.persistence.domain.Invoice;
import at.nacs.drhouseaccountancy.persistence.domain.Kind;
import at.nacs.drhouseaccountancy.persistence.domain.Patient;
import at.nacs.drhouseaccountancy.persistence.repository.InvoiceRepository;
import at.nacs.drhouseaccountancy.persistence.repository.PatientRrpository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Accountant {

    private final PatientRrpository patientRrpository;
    private final InvoiceRepository invoiceRepository;
    private final PatientDTO patientDTO;

    public Patient merge(PatientDTO patientDTO) {

        Optional<Patient> patient = patientRrpository.findPatientByUuid(patientDTO.getId());
        System.out.println("i recive the patient");
        if (patient.isPresent()) {
            createsInvoice(patientDTO);
            return patient.get();
        }

        saveNewPationt(patientDTO);
        createsInvoice(patientDTO);

        return patientRrpository.findPatientByUuid(patientDTO.getId()).get();
    }

    private void saveNewPationt(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setUuid(patientDTO.getId());
        patientRrpository.save(patient);
    }

    private void createsInvoice(PatientDTO patientDTO) {

        Patient patient = patientRrpository.findPatientByUuid(patientDTO.getId()).get();
        Kind kind = getKind(patientDTO);
        String provided = getProvided(patientDTO, kind);

        Invoice invoice = Invoice.builder()
                .patient(patient)
                .symptoms(patientDTO.getSymptoms())
                .diagnosis(patientDTO.getDiagnosis())
                .kind(kind)
                .provided(provided)
                .cost(calculatesCosts(kind))
                .paid(false)
                .timestamp(LocalDateTime.now())
                .build();
        invoiceRepository.save(invoice);
    }

    private Kind getKind(PatientDTO patientDTO) {
        Kind kind = Kind.TREATMENT;
//        if (patientDTO.getMedicine().isEmpty()) {
//            System.out.println("i am here kind switsh");
//            kind = Kind.TREATMENT;
//        }
        return kind;
    }

    private String getProvided(PatientDTO patientDTO, Kind kind) {
        String provided = "";
        switch (kind) {
            case MEDICINE:
                provided = patientDTO.getMedicine();
                break;
            case TREATMENT:
                provided = patientDTO.getTreatment();
                break;
        }
        return provided;
    }

    private Double calculatesCosts(Kind kind) {
        double cost = 0.0;
        switch (kind) {
            case MEDICINE:
                cost = 50.00;
            case TREATMENT:
                cost = 100.00;
                break;
        }
        return cost;
    }

    public List<Invoice> displlyAllInvoice() {

        return invoiceRepository.findAll();
    }

    public void setAspaid(Long id) {

        Invoice invoice = invoiceRepository.findById(id).orElse(null);
        invoice.setPaid(true);
        invoiceRepository.save(invoice);
    }
}
