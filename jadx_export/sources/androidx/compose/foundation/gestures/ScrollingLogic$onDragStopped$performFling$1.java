package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "velocity"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1", f = "Scrollable.kt", i = {0, 1, 1, 2, 2}, l = {745, 748, 751}, m = "invokeSuspend", n = {"velocity", "velocity", "available", "velocity", "velocityLeft"}, s = {"J$0", "J$0", "J$1", "J$0", "J$1"})
/* loaded from: classes.dex */
final class ScrollingLogic$onDragStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    /* synthetic */ long J$0;
    long J$1;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollingLogic$onDragStopped$performFling$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$onDragStopped$performFling$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this.this$0, continuation);
        scrollingLogic$onDragStopped$performFling$1.J$0 = ((Velocity) obj).getPackedValue();
        return scrollingLogic$onDragStopped$performFling$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
        return m496invokesFctU(velocity.getPackedValue(), continuation);
    }

    /* renamed from: invoke-sF-c-tU, reason: not valid java name */
    public final Object m496invokesFctU(long j, Continuation<? super Velocity> continuation) {
        return ((ScrollingLogic$onDragStopped$performFling$1) create(Velocity.m6925boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a8  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r1 = r18
            int r2 = r1.label
            switch(r2) {
                case 0: goto L40;
                case 1: goto L34;
                case 2: goto L22;
                case 3: goto L13;
                default: goto Lb;
            }
        Lb:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L13:
            r0 = r18
            r2 = r19
            long r3 = r0.J$1
            long r5 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r2)
            r12 = r3
            r3 = r2
            goto Laa
        L22:
            r2 = r18
            r3 = r19
            long r4 = r2.J$1
            long r6 = r2.J$0
            kotlin.ResultKt.throwOnFailure(r3)
            r16 = r6
            r7 = r4
            r5 = r16
            r4 = r3
            goto L87
        L34:
            r2 = r18
            r3 = r19
            long r4 = r2.J$0
            kotlin.ResultKt.throwOnFailure(r3)
            r5 = r4
            r4 = r3
            goto L64
        L40:
            kotlin.ResultKt.throwOnFailure(r19)
            r2 = r18
            r3 = r19
            long r4 = r2.J$0
            androidx.compose.foundation.gestures.ScrollingLogic r6 = r2.this$0
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r6 = androidx.compose.foundation.gestures.ScrollingLogic.access$getNestedScrollDispatcher$p(r6)
            r7 = r2
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r2.J$0 = r4
            r8 = 1
            r2.label = r8
            java.lang.Object r6 = r6.m5281dispatchPreFlingQWom1Mo(r4, r7)
            if (r6 != r0) goto L5e
            return r0
        L5e:
            r16 = r4
            r4 = r3
            r3 = r6
            r5 = r16
        L64:
            androidx.compose.ui.unit.Velocity r3 = (androidx.compose.ui.unit.Velocity) r3
            long r7 = r3.getPackedValue()
            long r7 = androidx.compose.ui.unit.Velocity.m6937minusAH228Gc(r5, r7)
            androidx.compose.foundation.gestures.ScrollingLogic r3 = r2.this$0
            r9 = r2
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r2.J$0 = r5
            r2.J$1 = r7
            r10 = 2
            r2.label = r10
            java.lang.Object r3 = r3.m489doFlingAnimationQWom1Mo(r7, r9)
            if (r3 != r0) goto L82
            return r0
        L82:
            r16 = r4
            r4 = r3
            r3 = r16
        L87:
            androidx.compose.ui.unit.Velocity r4 = (androidx.compose.ui.unit.Velocity) r4
            long r12 = r4.getPackedValue()
            androidx.compose.foundation.gestures.ScrollingLogic r4 = r2.this$0
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r9 = androidx.compose.foundation.gestures.ScrollingLogic.access$getNestedScrollDispatcher$p(r4)
            long r10 = androidx.compose.ui.unit.Velocity.m6937minusAH228Gc(r7, r12)
            r14 = r2
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14
            r2.J$0 = r5
            r2.J$1 = r12
            r4 = 3
            r2.label = r4
            java.lang.Object r4 = r9.m5279dispatchPostFlingRZ2iAVY(r10, r12, r14)
            if (r4 != r0) goto La8
            return r0
        La8:
            r0 = r2
            r2 = r4
        Laa:
            androidx.compose.ui.unit.Velocity r2 = (androidx.compose.ui.unit.Velocity) r2
            long r7 = r2.getPackedValue()
            long r9 = androidx.compose.ui.unit.Velocity.m6937minusAH228Gc(r12, r7)
            long r14 = androidx.compose.ui.unit.Velocity.m6937minusAH228Gc(r5, r9)
            androidx.compose.ui.unit.Velocity r2 = androidx.compose.ui.unit.Velocity.m6925boximpl(r14)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
