package com.vp.app.roomservice.repository;

import com.vp.app.roomservice.domain.Room;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends ReactiveMongoRepository<Room, String> {
}
