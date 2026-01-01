package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import menu.constant.ErrorMessage;
import menu.constant.Menu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @ParameterizedTest
    @ValueSource(strings = {"가", "가나다라마"})
    void 코치_이름_길이_오류(String name) {
        assertThatThrownBy(() -> Coach.from(name))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.NAME_LENGTH_ERROR.getErrorMessage());
    }

    @Test
    void 못먹는_메뉴_개수_오류() {
        Coach coach = Coach.from("가나");
        assertThatThrownBy(() -> coach.addNoEatMenus(List.of(Menu.WESTERN_1, Menu.ASIAN_1, Menu.ASIAN_3)))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.NO_EAT_MENU_COUNT_ERROR.getErrorMessage());
    }

    @Test
    void 못먹는_메뉴_중복_오류() {
        Coach coach = Coach.from("가나");
        assertThatThrownBy(() -> coach.addNoEatMenus(List.of(Menu.ASIAN_1, Menu.ASIAN_1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.MENU_DUPLICATION_ERROR.getErrorMessage());
    }

    @Test
    void 추천_가능한_메뉴() {
        Coach coach = Coach.from("가나");

        coach.addRecommendedMenu(Menu.JAPANESE_1);
        coach.addRecommendedMenu(Menu.JAPANESE_2);
        coach.addRecommendedMenu(Menu.JAPANESE_3);

        assertThat(coach.isPossible(Menu.ASIAN_1)).isTrue();
    }

    @Test
    void 중복으로_인해_추천_불가능한_메뉴() {
        Coach coach = Coach.from("가나");

        coach.addRecommendedMenu(Menu.JAPANESE_1);
        coach.addRecommendedMenu(Menu.JAPANESE_2);

        assertThat(coach.isPossible(Menu.JAPANESE_2)).isFalse();
    }

    @Test
    void 못먹는_메뉴로_인해_추천_불가능한_메뉴() {
        Coach coach = Coach.from("가나");

        coach.addNoEatMenus(List.of(Menu.ASIAN_1, Menu.ASIAN_2));

        assertThat(coach.isPossible(Menu.ASIAN_1)).isFalse();
    }
}