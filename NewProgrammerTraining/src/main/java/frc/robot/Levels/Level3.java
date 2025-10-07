// Level3.java
package frc.robot.Levels;
import frc.robot.LevelBase;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * LEVEL 3: INPUTS, CALCULATIONS, AND LOOPS
 *
 * This level teaches you how to read live inputs, perform math, and display
 * the results in a continuous loop.
 *
 * You will learn how to:
 *   - Read number values that a user types into the Elastic dashboard.
 *   - Use a variable to store the result of a calculation.
 *   - Run code continuously to create a live-updating display.
 *
 * THIS IS THE CORE LOGIC OF A ROBOT: READ SENSORS -> THINK -> CONTROL MOTORS
 *
 * How to Complete This Level:
 *   1. Build and Deploy/Simulate this code.
 *   2. Open the Elastic dashboard.
 *   3. In the "Level Select" dropdown, choose "Level 3".
 *   4. Create a new tab in Elastic and name it "Level 3".
 *   5. Go to the "Unassigned" tab to find the data this level is sending.
 *        ➤ You will see "/SmartDashboard/Level 3/Number A", ".../Number B", and ".../Sum".
 *   6. Drag those three items onto your "Level 3" tab to create widgets.
 *   7. Click on the "Number A" and "Number B" widgets and type in different numbers.
 *   8. Go to the run() method below and follow the TODO instructions.
 *   9. Your goal is to make the "Sum" widget correctly show the sum of A + B.
 *        ➤ For example, if A is 5 and B is 10, Sum should show 15.
 *  10. The level will pass automatically once your calculation is correct.
 *
 * Important Notes:
 *   - This level uses Mode.PERIODIC – the run() method is a loop that
 *     executes about 50 times per second.
 *   - We use .getDouble(0.0) to READ a number from the dashboard.
 *   - The '0.0' is a default value, used if the value can't be found.
 *   - We use .setDouble(sum) to WRITE a number to the dashboard.
 *
 * Success Condition: The "Sum" widget correctly displays the sum of A + B.
 */
public class Level3 extends LevelBase {
    // These variables hold the connection to our dashboard data.
    private final NetworkTableEntry numberAEntry;
    private final NetworkTableEntry numberBEntry;
    private final NetworkTableEntry sumEntry;
    
    // ===============================================================
    // ===============================================================
    //
    //          ===>  WRITE YOUR CODE IN THE run() METHOD  <===
    //
    // ===============================================================
    // ===============================================================
    
    public void run() {
        // Since this method is a loop, these lines will run over and over every 20ms.

        // TODO 1: Read the number from the "Number A" widget and store it in a variable.
        double numberA = numberAEntry.getDouble(0.0);
        
        // TODO 2: Read the number from the "Number B" widget.
        double numberB = numberBEntry.getDouble(0.0);
        
        // TODO 3: Calculate the sum of numberA and numberB and store it in a new variable.
        // I dont think you need help on this one
        double sum = numberA + numberB;

        
        // TODO 4: Display the calculated sum in the "Sum" widget.
        sumEntry.setDouble(sum);


        // For debugging, you can print the values to the console.
        // To see this, uncomment the line below, redeploy, and watch the terminal.
        System.out.println("A: " + numberA + " + B: " + numberB + " = " + sum);
    }
    
    // ===============================================================
    //          (The code below is the level's framework)
    // ===============================================================

    // The constructor now accepts a String name instead of a ShuffleboardTab.
    public Level3(String name) {
        super(name);

        // Get the NetworkTableEntry for each piece of data we want to display.
        // The name (e.g., "Level 3") is used to create a unique key.
        // In Elastic, these will appear grouped under "/SmartDashboard/Level 3/".
        numberAEntry = SmartDashboard.getEntry(name + "/Number A");
        numberBEntry = SmartDashboard.getEntry(name + "/Number B");
        sumEntry     = SmartDashboard.getEntry(name + "/Sum");
        
        // Ensure the dashboard starts with clean values.
        reset();
    }

    @Override
    public Mode getMode() { 
        // PERIODIC mode makes the run() method execute in a continuous loop.
        return Mode.PERIODIC; 
    }
    
    @Override
    public void reset() {
        // When the level is reset, set all dashboard numbers back to 0.
        numberAEntry.setDouble(0.0);
        numberBEntry.setDouble(0.0);
        sumEntry.setDouble(0.0);
    }
    
    @Override
    public boolean checkSuccess() {
        // This method automatically checks if your calculation is correct.
        // It reads the inputs and compares them to the displayed sum.
        double a = numberAEntry.getDouble(0.0);
        double b = numberBEntry.getDouble(0.0);
        double displayedSum = sumEntry.getDouble(0.0);
        
        // Because computers can have tiny errors with decimal numbers (doubles),
        // we check if the difference is a very, very small number instead of checking
        // for exact equality.
        return Math.abs(displayedSum - (a + b)) < 0.0001;
    }
}