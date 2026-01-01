package menu.controller;

import java.util.List;
import menu.domain.Result;
import menu.service.MenuService;
import menu.util.InputParser;
import menu.util.Retry;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public void run() {
        OutputView.printStart();
        List<String> coachNames = registerCoaches();

        for (String coachName : coachNames) {
            registerNoEatMenus(coachName);
        }

        Result result = menuService.recommendMenus();
    }

    private void registerNoEatMenus(String coachName) {
        Retry.retryUntilSuccess(() -> {
            List<String> noEatMenuNames = InputParser.parseNoEatMenus(InputView.readNoEatMenus(coachName));
            menuService.registerNoEatMenus(coachName, noEatMenuNames);
        });
    }

    private List<String> registerCoaches() {
        return Retry.retryUntilSuccess(() -> {
            List<String> names = InputParser.parseCoachNames(InputView.readNames().strip());
            return menuService.registerCoaches(names);
        });
    }
}

