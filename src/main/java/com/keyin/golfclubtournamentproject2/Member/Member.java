package com.keyin.golfclubtournamentproject2.Member;

import com.keyin.golfclubtournamentproject2.Tournament.Tournament;
import jakarta.persistence.*;
import jakarta.persistence.SequenceGenerator;

import java.time.LocalDate;
import java.util.Collection;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "golf_member_sequence", sequenceName = "golf_member_sequence", allocationSize = 1, initialValue=1)
    private Long id;


    private String memberName;

    private String address;


    private String emailAddress;


    private String phoneNumber;

    private LocalDate startDate;

    private Integer duration;

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @ManyToMany(mappedBy = "participatingMembers")
    private Collection<Tournament> tournaments;

    public Collection<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Collection<Tournament> tournaments) {
        this.tournaments = tournaments;
    }
}

