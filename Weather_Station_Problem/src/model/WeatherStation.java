package model;

public class WeatherStation {
	private String name;
	private int maxApps;
	private WeatherApp[] apps;
	private int noa;

	public WeatherStation(String name) {
		/* 
		 * Create a weather station with the specified name.
		 */
		this.name = name;
		this.maxApps = 2;
		this.apps = new WeatherApp[this.maxApps];
		this.noa = 0;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumApps() {
		return this.noa;
	}

	public WeatherApp[] getInternalAppsArray() {
		return this.apps;
	}

	public WeatherApp[] getApps() {
		WeatherApp[] wa = new WeatherApp[this.noa];
		for (int i = 0; i < this.noa; i++) {
			wa[i] = this.apps[i];
		}
		return wa;
	}

	public void connect(WeatherApp app) {
		/* 
		 * Connect `app1` to `station1` (which symmetrically also connects `station1` to `app1`). 		 * 
		 * You can assume that a weather app, once added to a weather station, will not be added to that station again.
		 * 
		 * For simplicity, in the return value of the toString method,
		 * 	spell `1 apps`, `2 apps`, `1 stations`, `2 stations`, and etc.
		 * Recall: The default size of a station WeatherApp array is 2.
		 * If another WeatherApp wants to be connected when the capacity is full, 
		 * you should grow the array size to to hold 3 more weather apps, and then add the app.
		 * E.g. 2 --> 5 --> 8 --> 11 etc...
		 */
		// updates on 'this'
		if (this.noa == this.maxApps) {
			this.maxApps += 3;
			
			WeatherApp[] wa = new WeatherApp[this.maxApps];
			for (int i = 0; i < this.noa; i++) {
				wa[i] = this.apps[i];
			}
			this.apps = wa;
		}
		this.apps[this.noa] = app;
		this.noa++;
		
		// updates on 'app'
		app.connect(this);
	}
	
	public DummyApp[] getDummyApps() {
		/*
		 * Get all the apps that are dynamically dummy apps
		 * that are connected to the station context object.
		 * If there are no dummyApps connected, return an empty array.
		 */
		int count = 0;
		int[] indices = new int[this.noa];
		
		for (int i = 0; i < this.noa; i++) {
			if (this.apps[i] instanceof DummyApp) {
				indices[count] = i;
				count++;
			}
		}
		
		DummyApp[] result = new DummyApp[count];
		for (int i = 0; i < count; i++) {
			result[i] = (DummyApp) this.apps[indices[i]];
		}
		return result;
	}

	public String toString() {
		String result = null;
		if (this.noa == 0) {
			result = String.format("%s has no connected apps.", this.name);
		}
		else {
			String list = "<";
			for (int i = 0; i < this.noa; i++) {
				list += String.format("Weather %s App %s", this.apps[i].getType(), this.apps[i].getName());
				if (i < this.noa - 1) {
					list += ", ";
				}
			}
			list += ">";
			result = String.format("%s is connected by %d apps: %s.", this.name, this.noa, list);
		}
		
		return result;
	}
}
