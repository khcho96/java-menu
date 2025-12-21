package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.dto.CoachesDto;

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
        coaches.add(coach);
    }

    public CoachesDto getCoachesDto() {
        return new CoachesDto(coaches);
    }
}
