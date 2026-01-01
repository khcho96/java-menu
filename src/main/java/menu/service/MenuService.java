package menu.service;

import java.util.List;
import menu.constant.Menu;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Result;

public class MenuService {

    private Coaches coaches;

    public List<String> registerCoaches(List<String> names) {
        coaches = Coaches.from(names);
        return coaches.getCoachNames();
    }

    public void registerNoEatMenus(String coachName, List<String> noEatMenuNames) {
        Coach coach = coaches.getCoach(coachName);
        List<Menu> noEatMenus = noEatMenuNames.stream()
                .map(Menu::from)
                .toList();
        coach.addNoEatMenus(noEatMenus);
    }

    public Result recommendMenus() {

    }
}
