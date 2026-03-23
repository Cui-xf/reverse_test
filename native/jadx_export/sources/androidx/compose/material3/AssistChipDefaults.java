package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ8\u0010\u0015\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010#Jb\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u00182\b\b\u0002\u0010%\u001a\u00020\u00182\b\b\u0002\u0010&\u001a\u00020\u00182\b\b\u0002\u0010'\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020\u00182\b\b\u0002\u0010)\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020\u00182\b\b\u0002\u0010+\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010-JN\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\u00042\b\b\u0002\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u00042\b\b\u0002\u00103\u001a\u00020\u00042\b\b\u0002\u00104\u001a\u00020\u00042\b\b\u0002\u00105\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010#Jb\u00108\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\u00182\b\b\u0002\u0010%\u001a\u00020\u00182\b\b\u0002\u0010&\u001a\u00020\u00182\b\b\u0002\u0010'\u001a\u00020\u00182\b\b\u0002\u0010(\u001a\u00020\u00182\b\b\u0002\u0010)\u001a\u00020\u00182\b\b\u0002\u0010*\u001a\u00020\u00182\b\b\u0002\u0010+\u001a\u00020\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010-JN\u0010:\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\u00042\b\b\u0002\u00101\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u00042\b\b\u0002\u00103\u001a\u00020\u00042\b\b\u0002\u00104\u001a\u00020\u00042\b\b\u0002\u00105\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b;\u00107R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u00020\u000f*\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006<"}, d2 = {"Landroidx/compose/material3/AssistChipDefaults;", "", "()V", "Height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM", "()F", "F", "IconSize", "getIconSize-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultAssistChipColors", "Landroidx/compose/material3/ChipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultAssistChipColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "defaultElevatedAssistChipColors", "getDefaultElevatedAssistChipColors$material3_release", "assistChipBorder", "Landroidx/compose/material3/ChipBorder;", "borderColor", "Landroidx/compose/ui/graphics/Color;", "disabledBorderColor", "borderWidth", "assistChipBorder-d_3_b6Q", "(JJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipBorder;", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "assistChipBorder-h1eT-Ww", "(ZJJFLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "assistChipColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ChipColors;", "containerColor", "labelColor", "leadingIconContentColor", "trailingIconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconContentColor", "disabledTrailingIconContentColor", "assistChipColors-oq7We08", "(JJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipColors;", "assistChipElevation", "Landroidx/compose/material3/ChipElevation;", "elevation", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "assistChipElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ChipElevation;", "elevatedAssistChipColors", "elevatedAssistChipColors-oq7We08", "elevatedAssistChipElevation", "elevatedAssistChipElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AssistChipDefaults {
    public static final int $stable = 0;
    public static final AssistChipDefaults INSTANCE = new AssistChipDefaults();
    private static final float Height = AssistChipTokens.INSTANCE.m3021getContainerHeightD9Ej5fM();
    private static final float IconSize = AssistChipTokens.INSTANCE.m3030getIconSizeD9Ej5fM();

    private AssistChipDefaults() {
    }

    /* renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m1805getHeightD9Ej5fM() {
        return Height;
    }

    /* renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1806getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final ChipColors assistChipColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1961061417, "C(assistChipColors)1019@48412L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1961061417, $changed, -1, "androidx.compose.material3.AssistChipDefaults.assistChipColors (Chip.kt:1019)");
        }
        ChipColors defaultAssistChipColors$material3_release = getDefaultAssistChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultAssistChipColors$material3_release;
    }

    /* renamed from: assistChipColors-oq7We08, reason: not valid java name */
    public final ChipColors m1801assistChipColorsoq7We08(long containerColor, long labelColor, long leadingIconContentColor, long trailingIconContentColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconContentColor, long disabledTrailingIconContentColor, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -391745725, "C(assistChipColors)P(0:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)1045@49833L11:Chip.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : containerColor;
        long labelColor2 = (i & 2) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : labelColor;
        long leadingIconContentColor2 = (i & 4) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : leadingIconContentColor;
        long trailingIconContentColor2 = (i & 8) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : trailingIconContentColor;
        long disabledContainerColor2 = (i & 16) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledContainerColor;
        long disabledLabelColor2 = (i & 32) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledLabelColor;
        long disabledLeadingIconContentColor2 = (i & 64) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledLeadingIconContentColor;
        long disabledTrailingIconContentColor2 = (i & 128) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledTrailingIconContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-391745725, $changed, -1, "androidx.compose.material3.AssistChipDefaults.assistChipColors (Chip.kt:1045)");
        }
        ChipColors chipColorsM1874copyFD3wquc = getDefaultAssistChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m1874copyFD3wquc(containerColor2, labelColor2, leadingIconContentColor2, trailingIconContentColor2, disabledContainerColor2, disabledLabelColor2, disabledLeadingIconContentColor2, disabledTrailingIconContentColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return chipColorsM1874copyFD3wquc;
    }

    public final ChipColors getDefaultAssistChipColors$material3_release(ColorScheme $this$defaultAssistChipColors) {
        ChipColors it = $this$defaultAssistChipColors.getDefaultAssistChipColorsCached();
        if (it != null) {
            return it;
        }
        long jM4222getTransparent0d7_KjU = Color.INSTANCE.m4222getTransparent0d7_KjU();
        long jFromToken = ColorSchemeKt.fromToken($this$defaultAssistChipColors, AssistChipTokens.INSTANCE.getLabelTextColor());
        long jFromToken2 = ColorSchemeKt.fromToken($this$defaultAssistChipColors, AssistChipTokens.INSTANCE.getIconColor());
        long jFromToken3 = ColorSchemeKt.fromToken($this$defaultAssistChipColors, AssistChipTokens.INSTANCE.getIconColor());
        long jM4222getTransparent0d7_KjU2 = Color.INSTANCE.m4222getTransparent0d7_KjU();
        long jFromToken4 = ColorSchemeKt.fromToken($this$defaultAssistChipColors, AssistChipTokens.INSTANCE.getDisabledLabelTextColor());
        long jM4185copywmQWz5c = Color.m4185copywmQWz5c(jFromToken4, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken4) : AssistChipTokens.INSTANCE.getDisabledLabelTextOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken4) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken4) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken4) : 0.0f);
        long jFromToken5 = ColorSchemeKt.fromToken($this$defaultAssistChipColors, AssistChipTokens.INSTANCE.getDisabledIconColor());
        long jM4185copywmQWz5c2 = Color.m4185copywmQWz5c(jFromToken5, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken5) : AssistChipTokens.INSTANCE.getDisabledIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken5) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken5) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken5) : 0.0f);
        long jFromToken6 = ColorSchemeKt.fromToken($this$defaultAssistChipColors, AssistChipTokens.INSTANCE.getDisabledIconColor());
        ChipColors it2 = new ChipColors(jM4222getTransparent0d7_KjU, jFromToken, jFromToken2, jFromToken3, jM4222getTransparent0d7_KjU2, jM4185copywmQWz5c, jM4185copywmQWz5c2, Color.m4185copywmQWz5c(jFromToken6, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken6) : AssistChipTokens.INSTANCE.getDisabledIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken6) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken6) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken6) : 0.0f), null);
        $this$defaultAssistChipColors.setDefaultAssistChipColorsCached$material3_release(it2);
        return it2;
    }

    /* renamed from: assistChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m1802assistChipElevationaqJV_2Y(float elevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float elevation2;
        float pressedElevation2;
        float focusedElevation2;
        ComposerKt.sourceInformationMarkerStart($composer, 245366099, "C(assistChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if ((i & 1) != 0) {
            float elevation3 = AssistChipTokens.INSTANCE.m3028getFlatContainerElevationD9Ej5fM();
            elevation2 = elevation3;
        } else {
            elevation2 = elevation;
        }
        if ((i & 2) != 0) {
            float pressedElevation3 = elevation2;
            pressedElevation2 = pressedElevation3;
        } else {
            pressedElevation2 = pressedElevation;
        }
        if ((i & 4) != 0) {
            float focusedElevation3 = elevation2;
            focusedElevation2 = focusedElevation3;
        } else {
            focusedElevation2 = focusedElevation;
        }
        float hoveredElevation2 = (i & 8) != 0 ? elevation2 : hoveredElevation;
        float draggedElevation2 = (i & 16) != 0 ? AssistChipTokens.INSTANCE.m3022getDraggedContainerElevationD9Ej5fM() : draggedElevation;
        float disabledElevation2 = (i & 32) != 0 ? elevation2 : disabledElevation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(245366099, $changed, -1, "androidx.compose.material3.AssistChipDefaults.assistChipElevation (Chip.kt:1098)");
        }
        ChipElevation chipElevation = new ChipElevation(elevation2, pressedElevation2, focusedElevation2, hoveredElevation2, draggedElevation2, disabledElevation2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return chipElevation;
    }

    /* renamed from: assistChipBorder-h1eT-Ww, reason: not valid java name */
    public final BorderStroke m1800assistChipBorderh1eTWw(boolean enabled, long borderColor, long disabledBorderColor, float borderWidth, Composer $composer, int $changed, int i) {
        long disabledBorderColor2;
        ComposerKt.sourceInformationMarkerStart($composer, -1458649561, "C(assistChipBorder)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color,1:c#ui.unit.Dp)1118@53518L5,1120@53616L5:Chip.kt#uh7d8r");
        long borderColor2 = (i & 2) != 0 ? ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatOutlineColor(), $composer, 6) : borderColor;
        if ((i & 4) != 0) {
            long value = ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatDisabledOutlineColor(), $composer, 6);
            disabledBorderColor2 = Color.m4185copywmQWz5c(value, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value) : AssistChipTokens.INSTANCE.getFlatDisabledOutlineOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value) : 0.0f);
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        float borderWidth2 = (i & 8) != 0 ? AssistChipTokens.INSTANCE.m3029getFlatOutlineWidthD9Ej5fM() : borderWidth;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1458649561, $changed, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:1124)");
        }
        BorderStroke borderStrokeM257BorderStrokecXLIe8U = BorderStrokeKt.m257BorderStrokecXLIe8U(borderWidth2, enabled ? borderColor2 : disabledBorderColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return borderStrokeM257BorderStrokecXLIe8U;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Maintained for binary compatibility. Use the assistChipBorder function that returns BorderStroke instead", replaceWith = @ReplaceWith(expression = "assistChipBorder(enabled, borderColor, disabledBorderColor, borderWidth)", imports = {}))
    /* renamed from: assistChipBorder-d_3_b6Q, reason: not valid java name */
    public final ChipBorder m1799assistChipBorderd_3_b6Q(long borderColor, long disabledBorderColor, float borderWidth, Composer $composer, int $changed, int i) {
        long disabledBorderColor2;
        ComposerKt.sourceInformationMarkerStart($composer, 382372847, "C(assistChipBorder)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,1:c#ui.unit.Dp)1145@54691L5,1147@54789L5:Chip.kt#uh7d8r");
        long borderColor2 = (i & 1) != 0 ? ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatOutlineColor(), $composer, 6) : borderColor;
        if ((i & 2) != 0) {
            long value = ColorSchemeKt.getValue(AssistChipTokens.INSTANCE.getFlatDisabledOutlineColor(), $composer, 6);
            disabledBorderColor2 = Color.m4185copywmQWz5c(value, (14 & 1) != 0 ? Color.m4189getAlphaimpl(value) : AssistChipTokens.INSTANCE.getFlatDisabledOutlineOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(value) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(value) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(value) : 0.0f);
        } else {
            disabledBorderColor2 = disabledBorderColor;
        }
        float borderWidth2 = (i & 4) != 0 ? AssistChipTokens.INSTANCE.m3029getFlatOutlineWidthD9Ej5fM() : borderWidth;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(382372847, $changed, -1, "androidx.compose.material3.AssistChipDefaults.assistChipBorder (Chip.kt:1152)");
        }
        ChipBorder chipBorder = new ChipBorder(borderColor2, disabledBorderColor2, borderWidth2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return chipBorder;
    }

    public final ChipColors elevatedAssistChipColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 655175583, "C(elevatedAssistChipColors)1163@55344L11:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(655175583, $changed, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipColors (Chip.kt:1163)");
        }
        ChipColors defaultElevatedAssistChipColors$material3_release = getDefaultElevatedAssistChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultElevatedAssistChipColors$material3_release;
    }

    /* renamed from: elevatedAssistChipColors-oq7We08, reason: not valid java name */
    public final ChipColors m1803elevatedAssistChipColorsoq7We08(long containerColor, long labelColor, long leadingIconContentColor, long trailingIconContentColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconContentColor, long disabledTrailingIconContentColor, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -535762675, "C(elevatedAssistChipColors)P(0:c#ui.graphics.Color,5:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)1189@56785L11:Chip.kt#uh7d8r");
        long containerColor2 = (i & 1) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : containerColor;
        long labelColor2 = (i & 2) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : labelColor;
        long leadingIconContentColor2 = (i & 4) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : leadingIconContentColor;
        long trailingIconContentColor2 = (i & 8) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : trailingIconContentColor;
        long disabledContainerColor2 = (i & 16) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledContainerColor;
        long disabledLabelColor2 = (i & 32) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledLabelColor;
        long disabledLeadingIconContentColor2 = (i & 64) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledLeadingIconContentColor;
        long disabledTrailingIconContentColor2 = (i & 128) != 0 ? Color.INSTANCE.m4223getUnspecified0d7_KjU() : disabledTrailingIconContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-535762675, $changed, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipColors (Chip.kt:1189)");
        }
        ChipColors chipColorsM1874copyFD3wquc = SuggestionChipDefaults.INSTANCE.getDefaultElevatedSuggestionChipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6)).m1874copyFD3wquc(containerColor2, labelColor2, leadingIconContentColor2, trailingIconContentColor2, disabledContainerColor2, disabledLabelColor2, disabledLeadingIconContentColor2, disabledTrailingIconContentColor2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return chipColorsM1874copyFD3wquc;
    }

    public final ChipColors getDefaultElevatedAssistChipColors$material3_release(ColorScheme $this$defaultElevatedAssistChipColors) {
        ChipColors it = $this$defaultElevatedAssistChipColors.getDefaultElevatedAssistChipColorsCached();
        if (it == null) {
            long jFromToken = ColorSchemeKt.fromToken($this$defaultElevatedAssistChipColors, AssistChipTokens.INSTANCE.getElevatedContainerColor());
            long jFromToken2 = ColorSchemeKt.fromToken($this$defaultElevatedAssistChipColors, AssistChipTokens.INSTANCE.getLabelTextColor());
            long jFromToken3 = ColorSchemeKt.fromToken($this$defaultElevatedAssistChipColors, AssistChipTokens.INSTANCE.getIconColor());
            long jFromToken4 = ColorSchemeKt.fromToken($this$defaultElevatedAssistChipColors, AssistChipTokens.INSTANCE.getIconColor());
            long jFromToken5 = ColorSchemeKt.fromToken($this$defaultElevatedAssistChipColors, AssistChipTokens.INSTANCE.getElevatedDisabledContainerColor());
            long jM4185copywmQWz5c = Color.m4185copywmQWz5c(jFromToken5, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken5) : AssistChipTokens.INSTANCE.getElevatedDisabledContainerOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken5) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken5) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken5) : 0.0f);
            long jFromToken6 = ColorSchemeKt.fromToken($this$defaultElevatedAssistChipColors, AssistChipTokens.INSTANCE.getDisabledLabelTextColor());
            long jM4185copywmQWz5c2 = Color.m4185copywmQWz5c(jFromToken6, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken6) : AssistChipTokens.INSTANCE.getDisabledLabelTextOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken6) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken6) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken6) : 0.0f);
            long jFromToken7 = ColorSchemeKt.fromToken($this$defaultElevatedAssistChipColors, AssistChipTokens.INSTANCE.getDisabledIconColor());
            long jM4185copywmQWz5c3 = Color.m4185copywmQWz5c(jFromToken7, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken7) : AssistChipTokens.INSTANCE.getDisabledIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken7) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken7) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken7) : 0.0f);
            long jFromToken8 = ColorSchemeKt.fromToken($this$defaultElevatedAssistChipColors, AssistChipTokens.INSTANCE.getDisabledIconColor());
            ChipColors it2 = new ChipColors(jFromToken, jFromToken2, jFromToken3, jFromToken4, jM4185copywmQWz5c, jM4185copywmQWz5c2, jM4185copywmQWz5c3, Color.m4185copywmQWz5c(jFromToken8, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jFromToken8) : AssistChipTokens.INSTANCE.getDisabledIconOpacity(), (14 & 2) != 0 ? Color.m4193getRedimpl(jFromToken8) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jFromToken8) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jFromToken8) : 0.0f), null);
            $this$defaultElevatedAssistChipColors.setDefaultElevatedAssistChipColorsCached$material3_release(it2);
            return it2;
        }
        return it;
    }

    /* renamed from: elevatedAssistChipElevation-aqJV_2Y, reason: not valid java name */
    public final ChipElevation m1804elevatedAssistChipElevationaqJV_2Y(float elevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i) {
        float elevation2;
        float pressedElevation2;
        float focusedElevation2;
        ComposerKt.sourceInformationMarkerStart($composer, 1457698077, "C(elevatedAssistChipElevation)P(2:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,1:c#ui.unit.Dp,0:c#ui.unit.Dp):Chip.kt#uh7d8r");
        if ((i & 1) != 0) {
            float elevation3 = AssistChipTokens.INSTANCE.m3023getElevatedContainerElevationD9Ej5fM();
            elevation2 = elevation3;
        } else {
            elevation2 = elevation;
        }
        if ((i & 2) != 0) {
            float pressedElevation3 = AssistChipTokens.INSTANCE.m3027getElevatedPressedContainerElevationD9Ej5fM();
            pressedElevation2 = pressedElevation3;
        } else {
            pressedElevation2 = pressedElevation;
        }
        if ((i & 4) != 0) {
            float focusedElevation3 = AssistChipTokens.INSTANCE.m3025getElevatedFocusContainerElevationD9Ej5fM();
            focusedElevation2 = focusedElevation3;
        } else {
            focusedElevation2 = focusedElevation;
        }
        float hoveredElevation2 = (i & 8) != 0 ? AssistChipTokens.INSTANCE.m3026getElevatedHoverContainerElevationD9Ej5fM() : hoveredElevation;
        float draggedElevation2 = (i & 16) != 0 ? AssistChipTokens.INSTANCE.m3022getDraggedContainerElevationD9Ej5fM() : draggedElevation;
        float disabledElevation2 = (i & 32) != 0 ? AssistChipTokens.INSTANCE.m3024getElevatedDisabledContainerElevationD9Ej5fM() : disabledElevation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1457698077, $changed, -1, "androidx.compose.material3.AssistChipDefaults.elevatedAssistChipElevation (Chip.kt:1244)");
        }
        ChipElevation chipElevation = new ChipElevation(elevation2, pressedElevation2, focusedElevation2, hoveredElevation2, draggedElevation2, disabledElevation2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return chipElevation;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1988153916, "C1255@60496L5:Chip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1988153916, $changed, -1, "androidx.compose.material3.AssistChipDefaults.<get-shape> (Chip.kt:1255)");
        }
        Shape value = ShapesKt.getValue(AssistChipTokens.INSTANCE.getContainerShape(), $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return value;
    }
}
