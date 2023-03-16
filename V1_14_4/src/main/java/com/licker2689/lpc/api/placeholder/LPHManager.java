package com.licker2689.lpc.api.placeholder;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public final class LPHManager {
    private final Map<String, LPlaceHolder> placeholders = new HashMap<>();

    public void register(LPlaceHolder placeholder, String key) {
        placeholders.put(key, placeholder);
    }

    public void unregister(String key) {
        placeholders.remove(key);
    }

    public LPlaceHolder getPlaceholder(String key) {
        return placeholders.get(key);
    }

    public Map<String, LPlaceHolder> getPlaceholders() {
        return placeholders;
    }

}
