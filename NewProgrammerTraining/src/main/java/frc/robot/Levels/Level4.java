// Level4.java
package frc.robot.Levels;
import frc.robot.LevelBase;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * LEVEL 4: CONDITIONAL LOGIC (IF/ELSE)
 *
 * This level teaches you how to:
 *   - Make decisions in code using if/else statements
 *   - Compare values using comparison operators
 *   - Control robot behavior based on conditions
 *
 * CONDITIONALS ARE THE BRAIN OF YOUR ROBOT!
 * They let your robot make decisions like "if object detected, then stop"
 *
 * How to Complete This Level:
 *   1. You're building a simple speed limiter for robot safety
 *   2. In Shuffleboard, you'll see a "Motor Speed" input field
 *   3. Complete the code to:
 *      - Read the motor speed from Shuffleboard
 *      - Check if speed is safe (between -1.0 and 1.0)
 *      - If safe: Set "Status" to "SAFE" and "Can Move" to true
 *      - If unsafe: Set "Status" to "DANGER" and "Can Move" to false
 *      - Display the actual speed value
 *   4. Test with different speeds in Shuffleboard
 *   5. Level passes when your logic works correctly
 *
 * Important Notes:
 *   - Motor speeds in FRC are typically -1.0 to 1.0
 *   - Comparison operators: < (less than), > (greater than), <= (less/equal), >= (greater/equal)
 *   - Use && for AND, || for OR
 *   - if/else structure:
 *       if (condition) {
 *           // code when true
 *       } else {
 *           // code when false
 *       }
 *
 * What You're Learning:
 *   - if/else conditional statements
 *   - Comparison operators
 *   - Logical operators (&&, ||)
 *   - Safety checks (critical in robotics!)
 *
 * Success Condition: Correctly identify safe vs unsafe motor speeds
 */
public class Level4 extends LevelBase {
    private SimpleWidget motorSpeedWidget;
    private SimpleWidget statusWidget;
    private SimpleWidget canMoveWidget;

    // ===============================================================
    // ===============================================================
    //
    //          ===>  WRITE YOUR CODE IN THE run() METHOD  <===
    //
    // ===============================================================
    // ===============================================================

    @Override
    public void run() {
        // TODO: Read the motor speed from the Shuffleboard widget
        double motorSpeed = motorSpeedWidget.getEntry().getDouble(0.0);

        // TODO: Check if the speed is safe (between -1.0 and 1.0, inclusive)
        // HINT: A speed is safe if it's >= -1.0 AND <= 1.0
        // Use an if/else statement:
        if (motorSpeed >= -1.0 && motorSpeed <= 1.0) {
            // Speed is SAFE
            statusWidget.getEntry().setString("SAFE");
            canMoveWidget.getEntry().setBoolean(true);
        } else {
            // Speed is DANGEROUS
            statusWidget.getEntry().setString("DANGER");
            canMoveWidget.getEntry().setBoolean(false);
        }

        // Display the current speed for debugging (optional)
        levelTab.add("Current Speed", motorSpeed);
    }
    

    // ===============================================================
    // ===============================================================
    //
    //          ===>  DO NOT EDIT THE CODE BELOW THIS LINE  <===
    //          (This is the framework that makes the level work)
    //
    // ===============================================================
    // ===============================================================

    public Level4(ShuffleboardTab tab) {
        super(tab);
        // Create the widgets on the tab when the level is loaded
        motorSpeedWidget = levelTab.add("Motor Speed", 0.0);
        statusWidget = levelTab.add("Status", "UNKNOWN");
        canMoveWidget = levelTab.add("Can Move", false);
        reset();
    }

    @Override
    public Mode getMode() { return Mode.LOOP; }

    @Override
    public void reset() {
        motorSpeedWidget.getEntry().setDouble(0.0);
        statusWidget.getEntry().setString("UNKNOWN");
        canMoveWidget.getEntry().setBoolean(false);
        levelTab.add("Current Speed", 0.0);
    }

    @Override
    public boolean checkSuccess() {
        // Read values directly from the widgets for validation
        double speed = motorSpeedWidget.getEntry().getDouble(0.0);
        String status = statusWidget.getEntry().getString("UNKNOWN");
        boolean canMove = canMoveWidget.getEntry().getBoolean(false);

        // Check if the logic is correct for the current input
        if (speed >= -1.0 && speed <= 1.0) {
            return status.equals("SAFE") && canMove;
        } else {
            return status.equals("DANGER") && !canMove;
        }
    }
}