package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import menu.constant.Category;
import org.junit.jupiter.api.Test;

class CategoriesTest {

    @Test
    void 카테고리_저장() {
        Categories categories = Categories.newInstance();

        categories.addRecommendedCategory(Category.ASIAN);
        categories.addRecommendedCategory(Category.KOREAN);
        categories.addRecommendedCategory(Category.KOREAN);
        categories.addRecommendedCategory(Category.WESTERN);
        categories.addRecommendedCategory(Category.CHINESE);

        assertThat(categories.getCategories()).containsExactlyElementsOf(List.of("아시안", "한식", "한식", "양식", "중식"));
    }

    @Test
    void 하나의_카테고리가_2번_이하_추천될수있다() {
        Categories categories = Categories.newInstance();

        categories.addRecommendedCategory(Category.ASIAN);
        categories.addRecommendedCategory(Category.KOREAN);

        assertThat(categories.isPossible(Category.KOREAN)).isTrue();
    }

    @Test
    void 하나의_카테고리가_2번_초과_추천될수없다() {
        Categories categories = Categories.newInstance();

        categories.addRecommendedCategory(Category.ASIAN);
        categories.addRecommendedCategory(Category.KOREAN);
        categories.addRecommendedCategory(Category.KOREAN);

        assertThat(categories.isPossible(Category.KOREAN)).isFalse();
    }
}