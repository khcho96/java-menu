package menu;

import static menu.constant.Constant.CATEGORIES;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Recommendation;
import menu.dto.CoachNamesDto;
import menu.generator.RandomCategoryGenerator;
import menu.generator.RandomMenuGenerator;
import menu.util.InputParser;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {

    private static Recommendation recommendation;
    private static Coaches coaches;
    private static CoachNamesDto coachNamesDto;

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

                coachNamesDto = coaches.getCoachNamesDto();

                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }

        List<String> coachNames = coachNamesDto.getCoachNames();

        for (String coachName : coachNames) {
            while (true) {
                try {
                    String readRejectedMenus = InputView.readRejectedMenus(coachName);
                    List<String> rejectedMenus = InputParser.parseRejectedMenus(readRejectedMenus);

                    Coach coach = coaches.getCoach(coachName);
                    coach.addRejectedMenus(rejectedMenus);

                    break;
                } catch (IllegalArgumentException e) {
                    OutputView.printErrorMessage(e);
                }
            }
        }

        recommendation = Recommendation.from(coaches);

        while (!recommendation.isDone()) { // 추천 끝났으면(추천 카테고리 항목이 5개이면)
            String category = RandomCategoryGenerator.generateCategory();
            if (!recommendation.possible(category)) { // 이미 2번 추천 되었으면
                continue;
            }

            recommendation.addCategory(category); // 추천 카테고리 추가

            for (Coach coach : coaches.getCoaches()) { // 코치별로 메뉴 추천

                while (true) {
                    List<String> candidateMenus = CATEGORIES.get(category); // 카테고리에 맞는 메뉴 후보 가져오기

                    String menu = RandomMenuGenerator.generateMenu(candidateMenus);

                    if (!coach.possible(menu)) { // 이미 추천했거나 못먹는 음식이라면
                        continue;
                    }

                    coach.addRecommendedMenu(menu); // 메뉴 추가

                    break;
                }
            }
        }

        System.out.println("메뉴 추천 결과입니다.\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        List<String> categories = recommendation.getCategories();
        System.out.println("[ 카테고리 | " + String.join(" | ", categories.toArray(new String[0])) + " ]");

        List<Coach> coaches1 = recommendation.getCoaches();
        for (Coach coach : coaches1) {
            System.out.printf("[ %s | " + String.join(" | ", coach.getRecommendedMenus().toArray(new String[0])) + " ]\n", coach.getName());
        }

        System.out.println("추천을 완료했습니다.");
    }
}
