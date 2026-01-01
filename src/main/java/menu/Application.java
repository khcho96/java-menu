package menu;

import menu.controller.MenuController;
import menu.service.MenuService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MenuService menuService = new MenuService();
        MenuController menuController = new MenuController(menuService);
        menuController.run();
    }
}
