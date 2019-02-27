# Week 5 Exercise

In this week's exercicses you will:
* Assasinate an instance of the singleton pattern
* Locate and resolve cyclical dependencies among layers
* Judge and resolve a component by the SOLID principles

## Layer Dependencies

For this exercise we have extended the *B2B-tec* application by an H2 database. This database replaces the hardcoded JSON file for storing customer data. Subsequently, a password change in the *Profile* tab lasts through restarts of the program. With the previous JSON implementation that would require a dump of all user data, even for small modifications like a changed password, the approach featuring a data base is much more flexible. Unfortunately, the programming implementing the `Database` class was careless regarding cyclic dependencies among layers of the application.

### Your Task

Below you see a diagram of few essential classes, structured in packages and split into `Business` and `Storage` layers. The `Business Layer` contains the domain classes as well as the `UserManagementServer`, which provides the functionality to authenticate customers and change passwords. On the other hand the `Storage Layer` provides access to customer data and also is responsible for persisting their credentials. 

1. Draw the dependencies between the classes of the following diagram. You can determine the dependencies by looking at the code in the corresponding classes. When dawing the associations, also draw the direction to show which class known (depends on) which other class.

![Packages](images/Ex5.1%20Package%20Diagram%20Template.png)

2. Analyze the dependencies that exist between the `Business` and `Storage` layer. What is the problem with those dependencies?

## Singleton Assassination

In the lecture you have learned about the problems introduced through a singleton. Beside convenience for the initial implementer that `Database` singleton provides no benefit. Furthermore, there is no reason that a restriction to only a single database exists in our application.

### Your Task
1. In the previous task you should have seen that the `Database` class implements the `DataStore` interface. We could inject the dependency from `UserManagementService` to `DataStore` through its `load()` method by adding a `DataStore` parameter. The `DataStore` interface offers all functionality the `UserManagementService` needs and this would eliminate the direct dependency to `Database`. In this first step you can move the access of the `Database` singleton to the `ApplicationContext`, which instantiates all services.

2. Once the singleton is accessed in the `ApplicationContext` you can remove the singleton completely, by transforming the `Database` back into a *normal* class that features a constructor. In this way you could create multiple instances of the `Database`, but you can still limit the single instance used and provided through the `ApplicationContext`.

3. Update the dependencies in the package diagram:

![Packages](images/Ex5.2%20Package%20Diagram%20Template.png)

4. *Optional*: If you want you can wrap the creation of the `Database` into a `StoreProvider` class that offers the method `DataStore getDataStore(PersistencyKind)`. The `PersistencyKind` can be an `enum` with values for the possible storage mechanisms:

```java
public enum PersistencyKind {
	Database, Json
}
```

## Resolving Layer Dependencies
The mutual dependency between the layers that still exist could be resolved in two ways:
* Layers Pattern (1)
* Ports and Adapters Pattern (2)

1. Follow the `Layers` pattern by inverting the dependencies incured through the `Database` class using the domain model types `Customer` and `Credentials`. The consequence would be either to move all business domain classes to the storage layer. This would actually flip the dependency. However, the storage layer should not be defining our business model. That is not the responsibility of the `Storage` layer. 
Alternatively, we could offer record-like types representing the stored information in the database, which make sense to be defined the `Storage` layer, and let the `Business` layer depend on those. You can have a look at the inner class `CustomerTable.CustomerRecord` for an example of how such a record could look like. These records would be tightly coupled to the database scheme and this scheme would be exposed to the `Business` Layer's classes. This is a dependency on a detail we don't want in our software either.

2. Follow the `Ports and Adapters` pattern and move the `DataStorage` interface to the `Business Layer`. In this way we flip the only remaining dependency from the `Business` to the `Storage` layer and invert it.

### Your Task
1. Implement the latter solution for *B2B-tec* to resolve the cyclic dependency between *Business Layer* and *Storage Layer*. 

2. Update the dependencies in the package diagram:

![Packages](images/Ex5.3%20Package%20Diagram%20Template.png)


## Broken Interface

Have a look at the `JSONStore` class in the `ch.b2btec.store.json` package. This class is responsible for loading customer data from a *JSON* file. In order to act as a loader for customer data it implements the `DataStore` interface. This interface currently features the following methods:
* `Collection<Customer> loadCustomers();`
*	`void writeCredentials(Credentials credentials);`
*	`void writeCustomer(Customer customer);`

Our implementation of the JSON store can only dump and read a whole `UserManagementService` object at once. Subsequently, it would be really inefficient to provide the `writeCredentials` method, because it would need to write all customer data to fulfill a single password change request. To prevent storing data through the JSON persistency implementation, this part of the interface is not really implemented, but a runtime exception (`UnsupportedOperationException`) is thrown.

1. Which SOLID principle is violated by throwing by not implementing the whole `DataStore` interface?
2. How can we resolve this, if we don't want to offer the implementation of the `write*` methods?

