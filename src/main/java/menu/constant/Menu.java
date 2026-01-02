package menu.constant;

import java.util.Arrays;

public enum Menu {

    JAPANESE_1("규동"),
    JAPANESE_2("우동"),
    JAPANESE_3("미소시루"),
    JAPANESE_4("스시"),
    JAPANESE_5("가츠동"),
    JAPANESE_6("오니기리"),
    JAPANESE_7("하이라이스"),
    JAPANESE_8("라멘"),
    JAPANESE_9("오코노미야끼"),

    KOREAN_1("김밥"),
    KOREAN_2("김치찌개"),
    KOREAN_3("쌈밥"),
    KOREAN_4("된장찌개"),
    KOREAN_5("비빔밥"),
    KOREAN_6("칼국수"),
    KOREAN_7("불고기"),
    KOREAN_8("떡볶이"),
    KOREAN_9("제육볶음"),

    CHINESE_1("깐풍기"),
    CHINESE_2("볶음면"),
    CHINESE_3("동파육"),
    CHINESE_4("짜장면"),
    CHINESE_5("짬뽕"),
    CHINESE_6("마파두부"),
    CHINESE_7("탕수육"),
    CHINESE_8("토마토 달걀볶음"),
    CHINESE_9("고추잡채"),

    ASIAN_1("팟타이"),
    ASIAN_2("카오 팟"),
    ASIAN_3("나시고렝"),
    ASIAN_4("파인애플 볶음밥"),
    ASIAN_5("쌀국수"),
    ASIAN_6("똠얌꿍"),
    ASIAN_7("반미"),
    ASIAN_8("월남쌈"),
    ASIAN_9("분짜"),

    WESTERN_1("라자냐"),
    WESTERN_2("그라탱"),
    WESTERN_3("뇨끼"),
    WESTERN_4("끼슈"),
    WESTERN_5("프렌치 토스트"),
    WESTERN_6("바게트"),
    WESTERN_7("스파게티"),
    WESTERN_8("피자"),
    WESTERN_9("파니니"),
    ;

    private final String name;

    Menu(String name) {
        this.name = name;
    }

    public static Menu from(String name) {
        return Arrays.stream(values())
                .filter(menu -> menu.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NO_EXIST_MENU_ERROR.getErrorMessage()));
    }

    public String getName() {
        return name;
    }
}
