package ru.job4j.tracker.collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> listReq = new ArrayList<>();
        users.putIfAbsent(user, listReq);
    }

    public void addAccount(String passport, Account account) {
        User findUser = findByPassport(passport);
        if (findUser != null) {
            List<Account> findListReq = users.get(findUser);
            if (!findListReq.contains(account)) {
                users.get(findUser).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User find = users.keySet().stream()
                    .filter(x -> x.getPassport().equals(passport))
                    .findFirst().orElse(null);
        return find;
    }

    public Account findByRequisite(String passport, String requisite) {
        User findU = findByPassport(passport);
        Account find = null;
        if (findU != null) {
            find = users.get(findU).stream()
                    .filter(x -> x.getRequisite().equals(requisite))
                    .findFirst().orElse(null);
        }
        return find;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = true;
        Account accountSend = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
        if (accountSend == null || accountDest == null || accountSend.getBalance() < amount) {
            rsl = false;
        } else {
            accountSend.setBalance(accountSend.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
        }
        return rsl;
    }
}
