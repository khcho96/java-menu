package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.constant.ErrorMessage;

public class Coaches {

    private final List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public static Coaches from(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();

        for (String coachName : coachNames) {
            Coach coach = Coach.from(coachName);
            validateCoachDuplication(coaches, coach);
            coaches.add(coach);
        }

        validateCoachMaxCount(coaches);
        validateCoachMinCount(coaches);

        return new Coaches(coaches);
    }

    private static void validateCoachDuplication(List<Coach> coaches, Coach coach) {
        if (coaches.contains(coach)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_DUPLICATION_ERROR.getErrorMessage());
        }
    }

    private static void validateCoachMaxCount(List<Coach> coaches) {
        if (coaches.size() > 5) {
            throw new IllegalArgumentException(ErrorMessage.COACH_MAX_COUNT_ERROR.getErrorMessage());
        }
    }

    private static void validateCoachMinCount(List<Coach> coaches) {
        if (coaches.size() < 2) {
            throw new IllegalArgumentException(ErrorMessage.COACH_MIN_COUNT_ERROR.getErrorMessage());
        }
    }

    public List<String> getCoachNames() {
        return coaches.stream()
                .map(Coach::getName)
                .toList();
    }

    public Coach getCoach(String coachName) {
        return coaches.stream()
                .filter(coach -> coach.getName().equals(coachName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NO_EXIST_NAME_ERROR.getErrorMessage()));
    }
}
