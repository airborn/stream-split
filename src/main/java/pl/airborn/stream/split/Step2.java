package pl.airborn.stream.split;

class Step2 implements HasStatus {
    public final Status status;
    public final Step1 step1;

    Step2(Status status, Step1 step1) {
        this.status = status;
        this.step1 = step1;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Step2{" +
                "status=" + status +
                ", step1=" + step1 +
                '}';
    }
}
