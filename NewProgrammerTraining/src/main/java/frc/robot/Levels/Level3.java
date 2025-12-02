package frc.robot.Levels;
import frc.robot.LevelBase;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * =================================================================================================
 * LEVEL 3: LIVE INPUTS, CALCULATIONS, AND LOOPS
 * =================================================================================================
 *
 * This level teaches you the core logic loop of a robot: reading live data,
 * thinking (doing math), and showing the result.
 *
 * You will learn how to:
 *   - Read numbers that a user types into the Elastic dashboard.
 *   - Perform a simple calculation with those numbers.
 *   - Run code over and over in a continuous loop to create a live-updating display.
 *
 * This is the fundamental pattern of all robotics:
 *   READ SENSORS  ->  THINK/CALCULATE  ->  CONTROL MOTORS
 *
 * In this level, your keyboard and the dashboard are the "sensors," and the "Sum"
 * display is your "motor."
 *
 * ---
 *
 * YOUR GOAL:
 *  - Make a simple calculator. Read two numbers from the dashboard, add them
 *    together, and display the result in a "Sum" widget.
 *
 * =================================================================================================
 *
 * ===>  VERY IMPORTANT NOTE FOR THIS LEVEL  <===
 *
 * When you simulate this code, you will need to type numbers into the dashboard.
 * If you use the "real DriverStation," pressing the Enter key on your keyboard will
 * also DISABLE the robot, which is very frustrating.
 *
 * TO AVOID THIS PROBLEM:
 * When you select "WPILib: Simulate Robot Code":
 *   - A small pop-up will appear at the top of VS Code.
 *   - **DO NOT** check the box for "Use real DriverStation".
 *   - Just click "OK" with the box unchecked.
 *
 * A simulated Driver Station will appear on your screen for you to enable the robot.
 *
 * =================================================================================================
 *
 * STEP-BY-STEP INSTRUCTIONS:
 *
 *   1. Build and Simulate your code (remember the note above!).
 *
 *   2. In Elastic, use the "Level Select" widget to choose "Level 3".
 *
 *   3. Find the new widgets for this level. They will be under the SmartDashboard dropdown
 *      and will be named "Number A", "Number B", and "Sum".
 *
 *   4. Drag all three widgets onto your dashboard.
 *
 *   5. Double-click the value box for "Number A" and "Number B" and type in a number.
 *      Press Enter to confirm.
 *
 *   6. Now, go to the `run()` method below and complete the TODOs. Your job is to make
 *      the "Sum" widget correctly show the sum of A + B.
 *
 *   7. The level will automatically pass once your calculation is correct.
 *
 * =================================================================================================
 */
public class Level3 extends LevelBase {
    // These variables are special. They are not just storing a number, they are
    // creating a permanent, live connection to a widget on the dashboard.
    // Think of `NetworkTableEntry` as a direct phone line to that specific widget.
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
        // Because this level is in "PERIODIC" mode, the code inside this `run()` method
        // will execute from top to bottom about 50 times every second.

        // TODO 1: Read the current value from the "Number A" widget.
        // We use our special "network table" variable and ask it to `.getDouble()`.
        // The `0.0` is a default value to use if it can't connect to the dashboard.
         double numberA = numberAEntry.getDouble(0.0);
        
        // TODO 2: Do the same for the "Number B" widget. Read its value.
        double numberB = numberBEntry.getDouble(0.0);
        
        // TODO 3: Calculate the sum of numberA and numberB.
        // Store the result in a new `double` variable called `sum`. 
         double sum = numberA+numberB;
        
        // TODO 4: Send your calculated `sum` back to the "Sum" widget on the dashboard.
        // This uses the "phone line" for the sum widget to `.setDouble()` its value.
         sumEntry.setDouble(sum);


        // For debugging, you can print values to the console.
        // To see this, uncomment the line below, redeploy, and watch the terminal.
         System.out.println("A: " + numberA + " + B: " + numberB + " = " + sum);
    }
    
    // ===============================================================
    // ===============================================================
    //
    //          ===>  DO NOT EDIT THE CODE BELOW THIS LINE  <===
    //          (This is the framework that makes the level work)
    //
    // ===============================================================
    // ===============================================================

    public Level3(String name) {
        super(name);

        // This code sets up our live "phone lines" to the dashboard widgets.
        // It tells the program: "I will need to talk to widgets named 'Number A',
        // 'Number B', and 'Sum' inside the 'Level 3' group."
        numberAEntry = SmartDashboard.getEntry(name + "/Number A");
        numberBEntry = SmartDashboard.getEntry(name + "/Number B");
        sumEntry     = SmartDashboard.getEntry(name + "/Sum");
        
        // This ensures the dashboard starts with clean, predictable values.
        reset();
    }

    @Override
    public Mode getMode() { 
        // PERIODIC mode tells the framework to run the `run()` method
        // in a continuous loop, over and over, until the robot is disabled.
        return Mode.PERIODIC; 
    }
    
    @Override
    public void reset() {
        // When the level is reset, this sets all dashboard numbers back to 0.
        numberAEntry.setDouble(0.0);
        numberBEntry.setDouble(0.0);
        sumEntry.setDouble(0.0);
    }
    
    @Override
    public boolean checkSuccess() {
        // This method is also running in the background. It automatically
        // checks if your calculation is correct.
        double a = numberAEntry.getDouble(0.0);
        double b = numberBEntry.getDouble(0.0);
        double displayedSum = sumEntry.getDouble(0.0);
        
        // Because computers can have tiny precision errors with decimal numbers,
        // we check if the result is "close enough" rather than perfectly equal.
        return Math.abs(displayedSum - (a + b)) < 0.0001;
    }
}