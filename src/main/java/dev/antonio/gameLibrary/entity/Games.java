package dev.antonio.gameLibrary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "games", language = "java")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Games {
    @Id
    private ObjectId id;
    private String name;
    private String description;
    private List<String> categories;
    private Double price;
    private Integer rating;
    private Date release_date;
    private String developer;
    private String publisher;
    private String cover_image;
}
