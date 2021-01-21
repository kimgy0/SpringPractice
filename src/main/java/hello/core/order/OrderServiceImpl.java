package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    //private MemberRepository memberRepository=new MemoryMemberRepository();

    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    /**
     *
     *  개방-폐쇄 원칙과 의존관계 원칙을 준수하지 않은 코드입니다.
     *  왜 ?
     *  이 클래스는 인터페이스 뿐만이 아니라 클래스에도 의존하고 있습니다.
     *  우리는 이 것을 바꾸기 위해서 무언가 조립해줄 수 있는 조립자자 필요합니다.
     *  ⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️
     */

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;



    /**
     *  인터페이스에만 의존하도록 만들었다.
     *  하지만 이상태로 두면 nullpointexception error 가 발생하게 됩니다.
     *  그러면 여기서!! 생성자로 받을 수 있게 합니다.
     *  ⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️
     *
     *  누군가가 클라이언트인 OrderServiceImpl에 DiscountPolicy의 구현객체를 대신 생성하고 주입해줘야 합니다.
     */


    public OrderServiceImpl(MemberRepository memberRepository,DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }









    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member= memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}