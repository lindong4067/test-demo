/*
 *         File : SetRequest.java
 *    Classname : SetRequest
 *    Author(s) : eznlzhi
 *      Created : 2018-10-15
 *
 *
 */

package com.example.testframe.akka.demy;

import java.io.Serializable;

public class SetRequest implements Serializable {
    public final String key;
    public final Object value;

    public SetRequest(String key, Object value) {
        this.key = key;
        this.value = value;
    }
}
