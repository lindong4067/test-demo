package com.example.testpatterns.builder.senior;

public class Bike {
    private String Frame;
    private String Seat;
    private String Tire;

    public Bike() {
    }

    public Bike(Builder builder) {
        this.Frame = builder.frame;
        this.Seat = builder.seat;
        this.Tire = builder.tire;
    }

    public String getFrame() {
        return Frame;
    }

//    public void setFrame(String frame) {
//        Frame = frame;
//    }

    public Bike setFrame(String frame) {
        Frame = frame;
        return this;
    }

    public String getSeat() {
        return Seat;
    }

//    public void setSeat(String seat) {
//        Seat = seat;
//    }

    public Bike setSeat(String seat) {
        Seat = seat;
        return this;
    }

    public String getTire() {
        return Tire;
    }

//    public void setTire(String tire) {
//        Tire = tire;
//    }

    public Bike setTire(String tire) {
        Tire = tire;
        return this;
    }

    public static final class Builder {
        private String frame;
        private String seat;
        private String tire;

        public Builder frame(String frame) {
            this.frame = frame;
            return this;
        }

        public Builder seat(String seat) {
            this.seat = seat;
            return this;
        }

        public Builder tire(String tire) {
            this.tire = tire;
            return this;
        }

        public Bike build(){
            return new Bike(this);
        }
    }


}
