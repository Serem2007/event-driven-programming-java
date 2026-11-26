import java.util.Observable;
@SuppressWarnings("deprecation")
public class LegacyWeatherData extends Observable {
 private float temperature,humidity;
 public void setMeasurements(float temperature,float humidity){ this.temperature=temperature; this.humidity=humidity; setChanged(); notifyObservers(); }
 public float getTemperature(){return temperature;} public float getHumidity(){return humidity;}
}
