package by.overone.bibliophile.dto;

import by.overone.bibliophile.model.Books;
import by.overone.bibliophile.model.Genre;
import by.overone.bibliophile.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDataDTO extends Books {
    private long idBook;
    private String titleBook;
    private Genre genreBook;
    private String author;
    private long price;
    private Status status;
}
