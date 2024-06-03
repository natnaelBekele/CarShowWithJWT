package com.binary.repositories;

import com.binary.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    public Optional<Member> findByEmail(String Email);

}
