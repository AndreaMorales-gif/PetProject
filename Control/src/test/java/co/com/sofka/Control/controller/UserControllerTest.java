package co.com.sofka.Control.controller;

import co.com.sofka.Control.domain.repository.IRegisterDataRepository;
import co.com.sofka.Control.domain.repository.IUserDataRepository;
import co.com.sofka.Control.useCase.TransformationRegisterUseCase;
import co.com.sofka.Control.useCase.TransformationUserUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IUserDataRepository data;

    @MockBean
    private TransformationUserUseCase transformationUserUseCase;

   /* @Test
    @DisplayName("POST /api/saveUsers Success")
    public void guardarTest() throws Exception {
        String id = "1011391323";
        String name = "Salomé Berrio";
        String date = "17-07";
        String email = "salome@gmail.com";

        //Mockito.when(data.save(any())).thenReturn(new Person(new PersonId(id), new Name(name), new Phone(phone), new IsProfessional(professional)));

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/saveUsers/{userId}/{name}/{date}/{email}", id, name, date, email)
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"userId\":\"1011391323\",\"name\":\"Salomé Berrio\",\"date\":\"17-07\",\"email\"salome@gmail.com}"));


    }*/

}