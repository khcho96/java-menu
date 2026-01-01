package menu.constant;

public enum ErrorMessage {

    INVALID_FORMAT_ERROR("잘못된 형식입니다."),

    NAME_DUPLICATION_ERROR("이름이 중복입니다."),
    NAME_LENGTH_ERROR("코치의 이름은 2자 이상 4자 이하로 입력해야 합니다."),
    COACH_MIN_COUNT_ERROR("코치는 최소 2명 이상 입력해야 합니다."),
    COACH_MAX_COUNT_ERROR("코치는 최대 5명까지 입력할 수 있습니다."),

    NO_EXIST_MENU_ERROR("없는 메뉴입니다."),
    MENU_DUPLICATION_ERROR("메뉴가 중복입니다."),
    NO_EAT_MENU_COUNT_ERROR("못 먹는 메뉴는 최대 2개까지 입력할 수 있습니다."),
    ;

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(Object... args) {
        return ERROR_MESSAGE_PREFIX + String.format(errorMessage, args);
    }
}
