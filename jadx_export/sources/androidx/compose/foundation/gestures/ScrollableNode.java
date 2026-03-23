package androidx.compose.foundation.gestures;

import android.view.KeyEvent;
import androidx.autofill.HintConstants;
import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.foundation.FocusedBoundsObserverNode;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollNodeKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.core.app.NotificationCompat;
import java.util.List;
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

/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006BM\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000205H\u0002JM\u00109\u001a\u0002052=\u0010:\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110<¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(=\u0012\u0004\u0012\u0002050;\u0012\n\u0012\b\u0012\u0004\u0012\u0002050(\u0012\u0006\u0012\u0004\u0018\u00010)0 H\u0096@¢\u0006\u0002\u0010>J\b\u0010?\u001a\u000205H\u0016J\u001a\u0010@\u001a\u0002052\u0006\u0010A\u001a\u00020'H\u0016ø\u0001\u0000¢\u0006\u0004\bB\u0010CJ\u001a\u0010D\u001a\u0002052\u0006\u0010E\u001a\u00020FH\u0016ø\u0001\u0000¢\u0006\u0004\bG\u0010CJ\u001a\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020JH\u0016ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\b\u0010M\u001a\u000205H\u0016J*\u0010N\u001a\u0002052\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0016ø\u0001\u0000¢\u0006\u0004\bU\u0010VJ\u001a\u0010W\u001a\u00020\u00102\u0006\u0010I\u001a\u00020JH\u0016ø\u0001\u0000¢\u0006\u0004\bX\u0010LJ\"\u0010Y\u001a\u0002052\u0006\u0010I\u001a\u00020P2\u0006\u0010Z\u001a\u00020TH\u0002ø\u0001\u0000¢\u0006\u0004\b[\u0010\\J\b\u0010]\u001a\u000205H\u0002J\b\u0010^\u001a\u00020\u0010H\u0016JN\u0010_\u001a\u0002052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\b\u0010`\u001a\u000205H\u0002J\f\u0010a\u001a\u000205*\u00020bH\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R@\u0010\u001f\u001a4\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u0010\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010&\u001a \b\u0001\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0(\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b2\u00103\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006c"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "bringIntoViewSpec", "Landroidx/compose/foundation/gestures/BringIntoViewSpec;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/BringIntoViewSpec;)V", "contentInViewNode", "Landroidx/compose/foundation/gestures/ContentInViewNode;", "defaultFlingBehavior", "Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "nestedScrollConnection", "Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollByAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "x", "y", "scrollByOffsetAction", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/jvm/functions/Function2;", "scrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "scrollableContainerNode", "Landroidx/compose/foundation/gestures/ScrollableContainerNode;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "applyFocusProperties", "", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "clearScrollSemanticsActions", "drag", "forEachDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAttach", "onDragStarted", "startedPosition", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", "onKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/key/KeyEvent;", "onKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onObservedReadsChanged", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPreKeyEvent", "onPreKeyEvent-ZmokQxo", "processMouseWheelEvent", "size", "processMouseWheelEvent-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)V", "setScrollSemanticsActions", "startDragImmediately", "update", "updateDefaultFlingBehavior", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class ScrollableNode extends DragGestureNode implements ObserverModifierNode, CompositionLocalConsumerModifierNode, FocusPropertiesModifierNode, KeyInputModifierNode, SemanticsModifierNode {
    private final ContentInViewNode contentInViewNode;
    private final DefaultFlingBehavior defaultFlingBehavior;
    private FlingBehavior flingBehavior;
    private final ScrollableNestedScrollConnection nestedScrollConnection;
    private final NestedScrollDispatcher nestedScrollDispatcher;
    private OverscrollEffect overscrollEffect;
    private Function2<? super Float, ? super Float, Boolean> scrollByAction;
    private Function2<? super Offset, ? super Continuation<? super Offset>, ? extends Object> scrollByOffsetAction;
    private ScrollConfig scrollConfig;
    private final ScrollableContainerNode scrollableContainerNode;
    private final ScrollingLogic scrollingLogic;
    private final boolean shouldAutoInvalidate;

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    /* renamed from: getShouldClearDescendantSemantics */
    public /* synthetic */ boolean getIsClearingSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldClearDescendantSemantics(this);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return SemanticsModifierNode.CC.$default$getShouldMergeDescendantSemantics(this);
    }

    public ScrollableNode(ScrollableState scrollableState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, Orientation orientation, boolean z, boolean z2, MutableInteractionSource mutableInteractionSource, BringIntoViewSpec bringIntoViewSpec) {
        super(ScrollableKt.CanDragCalculation, z, mutableInteractionSource, orientation);
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = new NestedScrollDispatcher();
        this.scrollableContainerNode = (ScrollableContainerNode) delegate(new ScrollableContainerNode(z));
        this.defaultFlingBehavior = new DefaultFlingBehavior(SplineBasedDecayKt.splineBasedDecay(ScrollableKt.UnityDensity), null, 2, 0 == true ? 1 : 0);
        OverscrollEffect overscrollEffect2 = this.overscrollEffect;
        DefaultFlingBehavior defaultFlingBehavior = this.flingBehavior;
        this.scrollingLogic = new ScrollingLogic(scrollableState, overscrollEffect2, defaultFlingBehavior == null ? this.defaultFlingBehavior : defaultFlingBehavior, orientation, z2, this.nestedScrollDispatcher);
        this.nestedScrollConnection = new ScrollableNestedScrollConnection(this.scrollingLogic, z);
        this.contentInViewNode = (ContentInViewNode) delegate(new ContentInViewNode(orientation, this.scrollingLogic, z2, bringIntoViewSpec));
        delegate(NestedScrollNodeKt.nestedScrollModifierNode(this.nestedScrollConnection, this.nestedScrollDispatcher));
        delegate(FocusTargetModifierNodeKt.FocusTargetModifierNode());
        delegate(new BringIntoViewResponderNode(this.contentInViewNode));
        delegate(new FocusedBoundsObserverNode(new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.gestures.ScrollableNode.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates it) {
                ScrollableNode.this.contentInViewNode.onFocusBoundsChanged(it);
            }
        }));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        ScrollingLogic $this$drag_u24lambda_u240 = this.scrollingLogic;
        Object objScroll = $this$drag_u24lambda_u240.scroll(MutatePriority.UserInput, new ScrollableNode$drag$2$1(function2, $this$drag_u24lambda_u240, null), continuation);
        return objScroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll : Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* renamed from: onDragStarted-k-4lQ0M */
    public void mo384onDragStartedk4lQ0M(long startedPosition) {
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* renamed from: onDragStopped-TH1AsA0 */
    public void mo385onDragStoppedTH1AsA0(long velocity) {
        BuildersKt__Builders_commonKt.launch$default(this.nestedScrollDispatcher.getCoroutineScope(), null, null, new ScrollableNode$onDragStopped$1(this, velocity, null), 3, null);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    /* renamed from: startDragImmediately */
    public boolean getStartDragImmediately() {
        return this.scrollingLogic.shouldScrollImmediately();
    }

    public final void update(ScrollableState state, Orientation orientation, OverscrollEffect overscrollEffect, boolean enabled, boolean reverseDirection, FlingBehavior flingBehavior, MutableInteractionSource interactionSource, BringIntoViewSpec bringIntoViewSpec) {
        boolean shouldInvalidateSemantics;
        if (getEnabled() != enabled) {
            this.nestedScrollConnection.setEnabled(enabled);
            this.scrollableContainerNode.update(enabled);
            shouldInvalidateSemantics = true;
        } else {
            shouldInvalidateSemantics = false;
        }
        FlingBehavior resolvedFlingBehavior = flingBehavior == null ? this.defaultFlingBehavior : flingBehavior;
        boolean resetPointerInputHandling = this.scrollingLogic.update(state, orientation, overscrollEffect, reverseDirection, resolvedFlingBehavior, this.nestedScrollDispatcher);
        this.contentInViewNode.update(orientation, reverseDirection, bringIntoViewSpec);
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        update(ScrollableKt.CanDragCalculation, enabled, interactionSource, this.scrollingLogic.isVertical() ? Orientation.Vertical : Orientation.Horizontal, resetPointerInputHandling);
        if (shouldInvalidateSemantics) {
            clearScrollSemanticsActions();
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDefaultFlingBehavior();
        this.scrollConfig = AndroidScrollable_androidKt.platformScrollConfig(this);
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        updateDefaultFlingBehavior();
    }

    private final void updateDefaultFlingBehavior() {
        ObserverModifierNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.ScrollableNode.updateDefaultFlingBehavior.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Density density = (Density) CompositionLocalConsumerModifierNodeKt.currentValueOf(ScrollableNode.this, CompositionLocalsKt.getLocalDensity());
                ScrollableNode.this.defaultFlingBehavior.setFlingDecay(SplineBasedDecayKt.splineBasedDecay(density));
            }
        });
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onKeyEvent-ZmokQxo */
    public boolean mo202onKeyEventZmokQxo(KeyEvent event) {
        float xAmount;
        long scrollAmount;
        float yAmount;
        if (getEnabled() && ((Key.m4949equalsimpl0(KeyEvent_androidKt.m5257getKeyZmokQxo(event), Key.INSTANCE.m5137getPageDownEK5gGoQ()) || Key.m4949equalsimpl0(KeyEvent_androidKt.m5257getKeyZmokQxo(event), Key.INSTANCE.m5138getPageUpEK5gGoQ())) && KeyEventType.m5250equalsimpl0(KeyEvent_androidKt.m5258getTypeZmokQxo(event), KeyEventType.INSTANCE.m5254getKeyDownCS__XNY()) && !KeyEvent_androidKt.m5261isCtrlPressedZmokQxo(event))) {
            boolean zIsVertical = this.scrollingLogic.isVertical();
            ContentInViewNode contentInViewNode = this.contentInViewNode;
            if (zIsVertical) {
                int viewportHeight = IntSize.m6866getHeightimpl(contentInViewNode.getViewportSize());
                if (Key.m4949equalsimpl0(KeyEvent_androidKt.m5257getKeyZmokQxo(event), Key.INSTANCE.m5138getPageUpEK5gGoQ())) {
                    yAmount = viewportHeight;
                } else {
                    yAmount = -viewportHeight;
                }
                scrollAmount = OffsetKt.Offset(0.0f, yAmount);
            } else {
                int viewportWidth = IntSize.m6867getWidthimpl(contentInViewNode.getViewportSize());
                if (Key.m4949equalsimpl0(KeyEvent_androidKt.m5257getKeyZmokQxo(event), Key.INSTANCE.m5138getPageUpEK5gGoQ())) {
                    xAmount = viewportWidth;
                } else {
                    xAmount = -viewportWidth;
                }
                scrollAmount = OffsetKt.Offset(xAmount, 0.0f);
            }
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new ScrollableNode$onKeyEvent$1(this, scrollAmount, null), 3, null);
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onPreKeyEvent-ZmokQxo */
    public boolean mo204onPreKeyEventZmokQxo(KeyEvent event) {
        return false;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode, androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo203onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        boolean z;
        List $this$fastAny$iv = pointerEvent.getChanges();
        int index$iv$iv = 0;
        int size = $this$fastAny$iv.size();
        while (true) {
            if (index$iv$iv < size) {
                Object item$iv$iv = $this$fastAny$iv.get(index$iv$iv);
                PointerInputChange it = (PointerInputChange) item$iv$iv;
                if (getCanDrag().invoke(it).booleanValue()) {
                    z = true;
                    break;
                }
                index$iv$iv++;
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            super.mo203onPointerEventH0pRuoY(pointerEvent, pass, bounds);
        }
        if (pass == PointerEventPass.Main && PointerEventType.m5353equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5362getScroll7fucELk())) {
            m480processMouseWheelEventO0kMr_c(pointerEvent, bounds);
        }
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        if (getEnabled() && (this.scrollByAction == null || this.scrollByOffsetAction == null)) {
            setScrollSemanticsActions();
        }
        Function2 it = this.scrollByAction;
        if (it != null) {
            SemanticsPropertiesKt.scrollBy$default($this$applySemantics, null, it, 1, null);
        }
        Function2 it2 = this.scrollByOffsetAction;
        if (it2 != null) {
            SemanticsPropertiesKt.scrollByOffset($this$applySemantics, it2);
        }
    }

    private final void setScrollSemanticsActions() {
        this.scrollByAction = new Function2<Float, Float, Boolean>() { // from class: androidx.compose.foundation.gestures.ScrollableNode.setScrollSemanticsActions.1
            {
                super(2);
            }

            /* compiled from: Scrollable.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$1$1", f = "Scrollable.kt", i = {}, l = {522}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$1$1, reason: invalid class name and collision with other inner class name */
            static final class C00221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ float $x;
                final /* synthetic */ float $y;
                int label;
                final /* synthetic */ ScrollableNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00221(ScrollableNode scrollableNode, float f, float f2, Continuation<? super C00221> continuation) {
                    super(2, continuation);
                    this.this$0 = scrollableNode;
                    this.$x = f;
                    this.$y = f2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00221(this.this$0, this.$x, this.$y, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00221) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.label = 1;
                            if (ScrollableKt.m475semanticsScrollByd4ec7I(this.this$0.scrollingLogic, OffsetKt.Offset(this.$x, this.$y), this) != coroutine_suspended) {
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

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean invoke(Float f, Float f2) {
                return invoke(f.floatValue(), f2.floatValue());
            }

            public final Boolean invoke(float x, float y) {
                BuildersKt__Builders_commonKt.launch$default(ScrollableNode.this.getCoroutineScope(), null, null, new C00221(ScrollableNode.this, x, y, null), 3, null);
                return true;
            }
        };
        this.scrollByOffsetAction = new AnonymousClass2(null);
    }

    /* compiled from: Scrollable.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "offset"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$2", f = "Scrollable.kt", i = {}, l = {527}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Offset, Continuation<? super Offset>, Object> {
        /* synthetic */ long J$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = ScrollableNode.this.new AnonymousClass2(continuation);
            anonymousClass2.J$0 = ((Offset) obj).getPackedValue();
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Offset offset, Continuation<? super Offset> continuation) {
            return m481invoke3MmeM6k(offset.getPackedValue(), continuation);
        }

        /* renamed from: invoke-3MmeM6k, reason: not valid java name */
        public final Object m481invoke3MmeM6k(long j, Continuation<? super Offset> continuation) {
            return ((AnonymousClass2) create(Offset.m3934boximpl(j), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    long offset = this.J$0;
                    this.label = 1;
                    Object objM475semanticsScrollByd4ec7I = ScrollableKt.m475semanticsScrollByd4ec7I(ScrollableNode.this.scrollingLogic, offset, this);
                    return objM475semanticsScrollByd4ec7I == coroutine_suspended ? coroutine_suspended : objM475semanticsScrollByd4ec7I;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void clearScrollSemanticsActions() {
        this.scrollByAction = null;
        this.scrollByOffsetAction = null;
    }

    /* renamed from: processMouseWheelEvent-O0kMr_c, reason: not valid java name */
    private final void m480processMouseWheelEventO0kMr_c(PointerEvent event, long size) {
        boolean z;
        List $this$fastAll$iv = event.getChanges();
        int index$iv$iv = 0;
        int size2 = $this$fastAll$iv.size();
        while (true) {
            if (index$iv$iv < size2) {
                Object item$iv$iv = $this$fastAll$iv.get(index$iv$iv);
                PointerInputChange it = (PointerInputChange) item$iv$iv;
                if (it.isConsumed()) {
                    z = false;
                    break;
                }
                index$iv$iv++;
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            ScrollConfig $this$processMouseWheelEvent_O0kMr_c_u24lambda_u246 = this.scrollConfig;
            Intrinsics.checkNotNull($this$processMouseWheelEvent_O0kMr_c_u24lambda_u246);
            long scrollAmount = $this$processMouseWheelEvent_O0kMr_c_u24lambda_u246.mo388calculateMouseWheelScroll8xgXZGE(DelegatableNodeKt.requireDensity(this), event, size);
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new ScrollableNode$processMouseWheelEvent$2$1(this, scrollAmount, null), 3, null);
            List $this$fastForEach$iv = event.getChanges();
            int size3 = $this$fastForEach$iv.size();
            for (int index$iv = 0; index$iv < size3; index$iv++) {
                Object item$iv = $this$fastForEach$iv.get(index$iv);
                PointerInputChange it2 = (PointerInputChange) item$iv;
                it2.consume();
            }
        }
    }
}
