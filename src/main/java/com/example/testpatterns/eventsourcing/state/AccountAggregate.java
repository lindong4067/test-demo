package com.example.testpatterns.eventsourcing.state;


import com.example.testpatterns.eventsourcing.domain.Account;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the static accounts map holder class.
 * This class holds the state of the accounts.
 *
 * Created by Serdar Hamzaogullari on 06.08.2017.
 */
public class AccountAggregate {

  private static Map<Integer, Account> accounts = new HashMap<>();

  private AccountAggregate() {
  }

  /**
   * Put account.
   *
   * @param account the account
   */
  public static void putAccount(Account account) {
    accounts.put(account.getAccountNo(), account);
  }

  /**
   * Gets account.
   *
   * @param accountNo the account no
   * @return the copy of the account or null if not found
   */
  public static Account getAccount(int accountNo) {
    Account account = accounts.get(accountNo);
    if (account == null) {
      return null;
    }
    return account.copy();
  }

  /**
   * Reset state.
   */
  public static void resetState() {
    accounts = new HashMap<>();
  }
}
