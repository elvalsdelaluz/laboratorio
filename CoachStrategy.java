package mirobot;

import robocode.JuniorRobot;

public class CoachStrategy {

    //Mi primera clase anidada
    private static class HeadCoach implements CoachTactics {
        public CombatActions getCombatStrategy(JuniorRobot robot){
            // Elijo una estrategia en base a mi energia
            if (robot.energy > 90) {                             //COLOQUIO, esto era para la segunda
                return new OffensiveStrategy(robot);           //para la segunda deberia considerar más cosas
            } else if (robot.energy > 80) {                      //como la cantidad de enemigos, mi energia (ya lo tengo)
                return new DefensiveStrategy(robot);
            } else {
                return new SurvivalStrategy(robot);
            }
        }
    }
    //Mi segunda clase anidada
    private static class SubstituteCoach implements CoachTactics {
        public CombatActions getCombatStrategy(JuniorRobot robot){
            //NOSE QUE PONER
            return null;
        }
    }
    //Instancias de mis estrategas...s
    public static final CoachTactics
            HEAD_COACH_STRATEGIC_TACTICS = new HeadCoach();
    public static final CoachTactics
            SUBSTITUTE_COACH_STRATEGIC_TACTICS = new SubstituteCoach();

}
