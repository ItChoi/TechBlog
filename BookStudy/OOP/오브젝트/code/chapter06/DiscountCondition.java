package chapter06;

import chapter05.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
