package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.core.view.MotionEventCompat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: AwaitFirstLayoutModifier.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\fR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "()V", "continuation", "Lkotlin/coroutines/Continuation;", "", "wasPositioned", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "waitForFirstLayout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AwaitFirstLayoutModifier implements OnGloballyPositionedModifier {
    public static final int $stable = 0;
    private Continuation<? super Unit> continuation;
    private boolean wasPositioned;

    /* compiled from: AwaitFirstLayoutModifier.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier", f = "AwaitFirstLayoutModifier.kt", i = {0, 0}, l = {MotionEventCompat.AXIS_GENERIC_4}, m = "waitForFirstLayout", n = {"this", "oldContinuation"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AwaitFirstLayoutModifier.this.waitForFirstLayout(this);
        }
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return Modifier.Element.CC.$default$all(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(Function1 function1) {
        return Modifier.Element.CC.$default$any(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldIn(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldOut(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object waitForFirstLayout(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1 r0 = (androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1 r0 = new androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier$waitForFirstLayout$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            switch(r2) {
                case 0: goto L38;
                case 1: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L2c:
            java.lang.Object r1 = r0.L$1
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r2 = (androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6f
        L38:
            kotlin.ResultKt.throwOnFailure(r8)
            r2 = r7
            boolean r3 = r2.wasPositioned
            if (r3 != 0) goto L7d
            kotlin.coroutines.Continuation<? super kotlin.Unit> r3 = r2.continuation
            r0.L$0 = r2
            r0.L$1 = r3
            r4 = 1
            r0.label = r4
            r4 = r0
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            kotlin.coroutines.SafeContinuation r5 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r4)
            r5.<init>(r4)
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6 = 0
            r2.continuation = r4
            java.lang.Object r2 = r5.getOrThrow()
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r2 != r4) goto L6b
            r4 = r0
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r4)
        L6b:
            if (r2 != r1) goto L6e
            return r1
        L6e:
            r1 = r3
        L6f:
            if (r1 == 0) goto L7d
            kotlin.Result$Companion r2 = kotlin.Result.INSTANCE
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            java.lang.Object r2 = kotlin.Result.m6999constructorimpl(r2)
            r1.resumeWith(r2)
        L7d:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier.waitForFirstLayout(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.ui.layout.OnGloballyPositionedModifier
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        if (!this.wasPositioned) {
            this.wasPositioned = true;
            Continuation<? super Unit> continuation = this.continuation;
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m6999constructorimpl(Unit.INSTANCE));
            }
            this.continuation = null;
        }
    }
}
