package ru.job4j.tracker.collection.map;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> listReq = new ArrayList<>();
        users.putIfAbsent(user, listReq);
    }

    public void addAccount(String passport, Account account) {
        Optional<User> findUser = findByPassport(passport);
        if (findUser.isPresent()) {
            List<Account> findListReq = users.get(findUser.get());
            if (!findListReq.contains(account)) {
                users.get(findUser.get()).add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> opt = users.keySet().stream()
                    .filter(x -> x.getPassport().equals(passport))
                    .findFirst();
        return opt;
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> findU = findByPassport(passport);
        Optional<Account> find = Optional.empty();
        if (findU.isPresent()) {
            find = users.get(findU.get()).stream()
                    .filter(x -> x.getRequisite().equals(requisite))
                    .findFirst();
        }
        return find;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = true;
        Optional<Account> accountSend = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSend.isEmpty() || accountDest.isEmpty()
                || accountSend.get().getBalance() < amount) {
            rsl = false;
        } else {
            accountSend.get().setBalance(accountSend.get().getBalance() - amount);
            accountDest.get().setBalance(accountDest.get().getBalance() + amount);
        }
        return rsl;
    }
}
