package com.candidates.demo.domain.service;


import com.candidates.demo.domain.model.Candidate;
import com.candidates.demo.infraestructure.repository.CandidateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CandidateServiceImplTest {

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private CandidateServiceImpl candidateService;

    private Candidate candidate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        candidate = new Candidate();
        candidate.setName("Juan Pérez");
        candidate.setEmail("juan.perez@email.com");
        candidate.setGender("Male");
        candidate.setSalaryExpected(Double.valueOf(30000));
    }

    @Test
    void testSaveCandidate() {
        when(candidateRepository.save(any(Candidate.class))).thenReturn(candidate);

        Candidate savedCandidate = candidateService.saveCandidate(candidate);
        assertNotNull(savedCandidate);
        assertEquals("Juan Pérez", savedCandidate.getName());
    }

    @Test
    void testFindAll() {
        when(candidateRepository.findAll()).thenReturn(List.of(candidate));

        List<Candidate> candidates = candidateService.findAllCandidates();
        assertEquals(1, candidates.size());
    }
}