package menu.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class MenuServiceTest {

    @Test
    void 코치_이름_저장() {

        MenuService menuService = new MenuService();
        assertThat(menuService.registerCoaches(List.of("가가", "나나")))
                .containsExactlyElementsOf(List.of("가가", "나나"));
    }
}