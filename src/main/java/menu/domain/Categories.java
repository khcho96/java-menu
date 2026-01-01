package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.constant.Category;

public class Categories {

    private static final int CATEGORY_MAX = 2;

    private final List<Category> categories;

    private Categories() {
        categories = new ArrayList<>();
    }

    public static Categories newInstance() {
        return new Categories();
    }

    public boolean isPossible(Category recommendedCategory) {
        return Collections.frequency(categories, recommendedCategory) < CATEGORY_MAX;
    }

    public void addRecommendedCategory(Category category) {
        categories.add(category);
    }

    public List<String> getCategories() {
        return categories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }
}
