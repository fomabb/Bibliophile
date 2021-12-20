package by.overone.bibliophile.dto;

import by.overone.bibliophile.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDataDTO {
    private long idBook;
    private String titleBook;
    private Genre genreBook;
    private String author;
    private long price;
}
