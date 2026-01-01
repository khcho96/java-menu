package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import menu.constant.ErrorMessage;
import menu.constant.Menu;

public class Coach {

    private final String name;
    private List<Menu> noEatMenus;
    private List<Menu> recommendedMenus;

    private Coach(String name) {
        this.name = name;
        noEatMenus = new ArrayList<>();
        recommendedMenus = new ArrayList<>();
    }

    public static Coach from(String name) {
        validateName(name);
        return new Coach(name);
    }

    private static void validateName(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getErrorMessage());
        }
    }

    public void addNoEatMenus(List<Menu> noEatMenus) {
        for (Menu noEatMenu : noEatMenus) {
            validateNoEatMenusDuplication(noEatMenu);
            noEatMenus.add(noEatMenu);
        }

        validateNoEatMenusCount();
    }

    private void validateNoEatMenusDuplication(Menu noEatMenu) {
        if (noEatMenus.contains(noEatMenu)) {
            throw new IllegalArgumentException(ErrorMessage.MENU_DUPLICATION_ERROR.getErrorMessage());
        }
    }

    private void validateNoEatMenusCount() {
        if (noEatMenus.size() > 2) {
            throw new IllegalArgumentException(ErrorMessage.NO_EAT_MENU_COUNT_ERROR.getErrorMessage());
        }
    }

    public String getName() {
        return name;
    }

    public boolean isEatable(Menu menu) {
        return !noEatMenus.contains(menu);
    }

    public void addRecommendedMenu(Menu menu) {
        recommendedMenus.add(menu);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Coach coach = (Coach) object;
        return Objects.equals(name, coach.name);
    }
}
