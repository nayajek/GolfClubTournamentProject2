package com.keyin.golfclubtournamentproject2.Tournament;

import com.keyin.golfclubtournamentproject2.Member.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {
    @Autowired
    private TournamentRepository tournamentRepository;

    @PostMapping
    public Tournament addTournament(@RequestBody Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    @GetMapping("/{id}/members")
    public List<Member> getMembersInTournament(@PathVariable Long id) {
        Tournament tournament = tournamentRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        return tournament.getMembers();
    }
}

