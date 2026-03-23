package androidx.compose.material;

import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* compiled from: MaterialTextSelectionColors.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\"\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a2\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a*\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"DefaultSelectionBackgroundAlpha", "", "DesiredContrastRatio", "MinimumSelectionBackgroundAlpha", "binarySearchForAccessibleSelectionColorAlpha", "selectionColor", "Landroidx/compose/ui/graphics/Color;", "textColor", "backgroundColor", "binarySearchForAccessibleSelectionColorAlpha-ysEtTa8", "(JJJ)F", "calculateContrastRatio", "foreground", "background", "calculateContrastRatio--OWjLjI", "(JJ)F", "selectionColorAlpha", "calculateContrastRatio-nb2GgbA", "(JFJJ)F", "calculateSelectionBackgroundColor", "calculateSelectionBackgroundColor-ysEtTa8", "(JJJ)J", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "colors", "Landroidx/compose/material/Colors;", "(Landroidx/compose/material/Colors;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MaterialTextSelectionColorsKt {
    private static final float DefaultSelectionBackgroundAlpha = 0.4f;
    private static final float DesiredContrastRatio = 4.5f;
    private static final float MinimumSelectionBackgroundAlpha = 0.2f;

    public static final SelectionColors rememberTextSelectionColors(Colors colors, Composer $composer, int $changed) {
        long jM4197unboximpl;
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, -721696685, "C(rememberTextSelectionColors)45@1902L6,47@1930L384:MaterialTextSelectionColors.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-721696685, $changed, -1, "androidx.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:35)");
        }
        long primaryColor = colors.m1494getPrimary0d7_KjU();
        long backgroundColor = colors.m1487getBackground0d7_KjU();
        $composer.startReplaceGroup(1102762072);
        ComposerKt.sourceInformation($composer, "*43@1845L7");
        long $this$takeOrElse_u2dDxMtmZc$iv = ColorsKt.m1511contentColorFor4WTKRHQ(colors, backgroundColor);
        if ($this$takeOrElse_u2dDxMtmZc$iv != 16) {
            jM4197unboximpl = $this$takeOrElse_u2dDxMtmZc$iv;
        } else {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            jM4197unboximpl = ((Color) objConsume).m4197unboximpl();
        }
        $composer.endReplaceGroup();
        long textColorWithLowestAlpha = Color.m4185copywmQWz5c(jM4197unboximpl, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM4197unboximpl) : ContentAlpha.INSTANCE.getMedium($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(jM4197unboximpl) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM4197unboximpl) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM4197unboximpl) : 0.0f);
        ComposerKt.sourceInformationMarkerStart($composer, 1102766492, "CC(remember):MaterialTextSelectionColors.kt#9igjgp");
        boolean invalid$iv = $composer.changed(primaryColor) | $composer.changed(backgroundColor) | $composer.changed(textColorWithLowestAlpha);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new SelectionColors(colors.m1494getPrimary0d7_KjU(), m1594calculateSelectionBackgroundColorysEtTa8(primaryColor, textColorWithLowestAlpha, backgroundColor), null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        SelectionColors selectionColors = (SelectionColors) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return selectionColors;
    }

    /* renamed from: calculateSelectionBackgroundColor-ysEtTa8, reason: not valid java name */
    public static final long m1594calculateSelectionBackgroundColorysEtTa8(long selectionColor, long textColor, long backgroundColor) {
        float alpha;
        float maximumContrastRatio = m1593calculateContrastRationb2GgbA(selectionColor, 0.4f, textColor, backgroundColor);
        float minimumContrastRatio = m1593calculateContrastRationb2GgbA(selectionColor, 0.2f, textColor, backgroundColor);
        if (maximumContrastRatio >= DesiredContrastRatio) {
            alpha = 0.4f;
        } else {
            alpha = minimumContrastRatio < DesiredContrastRatio ? 0.2f : m1591binarySearchForAccessibleSelectionColorAlphaysEtTa8(selectionColor, textColor, backgroundColor);
        }
        return Color.m4185copywmQWz5c(selectionColor, (14 & 1) != 0 ? Color.m4189getAlphaimpl(selectionColor) : alpha, (14 & 2) != 0 ? Color.m4193getRedimpl(selectionColor) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(selectionColor) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(selectionColor) : 0.0f);
    }

    /* renamed from: binarySearchForAccessibleSelectionColorAlpha-ysEtTa8, reason: not valid java name */
    private static final float m1591binarySearchForAccessibleSelectionColorAlphaysEtTa8(long selectionColor, long textColor, long backgroundColor) {
        float lowAlpha = 0.2f;
        float alpha = 0.4f;
        float highAlpha = 0.4f;
        for (int attempts = 0; attempts < 7; attempts++) {
            float contrastRatio = m1593calculateContrastRationb2GgbA(selectionColor, alpha, textColor, backgroundColor);
            float percentageError = (contrastRatio / DesiredContrastRatio) - 1.0f;
            boolean z = false;
            if (0.0f <= percentageError && percentageError <= 0.01f) {
                z = true;
            }
            if (z) {
                break;
            }
            if (percentageError < 0.0f) {
                highAlpha = alpha;
            } else {
                lowAlpha = alpha;
            }
            alpha = (highAlpha + lowAlpha) / 2.0f;
        }
        return alpha;
    }

    /* renamed from: calculateContrastRatio-nb2GgbA, reason: not valid java name */
    private static final float m1593calculateContrastRationb2GgbA(long selectionColor, float selectionColorAlpha, long textColor, long backgroundColor) {
        long compositeBackground = ColorKt.m4232compositeOverOWjLjI(Color.m4185copywmQWz5c(selectionColor, (14 & 1) != 0 ? Color.m4189getAlphaimpl(selectionColor) : selectionColorAlpha, (14 & 2) != 0 ? Color.m4193getRedimpl(selectionColor) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(selectionColor) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(selectionColor) : 0.0f), backgroundColor);
        long compositeTextColor = ColorKt.m4232compositeOverOWjLjI(textColor, compositeBackground);
        return m1592calculateContrastRatioOWjLjI(compositeTextColor, compositeBackground);
    }

    /* renamed from: calculateContrastRatio--OWjLjI, reason: not valid java name */
    public static final float m1592calculateContrastRatioOWjLjI(long foreground, long background) {
        float foregroundLuminance = ColorKt.m4239luminance8_81llA(foreground) + 0.05f;
        float backgroundLuminance = ColorKt.m4239luminance8_81llA(background) + 0.05f;
        return Math.max(foregroundLuminance, backgroundLuminance) / Math.min(foregroundLuminance, backgroundLuminance);
    }
}
