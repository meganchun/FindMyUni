import org.jxmapviewer.viewer.GeoPosition;

import com.opencagedata.jopencage.JOpenCageGeocoder;
import com.opencagedata.jopencage.model.JOpenCageForwardRequest;
import com.opencagedata.jopencage.model.JOpenCageLatLng;
import com.opencagedata.jopencage.model.JOpenCageResponse;

//This class will create university objects 
public class University {

	// fields
	private String name;
	private String address;
	private String phoneNumber;
	private String link;

	private GeoPosition coordinates;

	// constructor
	public University(String name, String address, String phoneNumber, String link) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.link = link;
		//create coordinates based on the address
		convertAddressToCoordinates();
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public GeoPosition getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(GeoPosition coordinates) {
		this.coordinates = coordinates;
	}

	// utility method
	public void convertAddressToCoordinates() {
		// from: https://opencagedata.com/tutorials/geocode-in-java
		JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder("96277ef1eefd402d885b71ff62b12a95");
		
		//get the request for the coordinates based on the address
		JOpenCageForwardRequest request = new JOpenCageForwardRequest(address);
		System.out.println(name);
		request.setRestrictToCountryCode("ca"); // restrict results to a specific country

		//Actually geocode for the coordinates based on the address
		JOpenCageResponse response = jOpenCageGeocoder.forward(request);
		//Accept the first pair or coordinates it gives
		JOpenCageLatLng firstResultLatLng = response.getFirstPosition(); // get the coordinate pair of the first result
		System.out.println(firstResultLatLng.getLat().toString() + "," + firstResultLatLng.getLng().toString());

		System.out.println(link);
		//set the coordinates of the university
		setCoordinates(new GeoPosition(firstResultLatLng.getLat(), firstResultLatLng.getLng()));

	}

	// toString method
	@Override
	public String toString() {
		return "University [name=" + name +  ", address=" + address + ", phoneNumber=" + phoneNumber + ", link="
				+ link + "]";
	}

}
