package menu.constant;

import java.util.Arrays;
import java.util.List;

public enum Category {

    JAPANESE(1, "일식", List.of(Menu.JAPANESE_1,Menu.JAPANESE_2,Menu.JAPANESE_3,Menu.JAPANESE_4,Menu.JAPANESE_5,Menu.JAPANESE_6,Menu.JAPANESE_7,Menu.JAPANESE_8,Menu.JAPANESE_9)),
    KOREAN(2, "한식", List.of(Menu.KOREAN_1, Menu.KOREAN_2, Menu.KOREAN_3, Menu.KOREAN_4, Menu.KOREAN_5, Menu.KOREAN_6, Menu.KOREAN_7, Menu.KOREAN_8, Menu.KOREAN_9)),
    CHINESE(3, "중식", List.of(Menu.CHINESE_1,Menu.CHINESE_2,Menu.CHINESE_3,Menu.CHINESE_4,Menu.CHINESE_5,Menu.CHINESE_6,Menu.CHINESE_7,Menu.CHINESE_8,Menu.CHINESE_9)),
    ASIAN(4, "아시안", List.of(Menu.ASIAN_1,Menu.ASIAN_2,Menu.ASIAN_3,Menu.ASIAN_4,Menu.ASIAN_5,Menu.ASIAN_6,Menu.ASIAN_7,Menu.ASIAN_8,Menu.ASIAN_9)),
    WESTERN(5, "양식", List.of(Menu.WESTERN_1,Menu.WESTERN_2,Menu.WESTERN_3,Menu.WESTERN_4,Menu.WESTERN_5,Menu.WESTERN_6,Menu.WESTERN_7,Menu.WESTERN_8,Menu.WESTERN_9)),
    NONE(0, null, null),
    ;

    private final int index;
    private final String name;
    private final List<Menu> menus;

    Category(int index, String name, List<Menu> menus) {
        this.index = index;
        this.name = name;
        this.menus = menus;
    }

    public static Category fromIndex(int index) {
        return Arrays.stream(values())
                .filter(category -> category.index == index)
                .findFirst()
                .orElse(NONE);
    }

    public String getName() {
        return name;
    }

    public List<String> getMenus() {
        return menus.stream()
                .map(Menu::getName)
                .toList();
    }
}
