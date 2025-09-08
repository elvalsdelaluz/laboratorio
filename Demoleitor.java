package mirobot;
import robocode.*;

public class Demoleitor extends JuniorRobot {
    private CombatActions strategy = new OffensiveStrategy(this);   //COLOQUIO, alcanzaba con definirlo 1 vez sóla.
    private StrategicTactics entrenador = StrategicStrategy.MI_PRIMER_STRATEGIC_TACTICS;
    public void setStrategy(CombatActions strategy) {
        this.strategy = strategy;
    }

    @Override
    public void run() {
        setColors(purple, purple, purple, white, red);
        System.out.println("Arranca el juego...");
        while (true) {
            // Elijo una estrategia en base a mi energia
            if (this.energy > 90) {                             //COLOQUIO, esto era para la segunda
                setStrategy(new OffensiveStrategy(this));           //para la segunda deberia considerar más cosas
            } else if (this.energy > 80) {                      //como la cantidad de enemigos, mi energia (ya lo tengo)
                setStrategy(new DefensiveStrategy(this));
            } else {
                setStrategy(new SurvivalStrategy(this));
            }
            //Escaneo el ring
            turnGunRight(360);
            //Me retiro
            ahead(200);
        }
    }

    @Override  //COLOQUIO, esta bien que le mande a this por parametro
    public void onScannedRobot() {this.strategy.onScannedRobot();}

    @Override
    public void onHitByBullet() {
        this.strategy.onHitByBullet();
    }

    @Override
    public void onHitWall() {
        this.strategy.onHitWall();
    }

    @Override
    public void onHitRobot() {
        this.strategy.onHitRobot();
    }

}
