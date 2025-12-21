package menu.domain;

import static menu.constant.ErrorMessage.NAME_UNIQUE_ERROR;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.dto.CoachNamesDto;

public class Coaches {

    private final List<Coach> coaches;

    public Coaches() {
        this.coaches = new ArrayList<>();
    }

    public static Coaches newInstance() {
        return new Coaches();
    }

    public void addCoach(String coachName) {
        Coach coach = Coach.from(coachName);

        if (coaches.contains(coach)) {
            throw new IllegalArgumentException(NAME_UNIQUE_ERROR.getErrorMessage());
        }

        coaches.add(coach);
    }

    public CoachNamesDto getCoachNamesDto() {
        List<String> coachNames = coaches.stream()
                .map(Coach::getName)
                .collect(Collectors.toList());
        return new CoachNamesDto(coachNames);
    }

    public Coach getCoach(String coachName) {
        for (Coach coach : coaches) {
            if (coach.getName().equals(coachName)) {
                return coach;
            }
        }
        return null;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
