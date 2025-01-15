package hellocucumber;

public class Utils {
    private static final String projectFolderName = "Cucumber";

    public static String getRepositoryRootPath() {
        String currentPath = Utils.class.getResource("Utils.class").getPath();
        String[] pathParts = currentPath.split(projectFolderName);
        return pathParts[0].substring(1);
    }

    public static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {}
    }
}
