package menu.util;

import menu.constant.ErrorMessage;

public final class Validator {

    private static final String CSV_FORMAT = "^[가-힣]+ *(, *[가-힣]+ *)*$";

    private Validator() {}

    public static void validateCoachNamesFormat(String rawInput) {
        if (!rawInput.matches(CSV_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT_ERROR.getErrorMessage());
        }
    }

    public static void validateNoEatMenusFormat(String rawInput) {
        if (!rawInput.matches(CSV_FORMAT) && !rawInput.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT_ERROR.getErrorMessage());
        }
    }
}
