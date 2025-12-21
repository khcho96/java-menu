package menu.service;

import static menu.constant.Constant.CATEGORIES;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Recommendation;
import menu.dto.CoachNamesDto;
import menu.generator.RandomCategoryGenerator;
import menu.generator.RandomMenuGenerator;

public class MenuService {

    private Coaches coaches;

    public CoachNamesDto registerCoachNames(List<String> coachNames) {
        coaches = Coaches.newInstance();

        for (String coachName : coachNames) {
            coaches.addCoach(coachName);
        }

        return coaches.getCoachNamesDto();
    }

    public void registerRejectedMenus(String coachName, List<String> rejectedMenus) {
        Coach coach = coaches.getCoach(coachName);
        coach.addRejectedMenus(rejectedMenus);
    }

    public RecommendationDto getResult() {
        Recommendation recommendation = Recommendation.from(coaches);

        while (!recommendation.isDone()) { // 추천 끝났으면(추천 카테고리 항목이 5개이면)
            String category = RandomCategoryGenerator.generateCategory();
            if (!recommendation.possible(category)) { // 이미 2번 추천 되었으면
                continue;
            }

            recommendation.addCategory(category); // 추천 카테고리 추가

            addRecommendedMenu(category); // 추천 메뉴 추가
        }

        return recommendation.getDto();
    }

    private void addRecommendedMenu(String category) {
        for (Coach coach : coaches.getCoaches()) { // 코치별로 메뉴 추천
            addRecommendedMenuEachCoach(category, coach);
        }
    }

    private void addRecommendedMenuEachCoach(String category, Coach coach) {
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
