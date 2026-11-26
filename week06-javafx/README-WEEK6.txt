WEEK 6 — INTRODUCTION TO MODERN JAVAFX (VS CODE EDITION)

Requirements:
- JDK 17 or newer
- Maven installed and available in PATH
- VS Code
- Gluon Scene Builder (for the visual FXML activity)

Run from this folder:
  mvn clean javafx:run
This launches Activity 1 (App).

To run another activity, change the <mainClass> value in pom.xml:
  com.example.LayoutDemo
  com.example.FXMLApp
  com.example.DashboardApp
Then run:
  mvn clean javafx:run

Activity 3:
Open src/main/resources/com/example/login.fxml in Scene Builder.
The FXML is already created and connected to com.example.LoginController.
The Login button is connected to handleLoginButtonAction.
Test credentials: admin / password123
Other credentials print Login Failed.

Activity 5:
Set mainClass to com.example.DashboardApp and run.

Threading:
JavaFX UI changes run on the JavaFX Application Thread. Do not perform long-running work on this thread.

Git:
Commit the entire week06-javafx folder. Do not commit target/ (already ignored).
