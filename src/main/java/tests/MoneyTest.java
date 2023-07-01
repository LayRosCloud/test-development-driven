package tests;

import models.Bank;
import models.IExpression;
import models.Money;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {
    @Test
    public void testMultiplication(){
        Money money = Money.dollar(5);//создания 5 долларов

        assertEquals(Money.dollar(10), money.times(2)); //сравнение 10 долларов и умножения долларов
        assertNotEquals(Money.franc(10), money.times(2)); //сравнение 10 франков и умножения долларов
    }

    @Test
    public void testSimpleAddition(){
        //Создаем пять долларов
        Money five = Money.dollar(5);

        //Прибавляем 5 долларов друг к другу и получаем новый объект Expression
        IExpression sum = five.plus(five);

        //Создаем банк, он будет ответственнен за конвертацию валют
        Bank bank = new Bank();

        //Переводим сумму в выбранную нами валюту
        Money reduced = bank.reduce(sum, "USD");

        //Проверяем
        assertEquals(Money.dollar(10), reduced);
    }
}
