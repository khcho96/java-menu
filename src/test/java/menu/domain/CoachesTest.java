package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import menu.constant.ErrorMessage;
import org.junit.jupiter.api.Test;

class CoachesTest {

    @Test
    void 코치_이름_중복_오류() {
        assertThatThrownBy(() -> Coaches.from(List.of("가나","가나","다라")))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.NAME_DUPLICATION_ERROR.getErrorMessage());
    }

    @Test
    void 코치_이름_최대_개수_오류() {
        assertThatThrownBy(() -> Coaches.from(List.of("가가","나나","다다", "마마", "바바", "사사")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.COACH_MAX_COUNT_ERROR.getErrorMessage());
    }

    @Test
    void 코치_이름_최소_개수_오류() {
        assertThatThrownBy(() -> Coaches.from(List.of("가가")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.COACH_MIN_COUNT_ERROR.getErrorMessage());
    }

    @Test
    void 코치_이름_저장() {
        Coaches coaches = Coaches.from(List.of("가가", "나나", "다다"));
        assertThat(coaches.getCoachNames()).containsExactlyElementsOf(List.of("가가", "나나", "다다"));
    }
}