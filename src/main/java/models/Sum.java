package models;

public record Sum(IExpression _augend, IExpression _addend) implements IExpression{

    public Money reduce(Bank bank, String to){
        int amount = _augend.reduce(bank, to).amount() + _addend.reduce(bank, to).amount();
        return new Money(amount, to);
    }

    @Override
    public IExpression plus(IExpression addend) {
        return new Sum(this, addend);
    }

    @Override
    public IExpression times(int multiplier) {
        return new Sum(_augend.times(multiplier), _addend.times(multiplier));
    }
}
