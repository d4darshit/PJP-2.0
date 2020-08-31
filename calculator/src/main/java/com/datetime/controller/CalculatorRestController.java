package com.datetime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datetime.modal.DateTime;
import com.datetime.modal.DateTimeBO;
import com.datetime.modal.Session;
import com.datetime.repository.SessionRepository;


@RestController
@RequestMapping("/api")
public class CalculatorRestController {
	@Autowired
	DateTimeBO dateModal;
	@Autowired
	SessionRepository sessionRepository;

	Long session_id =(long) 1;
	
	List<Long> allSession;
	
	private DateTime result;
	private String query;
	@GetMapping("/")
	public String mainPage() {
		
		session_id = sessionRepository.findSessionId()+1;
		return "hello user";
	} 
	
	@GetMapping("/addDates")
	public DateTime addDates(@RequestParam String date1,@RequestParam String date2,String choice) {
		DateTime result = dateModal.addTwoDates(new DateTime(date1),new DateTime( date2));
		sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		
		return result;
	}
	
	@GetMapping("/subtractDates")
	public DateTime subtractDates(@RequestParam String date1,@RequestParam String date2,String choice,ModelMap model) {
		DateTime result = dateModal.subtractTwoDates(new DateTime(date1),new DateTime( date2));
		sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		
		return result;
	}
	@GetMapping("/addNDays")
	public DateTime addNDays(@RequestParam String date1, @RequestParam int n, ModelMap model) {
		result = dateModal.addNDays(new DateTime(date1),n);
		sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		return result;
	}
	
	
	@GetMapping("/subtractNDays")
	public DateTime subtractNDays(@RequestParam String date1, @RequestParam int n, ModelMap model) {
		result = dateModal.subtractNDays(new DateTime(date1),n);
		
		sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		
		return result;
	}
	
	@GetMapping("/addNWeeks")
	public String addNWeeks(@RequestParam String date1, @RequestParam int n, ModelMap model) {
		result = dateModal.addNWeeks(new DateTime(date1),n);
		query = "Add "+n+" Weeks to "+date1;
		model.put("query", query);
		model.put("result", result);
		sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		return "result.jsp";
	}
	
	@GetMapping("/subtractNWeeks")
	public String subtractNWeeks(@RequestParam String date1, @RequestParam int n, ModelMap model) {
		result = dateModal.subtractNWeeks(new DateTime(date1),n);
		query = "Subtract "+n+" weeks to "+date1;
		model.put("query", query);
		model.put("result", result);
		sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		return "result.jsp";
	}
	
	@GetMapping("/addNMonths")
	public DateTime addNMonths(@RequestParam String date1, @RequestParam int n, ModelMap model) {
		result = dateModal.addNMonths(new DateTime(date1),n);
		sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		return result;
	}
	
	@GetMapping("/subtractNMonths")
	public DateTime subtractNMonths(@RequestParam String date1, @RequestParam int n, ModelMap model) {
		result = dateModal.subtractNMonths(new DateTime(date1),n);
		sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		return result;
	}
	
	@GetMapping("/addNYears")
	public DateTime addNyears(@RequestParam String date1, @RequestParam int n, ModelMap model) {
		result = dateModal.addNYears(new DateTime(date1),n);
		sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		return result;
	}
	
	@GetMapping("/subtractNYears")
	public DateTime subtractNYears(@RequestParam String date1, @RequestParam int n, ModelMap model) {
		result = dateModal.subtractNYears(new DateTime(date1),n);
		sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		return result;
	}
	
	@GetMapping("/phrase")
	public DateTime phrase(@RequestParam String phrase,ModelMap model) {
		result = dateModal.enteringLanguagePhrase(phrase);
		return result;
	}
	
	@GetMapping("/history")
	public List<Session> showHistory(ModelMap model) {
		List<Session> session = sessionRepository.findAll();
		model.put("session", session);
		return  session;
		
	}
}
