package menu.domain;

import static menu.constant.ErrorMessage.COACH_NAME_LENGTH_ERROR;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private final List<String> rejectedMenus;
    private final List<String> recommendedMenus;

    private Coach(String name) {
        this.name = name;
        this.rejectedMenus = new ArrayList<>();
        this.recommendedMenus = new ArrayList<>();
    }

    public static Coach from(String name) {
        validate(name);

        return new Coach(name);
    }

    private static void validate(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(COACH_NAME_LENGTH_ERROR.getErrorMessage());
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendedMenus() {
        return recommendedMenus;
    }

    public List<String> getRejectedMenus() {
        return rejectedMenus;
    }
}
