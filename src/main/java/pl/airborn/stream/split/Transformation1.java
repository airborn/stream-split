package pl.airborn.stream.split;

import java.util.function.Function;

class Transformation1 implements Function<Step1, Step2> {

    @Override
    public Step2 apply(Step1 step1) {
        Status status = step1.id == 2 ? Status.NOK1 : Status.OK;
        return new Step2(status, step1);
    }
}
