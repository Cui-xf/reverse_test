package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0015\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0016J\u008a\u0001\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u00182\b\b\u0002\u0010 \u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u00182\b\b\u0002\u0010\"\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%JN\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u00042\b\b\u0002\u0010-\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b.\u0010/J^\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020\u00182\b\b\u0002\u00106\u001a\u00020\u00182\b\b\u0002\u00107\u001a\u00020\u00182\b\b\u0002\u00108\u001a\u00020\u00182\b\b\u0002\u00109\u001a\u00020\u00042\b\b\u0002\u0010:\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0016J\u008a\u0001\u0010=\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u00182\b\b\u0002\u0010 \u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u00182\b\b\u0002\u0010\"\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b>\u0010%JN\u0010?\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u00042\b\b\u0002\u0010-\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b@\u0010/R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u00020\u000f*\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006A"}, d2 = {"Landroidx/compose/material3/FilterChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultElevatedFilterChipColors", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultElevatedFilterChipColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SelectableChipColors;", "defaultFilterChipColors", "getDefaultFilterChipColors$material3_release", "elevatedFilterChipColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SelectableChipColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "labelColor", "iconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", "elevatedFilterChipColors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SelectableChipColors;", "elevatedFilterChipElevation", "Landroidx/compose/material3/SelectableChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "elevatedFilterChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SelectableChipElevation;", "filterChipBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "selected", "borderColor", "selectedBorderColor", "disabledBorderColor", "disabledSelectedBorderColor", "borderWidth", "selectedBorderWidth", "filterChipBorder-_7El2pE", "(ZZJJJJFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "filterChipColors", "filterChipColors-XqyqHi0", "filterChipElevation", "filterChipElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FilterChipDefaults {
    public static final int $stable = 0;
    public static final FilterChipDefaults INSTANCE = new FilterChipDefaults();
    private static final float Height = FilterChipTokens.INSTANCE.m3290getContainerHeightD9Ej5fM();
    private static final float IconSize = FilterChipTokens.INSTANCE.m3306getIconSizeD9Ej5fM();

    private FilterChipDefaults() {
    }

    /* renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m2131getHeightD9Ej5fM() {
        return Height;
    }

    /* renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2132getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final SelectableChipColors filterChipColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1743772077, "C(filterChipColors)1273@61089L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1743772077, $changed, -1, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1273)");
        }
        SelectableChipColors defaultFilterChipColors$material3_release = getDefaultFilterChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultFilterChipColors$material3_release;
    }

    /* renamed from: filterChipColors-XqyqHi0, reason: not valid java name */
    public final SelectableChipColors m2129filterChipColorsXqyqHi0(long containerColor, long labelColor, long iconColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconColor, long disabledTrailingIconColor, long selectedContainerColor, long disabledSelectedContainerColor, long selectedLabelColor, long selectedLeadingIconColor, long selectedTrailingIconColor, Composer $composer, int $changed, int $changed1, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -1831479801, "C(filterChipColors)P(0:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,4:c#ui.graphics.Color,9:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color)1308@63087L11:Chip.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : containerColor;
        long labelColor2 = (i & 2) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : labelColor;
        long iconColor2 = (i & 4) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : iconColor;
        long disabledContainerColor2 = (i & 8) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledContainerColor;
        long disabledLabelColor2 = (i & 16) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledLabelColor;
        long disabledLeadingIconColor2 = (i & 32) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledLeadingIconColor;
        long disabledTrailingIconColor2 = (i & 64) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledTrailingIconColor;
        long selectedContainerColor2 = (i & 128) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : selectedContainerColor;
        long disabledSelectedContainerColor2 = (i & 256) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledSelectedContainerColor;
        long selectedLabelColor2 = (i & 512) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : selectedLabelColor;
        long selectedLeadingIconColor2 = (i & 1024) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : selectedLeadingIconColor;
        long selectedTrailingIconColor2 = (i & 2048) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : selectedTrailingIconColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1831479801, $changed, $changed1, "androidx.compose.material3.FilterChipDefaults.filterChipColors (Chip.kt:1308)");
        }
        SelectableChipColors selectableChipColorsM2478copydaRQuJA = getDefaultFilterChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m2478copydaRQuJA(containerColor2, labelColor2, iconColor2, iconColor2, disabledContainerColor2, disabledLabelColor2, disabledLeadingIconColor2, disabledTrailingIconColor2, selectedContainerColor2, disabledSelectedContainerColor2, selectedLabelColor2, selectedLeadingIconColor2, selectedTrailingIconColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return selectableChipColorsM2478copydaRQuJA;
    }

    public final SelectableChipColors getDefaultFilterChipColors$material3_release(ColorScheme $this$defaultFilterChipColors) {
        SelectableChipColors it = $this$defaultFilterChipColors.getDefaultFilterChipColorsCached();
        if (it != null) {
            return it;
        }
        long jM4222getTransparent0d7_KjU = Color.INSTANCE.m4222getTransparent0d7_KjU();
        long jFromToken = ColorSchemeKt.fromToken($this$defaultFilterChipColors, FilterChipTokens.INSTANCE.getUnselectedLabelTextColor());
        long jFromToken2 = ColorSchemeKt.fromToken($this$defaultFilterChipColors, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor());
        long jFromToken3 = ColorSchemeKt.fromToken($this$defaultFilterChipColors, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor());
        long jM4222getTransparent0d7_KjU2 = Color.INSTANCE.m4222getTransparent0d7_KjU();
        long jFromToken4 = ColorSchemeKt.fromToken($this$defaultFilterChipColors, FilterChipTokens.INSTANCE.getDisabledLabelTextColor());
        long jM4185copywmQWz5c = Color.m4185copywmQWz5c(jFromToken4, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken4) : FilterChipTokens.INSTANCE.getDisabledLabelTextOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken4) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken4) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken4) : 0.0f);
        long jFromToken5 = ColorSchemeKt.fromToken($this$defaultFilterChipColors, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor());
        long jM4185copywmQWz5c2 = Color.m4185copywmQWz5c(jFromToken5, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken5) : FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken5) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken5) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken5) : 0.0f);
        long jFromToken6 = ColorSchemeKt.fromToken($this$defaultFilterChipColors, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor());
        long jM4185copywmQWz5c3 = Color.m4185copywmQWz5c(jFromToken6, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken6) : FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken6) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken6) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken6) : 0.0f);
        long jFromToken7 = ColorSchemeKt.fromToken($this$defaultFilterChipColors, FilterChipTokens.INSTANCE.getFlatSelectedContainerColor());
        long jFromToken8 = ColorSchemeKt.fromToken($this$defaultFilterChipColors, FilterChipTokens.INSTANCE.getFlatDisabledSelectedContainerColor());
        SelectableChipColors it2 = new SelectableChipColors(jM4222getTransparent0d7_KjU, jFromToken, jFromToken2, jFromToken3, jM4222getTransparent0d7_KjU2, jM4185copywmQWz5c, jM4185copywmQWz5c2, jM4185copywmQWz5c3, jFromToken7, Color.m4185copywmQWz5c(jFromToken8, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken8) : FilterChipTokens.INSTANCE.getFlatDisabledSelectedContainerOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken8) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken8) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken8) : 0.0f), ColorSchemeKt.fromToken($this$defaultFilterChipColors, FilterChipTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken($this$defaultFilterChipColors, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken($this$defaultFilterChipColors, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), null);
        $this$defaultFilterChipColors.setDefaultFilterChipColorsCached$material3_release(it2);
        return it2;
    }

    /* renamed from: filterChipElevation-aqJV_2Y, reason: not valid java name */
    public final SelectableChipElevation m2130filterChipElevationaqJV_2Y(float elevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float elevation2;
        float pressedElevation2;
        float focusedElevation2;
        ComposerKt.sourceInformationMarkerStart($composer, -757972185, "C(filterChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if ((i & 1) != 0) {
            float elevation3 = FilterChipTokens.INSTANCE.m3297getFlatContainerElevationD9Ej5fM();
            elevation2 = elevation3;
        } else {
            elevation2 = elevation;
        }
        if ((i & 2) != 0) {
            float pressedElevation3 = FilterChipTokens.INSTANCE.m3301getFlatSelectedPressedContainerElevationD9Ej5fM();
            pressedElevation2 = pressedElevation3;
        } else {
            pressedElevation2 = pressedElevation;
        }
        if ((i & 4) != 0) {
            float focusedElevation3 = FilterChipTokens.INSTANCE.m3298getFlatSelectedFocusContainerElevationD9Ej5fM();
            focusedElevation2 = focusedElevation3;
        } else {
            focusedElevation2 = focusedElevation;
        }
        float hoveredElevation2 = (i & 8) != 0 ? FilterChipTokens.INSTANCE.m3299getFlatSelectedHoverContainerElevationD9Ej5fM() : hoveredElevation;
        float draggedElevation2 = (i & 16) != 0 ? FilterChipTokens.INSTANCE.m3291getDraggedContainerElevationD9Ej5fM() : draggedElevation;
        float disabledElevation2 = (i & 32) != 0 ? elevation2 : disabledElevation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-757972185, $changed, -1, "androidx.compose.material3.FilterChipDefaults.filterChipElevation (Chip.kt:1378)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(elevation2, pressedElevation2, focusedElevation2, hoveredElevation2, draggedElevation2, disabledElevation2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return selectableChipElevation;
    }

    /* renamed from: filterChipBorder-_7El2pE, reason: not valid java name */
    public final BorderStroke m2128filterChipBorder_7El2pE(boolean enabled, boolean selected, long borderColor, long selectedBorderColor, long disabledBorderColor, long disabledSelectedBorderColor, float borderWidth, float selectedBorderWidth, Composer $composer, int $changed, int i) {
        long disabledBorderColor2;
        ComposerKt.sourceInformationMarkerStart($composer, -1138342447, "C(filterChipBorder)P(4,5,0:c#ui.graphics.Color,6:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,1:c#ui.unit.Dp,7:c#ui.unit.Dp)1406@68670L5,1409@68834L5:Chip.kt#uh7d8r");
        long borderColor2 = (i & 4) != 0 ? ColorSchemeKt.getValue(FilterChipTokens.INSTANCE.getFlatUnselectedOutlineColor(), $composer, 6) : borderColor;
        long selectedBorderColor2 = (i & 8) != 0 ? Color.INSTANCE.m4222getTransparent0d7_KjU() : selectedBorderColor;
        if ((i & 16) != 0) {
            long value = ColorSchemeKt.getValue(FilterChipTokens.INSTANCE.getFlatDisabledUnselectedOutlineColor(), $composer, 6);
            disabledBorderColor2 = Color.m4185copywmQWz5c(value, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value) : FilterChipTokens.INSTANCE.getFlatDisabledUnselectedOutlineOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value) : 0.0f);
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        long disabledSelectedBorderColor2 = (i & 32) != 0 ? Color.INSTANCE.m4222getTransparent0d7_KjU() : disabledSelectedBorderColor;
        float borderWidth2 = (i & 64) != 0 ? FilterChipTokens.INSTANCE.m3304getFlatUnselectedOutlineWidthD9Ej5fM() : borderWidth;
        float selectedBorderWidth2 = (i & 128) != 0 ? FilterChipTokens.INSTANCE.m3300getFlatSelectedOutlineWidthD9Ej5fM() : selectedBorderWidth;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1138342447, $changed, -1, "androidx.compose.material3.FilterChipDefaults.filterChipBorder (Chip.kt:1415)");
        }
        long color = enabled ? selected ? selectedBorderColor2 : borderColor2 : selected ? disabledSelectedBorderColor2 : disabledBorderColor2;
        BorderStroke borderStrokeM257BorderStrokecXLIe8U = BorderStrokeKt.m257BorderStrokecXLIe8U(selected ? selectedBorderWidth2 : borderWidth2, color);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return borderStrokeM257BorderStrokecXLIe8U;
    }

    public final SelectableChipColors elevatedFilterChipColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1082953289, "C(elevatedFilterChipColors)1430@69720L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1082953289, $changed, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:1430)");
        }
        SelectableChipColors defaultElevatedFilterChipColors$material3_release = getDefaultElevatedFilterChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultElevatedFilterChipColors$material3_release;
    }

    /* renamed from: elevatedFilterChipColors-XqyqHi0, reason: not valid java name */
    public final SelectableChipColors m2126elevatedFilterChipColorsXqyqHi0(long containerColor, long labelColor, long iconColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconColor, long disabledTrailingIconColor, long selectedContainerColor, long disabledSelectedContainerColor, long selectedLabelColor, long selectedLeadingIconColor, long selectedTrailingIconColor, Composer $composer, int $changed, int $changed1, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -915841711, "C(elevatedFilterChipColors)P(0:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,4:c#ui.graphics.Color,9:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color)1465@71739L11:Chip.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : containerColor;
        long labelColor2 = (i & 2) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : labelColor;
        long iconColor2 = (i & 4) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : iconColor;
        long disabledContainerColor2 = (i & 8) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledContainerColor;
        long disabledLabelColor2 = (i & 16) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledLabelColor;
        long disabledLeadingIconColor2 = (i & 32) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledLeadingIconColor;
        long disabledTrailingIconColor2 = (i & 64) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledTrailingIconColor;
        long selectedContainerColor2 = (i & 128) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : selectedContainerColor;
        long disabledSelectedContainerColor2 = (i & 256) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledSelectedContainerColor;
        long selectedLabelColor2 = (i & 512) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : selectedLabelColor;
        long selectedLeadingIconColor2 = (i & 1024) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : selectedLeadingIconColor;
        long selectedTrailingIconColor2 = (i & 2048) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : selectedTrailingIconColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-915841711, $changed, $changed1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipColors (Chip.kt:1465)");
        }
        SelectableChipColors selectableChipColorsM2478copydaRQuJA = getDefaultElevatedFilterChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m2478copydaRQuJA(containerColor2, labelColor2, iconColor2, iconColor2, disabledContainerColor2, disabledLabelColor2, disabledLeadingIconColor2, disabledTrailingIconColor2, selectedContainerColor2, disabledSelectedContainerColor2, selectedLabelColor2, selectedLeadingIconColor2, selectedTrailingIconColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return selectableChipColorsM2478copydaRQuJA;
    }

    public final SelectableChipColors getDefaultElevatedFilterChipColors$material3_release(ColorScheme $this$defaultElevatedFilterChipColors) {
        SelectableChipColors it = $this$defaultElevatedFilterChipColors.getDefaultElevatedFilterChipColorsCached();
        if (it == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultElevatedFilterChipColors, FilterChipTokens.INSTANCE.getElevatedUnselectedContainerColor());
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultElevatedFilterChipColors, FilterChipTokens.INSTANCE.getUnselectedLabelTextColor());
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultElevatedFilterChipColors, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor());
            long jFromToken4 = ColorSchemeKt.fromToken($this$defaultElevatedFilterChipColors, FilterChipTokens.INSTANCE.getUnselectedLeadingIconColor());
            long jFromToken5 = ColorSchemeKt.fromToken($this$defaultElevatedFilterChipColors, FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor());
            long jM4185copywmQWz5c = Color.m4185copywmQWz5c(jFromToken5, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken5) : FilterChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken5) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken5) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken5) : 0.0f);
            long jFromToken6 = ColorSchemeKt.fromToken($this$defaultElevatedFilterChipColors, FilterChipTokens.INSTANCE.getDisabledLabelTextColor());
            long jM4185copywmQWz5c2 = Color.m4185copywmQWz5c(jFromToken6, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken6) : FilterChipTokens.INSTANCE.getDisabledLabelTextOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken6) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken6) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken6) : 0.0f);
            long jFromToken7 = ColorSchemeKt.fromToken($this$defaultElevatedFilterChipColors, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor());
            long jM4185copywmQWz5c3 = Color.m4185copywmQWz5c(jFromToken7, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken7) : FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken7) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken7) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken7) : 0.0f);
            long jFromToken8 = ColorSchemeKt.fromToken($this$defaultElevatedFilterChipColors, FilterChipTokens.INSTANCE.getDisabledLeadingIconColor());
            long jM4185copywmQWz5c4 = Color.m4185copywmQWz5c(jFromToken8, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken8) : FilterChipTokens.INSTANCE.getDisabledLeadingIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken8) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken8) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken8) : 0.0f);
            long jFromToken9 = ColorSchemeKt.fromToken($this$defaultElevatedFilterChipColors, FilterChipTokens.INSTANCE.getElevatedSelectedContainerColor());
            long jFromToken10 = ColorSchemeKt.fromToken($this$defaultElevatedFilterChipColors, FilterChipTokens.INSTANCE.getElevatedDisabledContainerColor());
            SelectableChipColors it2 = new SelectableChipColors(jFromToken, jFromToken2, jFromToken3, jFromToken4, jM4185copywmQWz5c, jM4185copywmQWz5c2, jM4185copywmQWz5c3, jM4185copywmQWz5c4, jFromToken9, Color.m4185copywmQWz5c(jFromToken10, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken10) : FilterChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken10) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken10) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken10) : 0.0f), ColorSchemeKt.fromToken($this$defaultElevatedFilterChipColors, FilterChipTokens.INSTANCE.getSelectedLabelTextColor()), ColorSchemeKt.fromToken($this$defaultElevatedFilterChipColors, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), ColorSchemeKt.fromToken($this$defaultElevatedFilterChipColors, FilterChipTokens.INSTANCE.getSelectedLeadingIconColor()), null);
            $this$defaultElevatedFilterChipColors.setDefaultElevatedFilterChipColorsCached$material3_release(it2);
            return it2;
        }
        return it;
    }

    /* renamed from: elevatedFilterChipElevation-aqJV_2Y, reason: not valid java name */
    public final SelectableChipElevation m2127elevatedFilterChipElevationaqJV_2Y(float elevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float elevation2;
        float pressedElevation2;
        float focusedElevation2;
        ComposerKt.sourceInformationMarkerStart($composer, 684803697, "C(elevatedFilterChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if ((i & 1) != 0) {
            float elevation3 = FilterChipTokens.INSTANCE.m3292getElevatedContainerElevationD9Ej5fM();
            elevation2 = elevation3;
        } else {
            elevation2 = elevation;
        }
        if ((i & 2) != 0) {
            float pressedElevation3 = FilterChipTokens.INSTANCE.m3296getElevatedPressedContainerElevationD9Ej5fM();
            pressedElevation2 = pressedElevation3;
        } else {
            pressedElevation2 = pressedElevation;
        }
        if ((i & 4) != 0) {
            float focusedElevation3 = FilterChipTokens.INSTANCE.m3294getElevatedFocusContainerElevationD9Ej5fM();
            focusedElevation2 = focusedElevation3;
        } else {
            focusedElevation2 = focusedElevation;
        }
        float hoveredElevation2 = (i & 8) != 0 ? FilterChipTokens.INSTANCE.m3295getElevatedHoverContainerElevationD9Ej5fM() : hoveredElevation;
        float draggedElevation2 = (i & 16) != 0 ? FilterChipTokens.INSTANCE.m3291getDraggedContainerElevationD9Ej5fM() : draggedElevation;
        float disabledElevation2 = (i & 32) != 0 ? FilterChipTokens.INSTANCE.m3293getElevatedDisabledContainerElevationD9Ej5fM() : disabledElevation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(684803697, $changed, -1, "androidx.compose.material3.FilterChipDefaults.elevatedFilterChipElevation (Chip.kt:1536)");
        }
        SelectableChipElevation selectableChipElevation = new SelectableChipElevation(elevation2, pressedElevation2, focusedElevation2, hoveredElevation2, draggedElevation2, disabledElevation2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return selectableChipElevation;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1598643637, "C1547@76563L5:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1598643637, $changed, -1, "androidx.compose.material3.FilterChipDefaults.<get-shape> (Chip.kt:1547)");
        }
        Shape value = ShapesKt.getValue(FilterChipTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }
}
