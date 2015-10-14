package pl.airborn.stream.split;

import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple;
import org.jooq.lambda.tuple.Tuple2;

import java.util.function.Function;
import java.util.function.Predicate;

public class StepTransformer {

    private final Predicate<HasStatus> successfulStatusPredicate = HasStatus -> HasStatus.getStatus() == Status.OK;

    public Tuple2<Seq<Step4>, Seq<HasStatus>> transform(Iterable<Step1> steps) {
        Seq<Step1> seq = Seq.seq(steps);

        Tuple2<Seq<Step1>, Seq<HasStatus>> starting = Tuple.tuple(seq, Seq.empty());

        TransformationApplier<Step1, Step2> transformationApplier1 = createTransformationApplier(new Transformation1());
        TransformationApplier<Step2, Step3> transformationApplier2 = createTransformationApplier(new Transformation2());
        TransformationApplier<Step3, Step4> transformationApplier3 = createTransformationApplier(new Transformation3());

        return starting
                .map(transformationApplier1)
                .map(transformationApplier2)
                .map(transformationApplier3);
    }

    <F, T extends HasStatus> TransformationApplier<F, T> createTransformationApplier(Function<F, T> transformation) {
        return (steps, errors) -> steps
                .map(transformation)
                .partition(successfulStatusPredicate)
                .map2(newErrors -> errors.concat(newErrors.cast(HasStatus.class)));
    }
}
