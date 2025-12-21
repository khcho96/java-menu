package menu;

import java.util.List;
import menu.domain.Recommendation;
import menu.util.InputParser;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {

    private static Recommendation recommendation;

    public static void main(String[] args) {
        OutputView.printStart();
        while (true) {
            try {
                String readCoachNames = InputView.readCoachNames();
                List<String> coachNames = InputParser.parseCoachNames(readCoachNames);

                recommendation = Recommendation.newInstance();

                for (String coachName : coachNames) {
                    recommendation.addCoach(coachName);
                }
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
