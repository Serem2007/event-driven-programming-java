
# Event-Driven System Design

## System Name: Library Management System

---

## Part 1: Event Sources

1. Borrow Button - Generates an event when a user borrows a book.
2. Return Button - Generates an event when a user returns a book.
3. Search Field - Generates an event when a user searches for a book.
4. Login Button - Generates an event when a librarian logs into the system.
5. Refresh Button - Generates an event when the book list is refreshed.

---

## Part 2: Events

| Event Name | Source | Description |
|---|---|---|
| Book Borrowed | Borrow Button | Triggered when a user borrows an available book. |
| Book Returned | Return Button | Triggered when a user returns a borrowed book. |
| Book Searched | Search Field | Triggered when a user searches for a book title. |
| User Logged In | Login Button | Triggered when a librarian logs into the system. |
| Book List Refreshed | Refresh Button | Triggered when the book list is refreshed. |

---

## Part 3: Event Handlers

| Event | Handler Action |
|---|---|
| Book Borrowed | Marks the selected book as borrowed and updates its availability. |
| Book Returned | Marks the selected book as available again. |
| Book Searched | Displays books matching the search term. |
| User Logged In | Verifies the librarian's login details and displays the system. |
| Book List Refreshed | Reloads and displays the current list of books. |

---

## Part 4: Event Flow Diagram

```text
User Action
    |
    v
Event Source (Button or Search Field)
    |
    v
Event Generated
    |
    v
Event Queue
    |
    v
Event Dispatch Thread (EDT)
    |
    v
Event Handler
    |
    v
Update Library Information
    |
    v
Display Updated Information
```

---

## Part 5: Potential Issues

1. **Borrowing an unavailable book**
   - Prevention: Check book availability before allowing borrowing.

2. **Incorrect book information**
   - Prevention: Validate book details before saving or updating records.

3. **System freezing during operations**
   - Prevention: Run long operations in background threads and update the GUI safely using SwingUtilities.invokeLater().
