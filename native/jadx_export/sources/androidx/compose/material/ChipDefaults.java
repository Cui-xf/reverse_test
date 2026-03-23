package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 Jl\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)JN\u0010*\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010 Jl\u0010,\u001a\u00020\"2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\tR\u0019\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/material/ChipDefaults;", "", "()V", "ContentOpacity", "", "LeadingIconOpacity", "LeadingIconSize", "Landroidx/compose/ui/unit/Dp;", "getLeadingIconSize-D9Ej5fM", "()F", "F", "MinHeight", "getMinHeight-D9Ej5fM", "OutlinedBorderOpacity", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "SelectedIconSize", "getSelectedIconSize-D9Ej5fM", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "chipColors", "Landroidx/compose/material/ChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconContentColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconContentColor", "chipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ChipColors;", "filterChipColors", "Landroidx/compose/material/SelectableChipColors;", "leadingIconColor", "disabledLeadingIconColor", "selectedBackgroundColor", "selectedContentColor", "selectedLeadingIconColor", "filterChipColors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/SelectableChipColors;", "outlinedChipColors", "outlinedChipColors-5tl4gsc", "outlinedFilterChipColors", "outlinedFilterChipColors-J08w3-E", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ChipDefaults {
    public static final int $stable = 0;
    public static final float ContentOpacity = 0.87f;
    public static final float LeadingIconOpacity = 0.54f;
    public static final float OutlinedBorderOpacity = 0.12f;
    public static final ChipDefaults INSTANCE = new ChipDefaults();
    private static final float MinHeight = Dp.m6693constructorimpl(32);
    private static final float OutlinedBorderSize = Dp.m6693constructorimpl(1);
    private static final float LeadingIconSize = Dp.m6693constructorimpl(20);
    private static final float SelectedIconSize = Dp.m6693constructorimpl(18);

    private ChipDefaults() {
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1480getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: chipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m1477chipColors5tl4gsc(long backgroundColor, long contentColor, long leadingIconContentColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconContentColor, Composer $composer, int $changed, int i) {
        long backgroundColor2;
        long contentColor2;
        long disabledBackgroundColor2;
        long disabledContentColor2;
        long disabledLeadingIconContentColor2;
        ComposerKt.sourceInformationMarkerStart($composer, 1838505436, "C(chipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)392@17154L6,393@17248L6,394@17309L6,397@17511L6,398@17571L8,399@17646L6,401@17753L8,404@17901L8:Chip.kt#jmzs0o");
        if ((i & 1) != 0) {
            long jM1493getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            backgroundColor2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU) : 0.12f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU) : 0.0f), MaterialTheme.INSTANCE.getColors($composer, 6).m1498getSurface0d7_KjU());
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((i & 2) != 0) {
            long jM1493getOnSurface0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            contentColor2 = Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU2) : 0.87f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU2) : 0.0f);
        } else {
            contentColor2 = contentColor;
        }
        long leadingIconContentColor2 = (i & 4) != 0 ? Color.m4185copywmQWz5c(contentColor2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(contentColor2) : 0.54f, (14 & 2) != 0 ? Color.m4193getRedimpl(contentColor2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(contentColor2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(contentColor2) : 0.0f) : leadingIconContentColor;
        if ((i & 8) != 0) {
            long jM1493getOnSurface0d7_KjU3 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            disabledBackgroundColor2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU3) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.12f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU3) : 0.0f), MaterialTheme.INSTANCE.getColors($composer, 6).m1498getSurface0d7_KjU());
        } else {
            disabledBackgroundColor2 = disabledBackgroundColor;
        }
        if ((i & 16) != 0) {
            long contentColor3 = contentColor2;
            disabledContentColor2 = Color.m4185copywmQWz5c(contentColor3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(contentColor3) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.87f, (14 & 2) != 0 ? Color.m4193getRedimpl(contentColor3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(contentColor3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(contentColor3) : 0.0f);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i & 32) != 0) {
            long leadingIconContentColor3 = leadingIconContentColor2;
            disabledLeadingIconContentColor2 = Color.m4185copywmQWz5c(leadingIconContentColor3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(leadingIconContentColor3) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.54f, (14 & 2) != 0 ? Color.m4193getRedimpl(leadingIconContentColor3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(leadingIconContentColor3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(leadingIconContentColor3) : 0.0f);
        } else {
            disabledLeadingIconContentColor2 = disabledLeadingIconContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1838505436, $changed, -1, "androidx.compose.material.ChipDefaults.chipColors (Chip.kt:405)");
        }
        DefaultChipColors defaultChipColors = new DefaultChipColors(backgroundColor2, contentColor2, leadingIconContentColor2, disabledBackgroundColor2, disabledContentColor2, disabledLeadingIconContentColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultChipColors;
    }

    /* renamed from: outlinedChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m1483outlinedChipColors5tl4gsc(long backgroundColor, long contentColor, long leadingIconContentColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconContentColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContentColor2;
        long disabledLeadingIconContentColor2;
        ComposerKt.sourceInformationMarkerStart($composer, -1763922662, "C(outlinedChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)428@19097L6,429@19157L6,433@19440L8,436@19588L8,437@19640L342:Chip.kt#jmzs0o");
        long backgroundColor2 = (i & 1) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1498getSurface0d7_KjU() : backgroundColor;
        if ((i & 2) != 0) {
            long jM1493getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            contentColor2 = Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU) : 0.87f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU) : 0.0f);
        } else {
            contentColor2 = contentColor;
        }
        long leadingIconContentColor2 = (i & 4) != 0 ? Color.m4185copywmQWz5c(contentColor2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(contentColor2) : 0.54f, (14 & 2) != 0 ? Color.m4193getRedimpl(contentColor2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(contentColor2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(contentColor2) : 0.0f) : leadingIconContentColor;
        long disabledBackgroundColor2 = (i & 8) != 0 ? backgroundColor2 : disabledBackgroundColor;
        if ((i & 16) != 0) {
            long contentColor3 = contentColor2;
            disabledContentColor2 = Color.m4185copywmQWz5c(contentColor3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(contentColor3) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.87f, (14 & 2) != 0 ? Color.m4193getRedimpl(contentColor3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(contentColor3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(contentColor3) : 0.0f);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i & 32) != 0) {
            long leadingIconContentColor3 = leadingIconContentColor2;
            disabledLeadingIconContentColor2 = Color.m4185copywmQWz5c(leadingIconContentColor3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(leadingIconContentColor3) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.54f, (14 & 2) != 0 ? Color.m4193getRedimpl(leadingIconContentColor3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(leadingIconContentColor3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(leadingIconContentColor3) : 0.0f);
        } else {
            disabledLeadingIconContentColor2 = disabledLeadingIconContentColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1763922662, $changed, -1, "androidx.compose.material.ChipDefaults.outlinedChipColors (Chip.kt:437)");
        }
        long backgroundColor3 = backgroundColor2;
        long backgroundColor4 = contentColor2;
        ChipColors chipColorsM1477chipColors5tl4gsc = m1477chipColors5tl4gsc(backgroundColor3, backgroundColor4, leadingIconContentColor2, disabledBackgroundColor2, disabledContentColor2, disabledLeadingIconContentColor2, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | (57344 & $changed) | (458752 & $changed) | (3670016 & $changed), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return chipColorsM1477chipColors5tl4gsc;
    }

    /* renamed from: filterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m1478filterChipColorsJ08w3E(long backgroundColor, long contentColor, long leadingIconColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconColor, long selectedBackgroundColor, long selectedContentColor, long selectedLeadingIconColor, Composer $composer, int $changed, int i) {
        long backgroundColor2;
        long contentColor2;
        long disabledBackgroundColor2;
        long disabledContentColor2;
        long disabledLeadingIconColor2;
        long selectedBackgroundColor2;
        long selectedContentColor2;
        long selectedLeadingIconColor2;
        ComposerKt.sourceInformationMarkerStart($composer, 830140629, "C(filterChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color)462@20979L6,463@21073L6,464@21134L6,467@21321L6,468@21381L8,469@21456L6,471@21563L8,474@21698L8,476@21794L6,479@21953L6,482@22114L6:Chip.kt#jmzs0o");
        if ((i & 1) != 0) {
            long jM1493getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            backgroundColor2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU) : 0.12f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU) : 0.0f), MaterialTheme.INSTANCE.getColors($composer, 6).m1498getSurface0d7_KjU());
        } else {
            backgroundColor2 = backgroundColor;
        }
        if ((i & 2) != 0) {
            long jM1493getOnSurface0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            contentColor2 = Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU2) : 0.87f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU2) : 0.0f);
        } else {
            contentColor2 = contentColor;
        }
        long leadingIconColor2 = (i & 4) != 0 ? Color.m4185copywmQWz5c(contentColor2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(contentColor2) : 0.54f, (14 & 2) != 0 ? Color.m4193getRedimpl(contentColor2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(contentColor2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(contentColor2) : 0.0f) : leadingIconColor;
        if ((i & 8) != 0) {
            long jM1493getOnSurface0d7_KjU3 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            disabledBackgroundColor2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU3) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.12f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU3) : 0.0f), MaterialTheme.INSTANCE.getColors($composer, 6).m1498getSurface0d7_KjU());
        } else {
            disabledBackgroundColor2 = disabledBackgroundColor;
        }
        if ((i & 16) != 0) {
            long contentColor3 = contentColor2;
            disabledContentColor2 = Color.m4185copywmQWz5c(contentColor3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(contentColor3) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.87f, (14 & 2) != 0 ? Color.m4193getRedimpl(contentColor3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(contentColor3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(contentColor3) : 0.0f);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i & 32) != 0) {
            long leadingIconColor3 = leadingIconColor2;
            disabledLeadingIconColor2 = Color.m4185copywmQWz5c(leadingIconColor3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(leadingIconColor3) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.54f, (14 & 2) != 0 ? Color.m4193getRedimpl(leadingIconColor3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(leadingIconColor3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(leadingIconColor3) : 0.0f);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i & 64) != 0) {
            long jM1493getOnSurface0d7_KjU4 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            selectedBackgroundColor2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU4, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU4) : 0.12f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU4) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU4) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU4) : 0.0f), backgroundColor2);
        } else {
            selectedBackgroundColor2 = selectedBackgroundColor;
        }
        if ((i & 128) != 0) {
            long jM1493getOnSurface0d7_KjU5 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            selectedContentColor2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU5, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU5) : 0.16f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU5) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU5) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU5) : 0.0f), contentColor2);
        } else {
            selectedContentColor2 = selectedContentColor;
        }
        if ((i & 256) != 0) {
            long jM1493getOnSurface0d7_KjU6 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            selectedLeadingIconColor2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU6, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU6) : 0.16f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU6) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU6) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU6) : 0.0f), leadingIconColor2);
        } else {
            selectedLeadingIconColor2 = selectedLeadingIconColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(830140629, $changed, -1, "androidx.compose.material.ChipDefaults.filterChipColors (Chip.kt:485)");
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(backgroundColor2, contentColor2, leadingIconColor2, disabledBackgroundColor2, disabledContentColor2, disabledLeadingIconColor2, selectedBackgroundColor2, selectedContentColor2, selectedLeadingIconColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultSelectableChipColors;
    }

    /* renamed from: outlinedFilterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m1484outlinedFilterChipColorsJ08w3E(long backgroundColor, long contentColor, long leadingIconColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconColor, long selectedBackgroundColor, long selectedContentColor, long selectedLeadingIconColor, Composer $composer, int $changed, int i) {
        long contentColor2;
        long disabledContentColor2;
        long disabledLeadingIconColor2;
        long selectedBackgroundColor2;
        long selectedContentColor2;
        long selectedLeadingIconColor2;
        ComposerKt.sourceInformationMarkerStart($composer, 346878099, "C(outlinedFilterChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color)513@23764L6,514@23824L6,518@24084L8,521@24219L8,523@24315L6,526@24475L6,529@24636L6:Chip.kt#jmzs0o");
        long backgroundColor2 = (i & 1) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1498getSurface0d7_KjU() : backgroundColor;
        if ((i & 2) != 0) {
            long jM1493getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            contentColor2 = Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU) : 0.87f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU) : 0.0f);
        } else {
            contentColor2 = contentColor;
        }
        long leadingIconColor2 = (i & 4) != 0 ? Color.m4185copywmQWz5c(contentColor2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(contentColor2) : 0.54f, (14 & 2) != 0 ? Color.m4193getRedimpl(contentColor2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(contentColor2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(contentColor2) : 0.0f) : leadingIconColor;
        long disabledBackgroundColor2 = (i & 8) != 0 ? backgroundColor2 : disabledBackgroundColor;
        if ((i & 16) != 0) {
            long contentColor3 = contentColor2;
            disabledContentColor2 = Color.m4185copywmQWz5c(contentColor3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(contentColor3) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.87f, (14 & 2) != 0 ? Color.m4193getRedimpl(contentColor3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(contentColor3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(contentColor3) : 0.0f);
        } else {
            disabledContentColor2 = disabledContentColor;
        }
        if ((i & 32) != 0) {
            long leadingIconColor3 = leadingIconColor2;
            disabledLeadingIconColor2 = Color.m4185copywmQWz5c(leadingIconColor3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(leadingIconColor3) : ContentAlpha.INSTANCE.getDisabled($composer, 6) * 0.54f, (14 & 2) != 0 ? Color.m4193getRedimpl(leadingIconColor3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(leadingIconColor3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(leadingIconColor3) : 0.0f);
        } else {
            disabledLeadingIconColor2 = disabledLeadingIconColor;
        }
        if ((i & 64) != 0) {
            long jM1493getOnSurface0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            selectedBackgroundColor2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU2) : 0.16f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU2) : 0.0f), backgroundColor2);
        } else {
            selectedBackgroundColor2 = selectedBackgroundColor;
        }
        if ((i & 128) != 0) {
            long jM1493getOnSurface0d7_KjU3 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            selectedContentColor2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU3, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU3) : 0.16f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU3) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU3) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU3) : 0.0f), contentColor2);
        } else {
            selectedContentColor2 = selectedContentColor;
        }
        if ((i & 256) != 0) {
            long jM1493getOnSurface0d7_KjU4 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            selectedLeadingIconColor2 = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU4, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU4) : 0.16f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU4) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU4) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU4) : 0.0f), leadingIconColor2);
        } else {
            selectedLeadingIconColor2 = selectedLeadingIconColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(346878099, $changed, -1, "androidx.compose.material.ChipDefaults.outlinedFilterChipColors (Chip.kt:532)");
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(backgroundColor2, contentColor2, leadingIconColor2, disabledBackgroundColor2, disabledContentColor2, disabledLeadingIconColor2, selectedBackgroundColor2, selectedContentColor2, selectedLeadingIconColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultSelectableChipColors;
    }

    public final BorderStroke getOutlinedBorder(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1650225597, "C550@25483L6:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1650225597, $changed, -1, "androidx.compose.material.ChipDefaults.<get-outlinedBorder> (Chip.kt:549)");
        }
        float f = OutlinedBorderSize;
        long jM1493getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
        BorderStroke borderStrokeM257BorderStrokecXLIe8U = BorderStrokeKt.m257BorderStrokecXLIe8U(f, Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU) : 0.12f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU) : 0.0f));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return borderStrokeM257BorderStrokecXLIe8U;
    }

    /* renamed from: getOutlinedBorderSize-D9Ej5fM, reason: not valid java name */
    public final float m1481getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    /* renamed from: getLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1479getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    /* renamed from: getSelectedIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1482getSelectedIconSizeD9Ej5fM() {
        return SelectedIconSize;
    }
}
