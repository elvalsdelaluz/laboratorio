package mirobot;

import robocode.JuniorRobot;

public interface CoachTactics {
    CombatActions getCombatStrategy (JuniorRobot robot);
}
