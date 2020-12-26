package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    // 자바 코드로 직접 스프링 빈 등록하기

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    /*

    dependency injection
    1. 생성자 주입 (*권장)
    @Autowired
    public MemberController(MemberService memberService) { this.memberService = memberService; }

    2. 필드 주입 @Autowired private MemberService memberService;
       -  중간에 바꿀수있는 방법 없으므로 비추

    3. Setter 주입
    @Autowired
    public void setMemberService(MemberService memberService) { this.memberService = memberService; }
       - public으로 노출이되어있어서 세팅된 후 중간에 바끼면 문제가 생길 수 있음

    */

}
