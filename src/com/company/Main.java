package com.company;

public class Main {

    public static void main(String[] args) {
        Flight f1 = new Flight();

        System.out.println(f1.reservation(PlaneReservation.PlaceType.STANDARD,"Andrzejek",800));

        System.out.println(f1.changePlaces(1,2));

    }
}
