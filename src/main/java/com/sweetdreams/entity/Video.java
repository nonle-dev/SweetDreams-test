package com.sweetdreams.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(catalog = "abc", name="Video")
public class Video implements Serializable{
	private static final long serialVersionUID = 1L;
    
	@Id
	@Column(name = "VideoId")
	private String videoId;
	
	@Column(name = "Active")
	private boolean active;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "Poster")
	private String poster;


	@Column(name = "Title")
	private String title;

	@Column(name = "Views")
	private String views;
 
	//Kết nối many to one với category
	@ManyToOne
	@JoinColumn(name = "CategoryId")
	private Category category;
}
