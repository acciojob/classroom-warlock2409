package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {

    HashMap<String , Student> studentHashMap = new HashMap<>();
    HashMap<String ,Teacher> teacherHashMap = new HashMap<>();
    HashMap<String,String> studentTeacherPair = new HashMap<>();
    public boolean addStudent(Student data){
         studentHashMap.put(data.getName(),data);
         return true;
    }
    public boolean addTeacher(Teacher data){
        teacherHashMap.put(data.getName(),data);
        return true;
    }
    public boolean addStudentTeacherPair( String student , String teacher){
        studentTeacherPair.put(student,teacher);
        return true;
    }
    public Student getStudentByName(String name){
        if(studentHashMap.containsKey(name)){
            return studentHashMap.get(name);
        }
        return null;
    }
    public Teacher getTeacherByName(String name){
        if(teacherHashMap.containsKey(name)){
            return teacherHashMap.get(name);
        }
        return null;
    }
    public List<String> getStudentsByTeacherName(String teacher){
        List<String> li = new ArrayList<>();
        for(String student : studentTeacherPair.keySet()){
            if(studentTeacherPair.get(student).equals(teacher)){

                li.add(studentHashMap.get(student).getName());

            }
        }
        return li;
    }
    public List<String> getAllStudents(){
        List<String> li = new ArrayList<>();
        for(String students : studentHashMap.keySet()){
            li.add(students);
        }
        return li;
    }
    public boolean deleteTeacherByName(String name){
        Iterator<Map.Entry<String, String>> iterator = studentTeacherPair.entrySet().iterator();
        while(iterator.hasNext()){
           Map.Entry<String,String> student = iterator.next();
           if(student.getValue().equals(name)){
               iterator.remove();
               studentHashMap.remove(student.getKey());
           }
        }
        teacherHashMap.remove(name);
        return true;
    }
    public boolean deleteAllTeachers(){
        Iterator<Map.Entry<String, String>> iterator = studentTeacherPair.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,String> student = iterator.next();
            if(teacherHashMap.containsKey(student.getValue())){
                iterator.remove();
                studentHashMap.remove(student.getKey());
            }
        }
        teacherHashMap.clear();
        return true;
    }

}
