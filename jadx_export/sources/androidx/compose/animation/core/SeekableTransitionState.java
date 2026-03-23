package androidx.compose.animation.core;

import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: Transition.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0007\u0018\u0000 X*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002XYB\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u000e\u0010<\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010=J*\u0010>\u001a\u00020\b2\b\b\u0002\u00101\u001a\u00028\u00002\u0010\b\u0002\u0010?\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010@H\u0086@¢\u0006\u0002\u0010AJ\u000e\u0010B\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010=J\b\u0010C\u001a\u00020\bH\u0002J\b\u0010D\u001a\u00020\bH\u0002J\r\u0010E\u001a\u00020\bH\u0000¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020\bH\u0000¢\u0006\u0002\bHJ\u0018\u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020\u0007H\u0002J\u000e\u0010L\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010=J\"\u0010M\u001a\u00020\b2\b\b\u0001\u0010#\u001a\u00020!2\b\b\u0002\u00101\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020\bH\u0002J\u0016\u0010P\u001a\u00020\b2\u0006\u00101\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010QJ\u001b\u0010R\u001a\u00020\b2\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;H\u0010¢\u0006\u0002\bSJ\r\u0010T\u001a\u00020\bH\u0010¢\u0006\u0002\bUJ\u000e\u0010V\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010=J\u000e\u0010W\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010=R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00028\u0000X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0004R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\u0004R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010#\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020!8G@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00190+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\b00X\u0082\u0004¢\u0006\u0002\n\u0000R+\u00101\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u001f\u001a\u0004\b2\u0010\u000b\"\u0004\b3\u0010\u0004R\u001a\u00105\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0016\u0010:\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Landroidx/compose/animation/core/SeekableTransitionState;", "S", "Landroidx/compose/animation/core/TransitionState;", "initialState", "(Ljava/lang/Object;)V", "animateOneFrameLambda", "Lkotlin/Function1;", "", "", "composedTargetState", "getComposedTargetState$animation_core_release", "()Ljava/lang/Object;", "setComposedTargetState$animation_core_release", "Ljava/lang/Object;", "compositionContinuation", "Lkotlinx/coroutines/CancellableContinuation;", "getCompositionContinuation$animation_core_release", "()Lkotlinx/coroutines/CancellableContinuation;", "setCompositionContinuation$animation_core_release", "(Lkotlinx/coroutines/CancellableContinuation;)V", "compositionContinuationMutex", "Lkotlinx/coroutines/sync/Mutex;", "getCompositionContinuationMutex$animation_core_release", "()Lkotlinx/coroutines/sync/Mutex;", "currentAnimation", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "<set-?>", "currentState", "getCurrentState", "setCurrentState$animation_core_release", "currentState$delegate", "Landroidx/compose/runtime/MutableState;", "durationScale", "", "firstFrameLambda", "fraction", "getFraction", "()F", "setFraction", "(F)V", "fraction$delegate", "Landroidx/compose/runtime/MutableFloatState;", "initialValueAnimations", "Landroidx/collection/MutableObjectList;", "lastFrameTimeNanos", "mutatorMutex", "Landroidx/compose/animation/core/MutatorMutex;", "recalculateTotalDurationNanos", "Lkotlin/Function0;", "targetState", "getTargetState", "setTargetState$animation_core_release", "targetState$delegate", "totalDurationNanos", "getTotalDurationNanos$animation_core_release", "()J", "setTotalDurationNanos$animation_core_release", "(J)V", "transition", "Landroidx/compose/animation/core/Transition;", "animateOneFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doOneFrame", "endAllAnimations", "moveAnimationToInitialState", "observeTotalDuration", "observeTotalDuration$animation_core_release", "onTotalDurationChanged", "onTotalDurationChanged$animation_core_release", "recalculateAnimationValue", "animation", "deltaPlayTimeNanos", "runAnimations", "seekTo", "(FLjava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "seekToFraction", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transitionConfigured", "transitionConfigured$animation_core_release", "transitionRemoved", "transitionRemoved$animation_core_release", "waitForComposition", "waitForCompositionAfterTargetStateChange", "Companion", "SeekingAnimationState", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SeekableTransitionState<S> extends TransitionState<S> {
    private final Function1<Long, Unit> animateOneFrameLambda;
    private S composedTargetState;
    private CancellableContinuation<? super S> compositionContinuation;
    private final Mutex compositionContinuationMutex;
    private SeekingAnimationState currentAnimation;

    /* renamed from: currentState$delegate, reason: from kotlin metadata */
    private final MutableState currentState;
    private float durationScale;
    private final Function1<Long, Unit> firstFrameLambda;

    /* renamed from: fraction$delegate, reason: from kotlin metadata */
    private final MutableFloatState fraction;
    private final MutableObjectList<SeekingAnimationState> initialValueAnimations;
    private long lastFrameTimeNanos;
    private final MutatorMutex mutatorMutex;
    private final Function0<Unit> recalculateTotalDurationNanos;

    /* renamed from: targetState$delegate, reason: from kotlin metadata */
    private final MutableState targetState;
    private long totalDurationNanos;
    private Transition<S> transition;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final AnimationVector1D ZeroVelocity = new AnimationVector1D(0.0f);
    private static final AnimationVector1D Target1 = new AnimationVector1D(1.0f);

    /* compiled from: Transition.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState", f = "Transition.kt", i = {0, 1}, l = {368, 371}, m = "runAnimations", n = {"this", "this"}, s = {"L$0", "L$0"})
    /* renamed from: androidx.compose.animation.core.SeekableTransitionState$runAnimations$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SeekableTransitionState<S> seekableTransitionState, Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
            this.this$0 = seekableTransitionState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.runAnimations(this);
        }
    }

    /* compiled from: Transition.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState", f = "Transition.kt", i = {0, 0, 1, 1}, l = {564, 2184}, m = "waitForComposition", n = {"this", "expectedState", "this", "expectedState"}, s = {"L$0", "L$1", "L$0", "L$1"})
    /* renamed from: androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1, reason: invalid class name and case insensitive filesystem */
    static final class C02011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02011(SeekableTransitionState<S> seekableTransitionState, Continuation<? super C02011> continuation) {
            super(continuation);
            this.this$0 = seekableTransitionState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.waitForComposition(this);
        }
    }

    /* compiled from: Transition.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState", f = "Transition.kt", i = {0, 0, 1, 1}, l = {540, 2184}, m = "waitForCompositionAfterTargetStateChange", n = {"this", "expectedState", "this", "expectedState"}, s = {"L$0", "L$1", "L$0", "L$1"})
    /* renamed from: androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1, reason: invalid class name and case insensitive filesystem */
    static final class C02021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02021(SeekableTransitionState<S> seekableTransitionState, Continuation<? super C02021> continuation) {
            super(continuation);
            this.this$0 = seekableTransitionState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.waitForCompositionAfterTargetStateChange(this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SeekableTransitionState(S s) {
        DefaultConstructorMarker defaultConstructorMarker = null;
        super(defaultConstructorMarker);
        this.targetState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s, null, 2, null);
        this.currentState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s, null, 2, null);
        this.composedTargetState = s;
        this.recalculateTotalDurationNanos = new Function0<Unit>(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$recalculateTotalDurationNanos$1
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SeekableTransitionState<S> seekableTransitionState = this.this$0;
                Transition transition = ((SeekableTransitionState) this.this$0).transition;
                seekableTransitionState.setTotalDurationNanos$animation_core_release(transition != null ? transition.getTotalDurationNanos() : 0L);
            }
        };
        this.fraction = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.compositionContinuationMutex = MutexKt.Mutex$default(false, 1, null);
        this.mutatorMutex = new MutatorMutex();
        this.lastFrameTimeNanos = Long.MIN_VALUE;
        this.initialValueAnimations = new MutableObjectList<>(0, 1, defaultConstructorMarker);
        this.firstFrameLambda = new Function1<Long, Unit>(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$firstFrameLambda$1
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long frameTimeNanos) {
                ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = frameTimeNanos;
            }
        };
        this.animateOneFrameLambda = new Function1<Long, Unit>(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$animateOneFrameLambda$1
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long frameTimeNanos) {
                long delta = frameTimeNanos - ((SeekableTransitionState) this.this$0).lastFrameTimeNanos;
                ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = frameTimeNanos;
                long deltaPlayTimeNanos = MathKt.roundToLong(delta / ((SeekableTransitionState) this.this$0).durationScale);
                if (((SeekableTransitionState) this.this$0).initialValueAnimations.isNotEmpty()) {
                    ObjectList this_$iv = ((SeekableTransitionState) this.this$0).initialValueAnimations;
                    SeekableTransitionState<S> seekableTransitionState = this.this$0;
                    Object[] content$iv = this_$iv.content;
                    int i = this_$iv._size;
                    for (int i$iv = 0; i$iv < i; i$iv++) {
                        SeekableTransitionState.SeekingAnimationState animation = (SeekableTransitionState.SeekingAnimationState) content$iv[i$iv];
                        seekableTransitionState.recalculateAnimationValue(animation, deltaPlayTimeNanos);
                        animation.setComplete(true);
                    }
                    Transition transition = ((SeekableTransitionState) this.this$0).transition;
                    if (transition != null) {
                        transition.updateInitialValues$animation_core_release();
                    }
                    MutableObjectList this_$iv2 = ((SeekableTransitionState) this.this$0).initialValueAnimations;
                    int gap$iv = 0;
                    int size$iv = this_$iv2._size;
                    Object[] content$iv2 = this_$iv2.content;
                    MutableObjectList this_$iv$iv = this_$iv2;
                    IntRange intRangeUntil = RangesKt.until(0, this_$iv$iv._size);
                    int i$iv2 = intRangeUntil.getFirst();
                    int last = intRangeUntil.getLast();
                    if (i$iv2 <= last) {
                        while (true) {
                            content$iv2[i$iv2 - gap$iv] = content$iv2[i$iv2];
                            SeekableTransitionState.SeekingAnimationState it = (SeekableTransitionState.SeekingAnimationState) content$iv2[i$iv2];
                            if (it.getIsComplete()) {
                                gap$iv++;
                            }
                            if (i$iv2 == last) {
                                break;
                            } else {
                                i$iv2++;
                            }
                        }
                    }
                    ArraysKt.fill(content$iv2, (Object) null, size$iv - gap$iv, size$iv);
                    this_$iv2._size -= gap$iv;
                }
                SeekableTransitionState.SeekingAnimationState currentAnimation = ((SeekableTransitionState) this.this$0).currentAnimation;
                if (currentAnimation != null) {
                    currentAnimation.setDurationNanos(this.this$0.getTotalDurationNanos());
                    this.this$0.recalculateAnimationValue(currentAnimation, deltaPlayTimeNanos);
                    this.this$0.setFraction(currentAnimation.getValue());
                    if (currentAnimation.getValue() == 1.0f) {
                        ((SeekableTransitionState) this.this$0).currentAnimation = null;
                    }
                    this.this$0.seekToFraction();
                }
            }
        };
    }

    @Override // androidx.compose.animation.core.TransitionState
    public S getTargetState() {
        return (S) this.targetState.getValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void setTargetState$animation_core_release(S s) {
        MutableState $this$setValue$iv = this.targetState;
        $this$setValue$iv.setValue(s);
    }

    @Override // androidx.compose.animation.core.TransitionState
    public S getCurrentState() {
        return (S) this.currentState.getValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void setCurrentState$animation_core_release(S s) {
        MutableState $this$setValue$iv = this.currentState;
        $this$setValue$iv.setValue(s);
    }

    public final S getComposedTargetState$animation_core_release() {
        return this.composedTargetState;
    }

    public final void setComposedTargetState$animation_core_release(S s) {
        this.composedTargetState = s;
    }

    /* renamed from: getTotalDurationNanos$animation_core_release, reason: from getter */
    public final long getTotalDurationNanos() {
        return this.totalDurationNanos;
    }

    public final void setTotalDurationNanos$animation_core_release(long j) {
        this.totalDurationNanos = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFraction(float f) {
        MutableFloatState $this$setValue$iv = this.fraction;
        $this$setValue$iv.setFloatValue(f);
    }

    public final float getFraction() {
        FloatState $this$getValue$iv = this.fraction;
        return $this$getValue$iv.getFloatValue();
    }

    public final CancellableContinuation<S> getCompositionContinuation$animation_core_release() {
        return this.compositionContinuation;
    }

    public final void setCompositionContinuation$animation_core_release(CancellableContinuation<? super S> cancellableContinuation) {
        this.compositionContinuation = cancellableContinuation;
    }

    /* renamed from: getCompositionContinuationMutex$animation_core_release, reason: from getter */
    public final Mutex getCompositionContinuationMutex() {
        return this.compositionContinuationMutex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endAllAnimations() {
        Transition<S> transition = this.transition;
        if (transition != null) {
            transition.clearInitialAnimations$animation_core_release();
        }
        this.initialValueAnimations.clear();
        SeekingAnimationState current = this.currentAnimation;
        if (current != null) {
            this.currentAnimation = null;
            setFraction(1.0f);
            seekToFraction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object runAnimations(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof androidx.compose.animation.core.SeekableTransitionState.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.animation.core.SeekableTransitionState$runAnimations$1 r0 = (androidx.compose.animation.core.SeekableTransitionState.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            androidx.compose.animation.core.SeekableTransitionState$runAnimations$1 r0 = new androidx.compose.animation.core.SeekableTransitionState$runAnimations$1
            r0.<init>(r9, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = -9223372036854775808
            switch(r2) {
                case 0: goto L3e;
                case 1: goto L36;
                case 2: goto L2e;
                default: goto L26;
            }
        L26:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L2e:
            java.lang.Object r2 = r0.L$0
            androidx.compose.animation.core.SeekableTransitionState r2 = (androidx.compose.animation.core.SeekableTransitionState) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L9e
        L36:
            java.lang.Object r2 = r0.L$0
            androidx.compose.animation.core.SeekableTransitionState r2 = (androidx.compose.animation.core.SeekableTransitionState) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L7f
        L3e:
            kotlin.ResultKt.throwOnFailure(r10)
            r2 = r9
            androidx.collection.MutableObjectList<androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState> r5 = r2.initialValueAnimations
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L51
            androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState r5 = r2.currentAnimation
            if (r5 != 0) goto L51
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L51:
            kotlin.coroutines.CoroutineContext r5 = r0.getContext()
            float r5 = androidx.compose.animation.core.SuspendAnimationKt.getDurationScale(r5)
            r6 = 0
            r7 = 1
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 != 0) goto L61
            r5 = 1
            goto L62
        L61:
            r5 = 0
        L62:
            if (r5 == 0) goto L6c
            r2.endAllAnimations()
            r2.lastFrameTimeNanos = r3
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L6c:
            long r5 = r2.lastFrameTimeNanos
            int r8 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r8 != 0) goto L80
            kotlin.jvm.functions.Function1<java.lang.Long, kotlin.Unit> r5 = r2.firstFrameLambda
            r0.L$0 = r2
            r0.label = r7
            java.lang.Object r5 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(r5, r0)
            if (r5 != r1) goto L7f
            return r1
        L7f:
        L80:
            androidx.collection.MutableObjectList<androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState> r5 = r2.initialValueAnimations
            boolean r5 = r5.isNotEmpty()
            if (r5 != 0) goto L92
            androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState r5 = r2.currentAnimation
            if (r5 == 0) goto L8d
            goto L92
        L8d:
            r2.lastFrameTimeNanos = r3
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L92:
            r0.L$0 = r2
            r5 = 2
            r0.label = r5
            java.lang.Object r5 = r2.animateOneFrame(r0)
            if (r5 != r1) goto L9e
            return r1
        L9e:
            goto L80
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState.runAnimations(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doOneFrame(Continuation<? super Unit> continuation) {
        if (this.lastFrameTimeNanos == Long.MIN_VALUE) {
            Object objWithFrameNanos = MonotonicFrameClockKt.withFrameNanos(this.firstFrameLambda, continuation);
            return objWithFrameNanos == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithFrameNanos : Unit.INSTANCE;
        }
        Object objAnimateOneFrame = animateOneFrame(continuation);
        return objAnimateOneFrame == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateOneFrame : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateOneFrame(Continuation<? super Unit> continuation) {
        float durationScale = SuspendAnimationKt.getDurationScale(continuation.getContext());
        if (durationScale <= 0.0f) {
            endAllAnimations();
            return Unit.INSTANCE;
        }
        this.durationScale = durationScale;
        Object objWithFrameNanos = MonotonicFrameClockKt.withFrameNanos(this.animateOneFrameLambda, continuation);
        return objWithFrameNanos == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithFrameNanos : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recalculateAnimationValue(SeekingAnimationState animation, long deltaPlayTimeNanos) {
        long playTimeNanos = animation.getProgressNanos() + deltaPlayTimeNanos;
        animation.setProgressNanos(playTimeNanos);
        long durationNanos = animation.getAnimationSpecDuration();
        if (playTimeNanos >= durationNanos) {
            animation.setValue(1.0f);
            return;
        }
        VectorizedAnimationSpec animationSpec = animation.getAnimationSpec();
        if (animationSpec == null) {
            animation.setValue(VectorConvertersKt.lerp(animation.getStart().get$animation_core_release(0), 1.0f, playTimeNanos / durationNanos));
            return;
        }
        AnimationVector1D start = animation.getStart();
        AnimationVector1D animationVector1D = Target1;
        AnimationVector1D initialVelocity = animation.getInitialVelocity();
        if (initialVelocity == null) {
            initialVelocity = ZeroVelocity;
        }
        animation.setValue(RangesKt.coerceIn(((AnimationVector1D) animationSpec.getValueFromNanos(playTimeNanos, start, animationVector1D, initialVelocity)).get$animation_core_release(0), 0.0f, 1.0f));
    }

    public final Object snapTo(S s, Continuation<? super Unit> continuation) {
        Transition transition = this.transition;
        if (transition == null) {
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(getCurrentState(), s) && Intrinsics.areEqual(getTargetState(), s)) {
            return Unit.INSTANCE;
        }
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new C02002(this, s, transition, null), continuation, 1, null);
        return objMutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate$default : Unit.INSTANCE;
    }

    /* compiled from: Transition.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "S"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$snapTo$2", f = "Transition.kt", i = {}, l = {475}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.animation.core.SeekableTransitionState$snapTo$2, reason: invalid class name and case insensitive filesystem */
    static final class C02002 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02002(SeekableTransitionState<S> seekableTransitionState, S s, Transition<S> transition, Continuation<? super C02002> continuation) {
            super(1, continuation);
            this.this$0 = seekableTransitionState;
            this.$targetState = s;
            this.$transition = transition;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C02002(this.this$0, this.$targetState, this.$transition, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C02002) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            C02002 c02002;
            float fraction;
            C02002 c020022;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    c02002 = this;
                    c02002.this$0.endAllAnimations();
                    ((SeekableTransitionState) c02002.this$0).lastFrameTimeNanos = Long.MIN_VALUE;
                    c02002.this$0.setFraction(0.0f);
                    S s = c02002.$targetState;
                    if (Intrinsics.areEqual(s, c02002.this$0.getCurrentState())) {
                        fraction = -4.0f;
                    } else {
                        fraction = Intrinsics.areEqual(s, c02002.this$0.getTargetState()) ? -5.0f : -3.0f;
                    }
                    c02002.$transition.updateTarget$animation_core_release(c02002.$targetState);
                    c02002.$transition.setPlayTimeNanos(0L);
                    c02002.this$0.setTargetState$animation_core_release(c02002.$targetState);
                    c02002.this$0.setFraction(0.0f);
                    c02002.this$0.setCurrentState$animation_core_release(c02002.$targetState);
                    c02002.$transition.resetAnimationFraction$animation_core_release(fraction);
                    if (fraction == -3.0f) {
                        c02002.label = 1;
                        if (c02002.this$0.waitForCompositionAfterTargetStateChange(c02002) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c020022 = c02002;
                        c02002 = c020022;
                    }
                    c02002.$transition.onTransitionEnd$animation_core_release();
                    return Unit.INSTANCE;
                case 1:
                    c020022 = this;
                    ResultKt.throwOnFailure($result);
                    c02002 = c020022;
                    c02002.$transition.onTransitionEnd$animation_core_release();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object seekTo$default(SeekableTransitionState seekableTransitionState, float f, Object obj, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = seekableTransitionState.getTargetState();
        }
        return seekableTransitionState.seekTo(f, obj, continuation);
    }

    public final Object seekTo(float fraction, S s, Continuation<? super Unit> continuation) {
        boolean value$iv = false;
        if (0.0f <= fraction && fraction <= 1.0f) {
            value$iv = true;
        }
        if (!value$iv) {
            PreconditionsKt.throwIllegalArgumentException("Expecting fraction between 0 and 1. Got " + fraction);
        }
        Transition transition = this.transition;
        if (transition == null) {
            return Unit.INSTANCE;
        }
        Object oldTargetState = getTargetState();
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new AnonymousClass3(s, oldTargetState, this, transition, fraction, null), continuation, 1, null);
        return objMutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate$default : Unit.INSTANCE;
    }

    /* compiled from: Transition.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "S"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3", f = "Transition.kt", i = {}, l = {507}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ float $fraction;
        final /* synthetic */ S $oldTargetState;
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(S s, S s2, SeekableTransitionState<S> seekableTransitionState, Transition<S> transition, float f, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$targetState = s;
            this.$oldTargetState = s2;
            this.this$0 = seekableTransitionState;
            this.$transition = transition;
            this.$fraction = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass3(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: Transition.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "S", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1", f = "Transition.kt", i = {}, l = {529}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ float $fraction;
            final /* synthetic */ S $oldTargetState;
            final /* synthetic */ S $targetState;
            final /* synthetic */ Transition<S> $transition;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(S s, S s2, SeekableTransitionState<S> seekableTransitionState, Transition<S> transition, float f, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$targetState = s;
                this.$oldTargetState = s2;
                this.this$0 = seekableTransitionState;
                this.$transition = transition;
                this.$fraction = f;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object $result) {
                AnonymousClass1 anonymousClass1;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
                        boolean zAreEqual = Intrinsics.areEqual(this.$targetState, this.$oldTargetState);
                        SeekableTransitionState<S> seekableTransitionState = this.this$0;
                        if (!zAreEqual) {
                            seekableTransitionState.moveAnimationToInitialState();
                        } else {
                            ((SeekableTransitionState) seekableTransitionState).currentAnimation = null;
                            if (Intrinsics.areEqual(this.this$0.getCurrentState(), this.$targetState)) {
                                return Unit.INSTANCE;
                            }
                        }
                        if (!Intrinsics.areEqual(this.$targetState, this.$oldTargetState)) {
                            this.$transition.updateTarget$animation_core_release(this.$targetState);
                            this.$transition.setPlayTimeNanos(0L);
                            this.this$0.setTargetState$animation_core_release(this.$targetState);
                            this.$transition.resetAnimationFraction$animation_core_release(this.$fraction);
                        }
                        this.this$0.setFraction(this.$fraction);
                        if (((SeekableTransitionState) this.this$0).initialValueAnimations.isNotEmpty()) {
                            BuildersKt__Builders_commonKt.launch$default($this$coroutineScope, null, null, new C00011(this.this$0, null), 3, null);
                        } else {
                            ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = Long.MIN_VALUE;
                        }
                        this.label = 1;
                        if (this.this$0.waitForCompositionAfterTargetStateChange(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        anonymousClass1 = this;
                        break;
                    case 1:
                        anonymousClass1 = this;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                anonymousClass1.this$0.seekToFraction();
                return Unit.INSTANCE;
            }

            /* compiled from: Transition.kt */
            @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "S", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1$1", f = "Transition.kt", i = {}, l = {525}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1$1, reason: invalid class name and collision with other inner class name */
            static final class C00011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ SeekableTransitionState<S> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00011(SeekableTransitionState<S> seekableTransitionState, Continuation<? super C00011> continuation) {
                    super(2, continuation);
                    this.this$0 = seekableTransitionState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00011(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.label = 1;
                            if (this.this$0.runAnimations(this) != coroutine_suspended) {
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
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, null), this) != coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object waitForCompositionAfterTargetStateChange(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState.waitForCompositionAfterTargetStateChange(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object waitForComposition(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof androidx.compose.animation.core.SeekableTransitionState.C02011
            if (r0 == 0) goto L14
            r0 = r15
            androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1 r0 = (androidx.compose.animation.core.SeekableTransitionState.C02011) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1 r0 = new androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1
            r0.<init>(r14, r15)
        L19:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            switch(r2) {
                case 0: goto L45;
                case 1: goto L3b;
                case 2: goto L2e;
                default: goto L26;
            }
        L26:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L2e:
            r1 = 0
            java.lang.Object r2 = r0.L$1
            java.lang.Object r3 = r0.L$0
            androidx.compose.animation.core.SeekableTransitionState r3 = (androidx.compose.animation.core.SeekableTransitionState) r3
            kotlin.ResultKt.throwOnFailure(r15)
            r5 = r3
            r3 = r15
            goto L9b
        L3b:
            java.lang.Object r2 = r0.L$1
            java.lang.Object r5 = r0.L$0
            androidx.compose.animation.core.SeekableTransitionState r5 = (androidx.compose.animation.core.SeekableTransitionState) r5
            kotlin.ResultKt.throwOnFailure(r15)
            goto L5f
        L45:
            kotlin.ResultKt.throwOnFailure(r15)
            r2 = r14
            java.lang.Object r5 = r2.getTargetState()
            kotlinx.coroutines.sync.Mutex r6 = r2.compositionContinuationMutex
            r0.L$0 = r2
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.sync.Mutex.DefaultImpls.lock$default(r6, r4, r0, r3, r4)
            if (r6 != r1) goto L5c
            return r1
        L5c:
            r13 = r5
            r5 = r2
            r2 = r13
        L5f:
            r6 = 0
            r0.L$0 = r5
            r0.L$1 = r2
            r7 = 2
            r0.label = r7
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r8 = 0
            kotlinx.coroutines.CancellableContinuationImpl r9 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r7)
            r9.<init>(r10, r3)
            r9.initCancellability()
            r10 = r9
            kotlinx.coroutines.CancellableContinuation r10 = (kotlinx.coroutines.CancellableContinuation) r10
            r11 = 0
            r5.setCompositionContinuation$animation_core_release(r10)
            kotlinx.coroutines.sync.Mutex r12 = r5.getCompositionContinuationMutex()
            kotlinx.coroutines.sync.Mutex.DefaultImpls.unlock$default(r12, r4, r3, r4)
            java.lang.Object r3 = r9.getResult()
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r3 != r4) goto L97
            r4 = r0
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r4)
        L97:
            if (r3 != r1) goto L9a
            return r1
        L9a:
            r1 = r6
        L9b:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r2)
            if (r1 == 0) goto La6
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        La6:
            r6 = -9223372036854775808
            r5.lastFrameTimeNanos = r6
            java.util.concurrent.CancellationException r1 = new java.util.concurrent.CancellationException
            java.lang.String r4 = "targetState while waiting for composition"
            r1.<init>(r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState.waitForComposition(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void moveAnimationToInitialState() {
        /*
            r14 = this;
            androidx.compose.animation.core.Transition<S> r0 = r14.transition
            if (r0 != 0) goto L5
            return
        L5:
            androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState r1 = r14.currentAnimation
            r2 = 0
            if (r1 != 0) goto L64
            long r3 = r14.totalDurationNanos
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L63
            float r1 = r14.getFraction()
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L1f
            r1 = 1
            goto L20
        L1f:
            r1 = 0
        L20:
            if (r1 != 0) goto L63
            java.lang.Object r1 = r14.getCurrentState()
            java.lang.Object r3 = r14.getTargetState()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L31
            goto L63
        L31:
            androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState r1 = new androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState
            r1.<init>()
            r3 = r1
            r5 = 0
            float r6 = r14.getFraction()
            r3.setValue(r6)
            long r6 = r14.totalDurationNanos
            r3.setDurationNanos(r6)
            double r8 = (double) r6
            float r10 = r14.getFraction()
            double r10 = (double) r10
            r12 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r12 = r12 - r10
            double r8 = r8 * r12
            long r8 = kotlin.math.MathKt.roundToLong(r8)
            r3.setAnimationSpecDuration(r8)
            androidx.compose.animation.core.AnimationVector1D r8 = r3.getStart()
            float r9 = r14.getFraction()
            r8.set$animation_core_release(r4, r9)
            goto L64
        L63:
            r1 = r2
        L64:
            if (r1 == 0) goto L76
            long r3 = r14.totalDurationNanos
            r1.setDurationNanos(r3)
            androidx.collection.MutableObjectList<androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState> r3 = r14.initialValueAnimations
            r4 = 0
            r3.add(r1)
            r0.setInitialAnimations$animation_core_release(r1)
        L76:
            r14.currentAnimation = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState.moveAnimationToInitialState():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(SeekableTransitionState seekableTransitionState, Object obj, FiniteAnimationSpec finiteAnimationSpec, Continuation continuation, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = seekableTransitionState.getTargetState();
        }
        if ((i & 2) != 0) {
            finiteAnimationSpec = null;
        }
        return seekableTransitionState.animateTo(obj, finiteAnimationSpec, continuation);
    }

    /* compiled from: Transition.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "S"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2", f = "Transition.kt", i = {}, l = {621}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.animation.core.SeekableTransitionState$animateTo$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Transition<S> transition, SeekableTransitionState<S> seekableTransitionState, S s, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$transition = transition;
            this.this$0 = seekableTransitionState;
            this.$targetState = s;
            this.$animationSpec = finiteAnimationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$transition, this.this$0, this.$targetState, this.$animationSpec, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: Transition.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "S", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1", f = "Transition.kt", i = {0}, l = {2189, 634, 636, 688, 690}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
        /* renamed from: androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
            final /* synthetic */ S $targetState;
            final /* synthetic */ Transition<S> $transition;
            Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SeekableTransitionState<S> seekableTransitionState, S s, Transition<S> transition, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = seekableTransitionState;
                this.$targetState = s;
                this.$transition = transition;
                this.$animationSpec = finiteAnimationSpec;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$targetState, this.$transition, this.$animationSpec, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x00b5  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x00d6 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00e6  */
            /* JADX WARN: Removed duplicated region for block: B:74:0x022a A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:75:0x022b  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r19) {
                /*
                    Method dump skipped, instructions count: 588
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            AnonymousClass2 anonymousClass2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(this.this$0, this.$targetState, this.$transition, this.$animationSpec, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    anonymousClass2 = this;
                    break;
                case 1:
                    anonymousClass2 = this;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            anonymousClass2.$transition.onTransitionEnd$animation_core_release();
            return Unit.INSTANCE;
        }
    }

    public final Object animateTo(S s, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super Unit> continuation) {
        Transition transition = this.transition;
        if (transition == null) {
            return Unit.INSTANCE;
        }
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new AnonymousClass2(transition, this, s, finiteAnimationSpec, null), continuation, 1, null);
        return objMutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMutate$default : Unit.INSTANCE;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionConfigured$animation_core_release(Transition<S> transition) {
        boolean value$iv = this.transition == null || Intrinsics.areEqual(transition, this.transition);
        if (!value$iv) {
            PreconditionsKt.throwIllegalStateException("An instance of SeekableTransitionState has been used in different Transitions. Previous instance: " + this.transition + ", new instance: " + transition);
        }
        this.transition = transition;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionRemoved$animation_core_release() {
        this.transition = null;
        TransitionKt.getSeekableStateObserver().clear(this);
    }

    public final void observeTotalDuration$animation_core_release() {
        TransitionKt.getSeekableStateObserver().observeReads(this, TransitionKt.SeekableTransitionStateTotalDurationChanged, this.recalculateTotalDurationNanos);
    }

    public final void onTotalDurationChanged$animation_core_release() {
        long previousTotalDurationNanos = this.totalDurationNanos;
        observeTotalDuration$animation_core_release();
        if (previousTotalDurationNanos != this.totalDurationNanos) {
            SeekingAnimationState animation = this.currentAnimation;
            if (animation != null) {
                animation.setDurationNanos(this.totalDurationNanos);
                if (animation.getAnimationSpec() == null) {
                    animation.setAnimationSpecDuration(MathKt.roundToLong((1.0d - animation.getStart().get$animation_core_release(0)) * this.totalDurationNanos));
                    return;
                }
                return;
            }
            seekToFraction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void seekToFraction() {
        Transition transition = this.transition;
        if (transition == null) {
            return;
        }
        long playTimeNanos = MathKt.roundToLong(getFraction() * transition.getTotalDurationNanos());
        transition.seekAnimations$animation_core_release(playTimeNanos);
    }

    /* compiled from: Transition.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010)\u001a\u00020*H\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\u001a\u0010 \u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "", "()V", "animationSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "Landroidx/compose/animation/core/AnimationVector1D;", "getAnimationSpec", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;)V", "animationSpecDuration", "", "getAnimationSpecDuration", "()J", "setAnimationSpecDuration", "(J)V", "durationNanos", "getDurationNanos", "setDurationNanos", "initialVelocity", "getInitialVelocity", "()Landroidx/compose/animation/core/AnimationVector1D;", "setInitialVelocity", "(Landroidx/compose/animation/core/AnimationVector1D;)V", "isComplete", "", "()Z", "setComplete", "(Z)V", "progressNanos", "getProgressNanos", "setProgressNanos", "start", "getStart", "setStart", "value", "", "getValue", "()F", "setValue", "(F)V", "toString", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SeekingAnimationState {
        public static final int $stable = 8;
        private VectorizedAnimationSpec<AnimationVector1D> animationSpec;
        private long animationSpecDuration;
        private long durationNanos;
        private AnimationVector1D initialVelocity;
        private boolean isComplete;
        private long progressNanos;
        private AnimationVector1D start = new AnimationVector1D(0.0f);
        private float value;

        public final long getProgressNanos() {
            return this.progressNanos;
        }

        public final void setProgressNanos(long j) {
            this.progressNanos = j;
        }

        public final VectorizedAnimationSpec<AnimationVector1D> getAnimationSpec() {
            return this.animationSpec;
        }

        public final void setAnimationSpec(VectorizedAnimationSpec<AnimationVector1D> vectorizedAnimationSpec) {
            this.animationSpec = vectorizedAnimationSpec;
        }

        /* renamed from: isComplete, reason: from getter */
        public final boolean getIsComplete() {
            return this.isComplete;
        }

        public final void setComplete(boolean z) {
            this.isComplete = z;
        }

        public final float getValue() {
            return this.value;
        }

        public final void setValue(float f) {
            this.value = f;
        }

        public final AnimationVector1D getStart() {
            return this.start;
        }

        public final void setStart(AnimationVector1D animationVector1D) {
            this.start = animationVector1D;
        }

        public final AnimationVector1D getInitialVelocity() {
            return this.initialVelocity;
        }

        public final void setInitialVelocity(AnimationVector1D animationVector1D) {
            this.initialVelocity = animationVector1D;
        }

        public final long getDurationNanos() {
            return this.durationNanos;
        }

        public final void setDurationNanos(long j) {
            this.durationNanos = j;
        }

        public final long getAnimationSpecDuration() {
            return this.animationSpecDuration;
        }

        public final void setAnimationSpecDuration(long j) {
            this.animationSpecDuration = j;
        }

        public String toString() {
            return "progress nanos: " + this.progressNanos + ", animationSpec: " + this.animationSpec + ", isComplete: " + this.isComplete + ", value: " + this.value + ", start: " + this.start + ", initialVelocity: " + this.initialVelocity + ", durationNanos: " + this.durationNanos + ", animationSpecDuration: " + this.animationSpecDuration;
        }
    }

    /* compiled from: Transition.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/compose/animation/core/SeekableTransitionState$Companion;", "", "()V", "Target1", "Landroidx/compose/animation/core/AnimationVector1D;", "getTarget1", "()Landroidx/compose/animation/core/AnimationVector1D;", "ZeroVelocity", "getZeroVelocity", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnimationVector1D getZeroVelocity() {
            return SeekableTransitionState.ZeroVelocity;
        }

        public final AnimationVector1D getTarget1() {
            return SeekableTransitionState.Target1;
        }
    }
}
