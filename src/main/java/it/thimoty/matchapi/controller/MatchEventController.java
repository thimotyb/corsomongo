package it.thimoty.matchapi.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.thimoty.matchapi.model.MatchEvent;
import it.thimoty.matchapi.service.MatchEventService;


 
@RestController
@RequestMapping(value="/api/match")
public class MatchEventController {
	
	@Autowired
	MatchEventService matchEventService;
	
	private static final Logger log = LoggerFactory.getLogger(MatchEventController.class);
	
	
	//GET-A-MATCH-EVENT METHOD
	 @GetMapping(value = "/matches/{id}", headers = "Accept=application/json")
	 @Produces({MediaType.APPLICATION_JSON })
	 public ResponseEntity<MatchEvent> getMatchById(@PathVariable(value = "id") String id) {
	        return matchEventService.getMatchEvent(id)
	                .map(savedMatchEvent -> ResponseEntity.ok(savedMatchEvent))
	                .orElse(ResponseEntity.notFound().build());
	    }
	 
	 
	//GET-ALL-MATCH-EVENTS METHOD
	 @GetMapping("/matches")
    public Iterable<MatchEvent> getAllMatches() {
        return matchEventService.getAllMatchEvents();
    }
 
	//POST-A-MATCH-EVENT METHOD
	 @PostMapping(value = "/matches", headers = "Accept=application/json")
	 @Consumes({MediaType.APPLICATION_JSON})
	 @Produces({MediaType.APPLICATION_JSON })
	 public void addMatchEvent(@Valid @RequestBody String newMatchEvent) {
		 log.info("processing message = '{}'", newMatchEvent);
		 matchEventService.addMatchEvent(newMatchEvent);
		 log.info("message processed = '{}'", newMatchEvent);
		 
	 }

}