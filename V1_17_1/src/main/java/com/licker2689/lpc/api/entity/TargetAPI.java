package com.licker2689.lpc.api.entity;

import com.licker2689.lpc.LPCore;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("all")
public class TargetAPI {
    private static final LPCore plugin = LPCore.getInstance();

    @Nullable
    public static Entity getNearestTargetFromList(Entity center, List<Entity> targets, double maxDistance) {
        if (center == null) return null;
        if (targets.isEmpty()) return null;
        Entity nearestTarget = null;
        double nearestDistance = maxDistance;
        for (Entity target : targets) {
            double distance = center.getLocation().distance(target.getLocation());
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestTarget = target;
            }
        }
        return nearestTarget;
    }

    public static double getDistanceBTAC(Entity center, Entity target) {
        if (center == null || target == null) return 0;
        return center.getLocation().distance(target.getLocation());
    }


}
