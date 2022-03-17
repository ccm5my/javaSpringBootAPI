package com.cameron.interfaces;

import com.cameron.model.Actor;

import java.util.List;

public interface IActorService {
    List<Actor> getActors();

    void addNewActor(Actor actor);

    void updateNewActor(Actor actor);
}
