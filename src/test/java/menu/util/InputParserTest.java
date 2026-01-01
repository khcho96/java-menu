package menu.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import menu.constant.ErrorMessage;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    void 코치_이름_파싱() {
        List<String> names = InputParser.parseCoachNames("가가, 나나, 다다 ");
        assertThat(names).containsExactlyElementsOf(List.of("가가", "나나", "다다"));
    }

    @Test
    void 코치_이름_형식_오류() {
        assertThatThrownBy(() -> InputParser.parseCoachNames("가가-나나-다다 "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.INVALID_FORMAT_ERROR.getErrorMessage());
    }

    @Test
    void 못먹는메뉴_파싱() {
        List<String> menus = InputParser.parseNoEatMenus(" 규동, 파니니");
        assertThat(menus).containsExactlyElementsOf(List.of("규동", "파니니"));
    }

    @Test
    void 못먹는메뉴_오류() {
        assertThatThrownBy(() -> InputParser.parseNoEatMenus("규동;파니니"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_FORMAT_ERROR.getErrorMessage());
    }
}