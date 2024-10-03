package com.example.game_service_api.services.impl;

import com.example.game_service_api.commons.entities.Game;
import com.example.game_service_api.commons.exceptions.GameException;
import com.example.game_service_api.repositories.GameRepository;
import com.example.game_service_api.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImp implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImp(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game saveGame(Game gameRequest) {
        Game gameCreatedInDB = this.gameRepository.save(gameRequest);
        return gameCreatedInDB;
    }

    @Override
    public Game getGameByID(Long id) {
        Game gameFoundInDB = this.gameRepository.findById(id).orElseThrow(
                () -> new GameException(HttpStatus.NOT_FOUND,"Game with id: " + id + " not found!")
        );
        return gameFoundInDB;
    }
    @Override
    public List<Game> getAllGames() {
        List<Game> games = this.gameRepository.findAll();
        return games;
    }
    @Override
    public Game updateGame(Game updatedGame) {
        Long gameToUpdateID = updatedGame.getId();
        if (!this.gameRepository.existsById(gameToUpdateID)){
            throw new GameException(HttpStatus.NOT_FOUND,"Game with id: " + gameToUpdateID + " not found!");
        }

        return this.gameRepository.save(updatedGame);
    }
    @Override
    public void deleteGame(Long id) {
        Boolean gameToDeleteID = this.gameRepository.existsById(id);
        if (!gameToDeleteID) {
            throw new GameException(HttpStatus.NOT_FOUND,"Game with id: " + id + " not found!");
        }

        this.gameRepository.deleteById(id);
    }

}
