package mirobot;

public class StrategicStrategy {
    //Mi primera clase anidada
    private static class HeadCoach implements StrategicTactics {
        public CombatActions obtenerEstrategia(){
            //QSY
            return null;
        }
    }
    //Mi segunda clase anidada
    private static class SubstituteCoach implements StrategicTactics {
        public CombatActions obtenerEstrategia(){
            //QSY
            return null;
        }
    }
    //Instancias de mis estrategas...s
    public static final StrategicTactics
            MI_PRIMER_STRATEGIC_TACTICS = new HeadCoach();
    public static final StrategicTactics
            MI_SEGUNDO_STRATEGIC_TACTICS = new SubstituteCoach();

}
