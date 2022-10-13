package com.cwdegidio.ExpenseTracker.model;

public class AppState {

    private String currentLocation;

    public AppState() {
        currentLocation = "mainMenu";
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
}
