package ru.netology.domain;

public class Radio {
    final int maxStation;
    static final int minStation = 0;
    private int currentStation;
    static final int maxVolume = 100;
    static final int minVolume = 0;
    private int currentVolume = 30;

    public Radio() { //по умолчанию
        this.maxStation = 9;
    }

    public Radio(int counterStation) { //изменения кол-ва станций
        this.maxStation = counterStation - 1;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation < minStation || currentStation > maxStation) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void nextStation() { //след станция
        if (currentStation == maxStation) {
            this.currentStation = minStation;
        } else {
            this.currentStation = currentStation + 1;
        }
    }

    public void prevStation() { //пред станция
        if (currentStation == minStation) {
            this.currentStation = maxStation;
        } else {
            this.currentStation = currentStation - 1;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < minVolume || currentVolume > maxVolume) {
            return;
        } else {
            this.currentVolume = currentVolume;
        }
    }

    public void volumeUp() { //повышение громкости
        if (currentVolume == maxVolume) {
            return;
        }
        this.currentVolume = currentVolume + 1;
    }

    public void volumeDown() { //понижение громкости
        if (currentVolume == minVolume) {
            return;
        }
        this.currentVolume = currentVolume - 1;
    }
}
