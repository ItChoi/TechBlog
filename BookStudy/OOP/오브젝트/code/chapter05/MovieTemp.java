package chapter05;

import java.time.Duration;
import java.util.List;

public class MovieTemp {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountConditionTemp> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return this.fee.minus(calculateDiscountAmount());
        }

        return this.fee;
    }

    private Money calculateDiscountAmount() {
        switch (movieType) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountAmount();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountAmount();
            case NONE_DISCOUNT:
                return calculateNoneDiscountAmount();
        }

        throw new IllegalStateException();
    }

    private Money calculateNoneDiscountAmount() {
        return Money.ZERO;
    }

    private Money calculatePercentDiscountAmount() {
        return this.fee.times(discountPercent);
    }

    private Money calculateAmountDiscountAmount() {
        return this.discountAmount;
    }

    private boolean isDiscountable(Screening screening) {
        return this.discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }
}
