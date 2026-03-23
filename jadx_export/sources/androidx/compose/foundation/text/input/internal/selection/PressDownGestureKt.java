package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.core.view.MotionEventCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: PressDownGesture.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0080@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"detectPressDownGesture", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDown", "Landroidx/compose/foundation/text/input/internal/selection/TapOnPosition;", "onUp", "Lkotlin/Function0;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/input/internal/selection/TapOnPosition;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PressDownGestureKt {
    public static /* synthetic */ Object detectPressDownGesture$default(PointerInputScope pointerInputScope, TapOnPosition tapOnPosition, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        return detectPressDownGesture(pointerInputScope, tapOnPosition, function0, continuation);
    }

    /* compiled from: PressDownGesture.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.PressDownGestureKt$detectPressDownGesture$2", f = "PressDownGesture.kt", i = {0, 1, 1}, l = {33, MotionEventCompat.AXIS_GENERIC_8}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "down"}, s = {"L$0", "L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.text.input.internal.selection.PressDownGestureKt$detectPressDownGesture$2, reason: invalid class name */
    static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TapOnPosition $onDown;
        final /* synthetic */ Function0<Unit> $onUp;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TapOnPosition tapOnPosition, Function0<Unit> function0, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$onDown = tapOnPosition;
            this.$onUp = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$onDown, this.$onUp, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x007d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00d2  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c6 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x007e -> B:19:0x0085). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                Method dump skipped, instructions count: 228
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.PressDownGestureKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Object detectPressDownGesture(PointerInputScope $this$detectPressDownGesture, TapOnPosition onDown, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectPressDownGesture, new AnonymousClass2(onDown, function0, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }
}
