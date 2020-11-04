package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.controls.Direction;
import cegepst.engine.controls.MovementController;
import cegepst.engine.entities.ControllableEntity;

import java.awt.*;
import java.util.ArrayList;

public class Tank extends ControllableEntity {

    private int canonX;
    private int canonY;
    private int canonWidth;
    private int canonHeight;

    private ArrayList<Shell> explodedShells;
    private int fireCooldown = 0;

    public Tank(MovementController controller) {
        super(controller);
        setDimension(30, 30);
        setSpeed(2);
        teleport(100, 100);

    }

    @Override
    public void update() {
        super.update();
        moveAccordingToController();
        canonDirection();
        fireCooldown--;
        if (fireCooldown <= 0) {
            fireCooldown = 0;
        }
    }

    @Override
    public void draw(Buffer buffer) {
        if (hasMoved()) {
            drawHitBox(buffer);
        }
        buffer.drawRectangle(x, y, width, height, Color.GREEN);
        buffer.drawRectangle(canonX, canonY, canonWidth, canonHeight, Color.GREEN); //canon
    }

    public Shell fire() {
        fireCooldown = 50;
        return new Shell(this);
    }

    public boolean canFire() {
        return fireCooldown == 0;
    }

    private void canonDirection() {
        if (getDirection() == Direction.UP) {
            canonX = 12 + x;
            canonY = -10 + y;
            canonWidth = 5;
            canonHeight = 10;
        }
        if (getDirection() == Direction.DOWN) {
            canonX = 12 + x;
            canonY = 30 + y;
            canonWidth = 5;
            canonHeight = 10;
        }
        if (getDirection() == Direction.RIGHT) {
            canonX = 30 + x;
            canonY = 12 + y;
            canonWidth = 10;
            canonHeight = 5;
        }
        if (getDirection() == Direction.LEFT) {
            canonX = -10 + x;
            canonY = 12 + y;
            canonWidth = 10;
            canonHeight = 5;
        }
    }
}
