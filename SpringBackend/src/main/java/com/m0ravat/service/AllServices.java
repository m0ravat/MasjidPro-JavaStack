package com.m0ravat.service;

import com.m0ravat.models.*;
import com.m0ravat.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllServices {

    private final AccountRepository accountRepo;
    private final AttendanceRecordRepository attendanceRepo;
    private final BookRepository bookRepo;
    private final BookAssignmentRepository bookAssignRepo;
    private final ComplaintRecordRepository complaintRepo;
    private final CourseRepository courseRepo;
    private final CourseEnrollmentRepository courseEnrollRepo;
    private final ExamRepository examRepo;
    private final ExamRecordRepository examRecordRepo;
    private final PaymentRepository paymentRepo;
    private final PersonRepository personRepo;
    private final PublicEventRepository eventRepo;
    private final StudentRepository studentRepo;
    private final StudentFeedbackRepository feedbackRepo;
    private final SubjectRepository subjectRepo;

    public AllServices(AccountRepository accountRepo,
                       AttendanceRecordRepository attendanceRepo,
                       BookRepository bookRepo,
                       BookAssignmentRepository bookAssignRepo,
                       ComplaintRecordRepository complaintRepo,
                       CourseRepository courseRepo,
                       CourseEnrollmentRepository courseEnrollRepo,
                       ExamRepository examRepo,
                       ExamRecordRepository examRecordRepo,
                       PaymentRepository paymentRepo,
                       PersonRepository personRepo,
                       PublicEventRepository eventRepo,
                       StudentRepository studentRepo,
                       StudentFeedbackRepository feedbackRepo,
                       SubjectRepository subjectRepo) {
        this.accountRepo = accountRepo;
        this.attendanceRepo = attendanceRepo;
        this.bookRepo = bookRepo;
        this.bookAssignRepo = bookAssignRepo;
        this.complaintRepo = complaintRepo;
        this.courseRepo = courseRepo;
        this.courseEnrollRepo = courseEnrollRepo;
        this.examRepo = examRepo;
        this.examRecordRepo = examRecordRepo;
        this.paymentRepo = paymentRepo;
        this.personRepo = personRepo;
        this.eventRepo = eventRepo;
        this.studentRepo = studentRepo;
        this.feedbackRepo = feedbackRepo;
        this.subjectRepo = subjectRepo;
    }

    // Generic CRUD Getters

    public List<Account> getAccounts() { return accountRepo.findAll(); }
    public Optional<Account> getAccountById(Integer id) { return accountRepo.findById(id); }

    public List<AttendanceRecord> getAttendanceRecords() { return attendanceRepo.findAll(); }
    public Optional<AttendanceRecord> getAttendanceRecordById(Integer id) { return attendanceRepo.findById(id); }

    public List<Book> getBooks() { return bookRepo.findAll(); }
    public Optional<Book> getBookById(Integer id) { return bookRepo.findById(id); }

    public List<BookAssignment> getBookAssignments() { return bookAssignRepo.findAll(); }
    public Optional<BookAssignment> getBookAssignmentById(BookAssignmentKey key) { return bookAssignRepo.findById(key); }

    public List<ComplaintRecord> getComplaintRecords() { return complaintRepo.findAll(); }
    public Optional<ComplaintRecord> getComplaintRecordById(Integer id) { return complaintRepo.findById(id); }

    public List<Course> getCourses() { return courseRepo.findAll(); }
    public Optional<Course> getCourseByName(String name) { return courseRepo.findById(name); }

    public List<CourseEnrollment> getCourseEnrollments() { return courseEnrollRepo.findAll(); }
    public Optional<CourseEnrollment> getCourseEnrollmentById(CourseEnrollmentKey key) { return courseEnrollRepo.findById(key); }

    public List<Exam> getExams() { return examRepo.findAll(); }
    public Optional<Exam> getExamById(Integer id) { return examRepo.findById(id); }

    public List<ExamRecord> getExamRecords() { return examRecordRepo.findAll(); }
    public Optional<ExamRecord> getExamRecordById(ExamRecordKey key) { return examRecordRepo.findById(key); }

    public List<Payment> getPayments() { return paymentRepo.findAll(); }
    public Optional<Payment> getPaymentById(Integer id) { return paymentRepo.findById(id); }

    public List<Person> getPersons() { return personRepo.findAll(); }
    public Optional<Person> getPersonById(Integer id) { return personRepo.findById(id); }

    public List<PublicEvent> getPublicEvents() { return eventRepo.findAll(); }
    public Optional<PublicEvent> getPublicEventById(Integer id) { return eventRepo.findById(id); }

    public List<Student> getStudents() { return studentRepo.findAll(); }
    public Optional<Student> getStudentById(Integer id) { return studentRepo.findById(id); }

    public List<StudentFeedback> getStudentFeedbacks() { return feedbackRepo.findAll(); }
    public Optional<StudentFeedback> getStudentFeedbackById(Integer id) { return feedbackRepo.findById(id); }

    public List<Subject> getSubjects() { return subjectRepo.findAll(); }
    public Optional<Subject> getSubjectByName(String name) { return subjectRepo.findById(name); }
}

