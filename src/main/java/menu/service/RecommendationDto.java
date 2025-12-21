package menu.service;

import java.util.List;
import menu.domain.Coaches;

public class RecommendationDto {

    private final Coaches coaches;
    private final List<String> categories;

    public RecommendationDto(Coaches coaches, List<String> categories) {
        this.coaches = coaches;
        this.categories = categories;
    }

    public List<String> getCategories() {
        return categories;
    }

    public Coaches getCoaches() {
        return coaches;
    }
}
