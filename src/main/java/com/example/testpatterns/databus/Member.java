package com.example.testpatterns.databus;

import java.util.function.Consumer;

/**
 * Members receive events from the Data-Bus.
 *
 * @author Paul Campbell (pcampbell@kemitix.net)
 */
public interface Member extends Consumer<DataType> {

  void accept(DataType event);
}
