package tests;

import models.Bank;
import models.IExpression;
import models.Money;
import models.Sum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {
    @Test
    public void testMultiplication(){
        Money money = Money.dollar(5);//создания 5 долларов

        assertEquals(Money.dollar(10), money.times(2)); //сравнение 10 долларов и умножения долларов
        assertNotEquals(Money.franc(10), money.times(2)); //сравнение 10 франков и умножения долларов
    }

    @Test
    public void testSimpleAddition(){
        IExpression sum = new Sum(Money.dollar(5),Money.dollar(5));

        //Создаем банк, он будет ответственен за конвертацию валют
        Bank bank = new Bank();

        //Переводим сумму в выбранную нами валюту
        Money reduced = bank.reduce(sum, "USD");

        //Проверяем
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testReduceMoneyDifferentCurrency(){
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }
    @Test
    public void testIdentityRate(){
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    public void testMixedAddition(){
        IExpression fiveBucks = Money.dollar(5);
        IExpression tenFrancs = Money.franc(10);

        Bank bank = new Bank();

        bank.addRate("CHF", "USD", 2);

        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");

        assertEquals(Money.dollar(10), result);
    }
    @Test
    public void testSumPlusMoney(){
        IExpression fiveBucks = Money.dollar(5);
        IExpression tenFrancs = Money.franc(10);

        Bank bank = new Bank();

        bank.addRate("CHF", "USD", 2);

        IExpression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);

        Money result = bank.reduce(sum, "USD");

        assertEquals(Money.dollar(15), result);
    }
    @Test
    public void testSumTimes(){
        IExpression fiveBucks = Money.dollar(5);
        IExpression tenFrancs = Money.franc(10);

        Bank bank = new Bank();

        bank.addRate("CHF", "USD", 2);

        IExpression sum = new Sum(fiveBucks, tenFrancs).times(2);

        Money result = bank.reduce(sum, "USD");

        assertEquals(Money.dollar(20).amount(), result.amount());
    }

    @Test
    public void testPlusSameCurrencyReturnsMoney(){
        IExpression sum = Money.dollar(1).plus(Money.dollar(1));
        assertFalse(sum instanceof Money);
    }
}
