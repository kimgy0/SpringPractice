package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService;
        OrderService orderService;

        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        System.out.println(memberService.findMember(memberId).getName());
        System.out.println(member.getName());
        System.out.println(member.getId());

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = "+order);
        System.out.println("order.calculatePrice = "+order.calculatePrice());
    }
}
