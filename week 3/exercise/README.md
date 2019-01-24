# Week 3 Exercise - Object-Oriented Design

## Observer Pattern
* Download the template for Week 3 from github according the [Practices document on Moodle](https://moodle.hsr.ch/pluginfile.php/98118/mod_folder/content/0/Practices_1.0.pdf?forcedownload=1).
* Open the project for Week 3.
* Execute the application and login with the following credentials.
```
user: al
pass: flannel
```
* You will find multiple `TODO`s in
	* ```ch.b2btec.bl.domain.ShoppingCart.java```
	* ```ch.b2btec.ui.models.ShoppingCartModel.java```
	* ```ch.b2btec.ui.models.OrderPositionTableModel.java```
1. Currently, the UI (e.g. the shopping cart overview on top) does not update when the user adds products to the basket. To solve this issue, follow the steps:
	1. Identify the responsibilities of the involved classes:
		* Which class represents the Observer, which class has the responsibility of a Subject?
		> *Caution:* The package names are misleading; UI mediators are called 'Model' in Swing.
	2. Draw a sequence diagram in UML syntax with both phases (setup / notifcation), e.g.:
		* ```ShoppingCartModel --register(this)--> ShoppingCart```
		* The dynamics are desribed in the slide *Observer Pattern - Dynamics*. 
	3. Create classes according the Observer Pattern definition (see *Observer Pattern - Structure* slides). Create interfaces for Subject, Observer and derive the concretes (`ShoppingCartModel`, `ShoppingCart`) from the corresponding interfaces.
	4. Implement the concrete Subject. It stores a list of Observers which can be attached by a public ```attachObserver()``` method. Additionally, the Subject needs a mechanism to ```update()``` all observers, place this feature into a ```notifyObservers()``` method. 
	5. During the setup phase, all observers need to register themself to the Subject.
	6. Subjects needs to capture external events and invoke the ```notifyObservers()``` method.
2. After implementing the Observer pattern from scratch, let's replace the self-made classes with the `java.beans` implementation.
	1. Have a look at the *Observer Pattern in Java* slide.
	2. Replace your own Observer Pattern implementation with the facilities given by the `java.beans.PropertyChange*` API.
	3. There are existing facilities within the b2btec shop, which simplifies the usage of `java.beans` implementation. The features are located in the ```ch.b2btec.utils.PropertyObservable``` class.


## MVC Pattern
* Analyze the structure of the following classes:
	* ```ch.b2btec.bl.domain.ShoppingCart.java```
	* ```ch.b2btec.ui.models.ShoppingCartModel.java```
	* ```ch.b2btec.ui.models.ShoppingCartSummaryPanel.java```
* Which classes represents the Model, View and Controller responsibility according the M-V-C pattern?


## General Questions
* The ```UserManagementService``` contains the following code snippet:
```
var loginName = newCustomer.getProfile().getCredentials().getLoginName();
```
Which pattern could be used, to reduce the method chain? How would you apply this pattern?


## Solution

* See [solution folder](../solution)
