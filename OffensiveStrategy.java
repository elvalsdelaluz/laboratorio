package mirobot;

public class OffensiveStrategy extends CombatStrategy{

    @Override
    public void onScannedRobot(Demoleitor lulu) {
        System.out.println("Escanee un robot y le dispare, estoy en offensive");
        // Apuntar el arma hacia el robot
        lulu.turnGunTo(lulu.scannedAngle);
        // Si está cerca disparo fuerte, si está lejos disparo suave
        int power;
        if (lulu.scannedDistance < 200 && lulu.scannedVelocity == 0) {
            power = 3;
        } else if (lulu.scannedDistance < 200) {
            power = 2;
        } else {
            power = 1;
        }
        lulu.fire(power);
    }

    @Override
    public void onHitByBullet(Demoleitor lulu) {
        System.out.println("Me dispararonnnn!");
        //Le disparo y lo choco
        System.out.println("Mi heading es "+lulu.heading);
        System.out.println("El heading scanned al robot que me disparo es "+lulu.scannedBearing);
        //Apunto y disparo
        lulu.bearGunTo(lulu.scannedAngle);
        lulu.fire(2);
        //Choco si tengo más vida que ese robot
        if (lulu.energy > lulu.scannedBearing) {
            lulu.turnTo(lulu.scannedBearing);
            lulu.ahead(lulu.scannedDistance);
        }
        else {
            //-------------------------------------
            // Muevo el robot para esquivar
            lulu.turnRight(lulu.hitByBulletBearing);
            lulu.ahead(100);
            // Giro el arma hacia donde vino el disparo
        }
    }

    @Override
    public void onHitWall(Demoleitor lulu) {
        lulu.back(50); // retrocede un poco
        lulu.turnRight(90); // gira para salir paralelo a la pared
        lulu.ahead(100); // avanza lejos de la pared
        System.out.println("Me choque contra la pared, estoy en offensive");
    }

}
