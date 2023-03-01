package arp.project.spring.learnspringboot.survey;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@WebMvcTest(controllers = SurveyController.class)
@AutoConfigureMockMvc(addFilters = false)
class SurveyControllerTest {
    @MockBean
    private SurveyService surveyService;

    @Autowired
    private MockMvc mockMvc;

    private static String SPECIFIC_QUESTION_URL = "http://localhost:8081/surveys/Survey1/questions/Question1";
    private static String QUESTIONS_URL = "http://localhost:8081/surveys/Survey1/questions";

    @Test
    public void getQuestionByIdForSurvey_404Scenario() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(404, mvcResult.getResponse().getStatus());
    }

    @Test
    public void getQuestionByIdForSurvey_baseScenario() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL).accept(MediaType.APPLICATION_JSON);
        Question question = new Question("Question1",
                "Most Popular Cloud Platform Today", Arrays.asList(
                "AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
        when(surveyService.retrieveQuestionByIdForSurvey("Survey1", "Question1")).thenReturn(question);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        String expectedResponse = """
                {
                    "id":"Question1",
                    "description":"Most Popular Cloud Platform Today",
                    "options":["AWS","Azure","Google Cloud","Oracle Cloud"],
                    "correctAnswer":"AWS"
                }
                """;
        MockHttpServletResponse response = mvcResult.getResponse();
        assertEquals(200, response.getStatus());
        JSONAssert.assertEquals(expectedResponse, response.getContentAsString(), false);
    }

    @Test
    public void addNewSurveyQuestion_baseScenario() throws Exception {
        String requestBody = """
            {
                "description": "Most Popular Programming language Today",
                "options":[
                    "Java",
                    "Python",
                    "Scala",
                    "Kotlin"
                ],
                "correctAnswer": "Java"
            }
            """;

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(QUESTIONS_URL)
                .accept(MediaType.APPLICATION_JSON).
                content(requestBody)
                .contentType(MediaType.APPLICATION_JSON);

        when(surveyService.addNewSurveyQuestion(anyString(), any())).thenReturn("newQuestionId");

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();

        assertEquals(201, response.getStatus());
        String expectedLocationHeader = "/surveys/Survey1/questions/newQuestionId";
        assertTrue(response.getHeader("Location").contains(expectedLocationHeader));


//        Question newQuestion = new Question("Question1",
//                "Most Popular Language", Arrays.asList(
//                "Java", "Scala", "Ruby", "Python"), "Python");
//
    }

    /*
      @RequestMapping(value = "/surveys/{surveyId}/questions", method = RequestMethod.POST)
    public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String surveyId, @RequestBody Question question) {
        String questionId = surveyService.addNewSurveyQuestion(surveyId, question);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{questionId}")
                .buildAndExpand(questionId)
                .toUri();
        return ResponseEntity.created(location).build();
    }
     */
}