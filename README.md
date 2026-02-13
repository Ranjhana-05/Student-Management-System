# Student Management System (Core Java)

A menu-driven console application built using Core Java to manage student records efficiently.  
The application supports CRUD operations with proper validation and file-based data persistence.  
Developed as part of Core Java practice and application design learning.

---

## 🚀 Features

- Add new students with input validation
- View all student records
- Search students by ID
- Update existing student details
- Delete student records
- Data persistence using file handling (students.txt)
- Menu-driven console interface

---

## 🛠 Concepts Implemented

- Core Java
- Object-Oriented Programming (OOP)
- Encapsulation
- Collections Framework (ArrayList)
- File Handling (BufferedReader, BufferedWriter)
- Iterators
- Input Validation
- Layered Architecture (model, service, app)

---

## 📂 Project Structure

StudentManagement  
│  
├── app  
│   └── StudentApp.java  
├── model  
│   └── Student.java  
└── service  
    ├── StudentService.java  
    └── FileService.java  

---

## 💡 Key Highlights

- Separated business logic from UI logic
- Implemented validation at service layer
- Used Iterator to safely remove elements from list
- Persisted data across application restarts using file storage
