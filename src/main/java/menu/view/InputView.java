package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String COACH_NAME_REQUEST = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public static String readCoachNames() {
        System.out.println(COACH_NAME_REQUEST);
        return Console.readLine();
    }
}
