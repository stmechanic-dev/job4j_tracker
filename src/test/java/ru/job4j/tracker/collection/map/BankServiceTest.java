package ru.job4j.tracker.collection.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void addUser() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        Optional<User> opt = bank.findByPassport("3434");
        opt.ifPresent(value -> assertThat(value, is(user)));
    }

    @Test
    public void whenEnterInvalidPassport() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        Optional<Account> opt = bank.findByRequisite("34", "5546");
        opt.ifPresent(Assert::assertNull);
    }

    @Test
    public void addAccount() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        Optional<Account> opt = bank.findByRequisite("3434", "5546");
        opt.ifPresent(account -> assertThat(account.getBalance(), is(150D)));
    }

    @Test
    public void transferMoney() {
        User user = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user);
        bank.addAccount(user.getPassport(), new Account("5546", 150D));
        bank.addAccount(user.getPassport(), new Account("113", 50D));
        bank.transferMoney(user.getPassport(), "5546"
                        , user.getPassport(), "113", 150D);
        Optional<Account> opt = bank.findByRequisite(user.getPassport(), "113");
        opt.ifPresent(balance -> assertThat(balance.getBalance(), is(200D)));
    }
}