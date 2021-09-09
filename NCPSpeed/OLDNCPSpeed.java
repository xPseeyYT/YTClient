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
                mc.thePlayer.jump();
 		mc.timer.timerSpeed = 1.09F;
            } else {
                mc.timer.timerSpeed = 1.05F;
                mc.thePlayer.motionX *= 1F;
                mc.thePlayer.motionZ *= 1F;
                if (mc.thePlayer.fallDistance >= 0.4) {
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
