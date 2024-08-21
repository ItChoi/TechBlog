package chapter04;

public class AnyClass {
    void anyMethod(Rectangle rectangle, int multiple) {
        // 중복 가능성, 자세한 정보를 알 수 있음
        rectangle.setRight(rectangle.getRight() * multiple);
        rectangle.setBottom(rectangle.getBottom() * multiple);
    }
}
