package com.example.memerableplaces;

import android.content.SharedPreferences;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class UpdateSharedPreferances {

    // Accessible class for updating the system preferences in a more streamlined fashion

    public static void update(SharedPreferences sharedPreferences) {

        sharedPreferences.edit().clear().apply();

        try {
            ArrayList<String> latitudes = new ArrayList<>();
            ArrayList<String> longitudes = new ArrayList<>();

            // To convert LatLng objects into strings to work with shared preference
            for (LatLng coord : MainActivity.locations) {
                latitudes.add(Double.toString(coord.latitude));
                longitudes.add(Double.toString(coord.longitude));
            }

            sharedPreferences.edit().putString("places", ObjectSerializer.serialize(MainActivity.places)).apply();

            sharedPreferences.edit().putString("lats", ObjectSerializer.serialize(latitudes)).apply();
            sharedPreferences.edit().putString("lons", ObjectSerializer.serialize(longitudes)).apply();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
