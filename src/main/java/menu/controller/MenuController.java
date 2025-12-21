package menu.controller;

import java.util.List;
import menu.dto.CoachNamesDto;
import menu.service.MenuService;
import menu.service.RecommendationDto;
import menu.util.InputParser;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public void run() {
        OutputView.printStart();

        CoachNamesDto coachNamesDto = registerCoachNames();
        List<String> coachNames = coachNamesDto.getCoachNames();

        for (String coachName : coachNames) {
            registerRejectedMenus(coachName);
        }

        RecommendationDto result = menuService.getResult();
        OutputView.printResult(result);
    }

    private void registerRejectedMenus(String coachName) {
        while (true) {
            try {
                String readRejectedMenus = InputView.readRejectedMenus(coachName);
                List<String> rejectedMenus = InputParser.parseRejectedMenus(readRejectedMenus);

                menuService.registerRejectedMenus(coachName, rejectedMenus);

                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private CoachNamesDto registerCoachNames() {
        while (true) {
            try {
                String readCoachNames = InputView.readCoachNames();
                List<String> coachNames = InputParser.parseCoachNames(readCoachNames);

                return menuService.registerCoachNames(coachNames);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
