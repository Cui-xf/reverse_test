package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material.AnchoredDragScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\u0001\u001a\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002H\u0002\u001aF\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0010H\u0082@¢\u0006\u0002\u0010\u0012\u001aR\u0010\u0013\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0002*\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001aH\u0001\u001a0\u0010\u001f\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u0010 \u001a\u0002H\u00022\b\b\u0002\u0010!\u001a\u00020\"H\u0081@¢\u0006\u0002\u0010#\u001ar\u0010$\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0002*\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182H\u0010%\u001aD\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110*¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(+\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\u0004\u0012\u0002H\u00020,0\u0010H\u0001\u001a&\u0010-\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u0010 \u001a\u0002H\u0002H\u0081@¢\u0006\u0002\u0010.¨\u0006/"}, d2 = {"DraggableAnchors", "Landroidx/compose/material/DraggableAnchors;", "T", "", "builder", "Lkotlin/Function1;", "Landroidx/compose/material/DraggableAnchorsConfig;", "", "Lkotlin/ExtensionFunctionType;", "emptyDraggableAnchors", "Landroidx/compose/material/MapDraggableAnchors;", "restartable", "I", "inputs", "Lkotlin/Function0;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anchoredDraggable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "animateTo", "targetValue", "velocity", "", "(Landroidx/compose/material/AnchoredDraggableState;Ljava/lang/Object;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "draggableAnchors", "anchors", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "size", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Lkotlin/Pair;", "snapTo", "(Landroidx/compose/material/AnchoredDraggableState;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnchoredDraggableKt {

    /* compiled from: AnchoredDraggable.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt", f = "AnchoredDraggable.kt", i = {}, l = {742}, m = "restartable", n = {}, s = {})
    /* renamed from: androidx.compose.material.AnchoredDraggableKt$restartable$1, reason: invalid class name and case insensitive filesystem */
    static final class C03801<I> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C03801(Continuation<? super C03801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnchoredDraggableKt.restartable(null, null, this);
        }
    }

    public static final <T> DraggableAnchors<T> DraggableAnchors(Function1<? super DraggableAnchorsConfig<T>, Unit> function1) {
        DraggableAnchorsConfig draggableAnchorsConfig = new DraggableAnchorsConfig();
        function1.invoke(draggableAnchorsConfig);
        return new MapDraggableAnchors(draggableAnchorsConfig.getAnchors$material_release());
    }

    public static final <T> Modifier anchoredDraggable(Modifier $this$anchoredDraggable, AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, boolean enabled, boolean reverseDirection, MutableInteractionSource interactionSource, boolean startDragImmediately) {
        return DraggableKt.draggable($this$anchoredDraggable, anchoredDraggableState.getDraggableState(), orientation, (188 & 4) != 0 ? true : enabled, (188 & 8) != 0 ? null : interactionSource, (188 & 16) != 0 ? false : startDragImmediately, (188 & 32) != 0 ? DraggableKt.NoOpOnDragStarted : null, (188 & 64) != 0 ? DraggableKt.NoOpOnDragStopped : new AnonymousClass1(anchoredDraggableState, null), (188 & 128) != 0 ? false : reverseDirection);
    }

    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "velocity", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$anchoredDraggable$1", f = "AnchoredDraggable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.AnchoredDraggableKt$anchoredDraggable$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnchoredDraggableState<T> $state;
        /* synthetic */ float F$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AnchoredDraggableState<T> anchoredDraggableState, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.$state = anchoredDraggableState;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Float f, Continuation<? super Unit> continuation) {
            return invoke(coroutineScope, f.floatValue(), continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, float f, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$state, continuation);
            anonymousClass1.L$0 = coroutineScope;
            anonymousClass1.F$0 = f;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: AnchoredDraggable.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$anchoredDraggable$1$1", f = "AnchoredDraggable.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.material.AnchoredDraggableKt$anchoredDraggable$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AnchoredDraggableState<T> $state;
            final /* synthetic */ float $velocity;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00651(AnchoredDraggableState<T> anchoredDraggableState, float f, Continuation<? super C00651> continuation) {
                super(2, continuation);
                this.$state = anchoredDraggableState;
                this.$velocity = f;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00651(this.$state, this.$velocity, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00651) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        if (this.$state.settle(this.$velocity, this) != coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope $this$draggable = (CoroutineScope) this.L$0;
                    float velocity = this.F$0;
                    BuildersKt__Builders_commonKt.launch$default($this$draggable, null, null, new C00651(this.$state, velocity, null), 3, null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/material/AnchoredDragScope;", "anchors", "Landroidx/compose/material/DraggableAnchors;", "latestTarget"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$snapTo$2", f = "AnchoredDraggable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.AnchoredDraggableKt$snapTo$2, reason: invalid class name and case insensitive filesystem */
    static final class C03822<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        C03822(Continuation<? super C03822> continuation) {
            super(4, continuation);
        }

        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t, Continuation<? super Unit> continuation) {
            C03822 c03822 = new C03822(continuation);
            c03822.L$0 = anchoredDragScope;
            c03822.L$1 = draggableAnchors;
            c03822.L$2 = t;
            return c03822.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(AnchoredDragScope anchoredDragScope, Object obj, Object obj2, Continuation<? super Unit> continuation) {
            return invoke(anchoredDragScope, (DraggableAnchors<DraggableAnchors<T>>) obj, (DraggableAnchors<T>) obj2, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    AnchoredDragScope $this$anchoredDrag = (AnchoredDragScope) this.L$0;
                    DraggableAnchors draggableAnchors = (DraggableAnchors) this.L$1;
                    Object latestTarget = this.L$2;
                    float targetOffset = draggableAnchors.positionOf(latestTarget);
                    if (!Float.isNaN(targetOffset)) {
                        AnchoredDragScope.CC.dragTo$default($this$anchoredDrag, targetOffset, 0.0f, 2, null);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static final <T> Object snapTo(AnchoredDraggableState<T> anchoredDraggableState, T t, Continuation<? super Unit> continuation) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t, null, new C03822(null), continuation, 2, null);
        return objAnchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnchoredDrag$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$default(AnchoredDraggableState anchoredDraggableState, Object obj, float f, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            f = anchoredDraggableState.getLastVelocity();
        }
        return animateTo(anchoredDraggableState, obj, f, continuation);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/material/AnchoredDragScope;", "anchors", "Landroidx/compose/material/DraggableAnchors;", "latestTarget"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$animateTo$2", f = "AnchoredDraggable.kt", i = {}, l = {706}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.AnchoredDraggableKt$animateTo$2, reason: invalid class name */
    static final class AnonymousClass2<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnchoredDraggableState<T> $this_animateTo;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AnchoredDraggableState<T> anchoredDraggableState, float f, Continuation<? super AnonymousClass2> continuation) {
            super(4, continuation);
            this.$this_animateTo = anchoredDraggableState;
            this.$velocity = f;
        }

        public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, T t, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_animateTo, this.$velocity, continuation);
            anonymousClass2.L$0 = anchoredDragScope;
            anonymousClass2.L$1 = draggableAnchors;
            anonymousClass2.L$2 = t;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(AnchoredDragScope anchoredDragScope, Object obj, Object obj2, Continuation<? super Unit> continuation) {
            return invoke(anchoredDragScope, (DraggableAnchors<DraggableAnchors<T>>) obj, (DraggableAnchors<T>) obj2, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            AnonymousClass2 anonymousClass2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final AnchoredDragScope $this$anchoredDrag = (AnchoredDragScope) this.L$0;
                    DraggableAnchors draggableAnchors = (DraggableAnchors) this.L$1;
                    Object latestTarget = this.L$2;
                    float targetOffset = draggableAnchors.positionOf(latestTarget);
                    if (!Float.isNaN(targetOffset)) {
                        final Ref.FloatRef prev = new Ref.FloatRef();
                        prev.element = Float.isNaN(this.$this_animateTo.getOffset()) ? 0.0f : this.$this_animateTo.getOffset();
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 1;
                        if (SuspendAnimationKt.animate(prev.element, targetOffset, this.$velocity, this.$this_animateTo.getAnimationSpec(), new Function2<Float, Float, Unit>() { // from class: androidx.compose.material.AnchoredDraggableKt.animateTo.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Float f, Float f2) {
                                invoke(f.floatValue(), f2.floatValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(float value, float velocity) {
                                $this$anchoredDrag.dragTo(value, velocity);
                                prev.element = value;
                            }
                        }, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        anonymousClass2 = this;
                    }
                    return Unit.INSTANCE;
                case 1:
                    anonymousClass2 = this;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static final <T> Object animateTo(AnchoredDraggableState<T> anchoredDraggableState, T t, float velocity, Continuation<? super Unit> continuation) {
        Object objAnchoredDrag$default = AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, t, null, new AnonymousClass2(anchoredDraggableState, velocity, null), continuation, 2, null);
        return objAnchoredDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnchoredDrag$default : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <I> java.lang.Object restartable(kotlin.jvm.functions.Function0<? extends I> r4, kotlin.jvm.functions.Function2<? super I, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof androidx.compose.material.AnchoredDraggableKt.C03801
            if (r0 == 0) goto L14
            r0 = r6
            androidx.compose.material.AnchoredDraggableKt$restartable$1 r0 = (androidx.compose.material.AnchoredDraggableKt.C03801) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            androidx.compose.material.AnchoredDraggableKt$restartable$1 r0 = new androidx.compose.material.AnchoredDraggableKt$restartable$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            switch(r2) {
                case 0: goto L32;
                case 1: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2c:
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: androidx.compose.material.AnchoredDragFinishedSignal -> L30
            goto L48
        L30:
            r4 = move-exception
            goto L49
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.compose.material.AnchoredDraggableKt$restartable$2 r2 = new androidx.compose.material.AnchoredDraggableKt$restartable$2     // Catch: androidx.compose.material.AnchoredDragFinishedSignal -> L30
            r3 = 0
            r2.<init>(r4, r5, r3)     // Catch: androidx.compose.material.AnchoredDragFinishedSignal -> L30
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch: androidx.compose.material.AnchoredDragFinishedSignal -> L30
            r3 = 1
            r0.label = r3     // Catch: androidx.compose.material.AnchoredDragFinishedSignal -> L30
            java.lang.Object r2 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r2, r0)     // Catch: androidx.compose.material.AnchoredDragFinishedSignal -> L30
            if (r2 != r1) goto L48
            return r1
        L48:
        L49:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AnchoredDraggableKt.restartable(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "I", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$restartable$2", f = "AnchoredDraggable.kt", i = {}, l = {745}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.AnchoredDraggableKt$restartable$2, reason: invalid class name and case insensitive filesystem */
    static final class C03812 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Function0<I> $inputs;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03812(Function0<? extends I> function0, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super C03812> continuation) {
            super(2, continuation);
            this.$inputs = function0;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03812 c03812 = new C03812(this.$inputs, this.$block, continuation);
            c03812.L$0 = obj;
            return c03812;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C03812) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                    Ref.ObjectRef previousDrag = new Ref.ObjectRef();
                    this.label = 1;
                    if (SnapshotStateKt.snapshotFlow(this.$inputs).collect(new AnonymousClass1(previousDrag, $this$coroutineScope, this.$block), this) != coroutine_suspended) {
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

        /* compiled from: AnchoredDraggable.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "I", "latestInputs", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        /* renamed from: androidx.compose.material.AnchoredDraggableKt$restartable$2$1, reason: invalid class name */
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ Ref.ObjectRef<Job> $previousDrag;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Ref.ObjectRef<Job> objectRef, CoroutineScope coroutineScope, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2) {
                this.$previousDrag = objectRef;
                this.$$this$coroutineScope = coroutineScope;
                this.$block = function2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(I r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
                /*
                    r9 = this;
                    boolean r0 = r11 instanceof androidx.compose.material.AnchoredDraggableKt$restartable$2$1$emit$1
                    if (r0 == 0) goto L14
                    r0 = r11
                    androidx.compose.material.AnchoredDraggableKt$restartable$2$1$emit$1 r0 = (androidx.compose.material.AnchoredDraggableKt$restartable$2$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L14
                    int r11 = r0.label
                    int r11 = r11 - r2
                    r0.label = r11
                    goto L19
                L14:
                    androidx.compose.material.AnchoredDraggableKt$restartable$2$1$emit$1 r0 = new androidx.compose.material.AnchoredDraggableKt$restartable$2$1$emit$1
                    r0.<init>(r9, r11)
                L19:
                    java.lang.Object r11 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    switch(r2) {
                        case 0: goto L3b;
                        case 1: goto L2c;
                        default: goto L24;
                    }
                L24:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r11)
                    throw r10
                L2c:
                    r10 = 0
                    java.lang.Object r1 = r0.L$2
                    kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
                    java.lang.Object r1 = r0.L$1
                    java.lang.Object r2 = r0.L$0
                    androidx.compose.material.AnchoredDraggableKt$restartable$2$1 r2 = (androidx.compose.material.AnchoredDraggableKt.C03812.AnonymousClass1) r2
                    kotlin.ResultKt.throwOnFailure(r11)
                    goto L65
                L3b:
                    kotlin.ResultKt.throwOnFailure(r11)
                    r2 = r9
                    kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.Job> r3 = r2.$previousDrag
                    T r3 = r3.element
                    kotlinx.coroutines.Job r3 = (kotlinx.coroutines.Job) r3
                    if (r3 == 0) goto L67
                    r4 = r3
                    r5 = 0
                    androidx.compose.material.AnchoredDragFinishedSignal r6 = new androidx.compose.material.AnchoredDragFinishedSignal
                    r6.<init>()
                    java.util.concurrent.CancellationException r6 = (java.util.concurrent.CancellationException) r6
                    r4.cancel(r6)
                    r0.L$0 = r2
                    r0.L$1 = r10
                    r0.L$2 = r3
                    r3 = 1
                    r0.label = r3
                    java.lang.Object r3 = r4.join(r0)
                    if (r3 != r1) goto L63
                    return r1
                L63:
                    r1 = r10
                    r10 = r5
                L65:
                    r10 = r1
                L67:
                    kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.Job> r1 = r2.$previousDrag
                    kotlinx.coroutines.CoroutineScope r3 = r2.$$this$coroutineScope
                    kotlinx.coroutines.CoroutineStart r5 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                    androidx.compose.material.AnchoredDraggableKt$restartable$2$1$2 r4 = new androidx.compose.material.AnchoredDraggableKt$restartable$2$1$2
                    kotlin.jvm.functions.Function2<I, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r6 = r2.$block
                    kotlinx.coroutines.CoroutineScope r7 = r2.$$this$coroutineScope
                    r8 = 0
                    r4.<init>(r6, r10, r7, r8)
                    r6 = r4
                    kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
                    r7 = 1
                    r4 = 0
                    kotlinx.coroutines.Job r3 = kotlinx.coroutines.BuildersKt.launch$default(r3, r4, r5, r6, r7, r8)
                    r1.element = r3
                    kotlin.Unit r1 = kotlin.Unit.INSTANCE
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AnchoredDraggableKt.C03812.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }

            /* compiled from: AnchoredDraggable.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "I", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$restartable$2$1$2", f = "AnchoredDraggable.kt", i = {}, l = {751}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material.AnchoredDraggableKt$restartable$2$1$2, reason: invalid class name and collision with other inner class name */
            static final class C00662 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
                final /* synthetic */ I $latestInputs;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00662(Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> function2, I i, CoroutineScope coroutineScope, Continuation<? super C00662> continuation) {
                    super(2, continuation);
                    this.$block = function2;
                    this.$latestInputs = i;
                    this.$$this$coroutineScope = coroutineScope;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00662(this.$block, this.$latestInputs, this.$$this$coroutineScope, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00662) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    C00662 c00662;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Function2<I, Continuation<? super Unit>, Object> function2 = this.$block;
                            I i = this.$latestInputs;
                            this.label = 1;
                            if (function2.invoke(i, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            c00662 = this;
                            break;
                        case 1:
                            c00662 = this;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    CoroutineScopeKt.cancel(c00662.$$this$coroutineScope, new AnchoredDragFinishedSignal());
                    return Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> MapDraggableAnchors<T> emptyDraggableAnchors() {
        return new MapDraggableAnchors<>(MapsKt.emptyMap());
    }

    public static final <T> Modifier draggableAnchors(Modifier $this$draggableAnchors, AnchoredDraggableState<T> anchoredDraggableState, Orientation orientation, Function2<? super IntSize, ? super Constraints, ? extends Pair<? extends DraggableAnchors<T>, ? extends T>> function2) {
        return $this$draggableAnchors.then(new DraggableAnchorsElement(anchoredDraggableState, function2, orientation));
    }
}
