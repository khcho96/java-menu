package menu.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    void 이름으로_메뉴_반환() {
        Menu menu = Menu.from("규동");
        assertThat(menu.getName()).isEqualTo("규동");
    }

    @Test
    void 오류_테스트_템플릿() {
        assertThatThrownBy(() -> Menu.from("간장계란밥"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NO_EXIST_MENU_ERROR.getErrorMessage());
    }
}