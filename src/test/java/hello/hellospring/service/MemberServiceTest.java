package hello.hellospring.service;

import hello.hellospring.domain.Member;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
//test 파일 만드는법 → 원본 파일에서 클래스명 잡고 alt + enter

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository ;

    @BeforeEach
    public void beforeEach(){
        // 테스트 실행할 때 마다 생성됨
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    public void afterEach(){
        // @AfterEach 각 메서드가 끝날때마다 실행. 콜백 메서드
        memoryMemberRepository.clearStore();
    }

    @Test
    public void 회원가입() {
        // given : 상황이 주어졌을때
        Member member = new Member();
        member.setName("Spring");

        // when  : 실행했을때
        Long saveId = memberService.join(member);

        // then  : 나오는 결과
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){

        // given : 상황이 주어졌을때
        Member member1 = new Member();
        member1.setName("Spring");
        Member member2 = new Member();
        member2.setName("Spring");

        // when  : 실행했을때
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*
        중복 확인 코드 try-catch 이용 ver. 간단하게 위처럼 사용가능
        try{
            memberService.join(member2);
            fail();
        }catch(IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

        // then  : 나오는 결과
    }


    @Test
    public void findMembers() {
    }

    @Test
    public void findOne() {
    }
}