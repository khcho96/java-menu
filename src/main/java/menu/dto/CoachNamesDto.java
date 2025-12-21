package menu.dto;

import java.util.ArrayList;
import java.util.List;

public class CoachNamesDto {

    private final List<String> coachNames;

    public CoachNamesDto(List<String> coachNames) {
        this.coachNames = new ArrayList<>(coachNames);
    }

    public List<String> getCoachNames() {
        return coachNames;
    }
}
