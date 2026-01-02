package model;

public class SensorApp extends WeatherApp {

	public SensorApp(String name, int maxStations) {
		/*
		 * Create a weather sensor app with the specified name and maximum 20 connected weather stations.
		 * No error handling is needed when a preset maximum is exceeded: let the ArrayIndexOutOfBoundsException occur.
		 */
		super(name, maxStations);
	}
	
	public DummyApp[] getConnectedDummysOf(String station) {
		/*
		 * For the weather station that is connected to the context sensor object, 
		 * retrieve the list of dummy apps that are connected to that weather station.
		 * The order of the dummy apps should correspond to the order they are in the WeatherStation object.
		 * If there are no connected dummy apps, return an empty array.
		 */
		boolean found = false;
		int index = -1;
		// Step 1: find the station with the corresponding name
		for (int i = 0; !found && i < this.nos; i++) {
			if (this.stations[i].getName().equals(station)) {
				// station found
				found = true;
				index = i;
			}
		}
		if (found) {
			return this.stations[index].getDummyApps();
		}
		else {
			return new DummyApp[0];
		}
	}
	
	public String toString() {
		String result = null;
		if (this.nos == 0) {
			result = String.format("Weather Sensor App %s is connected to no stations.", this.name);
		}
		else {
			String list = "<";
			for (int i = 0; i < this.nos; i++) {
				list += this.stations[i].getName();
				if (i < this.nos - 1) {
					list += ", ";
				}
			}
			list += ">";
			result = String.format("Weather Sensor App %s is connected to %d stations: %s.", this.name, this.nos, list);
		}
		return result;
	}

}
