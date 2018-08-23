package com.example.testpatterns.databus;

/**
 * Base for data to send via the Data-Bus.
 *
 * @author Paul Campbell (pcampbell@kemitix.net)
 */
public class AbstractDataType implements DataType {

  private DataBus dataBus;

  @Override
  public DataBus getDataBus() {
    return dataBus;
  }

  @Override
  public void setDataBus(DataBus dataBus) {
    this.dataBus = dataBus;
  }
}
