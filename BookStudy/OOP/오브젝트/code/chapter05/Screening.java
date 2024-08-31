package chapter05;

import java.time.LocalDateTime;

public class Screening {
    private MovieTemp movie;
    private int sequence;
    private LocalDateTime whenScreened;

    // msg: 예약해라
    public Reservation reserve(Customer customer,
                               int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    // msg: 계산해라
    private Money calculateFee(int audienceCount) {
        return this.movie.calculateMovieFee(this).times(audienceCount);
    }

    public MovieTemp getMovie() {
        return movie;
    }

    public int getSequence() {
        return sequence;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }
}
