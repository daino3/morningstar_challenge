### MorningStar challenge

### Overview:
You are to write a program to implement a grocery store / cashier line simulation. This program should read input from a file, and print the resulting score to the console. (The program should be a console-only program.) The program should take a single command line parameter, the name of the input file.

Customers in a grocery store arrive at a set of registers to check out. Each register is run by a cashier who serves customers on a first-come, first-served basis. The goal of the problem is to determine when all customers are done checking out. 

One of the most important criteria for a successful solution is that it correctly implements the problem to be solved. This will be determined by both code inspection and acceptance testing using the 5 examples in this problem as well as additional test cases not provided as part of the problem. 

We will be considering your overall approach to the problem and your programming style. This assignment is an opportunity to show off your domain modeling, OO, tests and design skills to produce an elegant, readable and testable solution. Please do use what you would consider best practice in developing your solution.
### Problem Details:
Problem Details: 

1) The number of registers is specified by the problem inputs; registers are numbered 1, 2, 3, ..., n for n registers. 

2) Time is measured in minutes. 

3) The grocery store always has a single cashier in training. This cashier is always assigned to the highest numbered register. 

4) Regular registers take one minute to process each customer's item. The register staffed by the cashier in training takes two minutes for each item. So a customer with n items at a regular register takes n minutes to check out. However, if the customer ends up at the last register, it will take 2n minutes to check out. 

5) The simulation starts at t=0 . At that time all registers are empty (no customers in line). 

6) Two types of customers arrive at the registers:

a. Customer Type A always chooses the register with the shortest line (fewest number of customers in line).
b. Customer Type B looks at the last customer in each line, and always chooses to be behind the customer with the fewest number of items left to check out, regardless of how many other customers are in the line or how many items they have. Customer Type B will always choose an empty line before a line with any customers in it. 

7) Customers just finishing checking out do not count as being in line (for either kind of Customer). 

8) If two or more customers arrive at the same time, those with fewer items choose registers before those with more, and if they have the same number of items then type A's choose before type B's.


### Input Format: 

Input is in the form of a single integer (number of registers), followed by a list of pairs. Each pair specifies the time in minutes (from a fixed offset) when a customer arrives to the set of registers, and how many items that customer has. Each pair appears white-space separated on a line by itself in the input file; see below for a sample input and output.

### Example:

For the following input file: 

1 
A 1 2 
A 2 1 

The following highlights occur: 

• t=0 : Simulation starts with one register, which is a training register. 

• t=1 : Customer #1 (type A) arrives with 2 items and goes to register #1 which
starts servicing him. 

• t=2 : Customer #2 (type A) arrives with 1 item and goes to register #1, behind 
Customer #1. 

• t=3 : (Customer #1 now has one item left, since the first item took two
minutes). 

• t=5 : Customer #1 leaves and register #1 starts servicing Customer #2. 

• t=7 : Customer #2 leaves.
