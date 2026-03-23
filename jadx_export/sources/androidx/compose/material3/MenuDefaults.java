package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* compiled from: Menu.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u001b\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u001cJN\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0017\u0010\u000e\u001a\u00020\u000f8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0017*\u00020\u00188@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/compose/material3/MenuDefaults;", "", "()V", "DropdownMenuItemContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getDropdownMenuItemContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "ShadowElevation", "Landroidx/compose/ui/unit/Dp;", "getShadowElevation-D9Ej5fM", "()F", "F", "TonalElevation", "getTonalElevation-D9Ej5fM", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultMenuItemColors", "Landroidx/compose/material3/MenuItemColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultMenuItemColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/MenuItemColors;", "itemColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/MenuItemColors;", "textColor", "leadingIconColor", "trailingIconColor", "disabledTextColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "itemColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/MenuItemColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MenuDefaults {
    public static final int $stable = 0;
    public static final MenuDefaults INSTANCE = new MenuDefaults();
    private static final float TonalElevation = ElevationTokens.INSTANCE.m3190getLevel0D9Ej5fM();
    private static final float ShadowElevation = MenuTokens.INSTANCE.m3334getContainerElevationD9Ej5fM();
    private static final PaddingValues DropdownMenuItemContentPadding = PaddingKt.m675PaddingValuesYgX7TsA(MenuKt.DropdownMenuItemHorizontalPadding, Dp.m6693constructorimpl(0));

    private MenuDefaults() {
    }

    /* renamed from: getTonalElevation-D9Ej5fM, reason: not valid java name */
    public final float m2246getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    /* renamed from: getShadowElevation-D9Ej5fM, reason: not valid java name */
    public final float m2245getShadowElevationD9Ej5fM() {
        return ShadowElevation;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 218702739, "C194@9499L5:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(218702739, $changed, -1, "androidx.compose.material3.MenuDefaults.<get-shape> (Menu.kt:194)");
        }
        Shape value = ShapesKt.getValue(MenuTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final long getContainerColor(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1787427929, "C198@9634L5:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1787427929, $changed, -1, "androidx.compose.material3.MenuDefaults.<get-containerColor> (Menu.kt:198)");
        }
        long value = ColorSchemeKt.getValue(MenuTokens.INSTANCE.getContainerColor(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }

    public final MenuItemColors itemColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1326531516, "C(itemColors)204@9833L11:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1326531516, $changed, -1, "androidx.compose.material3.MenuDefaults.itemColors (Menu.kt:204)");
        }
        MenuItemColors defaultMenuItemColors$material3_release = getDefaultMenuItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultMenuItemColors$material3_release;
    }

    /* renamed from: itemColors-5tl4gsc, reason: not valid java name */
    public final MenuItemColors m2247itemColors5tl4gsc(long textColor, long leadingIconColor, long trailingIconColor, long disabledTextColor, long disabledLeadingIconColor, long disabledTrailingIconColor, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -1278543580, "C(itemColors)P(4:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,1:c#ui.graphics.Color,0:c#ui.graphics.Color,2:c#ui.graphics.Color)229@11073L11:Menu.kt#uh7d8r");
        long textColor2 = (i & 1) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : textColor;
        long leadingIconColor2 = (i & 2) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : leadingIconColor;
        long trailingIconColor2 = (i & 4) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : trailingIconColor;
        long disabledTextColor2 = (i & 8) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledTextColor;
        long disabledLeadingIconColor2 = (i & 16) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledLeadingIconColor;
        long disabledTrailingIconColor2 = (i & 32) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledTrailingIconColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1278543580, $changed, -1, "androidx.compose.material3.MenuDefaults.itemColors (Menu.kt:229)");
        }
        MenuItemColors menuItemColorsM2249copytNS2XkQ = getDefaultMenuItemColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m2249copytNS2XkQ(textColor2, leadingIconColor2, trailingIconColor2, disabledTextColor2, disabledLeadingIconColor2, disabledTrailingIconColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return menuItemColorsM2249copytNS2XkQ;
    }

    public final MenuItemColors getDefaultMenuItemColors$material3_release(ColorScheme $this$defaultMenuItemColors) {
        MenuItemColors it = $this$defaultMenuItemColors.getDefaultMenuItemColorsCached();
        if (it == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultMenuItemColors, ListTokens.INSTANCE.getListItemLabelTextColor());
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultMenuItemColors, ListTokens.INSTANCE.getListItemLeadingIconColor());
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultMenuItemColors, ListTokens.INSTANCE.getListItemTrailingIconColor());
            long jFromToken4 = ColorSchemeKt.fromToken($this$defaultMenuItemColors, ListTokens.INSTANCE.getListItemDisabledLabelTextColor());
            long jM4185copywmQWz5c = Color.m4185copywmQWz5c(jFromToken4, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken4) : ListTokens.INSTANCE.getListItemDisabledLabelTextOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken4) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken4) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken4) : 0.0f);
            long jFromToken5 = ColorSchemeKt.fromToken($this$defaultMenuItemColors, ListTokens.INSTANCE.getListItemDisabledLeadingIconColor());
            long jM4185copywmQWz5c2 = Color.m4185copywmQWz5c(jFromToken5, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken5) : ListTokens.INSTANCE.getListItemDisabledLeadingIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken5) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken5) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken5) : 0.0f);
            long jFromToken6 = ColorSchemeKt.fromToken($this$defaultMenuItemColors, ListTokens.INSTANCE.getListItemDisabledTrailingIconColor());
            MenuItemColors it2 = new MenuItemColors(jFromToken, jFromToken2, jFromToken3, jM4185copywmQWz5c, jM4185copywmQWz5c2, Color.m4185copywmQWz5c(jFromToken6, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken6) : ListTokens.INSTANCE.getListItemDisabledTrailingIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken6) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken6) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken6) : 0.0f), null);
            $this$defaultMenuItemColors.setDefaultMenuItemColorsCached$material3_release(it2);
            return it2;
        }
        return it;
    }

    public final PaddingValues getDropdownMenuItemContentPadding() {
        return DropdownMenuItemContentPadding;
    }
}
