public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        //this.ticketOffice.plusAmount(audience.buy(this.ticketOffice.getTicket()));
        this.ticketOffice.sellTicketTo(audience);
    }
}
