package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Flight implements  PlaneReservation{

    public final List<Place> seats = new ArrayList<>();

    private int status=0;
    public Flight() {
        for(int i = 0 ; i < 128 ; i ++){
            if(i<100){
                seats.add(new Place(i,null,PlaceType.STANDARD));
            }else {
                seats.add(new Place(i,null,PlaceType.VIP));
            }
        }
    }

    @Override
    public Optional<Integer> reservation(PlaceType placeType, String username, int price) {
        for(Place o : seats){
            if(o.getPlaceType().equals(placeType) && o.getUsername()==null){
                o.setUsername(username);
                status+=price*100;
                return Optional.of(o.getId());
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> cancel(int placeId) {

        if(seats.get(placeId).getUsername()!=null){
            seats.get(placeId).setUsername(null);
            if(seats.get(placeId).getPlaceType().equals(PlaceType.STANDARD)) status-=800*100;
            else if(seats.get(placeId).getPlaceType().equals(PlaceType.VIP)) status-=1200*100;
            return Optional.of(placeId);
        }

        return Optional.empty();
    }

    @Override
    public int status() {
        return this.status/100;
    }

    @Override
    public List<Place> freePlaces() {
        List<Place> free = new ArrayList<>();
        for (Place p: seats) {
            if(p.getUsername()==null){
                free.add(p);
            }
        }
        if(free.isEmpty())return null;
        else return free;
    }

    @Override
    public List<Place> reservedPlaces() {
        List<Place> free = new ArrayList<>();
        for (Place p: seats) {
            if(p.getUsername()!=null){
                free.add(p);
            }
        }
        if(free.isEmpty())return null;
        else return free;
    }

    @Override
    public boolean changePlaces(int sourcePlaceId, int destinationPlaceId) {
        if(seats.get(sourcePlaceId)==null)return false;
        else if(seats.get(destinationPlaceId)==null){
            return seats.get(sourcePlaceId).getPlaceType() == seats.get(destinationPlaceId).getPlaceType();
        }
        else return false;
    }
}
