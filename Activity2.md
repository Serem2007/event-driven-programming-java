# Activity 2: Build the Event Loop – Physical Simulation

## Part 1: Event Cards

The following ten events were used in the simulation:

1. Button A Clicked
2. Button B Clicked
3. Text Field Updated: "Hello"
4. Timer Fired
5. Window Resized
6. Checkbox Selected
7. Menu Item Clicked
8. Key Pressed: 'A'
9. Mouse Moved
10. Button A Clicked

## Part 2: Round 1 – Simple Processing

Each event was moved from the Event Sources area to the Event Queue and then processed by the Event Loop.

| Event | Handler | Action |
|---|---|---|
| Button A Clicked | Button A ActionListener | Displays "Button A clicked" |
| Button B Clicked | Button B ActionListener | Displays "Button B clicked" |
| Text Field Updated | DocumentListener | Reads the updated text |
| Timer Fired | Timer ActionListener | Executes the timer task |
| Window Resized | ComponentListener | Adjusts the interface |
| Checkbox Selected | ItemListener | Updates the checkbox state |
| Menu Item Clicked | Menu ActionListener | Executes the selected menu command |
| Key Pressed: 'A' | KeyListener | Processes the pressed key |
| Mouse Moved | MouseMotionListener | Tracks mouse movement |
| Button A Clicked | Button A ActionListener | Displays "Button A clicked" |

## Part 3: Round 2 – Multiple Events at Once

Five event cards were placed in the Event Queue and processed one by one from left to right.

The event loop processed the first event before moving to the next event. Each event was handled by its appropriate listener and handler. This demonstrated how an application can manage several events in an organised sequence.

## Part 4: Round 3 – Simulating a Blocked Event Loop

Five event cards were placed in the Event Queue. The first event was given a slow handler that took extra time to complete.

While the first event was being processed, the other four events remained waiting in the queue. They could only be processed after the slow handler finished.

### Questions and Answers

**1. What happened to the other events while you were "stuck" on the slow handler?**

The other events remained waiting in the event queue because the event loop was busy processing the slow event. They could not be handled until the current operation was completed.

**2. What would a user see if this happened in a real application?**

The user would experience an application that becomes slow or unresponsive. Buttons might stop responding, the screen might freeze, and the user might think the application has crashed.

**3. How could this problem be fixed?**

The problem can be fixed by moving long-running operations to background threads so that the event loop remains available to process other events. In Java Swing, SwingWorker or a separate background thread can be used. GUI updates should then be performed safely on the Event Dispatch Thread (EDT).

## Part 5: Reflection

The event queue stores events that are waiting to be processed by an application. The event loop continuously checks the queue and sends events for processing by their appropriate handlers. Events are generally processed in the order they are received. The event loop should never be blocked because doing so prevents other events from being handled. When a slow operation blocks the event loop, the application may freeze or become unresponsive to the user. This problem can be prevented by performing long-running tasks in background threads. Keeping the event loop responsive ensures that an application remains interactive and user-friendly.

## Conclusion

This activity demonstrated how events move from event sources into an event queue before being processed by the event loop. It also showed the importance of avoiding slow operations on the event-handling thread to maintain application responsiveness.