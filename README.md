# Java Practical 4 - Term 2

## Overview
This repository contains three Java programs developed as part of **CSC212 2022 Practical 4 Term 2**. Each program implements different computational and algorithmic problems, including the **Catalan number sequence**, **coin change problem**, and **edit distance calculation for a word game**.

---

## Files Description
### 1. `Question1.java`
**Functionality:**
- Implements a recursive approach with memoization to compute **Catalan numbers**.
- Reads input from a CSV file (`catalan.csv`) containing integer values.
- Outputs the corresponding **Catalan number** for each input value.
- Uses a **top-down dynamic programming approach** to store previously computed results.

**How It Works:**
- Reads input from `catalan.csv`.
- Computes the **Catalan number** using the formula:
  \[ C(n) = \sum_{i=0}^{n-1} C(i) * C(n-i-1) \]
- Prints the result to the console.

**Error Handling:**
- Handles `FileNotFoundException` if the input file is missing.

---

### 2. `Question2.java`
**Functionality:**
- Implements a **dynamic programming approach** to solve the **coin change problem**.
- Reads bill amount, tip amount, and amount received from `juice.csv`.
- Computes the total amount required and determines the **number of ways to make change** using denominations `{1, 2, 5, 10, 20, 50, 100, 200}`.

**How It Works:**
- Reads input values from `juice.csv`.
- Uses a **bottom-up approach** to determine the number of ways to make change.
- Outputs the computed number of ways to give the required change.

**Error Handling:**
- Handles `FileNotFoundException` if the input file is missing.

---

### 3. `Question3.java`
**Functionality:**
- Implements a **word game** where the user guesses words from predefined categories.
- Uses **edit distance (Levenshtein distance)** to determine how close an incorrect answer is to the correct one.
- Stores the user's name and **final score** in a dynamically created `.txt` file.

**How It Works:**
- Prompts the user for their name (creates a file `username.txt`).
- Presents **10 rounds** of different categories (Animals, Football, Clothing Brands, etc.).
- Evaluates the user's guesses and calculates their **edit distance** from the correct answer.
- Saves the final score in `username.txt`.

**Error Handling:**
- Handles `IOException` for file operations.

---

## Setup and Execution
### Prerequisites
- Java Development Kit (JDK 8 or later)
- A Java-compatible IDE (e.g., IntelliJ IDEA, Eclipse, or VS Code)

### Compilation & Execution
1. Compile the Java files:
   ```sh
   javac Question1.java Question2.java Question3.java
   ```
2. Run the programs individually:
   ```sh
   java Question1
   ```
   ```sh
   java Question2
   ```
   ```sh
   java Question3
   ```

---
