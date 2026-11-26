# Week 2 Final Self-Assessment

1. **UML:** Subject interface is implemented by ConcreteSubject. ConcreteSubject stores state and a collection of Observer objects. Observer interface declares update(). ConcreteObserver implements Observer and reacts to updates.
2. **Subject interface:** `registerObserver(Observer o)`, `removeObserver(Observer o)`, and `notifyObservers()`.
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
3. The Subject needs a list so it can keep track of all registered observers and notify each one when its state changes.
4. Three problems: Observable is a class and restricts inheritance; notification order is unspecified; setChanged() is easy to forget and notifications then do not occur. Other issues include pull-only design and limited extensibility.
5. It was deprecated because the API has an inflexible class-based design and other design limitations that make it less suitable for modern event systems.
6. Pull means observers are notified that something changed and must call getters to retrieve the data. This adds calls and couples observers to the subject's API.
7. A custom Subject should provide methods to register/add observers, remove observers, and notify observers.
8. The Subject loops through its observer list and calls each observer's update method.
9. Call removeObserver() when an observer is no longer needed so the Subject does not retain it unnecessarily.
10. Custom Observer, java.util.Observer/Observable, PropertyChangeListener, and JavaFX Properties/Bindings.
11. JavaFX Properties and Bindings.
12. java.util.Observer and java.util.Observable.

       <<interface>>
          Subject
    + registerObserver()
    + removeObserver()
    + notifyObservers()
             |
             |
      ConcreteSubject
    - observers: List
    - state
             |
       notifies
             |
       <<interface>>
          Observer
       + update()
             |
       ConcreteObserver
       + update()
       # Final Reflection

The Observer Pattern is a behavioral design pattern that allows one object to notify multiple dependent objects whenever its state changes. It is important because it reduces tight coupling and makes software easier to maintain and extend. It relates to event-driven programming because objects can respond automatically to events without constantly checking for changes. In my own projects, I would choose the Custom Observer Pattern because it provides flexibility and allows me to control how notifications are handled. PropertyChangeListener is also useful when working with JavaBeans and Swing applications. Overall, the Observer Pattern helps create organized, reusable and maintainable applications.