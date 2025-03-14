package com.newinntech.newinntech.Controllers;


import com.newinntech.newinntech.Contract.Reponse.VoterResponse;
import com.newinntech.newinntech.Contract.Request.VoterRequest;
import com.newinntech.newinntech.Mapper.Interface.VoterInterface;
import com.newinntech.newinntech.Services.VoterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voter")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class VoterController {


    private final VoterInterface voterInterface;
    private final VoterService voterService;


    @GetMapping("/list")
    public List<VoterResponse> getVoterList() {
        return voterInterface.mapToVoterListToVoterResponseList(voterService.getVoterAll());
    }

    //
    @GetMapping("/getVoterById/{id}")
    public VoterResponse getVoterById(@PathVariable Long id) {
        return voterInterface.mapToVoterModelToVoterResponse(voterService.getVoterById(id));
    }


    @PostMapping ("/create")
    public VoterResponse createVoter (VoterRequest voterRequest){
        return  voterInterface.mapToVoterModelToVoterResponse(voterService.CreateVoter
                (voterInterface.mapToVoterRequestToVoterModel(voterRequest)));

    }


    @DeleteMapping ("/delete/{id}")
    public VoterResponse deleteVoter (@PathVariable Long id){
        return  voterInterface.mapToVoterModelToVoterResponse(voterService.deteleVoterById(id));
    }



}
