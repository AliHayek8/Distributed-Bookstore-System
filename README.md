📚 Distributed Bookstore System

This project implements a distributed bookstore application using Java RMI (Remote Method Invocation). The system consists of multiple servers and a single client. Each server is responsible for a specific service in the bookstore, including:
	•	Bookstore Server — managing available books and purchase requests
	•	Inventory Server — managing stock levels for each book
	•	Payment Server — processing payments and validating balances
	•	Client — user interface to interact with all servers

The project simulates a complete bookstore workflow:
	1.	A user requests a book
	2.	The system checks inventory
	3.	The system processes payment
	4.	The system approves or rejects the purchase

⸻

📁 Project Structure

/
│
├── BookstoreServer.java
├── InventoryServer.java
├── PaymentServer.java
├── Client.java
│
├── BookstoreInterface.java
├── InventoryInterface.java
├── PaymentInterface.java
│
├── inventory.txt
└── payments.txt


⸻

   Components Overview

1. Bookstore Server

Responsible for handling:
	•	Book ordering requests
	•	Communicating with Inventory Server
	•	Communicating with Payment Server
	•	Returning final status to Client

2. Inventory Server

Manages:
	•	Stock quantity
	•	Updating stock when a book is sold
	•	Reading initial inventory from inventory.txt

3. Payment Server

Responsible for:
	•	Storing user balances
	•	Deducting payments
	•	Reading balances from payments.txt

4. Client

The main program the user interacts with. It can:
	•	Request book purchases
	•	Communicate with the Bookstore Server only
	•	Display results (approved / rejected)

⸻

  How to Run the Project

You must run three servers first, then the client.

Step 1: Start the RMI Registry

rmiregistry 1099 &

Step 2: Start Inventory Server

java InventoryServer

Step 3: Start Payment Server

java PaymentServer

Step 4: Start Bookstore Server

java BookstoreServer

Step 5: Run Client

java Client


⸻

  Example Interaction

Client Input:

Enter book name: CleanCode
Enter username: ali

Output:

Book is available.
Stock updated.
Payment approved.
Purchase successful!


⸻

  Data Files Description

inventory.txt

Stores book quantities:

CleanCode 5
Algorithms 2
AI 10

payments.txt

Stores user balances:

ali 200
sara 150
ahmed 75


⸻

  System Architecture

+----------+         +------------------+
|  Client  | <-----> | Bookstore Server |
+----------+         +------------------+
                            |   
           --------------------------------------
           |                                    |
+------------------+                 +------------------+
| Inventory Server |                 |  Payment Server  |
+------------------+                 +------------------+


⸻

  Features
	•	Multi-server distributed architecture
	•	Persistent data through text files
	•	Clear modular design using Java RMI interfaces
	•	Full purchase workflow simulation

⸻

  Technologies Used
	•	Java RMI
	•	Java Sockets (internally by RMI)
	•	Multithreading (in servers)
	•	File I/O

⸻

  Author

Ali Hayek

⸻

  License

This project is for educational purposes.
