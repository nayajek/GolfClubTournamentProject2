package com.keyin.golfclubtournamentproject2.Member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByPhoneNumber(String phoneNumber);

    List<Member> findMemberByMemberName(String name);
}
