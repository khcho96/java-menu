package menu.domain;

import static menu.constant.Constant.CATEGORIES;
import static menu.constant.Constant.COACH_NAME_LENGTH_MIN;
import static menu.constant.ErrorMessage.COACH_NAME_LENGTH_ERROR;
import static menu.constant.ErrorMessage.NO_EXIST_MENU_ERROR;

import java.util.ArrayList;
import java.util.List;
import menu.constant.Constant;

public class Coach {

    private final String name;
    private List<String> rejectedMenus;
    private final List<String> recommendedMenus;

    private Coach(String name) {
        this.name = name;
        this.recommendedMenus = new ArrayList<>();
    }

    public static Coach from(String name) {
        validate(name);

        return new Coach(name);
    }

    private static void validate(String name) {
        if (name.length() < COACH_NAME_LENGTH_MIN || name.length() > Constant.COACH_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(COACH_NAME_LENGTH_ERROR.getErrorMessage());
        }
    }

    public String getName() {
        return name;
    }

    public List<String> getRecommendedMenus() {
        return recommendedMenus;
    }

    public void addRejectedMenus(List<String> rejectedMenus) {
        for (String rejectedMenu : rejectedMenus) {
            validateExistence(rejectedMenu);
        }
        this.rejectedMenus = new ArrayList<>(rejectedMenus);
    }

    private void validateExistence(String rejectedMenu) {
        for (String categoryName : CATEGORIES.keySet()) {
            List<String> menus = CATEGORIES.get(categoryName);
            if (menus.contains(rejectedMenu)) {
                return;
            }
        }

        throw new IllegalArgumentException(NO_EXIST_MENU_ERROR.getErrorMessage());
    }

    public boolean possible(String menu) {
        return !recommendedMenus.contains(menu) && !rejectedMenus.contains(menu);
    }

    public void addRecommendedMenu(String menu) {
        this.recommendedMenus.add(menu);
    }
}
