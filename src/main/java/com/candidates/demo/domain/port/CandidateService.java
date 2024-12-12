package com.candidates.demo.domain.port;

import com.candidates.demo.domain.model.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateService {
    List<Candidate> findAllCandidates();
    Optional<Candidate> findCandidateById(Long id);
    Candidate saveCandidate(Candidate candidate);
    void deleteCandidate(Long id);
}
