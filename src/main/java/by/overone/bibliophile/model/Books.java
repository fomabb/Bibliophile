package by.overone.bibliophile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    private long idBook;
    private String titleBook;
    private Genre genreBook;
    private String author;
    private long price;
}
