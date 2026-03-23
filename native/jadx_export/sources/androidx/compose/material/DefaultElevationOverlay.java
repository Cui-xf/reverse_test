package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* compiled from: ElevationOverlay.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0017ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"Landroidx/compose/material/DefaultElevationOverlay;", "Landroidx/compose/material/ElevationOverlay;", "()V", "apply", "Landroidx/compose/ui/graphics/Color;", "color", "elevation", "Landroidx/compose/ui/unit/Dp;", "apply-7g2Lkgo", "(JFLandroidx/compose/runtime/Composer;I)J", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DefaultElevationOverlay implements ElevationOverlay {
    public static final DefaultElevationOverlay INSTANCE = new DefaultElevationOverlay();

    private DefaultElevationOverlay() {
    }

    @Override // androidx.compose.material.ElevationOverlay
    /* renamed from: apply-7g2Lkgo, reason: not valid java name */
    public long mo1536apply7g2Lkgo(long color, float elevation, Composer $composer, int $changed) {
        long foregroundColor;
        $composer.startReplaceGroup(-1687113661);
        ComposerKt.sourceInformation($composer, "C(apply)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)69@2742L6:ElevationOverlay.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1687113661, $changed, -1, "androidx.compose.material.DefaultElevationOverlay.apply (ElevationOverlay.kt:68)");
        }
        Colors colors = MaterialTheme.INSTANCE.getColors($composer, 6);
        int $this$dp$iv = Dp.m6692compareTo0680j_4(elevation, Dp.m6693constructorimpl(0));
        if ($this$dp$iv <= 0 || colors.isLight()) {
            $composer.startReplaceGroup(1169152471);
            $composer.endReplaceGroup();
            foregroundColor = color;
        } else {
            $composer.startReplaceGroup(1169013963);
            ComposerKt.sourceInformation($composer, "71@2841L42");
            long foregroundColor2 = ElevationOverlayKt.m1562calculateForegroundColorCLU3JFs(color, elevation, $composer, ($changed & 14) | ($changed & 112));
            foregroundColor = ColorKt.m4232compositeOverOWjLjI(foregroundColor2, color);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return foregroundColor;
    }
}
