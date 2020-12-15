package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     */
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원X
        validateDuplicate(member);// refactor 단축키 : ctrl + shift + alt + T
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 중복회원 검증
     * @param member
     */
    private void validateDuplicate(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                        throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

        /*
        Optional로 바로 반환하는 것은 좋지 않음. 그러므로 위와 같이 사용.
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
                        throw new IllegalStateException("이미 존재하는 회원입니다.");
        });*/
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
