package com.example.carreservation.Controller;

import com.example.carreservation.Entity.Member;
import com.example.carreservation.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable("id") Long id) {
        Member member = memberService.getMemberById(id);
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping("/members")
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        Member newMember = memberService.createMember(member);
        return new ResponseEntity<>(newMember, HttpStatus.CREATED);
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<Member> updateMember(@RequestBody Member member, @PathVariable("id") Long id) {
        return new ResponseEntity<>(memberService.updateMember(id, member), HttpStatus.OK);
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

/*

    @GetMapping("/parties")
    public List<Member> getAllParties() {
        return memberService.findAll();
    }

    @PostMapping("/member")
    public Member saveMember(@RequestBody Member member) {
        return memberService.save(member);
    }
*/

}
