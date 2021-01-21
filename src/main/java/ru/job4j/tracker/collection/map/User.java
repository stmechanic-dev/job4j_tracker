package ru.job4j.tracker.collection.map;

import java.util.Objects;

/**
 *  Класс описывает модель держателя банковского счета.
 *  @author ILYA KOVALEV
 *  @version 1.0
 */
public class User {
    /**
     * Паспорт держателя хранится в поле типа String.
     * Имя держателя хранится в поле типа String.
     */
    private String passport;
    private String username;

    /**
     * Метод принмает на вход паспорт и имя держатля
     * банковского счета и присваивает эти значения
     * полям объекта.
     * @param passport паспорт держателя банковского счета.
     * @param username имя держателя банковского счета.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод предоставляет данные о паспорте держателя банковского счета.
     * @return возвращает паспорт держателя банковского счета.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод присваивает номер паспорта держателя банковского счета.
     * @param passport паспорт держателя банковского счета.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод предоставляет данные об имени держателя банковского счета.
     * @return возвращает имя держателя банковского счета.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод присваивает имя держателю банковского счета.
     * @param username имя держателя банковского счета.
     */
    public void setUsername(String username) {
        this.username = username;
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод сравнивает объекты по hashCode
     * @return возвращает параметр типа int
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
