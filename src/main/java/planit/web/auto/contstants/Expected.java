package planit.web.auto.contstants;

public enum Expected {
    DISPLAYING("displaying"),
    NOT_DISPLAYING("not displaying");

    private String expected;

    Expected(String expected) {
        this.expected = expected;
    }

    public String getExpected() {
        return expected;
    }
}
