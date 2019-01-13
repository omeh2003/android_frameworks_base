/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.internal.statusbar;

import android.content.om.IOverlayManager;
import android.content.om.OverlayInfo;
import android.os.RemoteException;
import android.util.Log;

public class ThemeAccentUtils {

    public static final String TAG = "ThemeAccentUtils";

    // Stock dark theme package
    private static final String STOCK_DARK_THEME = "com.android.systemui.theme.dark";

    // Dark themes
    private static final String[] DARK_THEMES = {
        "com.android.system.theme.dark", // 0
        "com.android.settings.theme.dark", // 1
        "com.android.settings.intelligence.theme.dark", // 2
        "com.android.gboard.theme.dark", // 3      
        "com.android.contacts.theme.dark", // 4
        "com.android.dialer.theme.dark", // 5
        "com.android.documentsui.theme.dark", // 6
        "com.accents.pink", // 7
        "com.android.systemui.theme.dark", // 8
    };

    private static final String[] BLACK_THEMES = {
        "com.android.system.theme.black", // 0
        "com.android.settings.theme.black", // 1
        "com.android.settings.intelligence.theme.black", // 2
        "com.android.gboard.theme.black", // 3
        "com.android.contacts.theme.black", // 4
        "com.android.dialer.theme.black", // 5
        "com.android.documentsui.theme.black", // 6
        "com.accents.deeppurple", // 7
        "com.android.systemui.theme.black", // 8
    };

    private static final String[] SHISHUNIGHTS_THEMES = {
        "com.android.system.theme.shishunights", // 0
        "com.android.settings.theme.shishunights", // 1
        "com.android.settings.intelligence.theme.shishunights", // 2
        "com.android.gboard.theme.shishunights", // 3
        "com.android.contacts.theme.shishunights", // 4
        "com.android.dialer.theme.shishunights", // 5
        "com.android.documentsui.theme.shishunights", // 6
        "com.google.android.apps.wellbeing.theme.shishunights", // 7
        "com.accents.userone", // 8
        "com.android.systemui.theme.shishunights", // 9
    };

    private static final String[] CHOCOLATE_THEMES = {
        "com.android.system.theme.chocolate", // 0
        "com.android.settings.theme.chocolate", // 1
        "com.android.settings.intelligence.theme.chocolate", // 2
        "com.android.gboard.theme.chocolate", // 3
        "com.android.contacts.theme.chocolate", // 4
        "com.android.dialer.theme.chocolate", // 5
        "com.android.documentsui.theme.chocolate", // 6
        "com.google.android.apps.wellbeing.theme.chocolate", // 7
        "com.accents.candyred", // 8
        "com.android.systemui.theme.chocolate", // 9
    };

    private static final String[] SHISHUCOSMOS_THEMES = {
        "com.android.system.theme.shishucosmos", // 0
        "com.android.systemui.theme.shishucosmos", // 1
        "com.android.settings.theme.shishucosmos", // 2
        "com.android.settings.intelligence.theme.shishucosmos", // 3
        "com.android.gboard.theme.shishucosmos", // 4
        "com.android.contacts.theme.shishucosmos", // 5
        "com.android.dialer.theme.shishucosmos", // 6
        "com.android.documentsui.theme.shishucosmos", // 7
        "com.google.android.gms.theme.shishucosmos", // 8
        "com.google.android.apps.wellbeing.theme.shishucosmos", // 9
        "com.accents.candyred", // 10
    };

    // Accents
    private static final String[] ACCENTS = {
        "default_accent", // 0
        "com.accents.red", // 1
        "com.accents.pink", // 2
        "com.accents.purple", // 3
        "com.accents.deeppurple", // 4
        "com.accents.indigo", // 5
        "com.accents.blue", // 6
        "com.accents.lightblue", // 7
        "com.accents.cyan", // 8
        "com.accents.teal", // 9
        "com.accents.green", // 10
        "com.accents.lightgreen", // 11
        "com.accents.lime", // 12
        "com.accents.yellow", // 13
        "com.accents.amber", // 14
        "com.accents.orange", // 15
        "com.accents.deeporange", // 16
        "com.accents.brown", // 17
        "com.accents.grey", // 18
        "com.accents.bluegrey", // 19
        "com.accents.black", // 20
        "com.accents.white", // 21
        "com.accents.userone", // 22
        "com.accents.usertwo", // 23
        "com.accents.userthree", // 24
        "com.accents.userfour", // 25
        "com.accents.userfive", // 26
        "com.accents.usersix", // 27
        "com.accents.userseven", // 28
        "com.accents.maniaamber", // 29
        "com.accents.coldyellow", // 30
        "com.accents.newhouseorange", // 31
        "com.accents.warmthorange", // 32
        "com.accents.burningred", // 33
        "com.accents.candyred", // 34
        "com.accents.palered", // 35
        "com.accents.hazedpink", // 36
        "com.accents.bubblegumpink", // 37
        "com.accents.trufilpink", // 38
        "com.accents.duskpurple", // 39
        "com.accents.illusionspurple", // 40
        "com.accents.spookedpurple", // 41
        "com.accents.notimppurple", // 42
        "com.accents.dreamypurple", // 43
        "com.accents.footprintpurple", // 44
        "com.accents.obfusbleu", // 45
        "com.accents.frenchbleu", // 46
        "com.accents.coldbleu", // 47
        "com.accents.heirloombleu", // 48
        "com.accents.paleblue", // 49
        "com.accents.holillusion", // 50
        "com.accents.stock", // 51
        "com.accents.seasidemint", // 52
        "com.accents.movemint", // 53
        "com.accents.extendedgreen", // 54
        "com.accents.diffdaygreen", // 55
        "com.accents.jadegreen", // 56
    };

    private static final String[] QS_TILE_THEMES = {
        "com.android.systemui.qstile.default", // 0
        "com.android.systemui.qstile.circlegradient", // 1
        "com.android.systemui.qstile.circletrim", // 2
        "com.android.systemui.qstile.dottedcircle", // 3
        "com.android.systemui.qstile.dualtonecircle", // 4
        "com.android.systemui.qstile.dualtonecircletrim", // 5
        "com.android.systemui.qstile.mountain", // 6
        "com.android.systemui.qstile.ninja", // 7
        "com.android.systemui.qstile.pokesign", // 8
        "com.android.systemui.qstile.wavey", // 9
        "com.android.systemui.qstile.squircletrim", // 10
        "com.android.systemui.qstile.oreo", // 11
        "com.android.systemui.qstile.oreocircletrim", // 12
        "com.android.systemui.qstile.oreosquircletrim", // 13
    };

    // Unloads the stock dark theme
    public static void unloadStockDarkTheme(IOverlayManager om, int userId) {
        OverlayInfo themeInfo = null;
        try {
            themeInfo = om.getOverlayInfo(STOCK_DARK_THEME,
                    userId);
            if (themeInfo != null && themeInfo.isEnabled()) {
                om.setEnabled(STOCK_DARK_THEME,
                        false /*disable*/, userId);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    // Check for the dark system theme
    public static boolean isUsingDarkTheme(IOverlayManager om, int userId) {
        OverlayInfo themeInfo = null;
        try {
            themeInfo = om.getOverlayInfo(DARK_THEMES[0],
                    userId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return themeInfo != null && themeInfo.isEnabled();
    }

    // Check for the black system theme
    public static boolean isUsingBlackTheme(IOverlayManager om, int userId) {
        OverlayInfo themeInfo = null;
        try {
            themeInfo = om.getOverlayInfo(BLACK_THEMES[0],
                    userId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return themeInfo != null && themeInfo.isEnabled();
     }

    // Check for the shishunights system theme
    public static boolean isUsingShishuNightsTheme(IOverlayManager om, int userId) {
        OverlayInfo themeInfo = null;
        try {
            themeInfo = om.getOverlayInfo(SHISHUNIGHTS_THEMES[0],
                    userId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return themeInfo != null && themeInfo.isEnabled();
     }

    // Check for the chocolate system theme
    public static boolean isUsingChocolateTheme(IOverlayManager om, int userId) {
        OverlayInfo themeInfo = null;
        try {
            themeInfo = om.getOverlayInfo(CHOCOLATE_THEMES[0],
                    userId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return themeInfo != null && themeInfo.isEnabled();
     }

    // Check for the shishucosmos system theme
    public static boolean isUsingShishuCosmosTheme(IOverlayManager om, int userId) {
        OverlayInfo themeInfo = null;
        try {
            themeInfo = om.getOverlayInfo(SHISHUCOSMOS_THEMES[0],
                    userId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return themeInfo != null && themeInfo.isEnabled();
     }

    // Set light / dark theme
    public static void setLightDarkTheme(IOverlayManager om, int userId, boolean useDarkTheme) {
        for (String theme : DARK_THEMES) {
            try {
                om.setEnabled(theme,
                        useDarkTheme, userId);
                unfuckBlackWhiteAccent(om, userId);
                if (useDarkTheme) {
                    unloadStockDarkTheme(om, userId);
                }
            } catch (RemoteException e) {
            }
        }
    }

    // Set black theme
    public static void setBlackTheme(IOverlayManager om, int userId, boolean useBlackTheme) {
        for (String theme : BLACK_THEMES) {
            try {
                om.setEnabled(theme,
                        useBlackTheme, userId);
                unfuckBlackWhiteAccent(om, userId);
                if (useBlackTheme) {
                    unloadStockDarkTheme(om, userId);
                }
            } catch (RemoteException e) {
            }
        }
    }

    // Set shishunights theme
    public static void setShishuNightsTheme(IOverlayManager om, int userId, boolean useShishuNightsTheme) {
        for (String theme : SHISHUNIGHTS_THEMES) {
            try {
                om.setEnabled(theme,
                        useShishuNightsTheme, userId);
                unfuckBlackWhiteAccent(om, userId);
                if (useShishuNightsTheme) {
                    unloadStockDarkTheme(om, userId);
                }
            } catch (RemoteException e) {
            }
        }
    }

    // Set chocolate theme
    public static void setChocolateTheme(IOverlayManager om, int userId, boolean useChocolateTheme) {
        for (String theme : CHOCOLATE_THEMES) {
            try {
                om.setEnabled(theme,
                        useChocolateTheme, userId);
                unfuckBlackWhiteAccent(om, userId);
                if (useChocolateTheme) {
                    unloadStockDarkTheme(om, userId);
                }
            } catch (RemoteException e) {
            }
        }
    }

    public static void setShishuCosmosTheme(IOverlayManager om, int userId, boolean useShishuCosmosTheme) {
        for (String theme : SHISHUCOSMOS_THEMES) {
                try {
                    om.setEnabled(theme,
                        useShishuCosmosTheme, userId);
                } catch (RemoteException e) {
                    Log.w(TAG, "Can't change theme", e);
                }
        }
    }

    // Check for black and white accent overlays
    public static void unfuckBlackWhiteAccent(IOverlayManager om, int userId) {
        OverlayInfo themeInfo = null;
        try {
            if (isUsingDarkTheme(om, userId) || isUsingBlackTheme(om, userId) || isUsingShishuNightsTheme(om, userId) || isUsingChocolateTheme(om, userId) || isUsingShishuCosmosTheme(om, userId)) {
                themeInfo = om.getOverlayInfo(ACCENTS[20],
                        userId);
                if (themeInfo != null && themeInfo.isEnabled()) {
                    om.setEnabled(ACCENTS[20],
                            false /*disable*/, userId);
                    om.setEnabled(ACCENTS[21],
                            true, userId);
                }
            } else {
                themeInfo = om.getOverlayInfo(ACCENTS[21],
                        userId);
                if (themeInfo != null && themeInfo.isEnabled()) {
                    om.setEnabled(ACCENTS[21],
                            false /*disable*/, userId);
                    om.setEnabled(ACCENTS[20],
                            true, userId);
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    // Check for the white accent overlay
    public static boolean isUsingWhiteAccent(IOverlayManager om, int userId) {
        OverlayInfo themeInfo = null;
        try {
            themeInfo = om.getOverlayInfo(ACCENTS[21],
                    userId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return themeInfo != null && themeInfo.isEnabled();
    }

    // Switches theme accent from one to another or back to stock
    public static void updateAccents(IOverlayManager om, int userId, int accentSetting) {
        if (accentSetting == 0) {
            //On selecting default accent, set accent to pink if Dark Theme is being used
            if (isUsingDarkTheme(om, userId)) {
                try {
                    om.setEnabled(DARK_THEMES[7],
                        true, userId);
                } catch (RemoteException e) {
                    Log.w(TAG, "Can't change theme", e);
                }
            //On selecting default accent, set accent to deep purple if Black Theme is being used
            } else if (isUsingBlackTheme(om, userId)) {
                try {
                    om.setEnabled(BLACK_THEMES[7],
                        true, userId);
                } catch (RemoteException e) {
                    Log.w(TAG, "Can't change theme", e);
                }
            //On selecting default accent, set accent to dirty red if ShishuNights Theme is being used
            } else if (isUsingShishuNightsTheme(om, userId)) {
                try {
                    om.setEnabled(SHISHUNIGHTS_THEMES[8],
                        true, userId);
                } catch (RemoteException e) {
                    Log.w(TAG, "Can't change theme", e);
                }
            //On selecting default accent, set accent to candy red if Chocolate Theme is being used
            } else if (isUsingChocolateTheme(om, userId)) {
                try {
                    om.setEnabled(CHOCOLATE_THEMES[8],
                        true, userId);
                } catch (RemoteException e) {
                    Log.w(TAG, "Can't change theme", e);
                }
            } else if (isUsingShishuCosmosTheme(om, userId)) {
                try {
                    om.setEnabled(SHISHUCOSMOS_THEMES[10],
                        true, userId);
                } catch (RemoteException e) {
                    Log.w(TAG, "Can't change theme", e);
                }
            } else {
                unloadAccents(om, userId);
            }
        } else if ((accentSetting < 20) || (accentSetting > 21)) {
            try {
                om.setEnabled(ACCENTS[accentSetting],
                        true, userId);
            } catch (RemoteException e) {
            }
        } else if (accentSetting == 20) {
            try {
                // If using a dark theme we use the white accent, otherwise use the black accent
                if (isUsingDarkTheme(om, userId) || isUsingBlackTheme(om, userId) || isUsingShishuNightsTheme(om, userId) || isUsingChocolateTheme(om, userId) || isUsingShishuCosmosTheme(om, userId)) {
                    om.setEnabled(ACCENTS[21],
                            true, userId);
                } else {
                    om.setEnabled(ACCENTS[20],
                            true, userId);
                }
            } catch (RemoteException e) {
            }
        }
    }

    // Unload all the theme accents
    public static void unloadAccents(IOverlayManager om, int userId) {
        // skip index 0
        for (int i = 1; i < ACCENTS.length; i++) {
            String accent = ACCENTS[i];
            try {
                om.setEnabled(accent,
                        false /*disable*/, userId);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    // Switches qs tile style to user selected.
    public static void updateTileStyle(IOverlayManager om, int userId, int qsTileStyle) {
        if (qsTileStyle == 0) {
            stockTileStyle(om, userId);
        } else {
            try {
                om.setEnabled(QS_TILE_THEMES[qsTileStyle],
                        true, userId);
            } catch (RemoteException e) {
                Log.w(TAG, "Can't change qs tile icon", e);
            }
        }
    }

    // Switches qs tile style back to stock.
    public static void stockTileStyle(IOverlayManager om, int userId) {
        // skip index 0
        for (int i = 1; i < QS_TILE_THEMES.length; i++) {
            String qstiletheme = QS_TILE_THEMES[i];
            try {
                om.setEnabled(qstiletheme,
                        false /*disable*/, userId);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    // Check for any QS tile styles overlay
    public static boolean isUsingQsTileStyles(IOverlayManager om, int userId, int qsstyle) {
        OverlayInfo themeInfo = null;
        try {
            themeInfo = om.getOverlayInfo(QS_TILE_THEMES[qsstyle],
                    userId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return themeInfo != null && themeInfo.isEnabled();
    }
}
