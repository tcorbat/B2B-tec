# Week 5 Exercise Solution


## Layer Dependencies

We cyclic dependencies between the *Business Layer* and the *Storage Layer*. This couples both tightly together and makes exchanging components in the *Storage Layer* difficult.

![Packages](images/Ex5.1%20Package%20Diagram%20Solution.png)


## Singleton Assasination

The only remaining dependency from the *Business Layer* to the *Storage Layer* comes through the `DataStore` interface that is used by the `UserManagementService`.

![Packages](images/Ex5.2%20Package%20Diagram%20Solution.png)


## Resolving Layer Dependencies

Now all dependencies are inward regarding the `Business Layer`. Therefore, it does not depend on any other component. It is the core of our hexagon.

![Packages](images/Ex5.3%20Package%20Diagram%20Solution.png)


## Broken Interface

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
