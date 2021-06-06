package cool.beer.handlingformsubmission.models;

//    Example or returned JSON object
//    ambientTemperature	"19.73"
//    objectTemperature	"18.85"

public class TemperatureSummary {

    private String id;
    private double ambientTemperature;
    private double objectTemperature;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "sensorID: " + this.id + "\nambientTemperature: " + this.ambientTemperature + "\nobjectTemperature: " + this.objectTemperature;
    }
}
