package pl.airborn.stream.split;

import org.assertj.core.api.iterable.Extractor;
import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StepTransformerTest {

    Extractor<Step4, Integer> idExtractor = step4 -> step4.step3.step2.step1.id;
    Extractor<HasStatus, Status> statusExtractor = HasStatus::getStatus;

    @Test
    public void shouldSplitSuccessfulAndFailedItems() {
        // given
        StepTransformer testObj = new StepTransformer();

        Step1 successful = new Step1(1);
        Step1 failedAtLevel2 = new Step1(2);
        Step1 failedAtLevel3 = new Step1(3);
        Step1 failedAtLevel4 = new Step1(4);

        List<Step1> steps = Arrays.asList(successful, failedAtLevel2, failedAtLevel3, failedAtLevel4);

        // when
        Tuple2<Seq<Step4>, Seq<HasStatus>> maped = testObj.transform(steps);

        // then
        assertThat(maped.v1.toList()).extracting(idExtractor).containsExactly(1);
        assertThat(maped.v2.toList()).extracting(statusExtractor).containsExactly(Status.NOK1, Status.NOK2, Status.NOK3);
    }
}
