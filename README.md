📌 Project Overview

This application allows two players to play Tic Tac Toe in the console. The game manages player turns, validates user input, checks for win/draw conditions after each move, and supports replay functionality.

The project is structured to emphasize maintainability, readability, and scalability.

🏗️ Architecture & Design

The game is organized into three main classes:

1️⃣ Game Class

Responsibilities:

Controls overall game flow

Manages player turns

Initializes the board

Checks game status after each move

Key Methods:

startGame() – Starts the game loop

playTurn() – Handles a single player turn

checkGameStatus() – Determines win or draw conditions

2️⃣ Board Class

Responsibilities:

Represents the 3×3 game board

Tracks cell states

Displays the board

Key Methods:

displayBoard() – Prints the board to the console

markCell(int row, int col, char player) – Marks a cell

isCellEmpty(int row, int col) – Validates cell availability

3️⃣ Player Class

Responsibilities:

Represents a player

Stores player symbol (X or O)

Handles player-specific actions

Key Methods:

getSymbol() – Returns player's symbol

🧠 Game Logic
✅ Win Condition

The game checks:

All rows

All columns

Both diagonals

If a player has three identical symbols in a line, they win.

🤝 Draw Condition

If all cells are filled and no player has won, the game declares a draw.

🔐 Input Validation

To maintain game integrity, the program:

Ensures input is numeric

Validates row and column range (1–3)

Prevents marking already occupied cells

Prompts the user again for invalid input

🔁 Game Loop Flow

Display the board

Prompt current player for a move

Validate and apply move

Check for win or draw

Switch player

Repeat until game ends

Option to restart or exit

🛠️ Technologies Used

Java

Object-Oriented Programming (OOP)

Console-based UI

🎯 Features

Two-player mode

Real-time win detection

Draw detection

Input validation

Replay option

Clean modular class design

📚 Learning Objectives

This project demonstrates:

Class design and responsibility separation

Game loop implementation

Conditional logic for win checking

Input validation handling

Clean and maintainable Java structure

🚀 How to Run

Clone the repository:

git clone <your-repo-url>


Compile the project:

javac Main.java


Run the game:

java Main

📌 Future Improvements

GUI implementation using Java Swing

Single-player mode (AI opponent)

Score tracking system

Enhanced UI styling

Unit testing
