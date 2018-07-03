package it.thimoty.matchapi.model;

import java.math.BigDecimal;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MatchEvent {
 
    @Id
    private ObjectId _id;
    private String name;
    private String description;
	private BigDecimal quote;
    
 
    public MatchEvent(String name, String description, BigDecimal quote) {
        this.name = name;
        this.description = description;
        this.quote = quote;
    }
    
    public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getQuote() {
		return quote;
	}

	public void setQuote(BigDecimal quote) {
		this.quote = quote;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
    	return this.description;
    }

	@Override
	public String toString() {
		return "MatchEvent [_id=" + _id + ", name=" + name + ", description=" + description + ", quote=" + quote + "]";
	}

	
    
}
 
