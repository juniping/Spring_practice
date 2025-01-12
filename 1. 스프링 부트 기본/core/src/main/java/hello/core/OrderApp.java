package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {

	public static void main(String[] args) {
		// AppConfig appConfig = new AppConfig();
		// MemberService memberService = appConfig.memberService();
		// OrderService orderService = appConfig.orderService();

		ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
		OrderService orderService = ac.getBean(OrderService.class);
		MemberService memberService = ac.getBean(MemberService.class);

		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.CreateOrder(memberId, "itemA", 10000);

		System.out.println("order : " + order);
		System.out.println("calculatedOrder : " + order.calculateDiscount());
	}
}
