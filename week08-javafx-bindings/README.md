# Week 8 – Properties and Bindings in JavaFX

This project follows the Week 8 Self-Paced Guide and Achievement Summary.

## Requirements
- JDK 21
- Maven
- Internet access on the first run to download dependencies

## Run
Open PowerShell in this folder and run:

```powershell
mvn clean javafx:run
```

The default app is `ReactiveFormApp` (Activity 5). To run another activity, change
`<mainClass>` in `pom.xml` to one of these classes, then run the same Maven command:

- `com.example.ListenerDemo` – Activity 2 (console output)
- `com.example.UnidirectionalDemo` – Activity 3
- `com.example.BidirectionalDemo` – Activity 4
- `com.example.ReactiveFormApp` – Activity 5

Activity 1 is the `Person` observable model, used by the listener demo.
