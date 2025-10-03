// Level3.java
package frc.robot.Levels;
import frc.robot.LevelBase;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;
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
    
    // Framework variables for our widgets
    private SimpleWidget numberAWidget;
    private SimpleWidget numberBWidget;
    private SimpleWidget sumWidget;

    // ===============================================================
    //          ===>  WRITE YOUR CODE IN THE run() METHOD  <===
    // ===============================================================
    
    @Override
    public void run() {

        // Use getNumber() to read values. If the entry doesn't exist, it uses the default.
        //double numberA = levelTab.add("Number A", 0.0).getEntry().getDouble(0.0);
        //double numberB = levelTab.add("Number B", 0.0).getEntry().getDouble(0.0);
        
        // TODO: Calculate the sum
        // double sum = numberA + numberB;
        
        // TODO: Display the result on Shuffleboard
        // sumWidget.getEntry().setDouble(sum);

        // Print to console for debugging
        // System.out.println("A: " + numberA + " + B: " + numberB + " = " + sum);
    }
    

    // ===============================================================
    //          ===>  DO NOT EDIT THE CODE BELOW THIS LINE  <===
    // ===============================================================

    public Level3(ShuffleboardTab tab) {
        this.levelTab = tab;
        numberAWidget = levelTab.add("Number A", 0.0);
        numberBWidget = levelTab.add("Number B", 0.0);
        sumWidget = levelTab.add("Sum", 0.0);
    }

    @Override
    public Mode getMode() { 
        // This level runs continuously to update as inputs change
        return Mode.LOOP; 
    }
    
    @Override
    public void reset() {
        // Set the widgets back to their default values
        numberAWidget.getEntry().setDouble(0.0);
        numberBWidget.getEntry().setDouble(0.0);
        sumWidget.getEntry().setDouble(0.0);
    }
    
    @Override
    public boolean checkSuccess() {
        double a = numberAWidget.getEntry().getDouble(0.0);
        double b = numberBWidget.getEntry().getDouble(0.0);
        double displayedSum = sumWidget.getEntry().getDouble(0.0);
        
        return Math.abs(displayedSum - (a + b)) < 0.0001;
    }
}