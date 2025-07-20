package com.vp.app.roomservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class RoomFilterDTO {
    @Schema(description = "Filter by floor number", example = "3")
    private Integer floor;
    private String name;
    private String type;
    private Double price;
    private Double priceMin;
    private Double priceMax;
    private String priceOp;

    private int size = 10;
    private int page = 0;

    @Schema(description = "Sort by field name (ex: name, floor)", example = "name")
    private String sortBy;

    @Schema(description = "Sort direction: asc or desc", example = "asc")
    private String direction;
}
