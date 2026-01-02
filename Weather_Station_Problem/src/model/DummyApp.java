package model;

public class DummyApp extends WeatherApp {

	public DummyApp(String name, int maxStations) {
		/*
		 * Create a weather dummy app with the specified name and maximum 20 connected weather stations.
		 * The dummy app is a still in the making so it doesn't do anything besides have a toString. 
		 * No error handling is needed when a preset maximum is exceeded: let the ArrayIndexOutOfBoundsException occur.
		 */
		super(name, maxStations);
	}
	
	public String toString() {
		String result = null;
		if (this.nos == 0) {
			result = String.format("Weather Dummy App %s is connected to no stations.", this.name);
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
			result = String.format("Weather Dummy App %s is connected to %d stations: %s.", this.name, this.nos, list);
		}
		return result;
	}

}
