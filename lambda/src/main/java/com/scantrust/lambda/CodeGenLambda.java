package com.scantrust.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.scantrust.MessageGen;
import com.scantrust.pojo.Batch;
import com.scantrust.pojo.Version;

import java.util.ArrayList;
import java.util.List;

public class CodeGenLambda {

    public String handler(Params params, Context context) {
        List<String> res = new ArrayList<>(params.batch.quantity);
        int[] bits = new int[]{10, 3, 3, 3, 3, 7, 10, 6};

        double[] values = new double[]{
                1d,
                params.batch.code_initial_threshold,
                params.version.density(0),
                params.version.density(1),
                params.version.density(2),
                params.version.density(3),
                params.version.size_cell_in_pixels_QR,
                params.version.size_pattern_in_cells,
        };

        for (int i = 0; i < params.batch.quantity; i++) {
            res.add(MessageGen.generateMessage(
                    bits,
                    values
            ));
        }

        return res.get(0) + " - " + res.get(res.size() - 2) + "count = " + params.batch.quantity;
    }

    public static class Params {
        public Version version;
        public Batch batch;
    }
}
