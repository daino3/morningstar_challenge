### MorningStar challenge
Author: Dain Hall

Note from author: Implemenation done in both ruby and java. Ruby version was to
get logic and structure to be translated into Java-based version (first time
with Java).

### To Run Java Version:

Run RunnerTest file in Eclipse or Intellij.

### Java Solution Overview:

Customer, Register and Store classes are the main objects. Store is instantiated
with ArrayLists of registers and customers. Store#main calculates the run time
of servicing all customers.

CustomerSorter, Parser and Runner are leveraged for their specific tasks -
sorting customers, parsing the text files and running the application,
respectively.

### To Run Ruby Version:

From the command line run, change into the ruby_version directory and run:
```
ruby run.rb
```

### Ruby Solution Overview:

The Ruby code was hurried to simply get the objects and logic down so that I
could convert the code into Java. The solution has 4 classes: Customer,
Register, Store and Parser. The Ruby code is definitely more elegant A) because
I'm more familiar with Ruby and B) because enumerable methods take a lot of the
complication of this exercise. THERE IS NO TESTING FOR THIS VERSION HOWEVER._
