public class ActivityHelper {
    public static void initialize(Activity activity) {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
}
//On another All activity
 ActivityHelper.initialize(this);
