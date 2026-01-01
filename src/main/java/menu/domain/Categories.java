package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.constant.Category;

public class Categories {

    private final List<Category> categories;

    private Categories() {
        categories = new ArrayList<>();
    }

    public static Categories newInstance() {
        return new Categories();
    }

    public boolean isPossible(Category recommendedCategory) {
        return Collections.frequency(categories, recommendedCategory) < 2;
    }

    public void addRecommendedCategory(Category category) {
        categories.add(category);
    }
}
