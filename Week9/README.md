# Week 9: Asynchronous Programming in JavaFX

Complete starter/solution project for the four Week 9 demonstrations, aligned with the supplied self-paced guide and achievement summary.

## Requirements
- JDK 21
- Apache Maven 3.9+ (or Maven installed through your IDE)
- Internet connection on first run (Maven downloads JavaFX dependencies)
- VS Code and Extension Pack for Java (optional)

## Open and run
Open this folder (the folder containing `pom.xml`) in VS Code. In its Terminal, run one demo at a time:

```bash
mvn javafx:run -Djavafx.mainClass=com.example.FreezeDemo
mvn javafx:run -Djavafx.mainClass=com.example.TaskDemo
mvn javafx:run -Djavafx.mainClass=com.example.ProgressDemo
mvn javafx:run -Djavafx.mainClass=com.example.ServiceDemo
```

If your Maven plugin does not accept the `-Djavafx.mainClass` override, change the `mainClass` value in `pom.xml` to the class for the activity you want and run `mvn javafx:run`.

## Activities
1. **FreezeDemo** — deliberately blocks the JavaFX UI thread for five seconds to demonstrate why blocking work causes an unresponsive UI.
2. **TaskDemo** — runs a one-off simulated task on a background thread and updates the UI after completion.
3. **ProgressDemo** — simulates a download, binding progress and status message to a `Task`.
4. **ServiceDemo** — demonstrates a reusable JavaFX `Service`, progress indicator, and cancellation.

## Self-check answers

**Activity 1: Why did the window freeze?**  
`Thread.sleep(5000)` runs inside the event handler on the JavaFX Application Thread. That thread cannot process input, repaint, or window events while blocked.

**Activity 2: What does Platform.runLater do?**  
It schedules a Runnable to be executed on the JavaFX Application Thread, allowing UI changes to be made safely from another thread. JavaFX Task event handlers/properties are also useful for safely presenting task state.

**Activity 3: Why use updateProgress and updateMessage?**  
They publish progress and status from the background Task for JavaFX to expose through properties, which can be bound to UI controls. Bound text must be unbound before setting it directly again.

**Activity 4: Task vs Service?**  
A Task represents a single background operation. A Service provides a reusable lifecycle for creating and running Tasks, and can be restarted. Cancellation should be checked in the background work, such as using `isCancelled()` inside a loop.

## GitHub
From the root of your existing coursework repository (after copying this folder into it):

```bash
git add .
git commit -m "Complete Week 9 JavaFX asynchronous programming"
git push origin main
```

Check that your repository's branch is `main`; if yours has another branch name, push to that branch instead.

## Note
The Freeze demo intentionally makes the UI unresponsive for five seconds. This is a demonstration of a bad practice, not a pattern to use in real applications.
