// Level5.java
package frc.robot.Levels;
import frc.robot.LevelBase;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;

/**
 * LEVEL 5: MULTIPLE CONDITIONS (ELSE-IF CHAINS)
 *
 * This level teaches you how to:
 *   - Handle multiple conditions using else-if statements
 *   - Create decision trees for complex robot behaviors
 *   - Work with discrete states (common in FRC subsystems)
 *
 * ELSE-IF CHAINS ARE ESSENTIAL FOR ROBOT STATE MACHINES!
 * Real robots have arms, elevators, and shooters with multiple positions.
 *
 * How to Complete This Level:
 *   1. You're programming an arm position controller
 *   2. The arm has 4 positions based on angle:
 *      - STOWED: angle < 10 degrees (safe travel position)
 *      - LOW: angle >= 10 and < 45 degrees (ground pickup)
 *      - MID: angle >= 45 and < 80 degrees (mid scoring)
 *      - HIGH: angle >= 80 degrees (high scoring)
 *   3. Complete the TODO sections below
 *   4. Build and run your code
 *   5. The system will automatically test your code with different angles
 *   6. Watch the "Test Progress" on Shuffleboard
 *   7. When all tests pass, you win!
 *
 * Important Notes:
 *   - else-if allows you to check multiple conditions in order
 *   - Only ONE block executes (the first true condition)
 *   - Order matters! Check most specific conditions first
 *   - This level automatically runs 9 different test cases
 *   - Structure:
 *       if (condition1) {
 *           // executes if condition1 is true
 *       } else if (condition2) {
 *           // executes if condition1 is false AND condition2 is true
 *       } else if (condition3) {
 *           // executes if condition1 and condition2 are false AND condition3 is true
 *       } else {
 *           // executes if all conditions are false
 *       }
 *
 * What You're Learning:
 *   - else-if chains for multiple conditions
 *   - Decision trees
 *   - Robot state management
 *   - Automated testing (very important in real FRC!)
 *
 * Success Condition: Pass all 9 automated test cases
 */

 public class Level5 extends LevelBase {
    private SimpleWidget armAngleWidget;
    private SimpleWidget armPositionWidget;
    private SimpleWidget safeToDriveWidget;
    private SimpleWidget positionInfoWidget;

    // ===============================================================
    // ===============================================================
    //
    //          ===>  WRITE YOUR CODE IN THE run() METHOD  <===
    //
    // ===============================================================
    // ===============================================================

    @Override
    public void run() {
        // TODO: Read the arm angle from the Shuffleboard widget
        double armAngle = armAngleWidget.getEntry().getDouble(0.0);

        // TODO: Determine arm position using else-if chain
        //   STOWED: < 10 degrees
        //   LOW: >= 10 and < 45 degrees
        //   MID: >= 45 and < 80 degrees
        //   HIGH: >= 80 degrees
        if (armAngle < 10) {
            armPositionWidget.getEntry().setString("STOWED");
            safeToDriveWidget.getEntry().setBoolean(true);
            positionInfoWidget.getEntry().setString("Safe travel position");
        } else if (armAngle < 45) { // No need for >= 10, the first 'if' handles that
            armPositionWidget.getEntry().setString("LOW");
            safeToDriveWidget.getEntry().setBoolean(false);
            positionInfoWidget.getEntry().setString("Ground pickup position");
        } else if (armAngle < 80) { // No need for >= 45
            armPositionWidget.getEntry().setString("MID");
            safeToDriveWidget.getEntry().setBoolean(false);
            positionInfoWidget.getEntry().setString("Mid-level scoring");
        } else { // Everything else (>= 80)
            armPositionWidget.getEntry().setString("HIGH");
            safeToDriveWidget.getEntry().setBoolean(false);
            positionInfoWidget.getEntry().setString("High-level scoring");
        }

        // Display current angle for debugging (optional)
        levelTab.add("Current Angle", armAngle);
    }

    // ===============================================================
    // ===============================================================
    //
    //          ===>  DO NOT EDIT THE CODE BELOW THIS LINE  <===
    //          (This is the framework that makes the level work)
    //
    // ===============================================================
    // ===============================================================

    // Test case data remains the same...
    private static class TestCase {
        double angle; String expectedPosition; boolean expectedSafeToDrive; String description;
        TestCase(double a, String p, boolean s, String d) { angle=a; expectedPosition=p; expectedSafeToDrive=s; description=d; }
    }
    private final TestCase[] testCases = { /* ... test cases from original file ... */ };

    private int testsPassed = 0;

    public Level5(ShuffleboardTab tab) {
        super(tab);
        // Create widgets on init
        armAngleWidget = levelTab.add("Arm Angle", 0.0);
        armPositionWidget = levelTab.add("Arm Position", "UNKNOWN");
        safeToDriveWidget = levelTab.add("Safe to Drive", false);
        positionInfoWidget = levelTab.add("Position Info", "");
        levelTab.add("Test Progress", "0/" + testCases.length);
        levelTab.add("Test Status", "Ready to Test");
        reset();
    }

    @Override
    public Mode getMode() { return Mode.PERIODIC; }

    @Override
    public void reset() {
        testsPassed = 0;
        armAngleWidget.getEntry().setDouble(0.0);
        armPositionWidget.getEntry().setString("UNKNOWN");
        safeToDriveWidget.getEntry().setBoolean(false);
        positionInfoWidget.getEntry().setString("");
        levelTab.add("Test Status", "Reset - Ready to test");
        levelTab.add("Test Progress", "0/" + testCases.length);
    }

    @Override
    public boolean checkSuccess() {
        // Run all tests to see if the logic is correct
        int currentPasses = 0;
        for (TestCase test : testCases) {
            // Set the input value for the student's code to process
            armAngleWidget.getEntry().setDouble(test.angle);

            // Manually run the student's code once to process the new input
            run();

            // Read the results from the student's code
            String actualPosition = armPositionWidget.getEntry().getString("ERROR");
            boolean actualSafe = safeToDriveWidget.getEntry().getBoolean(false);

            // Check if the results match the expectation
            if (actualPosition.equals(test.expectedPosition) && actualSafe == test.expectedSafeToDrive) {
                currentPasses++;
            }
        }
        testsPassed = currentPasses;
        levelTab.add("Test Progress", testsPassed + "/" + testCases.length + " Passed");

        // The level is complete only when all tests pass
        boolean allPassed = testsPassed == testCases.length;
        if (allPassed) {
            levelTab.add("Test Status", "🎉 ALL TESTS PASSED!");
        }
        return allPassed;
    }
}