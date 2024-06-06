package ru.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.example.demo.IntegrationTestBase;
import ru.example.demo.dto.StatisticDto;
import ru.example.demo.service.StatisticService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StatisticControllerTest extends IntegrationTestBase {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StatisticService statisticService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getData() throws Exception {
        objectMapper.registerModule(new JavaTimeModule());
        StatisticDto statisticDto = Instancio.create(StatisticDto.class);
        when(statisticService.getStatistics(any())).thenReturn(statisticDto);
        MvcResult mvcResult = mockMvc.perform(get("/statistics")
                        .param("startTime", "2024-05-28T18:57:26.338522982"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        StatisticDto dto = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), StatisticDto.class);
        assertThat(dto.getStartTime()).isEqualTo(statisticDto.getStartTime());
        assertThat(dto.getEndTime()).isEqualTo(statisticDto.getEndTime());
        assertThat(dto.getEnrollment()).isEqualTo(statisticDto.getEnrollment());
        assertThat(dto.getWithdrawal()).isEqualTo(statisticDto.getWithdrawal());
    }
}