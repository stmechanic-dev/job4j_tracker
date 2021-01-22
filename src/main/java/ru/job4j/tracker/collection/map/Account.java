package ru.job4j.tracker.collection.map;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета.
 * @author ILYA KOVALEV
 * @version 1.0
 */
public class Account {
    /**
     * Реквезиты счета хранятся в поле типа String.
     * Баланс счета хранится в поле типа double.
     */
    private String requisite;
    private double balance;

    /**
     * Метод принимает на вход реквизиты и баланс счета
     * и присваивает эти значения переменным объекта.
     * @param requisite реквизиты которые присваиваются объекту.
     * @param balance баланс который присваивается объекту.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод предоставляет данные по реквизитам счета.
     * @return возвращает реквизиты объекта.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод присваивает реквизиты объекту.
     * @param requisite реквизиты счета.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }
    /**
     * Метод предоставляет данные по балансу счета.
     * @return возвращает баланс объекта.
     */

    public double getBalance() {
        return balance;
    }

    /**
     * Метод устанавливает баланс счета.
     * @param balance баланс счета.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределенный метод из класса Object
     * Сравнивает два объекта, принимает на вход объект,
     * который сравнивается с объектом вызвавшим этот метод.
     * @param o входной параметр.
     * @return возвращает значение true или false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод сравнивает объекты по hashCode
     * @return возвращает параметр типа int
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
