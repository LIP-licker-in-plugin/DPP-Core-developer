package com.licker2689.lpc.enums;

@SuppressWarnings("all")
public enum PluginName {
    LPCore("LP-Core", 13426),
    LegendaryCash("LP-LegendaryCash", 13387),
    VirtualStorage("LP-VirtualStorage", 13386),
    SimplePrefix("LP-SimplePrefix", 13460),
    ItemEditor("LP-ItemEditor", 13462),
    SimpleMenu("LP-SimpleMenu", 13499),
    SimpleAnnouncement("LP-SimpleAnnouncement", 13561),
    EquipmentAttribution("LP-EquipmentAttribution", 13663),
    SimpleShop("LP-SimpleShop", 14331),
    RPG("LP-RPG", 14497),
    OreGen("LP-OreGen", 14637),
    MultiWorld("LP-MultiWorld", 14686),
    ItemCommand("LP-ItemCommand", 14687),
    EasyEntitySpawn("LP-EasyEntitySpawn", 14688),
    HotTime("LP-HotTime", 14732),
    EasyMessages("LP-EasyMessages", 14733),
    EasyWarning("LP-EasyWarning", 14737),
    EasyWarp("LP-EasyWarp", 14751),
    LegendaryStorage("LP-LegendaryStorage", 14782),
    Lotto("LP-Lotto", 14901),
    ChatChannel("LP-ChatChannel", 14902),
    RandomBox("LP-RandomBox", 15134),
    GiftBox("LP-GiftBox", 15135),
    BackPack("LP-BackPack", 15136),
    BubbleChat("LP-BubbleChat", 15491),
    LegendaryEnderChest("LP-LegendaryEnderChest", 15714),
    BroadcastStream("LP-BroadcastStream", 15715),
    Menu("LP-Menu", 15781),
    MultiCommand("LP-MultiCommand", 15934),
    LegendaryCollection("LP-LegendaryCollection", 15935),
    ;
    private final String name;
    private final int pluginID;

    PluginName(String name, int pluginID) {
        this.name = name;
        this.pluginID = pluginID;
    }

    public String getName() {
        return name;
    }

    public int getPluginID() {
        return pluginID;
    }

    public static PluginName getByName(String name) {
        for (PluginName pluginName : values()) {
            if (pluginName.getName().equals(name)) {
                return pluginName;
            }
        }
        return null;
    }

    public static PluginName getByID(int id) {
        for (PluginName pluginName : values()) {
            if (pluginName.getPluginID() == id) {
                return pluginName;
            }
        }
        return null;
    }
}
