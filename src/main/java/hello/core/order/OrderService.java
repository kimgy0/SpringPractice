package hello.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
    /*
     *  최종 order 결과를 반환하는 기능을 가진 crateOrder.
     */
}
