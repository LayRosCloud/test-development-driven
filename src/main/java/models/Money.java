package models;

public record Money(int _amount, String _currency) implements IExpression {

    //Props
    public String currency() { return _currency; }
    public int amount() { return _amount; }

    //Override methods
    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return  money._amount == _amount && money._currency.equals(_currency);
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(this._currency, to);
        return new Money(_amount / rate, to);
    }
    @Override
    public IExpression times(int multiplier) { return new Money(_amount * multiplier, _currency); }
    @Override
    public IExpression plus(IExpression addend){
        return new Sum(this, addend);
    }

    //Static methods
    public static Money dollar(int amount){ return new Money(amount, "USD"); }

    public static Money franc(int amount) { return new Money(amount, "CHF"); }
}
