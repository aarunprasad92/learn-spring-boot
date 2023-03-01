package arp.project.spring.learnspringboot.survey;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIntegrationTest {
    private static String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/Question1";
    private static String QUESTIONS_URL = "/surveys/Survey1/questions";


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
        HttpHeaders headers = createHttpContentTypeAndAuthorizationHeaders();

        HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> responseEntity =
                restTemplate.exchange(SPECIFIC_QUESTION_URL, HttpMethod.GET, httpEntity, String.class);

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

    @Test
    public void addNewSurveyQuestion_baseScenario() {
        String body = """
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

        HttpHeaders headers = createHttpContentTypeAndAuthorizationHeaders();

        HttpEntity<String> httpEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity =
                restTemplate.exchange(QUESTIONS_URL, HttpMethod.POST, httpEntity, String.class);

        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
        String locationHeader = responseEntity.getHeaders().getLocation().toString();
        assertTrue(locationHeader.contains("/surveys/Survey1/questions"));

        //Delete the created resource
        ResponseEntity<String> responseEntityDelete =
                restTemplate.exchange(locationHeader, HttpMethod.DELETE, httpEntity, String.class);
        assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
    }

    private HttpHeaders createHttpContentTypeAndAuthorizationHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", "Basic " + performBasicAuthEncoding("arun", "dummy"));
        return headers;
    }

    String performBasicAuthEncoding(String username, String password) {
        String combined = username + ":" + password;
        byte[] encodedBytes = Base64.getEncoder().encode(combined.getBytes());
        return new String(encodedBytes);
    }
}