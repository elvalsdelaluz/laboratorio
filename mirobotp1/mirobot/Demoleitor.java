package mirobot;
import robocode.*;

public class Demoleitor extends JuniorRobot {
    private CombatStrategy strategy = new OffensiveStrategy();

    public void setStrategy(CombatStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void run() {
        setColors(purple, purple, purple, white, red);
        System.out.println("Arranca el juego...");
        while (true) {
            // Elijo una estrategia en base a mi energia
            if (this.energy > 70) {
                setStrategy(new OffensiveStrategy());
            } else if (this.energy > 50) {
                setStrategy(new DefensiveStrategy());
            } else {
                setStrategy(new SurvivalStrategy());
            }
            //Escaneo el ring
            turnGunRight(360);
            //Me retiro
            ahead(200);
        }
    }

    @Override
    public void onScannedRobot() {
        this.strategy.onScannedRobot(this);
    }

    @Override
    public void onHitByBullet() {
        this.strategy.onHitByBullet(this);
    }

    @Override
    public void onHitWall() {
        this.strategy.onHitWall(this);
    }

    @Override
    public void onHitRobot() {
        this.strategy.onHitRobot(this);
    }

    void goTo(double nuevaX, double nuevaY) {
        double dx = nuevaX - robotX;  // diferencia en X
        double dy = nuevaY - robotY;  // diferencia en Y
        // Calcular ángulo absoluto
        int angleToTarget = (int) Math.toDegrees(Math.atan2(dx, dy));
        // Girar hacia ese ángulo
        turnTo(angleToTarget);
        // Calcular distancia
        int distance = (int) Math.hypot(dx, dy);
        // Avanzar hasta el punto
        ahead(distance);
    }
}
