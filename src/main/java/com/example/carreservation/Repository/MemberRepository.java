package com.example.carreservation.Repository;

import com.example.carreservation.Entity.Member;
import com.example.carreservation.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
  // List<Member> findMemberByReservation(Reservation reservation);

}
