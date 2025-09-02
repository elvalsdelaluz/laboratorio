package mirobot;
import robocode.*;

public class Demoleitor extends JuniorRobot {
    private CombatStrategy strategy = new OffensiveStrategy();

    public void setStrategy(CombatStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void run() {
        setColors(purple, purple, purple, purple, purple);
        System.out.println("Arranca el juego...");
        turnTo(180);
        this.goTo(20,20);

        while (true) {
            // Elijo una estrategia en base a mi energia
            if (energy > 70) {
                setStrategy(new OffensiveStrategy());
            } else if (energy > 50) {
                setStrategy(new DefensiveStrategy());
            } else {
                setStrategy(new SurvivalStrategy());
            }
            //Escaneo el ring
            turnGunRight(360);
            turnTo(90);   // mirar al este
            ahead(200);   // avanzar
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

    void goTo(double targetX, double targetY) {
        // ejemplo: imprimir posición y heading actual
        System.out.println("El medio, a donde quiero ir -> X: " + targetX + " Y: " + targetY);
        System.out.println("Posición inicial -> X: " + robotX + " Y: " + robotY);
        System.out.println("Heading inicial: " + heading);

        double dx = targetX - robotX;  // diferencia en X
        double dy = targetY - robotY;  // diferencia en Y

        // Calcular ángulo absoluto hacia el objetivo
        int angleToTarget = (int) Math.toDegrees(Math.atan2(dx, dy));
        // Girar hacia ese ángulo
        turnTo(angleToTarget);

        // Calcular distancia al objetivo
        int distance = (int) Math.hypot(dx, dy);
        System.out.println("dx: " + dx + " dy: " + dy);
        System.out.println("Ángulo calculado: " + angleToTarget);
        System.out.println("Distancia calculada: " + distance);

        // Avanzar hasta el punto
        ahead(distance);

        System.out.println("Nueva posición -> X: " + robotX + " Y: " + robotY);
        System.out.println("Nuevo heading: " + heading);
    }
}
