package com.project.demo;

import com.project.demo.annotation_config.service.TeacherService;
import com.project.demo.bean_annotation_config.service.CourseService;
import com.project.demo.entity.Student;
import com.project.demo.xml_config.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;


public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext contextByXml = new ClassPathXmlApplicationContext("applicationcontext/application-xml-bean-config.xml");

		System.out.println("Get bean by class type");
		StudentService studentService = contextByXml.getBean(StudentService.class);
		studentService.justDoIt();

		System.out.println("Get bean by id");
		StudentService studentServiceById = (StudentService) contextByXml.getBean("studentService");
		studentServiceById.justDoIt();


		ApplicationContext contextByAnnotations = new ClassPathXmlApplicationContext("applicationcontext/application-scan-bean-config.xml");

		System.out.println("Get bean by class type");
		TeacherService teacherService = contextByAnnotations.getBean(TeacherService.class);
		teacherService.justDoIt();


		ApplicationContext contextByConfiguration =
				new AnnotationConfigApplicationContext(com.project.demo.bean_annotation_config.configuration.ApplicationConfiguration.class);
		CourseService courseService = contextByConfiguration.getBean(CourseService.class);
		courseService.welcomeToCourse();

		Student student = contextByConfiguration.getBean(Student.class);
		student.getFirstName();

		GenericApplicationContext context = new GenericApplicationContext();
		context.registerBean( TeacherService.class, () -> new TeacherService());
		context.refresh();

		TeacherService teacherService2 = context.getBean(TeacherService.class);
		teacherService2.justDoIt();
	}

}
