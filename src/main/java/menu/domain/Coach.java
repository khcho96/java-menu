package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import menu.constant.ErrorMessage;
import menu.constant.Menu;

public class Coach {

    private static final int NAME_LENGTH_MIN = 2;
    private static final int NAME_LENGTH_MAX = 4;
    private static final int NO_EAT_MENU_MIN = 2;

    private final String name;
    private final List<Menu> noEatMenus;
    private final List<Menu> recommendedMenus;

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
        if (name.length() < NAME_LENGTH_MIN || name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getErrorMessage());
        }
    }

    public void addNoEatMenus(List<Menu> noEatMenus) {
        for (Menu noEatMenu : noEatMenus) {
            validateNoEatMenusDuplication(noEatMenu);
            this.noEatMenus.add(noEatMenu);
        }

        validateNoEatMenusCount();
    }

    private void validateNoEatMenusDuplication(Menu noEatMenu) {
        if (noEatMenus.contains(noEatMenu)) {
            throw new IllegalArgumentException(ErrorMessage.MENU_DUPLICATION_ERROR.getErrorMessage());
        }
    }

    private void validateNoEatMenusCount() {
        if (noEatMenus.size() > NO_EAT_MENU_MIN) {
            throw new IllegalArgumentException(ErrorMessage.NO_EAT_MENU_COUNT_ERROR.getErrorMessage());
        }
    }

    public String getName() {
        return name;
    }

    public boolean isPossible(Menu menu) {
        return isEatable(menu) && isUnique(menu);
    }

    private boolean isEatable(Menu menu) {
        return !noEatMenus.contains(menu);
    }

    private boolean isUnique(Menu menu) {
        return !recommendedMenus.contains(menu);
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

    public List<String> getRecommendedMenus() {
        return recommendedMenus.stream()
                .map(Menu::getName)
                .collect(Collectors.toList());
    }
}
