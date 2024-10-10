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
        return this.gameRepository.save(gameRequest);
    }

    @Override
    public Game getGameByID(Long id) {
        return this.gameRepository
                .findById(id)
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND,"Game with id: " + id + " not found!"));
    }
    @Override
    public List<Game> getAllGames() {
        return this.gameRepository.findAll();
    }
    @Override
    public Game updateGame(Game updatedGame) {
        return this.gameRepository.save(updatedGame);
    }
    @Override
    public void deleteGame(Long id) {
        this.gameRepository.deleteById(id);
    }

}
