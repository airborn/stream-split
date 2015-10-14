package pl.airborn.stream.split;

import org.jooq.lambda.Seq;
import org.jooq.lambda.function.Function2;
import org.jooq.lambda.tuple.Tuple2;

interface TransformationApplier<F, T> extends Function2<Seq<F>, Seq<HasStatus>, Tuple2<Seq<T>, Seq<HasStatus>>> {
}
