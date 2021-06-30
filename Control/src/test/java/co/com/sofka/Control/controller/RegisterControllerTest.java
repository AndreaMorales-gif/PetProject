package co.com.sofka.Control.controller;


import co.com.sofka.Control.domain.repository.RegisterData;
import co.com.sofka.Control.domain.service.RegisterService;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class RegisterControllerTest {

    @MockBean
    private RegisterService service;

    @Autowired
    private MockMvc mockMvc;

 //   @Test
 //  @DisplayName("GET /registers success")
 // void testGetRegistersSuccess() throws Exception {
 //      RegisterData register1 = new RegisterData("1", "3", "26-06");
 //     RegisterData register2 = new RegisterData("4", "2", "27-07");
    //      doReturn(Lists.newArrayList(register1, register2)).when(service).listar();
//
    //       mockMvc.perform(get("/api/findRegisters"))
//
    //          .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//
    //          .andExpect(header().string(HttpHeaders.LOCATION, "/api/findRegisters"))

    //       .andExpect(jsonPath("$", hasSize(2)))
    //      .andExpect(jsonPath("$[0].id", is("1")))
    //       .andExpect(jsonPath("$[0].userId", is("3")))
    //       .andExpect(jsonPath("$[0].entryDate", is("26-06")))
    //       .andExpect(jsonPath("$[1].id", is("4")))
    //       .andExpect(jsonPath("$[1].userId", is("2")))
    //       .andExpect(jsonPath("$[1].entryDate", is("27-07")));
//}


}