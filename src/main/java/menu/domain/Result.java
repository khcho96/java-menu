package menu.domain;

public final class Result {
    private final Categories categories;
    private final Coaches coaches;

    public Result(Categories categories, Coaches coaches) {
        this.categories = categories;
        this.coaches = coaches;
    }

    public Categories categories() {
        return categories;
    }

    public Coaches coaches() {
        return coaches;
    }

}
