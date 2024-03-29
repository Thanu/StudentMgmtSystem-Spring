package org.cse.springtute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleStudentRepository implements StudentRepository {

    private Map<Long, Student> studentsDb = new HashMap<Long, Student>();

    @Override
    public void saveStudent(Student stu) {
        studentsDb.put(stu.getRegNumber(), stu);
    }

    @Override
    public void deleteStudent(Student stu) {
        studentsDb.remove(stu.getRegNumber());

    }

    @Override
    public Student findStudent(long regNumber) {
        return studentsDb.get(regNumber);
    }

    @Override
    public void updateStudent(Student stu) {
        if (findStudent(stu.getRegNumber()) == null) {
            saveStudent(stu);
        } else {
            deleteStudent(stu);
            saveStudent(stu);
        }
    }

    @Override
    public List<Student> findAllStudents() {
        ArrayList students = new ArrayList(studentsDb.values());
        return students;
    }
}
