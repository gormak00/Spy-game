package controller;

import model.Locations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameController {
    private Locations locations;

    public void createGame(int numberOfPlayers, String path) {
        String place = getRandomLocation();
        int spyNumber = getSpyNumber(numberOfPlayers);
        createAllPlayersFiles(numberOfPlayers, path, place, spyNumber);
        getAllLocationsFile(path);
    }

    private String getRandomLocation() {
        locations = new Locations();
        int random = (int) (Math.random() * locations.getLocations().size());
        return locations.getLocations().get(random);
    }

    private int getSpyNumber(int numberOfPlayers) {
        return (int) (Math.random() * numberOfPlayers + 1);
    }

    private void createAllPlayersFiles(int numberOfPlayers, String path, String location, int spyNumber) {
        if (!new File(path).isDirectory()) {
            new File(path).mkdir();
        } else deleteAllFiles(path);
        for (int i = 0; i < numberOfPlayers; i++) {
            int numberOfFile = i+1;
            File file = new File(path + numberOfFile + ".txt");
            FileWriter fr = null;
            try {
                fr = new FileWriter(file);
                if (i == spyNumber - 1) {
                    fr.write("Вы шпион!");
                } else fr.write(location);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void getAllLocationsFile(String path) {
        locations = new Locations();
        File file = new File(path + "All locations.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            for (String location: locations.getLocations()) {
                fr.write(location + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteAllFiles(String path) {
        for (File myFile : new File(path).listFiles())
            if (myFile.isFile()) myFile.delete();
    }
}
