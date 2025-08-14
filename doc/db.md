# Database
Since the requirements for this project are relatively well defined and I see minimal chance of expectations changing I intend on using an SQL oriented database. I've extensively used MySQL in my previous iteration of MasjidPro and I also used it at university so I will be opting for the open source MariaDB.
## Data stored
### Users
#### Students 
Personal information such as: Name, dob, gender, address and email and emergency contact, allergies etc.
System specific: Attendance, complaints, absences, suspensions, detentions, meetings, grades, feedback given, course they're taking, feedback to mosque/teacher, completion, start/end date, payment status, detentions, strikes. 
#### Parents
Personal info such as: name, dob, gender, relationship, address, email, phone number. 
#### Teachers
Same as parents as well as salary, subjects taught, hire date, application info from when they applied. 

### Education related data
Since most mosques have one class per year group we won't be handling as much as expected.
#### Course
Course name, course description, price, dates/timings, duration, capacity

#### Subjects
Subject name, subject description, time, day, respective teacher(s)

#### Books 
Book name, book description. price, link to bookstore, subject(s) it belongs to. 

#### Lessons
Lesson title, teacher(s), day, time. 

#### Feedback on exams
Grade, other feedback, expected/achieved. 



### System related data
#### Attendance
Absence for student, authorised by parent/teacher.
#### Formal complaint
Teacher(s)/student(s), outcome, date of meeting. 

#### Events
Date, time, open to: ... , description, title, relevant links. 
#### Payments
for course/book, made/pledged, online/in person, amount etc. 

## Database overview

## ERD/DB Justification

## Queries

## Testing DB/Queries