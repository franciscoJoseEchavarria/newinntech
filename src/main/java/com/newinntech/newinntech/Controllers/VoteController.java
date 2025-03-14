package com.newinntech.newinntech.Controllers;


import com.newinntech.newinntech.Contract.Reponse.VoteResponse;
import com.newinntech.newinntech.Contract.Request.VoteRequest;
import com.newinntech.newinntech.Mapper.Interface.VoteInterface;
import com.newinntech.newinntech.Mapper.Interface.VoterInterface;
import com.newinntech.newinntech.Models.VoteModel;
import com.newinntech.newinntech.Services.VoteService;
import com.newinntech.newinntech.Services.VoterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VoteController {

    private final VoteService voteService;
    private final VoteInterface voteInterface;


    @PostMapping ("/votes")
    public VoteResponse createVote (VoteRequest voteRequest) {
        VoteModel voteModel = voteInterface.mapVoteRequestToVoteModel(voteRequest);
        return voteInterface.mapVoteModelToVoteResponse(voteService.createVote(voteModel));
    }

    @GetMapping ("/votes/{id}")
    public VoteResponse getVoteById (@PathVariable Long id) {
        return voteInterface.mapVoteModelToVoteResponse(voteService.getVoteById(id));
    }

    @GetMapping("/votes")
    public List <VoteResponse> getVotes() {
        return voteInterface.mapVoteModelListToResponseList(voteService.getVoteAll());
    }


    @DeleteMapping("/Votes/{id}")
    public VoteResponse deleteVote(@PathVariable Long id) {
        VoteModel voteModel = voteService.deleteVoteById(id);
        return voteInterface.mapVoteModelToVoteResponse(voteModel);
    }
}
