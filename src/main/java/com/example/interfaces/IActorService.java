package com.example.interfaces;

import com.example.model.Actor;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IActorService {
    List<Actor> getActors();
}
