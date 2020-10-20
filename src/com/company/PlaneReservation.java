package com.company;

import java.util.List;
import java.util.Optional;

class Place {
    public Place(int id, String username, PlaneReservation.PlaceType placeType) {
        this.id = id;
        this.username = username;
        this.placeType = placeType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PlaneReservation.PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaneReservation.PlaceType placeType) {
        this.placeType = placeType;
    }

    private int id;
    private String username;
    private PlaneReservation.PlaceType placeType;


}

public interface PlaneReservation {

    enum PlaceType {
        STANDARD,
        VIP
    }

    Optional<Integer> reservation(final PlaceType placeType, final String username, int price);
    Optional<Integer> cancel(int placeId);
    int status();
    List<Place> freePlaces();
    List<Place> reservedPlaces();
    boolean changePlaces(int sourcePlaceId, int destinationPlaceId);
}
