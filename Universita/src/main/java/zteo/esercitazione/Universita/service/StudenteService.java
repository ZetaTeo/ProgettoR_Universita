package zteo.esercitazione.Universita.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zteo.esercitazione.Universita.dto.StudenteDto;
import zteo.esercitazione.Universita.entity.Studente;
import zteo.esercitazione.Universita.exception.IllegalArgumentException;
import zteo.esercitazione.Universita.exception.ResourceNotFoundException;
import zteo.esercitazione.Universita.repository.StudenteRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudenteService {

    private final StudenteRepository studenteRepository;











}
