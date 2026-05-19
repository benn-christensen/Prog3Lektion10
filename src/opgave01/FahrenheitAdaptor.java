package opgave01;

public class FahrenheitAdaptor implements TemperatureSensor {
    private FahrenheitSensor fahrenheitSensor;

    public FahrenheitAdaptor(FahrenheitSensor fahrenheitSensor) {
        this.fahrenheitSensor = fahrenheitSensor;
    }

    @Override
    public double getTemperature() {
        return (fahrenheitSensor.getTemperature() - 32) * 5 / 9;
    }
}
