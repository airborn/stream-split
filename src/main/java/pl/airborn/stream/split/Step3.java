package pl.airborn.stream.split;

class Step3 implements HasStatus {
    public final Status status;
    public final Step2 step2;

    Step3(Status status, Step2 step2) {
        this.status = status;
        this.step2 = step2;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Step3{" +
                "status=" + status +
                ", step2=" + step2 +
                '}';
    }
}
