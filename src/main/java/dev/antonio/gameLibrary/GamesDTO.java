package dev.antonio.gameLibrary;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GamesDTO {
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
