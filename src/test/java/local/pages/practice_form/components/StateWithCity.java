package local.pages.practice_form.components;

import java.util.List;
import java.util.Random;

public enum StateWithCity {
    NCR("NCR", List.of("Delhi", "Gurgaon", "Noida")),
    UTTAR_PRADESH("Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut")),
    HARYANA("Haryana", List.of("Karnal", "Panipat")),
    RAJASTHAN("Rajasthan", List.of("Jaipur", "Jaiselmer"));

    private final String state;
    private final List<String> cities;

    StateWithCity(String state, List<String> cities) {
        this.state = state;
        this.cities = cities;
    }

    public String getState() {
        return state;
    }

    public List<String> getCities() {
        return cities;
    }

    public String getRandomCity() {
        return cities.get(new Random().nextInt(cities.size()));
    }
}