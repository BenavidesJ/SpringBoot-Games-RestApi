package com.example.game_service_api.services;

import com.example.game_service_api.commons.entities.Game;

import java.util.List;

public interface GameService {
    Game saveGame(Game gameRequest);
    Game getGameByID(Long id);
    List<Game> getAllGames();
    Game updateGame(Game updatedGame);
    void deleteGame(Long id);
}
