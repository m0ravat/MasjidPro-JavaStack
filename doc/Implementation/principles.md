# Coding Standards & Principles
These are tje principles submitted by the QA Developer (me) to ensure standards for code. 
## SOLID Principles 

### Single Responsibility Principle

Single-responsibility Principle (SRP) states:
> A class should have one and only one reason to change, meaning that a class should have only one job

In the context of this project each file will have one purpose. 

### Open Closed Principle

Open-closed Principle (OCP) states:  
> Objects or entities should be open for extension but closed for modification.

Add new features without changing existing code - if it works don't change it (unless its messy)

### Liskov Substitution Principle:

Liskov Substitution Principle states:
> Let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of
type S where S is a subtype of T.

This means that every subclass or derived class should be substitutable for their base or parent class.

### Interface Segregation Principle

The interface segregation principle states:
> A client should never be forced to implement an interface that it doesn’t use, or clients shouldn’t be forced to depend on
 methods they do not use.

Don't include unused functions/classes/variables. 
### Dependency Inversion Principle

Dependency inversion principle states:
> Entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the low-level module, but they
should depend on abstractions.

High level classes should not extend high level classes, that's what abstract/interfaces are for.
## Other relevant Principles/Standards

### Legible Notation
Documentation at the start of each file documenting its purpose and notes explaining the why. Code should be clean enough what it's doing should be obvious.

### Separation of Concerns
Refer to SOLID
### Encapsulation
Private vs public vs protected and their respective use cases. 
### Modularity
Code shouldn't be congested in one large file, shouldn't be isolated either.
### Portability
It should work when deployed outside of the local machine.
### Anticipation of Change
Flexible code. 