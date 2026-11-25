
# Bug Fix Documentation

## Bug 1: Blocking the EDT

- **Symptom:** The user interface freezes when the Process button is clicked.
- **Cause:** The long operation was running on the Event Dispatch Thread (EDT).
- **Fix:** Ran the long operation in a background thread and updated the GUI on the EDT.
- **Code Change:** Used `new Thread()` to perform the five-second operation and `SwingUtilities.invokeLater()` to update the status label and re-enable the button.

## Bug 2: Missing Listener

- **Symptom:** Clicking the Increment button does nothing.
- **Cause:** No ActionListener was registered to handle button clicks.
- **Fix:** Added an ActionListener to the Increment button.
- **Code Change:** Used `incrementButton.addActionListener()` to increase the count and update the label whenever the button is clicked.

## Bug 3: Wrong Thread

- **Symptom:** The clock updates from a background thread, which can cause unpredictable GUI behaviour.
- **Cause:** The GUI label was updated directly from a background thread.
- **Fix:** Used SwingUtilities.invokeLater() for GUI updates.
- **Code Change:** Wrapped the timeLabel.setText() statement inside `SwingUtilities.invokeLater()` so that the label is updated safely on the EDT.

## Bug 4: Memory Leak

- **Symptom:** Removed buttons remain referenced in memory.
- **Cause:** The createdButtons list retained references to buttons even after they were removed from the interface.
- **Fix:** Cleared the list when removing all buttons.
- **Code Change:** Added `createdButtons.clear()` inside the Remove All button's ActionListener to release the references.
