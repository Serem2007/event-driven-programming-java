# Activity 1: Spot the Components

## Part 1: Real-World Event-Driven Systems

| System | Event Source | Event | Listener | Handler / Action |
|---|---|---|---|---|
| ATM Machine | Keypad | Button pressed | ATM software | Verifies the PIN |
| Microwave Oven | Door sensor | Door closed | Microwave controller | Allows heating |
| Traffic Light | Timer | Time interval expires | Traffic controller | Changes the traffic light |
| Video Game | Keyboard | Key pressed | Game engine | Moves the character |
| Elevator | Floor button | Button pressed | Elevator controller | Moves to the selected floor |
| Smartphone | Touchscreen | Screen tapped | Touch listener | Opens an application |
| Online Shopping | Add-to-cart button | Button clicked | Website listener | Adds a product to the cart |
| Security Alarm | Motion sensor | Movement detected | Alarm controller | Triggers the alarm |

## Part 2: Self-Check Questions

### 1. What is the difference between an event source and an event listener?

An event source is the component that generates an event, while an event listener detects and waits for that event so that the program can respond.

### 2. Can one event source have multiple listeners?

Yes. One event source can have multiple listeners, and each listener can respond to the same event in a different way.

### 3. Can one listener handle events from multiple sources?

Yes. One listener can be registered to handle events from multiple event sources, provided the program is designed to distinguish and process those events correctly.

## Conclusion

This activity helped me understand how event-driven programming is used in everyday systems. I learned that event sources generate events, listeners detect them, and event handlers perform the required actions.