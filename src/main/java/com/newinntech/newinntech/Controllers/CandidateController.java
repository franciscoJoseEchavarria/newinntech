package com.newinntech.newinntech.Controllers;


import com.newinntech.newinntech.Contract.Reponse.CandidateResponse;
import com.newinntech.newinntech.Contract.Reponse.VoteStaticaReponse;
import com.newinntech.newinntech.Contract.Request.CandidateRequest;
import com.newinntech.newinntech.Mapper.Interface.CandidateInterface;

import com.newinntech.newinntech.Repositorys.CandidateRepository;
import com.newinntech.newinntech.Services.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {

    private final CandidateInterface candidateInterface;
    private final CandidateService candidateService;


    @GetMapping ("/candidates")
    public List<CandidateResponse> getCandidateList() {
        return candidateInterface.mapToCandidateListToCandidateResponseList(candidateService.getCandidateList());
    }

    @GetMapping("/candidates/{id}")
    public CandidateResponse getCandidateById(@PathVariable Long id) {
        return candidateInterface.mapToCandidateModelToCandidateResponse(candidateService.getCandidateById(id));
    }


    @PostMapping ("/candidates")
    public CandidateResponse createCandidate (@RequestBody CandidateRequest candidateRequest) {
        return candidateInterface.mapToCandidateModelToCandidateResponse(candidateService.CreateCandidate
                (candidateInterface.mapToCandidateRequestToCandidateModel(candidateRequest)));
    }


    @DeleteMapping ("/candidates/{id}")
    public CandidateResponse deleteCandidate (@PathVariable Long id){
        return  candidateInterface.mapToCandidateModelToCandidateResponse(candidateService.deleteCandidate(id));
    }



}
