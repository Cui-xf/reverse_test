package androidx.compose.material3;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: AppBar.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"androidx/compose/material3/ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ ExitUntilCollapsedScrollBehavior this$0;

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    public /* synthetic */ Object mo478onPreFlingQWom1Mo(long j, Continuation continuation) {
        return NestedScrollConnection.CC.m5274onPreFlingQWom1Mo$suspendImpl(this, j, continuation);
    }

    ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1(ExitUntilCollapsedScrollBehavior $receiver) {
        this.this$0 = $receiver;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo479onPreScrollOzD1aCk(long available, int source) {
        if (!this.this$0.getCanScroll().invoke().booleanValue() || Offset.m3946getYimpl(available) > 0.0f) {
            return Offset.INSTANCE.m3961getZeroF1C5BW0();
        }
        float prevHeightOffset = this.this$0.getState().getHeightOffset();
        this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m3946getYimpl(available));
        return !((prevHeightOffset > this.this$0.getState().getHeightOffset() ? 1 : (prevHeightOffset == this.this$0.getState().getHeightOffset() ? 0 : -1)) == 0) ? Offset.m3939copydBAh8RU$default(available, 0.0f, 0.0f, 2, null) : Offset.INSTANCE.m3961getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo477onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!this.this$0.getCanScroll().invoke().booleanValue()) {
            return Offset.INSTANCE.m3961getZeroF1C5BW0();
        }
        TopAppBarState state = this.this$0.getState();
        state.setContentOffset(state.getContentOffset() + Offset.m3946getYimpl(consumed));
        if (Offset.m3946getYimpl(available) < 0.0f || Offset.m3946getYimpl(consumed) < 0.0f) {
            float oldHeightOffset = this.this$0.getState().getHeightOffset();
            this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m3946getYimpl(consumed));
            return OffsetKt.Offset(0.0f, this.this$0.getState().getHeightOffset() - oldHeightOffset);
        }
        if ((Offset.m3946getYimpl(consumed) == 0.0f) && Offset.m3946getYimpl(available) > 0.0f) {
            this.this$0.getState().setContentOffset(0.0f);
        }
        if (Offset.m3946getYimpl(available) > 0.0f) {
            float oldHeightOffset2 = this.this$0.getState().getHeightOffset();
            this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Offset.m3946getYimpl(available));
            return OffsetKt.Offset(0.0f, this.this$0.getState().getHeightOffset() - oldHeightOffset2);
        }
        return Offset.INSTANCE.m3961getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo476onPostFlingRZ2iAVY(long r9, long r11, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r13) {
        /*
            r8 = this;
            boolean r0 = r13 instanceof androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1
            if (r0 == 0) goto L14
            r0 = r13
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = (androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 r0 = new androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1
            r0.<init>(r8, r13)
        L19:
            r6 = r0
            java.lang.Object r13 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            switch(r1) {
                case 0: goto L40;
                case 1: goto L34;
                case 2: goto L2d;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L2d:
            long r9 = r6.J$0
            kotlin.ResultKt.throwOnFailure(r13)
            r11 = r13
            goto L81
        L34:
            long r9 = r6.J$0
            java.lang.Object r11 = r6.L$0
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 r11 = (androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1) r11
            kotlin.ResultKt.throwOnFailure(r13)
            r4 = r9
            r9 = r13
            goto L55
        L40:
            kotlin.ResultKt.throwOnFailure(r13)
            r1 = r8
            r2 = r9
            r4 = r11
            r6.L$0 = r1
            r6.J$0 = r4
            r9 = 1
            r6.label = r9
            java.lang.Object r9 = androidx.compose.ui.input.nestedscroll.NestedScrollConnection.CC.m5265$default$onPostFlingRZ2iAVY(r1, r2, r4, r6)
            if (r9 != r0) goto L54
            return r0
        L54:
            r11 = r1
        L55:
            androidx.compose.ui.unit.Velocity r9 = (androidx.compose.ui.unit.Velocity) r9
            long r9 = r9.getPackedValue()
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior r12 = r11.this$0
            androidx.compose.material3.TopAppBarState r12 = r12.getState()
            float r1 = androidx.compose.ui.unit.Velocity.m6935getYimpl(r4)
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior r2 = r11.this$0
            androidx.compose.animation.core.DecayAnimationSpec r2 = r2.getFlingAnimationSpec()
            androidx.compose.material3.ExitUntilCollapsedScrollBehavior r3 = r11.this$0
            androidx.compose.animation.core.AnimationSpec r3 = r3.getSnapAnimationSpec()
            r7 = 0
            r6.L$0 = r7
            r6.J$0 = r9
            r7 = 2
            r6.label = r7
            java.lang.Object r11 = androidx.compose.material3.AppBarKt.access$settleAppBar(r12, r1, r2, r3, r6)
            if (r11 != r0) goto L81
            return r0
        L81:
            androidx.compose.ui.unit.Velocity r11 = (androidx.compose.ui.unit.Velocity) r11
            long r11 = r11.getPackedValue()
            long r9 = androidx.compose.ui.unit.Velocity.m6938plusAH228Gc(r9, r11)
            androidx.compose.ui.unit.Velocity r9 = androidx.compose.ui.unit.Velocity.m6925boximpl(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1.mo476onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
