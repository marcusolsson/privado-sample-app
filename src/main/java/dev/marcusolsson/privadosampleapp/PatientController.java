package dev.marcusolsson.privadosampleapp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PatientController {
    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    private final PatientRepository repository;

    PatientController(PatientRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/patients")
    List<Patient> all() {
        return repository.findAll();
    }

    @PostMapping("/patients")
    void register(Patient patient) {
        repository.save(patient);

        logger.info("Registered new patient with SSN: {}", patient.getSsn());
    }
}
