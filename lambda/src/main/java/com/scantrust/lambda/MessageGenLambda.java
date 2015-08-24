package com.scantrust.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.scantrust.MessageGen;

public class MessageGenLambda {

    public String handler(MessageGenParams params, Context context) {
        return MessageGen.generateMessage(
                params.bits.stream().mapToInt(i -> i).toArray(),
                params.values.stream().mapToDouble(i -> i).toArray()
        );
    }

}
