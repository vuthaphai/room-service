package com.vp.app.roomservice.service.impl;

import com.vp.app.roomservice.domain.Room;
import com.vp.app.roomservice.dto.RoomDTO;
import com.vp.app.roomservice.mapper.RoomMapper;
import com.vp.app.roomservice.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoomServiceImplTest {

    @Mock
    RoomRepository roomRepository;

    @Mock
    RoomMapper roomMapper;

    @InjectMocks
    RoomServiceImpl roomService;

    @Test
    void createRoom() {
        //given
        Room room = new Room();
        room.setId("683be10d51a716a4ed8f28b0");
        room.setName("Luxary room");
        when(roomRepository.save(room)).thenReturn(Mono.just(room));
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId("683be10d51a716a4ed8f28b0");
        roomDTO.setName("Luxary room");
        when(roomMapper.toEntity(roomDTO)).thenReturn(room);
        when(roomMapper.toRoomDTO(room)).thenReturn(roomDTO);

        //when
        Mono<RoomDTO> result = roomService.createRoom(roomDTO);

        //then
        result.subscribe(dto -> {
            assertNotNull(dto);
            assertEquals("Luxary room", dto.getName());
            assertEquals("683be10d51a716a4ed8f28b0", dto.getId());
        });
    }

    @Test
    void getRoomById() {
        //given
        Room room = new Room();
        room.setId("683be10d51a716a4ed8f28b0");
        room.setName("Luxary room");
        when(roomRepository.findById("683be10d51a716a4ed8f28b0")).thenReturn(Mono.just(room));
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId("683be10d51a716a4ed8f28b0");
        roomDTO.setName("Luxary room");

        //when
        Mono<RoomDTO> result = roomService.getRoomById("683be10d51a716a4ed8f28b0");
        //then
        result.subscribe(dto -> {
            assertNotNull(dto);
            assertEquals("Luxary ", dto.getName());
        });
    }

    @Test
    void updateRoom() {
        //given
        Room room = new Room();
        room.setId("683be10d51a716a4ed8f28b0");
        room.setName("Luxary room");
        when(roomRepository.findById("683be10d51a716a4ed8f28b0")).thenReturn(Mono.just(room));
        //when
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId("683be10d51a716a4ed8f28b0");
        roomDTO.setName("Updated Luxary room");
        when(roomMapper.toRoomDTO(room)).thenReturn(roomDTO);
        when(roomRepository.save(room)).thenReturn(Mono.just(room));
        Mono<RoomDTO> result = roomService.updateRoom("683be10d51a716a4ed8f28b0", roomDTO);
        //then
        result.subscribe(dto -> {
            assertNotNull(dto);
            assertEquals("Updated Luxary room", dto.getName());
            assertEquals("683be10d51a716a4ed8f28b0", dto.getId());
        });
    }

    @Test
    void patchRoom() {
        //given
        Room room = new Room();
        room.setId("683be10d51a716a4ed8f28b0");
        room.setName("Luxary room");
        when(roomRepository.findById("683be10d51a716a4ed8f28b0")).thenReturn(Mono.just(room));
        //when
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId("683be10d51a716a4ed8f28b0");
        roomDTO.setName("Patched Luxary room");
        when(roomMapper.toRoomDTO(room)).thenReturn(roomDTO);
        when(roomRepository.save(room)).thenReturn(Mono.just(room));
        Mono<RoomDTO> result = roomService.patchRoom("683be10d51a716a4ed8f28b0", roomDTO);
        //then
        result.subscribe(dto -> {
            assertNotNull(dto);
            assertEquals("Patched Luxary room", dto.getName());
            assertEquals("683be10d51a716a4ed8f28b0", dto.getId());
        });
    }

    @Test
    void deleteRoom() {
        //given
        String roomId = "683be10d51a716a4ed8f28b0";
        when(roomRepository.deleteById(roomId)).thenReturn(Mono.empty());
        //when
        Mono<Void> result = roomService.deleteRoom(roomId);
        //then
        result.subscribe(aVoid -> assertNotNull(aVoid));
    }

    @Test
    void findAllRooms() {
        //given
        Room room = new Room();
        room.setId("683be10d51a716a4ed8f28b0");
        room.setName("Luxary room");
        when(roomRepository.findAll()).thenReturn(Flux.just(room));
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId("683be10d51a716a4ed8f28b0");
        roomDTO.setName("Luxary room");
        when(roomMapper.toRoomDTO(room)).thenReturn(roomDTO);

        //when
        Flux<RoomDTO> result = roomService.findAllRooms();

        //then
        result.subscribe(dto -> {
            assertNotNull(dto);
            assertEquals("Luxary room", dto.getName());
            assertEquals("683be10d51a716a4ed8f28b0", dto.getId());
        });
    }
}