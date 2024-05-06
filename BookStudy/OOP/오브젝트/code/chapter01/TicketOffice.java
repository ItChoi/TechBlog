package chapter01;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {
    private Long amount; // 판매 금액
    private List<Ticket> tickets = new ArrayList<>(); // 교환 해 줄 티켓 목록

    public TicketOffice(Long amount,
                        Ticket ... tickets) {
        this.amount = amount;
        this.tickets.addAll(List.of(tickets));
    }

    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }

    private Ticket getTicket() {
        return tickets.remove(0);
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }
}
