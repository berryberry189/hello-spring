package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class MemberController {

    private  final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
       // @Service, @Repository등 해당 클래스에 미리 정의해야 컨트롤러에서 @Autowired로 연결할수있음
        this.memberService = memberService;
    }
}
