package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.controls.Direction;
import cegepst.engine.controls.MovementController;
import cegepst.engine.entities.ControllableEntity;

import java.awt.*;

public class Tank extends ControllableEntity {

    private int canonX;
    private int canonY;
    private int canonWidth;
    private int canonHeight;

    public Tank(MovementController controller) {
        super(controller);
        setDimension(30, 30);
        setSpeed(2);
        teleport(100, 100);
    }

    @Override
    public void update() {
        moveAccordingToController();
        canonDirection();
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.GREEN);
        buffer.drawRectangle(x + canonX, y + canonY, canonWidth, canonHeight, Color.GREEN); //canon
    }

    private void canonDirection() {
        switch (getDirection()) {
            case UP:
                canonX = 12;
                canonY = -10;
                canonWidth = 5;
                canonHeight = 10;
        }
        if (getDirection() == Direction.DOWN) {
            canonX = 12;
            canonY = 30;
            canonWidth = 5;
            canonHeight = 10;
        }
        if (getDirection() == Direction.RIGHT) {
            canonX = 30;
            canonY = 12;
            canonWidth = 10;
            canonHeight = 5;
        }
        if (getDirection() == Direction.LEFT) {
            canonX = -10;
            canonY = 12;
            canonWidth = 10;
            canonHeight = 5;
        }
    }
}
