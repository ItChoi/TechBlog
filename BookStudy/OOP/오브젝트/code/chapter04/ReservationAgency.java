package chapter04;

import chapter02.Money;

public class ReservationAgency {
    public Reservation reserve(Screening screening,
                               Customer customer,
                               int audienceCount) {
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
