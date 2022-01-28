package ru.job4j.bank;

import java.util.*;

/**
 * Класс для работы банка с пользователями и их счетами
 * @author georgiy
 * @version 1.0
 */
public class BankService {
    /**
     * Содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему
     * @param user добавляемый пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет к пользователю
     * @param passport номер паспорта пользователя
     * @param account счет пользователя
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }

    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * @param passport номер паспорта пользователя
     * @return возвращает пользователя либо null, если пользователь не найден
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst();
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты счета пользователя
     * @return возвращает счет пользователя либо null, если пользователь не найден
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(value -> users.get(value).stream()
                .filter(account -> requisite.equals(account.getRequisite()))
                .findFirst());
    }

    /**
     * Метод выполняет перечисление денег с одного счета на другой счет
     * @param srcPassport номер паспорта пользователя, который переводит деньги
     * @param srcRequisite реквизиты пользователя, который переводит деньги
     * @param destPassport номер паспорта получателя денег
     * @param destRequisite реквизиты получателя денег
     * @param amount сумма для перевода
     * @return возвращает false, если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят)
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccountOpt = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccountOpt = findByRequisite(destPassport, destRequisite);
        if (srcAccountOpt.isPresent() && destAccountOpt.isPresent()) {
            Account srcAccount = srcAccountOpt.get();
            Account destAccount = destAccountOpt.get();
            if (srcAccount.getBalance() >= amount) {
                destAccount.setBalance(destAccount.getBalance() + amount);
                srcAccount.setBalance(srcAccount.getBalance() - amount);
                rsl = true;
            }
        }
        return rsl;
    }
}
