package ru.gb.news.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class AddNews {

    private String shortDescription;

    private String description;

    private LocalDate createDate;

    private Status status = Status.Active;
}
