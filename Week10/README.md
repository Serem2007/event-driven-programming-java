# Week 10 – University Management System

A JavaFX + MySQL capstone demonstrating event-driven architecture, background database tasks,
scheduled work, FXML navigation and JavaFX property bindings.

## Learning outcomes covered
- **LO1:** Separate the FXML view, Java controller and MySQL data layer through `DatabaseUtil`.
- **LO2:** Use JavaFX `Task` for loading and saving students away from the UI thread.
- **LO3:** Use `ScheduledExecutorService` to print a system heartbeat every five seconds.
- **LO4:** Connect UI events, controller handlers, observable model properties and task completion events.

See `README-START-HERE.txt` for setup and run instructions. Run `database/setup.sql` in MySQL Workbench
before using the Students screen. Configure credentials using environment variables; never commit passwords.
