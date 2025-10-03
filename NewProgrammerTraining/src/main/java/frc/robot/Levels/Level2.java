// Level2.java
package frc.robot.Levels;
import frc.robot.LevelBase;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * LEVEL 2: UNDERSTANDING DATA TYPES
 *
 * This level teaches you about Java's basic data types and how to display them.
 *
 * You will learn how to:
 *   - Create variables with different data types
 *   - Display values on the SmartDashboard
 *   - Understand how different types are used in robotics
 *
 * DATA TYPES ARE THE BUILDING BLOCKS OF PROGRAMMING!
 * Understanding types helps you work with sensors, motors, and game data.
 *
 * How to Complete This Level:
 *   1. Look at the run() method below - it has TODO comments
 *   2. Create four variables with these types:
 *      - String: For text (like "Robot Ready!")
 *      - int: For whole numbers (like 42)
 *      - double: For decimal numbers (like 3.14)
 *      - boolean: For true/false values
 *   3. Display each variable on SmartDashboard using the right method:
 *      - putString() for String
 *      - putNumber() for int and double
 *      - putBoolean() for boolean
 *   4. Build your code
 *   5. Run your code in simulation
 *   6. Go back to Shuffleboard and change the LevelSelector to Level 2
 *   6. Enable the simulated Robot in FRC Driver Station
 *   5. Check Shuffleboard to see your values
 *
 * Important Notes:
 *   - String values need quotes: "like this"
 *   - int values are whole numbers: 1, 2, 3
 *   - double values can have decimals: 1.5, 2.75
 *   - boolean values are only true or false
 *   - SmartDashboard has different methods for different types
 *
 * What You're Learning:
 *   - Java's basic data types
 *   - Variable declaration and assignment
 *   - Sending different types of data to SmartDashboard
 *
 * Success Condition: All four values appear correctly on SmartDashboard
 */
public class Level2 extends LevelBase {
    private boolean completed = false;
    
    // ===============================================================
    // ===============================================================
    //
    //          ===>  WRITE YOUR CODE IN THE run() METHOD  <===
    //
    // ===============================================================
    // ===============================================================
    
    @Override
    public void run() {
        System.out.println("Level 2: Working with data types");
        
        // TODO: Create a String variable with your team name or a message
        // Example: String teamName = "Titan Robotics";
        
        
        // TODO: Create an int variable for a whole number (like team number)
        // Example: int teamNumber = 8334;
        
        
        // TODO: Create a double variable for a decimal number (like sensor reading)
        // Example: double sensorValue = 3.14159;
        
        
        // TODO: Create a boolean variable (true/false)
        // Example: boolean robotReady = true;
        
        
        // TODO: Display all variables on SmartDashboard
        // We now use the 'levelTab' variable to keep the UI clean.
        //levelTab.add("Team Name", teamName);
        //levelTab.add("Team Number", teamNumber);
        //levelTab.add("Sensor Reading", sensorValue);
        //levelTab.add("Robot Enabled", isEnabled);
        
        // Uncomment this line when you've completed the tasks
        // completed = true;
    }

        
    // ===============================================================
    // ===============================================================
    //
    //          ===>  DO NOT EDIT THE CODE BELOW THIS LINE  <===
    //          (This is the framework that makes the level work)
    //
    // ===============================================================
    // ===============================================================
    
    private ShuffleboardTab levelTab;
    public Level2(ShuffleboardTab tab) { this.levelTab = tab; }
    
    @Override
    public Mode getMode() { return Mode.ONCE; }
    
    @Override
    public void reset() {
        completed = false;
        // The tab system automatically clears the old UI,
        // but we can set default values if needed.
    }
    
    @Override
    public boolean checkSuccess() {
        return completed;
    }
}