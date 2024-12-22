package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberApp {
	public static void main(String[] args) {
		// AppConfig appConfig = new AppConfig();
		// MemberService memberService = appConfig.memberService();

		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = ac.getBean(MemberService.class);

		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);

		Member findMember = memberService.findMember(1L);
		System.out.println("new member : " + member.getName());
		System.out.println("find member : " + findMember.getName());

		// DIP 의존관계 역전 원칙을 준수하는가 ?
		// OCP 개발-폐쇄 원칙을 준수하는가 ?

	}
}
