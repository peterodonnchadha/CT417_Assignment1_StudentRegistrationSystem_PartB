/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentRegistrationSystem_PartB;

import StudentRegistrationSystem.CourseProgramme;
import StudentRegistrationSystem.Student;
import StudentRegistrationSystem.Module;
import java.util.Arrays;
import java.util.List;
import org.joda.time.DateTime;

/**
 *
 * @author peter
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // fictional students populated with mock data
        List<Student> students = Arrays.asList(new Student("Peter O Donnchadha", "20/05/2000", "podonnchadha", null, null, 21, 18229906), new Student("Tom Hardy", "15/07/1977", "thardy", null, null, 44, 17788993), new Student("Tommy Tiernan", "10/06/1969", "ttiernan", null, null, 52, 87654321));

        // fictional modules to be populated with students
        List<Module> modules = Arrays.asList(new StudentRegistrationSystem.Module("Maths", "MA101", null, null), new StudentRegistrationSystem.Module("English", "EN102", null, null), new StudentRegistrationSystem.Module("Irish", "IR080", null, null));
        
        // initialising student pairs
        List<Student> Peter_Tom = Arrays.asList(students.get(0), students.get(1));
        List<Student> Tom_Tommy = Arrays.asList(students.get(0), students.get(1));
        List<Student> Peter_Tommy = Arrays.asList(students.get(0), students.get(2));
        
        // initialising module pairs
        List<Module> maths_english = Arrays.asList(modules.get(0), modules.get(1));
        List<Module> english_irish = Arrays.asList(modules.get(1), modules.get(2));
        List<Module> maths_irish = Arrays.asList(modules.get(0), modules.get(2));
        
        // add Peter and Tom to the Maths Module
        modules.get(0).setStudents(Peter_Tom);
        // add Tommy and Tom to the English Module
        modules.get(1).setStudents(Tom_Tommy);
        // add Peter and Tom to the Irish Module
        modules.get(2).setStudents(Peter_Tommy);
        
        // course start and end dates
        DateTime startDate = new DateTime(2020, 9, 1, 0, 0, 0, 0);
        DateTime endDate = new DateTime(2021, 5, 20, 0, 0, 0, 0);
        
        // initialising courses
        List<CourseProgramme> courses = Arrays.asList(new CourseProgramme("Engineering", maths_english, Peter_Tom, startDate, endDate), new CourseProgramme("Medicine", english_irish, Tom_Tommy, startDate, endDate), new CourseProgramme("Business", maths_irish, Peter_Tommy, startDate, endDate));
        
        // initialising module pairs
        List<CourseProgramme> eng_med = Arrays.asList(courses.get(0), courses.get(1));
        List<CourseProgramme> med_bus = Arrays.asList(courses.get(1), courses.get(2));
        List<CourseProgramme> eng_bus = Arrays.asList(courses.get(0), courses.get(2));
        
        CourseProgramme engineering = courses.get(0);
        CourseProgramme medicine = courses.get(1);
        CourseProgramme business = courses.get(2);
        
        engineering.setEnrolledStudents(Peter_Tom);
        
        Module maths = modules.get(0);
        Module english = modules.get(1); 
        Module irish = modules.get(2);
        
        // add courses to modules
        maths.setCourses(eng_bus);
        english.setCourses(eng_med);
        irish.setCourses(med_bus);
        
        Student peter = students.get(0);
        Student tom = students.get(1); 
        Student tommy = students.get(2);
        
        // set student's courses
        peter.setCourses(eng_bus);
        tom.setCourses(eng_med);
        tommy.setCourses(med_bus);
        
        // set student's modules
        peter.setModules(maths_irish);
        tom.setModules(maths_english);
        tommy.setModules(english_irish);
        
        // 1. Print string representation of the list using `toString()
        System.out.println(engineering.toString());
        System.out.println(medicine.toString());
        System.out.println(business.toString());
        //System.out.println("Student{" + "name=" + peter.getName() + ", dob=" + peter.getDob() + ", username=" + peter.getUsername() + ", age=" + peter.getAge() + ", id=" + peter.getId() + '}');

    }
    
}
