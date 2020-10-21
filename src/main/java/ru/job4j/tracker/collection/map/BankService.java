package ru.job4j.tracker.collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        User find = null;
        for (User u : users.keySet()) {
            if (u.getPassport().equals(passport)) {
                find = u;
                break;
            }
        }
        return find;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account find = null;
        User findU = findByPassport(passport);
        if (findU != null) {
            List<Account> listReq = users.get(findU);
            for (Account a : listReq) {
                if (a.getRequisite().equals(requisite)) {
                    find = a;
                    break;
                }
            }
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
