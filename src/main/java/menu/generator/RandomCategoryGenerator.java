package menu.generator;

import static menu.constant.Constant.CATEGORY_NAMES;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomCategoryGenerator {

    public static String generateCategory() {
        int number = Randoms.pickNumberInRange(1, 5);
        return CATEGORY_NAMES.get(number - 1);
    }
}
