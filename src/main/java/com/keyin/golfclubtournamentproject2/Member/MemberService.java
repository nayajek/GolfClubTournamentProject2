package com.keyin.golfclubtournamentproject2.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    public Member addMember(Member member) {
        return memberRepository.save(member);
    }


    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }


    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }


    public List<Member> searchMembersByName(String name) {
        return memberRepository.findMemberByMemberName(name);
    }


    public List<Member> searchMembersByPhoneNumber(String phoneNumber) {
        return memberRepository.findByPhoneNumber(phoneNumber);
    }


    public void deleteMemberById(Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
        } else {
            throw new RuntimeException("Member not found with ID: " + id);
        }
    }
}
