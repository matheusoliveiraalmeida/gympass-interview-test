package com.interview.test.gympass.race;

import com.interview.test.gympass.model.Race;
import com.interview.test.gympass.model.RaceResult;
import com.interview.test.gympass.parser.RaceParser;
import com.interview.test.gympass.utils.CalculateAverageSpeed;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import static java.nio.file.Files.readAllLines;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

public class KartRace {

    private static final Logger LOGGER = Logger.getLogger(KartRace.class.getName());

    private static final String MSG_RACE_DIDNT_START = "The Race didn't start!";
    private static final String MSG_FILE_NOT_FOUND = "File not found.";

    private Map<String, RaceResult> raceResultMap;
    private List<RaceResult> raceResults;
    private Race bestLap;

    public void runRace(String[] args) throws IOException {
        LOGGER.info("Processing kart race log file...\n");

        if (args.length != 1) {
            throw new FileNotFoundException(MSG_FILE_NOT_FOUND);
        }

        RaceParser raceParser = new RaceParser();
        raceResultMap = new HashMap<>();

        readAllLines(Paths.get(args[0]))
            .stream()
            .map(raceParser::parseLine)
            .sorted()
            .forEach(this::updateRaceResult);

        AtomicInteger position = new AtomicInteger();

        raceResults = raceResultMap
            .values()
            .stream()
            .sorted()
            .peek((RaceResult raceResult) -> raceResult.setPosition(position.incrementAndGet()))
            .collect(toList());

        printOutResult();

    }

    private void updateRaceResult(Race race) {
        if (isNull(raceResultMap.get(race.getDriverCode()))) {
            raceResultMap.put(race.getDriverCode(), new RaceResult(race));
        } else {
            RaceResult raceResult = raceResultMap.get(race.getDriverCode());

            updateLapsCompleted(race, raceResult);
            updateTotalRaceTime(race, raceResult);
            updateBestLap(race, raceResult);

            CalculateAverageSpeed.calculate(race, raceResult);

        }

    }

    private void updateLapsCompleted(Race race, RaceResult raceResult) {
        raceResult.setLapsCompleted(race.getLap());
    }

    private void updateTotalRaceTime(Race race, RaceResult raceResult) {
        raceResult.setTotalRaceTime(
            raceResult.getTotalRaceTime()
                .plusMinutes(race.getLapTime().getMinute())
                .plusSeconds(race.getLapTime().getSecond())
                .plusNanos(race.getLapTime().getNano())
        );
    }

    private void updateBestLap(Race race, RaceResult raceResult) {
        if (race.getLapTime().isBefore(raceResult.getBestLapTime())) {
            raceResult.setBestLap(race.getLap());
            raceResult.setBestLapTime(race.getLapTime());
        }

        if (isNull(bestLap) || race.getLapTime().isBefore(bestLap.getLapTime())) {
            bestLap = race;
        }
    }

    public List<RaceResult> getRaceResults() {
        if (isNull(raceResults)) {
            throw new IllegalStateException(MSG_RACE_DIDNT_START);
        }
        return raceResults;
    }

    public Race getBestLapOfTheRace() {
        if (isNull(bestLap)) {
            throw new IllegalStateException(MSG_RACE_DIDNT_START);
        }
        return bestLap;
    }

    private RaceResult getBestRaceResult() {
        return raceResults.get(0);
    }

    private void printOutResult() {
        System.out.println("Race Result:");
        raceResults.forEach(pilotStats -> System.out.println(
            pilotStats.resultPerTotalRaceTime(getBestRaceResult().getTotalRaceTime())
        ));

        System.out.println("\nBest lap of the race:");
        System.out.println(getBestLapOfTheRace());
    }

}
