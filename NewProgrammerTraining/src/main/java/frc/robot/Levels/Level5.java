// Level5.java
package frc.robot.Levels;
import frc.robot.LevelBase;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
 *   1. You're programming an arm position controller.
 *   2. The arm has 4 positions based on angle:
 *      - STOWED: angle < 10 degrees (safe travel position)
 *      - LOW: angle >= 10 and < 45 degrees (ground pickup)
 *      - MID: angle >= 45 and < 80 degrees (mid scoring)
 *      - HIGH: angle >= 80 degrees (high scoring)
 *   3. Complete the TODO sections in the run() method.
 *   4. Build and deploy/simulate your code.
 *   5. In the Elastic dashboard, add the widgets under "/SmartDashboard/Level 5/".
 *   6. The system will automatically test your code with different angles.
 *   7. Watch the "Test Progress" widget. When all tests pass, you win!
 *
 * Important Notes:
 *   - else-if allows you to check multiple conditions in order.
 *   - Only ONE block executes (the first true condition).
 *   - Order matters!
 *   - This level automatically runs 9 different test cases.
 *   - Structure:
 *       if (condition1) { ... } 
 *       else if (condition2) { ... } 
 *       else { ... }
 *
 * What You're Learning:
 *   - else-if chains for multiple conditions
 *   - Decision trees and robot state management
 *   - Automated testing (very important in real FRC!)
 *
 * Success Condition: Pass all 9 automated test cases.
 */
public class Level5 extends LevelBase {
    private final NetworkTableEntry armAngleEntry;
    private final NetworkTableEntry armPositionEntry;
    private final NetworkTableEntry safeToDriveEntry;
    private final NetworkTableEntry positionInfoEntry;

    // ===============================================================
    // ===============================================================
    //
    //          ===>  WRITE YOUR CODE IN THE run() METHOD  <===
    //
    // ===============================================================
    // ===============================================================

    @Override
    public void run() {
        // TODO: Read the arm angle from the dashboard
        double armAngle = armAngleEntry.getDouble(0.0);

        // TODO: Determine arm position using an else-if chain
        //   STOWED: < 10 degrees
        //   LOW:    >= 10 and < 45 degrees
        //   MID:    >= 45 and < 80 degrees
        //   HIGH:   >= 80 degrees
        if (armAngle < 10) {
            armPositionEntry.setString("STOWED");
            safeToDriveEntry.setBoolean(true);
            positionInfoEntry.setString("Safe travel position");
        } else if (armAngle < 45) { // No need for '>= 10' check; the first 'if' already handled that
            armPositionEntry.setString("LOW");
            safeToDriveEntry.setBoolean(false);
            positionInfoEntry.setString("Ground pickup position");
        } else if (armAngle < 80) { // No need for '>= 45' check
            armPositionEntry.setString("MID");
            safeToDriveEntry.setBoolean(false);
            positionInfoEntry.setString("Mid-level scoring");
        } else { // Everything else (>= 80)
            armPositionEntry.setString("HIGH");
            safeToDriveEntry.setBoolean(false);
            positionInfoEntry.setString("High-level scoring");
        }

        // Display current angle for debugging (optional)
        SmartDashboard.putNumber(levelName + "/Current Angle", armAngle);
    }

    // ===============================================================
    // ===============================================================
    //
    //          ===>  DO NOT EDIT THE CODE BELOW THIS LINE  <===
    //          (This is the framework that makes the level work)
    //
    // ===============================================================
    // ===============================================================

    private static class TestCase {
        double angle; String expectedPosition; boolean expectedSafeToDrive;
        TestCase(double a, String p, boolean s) { angle=a; expectedPosition=p; expectedSafeToDrive=s; }
    }

    private final TestCase[] testCases = {
        new TestCase(-10.0, "STOWED", true),  // Edge case: negative
        new TestCase(0.0,   "STOWED", true),  // Boundary
        new TestCase(9.9,   "STOWED", true),  // Boundary
        new TestCase(10.0,  "LOW",    false), // Boundary
        new TestCase(30.0,  "LOW",    false), // Mid-range
        new TestCase(44.9,  "LOW",    false), // Boundary
        new TestCase(45.0,  "MID",    false), // Boundary
        new TestCase(79.9,  "MID",    false), // Boundary
        new TestCase(80.0,  "HIGH",   false)  // Boundary
    };

    private int testsPassed = 0;

    public Level5(String name) {
        super(name);
        armAngleEntry     = SmartDashboard.getEntry(name + "/Arm Angle");
        armPositionEntry  = SmartDashboard.getEntry(name + "/Arm Position");
        safeToDriveEntry  = SmartDashboard.getEntry(name + "/Safe to Drive");
        positionInfoEntry = SmartDashboard.getEntry(name + "/Position Info");
        reset();
    }

    @Override
    public Mode getMode() { return Mode.PERIODIC; }

    @Override
    public void reset() {
        testsPassed = 0;
        armAngleEntry.setDouble(0.0);
        armPositionEntry.setString("UNKNOWN");
        safeToDriveEntry.setBoolean(false);
        positionInfoEntry.setString("");
        SmartDashboard.putString(levelName + "/Test Status", "Reset - Ready to test");
        SmartDashboard.putString(levelName + "/Test Progress", "0/" + testCases.length);
    }

    @Override
    public boolean checkSuccess() {
        int currentPasses = 0;
        for (TestCase test : testCases) {
            // Set the input value for the student's code to process
            armAngleEntry.setDouble(test.angle);

            // Manually run the student's code once to process the new input
            run();

            // Read the results from the student's code
            String actualPosition = armPositionEntry.getString("ERROR");
            boolean actualSafe = safeToDriveEntry.getBoolean(false);

            // Check if the results match the expectation
            if (actualPosition.equals(test.expectedPosition) && actualSafe == test.expectedSafeToDrive) {
                currentPasses++;
            }
        }
        
        testsPassed = currentPasses;
        SmartDashboard.putString(levelName + "/Test Progress", testsPassed + "/" + testCases.length + " Passed");

        boolean allPassed = testsPassed == testCases.length;
        if (allPassed) {
            SmartDashboard.putString(levelName + "/Test Status", "🎉 ALL TESTS PASSED!");
        }
        return allPassed;
    }
}