package planit.web.auto.entities;

public class TestDetails {
    private static String testCaseName;

    public static String getTestCaseName() {
        return testCaseName;
    }

    public static void setTestCaseName(String testCaseName) {
        TestDetails.testCaseName = testCaseName;
    }
}
