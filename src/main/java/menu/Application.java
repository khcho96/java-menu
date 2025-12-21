package menu;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Recommendation;
import menu.dto.CoachesDto;
import menu.util.InputParser;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {

    private static Recommendation recommendation;
    private static Coaches coaches;
    private static CoachesDto coachesDto;

    public static void main(String[] args) {
        OutputView.printStart();
        while (true) {
            try {
                String readCoachNames = InputView.readCoachNames();
                List<String> coachNames = InputParser.parseCoachNames(readCoachNames);

                coaches = Coaches.newInstance();

                for (String coachName : coachNames) {
                    coaches.addCoach(coachName);
                }

                coachesDto = coaches.getCoachesDto();

                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }

        List<Coach> coaches = coachesDto.getCoaches();

        for (Coach coach : coaches) {
            while (true) {
                try {
                    String readRejectedMenus = InputView.readRejectedMenus(coach);
                    List<String> rejectedMenus = InputParser.parseRejectedMenus(readRejectedMenus);
                    coach.addRejectedMenus(rejectedMenus);
                    break;
                } catch (IllegalArgumentException e) {
                    OutputView.printErrorMessage(e);
                }
            }
        }
    }
}
