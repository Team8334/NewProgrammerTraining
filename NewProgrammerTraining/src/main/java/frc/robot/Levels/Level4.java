// Level4.java
package frc.robot.Levels;
import frc.robot.LevelBase;
import edu.wpi.first.networktables.NetworkTableEntry;
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
 *   2. In the Elastic dashboard, find the "/SmartDashboard/Level 4/Motor Speed" entry and add it to your grid.
 *   3. Complete the code to:
 *      - Read the motor speed from the dashboard
 *      - Check if speed is safe (between -1.0 and 1.0)
 *      - If safe: Set "Status" to "SAFE" and "Can Move" to true
 *      - If unsafe: Set "Status" to "DANGER" and "Can Move" to false
 *      - Display the actual speed value
 *   4. Test with different speeds in the Elastic widget
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

    private final NetworkTableEntry motorSpeedEntry;
    private final NetworkTableEntry statusEntry;
    private final NetworkTableEntry canMoveEntry;

    // ===============================================================
    // ===============================================================
    //
    //          ===>  WRITE YOUR CODE IN THE run() METHOD  <===
    //
    // ===============================================================
    // ===============================================================

    @Override
    public void run() {
        // TODO: Read the motor speed from the dashboard
        double motorSpeed = motorSpeedEntry.getDouble(0.0);

        // TODO: Check if the speed is safe (between -1.0 and 1.0, inclusive)
        // HINT: A speed is safe if it's >= -1.0 AND <= 1.0
        // Use an if/else statement:
        if (motorSpeed >= -1.0 && motorSpeed <= 1.0) {
            // Speed is SAFE
            statusEntry.setString("SAFE");
            canMoveEntry.setBoolean(true);
        } else {
            // Speed is DANGEROUS
            statusEntry.setString("DANGER");
            canMoveEntry.setBoolean(false);
        }

        // Display the current speed for debugging (optional). 
        // We already read it, but this shows how you could display a processed value.
        SmartDashboard.putNumber(levelName + "/Current Speed", motorSpeed);
    }
    
    // ===============================================================
    // ===============================================================
    //
    //          ===>  DO NOT EDIT THE CODE BELOW THIS LINE  <===
    //          (This is the framework that makes the level work)
    //
    // ===============================================================
    // ===============================================================

    public Level4(String name) {
        super(name);
        // Get the NetworkTableEntry for each piece of data.
        // The level name (e.g., "Level 4") is used as a prefix to group them.
        motorSpeedEntry = SmartDashboard.getEntry(name + "/Motor Speed");
        statusEntry = SmartDashboard.getEntry(name + "/Status");
        canMoveEntry = SmartDashboard.getEntry(name + "/Can Move");
        reset();
    }

    @Override
    public Mode getMode() { return Mode.PERIODIC; }

    @Override
    public void reset() {
        motorSpeedEntry.setDouble(0.0);
        statusEntry.setString("UNKNOWN");
        canMoveEntry.setBoolean(false);
        SmartDashboard.putNumber(levelName + "/Current Speed", 0.0);
    }

    @Override
    public boolean checkSuccess() {
        // Read values directly from the dashboard entries for validation
        double speed = motorSpeedEntry.getDouble(0.0);
        String status = statusEntry.getString("UNKNOWN");
        boolean canMove = canMoveEntry.getBoolean(false);

        // Check if the logic is correct for the current input
        boolean isSafe = speed >= -1.0 && speed <= 1.0;
        
        if (isSafe) {
            return status.equals("SAFE") && canMove;
        } else {
            return status.equals("DANGER") && !canMove;
        }
    }
}