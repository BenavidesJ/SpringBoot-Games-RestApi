package com.example.game_service_api.controller;

import com.example.game_service_api.commons.constants.ApiPathVariables;
import com.example.game_service_api.commons.entities.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathVariables.API_VERSION + ApiPathVariables.API_ROOT_ROUTE)
public interface GameApi {
    @PostMapping
    ResponseEntity<Game> saveGame(@RequestBody Game game);
    @GetMapping("/{id}")
    ResponseEntity<Game> getGameByID(@PathVariable String id);
    @GetMapping
    ResponseEntity<Object> getGames();
    @PutMapping
    ResponseEntity<Game> updateGame(@RequestBody Game updatedGame);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteGameById(@PathVariable String id);
}
