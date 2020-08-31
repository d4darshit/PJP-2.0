package com.datetime.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.datetime.modal.DateTime;
import com.datetime.modal.DateTimeBO;
import com.datetime.modal.Session;
import com.datetime.repository.SessionRepository;

@Controller
public class DateTimeController {
	
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
		System.out.println(session_id);
		return "index.jsp";
	} 
	
	@GetMapping("/addDates") 
	public String addDates(@RequestParam String date1,@RequestParam String date2,String choice,ModelMap model) {
		DateTime result = dateModal.addTwoDates(new DateTime(date1),new DateTime( date2));
		query = new DateTime(date1) + " + " + new DateTime(date2);
		model.put("query", query);
		model.put("result", result);
		sessionRepository.save(new Session(session_id,date1,date2,query));
		
		return "result.jsp";
	}
	
	@GetMapping("/subtractDates")
	public String subtractDates(@RequestParam String date1,@RequestParam String date2,String choice,ModelMap model) {
		DateTime result = dateModal.subtractTwoDates(new DateTime(date1),new DateTime( date2));
		query = date1 + " - " + date2;
		model.put("query", query);
		model.put("result", result);
		sessionRepository.save(new Session(session_id,date1,result.getFormattedDate()));
		
		return "result.jsp";
	}
	@GetMapping("/addNDays")
	public String addNDays(@RequestParam String date1, @RequestParam int n, ModelMap model) {
		result = dateModal.addNDays(new DateTime(date1),n);
		query = "Add "+n+" Days to " + date1;
		model.put("query", query);
		model.put("result", result);
		sessionRepository.save(new Session(session_id,date1,query));
		return "result.jsp";
	}
	
	
	@GetMapping("/subtractNDays")
	public String subtractNDays(@RequestParam String date1, @RequestParam int n, ModelMap model) {
		result = dateModal.subtractNDays(new DateTime(date1),n);
		query = "Subtract "+n+" Days to "+date1;
		model.put("query", query);
		model.put("result", result);
		sessionRepository.save(new Session(session_id,date1,query));
		
		return "result.jsp";
	}
	
	@GetMapping("/addNWeeks")
	public String addNWeeks(@RequestParam String date1, @RequestParam int n, ModelMap model) {
		result = dateModal.addNWeeks(new DateTime(date1),n);
		query = "Add "+n+" Weeks to "+date1;
		model.put("query", query);
		model.put("result", result);
		sessionRepository.save(new Session(session_id,date1,query));
		return "result.jsp";
	}
	
	@GetMapping("/subtractNWeeks")
	public String subtractNWeeks(@RequestParam String date1, @RequestParam int n, ModelMap model) {
		result = dateModal.subtractNWeeks(new DateTime(date1),n);
		query = "Subtract "+n+" weeks to "+date1;
		model.put("query", query);
		model.put("result", result);
		sessionRepository.save(new Session(session_id,date1,query));
		return "result.jsp";
	}
	
	@GetMapping("/addNMonths")
	public String addNMonths(@RequestParam String date1, @RequestParam int n, ModelMap model) {
		result = dateModal.addNMonths(new DateTime(date1),n);
		query = "Add "+n+" Months to "+date1;
		model.put("query", query);
		model.put("result", result);
		sessionRepository.save(new Session(session_id,date1,query));
		return "result.jsp";
	}
	
	@GetMapping("/subtractNMonths")
	public String subtractNMonths(@RequestParam String date1, @RequestParam int n, ModelMap model) {
		result = dateModal.subtractNMonths(new DateTime(date1),n);
		query = "Subtract "+n+" Months to "+date1;
		model.put("query", query);
		model.put("result", result);
		sessionRepository.save(new Session(session_id,date1,query));
		return "result.jsp";
	}
	
	@GetMapping("/addNYears")
	public String addNyears(@RequestParam String date1, @RequestParam int n, ModelMap model) {
		result = dateModal.addNYears(new DateTime(date1),n);
		query = "Add "+n+" Years to "+date1;
		model.put("query", query);
		model.put("result", result);
		sessionRepository.save(new Session(session_id,date1,query));
		return "result.jsp";
	}
	
	@GetMapping("/subtractNYears")
	public String subtractNYears(@RequestParam String date1, @RequestParam int n, ModelMap model) {
		result = dateModal.subtractNYears(new DateTime(date1),n);
		query = "Subtracr "+n+" Years to "+date1;
		model.put("query", query);
		model.put("result", result);
		sessionRepository.save(new Session(session_id,date1,query));
		return "result.jsp";
	}
	
	@GetMapping("/phrase")
	public String phrase(@RequestParam String phrase,ModelMap model) {
		result = dateModal.enteringLanguagePhrase(phrase);
		query = phrase;
		model.put("query", query);
		model.put("result", result);
		sessionRepository.save(new Session(session_id,phrase));
		return "result.jsp";
	}
	
	@GetMapping("/history")
	public String showHistory(ModelMap model) {
		List<Session> session = sessionRepository.findAll();
		model.put("session", session);
		return "result.jsp";
		
	}
	
}

