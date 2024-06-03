package com.binary.services;

import com.binary.entities.Member;
import com.binary.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements  MemberService{
    @Autowired
    MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(int id, Member updatedMember) {
        return null;
    }

    @Override
    public Integer deleteMember(int id) {
        return 0;
    }

    @Override
    public Member getMemberById(int id) {

        Optional<Member> optionalMember = memberRepository.findById(id);
        if(optionalMember.isPresent()){
            return  optionalMember.get();
        }
        return null;
    }

    @Override
    public Member getMembersByEmail(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        if(optionalMember.isPresent()){
            return  optionalMember.get();
        }
        return null;
    }
}
