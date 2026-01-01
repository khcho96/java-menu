package menu.view;

public class OutputView {

    private OutputView() {
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public static void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void printResult() {
    }
}
