package menu.generator;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.Menu;

public final class RandomCategoryGenerator {

    public static String generateCategory() {
        int index = Randoms.pickNumberInRange(1, 5);
        return Menu.fromIndex(index).getCategory();
    }
}
