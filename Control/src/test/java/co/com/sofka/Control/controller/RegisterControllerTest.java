package co.com.sofka.Control.controller;


import co.com.sofka.Control.domain.repository.IRegisterDataRepository;
import co.com.sofka.Control.domain.repository.RegisterData;
import co.com.sofka.Control.domain.service.RegisterService;
import co.com.sofka.Control.useCase.TransformationRegisterUseCase;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class RegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IRegisterDataRepository data;

    @MockBean
    private TransformationRegisterUseCase transformationRegisterUseCase;


    @Test
    @DisplayName("POST /api/saveRegisters success")
    public void saveRegistersTest() throws Exception {
        String registerId = "5";
        String userId = "1025760444";
        String entryDate = "26-06";

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/saveRegisters/{registerId}/{userId}/{entryDate}", registerId, userId, entryDate)
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"registerId\":\"5\",\"userId\":\"1025760444\",\"entryDate\":\"26-06}"));
    }

 /*   @Test
    @DisplayName("GET /api/findRegister/{id} Success")
    public void listarId() throws Exception {

        Mockito.when(transformationRegisterUseCase.listarId("1")).thenReturn(new RegisterData("5", "1025760444", "26-06");

        mockMvc.perform( MockMvcRequestBuilders
                .get("/api/findRegister/{id}", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is("5")))
                .andExpect(jsonPath("$.userId", is("1025760444")));

    }*/

}





