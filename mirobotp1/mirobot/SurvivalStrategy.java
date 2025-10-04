package mirobot;

public class SurvivalStrategy extends CombatStrategy{
    @Override
    public void onScannedRobot(Demoleitor lulu) {
        System.out.println("Escanee un robot y le dispare, estoy en survival");
        // Apuntar el arma hacia el robot
        lulu.turnGunTo(lulu.scannedAngle);
        //Le sigo disparando
        //lulu.bearGunTo(lulu.hitRobotAngle);
        // Si está cerca disparo fuerte, si está lejos disparo suave
        if (lulu.scannedDistance < 150) {
            lulu.fire(3);
        } else {
            lulu.fire(1);
        }
    }

    @Override
    void onHitRobot(Demoleitor lulu) {
        System.out.println("Le pegue un tiro a un robot, estoy en survival");
        //Le sigo disparando
        lulu.turnGunTo(lulu.hitRobotAngle);
        lulu.fire(1);
    }

    @Override
    public void onHitByBullet(Demoleitor lulu){
        System.out.println("Me dispararon, vuelvo a 20,20; estoy en survival!");
        lulu.goTo(lulu.fieldWidth / 2, lulu.fieldHeight / 2);
        lulu.turnGunTo(lulu.hitByBulletAngle);
        int power;
        if (lulu.energy > 17) {
            power = 2;
            lulu.fire(power);
        } else {
            power = 1;
        }
        lulu.fire(power);
    }

    @Override
    public void onHitWall(Demoleitor lulu) {
        System.out.println("Choque, vuelvo a 20,20; estoy en supervivencia");
        lulu.goTo(lulu.fieldWidth / 2, lulu.fieldHeight / 2);
    }

}
