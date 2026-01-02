package model;

public class WeatherPerson {
	/*
	 * Create a WeatherPerson and set their name.
	 * Assume the maximum number of WeatherApps a WeatherPerson can have is 100, 
	 * Assume: more than 100 will never be added. No exception handling required.
	 */
	
	private static WeatherPerson instance;
	private String name;
	private WeatherApp[] apps;
	private int noa;
	private final int MAX_APPS = 100;
	
	
	public WeatherPerson() {
		instance = this;
		this.apps = new WeatherApp[MAX_APPS];
		this.noa = 0;
	}

	public static WeatherPerson getInstance() {
		if (instance == null) {
			instance = new WeatherPerson();
		}
		return instance;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WeatherApp[] getWeatherApps() {
		return this.apps;
	}

	public void addApp(WeatherApp app) {
		this.apps[this.noa] = app;
		this.noa++;
	}

	public static void resetWeatherPerson() {
		instance = new WeatherPerson();
	}
	
	public String toString() {
		int numSensorApps = 0;
		int numDummyApps = 0;
		for (int i = 0; i < this.noa; i++) {
			if (this.apps[i] instanceof SensorApp) {
				numSensorApps++;
			}
			else {
				numDummyApps++;
			}
		}
		return String.format("%s has  %d sensor apps and %d dummy apps.", this.name, numSensorApps, numDummyApps);
	}

}
