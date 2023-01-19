package org.siit.week11.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book
{
    private int id;
    private String bookName;
    private int authorId;
}
