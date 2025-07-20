package com.vp.app.roomservice.mapper;

import com.vp.app.roomservice.domain.Room;
import com.vp.app.roomservice.dto.RoomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    Room toEntity(RoomDTO roomDTO);

    RoomDTO toRoomDTO(Room room);

    @Mapping(target = "id", ignore = true)
    void updateRoomFromDto(RoomDTO dto, @MappingTarget Room entity);

    void patchRoomFromDto(RoomDTO dto, @MappingTarget Room entity);
}
