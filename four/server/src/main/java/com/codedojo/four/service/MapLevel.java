package com.codedojo.four.service;

import com.codedojo.four.model.Blindeer;
import com.codedojo.four.model.Move;

public interface MapLevel {

    boolean collision(Blindeer blindeer, Move move);

    int environment(Blindeer blindeer, Move move);

}
