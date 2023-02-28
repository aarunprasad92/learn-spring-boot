package arp.project.spring.learnspringboot.survey;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class SurveyController {

    private SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @RequestMapping("/surveys")
    public List<Survey> getSurveys() {
        return surveyService.retrieveAllSurveys();
    }

    @RequestMapping("/surveys/{surveyId}")
    public Survey getSurvey(@PathVariable String surveyId) {
        Survey survey = surveyService.retrieveSurvey(surveyId);
        if(survey == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return survey;
    }

    @RequestMapping("/surveys/{surveyId}/questions")
    public List<Question> getQuestionsForSurvey(@PathVariable String surveyId) {
        List<Question> surveyQuestions = surveyService.retrieveSurveyQuestions(surveyId);
        if(surveyQuestions == null || surveyQuestions.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return surveyQuestions;
    }

    @RequestMapping("/surveys/{surveyId}/questions/{questionId}")
    public Question getQuestionByIdForSurvey(@PathVariable String surveyId, @PathVariable String questionId) {
        Question question = surveyService.retrieveQuestionByIdForSurvey(surveyId, questionId);
        if(question == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return question;
    }

    @RequestMapping(value = "/surveys/{surveyId}/questions", method = RequestMethod.POST)
    public void addNewSurveyQuestion(@PathVariable String surveyId, @RequestBody Question question) {
        surveyService.addNewSurveyQuestion(surveyId, question);
    }
}
