package com.licker2689.lpc.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.server.v1_12_R1.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.inventory.CraftItemStack;
import org.bukkit.entity.EntityType;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NBT {
    public NBT() {
    }

    public static @NotNull ItemStack setObjectTag(ItemStack objitem, String key, Object value) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        ntc.setString(key, value.toString());
        item.setTag(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    public static @NotNull ItemStack removeTag(ItemStack objitem, String key) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        item.setTag(ntc);
        item.setTag(c(key, item.getTag()));
        return CraftItemStack.asBukkitCopy(item);
    }

    public static NBTTagCompound c(String s, NBTTagCompound tag) {
        if (tag != null && tag.hasKey(s)) {
            tag.remove(s);
            if (tag.isEmpty()) {
                return null;
            }
        }

        return tag;
    }

    public static @NotNull ItemStack removeAllTags(ItemStack objitem) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        Iterator var3 = ntc.c().iterator();

        while(var3.hasNext()) {
            String key = (String)var3.next();
            item.e(key);
        }

        item.setTag(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    public static @NotNull String getStringTag(ItemStack objitem, String key) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        return ntc.getString(key).replace('"', ' ').trim();
    }

    public static @NotNull byte getByteTag(ItemStack objitem, String key) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        return ntc.getByte(key);
    }

    public static @NotNull short getShortTag(ItemStack objitem, String key) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        return ntc.getShort(key);
    }

    public static @NotNull int getIntegerTag(ItemStack objitem, String key) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        return ntc.getInt(key);
    }

    public static @NotNull float getFloatTag(ItemStack objitem, String key) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        return ntc.getFloat(key);
    }

    public static @NotNull double getDoubleTag(ItemStack objitem, String key) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        return ntc.getDouble(key);
    }

    public static boolean getBooleanTag(ItemStack objitem, String key) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        return ntc.getBoolean(key);
    }

    public static @NotNull long getLongTag(ItemStack objitem, String key) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        return ntc.getLong(key);
    }

    public static @NotNull byte[] getByteArrayTag(ItemStack objitem, String key) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        return ntc.getByteArray(key);
    }

    public static @NotNull int[] getIntArrayTag(ItemStack objitem, String key) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        return ntc.getIntArray(key);
    }

    public static @NotNull NBTTagCompound getCompoundTag(ItemStack objitem, String key) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        return ntc.getCompound(key);
    }

    public static @Nullable Material getMaterialTag(ItemStack objitem, String key) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        return Material.getMaterial(ntc.getString(key));
    }

    public static @Nullable InventoryType getInventoryTypeTag(ItemStack objitem, String key) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        return InventoryType.valueOf(ntc.getString(key));
    }

    public static @Nullable EntityType getEntityTypeTag(ItemStack objitem, String key) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        return EntityType.valueOf(ntc.getString(key));
    }

    public static boolean hasTagKey(ItemStack objitem, String key) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        return ntc.hasKey(key);
    }

    public static @Nullable Map<String, String> getAllStringTag(ItemStack objitem) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        if (ntc.c().size() == 0) {
            return null;
        } else {
            Map<String, String> tags = new HashMap();
            Iterator var4 = ntc.c().iterator();

            while(var4.hasNext()) {
                String key = (String)var4.next();
                tags.put(key, ntc.get(key).toString());
            }

            return tags;
        }
    }

    public static @NotNull ItemStack setStringTag(ItemStack objitem, String key, String value) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        ntc.setString(key, value);
        item.setTag(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    public static @NotNull ItemStack setByteTag(ItemStack objitem, String key, byte value) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        ntc.setByte(key, value);
        item.setTag(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    public static @NotNull ItemStack setShortTag(ItemStack objitem, String key, short value) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        ntc.setShort(key, value);
        item.setTag(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    public static @NotNull ItemStack setIntTag(ItemStack objitem, String key, int value) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        ntc.setInt(key, value);
        item.setTag(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    public static @NotNull ItemStack setLongTag(ItemStack objitem, String key, long value) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        ntc.setLong(key, value);
        item.setTag(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    public static @NotNull ItemStack setFloatTag(ItemStack objitem, String key, float value) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        ntc.setFloat(key, value);
        item.setTag(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    public static @NotNull ItemStack setDoubleTag(ItemStack objitem, String key, double value) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        ntc.setDouble(key, value);
        item.setTag(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    public static @NotNull ItemStack setByteArrayTag(ItemStack objitem, String key, byte[] value) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        ntc.setByteArray(key, value);
        item.setTag(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    public static @NotNull ItemStack setIntArrayTag(ItemStack objitem, String key, int[] value) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        ntc.setIntArray(key, value);
        item.setTag(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    public static @NotNull ItemStack setMaterialTag(ItemStack objitem, String key, Material value) {
        net.minecraft.server.v1_12_R1.ItemStack item = CraftItemStack.asNMSCopy(objitem);
        NBTTagCompound ntc = item.hasTag() ? item.getTag() : new NBTTagCompound();
        ntc.setString(key, value.name());
        item.setTag(ntc);
        return CraftItemStack.asBukkitCopy(item);
    }

    public static ItemStack setItemStackTag(ItemStack objitem, String key, ItemStack value) {
        String sitem = ItemStackSerializer.serialize(value);
        String[] sitems = sitem.split("(?<=\\G.{288})");

        for(int i = 0; i < sitems.length; ++i) {
            objitem = setStringTag(objitem, key + i, sitems[i]);
        }

        objitem = setIntTag(objitem, key + "_size", sitems.length);
        return objitem;
    }

    public static @Nullable ItemStack getItemStackTag(ItemStack objitem, String key) {
        int length = getIntegerTag(objitem, key + "_size");
        String s = "";

        for(int i = 0; i < length; ++i) {
            s = s + getStringTag(objitem, key + i);
        }

        return ItemStackSerializer.deserialize(s);
    }

    public static ItemStack setInventoryTag(ItemStack objitem, Inventory inv, String key) {
        for(int i = 0; i < inv.getSize(); ++i) {
            objitem = setItemStackTag(objitem, "inv_" + key + "_" + i + "_item", inv.getItem(i));
        }

        objitem = setIntTag(objitem, "inv_" + key + "_size", inv.getSize());
        return objitem;
    }

    public static @Nullable Inventory getInventoryTag(ItemStack objitem, String key) {
        Inventory inv = Bukkit.createInventory((InventoryHolder)null, getIntegerTag(objitem, "inv_" + key + "_size"));

        for(int i = 0; i < inv.getSize(); ++i) {
            inv.setItem(i, getItemStackTag(objitem, "inv_" + key + "_" + i + "_item"));
        }

        return inv;
    }
}
