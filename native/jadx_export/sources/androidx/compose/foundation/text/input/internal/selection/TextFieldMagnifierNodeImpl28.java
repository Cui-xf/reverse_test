package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.MagnifierNode;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.core.view.PointerIconCompat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: AndroidTextFieldMagnifier.android.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001eH\u0002J(\u0010#\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\f\u0010$\u001a\u00020\u001e*\u00020%H\u0016J\f\u0010&\u001a\u00020\u001e*\u00020'H\u0016R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNodeImpl28;", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "visible", "", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Z)V", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/animation/core/AnimationVector2D;", "animationJob", "Lkotlinx/coroutines/Job;", "magnifierNode", "Landroidx/compose/foundation/MagnifierNode;", "<set-?>", "Landroidx/compose/ui/unit/IntSize;", "magnifierSize", "getMagnifierSize-YbymL2g", "()J", "setMagnifierSize-ozmzZPI", "(J)V", "magnifierSize$delegate", "Landroidx/compose/runtime/MutableState;", "onAttach", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "restartAnimationJob", "update", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldMagnifierNodeImpl28 extends TextFieldMagnifierNode implements CompositionLocalConsumerModifierNode {
    public static final int $stable = 0;
    private final Animatable<Offset, AnimationVector2D> animatable;
    private Job animationJob;
    private TextFieldSelectionState textFieldSelectionState;
    private TransformedTextFieldState textFieldState;
    private TextLayoutState textLayoutState;
    private boolean visible;

    /* renamed from: magnifierSize$delegate, reason: from kotlin metadata */
    private final MutableState magnifierSize = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntSize.m6859boximpl(IntSize.INSTANCE.m6872getZeroYbymL2g()), null, 2, null);
    private final MagnifierNode magnifierNode = (MagnifierNode) delegate(new MagnifierNode(new Function1<Density, Offset>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$magnifierNode$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Offset invoke(Density density) {
            return Offset.m3934boximpl(m1252invoketuRUvjQ(density));
        }

        /* renamed from: invoke-tuRUvjQ, reason: not valid java name */
        public final long m1252invoketuRUvjQ(Density $this$$receiver) {
            return ((Offset) this.this$0.animatable.getValue()).getPackedValue();
        }
    }, null, new Function1<DpSize, Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$magnifierNode$2
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DpSize dpSize) {
            m1253invokeEaSLcWc(dpSize.getPackedValue());
            return Unit.INSTANCE;
        }

        /* renamed from: invoke-EaSLcWc, reason: not valid java name */
        public final void m1253invokeEaSLcWc(long size) {
            TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl28 = this.this$0;
            Density $this$invoke_EaSLcWc_u24lambda_u240 = (Density) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, CompositionLocalsKt.getLocalDensity());
            textFieldMagnifierNodeImpl28.m1251setMagnifierSizeozmzZPI(IntSizeKt.IntSize($this$invoke_EaSLcWc_u24lambda_u240.mo361roundToPx0680j_4(DpSize.m6791getWidthD9Ej5fM(size)), $this$invoke_EaSLcWc_u24lambda_u240.mo361roundToPx0680j_4(DpSize.m6789getHeightD9Ej5fM(size))));
        }
    }, 0.0f, true, 0, 0.0f, 0.0f, false, null, PointerIconCompat.TYPE_HAND, null));

    public TextFieldMagnifierNodeImpl28(TransformedTextFieldState textFieldState, TextFieldSelectionState textFieldSelectionState, TextLayoutState textLayoutState, boolean visible) {
        this.textFieldState = textFieldState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.textLayoutState = textLayoutState;
        this.visible = visible;
        this.animatable = new Animatable<>(Offset.m3934boximpl(TextFieldMagnifierKt.m1247calculateSelectionMagnifierCenterAndroidhUlJWOE(this.textFieldState, this.textFieldSelectionState, this.textLayoutState, m1250getMagnifierSizeYbymL2g())), SelectionMagnifierKt.getUnspecifiedSafeOffsetVectorConverter(), Offset.m3934boximpl(SelectionMagnifierKt.getOffsetDisplacementThreshold()), null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getMagnifierSize-YbymL2g, reason: not valid java name */
    public final long m1250getMagnifierSizeYbymL2g() {
        State $this$getValue$iv = this.magnifierSize;
        return ((IntSize) $this$getValue$iv.getValue()).getPackedValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setMagnifierSize-ozmzZPI, reason: not valid java name */
    public final void m1251setMagnifierSizeozmzZPI(long j) {
        MutableState $this$setValue$iv = this.magnifierSize;
        $this$setValue$iv.setValue(IntSize.m6859boximpl(j));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        restartAnimationJob();
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode
    public void update(TransformedTextFieldState textFieldState, TextFieldSelectionState textFieldSelectionState, TextLayoutState textLayoutState, boolean visible) {
        TransformedTextFieldState previousTextFieldState = this.textFieldState;
        TextFieldSelectionState previousSelectionState = this.textFieldSelectionState;
        TextLayoutState previousLayoutState = this.textLayoutState;
        boolean wasVisible = this.visible;
        this.textFieldState = textFieldState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.textLayoutState = textLayoutState;
        this.visible = visible;
        if (!Intrinsics.areEqual(textFieldState, previousTextFieldState) || !Intrinsics.areEqual(textFieldSelectionState, previousSelectionState) || !Intrinsics.areEqual(textLayoutState, previousLayoutState) || visible != wasVisible) {
            restartAnimationJob();
        }
    }

    private final void restartAnimationJob() {
        Job job = this.animationJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.animationJob = null;
        if (Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, null)) {
            this.animationJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new AnonymousClass1(null), 3, null);
        }
    }

    /* compiled from: AndroidTextFieldMagnifier.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1", f = "AndroidTextFieldMagnifier.android.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = TextFieldMagnifierNodeImpl28.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    final CoroutineScope animationScope = (CoroutineScope) this.L$0;
                    final TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl28 = TextFieldMagnifierNodeImpl28.this;
                    Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Offset>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28.restartAnimationJob.1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Offset invoke() {
                            return Offset.m3934boximpl(m1254invokeF1C5BW0());
                        }

                        /* renamed from: invoke-F1C5BW0, reason: not valid java name */
                        public final long m1254invokeF1C5BW0() {
                            if (!textFieldMagnifierNodeImpl28.visible && textFieldMagnifierNodeImpl28.textFieldSelectionState.getDirectDragGestureInitiator() != TextFieldSelectionState.InputType.Touch) {
                                return Offset.INSTANCE.m3960getUnspecifiedF1C5BW0();
                            }
                            return TextFieldMagnifierKt.m1247calculateSelectionMagnifierCenterAndroidhUlJWOE(textFieldMagnifierNodeImpl28.textFieldState, textFieldMagnifierNodeImpl28.textFieldSelectionState, textFieldMagnifierNodeImpl28.textLayoutState, textFieldMagnifierNodeImpl28.m1250getMagnifierSizeYbymL2g());
                        }
                    });
                    final TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl282 = TextFieldMagnifierNodeImpl28.this;
                    this.label = 1;
                    if (flowSnapshotFlow.collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28.restartAnimationJob.1.2
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return m1255emit3MmeM6k(((Offset) value).getPackedValue(), $completion);
                        }

                        /* renamed from: emit-3MmeM6k, reason: not valid java name */
                        public final Object m1255emit3MmeM6k(long targetValue, Continuation<? super Unit> continuation) {
                            if (OffsetKt.m3964isSpecifiedk4lQ0M(((Offset) textFieldMagnifierNodeImpl282.animatable.getValue()).getPackedValue()) && OffsetKt.m3964isSpecifiedk4lQ0M(targetValue)) {
                                if (!(Offset.m3946getYimpl(((Offset) textFieldMagnifierNodeImpl282.animatable.getValue()).getPackedValue()) == Offset.m3946getYimpl(targetValue))) {
                                    BuildersKt__Builders_commonKt.launch$default(animationScope, null, null, new C00551(textFieldMagnifierNodeImpl282, targetValue, null), 3, null);
                                    return Unit.INSTANCE;
                                }
                            }
                            Object objSnapTo = textFieldMagnifierNodeImpl282.animatable.snapTo(Offset.m3934boximpl(targetValue), continuation);
                            return objSnapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSnapTo : Unit.INSTANCE;
                        }

                        /* compiled from: AndroidTextFieldMagnifier.android.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1$2$1", f = "AndroidTextFieldMagnifier.android.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28$restartAnimationJob$1$2$1, reason: invalid class name and collision with other inner class name */
                        static final class C00551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ long $targetValue;
                            int label;
                            final /* synthetic */ TextFieldMagnifierNodeImpl28 this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C00551(TextFieldMagnifierNodeImpl28 textFieldMagnifierNodeImpl28, long j, Continuation<? super C00551> continuation) {
                                super(2, continuation);
                                this.this$0 = textFieldMagnifierNodeImpl28;
                                this.$targetValue = j;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C00551(this.this$0, this.$targetValue, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((C00551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object $result) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        Animatable animatable = this.this$0.animatable;
                                        Offset offsetM3934boximpl = Offset.m3934boximpl(this.$targetValue);
                                        SpringSpec<Offset> magnifierSpringSpec = SelectionMagnifierKt.getMagnifierSpringSpec();
                                        this.label = 1;
                                        if (animatable.animateTo(offsetM3934boximpl, (4 & 2) != 0 ? animatable.defaultSpringSpec : magnifierSpringSpec, (4 & 4) != 0 ? animatable.getVelocity() : null, (4 & 8) != 0 ? null : null, this) != coroutine_suspended) {
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
                    }, this) != coroutine_suspended) {
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

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode, androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope $this$draw) {
        $this$draw.drawContent();
        MagnifierNode $this$draw_u24lambda_u240 = this.magnifierNode;
        $this$draw_u24lambda_u240.draw($this$draw);
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode, androidx.compose.ui.layout.OnGloballyPositionedModifier
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        this.magnifierNode.onGloballyPositioned(coordinates);
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode, androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        MagnifierNode $this$applySemantics_u24lambda_u241 = this.magnifierNode;
        $this$applySemantics_u24lambda_u241.applySemantics($this$applySemantics);
    }
}
