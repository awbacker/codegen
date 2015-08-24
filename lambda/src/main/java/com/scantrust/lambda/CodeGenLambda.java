package com.scantrust.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.scantrust.pojo.Batch;
import com.scantrust.pojo.Version;

public class CodeGenLambda {

    public String handler(Params params, Context context) {
        return "Decoded OK";
    }

    public static class Params {
        public Version version;
        public Batch batch;
    }
}
