package com.vp.app.roomservice.controller;

import com.vp.app.roomservice.dto.RoomDTO;
import com.vp.app.roomservice.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    //create room
    @PostMapping()
    public Mono<RoomDTO> createRoom(@RequestBody RoomDTO roomDTO) {
        // Implementation to create a room
        return roomService.createRoom(roomDTO);
    }

    //get room by id
    @GetMapping("/{id}")
    public Mono<RoomDTO> getRoomById(@PathVariable String id) {
        // Implementation to get a room by ID
        log.info("get room by id {}", id);
        return roomService.getRoomById(id);
    }

    //put mapping for update room
    @PutMapping("/{id}")
    public Mono<RoomDTO> updateRoom(@PathVariable String id, @RequestBody RoomDTO roomDTO) {
        // Implementation to update a room
        return roomService.updateRoom(id, roomDTO);
    }

    //patch mapping for update room
    @PatchMapping("/{id}")
    public Mono<RoomDTO> patchRoom(@PathVariable String id, @RequestBody RoomDTO roomDTO) {
        // Implementation to patch a room
        return roomService.patchRoom(id, roomDTO);
    }

    //delete room by id
    @DeleteMapping("/{id}")
    public Mono<Void> deleteRoom(@PathVariable String id) {
        // Implementation to delete a room by ID
        return roomService.deleteRoom(id);
    }

    //get all rooms
    @GetMapping
    public Flux<RoomDTO> findAllRooms() {
        // Implementation to get all rooms
        return roomService.findAllRooms();
    }

}
