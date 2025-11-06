package com.m0ravat.controllers;

import com.m0ravat.models.*;
import com.m0ravat.service.AllServices;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AllControllers {

    private final AllServices service;

    public AllControllers(AllServices service) {
        this.service = service;
    }

    // ---- Account ----
    @QueryMapping public List<Account> accounts() { return service.getAccounts(); }
    @QueryMapping public Account accountById(@Argument Integer accountID) { return service.getAccountById(accountID).orElse(null); }

    // ---- AttendanceRecord ----
    @QueryMapping public List<AttendanceRecord> attendanceRecords() { return service.getAttendanceRecords(); }
    @QueryMapping public AttendanceRecord attendanceRecordById(@Argument Integer attendanceID) { return service.getAttendanceRecordById(attendanceID).orElse(null); }

    // ---- Book ----
    @QueryMapping public List<Book> books() { return service.getBooks(); }
    @QueryMapping public Book bookById(@Argument Integer bookID) { return service.getBookById(bookID).orElse(null); }

    // ---- BookAssignment ----
    @QueryMapping public List<BookAssignment> bookAssignments() { return service.getBookAssignments(); }
    @QueryMapping public BookAssignment bookAssignmentById(@Argument Integer uniqueAssignID, @Argument Integer bookID, @Argument String subjectName) {
        BookAssignmentKey key = new BookAssignmentKey();
        key.setUniqueAssignID(uniqueAssignID);
        key.setBookID(bookID);
        key.setSubjectName(subjectName);
        return service.getBookAssignmentById(key).orElse(null);
    }

    // ---- ComplaintRecord ----
    @QueryMapping public List<ComplaintRecord> complaintRecords() { return service.getComplaintRecords(); }
    @QueryMapping public ComplaintRecord complaintRecordById(@Argument Integer complaintID) { return service.getComplaintRecordById(complaintID).orElse(null); }

    // ---- Course ----
    @QueryMapping public List<Course> courses() { return service.getCourses(); }
    @QueryMapping public Course courseByName(@Argument String courseName) { return service.getCourseByName(courseName).orElse(null); }

    // ---- CourseEnrollment ----
    @QueryMapping public List<CourseEnrollment> courseEnrollments() { return service.getCourseEnrollments(); }
    @QueryMapping public CourseEnrollment courseEnrollmentById(@Argument Integer enrolID, @Argument Integer studentID) {
        CourseEnrollmentKey key = new CourseEnrollmentKey();
        key.setEnrolID(enrolID);
        key.setStudentID(studentID);
        return service.getCourseEnrollmentById(key).orElse(null);
    }

    // ---- Exam ----
    @QueryMapping public List<Exam> exams() { return service.getExams(); }
    @QueryMapping public Exam examById(@Argument Integer examID) { return service.getExamById(examID).orElse(null); }

    // ---- ExamRecord ----
    @QueryMapping public List<ExamRecord> examRecords() { return service.getExamRecords(); }
    @QueryMapping public ExamRecord examRecordByPk(@Argument Integer studentID, @Argument Integer examID) {
        ExamRecordKey key = new ExamRecordKey();
        key.setStudentID(studentID);
        key.setExamID(examID);
        return service.getExamRecordById(key).orElse(null);
    }

    // ---- Payment ----
    @QueryMapping public List<Payment> payments() { return service.getPayments(); }
    @QueryMapping public Payment paymentById(@Argument Integer paymentID) { return service.getPaymentById(paymentID).orElse(null); }

    // ---- Person ----
    @QueryMapping public List<Person> persons() { return service.getPersons(); }
    @QueryMapping public Person personById(@Argument Integer personID) { return service.getPersonById(personID).orElse(null); }

    // ---- PublicEvent ----
    @QueryMapping public List<PublicEvent> publicEvents() { return service.getPublicEvents(); }
    @QueryMapping public PublicEvent publicEventById(@Argument Integer eventID) { return service.getPublicEventById(eventID).orElse(null); }

    // ---- Student ----
    @QueryMapping public List<Student> students() { return service.getStudents(); }
    @QueryMapping public Student studentById(@Argument Integer studentID) { return service.getStudentById(studentID).orElse(null); }

    // ---- StudentFeedback ----
    @QueryMapping public List<StudentFeedback> studentFeedbacks() { return service.getStudentFeedbacks(); }
    @QueryMapping public StudentFeedback studentFeedbackById(@Argument Integer feedbackID) { return service.getStudentFeedbackById(feedbackID).orElse(null); }

    // ---- Subject ----
    @QueryMapping public List<Subject> subjects() { return service.getSubjects(); }
    @QueryMapping public Subject subjectByName(@Argument String subjectName) { return service.getSubjectByName(subjectName).orElse(null); }
}

