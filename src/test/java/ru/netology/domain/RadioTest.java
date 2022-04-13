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
    void setSelectStation(String nameTest, int inputSelectStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setSelectStation(inputSelectStation);
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
    void setNextStation(String nameTest, int oldCurrentStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setCurrentStation(oldCurrentStation);
        radio.setNextStation();
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
    void setPrevCurrentStation(String nameTest, int oldCurrentStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setCurrentStation(oldCurrentStation);
        radio.setPrevStation();
        assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path analysis; 6; 7",
            "Boundary value analysis 1; 0; 1",
            "Boundary value analysis 2; 1; 2",
            "Boundary value analysis 3; 9; 10",
            "Boundary value analysis 4; 10; 10",
    }, delimiter = ';')
    void setVolumeUp(String nameTest, int oldCurrentVolume, int expectedVolume) {
        Radio radio = new Radio();
        radio.setCurrentVolume(oldCurrentVolume);
        radio.setVolumeUp();
        assertEquals(radio.getCurrentVolume(), expectedVolume);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Critical path analysis; 6; 5",
            "Boundary value analysis 1; 0; 0",
            "Boundary value analysis 2; 1; 0",
            "Boundary value analysis 3; 9; 8",
            "Boundary value analysis 4; 10; 9",
    }, delimiter = ';')
    void setVolumeDown(String nameTest, int oldCurrentVolume, int expectedVolume) {
        Radio radio = new Radio();
        radio.setCurrentVolume(oldCurrentVolume);
        radio.setVolumeDown();
        assertEquals(radio.getCurrentVolume(), expectedVolume);
    }
}