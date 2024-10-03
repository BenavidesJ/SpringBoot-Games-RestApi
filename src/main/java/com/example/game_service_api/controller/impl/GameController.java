package com.example.game_service_api.controller.impl;

import com.example.game_service_api.commons.entities.Game;
import com.example.game_service_api.controller.GameApi;
import com.example.game_service_api.services.impl.GameServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController implements GameApi {
    private final GameServiceImp gameService;

    public GameController(GameServiceImp gameService) {
        this.gameService = gameService;
    }

    @Override
    public ResponseEntity<Object> getGames(){
        Object gameRequestedList = this.gameService.getAllGames();
        return ResponseEntity.ok(gameRequestedList);
    }

    @Override
    public ResponseEntity<Game> saveGame(@RequestBody Game game){
        Game gameCreated = this.gameService.saveGame(game);
        return ResponseEntity.ok(gameCreated);
    }

    @Override
    public ResponseEntity<Game> getGameByID(String id) {
        Long gameID = Long.parseLong(id);
        Game gameRequested = this.gameService.getGameByID(gameID);
        return ResponseEntity.ok(gameRequested);
    }

    @Override
    public ResponseEntity<Game> updateGame(@RequestBody Game updatedGame) {
        Game game = this.gameService.updateGame(updatedGame);
        return ResponseEntity.ok(game);
    }

    @Override
    public ResponseEntity<Void> deleteGameById(@PathVariable String id) {
        Long gameID = Long.parseLong(id);
        this.gameService.deleteGame(gameID);
        return ResponseEntity.noContent().build();
    }
}
