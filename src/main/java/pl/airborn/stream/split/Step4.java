package pl.airborn.stream.split;

public class Step4 implements HasStatus {
    public final Status status;
    public final Step3 step3;

    Step4(Status status, Step3 step3) {
        this.status = status;
        this.step3 = step3;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Step4{" +
                "status=" + status +
                ", step3=" + step3 +
                '}';
    }
}
