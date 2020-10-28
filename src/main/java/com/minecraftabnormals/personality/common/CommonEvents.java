package com.minecraftabnormals.personality.common;

import com.minecraftabnormals.personality.core.Personality;
import com.teamabnormals.abnormals_core.common.world.storage.tracking.IDataManager;
import net.minecraft.entity.Pose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Personality.MODID)
public class CommonEvents {

	@SubscribeEvent
	public static void onEvent(TickEvent.PlayerTickEvent event) {
		PlayerEntity player = event.player;
		IDataManager data = (IDataManager) player;

		if (data == null || event.phase != TickEvent.Phase.END)
			return;

		if (data.getValue(Personality.CRAWLING) && player.getPose() != Pose.SWIMMING && !player.isPassenger()) {
			player.setPose(Pose.SWIMMING);
		}
	}
}
