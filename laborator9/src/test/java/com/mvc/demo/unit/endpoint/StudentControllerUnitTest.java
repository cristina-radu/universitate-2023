package com.mvc.demo.unit.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.demo.controller.StudentController;
import com.mvc.demo.dto.StudentDto;
import com.mvc.demo.model.Student;
import com.mvc.demo.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentControllerUnitTest {
    private MockMvc mockMvc;
    @Mock
    private StudentService studentService;
    @InjectMocks
    private StudentController studentController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    public void testGetAll_Success() throws Exception {
        List<StudentDto> students = getDummyStudentDtos();
        Mockito.when(studentService.getAll()).thenReturn(students);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/student"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(students)));
    }

    @Test
    public void testSave_success() throws Exception{
        StudentDto studentDto = getDummyStudentDtoOne();
        studentDto.setId(null);
        StudentDto savedStudentDto = getDummyStudentDtoOne();

        Mockito.when(studentService.save(studentDto))
                .thenReturn(savedStudentDto);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/student")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(studentDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(savedStudentDto)));
    }

    private List<StudentDto> getDummyStudentDtos(){
        return new ArrayList<>(Arrays.asList(getDummyStudentDtoOne(), getDummyStudentDtoTwo()));
    }

    private StudentDto getDummyStudentDtoOne(){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(10l);
        studentDto.setFirstName("Mircea");
        studentDto.setLastName("Pop");
        studentDto.setAge(22);
        studentDto.setScore(9);
        return studentDto;
    }

    private StudentDto getDummyStudentDtoTwo(){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(11l);
        studentDto.setFirstName("Maria");
        studentDto.setLastName("Georgescu");
        studentDto.setAge(23);
        studentDto.setScore(10);
        return studentDto;
    }
}
