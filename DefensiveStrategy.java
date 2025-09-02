package mirobot;

public class DefensiveStrategy extends CombatStrategy{
    @Override
    public void onScannedRobot(Demoleitor lulu) {
        System.out.println("Escanee un robot....");
        lulu.turnGunTo(lulu.scannedAngle);
        if (lulu.scannedVelocity == 0 || lulu.scannedDistance < 200) {
            lulu.fire(2);
        }
        else{
            lulu.fire(0.1);
        }
    }

    @Override
    public void onHitByBullet(Demoleitor lulu){
        System.out.println("Me dispararon!!!");
        lulu.turnGunTo(lulu.hitByBulletAngle);
        if (lulu.scannedVelocity == 0 || lulu.scannedDistance < 200) {
            lulu.fire(2);
        }
        else{
            lulu.fire(0.1);
        }
        lulu.turnTo(lulu.heading + 90);
        lulu.ahead(100);
    }

    @Override
    public void onHitWall(Demoleitor lulu) {
        System.out.println("estoy en defence");
        lulu.turnTo (lulu.hitWallAngle + 90);
        lulu.ahead(400);
    }
}
