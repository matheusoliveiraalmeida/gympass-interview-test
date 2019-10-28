package com.interview.test.gympass;

import com.interview.test.gympass.race.KartRace;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        KartRace kartRace = new KartRace();
        kartRace.runRace(args);
    }

}
