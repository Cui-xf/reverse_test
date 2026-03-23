package androidx.compose.material;

import androidx.compose.material.BackdropScaffoldKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BackdropScaffold.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1", f = "BackdropScaffold.kt", i = {0}, l = {708}, m = "onPreFling-QWom1Mo", n = {"available"}, s = {"J$0"})
/* loaded from: classes.dex */
final class BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BackdropScaffoldKt.C03871 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1(BackdropScaffoldKt.C03871 c03871, Continuation<? super BackdropScaffoldKt$ConsumeSwipeNestedScrollConnection$1$onPreFling$1> continuation) {
        super(continuation);
        this.this$0 = c03871;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.mo478onPreFlingQWom1Mo(0L, this);
    }
}
