package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy=new RateDiscountPolicy();



    @Test
    @DisplayName("VIP는 정률에 따른 10% 할인이 적용됩니다.")
    /*
     *  DISPLAYNAME은 한글로 이름을 적용해줄 수 있습니다.
     */
    void vip_o() {
        //given
        Member member = new Member(1L , "memberVIP", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        org.assertj.core.api.Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아닐경우 정률에 따른 10% 할인이 적용되지 않습니다.")
    /*
     * 반대로 테스트케이스를 작성할 때 실패할 경우도 만들어줘야 합니다.
     */
    void vip_x() {
        //given
        Member member = new Member(1L , "memberBASIC", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        org.assertj.core.api.Assertions.assertThat(discount).isEqualTo(0);
    }
}