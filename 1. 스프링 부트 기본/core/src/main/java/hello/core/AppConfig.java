package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixedDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

	public MemberService memberService(){
		return new MemberServiceImpl(memoryMemberRepository());
	};

	public MemoryMemberRepository memoryMemberRepository(){
		return new MemoryMemberRepository();
	}

	public DiscountPolicy discountPolicy(){
		return new FixedDiscountPolicy();
	}

	public OrderService orderService(){
		return new OrderServiceImpl(memoryMemberRepository(), discountPolicy());
	}


}
