package mirobot;

public class SurvivalStrategy extends CombatStrategy{
    @Override
    public void onScannedRobot(Demoleitor lulu) {
        System.out.println("Escanee un robot y le dispare, estoy en survival");
        // Apuntar el arma hacia el robot
        lulu.turnGunTo(lulu.scannedAngle);
        // Si está cerca disparo fuerte, si está lejos disparo suave
        if (lulu.scannedDistance < 200) {
            lulu.fire(3);
        } else {
            lulu.fire(1);
        }
    }

    @Override
    public void onHitByBullet(Demoleitor lulu){
        System.out.println("Me dispararon");
        lulu.goTo(lulu.fieldWidth / 2, lulu.fieldHeight / 2);
    }

    @Override
    public void onHitWall(Demoleitor lulu) {
        System.out.println("estoy en supervivencia");
        lulu.goTo(lulu.fieldWidth / 2, lulu.fieldHeight / 2);
    }

}
