package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean on;
    private final Random random = new Random();

    @Override
    public boolean isOn() {
        return on;
    }

    @Override
    public void setOn() {
        on = true;
    }

    @Override
    public void setOff() {
        on = false;
    }

    @Override
    public int read() {
        if (!on) {
            throw new IllegalStateException("Sensor is off.");
        }
        return random.nextInt(61) - 30;
    }
}
