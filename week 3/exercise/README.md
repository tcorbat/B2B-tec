# Week 3 Exercise - Object-Oriented Design

## Overview

* On to Patterns

## Observer Pattern
* Download the template for Week 3 from github according the [Practices document on Moodle](https://moodle.hsr.ch/pluginfile.php/98118/mod_folder/content/0/Practices_1.0.pdf?forcedownload=1).
* Open the project for Week 3.
* Execute the application and login with the following credentials. user: al, pass: flanel
* You will find multiple TODOs in
	* ch.b2btec.bl.domain.ShoppingCart.java
	* ch.b2btec.ui.models.ShoppingCartModel.java
	* ch.b2btec.ui.models.OrderPositionTableModel.java
* Currently, the UI does not update when the user adds products to the basket. To solve this issue, follow the steps:
	1. Identify the responsibilites of the involved classes:
	Which classes represents the Observer, which class has the responsibility of a Subject?
	Caution: The package names are missleading; UI controllers are called 'Model' in Swing.
	2. Draw a sequence diagram in UML syntax with both phases (setup / notifcation), e.g.:
	```
	ShoppingCartModel --register(this)--> ShoppingCart
	...
	```
	The dynamics of the is desribed in *Observer Pattern - Dynamics* slides. 
	3. Create classes according the Observer Pattern definition (see *Observer Pattern - Structure* slides). Create interfaces for Subject, Observer and derive the concretes (ShoppingCartModel, ShoppingCart) from the corresponding interfaces.
	4. Implement the concrete Subject. It stores a list of Observers which can be attached by a public ```attach()``` method. Additionally, the Subject needs a mechanism to ```update()``` all observers, place this feature into an ```notify()``` method. 
	5. During the setup phase, all observers need to register themself to the Subject.
	6. Subjects needs to capture external events and invoke the ```notify()``` method.
* After implementing the Observer Pattern from scratch, let's replace the self-made classes with the java.beans implementation.
	1. Have a look at the *Observer Pattern in Java* slide.
	2. Replace your own Observer Pattern implementation with the facilities given by the java.beans API.
	3. There are existing facilities within the b2btec shop which simplifies the usage of java.beans implementation. The features are located in the ch.b2btec.utils.PropertyObservable class.


## MVC Pattern
* Analyze the structure of the follwing classes:
	* ch.b2btec.bl.domain.ShoppingCart.java
	* ch.b2btec.ui.models.ShoppingCartModel.java
	* ch.b2btec.ui.models.ShoppingCartSummaryPanel.java
* Which classes represents the Model, View and Controller responsibility according the M-V-C Pattern?


## General Questions
* The ```UserManagementService``` contains the following code snippet:
```
var loginName = newCustomer.getProfile().getCredentials().getLoginName();
```
Which Pattern could be used, to reduce the method chain? How would you apply this Pattern?


## Solution

* See [solution folder](../solution)
