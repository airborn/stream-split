package pl.airborn.stream.split;

import java.util.function.Function;

class Transformation2 implements Function<Step2, Step3> {

    @Override
    public Step3 apply(Step2 step2) {
        Status status = step2.step1.id == 3 ? Status.NOK2 : Status.OK;
        return new Step3(status, step2);
    }
}
