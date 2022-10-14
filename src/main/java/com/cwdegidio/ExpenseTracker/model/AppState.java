package com.cwdegidio.ExpenseTracker.model;

import java.util.LinkedList;

public class AppState {

    private LinkedList<String> screenHistory;

    public AppState() {
        screenHistory = new LinkedList<>();
        screenHistory.add("mainMenu");
    }

    public String getCurrentLocation() {
        return screenHistory.getLast();
    }

    public void addLocationToHistory(String currentLocation) {
        screenHistory.add(currentLocation);
    }

    public void removeLastLocationFromHistory() {
        screenHistory.removeLast();
    }
}
