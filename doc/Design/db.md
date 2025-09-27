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
I used [DBDiagram.io](dbdiagram.io) to design my database, even though the layout feature doesn't handle relationship lines well since they constantly go behind/over other tables/lines it was the quickest and easiest way since tables are dynamically generated through an SQL like query which can be seen below:     

Project project_name {      
  database_type: 'MariaDB'      
  Note: 'MadrasahPro Database'     
}    

Table Person as P{     
  personID integer [pk, unique, not null, increment]     
  firstName varchar(100) [not null]     
  lastName varchar(100) [not null]   
  doB date [not null]   
  gender varchar(20) [not null]   
  address varchar(200) [not null]     
  email email [not null, unique, default: "Refer to parent/guardian contact info"]   
  phoneNumber varchar(50) [not null, default: "Refer to parent/guardian contact info"]   
  applicationInfo varchar(1000)   
  typeofApplicant varchar(20) [not null]   
  medicalInfo varchar(300) [not null, default: "N/A"]    
}    
Table Profile as U {   
  profileID integer [pk, unique, ref: - P.personID, not null]    
  emergencyContactFlag boolean [not null]    
  userFlag boolean [not null]    
  relationship varchar(100) [null]    
  priority int [null]    
  username varchar(50) [unique, null]    
  password varchar(20) [null]     
}      

Table Student {     
  studentID integer [pk, unique, ref: -U.profileID, not null]     
  courseEnrolled varchar(100) [not null]     
  accountCreated date [not null]     
  debt int [not null, default: 0]      
}     
Table Parent {     
  parentID integer [pk, unique, ref: -U.profileID, not null]     
  relationship varchar(100) [not null]     
}     
Table Teacher {     
  teacherID integer [pk, unique, ref: -U.profileID, not null]      
  salary float [not null]      
  hireDate date [not null, default: "TBC"]     
  subjectsTaught varchar(300) [not null, default: "N/A"]      
}      
Table AttendanceRecord {    
  attendanceID integer [pk, not null, increment]     
  studentID integer [not null, ref: > Student.studentID]    
  subjectID integer [ref: > Subject.subjectName, not null]     
  dateMark date [not null]     
  isAbsent boolean [not null]    
  authorisedAbsence boolean [not null, default: False]    
  extraInfo varchar(200) [not null, default: "N/A"]    
}   
Table ComplaintRecord {   
  complaintID integer [pk, not null, increment]   
  teacherID integer [not null, ref: > Teacher.teacherID]   
  studentID integer [not null, ref: > Student.studentID]   
  complaintTitle varchar(50) [not null]   
  complaintDesc varchar(300) [not null, default: "Refer to title"]   
  meetingSet date [null]   
  outcome varchar(100) [not null, default: "N/A"]   
}   
Table StudentFeedback {   
  feedbackID int [pk, not null, increment]   
  feedbackGiven varchar(200) [not null]   
  studentID int [ref: > Student.studentID, not null]   
  teacherID int [ref: > Teacher.teacherID, not null]   
}    
Table Course {   
  courseName varchar(100) [pk, unique, not null]   
  courseDesc varchar(500) [not null]    
  price int [not null]    
  duration varchar(50) [not null]    
  startAndEnd varchar(100) [not null]    
  capacity int [not null]    
}    
   
Table CourseEnrollment {   
  enrolID int [pk, unique, not null]    
  studentID int [unique, not null, ref: > Student.studentID]     
  courseID int [unique, not null, ref: > Course.courseName]    
  startDate date [not null]    
  endDate date [not null]    
  finalOutcome varchar(100) [not null, default: "N/A"]    
  currentlyTaking boolean [not null]   
}    
Table Subject {    
  subjectName varchar(100) [pk, unique, not null]   
  subjectDesc varchar(500) [not null]  
  timeInfo varchar(200) [not null]    
  dayInfo varchar(200) [not null]   
  taughtBy varchar(100) [not null, ref: > Teacher.teacherID]   
  courseName varchar(100) [ref: > Course.courseName]   
}    
Table BookAssignment {   
  uniqueAssignID int [pk, not null, unique, increment]    
  subjectAssigned varchar(100) [pk, ref: > Subject.subjectName]     
  bookAssigned varchar(200) [pk, ref: > Book.bookName]     
}     
Table Book {     
  bookName varchar(200) [pk, unique, not null]    
  bookDesc varchar(300) [not null]    
  price float [not null]    
  bookStoreLink varchar(400) [not null]    
}    
Table Exam {     
  examID int [pk, unique, increment, not null]     
  examTitle varchar(100) [not null]     
  examDesc varchar(500) [not null]     
  subjectID int [ref: > Subject.subjectName, not null]     
}     
Table ExamRecord {    
  recordID int [pk, unique, increment, not null]     
  percentage float [not null]    
  feedback varchar(1000) [not null]    
  dateTaken datetime [not null]    
  studentID int [ref: > Student.studentID, not null]    
  examID int [ref: > Exam.examID, not null]    
}     
  
Table Event {     
  eventID int [pk, unique, increment, not null]     
  dateInfo varchar(100) [not null]   
  timeInfo varchar(100) [not null]    
  openTo varchar(200) [not null]     
  eventDesc varchar(500) [not null]    
  relevantLinks varchar(1000) [not null]    
}    
Table Payment {    
  paymentID int [pk, unique, increment, not null]    
  paymentType varchar(100) [not null]    
  paymentReceived boolean [not null]    
  madeOnline boolean [not null]    
  amount float [not null]     
  dateMade date [not null]    
  paymentFor int [ref: > Student.studentID, not null]    
}    
## ERD/DB Justification
### Mapping the person related tables
Originally, I had a person table with a person's personal information. After that I had a user table with username/password and an emergency contact table. This is because I wanted to keep users separate to an emergency contact who wouldn't have an account which reflected a {optional, and} relationship. A person on the system could be an emergency contact and a parent/teacher, but if they just made an application they wouldn't be any. Mapping this meant I would merge the child tables together and add nullable flags. Then I renamed the User table to Profile table since not every emergency contact would be a user of the system.        
Afterwards, I had a Student, Teacher and Parent table to reflect each different type of user account. Each of these tables would have a primary key which would also be a foreign key from the Profile table, which is a mandatory, and relationship. 

### Other base tables
I have a payment table which records information about a payment, this is to allow students to buy books/pay for the course. I record various flexible information so payments can easily be recorded for different types and whether it's done in person or online.    
My Exam table records information of the exam so it could be sent ahead of time to students/parents so they can prepare for it. I then added an ExamRecord table which would have a unique record for every person who takes the test.     
I also have a Course table for the overall course and a subject table since one course will have multiple subjects. I also added a book table so parents can know what subjects require what books by joining the two tables with a BookAssign table. This is because one subject might have a (Year 1) and (Year 2) version so we could have one book spanning both years.    
I also have an event table which will dynamically load events for the website so people can know what's happening at the mosque. I considered adding a blog section so the mosque can make posts but since the intent behind this isn't currently commercial it seems redundant.

### Join tables
I have a table that records attendance for students by keeping track of their mark (absent/present), tracking extra info if there was an absence and the date/subject missed. This is because I felt dynamically calculating attendance would be easier than creating a record for every lesson on every subject and then creating an attendance record for each iteration of a lesson. This does mean values could be slightly skewed if the teacher isn't present and someone else doesn't record attendance on that day or if a teacher puts an extra day of attendance or forgets one. Even so, this is the easiest and the most storage safe way of handling it for the scope of this project and it would be assumed these results are overseen by the headteacher. We could also count the total absences/presents to see if students are missing any records as well. 
## Queries

## Testing DB/Queries