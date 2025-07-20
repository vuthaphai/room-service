package com.vp.app.roomservice.service;

import com.vp.app.roomservice.dto.RoomDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RoomService {

    Mono<RoomDTO> createRoom(RoomDTO roomDTO);

    Mono<RoomDTO> getRoomById(String roomId);

    Mono<RoomDTO> updateRoom(String roomId, RoomDTO roomDTO);

    //patch mapping for update room
    Mono<RoomDTO> patchRoom(String roomId, RoomDTO roomDTO);

    Mono<Void> deleteRoom(String roomId);

    Flux<RoomDTO> findAllRooms();

    Flux<RoomDTO> findRoomsByName(String name);

    Flux<RoomDTO> findRoomsByAttributesWidth(int width);

    Flux<RoomDTO> findRoomsByAttributesWidthAndLength(int width, int length);
}
