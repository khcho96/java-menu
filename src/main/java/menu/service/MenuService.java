package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import menu.constant.Category;
import menu.constant.Menu;
import menu.domain.Categories;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.dto.Result;

public class MenuService {

    private static final int DAY_COUNT = 5;

    private Coaches coaches;

    public List<String> registerCoaches(List<String> names) {
        coaches = Coaches.from(names);
        return coaches.getCoachNames();
    }

    public void registerNoEatMenus(String coachName, List<String> noEatMenuNames) {
        if (!noEatMenuNames.isEmpty()) {
            Coach coach = coaches.getCoach(coachName);
            List<Menu> noEatMenus = noEatMenuNames.stream()
                    .map(Menu::from)
                    .collect(Collectors.toList());
            coach.addNoEatMenus(noEatMenus);
        }
    }

    public Result recommendMenus() {
        Categories categories = Categories.newInstance();
        for (int i = 0; i < DAY_COUNT; i++) {
            recommendMenus(categories);
        }

        return new Result(categories, coaches);
    }

    private void recommendMenus(Categories categories) {
        while (true) {
            Category category = Category.fromIndex(Randoms.pickNumberInRange(1, 5));
            if (!categories.isPossible(category)) {
                continue;
            }

            categories.addRecommendedCategory(category);
            recommendMenu(category);
            break;
        }
    }

    private void recommendMenu(Category category) {
        for (Coach coach : coaches.getCoaches()) {
            recommendMenuEachCoach(category, coach);
        }
    }

    private void recommendMenuEachCoach(Category category, Coach coach) {
        while (true) {
            Menu menu = Menu.from(Randoms.shuffle(category.getMenus()).get(0));
            if (coach.isPossible(menu)) {
                coach.addRecommendedMenu(menu);
                break;
            }
        }
    }
}
