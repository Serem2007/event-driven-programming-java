# Comparison of Event Notification Mechanisms in Java

| Feature | Custom Observer | java.util.Observer | PropertyChangeListener | JavaFX Bindings |
|---|---|---|---|---|
| Push or Pull? | Both possible | Pull | Push (carries old + new) | Push |
| Is it deprecated? | No | Yes (Java 9+) | No | No |
| Requires inheritance? | No (interface) | Yes (class) | No | No |
| Thread-safe? | Depends on implementation | No | Depends on setup/use | Depends on JavaFX usage |
| Auto-generates boilerplate? | No | No | Yes, via PropertyChangeSupport | Yes |
| Best for... | Custom systems | Legacy code | JavaBeans / Swing | JavaFX apps |
| Can have multiple listeners? | Yes | Yes | Yes | Yes |
| Can be typed to send data? | Yes | Object argument | PropertyChangeEvent values | Yes |
| Recommended today? | Yes | No | For JavaBeans/Swing cases | Yes for JavaFX |

## Which One Should You Use?
- For a plain Java project with custom needs: Custom Observer.
- For a JavaFX application: JavaFX Properties and Bindings.
- For legacy code using JavaBeans or Swing: PropertyChangeListener.
- Avoid java.util.Observer/Observable in new projects because they are deprecated.

## Self-check
1. PropertyChangeListener carries both the old and new property values in PropertyChangeEvent.
2. PropertyChangeListener uses PropertyChangeSupport to manage listeners.
3. Custom Observer and JavaFX Bindings are the two mechanisms recommended in the activity for modern Java.
4. java.util.Observer/Observable is deprecated and should be avoided in new code.
