package com.example.testpatterns.builder.senior;

public class Computer {
    private String cpu;
    private String screen;
    private String memory;
    private String mainboard;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.screen = builder.screen;
        this.memory = builder.memory;
        this.mainboard = builder.mainboard;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMainboard() {
        return mainboard;
    }

    public void setMainboard(String mainboard) {
        this.mainboard = mainboard;
    }

    public static final class Builder {
        private String cpu;
        private String screen;
        private String memory;
        private String mainboard;

        public Builder() {
        }

        public Builder cpu(String val) {
            this.cpu = val;
            return this;
        }

        public Builder screen(String val) {
            this.screen = val;
            return this;
        }

        public Builder memory(String val) {
            this.memory = val;
            return this;
        }

        public Builder mainboard(String val) {
            this.mainboard = val;
            return this;
        }

        public Computer commit() {
            return new Computer(this);
        }
    }
}
