package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* compiled from: SuspendingPointerInputFilter.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u0014JE\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0017\u001a\u00020\u00182'\u0010\u0019\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001a¢\u0006\u0002\b\u001dH\u0096@¢\u0006\u0002\u0010\u001eJG\u0010\u001f\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0017\u001a\u00020\u00182'\u0010\u0019\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001a¢\u0006\u0002\b\u001dH\u0096@¢\u0006\u0002\u0010\u001eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u00020\u000bX¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006 À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeout", "T", "timeMillis", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface AwaitPointerEventScope extends Density {
    Object awaitPointerEvent(PointerEventPass pointerEventPass, Continuation<? super PointerEvent> continuation);

    PointerEvent getCurrentEvent();

    /* renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
    long mo5300getExtendedTouchPaddingNHjbRc();

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo5301getSizeYbymL2g();

    ViewConfiguration getViewConfiguration();

    <T> Object withTimeout(long j, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation);

    <T> Object withTimeoutOrNull(long j, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation);

    /* compiled from: SuspendingPointerInputFilter.kt */
    /* renamed from: androidx.compose.ui.input.pointer.AwaitPointerEventScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* renamed from: $default$getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
        public static long m5302$default$getExtendedTouchPaddingNHjbRc(AwaitPointerEventScope _this) {
            return Size.INSTANCE.m4023getZeroNHjbRc();
        }

        public static /* synthetic */ Object awaitPointerEvent$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitPointerEvent");
            }
            if ((i & 1) != 0) {
                pointerEventPass = PointerEventPass.Main;
            }
            return awaitPointerEventScope.awaitPointerEvent(pointerEventPass, continuation);
        }

        public static /* synthetic */ <T> Object withTimeoutOrNull$suspendImpl(AwaitPointerEventScope $this, long timeMillis, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
            return function2.invoke($this, continuation);
        }

        public static /* synthetic */ <T> Object withTimeout$suspendImpl(AwaitPointerEventScope $this, long timeMillis, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
            return function2.invoke($this, continuation);
        }
    }

    /* compiled from: SuspendingPointerInputFilter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m5317roundToPxR2X_6o(AwaitPointerEventScope $this, long $receiver) {
            return Density.CC.m6657$default$roundToPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m5318roundToPx0680j_4(AwaitPointerEventScope $this, float $receiver) {
            return Density.CC.m6658$default$roundToPx0680j_4($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m5319toDpGaN1DYA(AwaitPointerEventScope $this, long $receiver) {
            return FontScaling.CC.m6802$default$toDpGaN1DYA($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5320toDpu2uoSUM(AwaitPointerEventScope $this, float $receiver) {
            return Density.CC.m6659$default$toDpu2uoSUM($this, $receiver);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5321toDpu2uoSUM(AwaitPointerEventScope $this, int $receiver) {
            return Density.CC.m6660$default$toDpu2uoSUM((Density) $this, $receiver);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m5322toDpSizekrfVVM(AwaitPointerEventScope $this, long $receiver) {
            return Density.CC.m6661$default$toDpSizekrfVVM($this, $receiver);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m5323toPxR2X_6o(AwaitPointerEventScope $this, long $receiver) {
            return Density.CC.m6662$default$toPxR2X_6o($this, $receiver);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m5324toPx0680j_4(AwaitPointerEventScope $this, float $receiver) {
            return Density.CC.m6663$default$toPx0680j_4($this, $receiver);
        }

        @Deprecated
        public static Rect toRect(AwaitPointerEventScope $this, DpRect $receiver) {
            return Density.CC.$default$toRect($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m5325toSizeXkaWNTQ(AwaitPointerEventScope $this, long $receiver) {
            return Density.CC.m6664$default$toSizeXkaWNTQ($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m5326toSp0xMU5do(AwaitPointerEventScope $this, float $receiver) {
            return FontScaling.CC.m6803$default$toSp0xMU5do($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5327toSpkPz2Gy4(AwaitPointerEventScope $this, float $receiver) {
            return Density.CC.m6665$default$toSpkPz2Gy4($this, $receiver);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5328toSpkPz2Gy4(AwaitPointerEventScope $this, int $receiver) {
            return Density.CC.m6666$default$toSpkPz2Gy4((Density) $this, $receiver);
        }

        @Deprecated
        /* renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
        public static long m5316getExtendedTouchPaddingNHjbRc(AwaitPointerEventScope $this) {
            return CC.m5302$default$getExtendedTouchPaddingNHjbRc($this);
        }

        @Deprecated
        public static <T> Object withTimeoutOrNull(AwaitPointerEventScope $this, long timeMillis, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
            return CC.withTimeoutOrNull$suspendImpl($this, timeMillis, function2, continuation);
        }

        @Deprecated
        public static <T> Object withTimeout(AwaitPointerEventScope $this, long timeMillis, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
            return CC.withTimeout$suspendImpl($this, timeMillis, function2, continuation);
        }
    }
}
