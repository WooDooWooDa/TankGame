package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.controls.MovementController;
import cegepst.engine.entities.ControllableEntity;

import java.awt.*;

public class Tank extends ControllableEntity {

    public Tank(MovementController controller) {
        super(controller);
        setDimension(30, 30);
        setSpeed(2);
        teleport(100, 100);
    }

    @Override
    public void update() {
        moveAccordingToController();
    }

    @Override
    public void draw(Buffer buffer) {
        buffer.drawRectangle(x, y, width, height, Color.GREEN);
    }
}
