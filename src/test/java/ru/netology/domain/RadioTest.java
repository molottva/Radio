package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path analysis; 5; 5",
            "Invalid value analysis 1; -7; 0",
            "Invalid value analysis 2; 15; 0",
            "Boundary value analysis 1; -1; 0",
            "Boundary value analysis 2; 0; 0",
            "Boundary value analysis 3; 1; 1",
            "Boundary value analysis 4; 8; 8",
            "Boundary value analysis 5; 9; 9",
            "Boundary value analysis 6; 10; 0",
    }, delimiter = ';')
    void setCurrentStationDefaultSetting(String nameTest, int inputSelectStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setCurrentStation(inputSelectStation);
        assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path analysis; 5; 6",
            "Boundary value analysis 1; 0; 1",
            "Boundary value analysis 2; 1; 2",
            "Boundary value analysis 3; 8; 9",
            "Boundary value analysis 4; 9; 0",
    }, delimiter = ';')
    void nextStationDefaultSetting(String nameTest, int oldCurrentStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setCurrentStation(oldCurrentStation);
        radio.nextStation();
        assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path analysis; 5; 4",
            "Boundary value analysis 1; 0; 9",
            "Boundary value analysis 2; 1; 0",
            "Boundary value analysis 3; 8; 7",
            "Boundary value analysis 4; 9; 8",
    }, delimiter = ';')
    void prevStationDefaultSetting(String nameTest, int oldCurrentStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setCurrentStation(oldCurrentStation);
        radio.prevStation();
        assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path analysis, 1 station; 1; 0; 0",
            "Invalid value analysis 1, 1 station; 1; -7; 0",
            "Invalid value analysis 2, 1 station; 1; 3; 0",
            "Boundary value analysis 1, 1 station; 1; -1; 0",
            "Boundary value analysis 2, 1 station; 1; 1; 0",
            "Critical path analysis, 20 stations; 20; 13; 13",
            "Invalid value analysis 1, 20 stations; 20; -17; 0",
            "Invalid value analysis 2, 20 stations; 20; 35; 0",
            "Boundary value analysis 1, 20 stations; 20; -1; 0",
            "Boundary value analysis 2, 20 stations; 20; 0; 0",
            "Boundary value analysis 3, 20 stations; 20; 1; 1",
            "Boundary value analysis 4, 20 stations; 20; 18; 18",
            "Boundary value analysis 5, 20 stations; 20; 19; 19",
            "Boundary value analysis 6, 20 stations; 20; 20; 0",
    }, delimiter = ';')
    void setCurrentStationCustomSetting(String nameTest, int counterStation, int inputSelectStation, int expectedStation) {
        Radio radio = new Radio(counterStation);
        radio.setCurrentStation(inputSelectStation);
        assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path analysis, 1 station; 1; 0; 0",
            "Critical path analysis, 20 stations; 20; 11; 12",
            "Boundary value analysis 1, 20 stations; 20; 0; 1",
            "Boundary value analysis 2, 20 stations; 20; 1; 2",
            "Boundary value analysis 3, 20 stations; 20; 18; 19",
            "Boundary value analysis 4, 20 stations; 20; 19; 0",
    }, delimiter = ';')
    void nextStationCustomSetting(String nameTest, int counterStation, int oldCurrentStation, int expectedStation) {
        Radio radio = new Radio(counterStation);
        radio.setCurrentStation(oldCurrentStation);
        radio.nextStation();
        assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path analysis, 1 station; 1; 0; 0",
            "Critical path analysis, 20 stations; 20; 14; 13",
            "Boundary value analysis 1, 20 stations; 20; 0; 19",
            "Boundary value analysis 2, 20 stations; 20; 1; 0",
            "Boundary value analysis 3, 20 stations; 20; 18; 17",
            "Boundary value analysis 4, 20 stations; 20; 19; 18",
    }, delimiter = ';')
    void prevStationCustomSetting(String nameTest, int counterStation, int oldCurrentStation, int expectedStation) {
        Radio radio = new Radio(counterStation);
        radio.setCurrentStation(oldCurrentStation);
        radio.prevStation();
        assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path analysis; 54; 54",
            "Invalid value analysis 1; -11; 30",
            "Invalid value analysis 2; 904; 30",
            "Boundary value analysis 1; -1; 30",
            "Boundary value analysis 2; 0; 0",
            "Boundary value analysis 3; 1; 1",
            "Boundary value analysis 4; 99; 99",
            "Boundary value analysis 5; 100; 100",
            "Boundary value analysis 6; 101; 30",
    }, delimiter = ';')
    void setCurrentVolume(String nameTest, int currentVolume, int expectedVolume) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);
        assertEquals(radio.getCurrentVolume(), expectedVolume);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path analysis; 6; 7",
            "Boundary value analysis 1; 0; 1",
            "Boundary value analysis 2; 1; 2",
            "Boundary value analysis 3; 99; 100",
            "Boundary value analysis 4; 100; 100",
    }, delimiter = ';')
    void volumeUp(String nameTest, int oldCurrentVolume, int expectedVolume) {
        Radio radio = new Radio();
        radio.setCurrentVolume(oldCurrentVolume);
        radio.volumeUp();
        assertEquals(radio.getCurrentVolume(), expectedVolume);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path analysis; 6; 5",
            "Boundary value analysis 1; 0; 0",
            "Boundary value analysis 2; 1; 0",
            "Boundary value analysis 3; 99; 98",
            "Boundary value analysis 4; 100; 99",
    }, delimiter = ';')
    void volumeDown(String nameTest, int oldCurrentVolume, int expectedVolume) {
        Radio radio = new Radio();
        radio.setCurrentVolume(oldCurrentVolume);
        radio.volumeDown();
        assertEquals(radio.getCurrentVolume(), expectedVolume);
    }
}