package com.newinntech.newinntech.Controllers;


import com.newinntech.newinntech.Contract.Reponse.VoterResponse;
import com.newinntech.newinntech.Contract.Request.VoterRequest;
import com.newinntech.newinntech.Mapper.Interface.VoterInterface;
import com.newinntech.newinntech.Models.VoterModel;
import com.newinntech.newinntech.Services.VoterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class VoterController {


    private final VoterInterface voterInterface;
    private final VoterService voterService;


    @GetMapping ("/voters")
    public List<VoterResponse> getVoterList() {
        return voterInterface.mapToVoterListToVoterResponseList(voterService.getVoterAll());
    }

    //
    @GetMapping("/voters/{id}")
    public VoterResponse getVoterById(@PathVariable Long id) {
        return voterInterface.mapToVoterModelToVoterResponse(voterService.getVoterById(id));
    }


    @PostMapping ("/voters")
    public VoterResponse createVoter (@RequestBody VoterRequest voterRequest) {

        return voterInterface.mapToVoterModelToVoterResponse(voterService.CreateVoter
                (voterInterface.mapToVoterRequestToVoterModel(voterRequest)));
    }


    @DeleteMapping ("/voters/{id}")
    public VoterResponse deleteVoter (@PathVariable Long id){
        return  voterInterface.mapToVoterModelToVoterResponse(voterService.deteleVoterById(id));
    }



}
