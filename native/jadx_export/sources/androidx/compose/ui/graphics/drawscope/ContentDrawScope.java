package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ContentDrawScope.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawContent", "", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ContentDrawScope extends DrawScope {
    void drawContent();

    /* compiled from: ContentDrawScope.kt */
    /* renamed from: androidx.compose.ui.graphics.drawscope.ContentDrawScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    /* compiled from: ContentDrawScope.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m4694drawImageAZ2fEMs(ContentDrawScope $this, ImageBitmap image, long srcOffset, long srcSize, long dstOffset, long dstSize, float alpha, DrawStyle style, ColorFilter colorFilter, int blendMode, int filterQuality) {
            DrawScope.CC.m4736drawImageAZ2fEMs$default($this, image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, 0, 512, null);
        }

        @Deprecated
        /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m4695getCenterF1C5BW0(ContentDrawScope $this) {
            return DrawScope.CC.m4711$default$getCenterF1C5BW0($this);
        }

        @Deprecated
        /* renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m4696getSizeNHjbRc(ContentDrawScope $this) {
            return DrawScope.CC.m4712$default$getSizeNHjbRc($this);
        }

        @Deprecated
        /* renamed from: record-JVtK1S4, reason: not valid java name */
        public static void m4697recordJVtK1S4(ContentDrawScope $this, GraphicsLayer $receiver, long size, Function1<? super DrawScope, Unit> function1) {
            DrawScope.CC.m4713$default$recordJVtK1S4($this, $receiver, size, function1);
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m4698roundToPxR2X_6o(ContentDrawScope $this, long $receiver) {
            return Density.CC.m6657$default$roundToPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m4699roundToPx0680j_4(ContentDrawScope $this, float $receiver) {
            return Density.CC.m6658$default$roundToPx0680j_4($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m4700toDpGaN1DYA(ContentDrawScope $this, long $receiver) {
            return FontScaling.CC.m6802$default$toDpGaN1DYA($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4701toDpu2uoSUM(ContentDrawScope $this, float $receiver) {
            return Density.CC.m6659$default$toDpu2uoSUM($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4702toDpu2uoSUM(ContentDrawScope $this, int $receiver) {
            return Density.CC.m6660$default$toDpu2uoSUM((Density) $this, $receiver);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m4703toDpSizekrfVVM(ContentDrawScope $this, long $receiver) {
            return Density.CC.m6661$default$toDpSizekrfVVM($this, $receiver);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m4704toPxR2X_6o(ContentDrawScope $this, long $receiver) {
            return Density.CC.m6662$default$toPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m4705toPx0680j_4(ContentDrawScope $this, float $receiver) {
            return Density.CC.m6663$default$toPx0680j_4($this, $receiver);
        }

        @Deprecated
        public static Rect toRect(ContentDrawScope $this, DpRect $receiver) {
            return Density.CC.$default$toRect($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m4706toSizeXkaWNTQ(ContentDrawScope $this, long $receiver) {
            return Density.CC.m6664$default$toSizeXkaWNTQ($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m4707toSp0xMU5do(ContentDrawScope $this, float $receiver) {
            return FontScaling.CC.m6803$default$toSp0xMU5do($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4708toSpkPz2Gy4(ContentDrawScope $this, float $receiver) {
            return Density.CC.m6665$default$toSpkPz2Gy4($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4709toSpkPz2Gy4(ContentDrawScope $this, int $receiver) {
            return Density.CC.m6666$default$toSpkPz2Gy4((Density) $this, $receiver);
        }
    }
}
