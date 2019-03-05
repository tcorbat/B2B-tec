# Week 5 Exercise Solution

## SOLID Principles

### Case 1: Brids
In this case the liskov substitution principle is violated. Even though the interface `Bird` offers the `fly` method, a penguin usually cannot fly. Thus you cannot use `Penguin`s as `Bird`s unconditionally.

### Case 2: Means of Transport
This case violates the open-closed principle. Adding new means of transport requires an extension of the `MeansOfTransport` enum on one side, but on the other it requires code modifications in the `Trip` class, i.e. adding a new case for the added means of transport.

### Case 3: Signal Emitter
The `SignalEmitterInterface` specifies the whole interface of the `SignalEmitter`. We have two areas a client can be interested in: First, controlling the emitter through the methods `start`, `stop` and `setInterval`. Second, registering callbacks through `subscribeForSignal` and `unsubscribeFromSignal`. While both sets of functions belong to a `SignalEmitter` the interface could be split into two interfaces. Therefore, this case violates the interface segregation principle.

### Case 4: Employee
The `Employee` class violates the single responsibility principle. It tries to fulfill multiple tasks and satisfy multiple clients at once. This bears the danger of having a change for one client inadvertedly affect another client.

### Case 5: Counter
Class diagram of the initial situation:


![Packages](images/Ex5.1%20Case%20DIP%20Violation.png)

The problem domain has dependencies to the user interface and the storage layers. Ideally, the dependencies should go in the opposite direction. Lower level components should depend on higher level components. I.e. the stable core, the business logic, is unlikely to be replaced, while a user interface or a storage component should be easily replaceable. Therefore, those components should depend on the problem domain and not the other way around.


### Violations Resolved
Examples for resolving the violations of the SOLID principles are available as an Eclipse project [here](week%205%20Solid%20Violation%20Solution).


## B2B-tec Architecture (Optional)

### Layer Dependencies

We cyclic dependencies between the *Business Layer* and the *Storage Layer*. This couples both tightly together and makes exchanging components in the *Storage Layer* difficult.

![Packages](images/Ex5.2.1%20Package%20Diagram%20Solution.png)


### Singleton Assasination

The only remaining dependency from the *Business Layer* to the *Storage Layer* comes through the `DataStore` interface that is used by the `UserManagementService`.

![Packages](images/Ex5.2.2%20Package%20Diagram%20Solution.png)


### Resolving Layer Dependencies

Now all dependencies are inward regarding the `Business Layer`. Therefore, it does not depend on any other component. It is the core of our hexagon.

![Packages](images/Ex5.2.3%20Package%20Diagram%20Solution.png)


### Broken Interface

1. Throwing an `UnsupportedOperationException` instead of properly implementing the interface is a violation of the Liskov Substitution Principle. While in principle we could just provide the operations to support the storing operations, the JSON store is only intended to load a predefined dataset. We could use it in tests for example.

2. Applying the interface segregation principle allows the separation of the *load* and *store* operations in their own interfaces:

```java
public interface DataLoader {
	Collection<Customer> loadCustomers();
}
```

```java
public interface DataSaver {
	void writeCredentials(Credentials credentials);
	void writeCustomer(Customer customer);
}
```

While the `Database` class can support both features, it is sufficient when the `JSONStore` only supports the `DataLoader` interface. 

*Note:* Subsequently, the `UserManagementService` could feature a constructor that takes both a `DataLoader` and a `DataSaver` to work with.
