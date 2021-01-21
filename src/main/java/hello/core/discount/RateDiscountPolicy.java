package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private final int discountPercent = 10;

    /*
     *
     * 관례상 테스트클래스이름은 test를 붙여줍니다.
     * test클래스를 만들때 ctrl + shift + t
     * 라이브러리는 junit5
     */
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return price*discountPercent/100;
        }else{
            return 0;
        }
    }
}
