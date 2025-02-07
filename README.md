DynamicProgramming_Algorithms
This repository contains three Java programs that implement dynamic programming solutions for different algorithmic problems. Each program demonstrates efficient problem-solving techniques using memoization and tabulation to optimize performance.

Files Overview
1. Question1.java
Purpose: Calculates Catalan numbers using dynamic programming with memoization.

Functionality: 
Implements a recursive solution with memoization to compute Catalan numbers.

Reads input numbers from a CSV file and outputs the corresponding Catalan numbers.

Handles file not found exceptions.

Key Features:
Uses a memoization array to store previously computed results.

Processes up to 10 numbers from the input file.

2. Question2.java
Purpose: Computes the number of ways to make change for a given amount using specified coin denominations.

Functionality:
Uses dynamic programming to calculate combinations of coins that sum to a target amount.

Reads bill, tip, and received amounts from a CSV file.

Outputs the number of ways to make change for the calculated amount.

Key Features:
Supports coin denominations: 1, 2, 5, 10, 20, 50, 100, 200.

Handles file not found exceptions.

3. Question3.java
Purpose: Implements a quiz game that calculates edit distances between user answers and correct answers.

Functionality:
Uses dynamic programming to compute the Levenshtein edit distance between strings.

Runs a 10-round quiz across various categories (e.g., Animal, Football).

Allows up to three attempts per question and tracks the score based on edit distances.

Writes the final score to a user-specific text file.

Key Features:
Categories include Animals, Football, Clothing Brands, etc.

Handles file creation and writing exceptions.

Software Engineering Practices
Dynamic Programming: All three programs use dynamic programming to optimize solutions by breaking problems into subproblems and storing results.

Error Handling: Each program includes try-catch blocks to handle file-related exceptions.

Modularity: Code is organized into classes and methods for better readability and maintainability.

File I/O: Programs demonstrate reading from CSV files and writing to text files.

Requirements
Java Development Kit (JDK) installed.

CSV files (catalan.csv, juice.csv) placed in the specified directory paths (modify paths as needed).

Write permissions for creating text files (for Question3).

