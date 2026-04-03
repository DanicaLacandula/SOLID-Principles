# SOLID Order Management System

## 📋 Overview
This project demonstrates the implementation of **SOLID principles** in Object-Oriented Programming using Java. It showcases an order management system that is maintainable, extensible, and follows best practices in software design.

## 🎯 SOLID Principles Implemented

### 1. Single Responsibility Principle (SRP)
- Each class has exactly one reason to change
- `OrderProcessor` only processes orders
- `InvoiceService` only handles invoice generation
- `NotificationService` only manages notifications
- `SimpleOrder` and `CompleteOrder` represent domain models only

### 2. Open/Closed Principle (OCP)
- Classes are open for extension but closed for modification
- New notification types can be added by extending `INotificationSendable`
- New order types can be added by implementing required interfaces
- No need to modify existing code when adding features

### 3. Liskov Substitution Principle (LSP)
- Subtypes can substitute their base types
- `SimpleOrder` and `CompleteOrder` can be used interchangeably
- Any `IOrderCalculable` works seamlessly with `OrderProcessor`

### 4. Interface Segregation Principle (ISP)
- Interfaces are small, focused, and client-specific
- No "fat interfaces" forcing unnecessary implementations
- `SimpleOrder` only implements what it needs (calculation + placement)
- `CompleteOrder` implements additional interfaces as needed

### 5. Dependency Inversion Principle (DIP)
- High-level modules depend on abstractions, not concrete classes
- `OrderProcessor` depends on `IOrderCalculable` and `IOrderPlacable` interfaces
- Easy to swap implementations without changing client code

## 📁 Project Structure
