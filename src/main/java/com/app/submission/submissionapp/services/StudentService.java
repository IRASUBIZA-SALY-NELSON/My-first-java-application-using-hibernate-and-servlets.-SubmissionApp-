package com.app.submission.submissionapp.services;

import com.app.submission.submissionapp.models.Student;
import com.app.submission.submissionapp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentService {
    protected static SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
    protected static Session session;
    protected static StudentService studentService;
    public static StudentService getInstance() {
        if (studentService == null) {
            studentService = new StudentService();
            return studentService;
        }
        return studentService;
    }
    private StudentService() {}
    public void addStudent(Student student) {
        session=sessionFactory.openSession();
        session.beginTransaction();
        session.persist(student);
        session.getTransaction().commit();

    }
    public List<Student> getAllStudents() {
        session=sessionFactory.openSession();
        List<Student> students = session.createQuery("from Student").list();
        return students;
    }
}
