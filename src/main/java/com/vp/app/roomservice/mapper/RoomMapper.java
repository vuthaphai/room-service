package com.vp.app.roomservice.mapper;

import com.vp.app.roomservice.domain.Room;
import com.vp.app.roomservice.dto.RoomDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    Room toEntity(RoomDTO roomDTO);

    RoomDTO toRoomDTO(Room room);


}
