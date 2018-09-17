package com.example.testpatterns.eventsourcing.event;


import com.example.testpatterns.eventsourcing.domain.Account;
import com.example.testpatterns.eventsourcing.state.AccountAggregate;

import java.math.BigDecimal;

/**
 * This is the class that implements money transfer event.
 * Holds the necessary info for a money transfer event.
 * Implements the process function that finds the event related
 * domain objects and calls the related domain object's handle event functions
 *
 * Created by Serdar Hamzaogullari on 06.08.2017.
 */
public class MoneyTransferEvent extends DomainEvent {

  private final BigDecimal money;
  private final int accountNoFrom;
  private final int accountNoTo;

  /**
   * Instantiates a new Money transfer event.
   *
   * @param sequenceId the sequence id
   * @param createdTime the created time
   * @param money the money
   * @param accountNoFrom the account no from
   * @param accountNoTo the account no to
   */
  public MoneyTransferEvent(long sequenceId, long createdTime, BigDecimal money, int accountNoFrom,
      int accountNoTo) {
    super(sequenceId, createdTime, "MoneyTransferEvent");
    this.money = money;
    this.accountNoFrom = accountNoFrom;
    this.accountNoTo = accountNoTo;
  }

  /**
   * Gets money.
   *
   * @return the money
   */
  public BigDecimal getMoney() {
    return money;
  }

  /**
   * Gets account no which the money comes from.
   *
   * @return the account no from
   */
  public int getAccountNoFrom() {
    return accountNoFrom;
  }

  /**
   * Gets account no which the money goes to.
   *
   * @return the account no to
   */
  public int getAccountNoTo() {
    return accountNoTo;
  }

  @Override
  public void process() {
    Account accountFrom = AccountAggregate.getAccount(accountNoFrom);
    if (accountFrom == null) {
      throw new RuntimeException("Account not found " + accountNoFrom);
    }
    Account accountTo = AccountAggregate.getAccount(accountNoTo);
    if (accountTo == null) {
      throw new RuntimeException("Account not found" + accountTo);
    }

    accountFrom.handleTransferFromEvent(this);
    accountTo.handleTransferToEvent(this);
  }
}
