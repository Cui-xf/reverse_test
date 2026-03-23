package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1", f = "AnchoredDraggable.kt", i = {}, l = {275, 277}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class AnchoredDraggableNode$onDragStopped$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $velocity;
    Object L$0;
    int label;
    final /* synthetic */ AnchoredDraggableNode<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnchoredDraggableNode$onDragStopped$1(AnchoredDraggableNode<T> anchoredDraggableNode, long j, Continuation<? super AnchoredDraggableNode$onDragStopped$1> continuation) {
        super(2, continuation);
        this.this$0 = anchoredDraggableNode;
        this.$velocity = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnchoredDraggableNode$onDragStopped$1(this.this$0, this.$velocity, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnchoredDraggableNode$onDragStopped$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object $result) {
        AnchoredDraggableNode anchoredDraggableNode;
        AnchoredDraggableNode$onDragStopped$1 anchoredDraggableNode$onDragStopped$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                OverscrollEffect overscrollEffect = ((AnchoredDraggableNode) this.this$0).overscrollEffect;
                anchoredDraggableNode = this.this$0;
                if (overscrollEffect != null) {
                    OverscrollEffect overscrollEffect2 = anchoredDraggableNode.overscrollEffect;
                    Intrinsics.checkNotNull(overscrollEffect2);
                    this.label = 2;
                    if (overscrollEffect2.mo211applyToFlingBMRW4eQ(this.this$0.m378reverseIfNeededAH228Gc(this.$velocity), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    anchoredDraggableNode$onDragStopped$1 = this;
                    return Unit.INSTANCE;
                }
                this.L$0 = anchoredDraggableNode;
                this.label = 1;
                Object obj = ((AnchoredDraggableNode) this.this$0).state.settle(this.this$0.m380toFloatTH1AsA0(this.this$0.m378reverseIfNeededAH228Gc(this.$velocity)), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result = obj;
                anchoredDraggableNode.m383toVelocityadjELrA(((Number) $result).floatValue());
                return Unit.INSTANCE;
            case 1:
                AnchoredDraggableNode anchoredDraggableNode2 = (AnchoredDraggableNode) this.L$0;
                ResultKt.throwOnFailure($result);
                anchoredDraggableNode = anchoredDraggableNode2;
                anchoredDraggableNode.m383toVelocityadjELrA(((Number) $result).floatValue());
                return Unit.INSTANCE;
            case 2:
                anchoredDraggableNode$onDragStopped$1 = this;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "T", "availableVelocity"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1", f = "AnchoredDraggable.kt", i = {0}, l = {280}, m = "invokeSuspend", n = {"availableVelocity"}, s = {"J$0"})
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
        /* synthetic */ long J$0;
        Object L$0;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AnchoredDraggableNode<T> anchoredDraggableNode, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = anchoredDraggableNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.J$0 = ((Velocity) obj).getPackedValue();
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
            return m387invokesFctU(velocity.getPackedValue(), continuation);
        }

        /* renamed from: invoke-sF-c-tU, reason: not valid java name */
        public final Object m387invokesFctU(long j, Continuation<? super Velocity> continuation) {
            return ((AnonymousClass1) create(Velocity.m6925boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            AnonymousClass1 anonymousClass1;
            long availableVelocity;
            AnchoredDraggableNode anchoredDraggableNode;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    anonymousClass1 = this;
                    availableVelocity = anonymousClass1.J$0;
                    anchoredDraggableNode = anonymousClass1.this$0;
                    anonymousClass1.L$0 = anchoredDraggableNode;
                    anonymousClass1.J$0 = availableVelocity;
                    anonymousClass1.label = 1;
                    Object obj = ((AnchoredDraggableNode) anonymousClass1.this$0).state.settle(anonymousClass1.this$0.m380toFloatTH1AsA0(availableVelocity), anonymousClass1);
                    if (obj != coroutine_suspended) {
                        $result = obj;
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    long availableVelocity2 = this.J$0;
                    AnchoredDraggableNode anchoredDraggableNode2 = (AnchoredDraggableNode) this.L$0;
                    ResultKt.throwOnFailure($result);
                    anchoredDraggableNode = anchoredDraggableNode2;
                    availableVelocity = availableVelocity2;
                    anonymousClass1 = this;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long consumed = anchoredDraggableNode.m383toVelocityadjELrA(((Number) $result).floatValue());
            float currentOffset = ((AnchoredDraggableNode) anonymousClass1.this$0).state.requireOffset();
            float minAnchor = ((AnchoredDraggableNode) anonymousClass1.this$0).state.getAnchors().minAnchor();
            float maxAnchor = ((AnchoredDraggableNode) anonymousClass1.this$0).state.getAnchors().maxAnchor();
            if (currentOffset >= maxAnchor || currentOffset <= minAnchor) {
                availableVelocity = consumed;
            }
            return Velocity.m6925boximpl(availableVelocity);
        }
    }
}
