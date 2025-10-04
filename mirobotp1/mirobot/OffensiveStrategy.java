package mirobot;

public class OffensiveStrategy extends CombatStrategy{

    @Override
    public void onScannedRobot(Demoleitor lulu) {
        System.out.println("Escanee un robot y le dispare, estoy en offensive");
        //Apunto el arma hacia el robot
        //lulu.turnGunTo(lulu.scannedBearing);
        //lulu.bearGunTo(lulu.scannedBearing);
        lulu.turnGunTo(lulu.scannedAngle);
        //Le disparo
        int power;
        if (lulu.scannedDistance < 120 || lulu.scannedVelocity == 0) {
            power = 3;
        } else if (lulu.scannedDistance < 200) {
            power = 2;
        } else {
            power = 1;
        }
        lulu.fire(power);
    }

    @Override
    void onHitRobot(Demoleitor lulu) {
        System.out.println("LE DISPAREE a un robot esto en offensive");
        //Le sigo disparando
        lulu.turnGunTo(lulu.hitRobotAngle);
        lulu.fire(3);
    }

    @Override
    public void onHitByBullet(Demoleitor lulu) {
        System.out.println("Me dispararonnnn, estoy en offensive!");
        //Le disparo
        lulu.turnGunTo(lulu.hitByBulletAngle);
        lulu.fire(3);
        //Si no tengo energia para embestirlo me voy
        System.out.println("HDSKFJHASDJFSHKDFH SE SUPONE QUE LO ENVISTO"+lulu.hitByBulletBearing);
        lulu.turnRight(lulu.hitByBulletBearing);
        lulu.ahead(100);

        System.out.println("Dispare con potencia "+ 3);
    }

    @Override
    public void onHitWall(Demoleitor lulu) {
        //lulu.back(50); // retrocede un poco
        // lulu.turnRight(90); // gira para salir paralelo a la pared
       // lulu.ahead(100); // avanza lejos de la pared
        System.out.println("Me choque contra la pared, estoy en offensive");
        lulu.turnTo(lulu.hitWallAngle+90);
        lulu.back(300);
    }

}
