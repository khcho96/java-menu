package menu.util;

import static menu.constant.ErrorMessage.COACH_COUNT_MAX_ERROR;
import static menu.constant.ErrorMessage.COACH_COUNT_MIN_ERROR;
import static menu.constant.ErrorMessage.FORMAT_ERROR;
import static menu.constant.ErrorMessage.REJECTED_MENU_COUNT_ERROR;

import java.util.List;
import menu.constant.Constant;

public final class Validator {

    private static final String CSV_FORMAT = "^ *[가-힣a-zA-Z]+ *(, *[가-힣a-zA-Z]+ *)*$";

    private Validator() {}

    public static void validateCoachNameFormat(String input) {
        if (!input.matches(CSV_FORMAT)) {
            throw new IllegalArgumentException(FORMAT_ERROR.getErrorMessage());
        }
    }

    public static void validateCoachNames(List<String> names) {
        if (names.size() < Constant.COACH_COUNT_MIN) {
            throw new IllegalArgumentException(COACH_COUNT_MIN_ERROR.getErrorMessage());
        }

        if (names.size() > Constant.COACH_COUNT_MAX) {
            throw new IllegalArgumentException(COACH_COUNT_MAX_ERROR.getErrorMessage());
        }
    }

    public static void validateRejectedMenuFormat(String input) {
        if (input.isBlank()) {
            return;
        }

        if (!input.matches(CSV_FORMAT)) {
            throw new IllegalArgumentException(FORMAT_ERROR.getErrorMessage());
        }
    }

    public static void validateRejectedMenus(List<String> menus) {
        if (menus.size() > Constant.REJECTED_MENU_COUNT_MAX) {
            throw new IllegalArgumentException(REJECTED_MENU_COUNT_ERROR.getErrorMessage());
        }
    }
}
