package mirobot;
import robocode.*;

public class Labubu extends JuniorRobot {
    private CoachTactics coach = CoachStrategy.HEAD_COACH_STRATEGIC_TACTICS;

    @Override
    public void run() {
        setColors(purple, purple, purple, white, red);
        System.out.println("Arranca el juego...");
        while (true) {
            //Escaneo el ring
            turnGunRight(360);
            //Me retiro
            ahead(200);
        }
    }

    @Override  //COLOQUIO, esta bien que le mande a this por parametro
    public void onScannedRobot() {
        this.coach.getCombatStrategy(this).onScannedRobot();
    }

    @Override
    public void onHitByBullet() {
        this.coach.getCombatStrategy(this).onHitByBullet();
    }

    @Override
    public void onHitWall() {
        this.coach.getCombatStrategy(this).onHitWall();
    }

    @Override
    public void onHitRobot() {
        this.coach.getCombatStrategy(this).onHitRobot();
    }

}
