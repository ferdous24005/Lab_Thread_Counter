# 🧵 Static vs Non-Static Counter in Java

### Comparison of Thread Counting Using Static and Non-Static Variables

![Java](https://img.shields.io/badge/Java-Multithreading-orange?logo=openjdk)
![Course](https://img.shields.io/badge/Course-SEPM-blue)
![Problem ID](https://img.shields.io/badge/Problem%20ID-SEPM--001-green)

---

## 📋 Table of Contents

1. [Lab Information](#1-lab-information)
2. [Objectives](#2-objectives)
3. [Project Description](#3-project-description)
4. [Theoretical Background](#4-theoretical-background)
5. [Requirements](#5-requirements)
6. [Project Structure](#6-project-structure)
7. [How to Compile and Run](#7-how-to-compile-and-run)
8. [Test Cases](#8-test-cases)
9. [Result Analysis](#9-result-analysis)
10. [Analysis Questions and Answers](#10-analysis-questions-and-answers)
11. [Conclusion](#11-conclusion)

---

## 1. Lab Information

| Item                 | Details                                                             |
| -------------------- | ------------------------------------------------------------------- |
| Student Name         | Ferdous Bin Hafiz                                                   |
| Student ID           | IT-24005                                                            |
| Department           | Information and Communication Technology (ICT)                      |
| University           | Mawlana Bhashani Science and Technology University (MBSTU), Tangail |
| Course               | Software Engineering and Project Management (SEPM)                  |
| Problem ID           | SEPM-001                                                            |
| Experiment Title     | Comparison of Thread Counting Using Static and Non-Static Variables |
| Programming Language | Java                                                                |
| Source File          | `Ferdous_Thread.java`                                               |

## 2. Objectives

* Understand the differences between static and non-static variables in Java.
* Implement multithreading using the `Thread` class.
* Compare a thread-safe static counter with an unsynchronized static counter.
* Understand race conditions and lost updates.
* Calculate the absolute and percentage differences between counter totals.
* Investigate how the number of threads affects counting accuracy.

## 3. Project Description

This project demonstrates how multiple Java threads access and update shared data.

It compares two static counters:

* **Thread-safe counter:** Uses `AtomicLong` to perform atomic increment operations.
* **Non-thread-safe counter:** Uses a regular `long` variable without synchronization.

Each thread also maintains an independent counter. After all threads finish, the program calculates the total of the independent counters and compares it with the selected static counter.

The experiment demonstrates the importance of thread safety when multiple threads modify shared variables.

## 4. Theoretical Background

### 4.1 Static Variable

A static variable belongs to a class rather than an individual object. All instances of the class share the same static variable.

### 4.2 Non-Static Variable

A non-static variable belongs to an individual object. Each object maintains its own copy of the variable.

### 4.3 Multithreading

Multithreading allows multiple threads to execute concurrently within a process. It can improve responsiveness and resource utilization.

### 4.4 AtomicLong

`AtomicLong` is a Java class that supports atomic operations on a `long` value. Its `incrementAndGet()` method safely increments a shared counter.

### 4.5 Race Condition

A race condition occurs when multiple threads access and modify shared data without appropriate synchronization. An expression such as `counter++` is not an atomic operation, so concurrent updates may be lost.

### 4.6 Thread Join

The `join()` method makes the main thread wait until a worker thread completes its execution. This ensures that the final results are calculated after all workers finish.

## 5. Requirements

* Java Development Kit (JDK)
* Command Prompt or terminal
* A Java IDE, such as IntelliJ IDEA, Eclipse, or VS Code (optional)
* Git and GitHub for source-code management

## 6. Project Structure

```text
SEPM-001/
├── Ferdous_Thread.java
├── inputs/
├── outputs/
├── handwritten_code/
└── README.md
```

**Directory descriptions:**

* `Ferdous_Thread.java` — Main Java source code.
* `inputs/` — Test commands used in the experiment.
* `outputs/` — Screenshots of actual program executions.
* `handwritten_code/` — Handwritten code photographs or scans.
* `README.md` — Project documentation.

The supporting folders are optional and should be created if needed.

## 7. How to Compile and Run

### Step 1: Check Java Installation

Open a terminal and execute:

```bash
java -version
javac -version
```

### Step 2: Compile the Program

Navigate to the directory containing `Ferdous_Thread.java` and run:

```bash
javac Ferdous_Thread.java
```

### Step 3: Run the Thread-Safe Experiment

Use `true` to select the `AtomicLong` counter:

```bash
java Ferdous_Thread 10 50000 true
```

### Step 4: Run the Non-Thread-Safe Experiment

Use `false` to select the ordinary static `long` counter:

```bash
java Ferdous_Thread 10 50000 false
```

### Command Format

```bash
java Ferdous_Thread <threads> <increments> <true|false>
```

| Argument     | Description                              |
| ------------ | ---------------------------------------- |
| `threads`    | Number of worker threads                 |
| `increments` | Number of increments per thread          |
| `true`       | Use the thread-safe `AtomicLong` counter |
| `false`      | Use the unsynchronized static counter    |

### Additional Examples

```bash
java Ferdous_Thread 1 1000 true
java Ferdous_Thread 2 10000 false
java Ferdous_Thread 5 10000 true
java Ferdous_Thread 20 50000 false
java Ferdous_Thread 100 50000 true
```

## 8. Test Cases

The following test cases can be used to evaluate the program.

| Test Case | Threads | Increments per Thread | Expected Count |
| --------- | ------: | --------------------: | -------------: |
| TC1       |       1 |                 1,000 |          1,000 |
| TC2       |       2 |                10,000 |         20,000 |
| TC3       |       5 |                10,000 |         50,000 |
| TC4       |      10 |                50,000 |        500,000 |
| TC5       |      20 |                50,000 |      1,000,000 |
| TC6       |      50 |                50,000 |      2,500,000 |
| TC7       |     100 |                50,000 |      5,000,000 |

The expected count is calculated using:

$$
\text{Expected Count} =
\text{Number of Threads}
\times
\text{Increments per Thread}
$$

These are planned test cases; actual outputs should be recorded after running the program.

## 9. Result Analysis

### 9.1 Thread-Safe Experiment (`true`)

The shared `AtomicLong` counter should record every increment correctly.

Expected observations:

* Static count equals the expected count.
* Non-static total equals the expected count.
* Absolute difference is zero.
* Percentage difference is 0.00%.

### 9.2 Non-Thread-Safe Experiment (`false`)

The ordinary static counter may lose increments because multiple threads can update it concurrently.

Expected observations:

* The static count may be lower than the expected count.
* The non-static total should equal the expected count.
* The difference may vary between executions.
* The percentage difference depends on the execution conditions.

A race condition is possible, but the result is not guaranteed to be incorrect on every execution.

### 9.3 Calculation Formulas

**Absolute Difference**

$$
D = |S-L|
$$

**Percentage Difference**

$$
D\% = \frac{|S-L|}{L}\times100
$$

Where:

* \(S\) = selected static counter value
* \(L\) = total of the individual thread counters
* \(D\) = absolute difference

For example, if the static counter is 19,235 and the non-static total is 20,000:

$$
D=|19235-20000|=765
$$

$$
D\%=\frac{765}{20000}\times100=3.83\%
$$

This is an illustrative calculation, not a verified output from the current source code.

## 10. Analysis Questions and Answers

**Q1. What is a static variable in Java?**

A static variable belongs to the class and is shared among all instances of that class.

**Q2. What is a non-static variable?**

A non-static variable belongs to an individual object, and each object has its own copy.

**Q3. What is multithreading?**

Multithreading is the concurrent execution of multiple threads within a process.

**Q4. What is a race condition?**

A race condition occurs when concurrent threads access shared data and the result depends on the timing of their operations.

**Q5. Why can an ordinary counter lose increments?**

The `counter++` operation is not atomic. Concurrent updates may overwrite each other, resulting in lost increments.

**Q6. How does `AtomicLong` help?**

It provides atomic operations that safely update a shared numeric counter.

**Q7. Why is `join()` used?**

It makes the main thread wait until the worker threads have completed their tasks.

**Q8. Does increasing the number of threads always increase the error?**

No. The error depends on scheduling, hardware, runtime conditions, and the degree of overlap between threads.

**Q9. How can a shared counter be made thread-safe?**

A shared counter can use `AtomicLong` or appropriate synchronization.

## 11. Conclusion

This project demonstrates the differences between static and non-static variables in Java and examines the effects of concurrent access to shared data.

The thread-safe counter uses `AtomicLong` to preserve increments, whereas the unsynchronized counter may lose updates because of race conditions. The experiment highlights the importance of thread-safe programming, correct synchronization, and testing under different execution conditions.

Actual outputs and screenshots should be added to document the results obtained on the execution environment.

---

## Author

**Ferdous Bin Hafiz**
Student ID: IT-24005
Department of Information and Communication Technology (ICT)
Mawlana Bhashani Science and Technology University (MBSTU)

## Repository

[Lab_Thread_Counter — SEPM-001](https://github.com/ferdous24005/Lab_Thread_Counter/tree/main/SEPM-001)
