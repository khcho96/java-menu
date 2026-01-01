package menu.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    void 번호로_카테고리_반환() {
        Category category = Category.fromIndex(1);
        assertThat(category).isEqualTo(Category.JAPANESE);
    }
}