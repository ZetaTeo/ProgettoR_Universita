package zteo.esercitazione.Universita.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zteo.esercitazione.Universita.repository.EsameRepository;

@Service
@RequiredArgsConstructor
public class EsameService {

    private final EsameRepository esameRepository;
}
