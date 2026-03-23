package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\r\u001a^\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007\u001aH\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007\u001a\u001f\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020 H\u0082@ø\u0001\u0000¢\u0006\u0004\b#\u0010$\"\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"CanDragCalculation", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "DefaultScrollMotionDurationScale", "Landroidx/compose/ui/MotionDurationScale;", "getDefaultScrollMotionDurationScale", "()Landroidx/compose/ui/MotionDurationScale;", "DefaultScrollMotionDurationScaleFactor", "", "NoOpScrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "UnityDensity", "androidx/compose/foundation/gestures/ScrollableKt$UnityDensity$1", "Landroidx/compose/foundation/gestures/ScrollableKt$UnityDensity$1;", "scrollable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "enabled", "reverseDirection", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "semanticsScrollBy", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "offset", "semanticsScrollBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/ScrollingLogic;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollableKt {
    private static final float DefaultScrollMotionDurationScaleFactor = 1.0f;
    private static final Function1<PointerInputChange, Boolean> CanDragCalculation = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableKt$CanDragCalculation$1
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(PointerInputChange change) {
            return Boolean.valueOf(!PointerType.m5477equalsimpl0(change.getType(), PointerType.INSTANCE.m5482getMouseT8wyACA()));
        }
    };
    private static final ScrollScope NoOpScrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollableKt$NoOpScrollScope$1
        @Override // androidx.compose.foundation.gestures.ScrollScope
        public float scrollBy(float pixels) {
            return pixels;
        }
    };
    private static final MotionDurationScale DefaultScrollMotionDurationScale = new MotionDurationScale() { // from class: androidx.compose.foundation.gestures.ScrollableKt$DefaultScrollMotionDurationScale$1
        @Override // androidx.compose.ui.MotionDurationScale, kotlin.coroutines.CoroutineContext.Element
        public /* synthetic */ CoroutineContext.Key getKey() {
            return MotionDurationScale.INSTANCE;
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) MotionDurationScale.DefaultImpls.fold(this, r, function2);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
            return (E) MotionDurationScale.DefaultImpls.get(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
        public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
            return MotionDurationScale.DefaultImpls.minusKey(this, key);
        }

        @Override // kotlin.coroutines.CoroutineContext
        public CoroutineContext plus(CoroutineContext context) {
            return MotionDurationScale.DefaultImpls.plus(this, context);
        }

        @Override // androidx.compose.ui.MotionDurationScale
        public float getScaleFactor() {
            return 1.0f;
        }
    };
    private static final ScrollableKt$UnityDensity$1 UnityDensity = new Density() { // from class: androidx.compose.foundation.gestures.ScrollableKt$UnityDensity$1
        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx--R2X_6o */
        public /* synthetic */ int mo360roundToPxR2X_6o(long j) {
            return Density.CC.m6657$default$roundToPxR2X_6o(this, j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx-0680j_4 */
        public /* synthetic */ int mo361roundToPx0680j_4(float f) {
            return Density.CC.m6658$default$roundToPx0680j_4(this, f);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* renamed from: toDp-GaN1DYA */
        public /* synthetic */ float mo362toDpGaN1DYA(long j) {
            return FontScaling.CC.m6802$default$toDpGaN1DYA(this, j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public /* synthetic */ float mo363toDpu2uoSUM(float f) {
            return Density.CC.m6659$default$toDpu2uoSUM(this, f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public /* synthetic */ float mo364toDpu2uoSUM(int i) {
            return Density.CC.m6660$default$toDpu2uoSUM((Density) this, i);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDpSize-k-rfVVM */
        public /* synthetic */ long mo365toDpSizekrfVVM(long j) {
            return Density.CC.m6661$default$toDpSizekrfVVM(this, j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx--R2X_6o */
        public /* synthetic */ float mo366toPxR2X_6o(long j) {
            return Density.CC.m6662$default$toPxR2X_6o(this, j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx-0680j_4 */
        public /* synthetic */ float mo367toPx0680j_4(float f) {
            return Density.CC.m6663$default$toPx0680j_4(this, f);
        }

        @Override // androidx.compose.ui.unit.Density
        public /* synthetic */ Rect toRect(DpRect dpRect) {
            return Density.CC.$default$toRect(this, dpRect);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSize-XkaWNTQ */
        public /* synthetic */ long mo368toSizeXkaWNTQ(long j) {
            return Density.CC.m6664$default$toSizeXkaWNTQ(this, j);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* renamed from: toSp-0xMU5do */
        public /* synthetic */ long mo369toSp0xMU5do(float f) {
            return FontScaling.CC.m6803$default$toSp0xMU5do(this, f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public /* synthetic */ long mo370toSpkPz2Gy4(float f) {
            return Density.CC.m6665$default$toSpkPz2Gy4(this, f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public /* synthetic */ long mo371toSpkPz2Gy4(int i) {
            return Density.CC.m6666$default$toSpkPz2Gy4((Density) this, i);
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return 1.0f;
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return 1.0f;
        }
    };

    public static final Modifier scrollable(Modifier $this$scrollable, ScrollableState state, Orientation orientation, boolean enabled, boolean reverseDirection, FlingBehavior flingBehavior, MutableInteractionSource interactionSource) {
        return scrollable$default($this$scrollable, state, orientation, null, enabled, reverseDirection, flingBehavior, interactionSource, null, 128, null);
    }

    public static /* synthetic */ Modifier scrollable$default(Modifier modifier, ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z, boolean z2, FlingBehavior flingBehavior, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec, int i, Object obj) {
        return scrollable(modifier, scrollableState, orientation, overscrollEffect, (i & 8) != 0 ? true : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? null : flingBehavior, (i & 64) != 0 ? null : mutableInteractionSource, (i & 128) != 0 ? null : bringIntoViewSpec);
    }

    public static final Modifier scrollable(Modifier $this$scrollable, ScrollableState state, Orientation orientation, OverscrollEffect overscrollEffect, boolean enabled, boolean reverseDirection, FlingBehavior flingBehavior, MutableInteractionSource interactionSource, BringIntoViewSpec bringIntoViewSpec) {
        return $this$scrollable.then(new ScrollableElement(state, orientation, overscrollEffect, enabled, reverseDirection, flingBehavior, interactionSource, bringIntoViewSpec));
    }

    public static final MotionDurationScale getDefaultScrollMotionDurationScale() {
        return DefaultScrollMotionDurationScale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* renamed from: semanticsScrollBy-d-4ec7I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m475semanticsScrollByd4ec7I(androidx.compose.foundation.gestures.ScrollingLogic r8, long r9, kotlin.coroutines.Continuation<? super androidx.compose.ui.geometry.Offset> r11) {
        /*
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1
            if (r0 == 0) goto L14
            r0 = r11
            androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1 r0 = (androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1 r0 = new androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            switch(r2) {
                case 0: goto L38;
                case 1: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L2c:
            java.lang.Object r8 = r0.L$1
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref.FloatRef) r8
            java.lang.Object r9 = r0.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r9 = (androidx.compose.foundation.gestures.ScrollingLogic) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L5c
        L38:
            kotlin.ResultKt.throwOnFailure(r11)
            r3 = r8
            r4 = r9
            kotlin.jvm.internal.Ref$FloatRef r6 = new kotlin.jvm.internal.Ref$FloatRef
            r6.<init>()
            androidx.compose.foundation.MutatePriority r8 = androidx.compose.foundation.MutatePriority.Default
            androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2 r2 = new androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2
            r7 = 0
            r2.<init>(r3, r4, r6, r7)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.L$0 = r3
            r0.L$1 = r6
            r9 = 1
            r0.label = r9
            java.lang.Object r8 = r3.scroll(r8, r2, r0)
            if (r8 != r1) goto L5a
            return r1
        L5a:
            r9 = r3
            r8 = r6
        L5c:
            float r10 = r8.element
            long r1 = r9.m495toOffsettuRUvjQ(r10)
            androidx.compose.ui.geometry.Offset r10 = androidx.compose.ui.geometry.Offset.m3934boximpl(r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollableKt.m475semanticsScrollByd4ec7I(androidx.compose.foundation.gestures.ScrollingLogic, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
