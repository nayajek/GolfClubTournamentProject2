package com.keyin.golfclubtournamentproject2.Tournament;

import com.keyin.golfclubtournamentproject2.Member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }


    public List<Tournament> searchTournamentsByStartDate(LocalDate startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }

    public List<Tournament> searchTournamentsByLocation(String location) {
        return tournamentRepository.findByLocation(location);
    }

    public Tournament addMembersToTournament(Long tournamentId, List<Member> members) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new RuntimeException("Tournament not found with ID: " + tournamentId));

        tournament.getParticipatingMembers().addAll(members);
        return tournamentRepository.save(tournament);
    }

    public List<Member> getMembersInTournament(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new RuntimeException("Tournament not found with ID: " + tournamentId));

        return tournament.getParticipatingMembers();
    }

    public void deleteTournamentById(Long id) {
        if (tournamentRepository.existsById(id)) {
            tournamentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tournament not found with ID: " + id);
        }
    }
}
