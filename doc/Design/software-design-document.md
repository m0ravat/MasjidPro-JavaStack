# Software Design Documentation

## High Level Architecture 
The backend will consist of 2 main areas: authentication and the API for data handling.   
The backend will be the only source to directly interact with the database, so all other systems like frontend, desktop & mobile 
will communicate with the backend. This can be represented through:  
> Database --> Backend (Authentication/API) --> Presentation Layer (Mobile, web, desktop)  

This is a client-server application that will be deployed locally and maintained on GitHub, while the backend
initially cover both the API and authentication I may separate them in the future but for now will handle them in the same application.
### Database Design
I am using a MySQL database with phpmyadmin as the interface to interact with it. 
#### Database Schema
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
#### Entity relationship diagram (ERD)

#### Relationships between data entities
##### Inheritance (is-a)
##### Association (uses-a)
##### Aggregation (has-a, weak ownership)
##### Composition (has-a, strong ownership)
##### Dependency (depends on)

### Backend Design
The backend will be launched in SpringBoot due to its comprehensive and constantly maintained ecosystem.
#### GraphQL Schema 
```graphql
schema {
  query: Query
  mutation: Mutation
}   
## Queries
type Query {
    accounts: [Account]
    accountById(accountID: String!): Account

    attendanceRecords: [AttendanceRecord]
    attendanceRecordById(attendanceID: String!): AttendanceRecord

    books: [Book]
    bookById(bookID: String!): Book

    bookAssignments: [BookAssigment]
    bookAssigmentById(uniqueAssignID: String!): BookAssigment

    complaintRecords: [ComplaintRecord]
    complaintRecordById(complaintID: String!): ComplaintRecord

    courses: [Course]
    courseByName(courseName: String!): Course

    courseEnrollments: [CourseEnrollment]
    courseEnrollmentById(enrolID: String!): CourseEnrollment

    exams: [Exam]
    examById(examID: String!): Exam

    examRecords: [ExamRecord]
    examRecordByPk(studentID: String!, examID: String!): ExamRecord

    payments: [Payment]
    paymentById(paymentID: String!): Payment

    persons: [Person]
    personById(personID: String!): Person

    publicEvents: [PublicEvent]
    publicEventById(eventID: String!): PublicEvent

    students: [Student]
    studentById(studentID: String!): Student

    studentFeedbacks: [StudentFeedback]
    studentFeedbackById(feedbackID: String!): StudentFeedback

    subjects: [Subject]
    subjectByName(subjectName: String!): Subject
    subjectByTeacher(teacherID: Int): Subject
}
## Mutations
type Mutation {
    createAccount(input: CreateAccountInput!): Account
    updateAccount(username: String, input: UpdateAccountInput!): Account
    deleteAccount(username: String): Boolean

    createAttendanceRecord(input: CreateAttendanceRecordInput!): AttendanceRecord
    updateAttendanceRecord(attendanceID: String, input: UpdateAttendanceRecordInput!): AttendanceRecord
    deleteAttendanceRecord(attendanceID: String): Boolean

    createBook(input: CreateBookInput!): Book
    updateBook(bookID: String, input: UpdateBookInput!): Book
    deleteBook(bookID: String): Boolean

    createBookAssignment(input: CreateBookAssigmentInput!): BookAssigment
    updateBookAssignment(uniqueAssignID: String, input: UpdateBookAssigmentInput!): BookAssigment
    deleteBookAssignment(uniqueAssignID: String): Boolean

    createComplaintRecord(input: CreateComplaintRecordInput!): ComplaintRecord
    updateComplaintRecord(complaintID: String, input: UpdateComplaintRecordInput!): ComplaintRecord
    deleteComplaintRecord(complaintID: String): Boolean

    createCourse(input: CreateCourseInput!): Course
    updateCourse(courseName: String, input: UpdateCourseInput!): Course
    deleteCourse(courseName: String): Boolean

    createCourseEnrollment(input: CreateCourseEnrollmentInput!): CourseEnrollment
    updateCourseEnrollment(enrolID: String, input: UpdateCourseEnrollmentInput!): CourseEnrollment
    deleteCourseEnrollment(enrolID: String): Boolean

    createExam(input: CreateExamInput!): Exam
    updateExam(examID: String, input: UpdateExamInput!): Exam
    deleteExam(examID: String): Boolean

    createExamRecord(input: CreateExamRecordInput!): ExamRecord
    updateExamRecord(studentID: String, input: UpdateExamRecordInput!): ExamRecord
    deleteExamRecord(studentID: String): Boolean

    createPayment(input: CreatePaymentInput!): Payment
    updatePayment(paymentID: String, input: UpdatePaymentInput!): Payment
    deletePayment(paymentID: String): Boolean

    createPerson(input: CreatePersonInput!): Person
    updatePerson(personID: String, input: UpdatePersonInput!): Person
    deletePerson(personID: String): Boolean

    createPublicEvent(input: CreatePublicEventInput!): PublicEvent
    updatePublicEvent(eventID: String, input: UpdatePublicEventInput!): PublicEvent
    deletePublicEvent(eventID: String): Boolean

    createStudent(input: CreateStudentInput!): Student
    updateStudent(studentID: String, input: UpdateStudentInput!): Student
    deleteStudent(studentID: String): Boolean

    createStudentFeedback(input: CreateStudentFeedbackInput!): StudentFeedback
    updateStudentFeedback(feedbackID: String, input: UpdateStudentFeedbackInput!): StudentFeedback
    deleteStudentFeedback(feedbackID: String): Boolean

    createSubject(input: CreateSubjectInput!): Subject
    updateSubject(subjectName: String, input: UpdateSubjectInput!): Subject
    deleteSubject(subjectName: String): Boolean
}
## Entities 
type Account {
    username: String
    password: String
    accountID: Int
}
type AttendanceRecord {
    attendanceID: Int
    studentID: Int
    subjectID: Int
    dateMarked: String
    isAbsent: Boolean
    authorisedAbsence: Boolean
    extraInfo: String
}
type Book {
    bookID: Int
    bookName: String
    bookDesc: String
    price: Float
    bookLinks: String
}
type BookAssigment {
    uniqueAssignID: Int
    bookID: Int
    subjectName: String
}
type ComplaintRecord {
    complaintID: Int
    studentID: Int
    teacherID: Int
    complaintTitle: String
    complaintDesc: String
    meetingSet: String
    outcome: String
}
type Course {
    courseName: String
    courseDesc: String
    price: Float
    duration: String
    capacity: Int
    targetAge: String
}
type CourseEnrollment {
    enrolID: Int
    studentID: Int
    courseName: String
    startDate: String
    endDate: String
    finalOutcome: String
    currentlyTaking: Boolean
}
type Exam {
    examID: Int
    examTitle: String
    examDesc: String
    forSubject: String
}
type ExamRecord {
    studentID: Int
    examID: Int
    takenAt: String
}
type Payment {
    paymentID: Int
    paymentType: String
    paymentReceived: Boolean
    madeOnline: Boolean
    amount: Float
    dateMade: String
    paymentFor: String
}
type Person {
    personID: Int
    firstName: String
    lastName: String
    doB: String
    gender: String
    homeAddress: String
    email: String
    phoneNo: String
    applicationInfo: String
    typeOfPerson: String
    medicalInfo: String
    userFlag: Boolean
    relationshipWith: String
}
type PublicEvent {
    eventID: Int
    dateInfo: String
    timeInfo: String
    openTo: String
    eventDesc: String
    relevantLinks: String
}
type Student {
    studentID: Int
    debtOwes: Float
}
type StudentFeedback {
    feedbackID: Int
    feedbackGiven: String
    studentID: Int
    teacherID: Int
}
type Subject {
    subjectName: String
    subjectDesc: String
    timeInfo: String
    dateInfo: String
    teacherID: Int
    salary: Float
    hireDate: String
}
## Inputs
input CreateAccountInput {
    username: String!
    password: String!
    accountID: String!
}
input UpdateAccountInput {
    username: String
    password: String
    accountID: String
}
input CreateAttendanceRecordInput {
    attendanceID: String!
    studentID: String!
    subjectID: String!
    dateMarked: String!
    isAbsent: Boolean!
    authorisedAbsence: Boolean!
    extraInfo: String!
}
input UpdateAttendanceRecordInput {
    attendanceID: String
    studentID: String
    subjectID: String
    dateMarked: String
    isAbsent: Boolean
    authorisedAbsence: Boolean
    extraInfo: String
}
input CreateBookInput {
    bookID: String!
    bookName: String!
    bookDesc: String!
    price: Float!
    bookLinks: String!
}
input UpdateBookInput {
    bookID: String
    bookName: String
    bookDesc: String
    price: Float
    bookLinks: String
}
input CreateBookAssigmentInput {
    uniqueAssignID: String!
    bookID: String!
    subjectName: String!
}
input UpdateBookAssigmentInput {
    uniqueAssignID: String
    bookID: String
    subjectName: String
}
input CreateComplaintRecordInput {
    complaintID: String!
    studentID: String!
    teacherID: String!
    complaintTitle: String!
    complaintDesc: String!
    meetingSet: String!
    outcome: String!
}
input UpdateComplaintRecordInput {
    complaintID: String
    studentID: String
    teacherID: String
    complaintTitle: String
    complaintDesc: String
    meetingSet: String
    outcome: String
}
input CreateCourseInput {
    courseName: String!
    courseDesc: String!
    price: Float!
    duration: String!
    capacity: String!
    targetAge: String!
}
input UpdateCourseInput {
    courseName: String
    courseDesc: String
    price: Float
    duration: String
    capacity: String
    targetAge: String
}
input CreateCourseEnrollmentInput {
    enrolID: String!
    studentID: String!
    courseName: String!
    startDate: String!
    endDate: String!
    finalOutcome: String!
    currentlyTaking: Boolean!
}
input UpdateCourseEnrollmentInput {
    enrolID: String
    studentID: String
    courseName: String
    startDate: String
    endDate: String
    finalOutcome: String
    currentlyTaking: Boolean
}
input CreateExamInput {
    examID: String!
    examTitle: String!
    examDesc: String!
    forSubject: String!
}
input UpdateExamInput {
    examID: String
    examTitle: String
    examDesc: String
    forSubject: String
}
input CreateExamRecordInput {
    studentID: String!
    examID: String!
    takenAt: String!
}
input UpdateExamRecordInput {
    studentID: String
    examID: String
    takenAt: String
}
input CreatePaymentInput {
    paymentID: String!
    paymentType: String!
    paymentReceived: Boolean!
    madeOnline: Boolean!
    amount: Float!
    dateMade: String!
    paymentFor: String!
}
input UpdatePaymentInput {
    paymentID: String
    paymentType: String
    paymentReceived: Boolean
    madeOnline: Boolean
    amount: Float
    dateMade: String
    paymentFor: String
}
input CreatePersonInput {
    personID: String!
    firstName: String!
    lastName: String!
    doB: String!
    gender: String!
    homeAddress: String!
    email: String!
    phoneNo: String!
    applicationInfo: String!
    typeOfPerson: String!
    medicalInfo: String!
    userFlag: Boolean!
    relationshipWith: String!
}
input UpdatePersonInput {
    personID: String
    firstName: String
    lastName: String
    doB: String
    gender: String
    homeAddress: String
    email: String
    phoneNo: String
    applicationInfo: String
    typeOfPerson: String
    medicalInfo: String
    userFlag: Boolean
    relationshipWith: String
}
input CreatePublicEventInput {
    eventID: String!
    dateInfo: String!
    timeInfo: String!
    openTo: String!
    eventDesc: String!
    relevantLinks: String!
}
input UpdatePublicEventInput {
    eventID: String
    dateInfo: String
    timeInfo: String
    openTo: String
    eventDesc: String
    relevantLinks: String
}
input CreateStudentInput {
    studentID: String!
    debtOwes: Float!
}
input UpdateStudentInput {
    studentID: String
    debtOwes: Float
}
input CreateStudentFeedbackInput {
    feedbackID: String!
    feedbackGiven: String!
    studentID: String!
    teacherID: String!
}
input UpdateStudentFeedbackInput {
    feedbackID: String
    feedbackGiven: String
    studentID: String
    teacherID: String
}
input CreateSubjectInput {
    subjectName: String!
    subjectDesc: String!
    timeInfo: String!
    dateInfo: String!
    teacherID: String!
    salary: Float!
    hireDate: String!
}
input UpdateSubjectInput {
    subjectName: String
    subjectDesc: String
    timeInfo: String
    dateInfo: String
    teacherID: String
    salary: Float
    hireDate: String
}
```
#### Authentication Design

### Presentation Layer

#### Website 
I will use Vue.js for the website. This will cover functionality for public users, registered users and employees ie teachers.
##### UI wireframes
##### Pages & Components 
##### Dynamic data vs static data 
##### CSS Styling and external packages/libraries

#### Desktop 
I will use either JavaFX/SwingUI for the desktop app. The purpose of this app is to create a dashboard for the system admin.
##### UI wireframes

#### Mobile
For now I won't go over this but my intention is to create an equivalent mobile app in Kotlin, similar to how Workday has a mobile/web app.

## External software
### Version Control
I will use GitHub for version control, since I will be simulating multiple developers I will include each one in the commit made and use branches to simulate a team environment with a QA developer in charge of approving changes/providing feedback. 

### Team Collaboration
I will use Jira to keep track of Events/Tasks and simulate conversations at the start/end of each day to simulate how developers may communicate.
### Deployment
It will mainly be deployed locally until the MVP is produced, in which case I'll use:    
- Backend: NA
- Database: Currently Google Cloud Platform (GCP), ideally AWS since that's more industry standard.
- Website: NA
- Desktop: NA
- Mobile: NA


## Security Measures
