# 🛠️ Lexicon Converter App

A robust, console-based Java application built to handle everyday conversions quickly and accurately. This project was developed as part of the Lexicon Java Programming Workshop, moving beyond basic functionality to implement defensive programming and session tracking.

## ✨ Features

* **3-in-1 Conversion Engine:**
    * 💵 **Currency:** Convert SEK to USD and EUR.
    * 🌡️ **Temperature:** Convert between Celsius and Fahrenheit.
    * 📏 **Length:** Convert Centimeters to Meters, and Meters to Kilometers.
* **Bulletproof Input Validation:** Implements strict `try-catch` blocks and logical boundary checks (e.g., preventing negative lengths and temperatures below Absolute Zero) to ensure the application never crashes.
* **Session History Tracking:** Uses an `ArrayList` to silently track all successful conversions during a session, printing a clean, formatted receipt when the user exits.
* **Dynamic Timestamps:** Leverages `LocalDateTime` to stamp every conversion with the exact date, time, and user timezone.

## 🚀 How to Run

1. Clone this repository to your local machine.
2. Open the project in your preferred Java IDE (IntelliJ IDEA, Eclipse, VS Code).
3. Run the `main` method located in `src/main/java/se/lexicon/ConverterApp.java`.
4. Follow the on-screen console prompts to start converting!

## 💻 Technical Highlights

* **Language:** Java
* **Concepts Applied:** * Defensive Programming & Exception Handling (`InputMismatchException`)
    * Data Structures (`ArrayList`)
    * String Formatting (`String.format`, `System.out.printf`)
    * Time & Date API (`LocalDateTime`, `DateTimeFormatter`, `ZoneId`)
    * DRY Code Principles (Reusable Helper Methods)

---
*Developed by Baraa Jamos*