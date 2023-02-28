package arp.project.spring.learnspringboot.survey;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIntegrationTest {
    private static String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/Question1";

    // used to fire the api request
    @Autowired
    private TestRestTemplate restTemplate;

    // text blocks very useful since java 15
    String str = """
            {
            "id": "Question1",
            "description": "Most Popular Cloud Platform Today",
            "options": [
            "AWS",
            "Azure",
            "Google Cloud",
            "Oracle Cloud"
            ],
            "correctAnswer": "AWS"
            }
            """;


    @Test
    void getQuestionByIdForSurvey_baseScenario() throws JSONException {
        ResponseEntity<String> responseEntity = restTemplate
                .withBasicAuth("arun", "dummy")
                .getForEntity(SPECIFIC_QUESTION_URL, String.class);
        String expectedResponse = """
                {"id":"Question1",
                "description":"Most Popular Cloud Platform Today",
                "correctAnswer":"AWS"}
                """;
        //check status code is 200
        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

        //check content type is application json
        assertEquals("application/json", responseEntity.getHeaders().getContentType().toString());

        //check actual response body
        JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
    }
}