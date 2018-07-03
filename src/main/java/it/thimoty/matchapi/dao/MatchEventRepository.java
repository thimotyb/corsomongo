package it.thimoty.matchapi.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.thimoty.matchapi.model.MatchEvent;


public interface MatchEventRepository extends CrudRepository<MatchEvent, String> {

	List<MatchEvent> findByName(String name);

}
