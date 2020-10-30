package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.controls.Direction;
import cegepst.engine.entities.MovableEntity;

import java.awt.*;

public class Shell extends MovableEntity {

    public Shell(Direction direction, int x, int y) {
        setDirection(direction);
        teleport(x, y);
        setDimension(5,5);
        setSpeed(5);
    }

    @Override
    public void update() {
        move(getDirection());
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.GRAY);
    }
}
