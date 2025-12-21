package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recommendation {

    private final Coaches coaches;
    private final List<String> categories;

    private Recommendation(Coaches coaches) {
        this.categories = new ArrayList<>();
        this.coaches = coaches;
    }

    public static Recommendation from(Coaches coaches) {
        return new Recommendation(coaches);
    }

    public boolean isDone() {
        return categories.size() == 5;
    }

    public boolean possible(String category) {
        return Collections.frequency(categories, category) != 2;
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<Coach> getCoaches() {
        return coaches.getCoaches();
    }
}
