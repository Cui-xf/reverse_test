package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: TapGestureDetector.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitRelease", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface PressGestureScope extends Density {
    Object awaitRelease(Continuation<? super Unit> continuation);

    Object tryAwaitRelease(Continuation<? super Boolean> continuation);

    /* compiled from: TapGestureDetector.kt */
    /* renamed from: androidx.compose.foundation.gestures.PressGestureScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    /* compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m462roundToPxR2X_6o(PressGestureScope $this, long $receiver) {
            return Density.CC.m6657$default$roundToPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m463roundToPx0680j_4(PressGestureScope $this, float $receiver) {
            return Density.CC.m6658$default$roundToPx0680j_4($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m464toDpGaN1DYA(PressGestureScope $this, long $receiver) {
            return FontScaling.CC.m6802$default$toDpGaN1DYA($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m465toDpu2uoSUM(PressGestureScope $this, float $receiver) {
            return Density.CC.m6659$default$toDpu2uoSUM($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m466toDpu2uoSUM(PressGestureScope $this, int $receiver) {
            return Density.CC.m6660$default$toDpu2uoSUM((Density) $this, $receiver);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m467toDpSizekrfVVM(PressGestureScope $this, long $receiver) {
            return Density.CC.m6661$default$toDpSizekrfVVM($this, $receiver);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m468toPxR2X_6o(PressGestureScope $this, long $receiver) {
            return Density.CC.m6662$default$toPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m469toPx0680j_4(PressGestureScope $this, float $receiver) {
            return Density.CC.m6663$default$toPx0680j_4($this, $receiver);
        }

        @Deprecated
        public static Rect toRect(PressGestureScope $this, DpRect $receiver) {
            return Density.CC.$default$toRect($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m470toSizeXkaWNTQ(PressGestureScope $this, long $receiver) {
            return Density.CC.m6664$default$toSizeXkaWNTQ($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m471toSp0xMU5do(PressGestureScope $this, float $receiver) {
            return FontScaling.CC.m6803$default$toSp0xMU5do($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m472toSpkPz2Gy4(PressGestureScope $this, float $receiver) {
            return Density.CC.m6665$default$toSpkPz2Gy4($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m473toSpkPz2Gy4(PressGestureScope $this, int $receiver) {
            return Density.CC.m6666$default$toSpkPz2Gy4((Density) $this, $receiver);
        }
    }
}
