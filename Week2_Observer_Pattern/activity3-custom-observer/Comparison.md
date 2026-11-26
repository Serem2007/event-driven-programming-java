# Tightly Coupled System vs Observer Pattern

| Aspect | Tightly Coupled | Observer Pattern |
|---|---|---|
| Adding a new display | Modify DataModel to call it directly | Implement DataObserver and register it |
| Testing DataModel in isolation | Difficult because it depends on display classes | Easier because it depends only on an interface |
| Removing a display | Modify DataModel | Simply do not register or remove that observer |

The refactored DataModel knows only the DataObserver interface. This reduces coupling and makes the system easier to extend and test.

## Coupling questions
1. Adding a third display requires modifying DataModel to call the new display directly.
2. Renaming or deleting LabelDisplay can break DataModel because it directly references that class.
3. Testing DataModel alone is difficult because its logic is tied to display classes.
