package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.Game;

import java.util.ArrayList;

public class TankGame extends Game {

    private Tank tank;
    private GamePad gamePad;
    private ArrayList<Shell> shells;

    public TankGame() {
        shells = new ArrayList<>();
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
            shells.add(new Shell(tank.getDirection(), tank.getX(), tank.getY()));
        }
        for (Shell shell : shells) {
            shell.update();
        }
        tank.update();
    }

    @Override
    public void draw(Buffer buffer) {
        for (Shell shell : shells) {
            shell.draw(buffer);
        }
        tank.draw(buffer);
    }
}
