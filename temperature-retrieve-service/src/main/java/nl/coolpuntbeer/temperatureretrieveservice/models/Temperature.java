package nl.coolpuntbeer.temperatureretrieveservice.models;

public class Temperature {
    private String sensorId;
    private double ambientTemperature;
    private double objectTemperature;

    public Temperature(String sensorId, double ambientTemperature, double objectTemperature) {
        this.sensorId = sensorId;
        this.ambientTemperature = ambientTemperature;
        this.objectTemperature = objectTemperature;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public double getAmbientTemperature() {
        return ambientTemperature;
    }

    public void setAmbientTemperature(double ambientTemperature) {
        this.ambientTemperature = ambientTemperature;
    }

    public double getObjectTemperature() {
        return objectTemperature;
    }

    public void setObjectTemperature(double objectTemperature) {
        this.objectTemperature = objectTemperature;
    }
}
