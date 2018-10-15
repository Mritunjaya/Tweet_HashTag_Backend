package com.tweet.hashtags.twitter;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

class Root {

    private List<Result> results;
    @Override
	public String toString() {
		return "Root [results=" + results + ", status=" + status + "]";
	}
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String status;

   
}

class Result {

    @JsonProperty("address_components")
    private List<AddressComponent> addressComponents;

    @JsonProperty("formatted_address")
    private String formattedAddress;

    @Override
	public String toString() {
		return "Result [addressComponents=" + addressComponents + ", formattedAddress=" + formattedAddress
				+ ", geometry=" + geometry + ", types=" + types + "]";
	}

	public List<AddressComponent> getAddressComponents() {
		return addressComponents;
	}

	public void setAddressComponents(List<AddressComponent> addressComponents) {
		this.addressComponents = addressComponents;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	private Geometry geometry;

    private List<String> types;

    //getters, setters, toString
}

class AddressComponent {

    @JsonProperty("long_name")
    private String longName;

    @Override
	public String toString() {
		return "AddressComponent [longName=" + longName + ", shortName=" + shortName + ", types=" + types + "]";
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	@JsonProperty("short_name")
    private String shortName;

    private List<String> types;

    //getters, setters, toString
}

class Geometry {

    @Override
	public String toString() {
		return "Geometry [location=" + location + ", locationType=" + locationType + ", viewPort=" + viewPort
				+ ", bounds=" + bounds + "]";
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public ViewPort getViewPort() {
		return viewPort;
	}

	public void setViewPort(ViewPort viewPort) {
		this.viewPort = viewPort;
	}

	public ViewPort getBounds() {
		return bounds;
	}

	public void setBounds(ViewPort bounds) {
		this.bounds = bounds;
	}

	private Location location;

    @JsonProperty("location_type")
    private String locationType;

    @JsonProperty("viewport")
    private ViewPort viewPort;

    private ViewPort bounds;

    //getters, setters, toString
}

class ViewPort {

    @Override
	public String toString() {
		return "ViewPort [northeast=" + northeast + ", southwest=" + southwest + "]";
	}
	public Location getNortheast() {
		return northeast;
	}
	public void setNortheast(Location northeast) {
		this.northeast = northeast;
	}
	public Location getSouthwest() {
		return southwest;
	}
	public void setSouthwest(Location southwest) {
		this.southwest = southwest;
	}
	private Location northeast;
    private Location southwest;

    //getters, setters, toString
}

class Location {

    private String lat;
    private String lng;
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	@Override
	public String toString() {
		return "Location [lat=" + lat + ", lng=" + lng + "]";
	}

    //getters, setters, toString
}
