package com.example.testframe.akka.sample.iot;

import java.util.Optional;

public final class RespondTemperature {
    long requestId;

    final Optional<Double> value;

    public RespondTemperature(long requestId, Optional<Double> value) {
        this.requestId = requestId;
        this.value = value;
    }


}
