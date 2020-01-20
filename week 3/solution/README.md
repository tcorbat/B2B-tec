# Week 3 Exercise Solution

## Object-Oriented Design

### Standalone Observer

![Class Diagram for Observer](week%203%20Standalone%20Observer%20Solution/Observer%20with%20Layers.png)

### B2B-tec

The source code provides a possible solution how the TODOs could be implemented according the exercises.
Please import the current folder as a new project into your eclipse environment.

## MVC Pattern
* Which classes represents the Model, View and Controller responsibility according the M-V-C pattern?
* Analyze the structure of the following classes:
	* Model: [```ch.b2btec.bl.domain.ShoppingCart.java```](./src/ch/b2btec/bl/domain/ShoppingCart.java)
	* Controller: [```ch.b2btec.ui.models.ShoppingCartModel.java```](./src/ch/b2btec/ui/models/ShoppingCartModel.java)
	* View: [```ch.b2btec.ui.ShoppingCartSummaryPanel.java```](./src/ch/b2btec/ui/ShoppingCartSummaryPanel.java)

## General Questions
Which pattern could be used, to reduce the method chain? How would you apply this pattern?
```
var loginName = newCustomer.getProfile().getCredentials().getLoginName();
```
* Proxy Pattern
* Façade Pattern
