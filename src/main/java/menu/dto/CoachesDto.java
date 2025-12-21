package menu.dto;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;

public class CoachesDto {

    private final List<Coach> coaches;

    public CoachesDto(List<Coach> coaches) {
        this.coaches = new ArrayList<>(coaches);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
