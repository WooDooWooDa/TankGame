package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.Game;

import java.util.ArrayList;

public class TankGame extends Game {

    private Tank tank;
    private GamePad gamePad;

    public TankGame() {
        gamePad = new GamePad();
        tank = new Tank(gamePad);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void conclude() {

    }

    @Override
    public void update() {
        if (gamePad.isQuitPressed()) {
            super.stop();
        }
        if (gamePad.isFirePressed()) {
            tank.shot();
        }
        tank.update();
    }

    @Override
    public void draw(Buffer buffer) {
        tank.draw(buffer);
    }
}
