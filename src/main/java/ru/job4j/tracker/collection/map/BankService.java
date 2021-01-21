package ru.job4j.tracker.collection.map;

import java.util.*;

/**
 * Класс описывает работу банковских сервисов.
 * @author ILYA KOVALEV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных о пользоваетлях и их банковских счетах,
     * осуществляется с помощью коллекции типа HashMap.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход держателя банковского счета
     * и добавляет в коллекцию ysers если его там нет.
     * @param user держатель банковского счета.
     */
    public void addUser(User user) {
        List<Account> listReq = new ArrayList<>();
        users.putIfAbsent(user, listReq);
    }

    /**
     * Метод принимает 2 параметра паспорт и банковский счет.
     * Метод ищет держателя банковского счета по паспорту,
     * если он найден то добавить ему банковский счет.
     * @param passport паспорт держателя банковсеого счета.
     * @param account банковский счет.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> findUser = findByPassport(passport);
        if (findUser.isPresent()) {
            List<Account> findListReq = users.get(findUser.get());
            if (!findListReq.contains(account)) {
                users.get(findUser.get()).add(account);
            }
        }
    }

    /**
     * Метод ищет держателя банковского счета по номеру паспорта.
     * Принимает на вход номер паспорта.
     * @param passport паспорт держателя банковского счета.
     * @return возвращает держателя банковского счета.
     */
    public Optional<User> findByPassport(String passport) {
        Optional<User> opt = users.keySet().stream()
                    .filter(x -> x.getPassport().equals(passport))
                    .findFirst();
        return opt;
    }

    /**
     * Метод ищет банковский счет по реквезитам.
     * Принимает на вход 2 параметра паспорт и реквизиты держателя
     * банковского счета, ищет есть ли держатель в системе,
     * а уже после ищет его по реквизитам.
     * @param passport паспорт держателя банковского счета.
     * @param requisite реквизиты банковского счета.
     * @return возвращает банковский счет.
     */
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

    /**
     * Метод реализует первод денежных средств со одного счета
     * на другой.
     * Принимает на вход 5 параметров
     * @param srcPassport паспорт отправителя
     * @param srcRequisite реквизиты банковского счета отправителя
     * @param destPassport паспорт пполучателя
     * @param destRequisite реквизиты банковского счета получателя
     * @param amount сумма перевода
     * @return возвращает true если операция прошла успешно
     * и false если это не так.
     */
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
