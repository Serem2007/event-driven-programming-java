# Week 7 – Event Handling in JavaFX

This Maven project implements the four activities in the Week 7 self-paced guide.

## Requirements
- JDK 21
- Maven 3.10.2 (or compatible)
- Internet connection for the first dependency download

## Run the demos
Open PowerShell in this folder and run one command at a time:

```powershell
mvn clean javafx:run
```

The default demo is `EventPropagationDemo`.

To run another activity, temporarily change `<mainClass>` in `pom.xml`:
- `com.example.MouseKeyDemo`
- `com.example.DragDropDemo`
- `com.example.CustomEventDemo`

Then run `mvn clean javafx:run` again.

## Activity notes
- Event filters run during capturing; handlers run during bubbling.
- Mouse and keyboard demo: click the window, then use arrow keys.
- Drag and drop: drag the orange label into the gray rectangle.
- Custom event: enter a username and click Login.
