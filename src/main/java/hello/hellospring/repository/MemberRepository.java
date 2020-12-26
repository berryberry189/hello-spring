package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long Id);
    Optional<Member> findByName(String name);
    // Optional - 자바8에 들어가있는 기능. Wapper Class. null로 반환되는 경우에도 npe 안 떨어짐
    List<Member> findAll();
}
