### **Overview**

- **Project:** Offline 1vs1 Chess Game
- **Platform:** Java (Eclipse IDE)
- **Initial Thought:** Simple to build, but became more complex due to the intricacies of chess piece logic and movement conditions.

---

### **Challenges Encountered**

1. **Piece Movement & Logic:**
    
    - Complex rules for how pieces move: Knights jump, bishops move diagonally, etc.
    - Needed to implement checks for valid moves, piece interactions, and special moves like castling and en passant.
2. **Board Representation:**
    
    - Creating an 8x8 grid in code and updating it based on each move was harder than expected.
    - Managing the board state dynamically as pieces are moved or captured.
3. **Game State:**
    
    - Ensuring accurate tracking of turns, check/checkmate conditions, and updating the game status after each move.
    - Implementing game-ending conditions and stalemate detection.
4. **User Interface:**
    
    - Designing a simple yet functional interface for an offline, 1vs1 experience.
    - Updating the UI dynamically after each move, ensuring user interaction is smooth and intuitive.

---

### **Technologies Used**

- **Programming Language:** Java
- **IDE:** Eclipse
- **Libraries/Frameworks:** None

---

### **Achievements**

- Developed a fully functional chessboard with correct piece movement.
- Successfully tracked turns and implemented check/checkmate functionality.
- Created an offline 1vs1 mode allowing players to compete against each other.

---

### **Future Improvements**

- **Implementing engines**
- **Implementing Draws of insufficient materials** 
- **Move History & Undo:** Implementing a feature to track and undo previous moves.

---

### **Reflection**

Building this chess application was more difficult than anticipated. What initially seemed like a straightforward project turned into a deep dive into game logic, problem-solving, and Java programming. Despite the challenges, the final product functions as intended, and it has provided valuable experience for future game development projects.

---

### **Images**:

For visual insights and additional documentation on the project's development, you can refer to the following images:

1. [[WhiteTurn.png]]
2. [[BlackTurn.png]]
3. [[Check.png]]
4. [[Promotion.png]]
5. [[Stalemate.png]]
6. [[Checkmate.png]]