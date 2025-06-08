package com.vp.app.roomservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Data
@Setter
@Getter
public class RoomDTO {

    private String id;
    private String name;
    private Map<String, Object> attributes;

}
