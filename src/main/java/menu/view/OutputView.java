package menu.view;

import menu.domain.Categories;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.dto.Result;

public class OutputView {

    private OutputView() {
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printResult(Result result) {
        Categories categories = result.categories();
        Coaches coaches = result.coaches();

        System.out.println("\n메뉴 추천 결과입니다.\n"
                + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");

        System.out.println("[ 카테고리 | " + String.join(" | ", categories.getCategories()) + " ]");

        for (Coach coach : coaches.getCoaches()) {
            System.out.printf("[ %s | " + String.join(" | ", coach.getRecommendedMenus()) + " ]\n", coach.getName());
        }

        System.out.println("\n추천을 완료했습니다.");
    }
}
