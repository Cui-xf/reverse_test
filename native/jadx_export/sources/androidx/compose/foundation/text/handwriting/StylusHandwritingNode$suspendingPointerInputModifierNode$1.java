package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: StylusHandwriting.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1", f = "StylusHandwriting.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class StylusHandwritingNode$suspendingPointerInputModifierNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StylusHandwritingNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StylusHandwritingNode$suspendingPointerInputModifierNode$1(StylusHandwritingNode stylusHandwritingNode, Continuation<? super StylusHandwritingNode$suspendingPointerInputModifierNode$1> continuation) {
        super(2, continuation);
        this.this$0 = stylusHandwritingNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StylusHandwritingNode$suspendingPointerInputModifierNode$1 stylusHandwritingNode$suspendingPointerInputModifierNode$1 = new StylusHandwritingNode$suspendingPointerInputModifierNode$1(this.this$0, continuation);
        stylusHandwritingNode$suspendingPointerInputModifierNode$1.L$0 = obj;
        return stylusHandwritingNode$suspendingPointerInputModifierNode$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((StylusHandwritingNode$suspendingPointerInputModifierNode$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: StylusHandwriting.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1$1", f = "StylusHandwriting.kt", i = {0, 1, 1, 1, 2, 2}, l = {134, 158, 186}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "firstDown", "pass", "$this$awaitEachGesture", "firstDown"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ StylusHandwritingNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StylusHandwritingNode stylusHandwritingNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = stylusHandwritingNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Path cross not found for [B:15:0x0084, B:19:0x0097], limit reached: 97 */
        /* JADX WARN: Removed duplicated region for block: B:101:0x023d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:102:0x0235 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:103:0x016d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:104:0x0168 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0112 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0113  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x015f A[LOOP:1: B:46:0x012c->B:58:0x015f, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0174  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01db A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x01dc  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01f4  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x022a A[LOOP:0: B:79:0x01f2->B:91:0x022a, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x0241  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x0244  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0113 -> B:45:0x011c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x01dc -> B:78:0x01e1). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                Method dump skipped, instructions count: 618
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                PointerInputScope $this$SuspendingPointerInputModifierNode = (PointerInputScope) this.L$0;
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture($this$SuspendingPointerInputModifierNode, new AnonymousClass1(this.this$0, null), this) != coroutine_suspended) {
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
