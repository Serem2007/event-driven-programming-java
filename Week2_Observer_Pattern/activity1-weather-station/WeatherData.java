import java.util.ArrayList; import java.util.List;
public class WeatherData implements Subject {
 private final List<Observer> observers = new ArrayList<>();
 private float temperature, humidity, pressure;
 public void registerObserver(Observer o){ observers.add(o); System.out.println("[WeatherData] Observer registered: "+o.getClass().getSimpleName()); }
 public void removeObserver(Observer o){ observers.remove(o); System.out.println("[WeatherData] Observer removed: "+o.getClass().getSimpleName()); }
 public void notifyObservers(){ for(Observer o: observers) o.update(temperature,humidity,pressure); }
 public void setMeasurements(float temperature,float humidity,float pressure){ this.temperature=temperature; this.humidity=humidity; this.pressure=pressure; System.out.println("\n[WeatherData] New measurements received!"); notifyObservers(); }
}
