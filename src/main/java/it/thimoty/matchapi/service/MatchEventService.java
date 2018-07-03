package it.thimoty.matchapi.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import it.thimoty.matchapi.dao.MatchEventRepository;
import it.thimoty.matchapi.model.MatchEvent;


@Service
public class MatchEventService {
	
	@Autowired
    MatchEventRepository repository;
		
	public Iterable<MatchEvent> addMatchEvent(String newMatchEvent){
		
		ObjectNode node;
		try {
			node = new ObjectMapper().readValue(newMatchEvent, ObjectNode.class);
		
		String name = "";
		String description = "";
		String quote = "";
		if (node.has("name")) {
			name= node.get("name").asText();
		} 
		if (node.has("description")) {
			description= node.get("description").asText();
		} 
		if (node.has("quote")) {
			quote= node.get("quote").asText();
		} 
		
		MatchEvent newMatchEventObject = new MatchEvent(name, description, new BigDecimal(quote));
		
		System.out.println(":::service: " + newMatchEventObject);
		repository
			.save(newMatchEventObject); 
		
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAllMatchEvents();	
		
		
		
	}
	
	public Iterable<MatchEvent> getAllMatchEvents(){
		return repository.findAll();
		
	}
	
	public Optional<MatchEvent> getMatchEvent(String id){
		return repository.findById(id);
	}

	public void deleteMatchEvent(MatchEvent me) {
		repository.delete(me);
		
	}
	
	public void deleteMatchEventById(String id) {
		repository.deleteById(id);
		
	}

}
