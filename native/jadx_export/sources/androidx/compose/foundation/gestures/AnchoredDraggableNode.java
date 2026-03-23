package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.AnchoredDragScope;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BI\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0002\u0010\u000fJM\u0010\u0013\u001a\u00020\u00142=\u0010\u0015\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00140\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0016H\u0096@¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001a\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000¢\u0006\u0004\b'\u0010#J\b\u0010\u000e\u001a\u00020\bH\u0016JO\u0010(\u001a\u00020\u00142\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0002\u0010\u000fJ\u0016\u0010)\u001a\u00020!*\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u0016\u0010)\u001a\u00020&*\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010+J\u0016\u0010-\u001a\u00020.*\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u0016\u0010-\u001a\u00020.*\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b1\u00100J\u0019\u00102\u001a\u00020!*\u00020.H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u0019\u00105\u001a\u00020&*\u00020.H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00104R\u0014\u0010\u0010\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableNode;", "T", "Landroidx/compose/foundation/gestures/DragGestureNode;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "startDragImmediately", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLjava/lang/Boolean;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/OverscrollEffect;Z)V", "isReverseDirection", "()Z", "Ljava/lang/Boolean;", "drag", "", "forEachDelta", "Lkotlin/Function2;", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "Landroidx/compose/ui/geometry/Offset;", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", "update", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "(J)J", "reverseIfNeeded-AH228Gc", "toFloat", "", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "toVelocity", "toVelocity-adjELrA", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class AnchoredDraggableNode<T> extends DragGestureNode {
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    private Boolean reverseDirection;
    private boolean startDragImmediately;
    private AnchoredDraggableState<T> state;

    public AnchoredDraggableNode(AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean enabled, Boolean reverseDirection, MutableInteractionSource interactionSource, OverscrollEffect overscrollEffect, boolean startDragImmediately) {
        super(AnchoredDraggableKt.AlwaysDrag, enabled, interactionSource, orientation);
        this.state = anchoredDraggableState;
        this.orientation = orientation;
        this.reverseDirection = reverseDirection;
        this.overscrollEffect = overscrollEffect;
        this.startDragImmediately = startDragImmediately;
    }

    private final boolean isReverseDirection() {
        if (this.reverseDirection == null) {
            return DelegatableNodeKt.requireLayoutDirection(this) == LayoutDirection.Rtl && this.orientation == Orientation.Horizontal;
        }
        Boolean bool = this.reverseDirection;
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "it", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2", f = "AnchoredDraggable.kt", i = {}, l = {251}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> $forEachDelta;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, AnchoredDraggableNode<T> anchoredDraggableNode, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.$forEachDelta = function2;
            this.this$0 = anchoredDraggableNode;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$forEachDelta, this.this$0, continuation);
            anonymousClass2.L$0 = anchoredDragScope;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final AnchoredDragScope $this$anchoredDrag = (AnchoredDragScope) this.L$0;
                    Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> function2 = this.$forEachDelta;
                    final AnchoredDraggableNode<T> anchoredDraggableNode = this.this$0;
                    Function1<DragEvent.DragDelta, Unit> function1 = new Function1<DragEvent.DragDelta, Unit>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode.drag.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DragEvent.DragDelta dragDelta) {
                            invoke2(dragDelta);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DragEvent.DragDelta dragDelta) {
                            if (((AnchoredDraggableNode) anchoredDraggableNode).overscrollEffect == null) {
                                AnchoredDragScope.CC.dragTo$default($this$anchoredDrag, ((AnchoredDraggableNode) anchoredDraggableNode).state.newOffsetForDelta$foundation_release(anchoredDraggableNode.m381toFloatk4lQ0M(anchoredDraggableNode.m379reverseIfNeededMKHz9U(dragDelta.getDelta()))), 0.0f, 2, null);
                                return;
                            }
                            OverscrollEffect overscrollEffect = ((AnchoredDraggableNode) anchoredDraggableNode).overscrollEffect;
                            Intrinsics.checkNotNull(overscrollEffect);
                            long jM379reverseIfNeededMKHz9U = anchoredDraggableNode.m379reverseIfNeededMKHz9U(dragDelta.getDelta());
                            int iM5298getUserInputWNlRxjI = NestedScrollSource.INSTANCE.m5298getUserInputWNlRxjI();
                            final AnchoredDraggableNode<T> anchoredDraggableNode2 = anchoredDraggableNode;
                            final AnchoredDragScope anchoredDragScope = $this$anchoredDrag;
                            overscrollEffect.mo212applyToScrollRhakbz0(jM379reverseIfNeededMKHz9U, iM5298getUserInputWNlRxjI, new Function1<Offset, Offset>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode.drag.2.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Offset invoke(Offset offset) {
                                    return Offset.m3934boximpl(m386invokeMKHz9U(offset.getPackedValue()));
                                }

                                /* renamed from: invoke-MK-Hz9U, reason: not valid java name */
                                public final long m386invokeMKHz9U(long deltaForDrag) {
                                    float dragOffset = ((AnchoredDraggableNode) anchoredDraggableNode2).state.newOffsetForDelta$foundation_release(anchoredDraggableNode2.m381toFloatk4lQ0M(deltaForDrag));
                                    long consumedDelta = anchoredDraggableNode2.m382toOffsettuRUvjQ(dragOffset - ((AnchoredDraggableNode) anchoredDraggableNode2).state.requireOffset());
                                    AnchoredDragScope.CC.dragTo$default(anchoredDragScope, dragOffset, 0.0f, 2, null);
                                    return consumedDelta;
                                }
                            });
                        }
                    };
                    this.label = 1;
                    if (function2.invoke(function1, this) != coroutine_suspended) {
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

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(this.state, null, new AnonymousClass2(function2, this, null), continuation, 1, null);
        return objAnchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnchoredDrag$default : Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* renamed from: onDragStarted-k-4lQ0M, reason: not valid java name */
    public void mo384onDragStartedk4lQ0M(long startedPosition) {
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* renamed from: onDragStopped-TH1AsA0, reason: not valid java name */
    public void mo385onDragStoppedTH1AsA0(long velocity) {
        if (getIsAttached()) {
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AnchoredDraggableNode$onDragStopped$1(this, velocity, null), 3, null);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* renamed from: startDragImmediately, reason: from getter */
    public boolean getStartDragImmediately() {
        return this.startDragImmediately;
    }

    public final void update(AnchoredDraggableState<T> state, Orientation orientation, boolean enabled, Boolean reverseDirection, MutableInteractionSource interactionSource, OverscrollEffect overscrollEffect, boolean startDragImmediately) {
        boolean resetPointerInputHandling;
        boolean resetPointerInputHandling2 = false;
        if (!Intrinsics.areEqual(this.state, state)) {
            this.state = state;
            resetPointerInputHandling2 = true;
        }
        if (this.orientation != orientation) {
            this.orientation = orientation;
            resetPointerInputHandling2 = true;
        }
        if (Intrinsics.areEqual(this.reverseDirection, reverseDirection)) {
            resetPointerInputHandling = resetPointerInputHandling2;
        } else {
            this.reverseDirection = reverseDirection;
            resetPointerInputHandling = true;
        }
        this.startDragImmediately = startDragImmediately;
        this.overscrollEffect = overscrollEffect;
        DragGestureNode.update$default(this, null, enabled, interactionSource, orientation, resetPointerInputHandling, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m382toOffsettuRUvjQ(float $this$toOffset_u2dtuRUvjQ) {
        return OffsetKt.Offset(this.orientation == Orientation.Horizontal ? $this$toOffset_u2dtuRUvjQ : 0.0f, this.orientation == Orientation.Vertical ? $this$toOffset_u2dtuRUvjQ : 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toVelocity-adjELrA, reason: not valid java name */
    public final long m383toVelocityadjELrA(float $this$toVelocity_u2dadjELrA) {
        return VelocityKt.Velocity(this.orientation == Orientation.Horizontal ? $this$toVelocity_u2dadjELrA : 0.0f, this.orientation == Orientation.Vertical ? $this$toVelocity_u2dadjELrA : 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m380toFloatTH1AsA0(long $this$toFloat_u2dTH1AsA0) {
        return this.orientation == Orientation.Vertical ? Velocity.m6935getYimpl($this$toFloat_u2dTH1AsA0) : Velocity.m6934getXimpl($this$toFloat_u2dTH1AsA0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m381toFloatk4lQ0M(long $this$toFloat_u2dk_u2d4lQ0M) {
        return this.orientation == Orientation.Vertical ? Offset.m3946getYimpl($this$toFloat_u2dk_u2d4lQ0M) : Offset.m3945getXimpl($this$toFloat_u2dk_u2d4lQ0M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reverseIfNeeded-AH228Gc, reason: not valid java name */
    public final long m378reverseIfNeededAH228Gc(long $this$reverseIfNeeded_u2dAH228Gc) {
        return Velocity.m6940timesadjELrA($this$reverseIfNeeded_u2dAH228Gc, isReverseDirection() ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m379reverseIfNeededMKHz9U(long $this$reverseIfNeeded_u2dMK_u2dHz9U) {
        return Offset.m3952timestuRUvjQ($this$reverseIfNeeded_u2dMK_u2dHz9U, isReverseDirection() ? -1.0f : 1.0f);
    }
}
