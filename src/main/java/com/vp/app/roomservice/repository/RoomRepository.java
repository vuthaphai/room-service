package com.vp.app.roomservice.repository;

import com.vp.app.roomservice.domain.Room;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Query;
import reactor.core.publisher.Flux;

public interface RoomRepository extends ReactiveMongoRepository<Room, String> {
    Flux<Room> findByName(String name);

    @Query("{ 'attributes.width': ?0 }")
    Flux<Room> findByAttributesWidth(int width);

    @Query("{ 'attributes.width': ?0, 'attributes.length': ?1 }")
    Flux<Room> findByAttributesWidthAndLength(int width, int length);
}
