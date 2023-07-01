package models;

public class Money implements IExpression {
    private int amount;
    private String currency;
    public Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    public String currency() { return currency; }
    public Money times(int multiplier){ return new Money(amount * multiplier, currency); }
    public IExpression plus(Money addend){
        return new Money(amount + addend.amount, currency);
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return  money.amount == amount && money.currency.equals(currency);
    }

    public static Money dollar(int amount){ return new Money(amount, "USD"); }

    public static Money franc(int amount) { return new Money(amount, "CHF"); }
}
