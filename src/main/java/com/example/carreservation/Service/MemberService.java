package com.example.carreservation.Service;

import com.example.carreservation.Entity.Member;
import com.example.carreservation.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return MemberService.this.memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return MemberService.this.memberRepository.findById(id).orElse(null);
    }

    public Member createMember(Member member) {
        return MemberService.this.memberRepository.save(member);
    }

    public void deleteMember(Long id) {
        MemberService.this.memberRepository.deleteById(id);
    }

    public Member updateMember(Long id, Member member) {
        if (MemberService.this.memberRepository.findById(id).isEmpty()) {
            return null;
        }
        return MemberService.this.memberRepository.save(member);
    }

}

