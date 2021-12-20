package by.overone.bibliophile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private long id;
    private String title;
    private long customersID;
    private long employeeID;
    private long[] books;
}
