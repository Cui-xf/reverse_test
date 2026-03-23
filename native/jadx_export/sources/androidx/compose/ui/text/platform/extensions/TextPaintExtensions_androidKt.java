package androidx.compose.ui.text.platform.extensions;

import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;

/* compiled from: TextPaintExtensions.android.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a6\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001aP\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042&\u0010\u0012\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\f\u0010\u001b\u001a\u00020\b*\u00020\u0004H\u0000\u001a\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"correctBlurRadius", "", "blurRadius", "generateFallbackSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "letterSpacing", "Landroidx/compose/ui/unit/TextUnit;", "requiresLetterSpacing", "", "background", "Landroidx/compose/ui/graphics/Color;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "generateFallbackSpanStyle-62GTOB8", "(JZJLandroidx/compose/ui/text/style/BaselineShift;)Landroidx/compose/ui/text/SpanStyle;", "applySpanStyle", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "style", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "density", "Landroidx/compose/ui/unit/Density;", "hasFontAttributes", "setTextMotion", "", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextPaintExtensions_androidKt {
    public static /* synthetic */ SpanStyle applySpanStyle$default(AndroidTextPaint androidTextPaint, SpanStyle spanStyle, Function4 function4, Density density, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return applySpanStyle(androidTextPaint, spanStyle, function4, density, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0198  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.ui.text.SpanStyle applySpanStyle(androidx.compose.ui.text.platform.AndroidTextPaint r8, androidx.compose.ui.text.SpanStyle r9, kotlin.jvm.functions.Function4<? super androidx.compose.ui.text.font.FontFamily, ? super androidx.compose.ui.text.font.FontWeight, ? super androidx.compose.ui.text.font.FontStyle, ? super androidx.compose.ui.text.font.FontSynthesis, ? extends android.graphics.Typeface> r10, androidx.compose.ui.unit.Density r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt.applySpanStyle(androidx.compose.ui.text.platform.AndroidTextPaint, androidx.compose.ui.text.SpanStyle, kotlin.jvm.functions.Function4, androidx.compose.ui.unit.Density, boolean):androidx.compose.ui.text.SpanStyle");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /* renamed from: generateFallbackSpanStyle-62GTOB8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final androidx.compose.ui.text.SpanStyle m6429generateFallbackSpanStyle62GTOB8(long r31, boolean r33, long r34, androidx.compose.ui.text.style.BaselineShift r36) {
        /*
            r0 = r34
            r2 = 1
            r3 = 0
            if (r33 == 0) goto L26
            long r4 = androidx.compose.ui.unit.TextUnit.m6889getTypeUIouoOA(r31)
            androidx.compose.ui.unit.TextUnitType$Companion r6 = androidx.compose.ui.unit.TextUnitType.INSTANCE
            long r6 = r6.m6923getSpUIouoOA()
            boolean r4 = androidx.compose.ui.unit.TextUnitType.m6918equalsimpl0(r4, r6)
            if (r4 == 0) goto L26
            float r4 = androidx.compose.ui.unit.TextUnit.m6890getValueimpl(r31)
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L21
            r4 = 1
            goto L22
        L21:
            r4 = 0
        L22:
            if (r4 != 0) goto L26
            r4 = 1
            goto L27
        L26:
            r4 = 0
        L27:
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.INSTANCE
            long r5 = r5.m4223getUnspecified0d7_KjU()
            boolean r5 = androidx.compose.ui.graphics.Color.m4188equalsimpl0(r0, r5)
            if (r5 != 0) goto L42
            androidx.compose.ui.graphics.Color$Companion r5 = androidx.compose.ui.graphics.Color.INSTANCE
            long r5 = r5.m4222getTransparent0d7_KjU()
            boolean r5 = androidx.compose.ui.graphics.Color.m4188equalsimpl0(r0, r5)
            if (r5 != 0) goto L42
            r5 = 1
            goto L43
        L42:
            r5 = 0
        L43:
            if (r36 == 0) goto L56
            androidx.compose.ui.text.style.BaselineShift$Companion r6 = androidx.compose.ui.text.style.BaselineShift.INSTANCE
            float r6 = r6.m6444getNoney9eOQZs()
            float r7 = r36.m6440unboximpl()
            boolean r6 = androidx.compose.ui.text.style.BaselineShift.m6437equalsimpl0(r7, r6)
            if (r6 != 0) goto L56
            goto L57
        L56:
            r2 = 0
        L57:
            r3 = 0
            if (r4 != 0) goto L5f
            if (r5 != 0) goto L5f
            if (r2 != 0) goto L5f
            goto La6
        L5f:
            if (r4 == 0) goto L64
            r18 = r31
            goto L6c
        L64:
            androidx.compose.ui.unit.TextUnit$Companion r6 = androidx.compose.ui.unit.TextUnit.INSTANCE
            long r6 = r6.m6901getUnspecifiedXSAIIZE()
            r18 = r6
        L6c:
            if (r5 == 0) goto L71
            r23 = r0
            goto L79
        L71:
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.INSTANCE
            long r6 = r6.m4223getUnspecified0d7_KjU()
            r23 = r6
        L79:
            if (r2 == 0) goto L7e
            r20 = r36
            goto L80
        L7e:
            r20 = r3
        L80:
            androidx.compose.ui.text.SpanStyle r8 = new androidx.compose.ui.text.SpanStyle
            r29 = 63103(0xf67f, float:8.8426E-41)
            r30 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r21 = 0
            r22 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r8.<init>(r9, r11, r13, r14, r15, r16, r17, r18, r20, r21, r22, r23, r25, r26, r27, r28, r29, r30)
            r3 = r8
        La6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt.m6429generateFallbackSpanStyle62GTOB8(long, boolean, long, androidx.compose.ui.text.style.BaselineShift):androidx.compose.ui.text.SpanStyle");
    }

    public static final void setTextMotion(AndroidTextPaint $this$setTextMotion, TextMotion textMotion) {
        int flags;
        TextMotion finalTextMotion = textMotion == null ? TextMotion.INSTANCE.getStatic() : textMotion;
        if (finalTextMotion.getSubpixelTextPositioning()) {
            flags = $this$setTextMotion.getFlags() | 128;
        } else {
            flags = $this$setTextMotion.getFlags() & (-129);
        }
        $this$setTextMotion.setFlags(flags);
        int linearity = finalTextMotion.getLinearity();
        if (TextMotion.Linearity.m6582equalsimpl0(linearity, TextMotion.Linearity.INSTANCE.m6587getLinear4e0Vf04())) {
            $this$setTextMotion.setFlags($this$setTextMotion.getFlags() | 64);
            $this$setTextMotion.setHinting(0);
        } else if (TextMotion.Linearity.m6582equalsimpl0(linearity, TextMotion.Linearity.INSTANCE.m6586getFontHinting4e0Vf04())) {
            $this$setTextMotion.getFlags();
            $this$setTextMotion.setHinting(1);
        } else if (TextMotion.Linearity.m6582equalsimpl0(linearity, TextMotion.Linearity.INSTANCE.m6588getNone4e0Vf04())) {
            $this$setTextMotion.getFlags();
            $this$setTextMotion.setHinting(0);
        } else {
            $this$setTextMotion.getFlags();
        }
    }

    public static final boolean hasFontAttributes(SpanStyle $this$hasFontAttributes) {
        return ($this$hasFontAttributes.getFontFamily() == null && $this$hasFontAttributes.getFontStyle() == null && $this$hasFontAttributes.getFontWeight() == null) ? false : true;
    }

    public static final float correctBlurRadius(float blurRadius) {
        if (blurRadius == 0.0f) {
            return Float.MIN_VALUE;
        }
        return blurRadius;
    }
}
