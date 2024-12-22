package hello.core.discount;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

class RateDiscountPolicyTest {

	DiscountPolicy discountPolicy = new RateDiscountPolicy();

	@Test
	@DisplayName("VIP는 10%할인이 적용되어야한다.")
	void vip_o(){
		//given
		Member member = new Member(1L, "memberA", Grade.VIP);

		//when
		int discount = discountPolicy.discount(member, 10000);

		//then
		Assertions.assertThat(discount).isEqualTo(1000);
	} 

	@Test
	@DisplayName("VIP가 아니면 할인이 적용되지 않아야한다.")
	void vip_o2(){
		Member member = new Member(1L, "memberA", Grade.BASIC);
		int discount = discountPolicy.discount(member, 10000);
		Assertions.assertThat(discount).isEqualTo(0);

	}
}