package pl.airborn.stream.split;

import java.util.function.Function;

class Transformation3 implements Function<Step3, Step4> {

    @Override
    public Step4 apply(Step3 step3) {
        Status status = step3.step2.step1.id == 4 ? Status.NOK3 : Status.OK;
        return new Step4(status, step3);
    }
}
