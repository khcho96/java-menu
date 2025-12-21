package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Recommendation {

    private final List<Coach> coaches;
    private final List<String> categories;

    private Recommendation() {
        this.categories = new ArrayList<>();
        this.coaches = new ArrayList<>();
    }

    public static Recommendation newInstance() {
        return new Recommendation();
    }
}
