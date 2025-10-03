// Level3.java
package frc.robot.Levels;
import frc.robot.LevelBase;

import java.util.DuplicateFormatFlagsException;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;

/**
 * LEVEL 3: INPUTS, CALCULATIONS, AND LOOPS
 *
 * This level teaches you how to read live inputs, perform math, and display
 * the results in a continuous loop.
 *
 * You will learn how to:
 *   - Read number values that a user types into Shuffleboard.
 *   - Use a variable to store the result of a calculation.
 *   - Run code continuously to create a live-updating display.
 *
 * THIS IS THE CORE LOGIC OF A ROBOT: READ SENSORS -> THINK -> CONTROL MOTORS
 *
 * How to Complete This Level:
 *   1. Build and Deploy/Simulate this code.
 *   2. On Shuffleboard Level Select, select the "Level 3" tab.
 *   3. On Shuffleboard, go to the "Level 3" tab.
 *        ➤ You will see two white input boxes: "Number A" and "Number B".
 *        ➤ You will also see a gray output box: "Sum".
 *   4. Click on the input boxes and type in different numbers.
 *   5. Go to the run() method below and follow the TODO instructions.
 *   6. Your goal is to make the "Sum" box correctly show the sum of A + B.
 *        ➤ For example, if A is 5 and B is 10, Sum should show 15.
 *   7. The level will pass automatically once your calculation is correct.
 *
 * Important Notes:
 *   - This level uses Mode.PERIODIC – the run() method is a loop that
 *     executes about 50 times per second.
 *   - We use .getEntry().getDouble(0.0) to READ a number from a widget.
 *   - The '0.0' is a default value, used if the widget can't be found.
 *   - We use .getEntry().setDouble(sum) to WRITE a number to a widget.
 *
 * Success Condition: The "Sum" widget correctly displays the sum of A + B.
 */
public class Level3 extends LevelBase {
    // Framework variables to hold our three Shuffleboard widgets.
    // We create them in the constructor so we can read from/write to them later.
    private SimpleWidget numberAWidget;
    private SimpleWidget numberBWidget;
    private SimpleWidget sumWidget;

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
        double numberA = numberAWidget.getEntry().getDouble(0.0);
        
        // TODO 2: Read the number from the "Number B" widget.
        double numberB = numberBWidget.getEntry().getDouble(0.0);
        
        // TODO 3: Calculate the sum of numberA and numberB and store it in a new variable.
        //I dont think you need help on this one 
        double sum = numberA + numberB;
        
        // TODO 4: Display the calculated sum in the "Sum" widget.
        sumWidget.getEntry().setDouble(300);


        // For debugging, you can print the values to the console.
        // To see this, uncomment the line below, redeploy, and watch the terminal.
        //System.out.println("A: " + numberA + " + B: " + numberB + " = " + sum);
    }
    

    // ===============================================================
    //          (The code below is the level's framework)
    // ===============================================================

    // The constructor runs ONCE to set up the level.
    public Level3(ShuffleboardTab tab) {
        super(tab);

        // CREATE the widgets ONCE and store them in our variables.
        // The user will be able to type into "Number A" and "Number B".
        numberAWidget = levelTab.add("Number A", 0.0);
        numberBWidget = levelTab.add("Number B", 0.0);

        // "Sum" is for display only. We can disable the text box so users can't edit it.
        sumWidget = levelTab.add("Sum", 0.0);
    }

    @Override
    public Mode getMode() { 
        // LOOP mode makes the run() method execute in a continuous loop.
        return Mode.PERIODIC; 
    }
    
    @Override
    public void reset() {
        // When the level is reset, set all the numbers back to 0.
    }
    
    @Override
    public boolean checkSuccess() {
        // This method automatically checks if your calculation is correct.
        // It reads the inputs and compares them to the displayed sum.
        double a = numberAWidget.getEntry().getDouble(0.0);
        double b = numberBWidget.getEntry().getDouble(0.0);
        double displayedSum = sumWidget.getEntry().getDouble(0.0);
        
        // Because computers can have tiny errors with decimal numbers (doubles),
        // we check if the difference is a very, very small number instead of checking
        // for exact equality.
        return Math.abs(displayedSum - (a + b)) < 0.0001;
    }
}