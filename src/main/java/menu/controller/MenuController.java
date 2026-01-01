package menu.controller;

import java.util.List;
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
        registerCoaches();


    }

    private void registerCoaches() {
        Retry.retryUntilSuccess(() -> {
            List<String> names = InputParser.parseCoachNames(InputView.readNames().strip());
            menuService.registerCoaches(names);
        });
    }
}

