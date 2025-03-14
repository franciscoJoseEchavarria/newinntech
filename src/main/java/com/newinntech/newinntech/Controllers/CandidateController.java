package com.newinntech.newinntech.Controllers;


import com.newinntech.newinntech.Contract.Reponse.CandidateResponse;
import com.newinntech.newinntech.Contract.Request.CandidateRequest;
import com.newinntech.newinntech.Mapper.Interface.CandidateInterface;

import com.newinntech.newinntech.Repositorys.CandidateRepository;
import com.newinntech.newinntech.Services.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidate")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {

    private final CandidateInterface candidateInterface;
    private final CandidateService candidateService;


    @GetMapping("/list")
    public List<CandidateResponse> getCandidateList() {
        return candidateInterface.mapToCandidateListToCandidateResponseList(candidateService.getCandidateList());
    }

    @GetMapping("/getCandidateById/{id}")
    public CandidateResponse getCandidateById(@PathVariable Long id) {
        return candidateInterface.mapToCandidateModelToCandidateResponse(candidateService.getCandidateById(id));
    }

    @PostMapping ("/create")
    public CandidateResponse createCandidate (@RequestBody CandidateRequest candidateRequest) {
        return candidateInterface.mapToCandidateModelToCandidateResponse(candidateService.CreateCandidate
                (candidateInterface.mapToCandidateRequestToCandidateModel(candidateRequest)));
    }


    @DeleteMapping ("/delete/{id}")
    public CandidateResponse deleteCandidate (@PathVariable Long id){
        return  candidateInterface.mapToCandidateModelToCandidateResponse(candidateService.deleteCandidate(id));
    }

}
