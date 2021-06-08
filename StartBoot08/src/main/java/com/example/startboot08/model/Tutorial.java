package com.example.startboot08.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "tutorials")
public class Tutorial {
	@Id
	private String id;

	private String title;
	private String description;
	private boolean published;

	public Tutorial(String title, String description, boolean published) {
		this.title = title;
		this.description = description;
		this.published = published;
	}

	@Override
	public String toString() {
		return "Tutorial{" + "id='" + id + '\'' + ", title='" + title + '\'' + ", description='" + description + '\''
				+ ", published=" + published + '}';
	}

}
