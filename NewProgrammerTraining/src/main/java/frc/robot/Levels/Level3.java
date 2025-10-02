// Level3.java
package frc.robot.Levels;
import frc.robot.LevelBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * LEVEL 3: INPUTS AND ARITHMETIC
 *
 * This level teaches you how to:
 *   - Read input values from Shuffleboard
 *   - Perform arithmetic operations
 *   - Display calculated results
 *
 * INPUTS AND CALCULATIONS ARE ESSENTIAL FOR ROBOTICS!
 * You'll use these skills to process sensor data and control your robot.
 *
 * How to Complete This Level:
 *   1. Look at the run() method - it runs repeatedly (LOOP mode)
 *   2. In Shuffleboard, you'll see two input fields: "Number A" and "Number B"
 *   3. Enter different numbers in these fields
 *   4. Complete the code to:
 *      - Read both numbers from Shuffleboard
 *      - Calculate their sum
 *      - Display the result in "Sum" field
 *   5. The level passes when you correctly calculate and display the sum
 *
 * Important Notes:
 *   - Use SmartDashboard.getNumber() to read input values
 *   - Provide default values (like 0.0) in case no input exists
 *   - Use the + operator to add numbers
 *   - Use SmartDashboard.putNumber() to display the result
 *   - This level uses Mode.LOOP so it runs continuously
 *
 * What You're Learning:
 *   - Reading input from Shuffleboard
 *   - Basic arithmetic in Java
 *   - Continuous processing (loop mode)
 *
 * Success Condition: The "Sum" field correctly shows the sum of Number A and Number B
 */
public class Level3 extends LevelBase {
    private boolean initialized = false;
    
    @Override
    public void run() {
        // Initialize default values if first run
        if (!initialized) {
            SmartDashboard.putNumber("Number A", 0.0);
            SmartDashboard.putNumber("Number B", 0.0);
            SmartDashboard.putNumber("Sum", 0.0);
            initialized = true;
        }
        
        // TODO: Read Number A from Shuffleboard
        // double numberA = SmartDashboard.getNumber("Number A", 0.0);
        
        // TODO: Read Number B from Shuffleboard
        // double numberB = SmartDashboard.getNumber("Number B", 0.0);
        
        // TODO: Calculate the sum
        // double sum = numberA + numberB;
        
        // TODO: Display the result on Shuffleboard
        // SmartDashboard.putNumber("Sum", sum);
        
        // Print to console for debugging
        // System.out.println("A: " + numberA + " + B: " + numberB + " = " + sum);
    }
    
    @Override
    public Mode getMode() { 
        // This level runs continuously to update as inputs change
        return Mode.LOOP; 
    }
    
    @Override
    public void reset() {
        initialized = false;
        SmartDashboard.putNumber("Number A", 0.0);
        SmartDashboard.putNumber("Number B", 0.0);
        SmartDashboard.putNumber("Sum", 0.0);
    }
    
    @Override
    public boolean checkSuccess() {
        // Get the current values
        double a = SmartDashboard.getNumber("Number A", 0.0);
        double b = SmartDashboard.getNumber("Number B", 0.0);
        double displayedSum = SmartDashboard.getNumber("Sum", 0.0);
        
        // Check if the displayed sum matches the actual sum
        // Allow for tiny floating-point errors with a small epsilon
        double actualSum = a + b;
        double epsilon = 0.0001;
        
        return Math.abs(displayedSum - actualSum) < epsilon;
    }
}