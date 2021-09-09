package me.pseey.module.modules.movement;

import me.pseey.module.Category;
import me.pseey.module.Module;
import org.lwjgl.input.Keyboard;

public class Speed extends Module {
    public Speed() {
        super("Speed", Keyboard.KEY_H, Category.MOVEMENT);
    }


    @Override
    public void onUpdate() {
        if (mc.thePlayer.moveForward > 0 || mc.thePlayer.moveStrafing > 0) {
            if (mc.thePlayer.onGround) {
                mc.timer.timerSpeed = 1F;
                mc.thePlayer.jump();
                mc.thePlayer.motionX *= 1.0228F;
                mc.thePlayer.motionZ *= 1.0228F;
            } else {
                if (mc.thePlayer.ticksExisted % 3 == 0) {
                    mc.timer.timerSpeed = 1.2F;
                } else {
                    mc.timer.timerSpeed = 1.05F;
                }

                mc.thePlayer.motionX *= 1F;
                mc.thePlayer.motionZ *= 1F;
                //By GA • Let's codes
                mc.thePlayer.jumpMovementFactor = 0.0265F;
                //---
                mc.thePlayer.moveStrafing *= 1F;
                mc.thePlayer.moveForward *= 1F;
                if (mc.thePlayer.fallDistance >= 0.3) {
                    mc.timer.timerSpeed = 1.2F;
                    mc.thePlayer.motionY -= 62F;
                }
            }
        }
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {
        mc.timer.timerSpeed = 1F;
    }
}
