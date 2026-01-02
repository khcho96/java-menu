package menu.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import menu.constant.ErrorMessage;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    @Test
    void 쉼표_구분_형식이_올바르면_통과한다() {
        Validator.validateCsvFormat("가,나,다");
    }

    @Test
    void 쉼표_구분_형식이_올바르지_않으면_예외를_던진다() {
        assertThatThrownBy(() -> Validator.validateCsvFormat("가:나:다"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_FORMAT_ERROR.getErrorMessage());
    }
}