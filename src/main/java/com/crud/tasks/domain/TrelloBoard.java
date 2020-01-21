package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class TrelloBoard {
    private String id;
    private String name;
    private List<TrelloList>lists;
}
