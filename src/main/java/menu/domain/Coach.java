package menu.domain;

import static menu.constant.Constant.CATEGORIES;
import static menu.constant.ErrorMessage.COACH_NAME_LENGTH_ERROR;
import static menu.constant.ErrorMessage.NO_EXIST_MENU;

import java.util.ArrayList;
import java.util.List;

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

        throw new IllegalArgumentException(NO_EXIST_MENU.getErrorMessage());
    }

    public boolean possible(String menu) {
        return !recommendedMenus.contains(menu) || !rejectedMenus.contains(menu);
    }

    public void addRecommendedMenu(String menu) {
        this.recommendedMenus.add(menu);
    }
}
