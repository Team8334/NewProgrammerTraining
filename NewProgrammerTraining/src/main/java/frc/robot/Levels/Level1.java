// Level1.java
package frc.robot.Levels;
import frc.robot.LevelBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * LEVEL 1: YOUR FIRST CODE - COMPILE & DEPLOY
 *
 * This level teaches you the core FRC programming workflow:
 *   1. Write Code → 2. Build → 3. Deploy → 4. Verify
 *
 * You will learn how to:
 *   - Use VS Code to write Java code.
 *   - Compile your code using WPILib's build system.
 *   - Deploy it to the RoboRIO or run in simulation.
 *   - View output on Shuffleboard.
 *
 * THIS IS THE FOUNDATION OF EVERYTHING YOU DO IN FRC.
 * Master this cycle, and you’re ready for anything!
 *
 * How to Complete This Level:
 *   1. Open Shuffleboard 2025 on your laptop.
 *   2. Open FRC Driver Station on your laptop.
 *   2. In VS Code:
 *        ➤ Press Ctrl+Shift+P → Type/Select "WPILib: Build Robot Code"
 *        ➤ Wait for "BUILD SUCCESSFUL"
 *   3. In VS Code:
 *        ➤ Press Ctrl+Shift+P → Type "WPILib: Simulate Robot Code"
 *        ➤ Select "Use real DriverStation".
 *        ➤ Wait for "RUNNING IN SIMULATOR"
 *   4. Go back to Shuffleboard → Look for the "Greeting" field.
 *        ➤ If you see "Waiting..." → Status says "FAILED"
 *   5. Go to FRC Driver Station → Click "Enable Robot"
 *   6. Go back to Shuffleboard → Look for the "Greeting" field.
 *        ➤ If you see "Hello, FRC!" → Status changes to "PASSED" → YOU WIN!
 *
 * Important Notes:
 *   - DO NOT edit Robot.java. It’s the engine that runs your levels.
 *   - This level uses Mode.ONCE – it runs once after load.
 *   - SmartDashboard.putString() sends data to the Driver Station.
 *   - System.out.println() prints to the console (Simulator or RioLog).
 *   - reset() clears state when "ResetLevel" is pressed.
 *
 * What You're Learning:
 *   - Compile code using WPILib's build system.
 *   - Deploy code to the RoboRIO or run in simulation.
 *   - SmartDashboard: Visualize data from robot.
 *
 * Success Condition: "Greeting" shows "Hello, FRC!" and Status says "PASSED".
 */
public class Level1 extends LevelBase {
    private boolean hasRun = false;

    
    public void run() {
        // Print to RoboRIO console (visible in VS Code terminal)
        System.out.println("Level 1: Code deployed successfully!");
        
        // Send text to SmartDashboard
        SmartDashboard.putString("Greeting", "Hello, FRC!");
        
        // Mark level as complete
        hasRun = true;
    }
    
    // Don't change this

    public Mode getMode() { return Mode.ONCE; }
    public void reset() {
        hasRun = false;
        SmartDashboard.putString("Greeting", "Waiting...");
    }

    public boolean checkSuccess() {
        return hasRun;
    }
}