# Week 1 Self-Assessment

## Learning Outcome 1: Define Event-Driven Programming Components

### 1. What is an event? Give two examples.

An event is an action or occurrence detected by a computer program that causes the program to respond. Examples include clicking a button and pressing a keyboard key.

### 2. What is an event source? Give two examples.

An event source is the component that generates an event. Examples include a mouse button and a keyboard.

### 3. What is an event listener? Give two examples.

An event listener is a component that waits for and detects events from an event source. Examples include an ActionListener in Java Swing and a KeyListener that detects keyboard actions.

### 4. What is an event handler? Give two examples.

An event handler is a block of code that executes when a particular event occurs. Examples include code that opens a window when a button is clicked and code that updates a counter when a user presses a button.

### 5. Draw a diagram showing how these four components relate to each other.

```text
Event Source
     |
     v
Generates an Event
     |
     v
Event Listener
     |
     v
Event Handler
     |
     v
Program Responds
```

## Learning Outcome 2: Compare Programming Paradigms

### 6. How does procedural programming differ from event-driven programming?

Procedural programming follows a fixed sequence of instructions controlled by the program. Event-driven programming allows the flow of execution to be controlled by events such as button clicks, keyboard inputs or other user actions.

### 7. What is the main advantage of event-driven programming for GUIs?

Its main advantage is that it makes applications interactive and user-friendly. Users can perform different actions, and the application responds to each action without following one fixed sequence.

### 8. In which scenario would you choose procedural programming over event-driven programming?

I would choose procedural programming for tasks that require a clear sequence of instructions, such as calculating the average of numbers, performing mathematical operations or processing data in a fixed order.

## Learning Outcome 3: Understand Event Loops and Queues

### 9. What is the event loop? What does it do?

An event loop is a mechanism that continuously checks for events and processes them when they become available. It keeps an application responsive by allowing it to handle user actions and system events.

### 10. What is the event queue? How does it work?

An event queue is a temporary storage area where events wait to be processed. Events are generally handled in the order they are received, allowing the application to manage multiple events.

### 11. Why should the event loop never be blocked?

The event loop should never be blocked because the application may freeze or become unresponsive. Long-running tasks should be performed in background threads so that the user interface can continue responding.

### 12. What is the EDT in Java Swing?

The Event Dispatch Thread (EDT) is the thread responsible for handling GUI events and updating Swing components. GUI updates should be performed on the EDT to ensure that the interface behaves safely and correctly.

## Learning Outcome 4: Identify Real-World Event-Driven Systems

### 13. List five real-world event-driven systems.

1. Automated Teller Machines (ATMs).
2. Traffic light control systems.
3. Online shopping applications.
4. Smartphone applications.
5. Library management systems.

### 14. For one system, identify all four EDP components.

**Example: Library Management System**

- **Event Source:** Borrow Book button.
- **Event:** User clicks the Borrow Book button.
- **Event Listener:** ActionListener that detects the button click.
- **Event Handler:** Code that checks book availability, marks the book as borrowed and updates the displayed book list.

### 15. Why are most modern applications event-driven?

Most modern applications are event-driven because they need to respond to user interactions and system activities. This programming approach makes applications interactive, flexible and user-friendly. It is especially useful for graphical interfaces, websites, mobile applications and computer games.