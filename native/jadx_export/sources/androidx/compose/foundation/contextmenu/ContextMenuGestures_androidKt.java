package androidx.compose.foundation.contextmenu;

import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.core.view.MotionEventCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: ContextMenuGestures.android.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0082@¢\u0006\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a&\u0010\b\u001a\u00020\t*\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\fH\u0081@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"awaitFirstRightClickDown", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "contextMenuGestures", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "onRightClickDown", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "onDown", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContextMenuGestures_androidKt {

    /* compiled from: ContextMenuGestures.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt", f = "ContextMenuGestures.android.kt", i = {0}, l = {66}, m = "awaitFirstRightClickDown", n = {"$this$awaitFirstRightClickDown"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt$awaitFirstRightClickDown$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ContextMenuGestures_androidKt.awaitFirstRightClickDown(null, this);
        }
    }

    /* compiled from: ContextMenuGestures.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt$contextMenuGestures$1", f = "ContextMenuGestures.android.kt", i = {}, l = {MotionEventCompat.AXIS_GENERIC_13}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt$contextMenuGestures$1, reason: invalid class name and case insensitive filesystem */
    static final class C02251 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ContextMenuState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02251(ContextMenuState contextMenuState, Continuation<? super C02251> continuation) {
            super(2, continuation);
            this.$state = contextMenuState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02251 c02251 = new C02251(this.$state, continuation);
            c02251.L$0 = obj;
            return c02251;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((C02251) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                    final ContextMenuState contextMenuState = this.$state;
                    this.label = 1;
                    if (ContextMenuGestures_androidKt.onRightClickDown($this$pointerInput, new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt.contextMenuGestures.1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                            m338invokek4lQ0M(offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                        public final void m338invokek4lQ0M(long it) {
                            contextMenuState.setStatus(new ContextMenuState.Status.Open(it, null));
                        }
                    }, this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public static final Modifier contextMenuGestures(Modifier $this$contextMenuGestures, ContextMenuState state) {
        return SuspendingPointerInputFilterKt.pointerInput($this$contextMenuGestures, ContextMenuKey.INSTANCE, new C02251(state, null));
    }

    /* compiled from: ContextMenuGestures.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt$onRightClickDown$2", f = "ContextMenuGestures.android.kt", i = {0}, l = {53, 56}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt$onRightClickDown$2, reason: invalid class name */
    static final class AnonymousClass2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Offset, Unit> $onDown;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super Offset, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$onDown = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$onDown, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0060 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 1
                switch(r1) {
                    case 0: goto L24;
                    case 1: goto L18;
                    case 2: goto L12;
                    default: goto La;
                }
            La:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L12:
                r0 = r9
                kotlin.ResultKt.throwOnFailure(r10)
                r1 = r10
                goto L62
            L18:
                r1 = r9
                java.lang.Object r3 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                kotlin.ResultKt.throwOnFailure(r10)
                r4 = r3
                r3 = r1
                r1 = r10
                goto L3f
            L24:
                kotlin.ResultKt.throwOnFailure(r10)
                r1 = r9
                java.lang.Object r3 = r1.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                r4 = r1
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r1.L$0 = r3
                r1.label = r2
                java.lang.Object r4 = androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt.access$awaitFirstRightClickDown(r3, r4)
                if (r4 != r0) goto L3a
                return r0
            L3a:
                r8 = r1
                r1 = r10
                r10 = r4
                r4 = r3
                r3 = r8
            L3f:
                androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
                r10.consume()
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r5 = r3.$onDown
                long r6 = r10.getPosition()
                androidx.compose.ui.geometry.Offset r6 = androidx.compose.ui.geometry.Offset.m3934boximpl(r6)
                r5.invoke(r6)
                r10 = r3
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                r5 = 0
                r3.L$0 = r5
                r6 = 2
                r3.label = r6
                java.lang.Object r10 = androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation$default(r4, r5, r10, r2, r5)
                if (r10 != r0) goto L61
                return r0
            L61:
                r0 = r3
            L62:
                androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
                if (r10 == 0) goto L69
                r10.consume()
            L69:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final Object onRightClickDown(PointerInputScope $this$onRightClickDown, Function1<? super Offset, Unit> function1, Continuation<? super Unit> continuation) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture($this$onRightClickDown, new AnonymousClass2(function1, null), continuation);
        return objAwaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAwaitEachGesture : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004d -> B:18:0x0055). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitFirstRightClickDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r19) {
        /*
            r0 = r19
            boolean r1 = r0 instanceof androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt.AnonymousClass1
            if (r1 == 0) goto L16
            r1 = r0
            androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt$awaitFirstRightClickDown$1 r1 = (androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L1b
        L16:
            androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt$awaitFirstRightClickDown$1 r1 = new androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt$awaitFirstRightClickDown$1
            r1.<init>(r0)
        L1b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            switch(r3) {
                case 0: goto L3b;
                case 1: goto L2f;
                default: goto L27;
            }
        L27:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L2f:
            java.lang.Object r3 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
            kotlin.ResultKt.throwOnFailure(r0)
            r5 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            goto L55
        L3b:
            kotlin.ResultKt.throwOnFailure(r0)
            r3 = r18
        L40:
            r1.L$0 = r3
            r1.label = r4
            r5 = 0
            java.lang.Object r5 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.CC.awaitPointerEvent$default(r3, r5, r1, r4, r5)
            if (r5 != r2) goto L4d
            return r2
        L4d:
            r17 = r1
            r1 = r0
            r0 = r5
            r5 = r3
            r3 = r2
            r2 = r17
        L55:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            int r6 = r0.getButtons()
            boolean r6 = androidx.compose.ui.input.pointer.PointerEvent_androidKt.m5379isSecondaryPressedaHzCxE(r6)
            if (r6 == 0) goto L96
            java.util.List r6 = r0.getChanges()
            r7 = 0
            r8 = 0
            r9 = 0
            int r10 = r6.size()
        L6f:
            r11 = 0
            if (r9 >= r10) goto L89
            java.lang.Object r12 = r6.get(r9)
            r13 = r12
            r14 = 0
            r15 = r13
            androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
            r16 = 0
            boolean r15 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDown(r15)
            if (r15 != 0) goto L85
            r6 = 0
            goto L8b
        L85:
            int r9 = r9 + 1
            goto L6f
        L89:
            r6 = 1
        L8b:
            if (r6 == 0) goto L96
            java.util.List r3 = r0.getChanges()
            java.lang.Object r3 = r3.get(r11)
            return r3
        L96:
            r0 = r1
            r1 = r2
            r2 = r3
            r3 = r5
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.contextmenu.ContextMenuGestures_androidKt.awaitFirstRightClickDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
