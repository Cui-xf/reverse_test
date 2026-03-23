package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* compiled from: RadioButton.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Landroidx/compose/material/RadioButtonDefaults;", "", "()V", "colors", "Landroidx/compose/material/RadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledColor", "colors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/RadioButtonColors;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RadioButtonDefaults {
    public static final int $stable = 0;
    public static final RadioButtonDefaults INSTANCE = new RadioButtonDefaults();

    private RadioButtonDefaults() {
    }

    /* renamed from: colors-RGew2ao, reason: not valid java name */
    public final RadioButtonColors m1638colorsRGew2ao(long selectedColor, long unselectedColor, long disabledColor, Composer $composer, int $changed, int i) {
        long unselectedColor2;
        long disabledColor2;
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 1370708026, "C(colors)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color,0:c#ui.graphics.Color)162@6523L6,163@6588L6,164@6670L6,164@6713L8,166@6765L197:RadioButton.kt#jmzs0o");
        long selectedColor2 = (i & 1) != 0 ? MaterialTheme.INSTANCE.getColors($composer, 6).m1496getSecondary0d7_KjU() : selectedColor;
        if ((i & 2) != 0) {
            long jM1493getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            unselectedColor2 = Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU) : 0.6f, (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU) : 0.0f);
        } else {
            unselectedColor2 = unselectedColor;
        }
        if ((i & 4) != 0) {
            long jM1493getOnSurface0d7_KjU2 = MaterialTheme.INSTANCE.getColors($composer, 6).m1493getOnSurface0d7_KjU();
            disabledColor2 = Color.m4185copywmQWz5c(jM1493getOnSurface0d7_KjU2, (14 & 1) != 0 ? Color.m4189getAlphaimpl(jM1493getOnSurface0d7_KjU2) : ContentAlpha.INSTANCE.getDisabled($composer, 6), (14 & 2) != 0 ? Color.m4193getRedimpl(jM1493getOnSurface0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4192getGreenimpl(jM1493getOnSurface0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4190getBlueimpl(jM1493getOnSurface0d7_KjU2) : 0.0f);
        } else {
            disabledColor2 = disabledColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1370708026, $changed, -1, "androidx.compose.material.RadioButtonDefaults.colors (RadioButton.kt:165)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1778188470, "CC(remember):RadioButton.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer.changed(selectedColor2)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(unselectedColor2)) || ($changed & 48) == 32) | (((($changed & 896) ^ 384) > 256 && $composer.changed(disabledColor2)) || ($changed & 384) == 256);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new DefaultRadioButtonColors(selectedColor2, unselectedColor2, disabledColor2, null);
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        DefaultRadioButtonColors defaultRadioButtonColors = (DefaultRadioButtonColors) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultRadioButtonColors;
    }
}
