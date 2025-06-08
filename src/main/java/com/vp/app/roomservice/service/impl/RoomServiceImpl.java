package com.vp.app.roomservice.service.impl;

import com.vp.app.roomservice.domain.Room;
import com.vp.app.roomservice.dto.RoomDTO;
import com.vp.app.roomservice.mapper.RoomMapper;
import com.vp.app.roomservice.repository.RoomRepository;
import com.vp.app.roomservice.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public Mono<RoomDTO> createRoom(RoomDTO roomDTO) {
        log.debug("Creating room: {}", roomDTO);
        Room room = roomMapper.toEntity(roomDTO);
        return roomRepository.save(room)
                .doOnSuccess(saved -> log.info("Room saved room {}", saved)) // Log the saved room
                .map(roomMapper::toRoomDTO);


    }

    @Override
    public Mono<RoomDTO> getRoomById(String roomId) {
        // Implementation logic for retrieving a room by ID
        log.debug("Retrieving room by ID: {}", roomId);
        return roomRepository.findById(roomId)
                .doOnNext(room -> log.info("Room found room {}", room))
                .doOnSuccess(room -> log.info("Room found room {}", room))
                .map(roomMapper::toRoomDTO);

    }

    @Override
    public Mono<RoomDTO> updateRoom(String roomId, RoomDTO roomDTO) {
        log.debug("Updating room: {}", roomDTO);
        return roomRepository.findById(roomId)
                .flatMap(existingRoom -> {
                    roomMapper.updateRoomFromDto(roomDTO, existingRoom);
                    return roomRepository.save(existingRoom);
                })
                .map(roomMapper::toRoomDTO)
                .doOnSuccess(updatedRoomDTO -> log.info("Room updated: {}", updatedRoomDTO));
    }

    @Override
    public Mono<RoomDTO> patchRoom(String roomId, RoomDTO roomDTO) {
        log.debug("Partially updating room: {}", roomDTO);
        return roomRepository.findById(roomId)
                .flatMap(existingRoom -> {
                    roomMapper.patchRoomFromDto(roomDTO, existingRoom);
                    return roomRepository.save(existingRoom);
                })
                .map(roomMapper::toRoomDTO)
                .doOnSuccess(updatedRoomDTO -> log.info("Room partially updated: {}", updatedRoomDTO));
    }

    @Override
    public Mono<Void> deleteRoom(String roomId) {
        // Implementation logic for deleting a room
        log.debug("Deleting room with ID: {}", roomId);
        return roomRepository.deleteById(roomId)
                .doOnSuccess(aVoid -> log.info("Room deleted with ID: {}", roomId))
                .then();
    }

    @Override
    public Flux<RoomDTO> findAllRooms() {
        // Implementation logic for finding all rooms
        log.debug("Finding all rooms");
        return roomRepository.findAll()
                .doOnNext(room -> log.info("Room found room {}", room))
                .map(roomMapper::toRoomDTO);
    }
}
