package model;

public class WeatherApp {
	protected String name;
	protected int maxStations;
	protected WeatherStation[] stations;
	protected int nos;
	protected String type;
	
	public WeatherApp(String name, int maxStations) {
		this.name = name;
		this.maxStations = maxStations;
		this.stations = new WeatherStation[this.maxStations];
		this.nos = 0;
		
		if (this instanceof SensorApp) {
			this.type = "Sensor";
		}
		else {
			this.type = "Dummy";
		}
	}

	public String getName() {
		return this.name;
	}

	public String getType() {
		return this.type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void connect(WeatherStation station) {
		this.stations[this.nos] = station;
		this.nos++;
	}
	
	
}
