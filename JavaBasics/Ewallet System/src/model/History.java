package model;

public class History {

    private final String name;
    private final String operation;
    private final int amount;

    private History(Builder builder) {
        this.name = builder.name;
        this.operation = builder.operation;
        this.amount = builder.amount;
    }


    public String toString() {
        return "History{" +
                "name ='" + name + '\'' +
                ", operation ='" + operation + '\'' +
                ", amount= " + amount +
                '}';
    }

    public static class Builder {
        private String name;
        private String operation;
        private int amount;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setOperation(String operation) {
            this.operation = operation;
            return this;
        }

        public Builder setAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public History build() {
            return new History(this);
        }

    }
}
