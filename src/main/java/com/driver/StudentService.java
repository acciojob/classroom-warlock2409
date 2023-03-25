package com.driver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository repo = new StudentRepository();

    public boolean addStudent(Student data){
       return repo.addStudent(data);
    }
    public boolean addTeacher(Teacher data){
        return repo.addTeacher(data);
    }
    public boolean addStudentTeacherPair(String student , String teacher){
        return repo.addStudentTeacherPair(student,teacher);
    }
    public Student getStudentByName(String name){
        return repo.getStudentByName(name);
    }
    public Teacher getTeacherByName(String name){
        return repo.getTeacherByName(name);
    }
   public List<String> getStudentsByTeacherName(String teacher){
        return repo.getStudentsByTeacherName(teacher);
   }
   public List<String> getAllStudents(){
        return repo.getAllStudents();
   }
   public boolean deleteTeacherByName(String teacher){
        return repo.deleteTeacherByName(teacher);
   }

   public boolean deleteAllTeachers(){
        return repo.deleteAllTeachers();
   }
}
