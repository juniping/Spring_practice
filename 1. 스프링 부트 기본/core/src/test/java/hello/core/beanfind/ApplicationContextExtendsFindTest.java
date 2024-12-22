package hello.core.beanfind;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixedDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;

public class ApplicationContextExtendsFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

	@Test
	@DisplayName("부모 타입 조회 시 자식이 둘 인 오류 발생")
	void findBeanByParentTypeDuplicate(){
		DiscountPolicy bean;
		assertThrows(NoUniqueBeanDefinitionException.class,
			() -> ac.getBean(DiscountPolicy.class));
	}

	@Test
	@DisplayName("부모 타입 조회 시 자식 이름 지정해주면 된다")
	void findBeanByParentTypeBeanName(){
		DiscountPolicy bean = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
		org.assertj.core.api.Assertions.assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
	}

	@Configuration
	static class TestConfig {
		@Bean
		public DiscountPolicy rateDiscountPolicy() {
			return new RateDiscountPolicy();
		}

		@Bean
		public DiscountPolicy fixDiscountPolicy() {
			return new FixedDiscountPolicy();
		}
	}
}
