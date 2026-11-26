# Limitations of java.util.Observer and java.util.Observable

## 1. Single Inheritance
Observable is a class, not an interface. A class that extends Observable cannot extend another class because Java supports only one direct superclass. This restricts reuse and class design.

## 2. Cannot Change the Notification Order
The API does not guarantee the order in which observers are notified. A programmer cannot reliably control which observer receives the update first.

## 3. setChanged() is Confusing
setChanged() marks the Observable as changed. notifyObservers() only sends notifications when this flag has been set. Forgetting it means observers are silently not notified, making bugs difficult to find.

## 4. Pull Model by Default
The Observable notifies observers without passing the changed data. Each observer must query the Observable through getter methods. This creates extra calls and more dependence on the subject's API. In a push model, the subject passes the new data directly.

## 5. Deprecated Since Java 9
The classes were deprecated because of design limitations: Observable is a class, notification order is unspecified, setChanged() is easy to forget, the API is limited and not sufficiently flexible for modern event systems. A custom Observer interface or suitable modern event mechanism gives better control.

## Self-check
1. Extending Observable uses the class's one available superclass slot, so the class cannot extend another class.
2. Push sends the changed data to observers; pull tells observers that something changed and they retrieve the data from the subject.
3. Java deprecated the API because of its inflexible inheritance design, unclear change flag, unspecified notification order and limited extensibility.
