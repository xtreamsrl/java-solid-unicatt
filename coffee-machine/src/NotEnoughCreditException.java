public class NotEnoughCreditException extends RuntimeException {
    private final long cost;
    private final long credit;

    public NotEnoughCreditException(long cost, long credit) {
        this.cost = cost;
        this.credit = credit;
    }

    public long getCost() {
        return cost;
    }

    public long getCredit() {
        return credit;
    }
}
