package chapter01;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        return this.bag.hold(ticket);
    }

    public Bag getBag() {
        return bag;
    }
}
