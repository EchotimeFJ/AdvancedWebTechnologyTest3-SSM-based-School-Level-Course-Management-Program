import com.popse.pojo.Course;
import com.popse.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CourseTest {

    @Autowired
    @Qualifier("CourseServiceImpl")
    private CourseService courseService;

    @Test
    public void findCourseByNameTest() {
        ArrayList<Course> courseList = courseService.findCourseByName("");
        for(Course course : courseList) {
            System.out.println(course);
        }
    }

    @Test
    public void deleteCourseTest() {
        int i = courseService.deleteCourse(6);
        System.out.println(i);
    }

    @Test
    public void findCourseByIdAndNameTest() {
        ArrayList<Course> courseList = courseService.findCourseByIdAndName(9, "线性代数");
        for(Course course :courseList) {
            System.out.println(course);
        }
    }

    @Test
    public void findCourseAndAcademyByIdTest() {
        Map<String, Object> a = courseService.findCourseAndAcademyById(1);
        System.out.println(a);
    }

    @Test
    public void findCourseAndAcademyAllTest() {
//        List<Map<String, Object>> courses = courseService.findCourseAndAcademyAll();
//        for(Map<String, Object> course : courses) {
//            System.out.println(course);
//        }
//        System.out.println(courses.size());
        List<Object> obj = new ArrayList<>();
        List<Map<String, Object>> courses = courseService.findCourseAndAcademyAll();
        for(Map<String, Object> course : courses) {
            obj.add(course);
        }
    }
}
