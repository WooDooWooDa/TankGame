package cegepst;

import cegepst.engine.Buffer;
import cegepst.engine.CollidableRepository;
import cegepst.engine.Game;
import cegepst.engine.entities.StaticEntity;

import javax.swing.plaf.basic.BasicRadioButtonUI;
import java.util.ArrayList;
import java.util.Random;


public class TankGame extends Game {

    private Tank tank;
    private GamePad gamePad;
    private ArrayList<Brick> bricks;
    private ArrayList<Shell> shells;

    public TankGame() {
        bricks = new ArrayList<>();
        shells = new ArrayList<>();
        gamePad = new GamePad();
        tank = new Tank(gamePad);
        bricks.add(new Brick(500, 100));
        bricks.add(new Brick(500, 116));
        bricks.add(new Brick(500, 132));
        bricks.add(new Brick(500, 148));
        bricks.add(new Brick(500, 164));
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
        if (gamePad.isFirePressed() && tank.canFire()) {
            shells.add(tank.fire());
        }
        tank.update();
        ArrayList<StaticEntity> killedEntities = new ArrayList<>();
        for (Shell shell : shells) {
            shell.update();
            for (Brick brick : bricks) {
                if (shell.hitBoxIntersectWith(brick)) {
                    killedEntities.add(shell);
                    killedEntities.add(brick);
                }
            }
        }
        if (!killedEntities.isEmpty()) {
            for (StaticEntity killedElement : killedEntities) {
                if (killedElement instanceof Brick) {
                    bricks.remove(killedElement);
                } else if (killedElement instanceof Shell) {
                    shells.remove(killedElement);
                }
                CollidableRepository.getInstance().unregisterEntity(killedElement);
            }
            Random random = new Random();
            bricks.add(new Brick(random.nextInt(800), random.nextInt(600)));
        }
    }

    @Override
    public void draw(Buffer buffer) {
        for (Brick brick : bricks) {
            brick.draw(buffer);
        }
        for (Shell shell : shells) {
            shell.draw(buffer);
        }
        tank.draw(buffer);
    }
}
