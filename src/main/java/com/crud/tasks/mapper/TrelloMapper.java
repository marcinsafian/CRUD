package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrelloMapper {

    public List<TrelloBoard> mapToBoards(final List<TrelloBoardDto> trelloBoardDtos) {
        return trelloBoardDtos.stream()
                .map(trelloBoardDto -> new TrelloBoard(trelloBoardDto.getId(), trelloBoardDto.getName(),
                        mapToList(trelloBoardDto.getLists())))
                .collect(Collectors.toList());
    }

    public List<TrelloBoardDto> mapToBoardsDto(final List<TrelloBoard> trelloBoards) {
        return trelloBoards.stream()
                .map(trelloBoard -> new TrelloBoardDto(trelloBoard.getId(), trelloBoard.getName(), mapToListDto(trelloBoard.getLists())))
                .collect(Collectors.toList());
    }

    public List<TrelloList> mapToList(final List<TrelloListDto> trelloListDtos) {
        return trelloListDtos.stream()
                .map(trelloListDto -> new TrelloList(trelloListDto.getId(), trelloListDto.getName(), trelloListDto.isClosed()))
                .collect(Collectors.toList());
    }

    public List<TrelloListDto> mapToListDto(final List<TrelloList> trelloLists) {
        return trelloLists.stream()
                .map(trelloList -> new TrelloListDto(trelloList.getId(), trelloList.getName(), trelloList.isClosed()))
                .collect(Collectors.toList());
    }

    public TrelloCard mapToCard(final TrelloCardDto cardDto) {
        return new TrelloCard(cardDto.getName(), cardDto.getDescription(), cardDto.getPos(), cardDto.getListId());
    }

    public TrelloCardDto mapToCardDto(final TrelloCard card) {
        return new TrelloCardDto(card.getName(), card.getDescription(), card.getPos(), card.getListId());
    }
}