package com.example.testpatterns.eventsourcing.app;

import java.math.BigDecimal;
import java.util.Date;

import com.example.testpatterns.eventsourcing.event.AccountCreateEvent;
import com.example.testpatterns.eventsourcing.event.MoneyDepositEvent;
import com.example.testpatterns.eventsourcing.event.MoneyTransferEvent;
import com.example.testpatterns.eventsourcing.processor.DomainEventProcessor;
import com.example.testpatterns.eventsourcing.state.AccountAggregate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Event Sourcing : Instead of storing just the current state of the data in a domain, use an
 * append-only store to record the full series of actions taken on that data. The store acts as the
 * system of record and can be used to materialize the domain objects. This can simplify tasks in
 * complex domains, by avoiding the need to synchronize the data model and the business domain,
 * while improving performance, scalability, and responsiveness. It can also provide consistency for
 * transactional data, and maintain full audit trails and history that can enable compensating
 * actions.
 *
 * This App class is an example usage of Event Sourcing pattern. As an example, two bank account is
 * created, then some money deposit and transfer actions are taken so a new state of accounts is
 * created. At that point, state is cleared in order to represent a system shot down. After the shot
 * down, system state is recovered by re-creating the past events from event journal. Then state is
 * printed so a user can view the last state is same with the state before system shot down.
 *
 * Created by Serdar Hamzaogullari on 06.08.2017.
 */
public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
  /**
   * The constant ACCOUNT OF DAENERYS.
   */
  public static final int ACCOUNT_OF_DAENERYS = 1;
  /**
   * The constant ACCOUNT OF JON.
   */
  public static final int ACCOUNT_OF_JON = 2;

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {

    DomainEventProcessor eventProcessor = new DomainEventProcessor();


    LOGGER.info("Running the system first time............");
    eventProcessor.reset();

    LOGGER.info("Creating th accounts............");

    eventProcessor.process(new AccountCreateEvent(
        0, new Date().getTime(), ACCOUNT_OF_DAENERYS, "Daenerys Targaryen"));

    eventProcessor.process(new AccountCreateEvent(
        1, new Date().getTime(), ACCOUNT_OF_JON, "Jon Snow"));

    LOGGER.info("Do some money operations............");

    eventProcessor.process(new MoneyDepositEvent(
        2, new Date().getTime(), ACCOUNT_OF_DAENERYS,  new BigDecimal("100000")));

    eventProcessor.process(new MoneyDepositEvent(
        3, new Date().getTime(), ACCOUNT_OF_JON,  new BigDecimal("100")));

    eventProcessor.process(new MoneyTransferEvent(
        4, new Date().getTime(), new BigDecimal("10000"), ACCOUNT_OF_DAENERYS,
        ACCOUNT_OF_JON));

    LOGGER.info("...............State:............");
    LOGGER.info(AccountAggregate.getAccount(ACCOUNT_OF_DAENERYS).toString());
    LOGGER.info(AccountAggregate.getAccount(ACCOUNT_OF_JON).toString());

    LOGGER.info("At that point system had a shot down, state in memory is cleared............");
    AccountAggregate.resetState();

    LOGGER.info("Recover the system by the events in journal FileNIO............");

    eventProcessor = new DomainEventProcessor();
    eventProcessor.recover();

    LOGGER.info("...............Recovered State:............");
    LOGGER.info(AccountAggregate.getAccount(ACCOUNT_OF_DAENERYS).toString());
    LOGGER.info(AccountAggregate.getAccount(ACCOUNT_OF_JON).toString());
  }


}
