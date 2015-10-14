package pl.airborn.stream.split;

import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Step1> steps = Arrays.asList(new Step1(1), new Step1(2), new Step1(3), new Step1(4));

        StepTransformer stepTransformer = new StepTransformer();
        Tuple2<Seq<Step4>, Seq<HasStatus>> map = stepTransformer.transform(steps);

        System.out.println("Successful:");
        map.v1.forEach(System.out::println);
        System.out.println("============");
        System.out.println("failed:");
        map.v2.forEach(System.out::println);
    }
}
