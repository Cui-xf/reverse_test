package androidx.compose.material3;

import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* compiled from: Switch.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\r\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000eJ²\u0001\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u00102\b\b\u0002\u0010\u001d\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u00020\t*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Landroidx/compose/material3/SwitchDefaults;", "", "()V", "IconSize", "Landroidx/compose/ui/unit/Dp;", "getIconSize-D9Ej5fM", "()F", "F", "defaultSwitchColors", "Landroidx/compose/material3/SwitchColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSwitchColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SwitchColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "colors-V1nXRL4", "(JJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SwitchColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();
    private static final float IconSize = Dp.m6693constructorimpl(16);

    private SwitchDefaults() {
    }

    public final SwitchColors colors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 435552781, "C(colors)299@11393L11:Switch.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(435552781, $changed, -1, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:299)");
        }
        SwitchColors defaultSwitchColors$material3_release = getDefaultSwitchColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultSwitchColors$material3_release;
    }

    /* renamed from: colors-V1nXRL4, reason: not valid java name */
    public final SwitchColors m2593colorsV1nXRL4(long checkedThumbColor, long checkedTrackColor, long checkedBorderColor, long checkedIconColor, long uncheckedThumbColor, long uncheckedTrackColor, long uncheckedBorderColor, long uncheckedIconColor, long disabledCheckedThumbColor, long disabledCheckedTrackColor, long disabledCheckedBorderColor, long disabledCheckedIconColor, long disabledUncheckedThumbColor, long disabledUncheckedTrackColor, long disabledUncheckedBorderColor, long disabledUncheckedIconColor, Composer $composer, int $changed, int $changed1, int i) {
        long disabledCheckedThumbColor2;
        long disabledCheckedTrackColor2;
        long disabledCheckedIconColor2;
        long disabledUncheckedThumbColor2;
        long disabledUncheckedTrackColor2;
        long disabledUncheckedBorderColor2;
        long disabledUncheckedIconColor2;
        ComposerKt.sourceInformationMarkerStart($composer, 1937926421, "C(colors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,14:c#ui.graphics.Color,15:c#ui.graphics.Color,12:c#ui.graphics.Color,13:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,10:c#ui.graphics.Color,11:c#ui.graphics.Color,8:c#ui.graphics.Color,9:c#ui.graphics.Color)324@13145L5,325@13219L5,327@13346L5,328@13425L5,329@13503L5,330@13594L5,331@13670L5,333@13773L5,335@13898L11,337@14015L5,339@14131L11,342@14309L5,344@14432L11,346@14554L5,348@14681L11,350@14802L5,352@14918L11,354@15047L5,356@15163L11,358@15282L5,360@15407L11:Switch.kt#uh7d8r");
        long checkedThumbColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedHandleColor(), $composer, 6) : checkedThumbColor;
        long checkedTrackColor2 = (i & 2) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedTrackColor(), $composer, 6) : checkedTrackColor;
        long checkedBorderColor2 = (i & 4) != 0 ? Color.INSTANCE.m4222getTransparent0d7_KjU() : checkedBorderColor;
        long checkedIconColor2 = (i & 8) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedIconColor(), $composer, 6) : checkedIconColor;
        long uncheckedThumbColor2 = (i & 16) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedHandleColor(), $composer, 6) : uncheckedThumbColor;
        long uncheckedTrackColor2 = (i & 32) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedTrackColor(), $composer, 6) : uncheckedTrackColor;
        long uncheckedBorderColor2 = (i & 64) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor(), $composer, 6) : uncheckedBorderColor;
        long uncheckedIconColor2 = (i & 128) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedIconColor(), $composer, 6) : uncheckedIconColor;
        if ((i & 256) != 0) {
            long value = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedHandleColor(), $composer, 6);
            disabledCheckedThumbColor2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(value, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value) : SwitchTokens.INSTANCE.getDisabledSelectedHandleOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value) : 0.0f), MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface());
        } else {
            disabledCheckedThumbColor2 = disabledCheckedThumbColor;
        }
        if ((i & 512) != 0) {
            long value2 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedTrackColor(), $composer, 6);
            disabledCheckedTrackColor2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(value2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value2) : SwitchTokens.INSTANCE.getDisabledTrackOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value2) : 0.0f), MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface());
        } else {
            disabledCheckedTrackColor2 = disabledCheckedTrackColor;
        }
        long disabledCheckedBorderColor2 = (i & 1024) != 0 ? Color.INSTANCE.m4222getTransparent0d7_KjU() : disabledCheckedBorderColor;
        if ((i & 2048) != 0) {
            long value3 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledSelectedIconColor(), $composer, 6);
            disabledCheckedIconColor2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(value3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value3) : SwitchTokens.INSTANCE.getDisabledSelectedIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value3) : 0.0f), MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface());
        } else {
            disabledCheckedIconColor2 = disabledCheckedIconColor;
        }
        if ((i & 4096) != 0) {
            long value4 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor(), $composer, 6);
            disabledUncheckedThumbColor2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(value4, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value4) : SwitchTokens.INSTANCE.getDisabledUnselectedHandleOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value4) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value4) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value4) : 0.0f), MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface());
        } else {
            disabledUncheckedThumbColor2 = disabledUncheckedThumbColor;
        }
        if ((i & 8192) != 0) {
            long value5 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor(), $composer, 6);
            disabledUncheckedTrackColor2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(value5, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value5) : SwitchTokens.INSTANCE.getDisabledTrackOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value5) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value5) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value5) : 0.0f), MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface());
        } else {
            disabledUncheckedTrackColor2 = disabledUncheckedTrackColor;
        }
        if ((i & 16384) != 0) {
            long value6 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor(), $composer, 6);
            disabledUncheckedBorderColor2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(value6, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value6) : SwitchTokens.INSTANCE.getDisabledTrackOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value6) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value6) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value6) : 0.0f), MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface());
        } else {
            disabledUncheckedBorderColor2 = disabledUncheckedBorderColor;
        }
        if ((i & 32768) != 0) {
            long value7 = ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getDisabledUnselectedIconColor(), $composer, 6);
            disabledUncheckedIconColor2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(value7, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value7) : SwitchTokens.INSTANCE.getDisabledUnselectedIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value7) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value7) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value7) : 0.0f), MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface());
        } else {
            disabledUncheckedIconColor2 = disabledUncheckedIconColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1937926421, $changed, $changed1, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:362)");
        }
        SwitchColors switchColors = new SwitchColors(checkedThumbColor2, checkedTrackColor2, checkedBorderColor2, checkedIconColor2, uncheckedThumbColor2, uncheckedTrackColor2, uncheckedBorderColor2, uncheckedIconColor2, disabledCheckedThumbColor2, disabledCheckedTrackColor2, disabledCheckedBorderColor2, disabledCheckedIconColor2, disabledUncheckedThumbColor2, disabledUncheckedTrackColor2, disabledUncheckedBorderColor2, disabledUncheckedIconColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return switchColors;
    }

    public final SwitchColors getDefaultSwitchColors$material3_release(ColorScheme $this$defaultSwitchColors) {
        SwitchColors it = $this$defaultSwitchColors.getDefaultSwitchColorsCached();
        if (it == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getSelectedHandleColor());
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getSelectedTrackColor());
            long jM4222getTransparent0d7_KjU = Color.INSTANCE.m4222getTransparent0d7_KjU();
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getSelectedIconColor());
            long jFromToken4 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getUnselectedHandleColor());
            long jFromToken5 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getUnselectedTrackColor());
            long jFromToken6 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor());
            long jFromToken7 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getUnselectedIconColor());
            long jFromToken8 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getDisabledSelectedHandleColor());
            long jM4232compositeOverOWjLjI = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(jFromToken8, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken8) : SwitchTokens.INSTANCE.getDisabledSelectedHandleOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken8) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken8) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken8) : 0.0f), $this$defaultSwitchColors.getSurface());
            long jFromToken9 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getDisabledSelectedTrackColor());
            long jM4232compositeOverOWjLjI2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(jFromToken9, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken9) : SwitchTokens.INSTANCE.getDisabledTrackOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken9) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken9) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken9) : 0.0f), $this$defaultSwitchColors.getSurface());
            long jM4222getTransparent0d7_KjU2 = Color.INSTANCE.m4222getTransparent0d7_KjU();
            long jFromToken10 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getDisabledSelectedIconColor());
            long jM4232compositeOverOWjLjI3 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(jFromToken10, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken10) : SwitchTokens.INSTANCE.getDisabledSelectedIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken10) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken10) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken10) : 0.0f), $this$defaultSwitchColors.getSurface());
            long jFromToken11 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getDisabledUnselectedHandleColor());
            long jM4232compositeOverOWjLjI4 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(jFromToken11, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken11) : SwitchTokens.INSTANCE.getDisabledUnselectedHandleOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken11) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken11) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken11) : 0.0f), $this$defaultSwitchColors.getSurface());
            long jFromToken12 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getDisabledUnselectedTrackColor());
            long jM4232compositeOverOWjLjI5 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(jFromToken12, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken12) : SwitchTokens.INSTANCE.getDisabledTrackOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken12) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken12) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken12) : 0.0f), $this$defaultSwitchColors.getSurface());
            long jFromToken13 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getDisabledUnselectedTrackOutlineColor());
            long jM4232compositeOverOWjLjI6 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(jFromToken13, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken13) : SwitchTokens.INSTANCE.getDisabledTrackOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken13) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken13) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken13) : 0.0f), $this$defaultSwitchColors.getSurface());
            long jFromToken14 = ColorSchemeKt.fromToken($this$defaultSwitchColors, SwitchTokens.INSTANCE.getDisabledUnselectedIconColor());
            SwitchColors it2 = new SwitchColors(jFromToken, jFromToken2, jM4222getTransparent0d7_KjU, jFromToken3, jFromToken4, jFromToken5, jFromToken6, jFromToken7, jM4232compositeOverOWjLjI, jM4232compositeOverOWjLjI2, jM4222getTransparent0d7_KjU2, jM4232compositeOverOWjLjI3, jM4232compositeOverOWjLjI4, jM4232compositeOverOWjLjI5, jM4232compositeOverOWjLjI6, ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(jFromToken14, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken14) : SwitchTokens.INSTANCE.getDisabledUnselectedIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken14) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken14) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken14) : 0.0f), $this$defaultSwitchColors.getSurface()), null);
            $this$defaultSwitchColors.setDefaultSwitchColorsCached$material3_release(it2);
            return it2;
        }
        return it;
    }

    /* renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2594getIconSizeD9Ej5fM() {
        return IconSize;
    }
}
