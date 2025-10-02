// Level4.java
package frc.robot.Levels;
import frc.robot.LevelBase;
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
    private boolean initialized = false;
    
    @Override
    public void run() {
        // Initialize default values if first run
        if (!initialized) {
            SmartDashboard.putNumber("Motor Speed", 0.0);
            SmartDashboard.putString("Status", "UNKNOWN");
            SmartDashboard.putBoolean("Can Move", false);
            initialized = true;
        }
        
        // TODO: Read the motor speed from Shuffleboard
        // double motorSpeed = SmartDashboard.getNumber("Motor Speed", 0.0);
        
        
        // TODO: Check if the speed is safe (between -1.0 and 1.0, inclusive)
        // HINT: A speed is safe if it's >= -1.0 AND <= 1.0
        // Use an if/else statement:
        
        // if (motorSpeed >= -1.0 && motorSpeed <= 1.0) {
        //     // Speed is SAFE
        //     SmartDashboard.putString("Status", "SAFE");
        //     SmartDashboard.putBoolean("Can Move", true);
        // } else {
        //     // Speed is DANGER
        //     SmartDashboard.putString("Status", "DANGER");
        //     SmartDashboard.putBoolean("Can Move", false);
        // }
        
        
        // TODO: Display the current speed for debugging
        // SmartDashboard.putNumber("Current Speed", motorSpeed);
        
        
        // Print to console for debugging
        // System.out.println("Motor Speed: " + motorSpeed + " - Status: " + 
        //                    SmartDashboard.getString("Status", "UNKNOWN"));
    }
    
    @Override
    public Mode getMode() { 
        // Loop mode to continuously check the speed
        return Mode.LOOP; 
    }
    
    @Override
    public void reset() {
        initialized = false;
        SmartDashboard.putNumber("Motor Speed", 0.0);
        SmartDashboard.putString("Status", "UNKNOWN");
        SmartDashboard.putBoolean("Can Move", false);
        SmartDashboard.putNumber("Current Speed", 0.0);
    }
    
    @Override
    public boolean checkSuccess() {
        // Test multiple scenarios to verify the logic works
        double speed = SmartDashboard.getNumber("Motor Speed", 0.0);
        String status = SmartDashboard.getString("Status", "UNKNOWN");
        boolean canMove = SmartDashboard.getBoolean("Can Move", false);
        
        // Check if the logic is correct
        if (speed >= -1.0 && speed <= 1.0) {
            // Should be SAFE
            return status.equals("SAFE") && canMove == true;
        } else {
            // Should be DANGER
            return status.equals("DANGER") && canMove == false;
        }
    }
}