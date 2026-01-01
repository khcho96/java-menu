package menu.service;

import java.util.List;
import menu.domain.Coaches;

public class MenuService {

    private Coaches coaches;

    public List<String> registerCoaches(List<String> names) {
        coaches = Coaches.from(names);
        return coaches.getCoachNames();
    }

    // 도메인 객체 인스턴스 변수로 저장

    // 메서드
}
