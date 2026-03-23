package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.core.view.MotionEventCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: PointerMoveDetector.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0080@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"detectMoves", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "pointerEventPass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "onMove", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerMoveDetectorKt {
    public static /* synthetic */ Object detectMoves$default(PointerInputScope pointerInputScope, PointerEventPass pointerEventPass, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            pointerEventPass = PointerEventPass.Initial;
        }
        return detectMoves(pointerInputScope, pointerEventPass, function1, continuation);
    }

    /* compiled from: PointerMoveDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2", f = "PointerMoveDetector.kt", i = {}, l = {MotionEventCompat.AXIS_GENERIC_10}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Offset, Unit> $onMove;
        final /* synthetic */ PointerEventPass $pointerEventPass;
        final /* synthetic */ PointerInputScope $this_detectMoves;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(PointerInputScope pointerInputScope, PointerEventPass pointerEventPass, Function1<? super Offset, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_detectMoves = pointerInputScope;
            this.$pointerEventPass = pointerEventPass;
            this.$onMove = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$this_detectMoves, this.$pointerEventPass, this.$onMove, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineContext currentContext = get$context();
                    this.label = 1;
                    if (this.$this_detectMoves.awaitPointerEventScope(new AnonymousClass1(currentContext, this.$pointerEventPass, this.$onMove, null), this) != coroutine_suspended) {
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

        /* compiled from: PointerMoveDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1", f = "PointerMoveDetector.kt", i = {0, 0}, l = {MotionEventCompat.AXIS_GENERIC_13}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "previousPosition"}, s = {"L$0", "L$1"})
        /* renamed from: androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineContext $currentContext;
            final /* synthetic */ Function1<Offset, Unit> $onMove;
            final /* synthetic */ PointerEventPass $pointerEventPass;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(CoroutineContext coroutineContext, PointerEventPass pointerEventPass, Function1<? super Offset, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$currentContext = coroutineContext;
                this.$pointerEventPass = pointerEventPass;
                this.$onMove = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$currentContext, this.$pointerEventPass, this.$onMove, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x003c  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0067  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0075  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0077  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00c5  */
            /* JADX WARN: Type inference failed for: r9v1, types: [T, androidx.compose.ui.geometry.Offset] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x004e -> B:14:0x0055). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                /*
                    r11 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r11.label
                    r2 = 1
                    switch(r1) {
                        case 0: goto L24;
                        case 1: goto L12;
                        default: goto La;
                    }
                La:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r0)
                    throw r12
                L12:
                    r1 = r11
                    java.lang.Object r3 = r1.L$1
                    kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
                    java.lang.Object r4 = r1.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r4 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r4
                    kotlin.ResultKt.throwOnFailure(r12)
                    r5 = r4
                    r4 = r3
                    r3 = r1
                    r1 = r0
                    r0 = r12
                    goto L55
                L24:
                    kotlin.ResultKt.throwOnFailure(r12)
                    r1 = r11
                    java.lang.Object r3 = r1.L$0
                    androidx.compose.ui.input.pointer.AwaitPointerEventScope r3 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r3
                    kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
                    r4.<init>()
                    r10 = r4
                    r4 = r3
                    r3 = r10
                L34:
                    kotlin.coroutines.CoroutineContext r5 = r1.$currentContext
                    boolean r5 = kotlinx.coroutines.JobKt.isActive(r5)
                    if (r5 == 0) goto Lc5
                    androidx.compose.ui.input.pointer.PointerEventPass r5 = r1.$pointerEventPass
                    r6 = r1
                    kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                    r1.L$0 = r4
                    r1.L$1 = r3
                    r1.label = r2
                    java.lang.Object r5 = r4.awaitPointerEvent(r5, r6)
                    if (r5 != r0) goto L4e
                    return r0
                L4e:
                    r10 = r0
                    r0 = r12
                    r12 = r5
                    r5 = r4
                    r4 = r3
                    r3 = r1
                    r1 = r10
                L55:
                    androidx.compose.ui.input.pointer.PointerEvent r12 = (androidx.compose.ui.input.pointer.PointerEvent) r12
                    int r6 = r12.getType()
                    androidx.compose.ui.input.pointer.PointerEventType$Companion r7 = androidx.compose.ui.input.pointer.PointerEventType.INSTANCE
                    int r7 = r7.m5359getMove7fucELk()
                    boolean r7 = androidx.compose.ui.input.pointer.PointerEventType.m5353equalsimpl0(r6, r7)
                    if (r7 == 0) goto L69
                    r7 = 1
                    goto L73
                L69:
                    androidx.compose.ui.input.pointer.PointerEventType$Companion r7 = androidx.compose.ui.input.pointer.PointerEventType.INSTANCE
                    int r7 = r7.m5357getEnter7fucELk()
                    boolean r7 = androidx.compose.ui.input.pointer.PointerEventType.m5353equalsimpl0(r6, r7)
                L73:
                    if (r7 == 0) goto L77
                    r6 = 1
                    goto L81
                L77:
                    androidx.compose.ui.input.pointer.PointerEventType$Companion r7 = androidx.compose.ui.input.pointer.PointerEventType.INSTANCE
                    int r7 = r7.m5358getExit7fucELk()
                    boolean r6 = androidx.compose.ui.input.pointer.PointerEventType.m5353equalsimpl0(r6, r7)
                L81:
                    if (r6 == 0) goto Lbe
                L84:
                    java.util.List r6 = r12.getChanges()
                    java.lang.Object r6 = kotlin.collections.CollectionsKt.first(r6)
                    androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
                    long r6 = r6.getPosition()
                    androidx.compose.ui.geometry.Offset r6 = androidx.compose.ui.geometry.Offset.m3934boximpl(r6)
                    long r7 = r6.getPackedValue()
                    r12 = 0
                    T r9 = r4.element
                    boolean r12 = androidx.compose.ui.geometry.Offset.m3941equalsimpl(r7, r9)
                    if (r12 != 0) goto La4
                    goto La5
                La4:
                    r6 = 0
                La5:
                    if (r6 == 0) goto Lbd
                La8:
                    kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r12 = r3.$onMove
                    long r6 = r6.getPackedValue()
                    r8 = 0
                    androidx.compose.ui.geometry.Offset r9 = androidx.compose.ui.geometry.Offset.m3934boximpl(r6)
                    r4.element = r9
                    androidx.compose.ui.geometry.Offset r9 = androidx.compose.ui.geometry.Offset.m3934boximpl(r6)
                    r12.invoke(r9)
                Lbd:
                Lbe:
                    r12 = r0
                    r0 = r1
                    r1 = r3
                    r3 = r4
                    r4 = r5
                    goto L34
                Lc5:
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.PointerMoveDetectorKt.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    public static final Object detectMoves(PointerInputScope $this$detectMoves, PointerEventPass pointerEventPass, Function1<? super Offset, Unit> function1, Continuation<? super Unit> continuation) {
        Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new AnonymousClass2($this$detectMoves, pointerEventPass, function1, null), continuation);
        return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
    }
}
