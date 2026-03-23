package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.VelocityKt;
import androidx.core.app.NotificationCompat;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

/* compiled from: Draggable.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B5\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u001e\u001a\u00020\u001fJM\u0010 \u001a\u00020\u001f2=\u0010!\u001a9\b\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001f0\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0'\u0012\u0006\u0012\u0004\u0018\u00010(0\"H¦@¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u001fH\u0016J\b\u0010,\u001a\u00020\u001fH\u0016J\u001a\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H&ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001a\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u000204H&ø\u0001\u0000¢\u0006\u0004\b5\u00101J*\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u000e\u0010?\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010@J\u0016\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020CH\u0082@¢\u0006\u0002\u0010DJ\u0016\u0010E\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020FH\u0082@¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020\u0007H&J\b\u0010I\u001a\u00020\u001fH\u0002JH\u0010J\u001a\u00020\u001f2\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010K\u001a\u00020\u0007R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006L"}, d2 = {"Landroidx/compose/foundation/gestures/DragGestureNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "orientationLock", "Landroidx/compose/foundation/gestures/Orientation;", "(Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/Orientation;)V", "_canDrag", "<set-?>", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/DragEvent;", "dragInteraction", "Landroidx/compose/foundation/interaction/DragInteraction$Start;", "getEnabled", "()Z", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isListeningForEvents", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "disposeInteractionSource", "", "drag", "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializePointerInputNode", "onCancelPointerInput", "onDetach", "onDragStarted", "startedPosition", "Landroidx/compose/ui/geometry/Offset;", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "processDragCancel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStart", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/foundation/gestures/DragEvent$DragStarted;", "(Landroidx/compose/foundation/gestures/DragEvent$DragStarted;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processDragStop", "Landroidx/compose/foundation/gestures/DragEvent$DragStopped;", "(Landroidx/compose/foundation/gestures/DragEvent$DragStopped;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startDragImmediately", "startListeningForEvents", "update", "shouldResetPointerInputHandling", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DragGestureNode extends DelegatingNode implements PointerInputModifierNode, CompositionLocalConsumerModifierNode {
    public static final int $stable = 8;
    private final Function1<PointerInputChange, Boolean> _canDrag = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$_canDrag$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(PointerInputChange it) {
            return this.this$0.getCanDrag().invoke(it);
        }
    };
    private Function1<? super PointerInputChange, Boolean> canDrag;
    private Channel<DragEvent> channel;
    private DragInteraction.Start dragInteraction;
    private boolean enabled;
    private MutableInteractionSource interactionSource;
    private boolean isListeningForEvents;
    private Orientation orientationLock;
    private SuspendingPointerInputModifierNode pointerInputNode;

    /* compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", i = {0}, l = {563}, m = "processDragCancel", n = {"this"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1, reason: invalid class name and case insensitive filesystem */
    static final class C02451 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C02451(Continuation<? super C02451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragCancel(this);
        }
    }

    /* compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", i = {0, 0, 1, 1, 1}, l = {545, 548}, m = "processDragStart", n = {"this", NotificationCompat.CATEGORY_EVENT, "this", NotificationCompat.CATEGORY_EVENT, "interaction"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1, reason: invalid class name and case insensitive filesystem */
    static final class C02461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C02461(Continuation<? super C02461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragStart(null, this);
        }
    }

    /* compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode", f = "Draggable.kt", i = {0, 0}, l = {555}, m = "processDragStop", n = {"this", NotificationCompat.CATEGORY_EVENT}, s = {"L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1, reason: invalid class name and case insensitive filesystem */
    static final class C02471 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C02471(Continuation<? super C02471> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DragGestureNode.this.processDragStop(null, this);
        }
    }

    public abstract Object drag(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return PointerInputModifierNode.CC.$default$interceptOutOfBoundsChildEvents(this);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ void onDensityChange() {
        onCancelPointerInput();
    }

    /* renamed from: onDragStarted-k-4lQ0M */
    public abstract void mo384onDragStartedk4lQ0M(long startedPosition);

    /* renamed from: onDragStopped-TH1AsA0 */
    public abstract void mo385onDragStoppedTH1AsA0(long velocity);

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ void onViewConfigurationChange() {
        onCancelPointerInput();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public /* synthetic */ boolean sharePointerInputWithSiblings() {
        return PointerInputModifierNode.CC.$default$sharePointerInputWithSiblings(this);
    }

    /* renamed from: startDragImmediately */
    public abstract boolean getStartDragImmediately();

    public DragGestureNode(Function1<? super PointerInputChange, Boolean> function1, boolean enabled, MutableInteractionSource interactionSource, Orientation orientationLock) {
        this.orientationLock = orientationLock;
        this.canDrag = function1;
        this.enabled = enabled;
        this.interactionSource = interactionSource;
    }

    protected final Function1<PointerInputChange, Boolean> getCanDrag() {
        return this.canDrag;
    }

    protected final boolean getEnabled() {
        return this.enabled;
    }

    protected final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startListeningForEvents() {
        this.isListeningForEvents = true;
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new C02481(null), 3, null);
    }

    /* compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1", f = "Draggable.kt", i = {0, 0, 1, 1, 2, 2, 3, 4, 5}, l = {432, 434, 436, 443, 445, 448}, m = "invokeSuspend", n = {"$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", NotificationCompat.CATEGORY_EVENT, "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$0"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1, reason: invalid class name and case insensitive filesystem */
    static final class C02481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        C02481(Continuation<? super C02481> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C02481 c02481 = DragGestureNode.this.new C02481(continuation);
            c02481.L$0 = obj;
            return c02481;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C02481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00f0 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00f1  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00f8 A[Catch: CancellationException -> 0x0132, TryCatch #0 {CancellationException -> 0x0132, blocks: (B:44:0x00f2, B:46:0x00f8, B:50:0x0117, B:52:0x011d), top: B:66:0x00f2 }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0117 A[Catch: CancellationException -> 0x0132, TryCatch #0 {CancellationException -> 0x0132, blocks: (B:44:0x00f2, B:46:0x00f8, B:50:0x0117, B:52:0x011d), top: B:66:0x00f2 }] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0146 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0147  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x014a  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0150  */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v12, types: [androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1] */
        /* JADX WARN: Type inference failed for: r1v16, types: [androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1] */
        /* JADX WARN: Type inference failed for: r1v17, types: [androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1] */
        /* JADX WARN: Type inference failed for: r1v18, types: [androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1] */
        /* JADX WARN: Type inference failed for: r1v19, types: [androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1] */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v3, types: [androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1] */
        /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x011b -> B:23:0x0077). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x012d -> B:23:0x0077). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0147 -> B:23:0x0077). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x014a -> B:23:0x0077). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instructions count: 358
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.C02481.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* compiled from: Draggable.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "processDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "dragDelta"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1", f = "Draggable.kt", i = {0}, l = {439}, m = "invokeSuspend", n = {"processDelta"}, s = {"L$0"})
        /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00211 extends SuspendLambda implements Function2<Function1<? super DragEvent.DragDelta, ? extends Unit>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<DragEvent> $event;
            /* synthetic */ Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ DragGestureNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00211(Ref.ObjectRef<DragEvent> objectRef, DragGestureNode dragGestureNode, Continuation<? super C00211> continuation) {
                super(2, continuation);
                this.$event = objectRef;
                this.this$0 = dragGestureNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00211 c00211 = new C00211(this.$event, this.this$0, continuation);
                c00211.L$0 = obj;
                return c00211;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Function1<? super DragEvent.DragDelta, ? extends Unit> function1, Continuation<? super Unit> continuation) {
                return invoke2((Function1<? super DragEvent.DragDelta, Unit>) function1, continuation);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Function1<? super DragEvent.DragDelta, Unit> function1, Continuation<? super Unit> continuation) {
                return ((C00211) create(function1, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0056 -> B:25:0x0078). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0069 -> B:24:0x0070). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                /*
                    r8 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r8.label
                    switch(r1) {
                        case 0: goto L23;
                        case 1: goto L11;
                        default: goto L9;
                    }
                L9:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r0)
                    throw r9
                L11:
                    r1 = r8
                    java.lang.Object r2 = r1.L$1
                    kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                    java.lang.Object r3 = r1.L$0
                    kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
                    kotlin.ResultKt.throwOnFailure(r9)
                    r4 = r3
                    r3 = r2
                    r2 = r1
                    r1 = r0
                    r0 = r9
                    goto L70
                L23:
                    kotlin.ResultKt.throwOnFailure(r9)
                    r1 = r8
                    java.lang.Object r2 = r1.L$0
                    kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
                    r3 = r2
                L2c:
                    kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r2 = r1.$event
                    T r2 = r2.element
                    boolean r2 = r2 instanceof androidx.compose.foundation.gestures.DragEvent.DragStopped
                    if (r2 != 0) goto L7b
                    kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r2 = r1.$event
                    T r2 = r2.element
                    boolean r2 = r2 instanceof androidx.compose.foundation.gestures.DragEvent.DragCancelled
                    if (r2 != 0) goto L7b
                    kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r2 = r1.$event
                    T r2 = r2.element
                    boolean r4 = r2 instanceof androidx.compose.foundation.gestures.DragEvent.DragDelta
                    r5 = 0
                    if (r4 == 0) goto L48
                    androidx.compose.foundation.gestures.DragEvent$DragDelta r2 = (androidx.compose.foundation.gestures.DragEvent.DragDelta) r2
                    goto L49
                L48:
                    r2 = r5
                L49:
                    if (r2 == 0) goto L4e
                    r3.invoke(r2)
                L4e:
                    kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r2 = r1.$event
                    androidx.compose.foundation.gestures.DragGestureNode r4 = r1.this$0
                    kotlinx.coroutines.channels.Channel r4 = androidx.compose.foundation.gestures.DragGestureNode.access$getChannel$p(r4)
                    if (r4 == 0) goto L78
                    r5 = r1
                    kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                    r1.L$0 = r3
                    r1.L$1 = r2
                    r6 = 1
                    r1.label = r6
                    java.lang.Object r4 = r4.receive(r5)
                    if (r4 != r0) goto L69
                    return r0
                L69:
                    r7 = r0
                    r0 = r9
                    r9 = r4
                    r4 = r3
                    r3 = r2
                    r2 = r1
                    r1 = r7
                L70:
                    r5 = r9
                    androidx.compose.foundation.gestures.DragEvent r5 = (androidx.compose.foundation.gestures.DragEvent) r5
                    r9 = r0
                    r0 = r1
                    r1 = r2
                    r2 = r3
                    r3 = r4
                L78:
                    r2.element = r5
                    goto L2c
                L7b:
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.C02481.C00211.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.isListeningForEvents = false;
        disposeInteractionSource();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo203onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        if (this.enabled && this.pointerInputNode == null) {
            this.pointerInputNode = (SuspendingPointerInputModifierNode) delegate(initializePointerInputNode());
        }
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.mo203onPointerEventH0pRuoY(pointerEvent, pass, bounds);
        }
    }

    /* compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1", f = "Draggable.kt", i = {}, l = {521}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = DragGestureNode.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PointerInputScope $this$SuspendingPointerInputModifierNode = (PointerInputScope) this.L$0;
                    final VelocityTracker velocityTracker = new VelocityTracker();
                    final DragGestureNode dragGestureNode = DragGestureNode.this;
                    Function2 onDragStart = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragStart$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                            m427invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                        public final void m427invokeUv8p0NA(PointerInputChange startEvent, long initialDelta) {
                            if (dragGestureNode.getCanDrag().invoke(startEvent).booleanValue()) {
                                if (!dragGestureNode.isListeningForEvents) {
                                    if (dragGestureNode.channel == null) {
                                        dragGestureNode.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                                    }
                                    dragGestureNode.startListeningForEvents();
                                }
                                float xSign = Math.signum(Offset.m3945getXimpl(startEvent.getPosition()));
                                float ySign = Math.signum(Offset.m3946getYimpl(startEvent.getPosition()));
                                long adjustedStart = Offset.m3949minusMKHz9U(startEvent.getPosition(), OffsetKt.Offset(Offset.m3945getXimpl(initialDelta) * xSign, Offset.m3946getYimpl(initialDelta) * ySign));
                                Channel channel = dragGestureNode.channel;
                                if (channel != null) {
                                    ChannelResult.m8499boximpl(channel.mo8489trySendJP2dKIU(new DragEvent.DragStarted(adjustedStart, null)));
                                }
                            }
                        }
                    };
                    final DragGestureNode dragGestureNode2 = DragGestureNode.this;
                    Function1 onDragEnd = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragEnd$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange) {
                            invoke2(pointerInputChange);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(PointerInputChange upEvent) {
                            VelocityTrackerKt.addPointerInputChange(velocityTracker, upEvent);
                            float maximumVelocity = ((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(dragGestureNode2, CompositionLocalsKt.getLocalViewConfiguration())).getMaximumFlingVelocity();
                            long velocity = velocityTracker.m5505calculateVelocityAH228Gc(VelocityKt.Velocity(maximumVelocity, maximumVelocity));
                            velocityTracker.resetTracking();
                            Channel channel = dragGestureNode2.channel;
                            if (channel != null) {
                                ChannelResult.m8499boximpl(channel.mo8489trySendJP2dKIU(new DragEvent.DragStopped(DraggableKt.m442toValidVelocityTH1AsA0(velocity), null)));
                            }
                        }
                    };
                    final DragGestureNode dragGestureNode3 = DragGestureNode.this;
                    Function0 onDragCancel = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDragCancel$1
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
                            Channel channel = dragGestureNode3.channel;
                            if (channel != null) {
                                ChannelResult.m8499boximpl(channel.mo8489trySendJP2dKIU(DragEvent.DragCancelled.INSTANCE));
                            }
                        }
                    };
                    final DragGestureNode dragGestureNode4 = DragGestureNode.this;
                    Function0 shouldAwaitTouchSlop = new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$shouldAwaitTouchSlop$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return Boolean.valueOf(!dragGestureNode4.getStartDragImmediately());
                        }
                    };
                    final DragGestureNode dragGestureNode5 = DragGestureNode.this;
                    Function2 onDrag = new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$onDrag$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange, Offset offset) {
                            m426invokeUv8p0NA(pointerInputChange, offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                        public final void m426invokeUv8p0NA(PointerInputChange change, long delta) {
                            VelocityTrackerKt.addPointerInputChange(velocityTracker, change);
                            Channel channel = dragGestureNode5.channel;
                            if (channel != null) {
                                ChannelResult.m8499boximpl(channel.mo8489trySendJP2dKIU(new DragEvent.DragDelta(delta, null)));
                            }
                        }
                    };
                    this.label = 1;
                    if (CoroutineScopeKt.coroutineScope(new C00201(DragGestureNode.this, $this$SuspendingPointerInputModifierNode, onDragStart, onDragEnd, onDragCancel, shouldAwaitTouchSlop, onDrag, null), this) != coroutine_suspended) {
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

        /* compiled from: Draggable.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1", f = "Draggable.kt", i = {0}, l = {523}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"})
        /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputScope $$this$SuspendingPointerInputModifierNode;
            final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
            final /* synthetic */ Function0<Unit> $onDragCancel;
            final /* synthetic */ Function1<PointerInputChange, Unit> $onDragEnd;
            final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDragStart;
            final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DragGestureNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C00201(DragGestureNode dragGestureNode, PointerInputScope pointerInputScope, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function1<? super PointerInputChange, Unit> function1, Function0<Unit> function0, Function0<Boolean> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function22, Continuation<? super C00201> continuation) {
                super(2, continuation);
                this.this$0 = dragGestureNode;
                this.$$this$SuspendingPointerInputModifierNode = pointerInputScope;
                this.$onDragStart = function2;
                this.$onDragEnd = function1;
                this.$onDragCancel = function0;
                this.$shouldAwaitTouchSlop = function02;
                this.$onDrag = function22;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00201 c00201 = new C00201(this.this$0, this.$$this$SuspendingPointerInputModifierNode, this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$shouldAwaitTouchSlop, this.$onDrag, continuation);
                c00201.L$0 = obj;
                return c00201;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3 */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r1v6 */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineScope coroutineScope;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                C00201 c00201 = this.label;
                try {
                    switch (c00201) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            C00201 c002012 = this;
                            coroutineScope = (CoroutineScope) c002012.L$0;
                            Orientation orientation = c002012.this$0.orientationLock;
                            c002012.L$0 = coroutineScope;
                            c002012.label = 1;
                            Object objDetectDragGestures = DragGestureDetectorKt.detectDragGestures(c002012.$$this$SuspendingPointerInputModifierNode, c002012.$onDragStart, c002012.$onDragEnd, c002012.$onDragCancel, c002012.$shouldAwaitTouchSlop, orientation, c002012.$onDrag, c002012);
                            c00201 = c002012;
                            if (objDetectDragGestures == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            C00201 c002013 = this;
                            coroutineScope = (CoroutineScope) c002013.L$0;
                            ResultKt.throwOnFailure(obj);
                            c00201 = c002013;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (CancellationException e) {
                    Channel channel = c00201.this$0.channel;
                    if (channel != null) {
                        ChannelResult.m8499boximpl(channel.mo8489trySendJP2dKIU(DragEvent.DragCancelled.INSTANCE));
                    }
                    if (!CoroutineScopeKt.isActive(coroutineScope)) {
                        throw e;
                    }
                }
                return Unit.INSTANCE;
            }
        }
    }

    private final SuspendingPointerInputModifierNode initializePointerInputNode() {
        return SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new AnonymousClass1(null));
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = this.pointerInputNode;
        if (suspendingPointerInputModifierNode != null) {
            suspendingPointerInputModifierNode.onCancelPointerInput();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processDragStart(androidx.compose.foundation.gestures.DragEvent.DragStarted r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.DragGestureNode.C02461
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode.C02461) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragStart$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            switch(r2) {
                case 0: goto L49;
                case 1: goto L3c;
                case 2: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L2c:
            java.lang.Object r9 = r0.L$2
            androidx.compose.foundation.interaction.DragInteraction$Start r9 = (androidx.compose.foundation.interaction.DragInteraction.Start) r9
            java.lang.Object r1 = r0.L$1
            androidx.compose.foundation.gestures.DragEvent$DragStarted r1 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r1
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.gestures.DragGestureNode r2 = (androidx.compose.foundation.gestures.DragGestureNode) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L8d
        L3c:
            r9 = 0
            java.lang.Object r2 = r0.L$1
            androidx.compose.foundation.gestures.DragEvent$DragStarted r2 = (androidx.compose.foundation.gestures.DragEvent.DragStarted) r2
            java.lang.Object r3 = r0.L$0
            androidx.compose.foundation.gestures.DragGestureNode r3 = (androidx.compose.foundation.gestures.DragGestureNode) r3
            kotlin.ResultKt.throwOnFailure(r10)
            goto L6d
        L49:
            kotlin.ResultKt.throwOnFailure(r10)
            r3 = r8
            r2 = r9
            androidx.compose.foundation.interaction.DragInteraction$Start r9 = r3.dragInteraction
            if (r9 == 0) goto L6e
            r4 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = r3.interactionSource
            if (r5 == 0) goto L6e
            androidx.compose.foundation.interaction.DragInteraction$Cancel r6 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r6.<init>(r9)
            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
            r0.L$0 = r3
            r0.L$1 = r2
            r7 = 1
            r0.label = r7
            java.lang.Object r9 = r5.emit(r6, r0)
            if (r9 != r1) goto L6c
            return r1
        L6c:
            r9 = r4
        L6d:
        L6e:
            androidx.compose.foundation.interaction.DragInteraction$Start r9 = new androidx.compose.foundation.interaction.DragInteraction$Start
            r9.<init>()
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = r3.interactionSource
            if (r4 == 0) goto L8f
            r5 = r9
            androidx.compose.foundation.interaction.Interaction r5 = (androidx.compose.foundation.interaction.Interaction) r5
            r0.L$0 = r3
            r0.L$1 = r2
            r0.L$2 = r9
            r6 = 2
            r0.label = r6
            java.lang.Object r4 = r4.emit(r5, r0)
            if (r4 != r1) goto L8b
            return r1
        L8b:
            r1 = r2
            r2 = r3
        L8d:
            r3 = r2
            r2 = r1
        L8f:
            r3.dragInteraction = r9
            long r4 = r2.getStartPoint()
            r3.mo384onDragStartedk4lQ0M(r4)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.processDragStart(androidx.compose.foundation.gestures.DragEvent$DragStarted, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processDragStop(androidx.compose.foundation.gestures.DragEvent.DragStopped r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.DragGestureNode.C02471
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode.C02471) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragStop$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            switch(r2) {
                case 0: goto L39;
                case 1: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L2c:
            r9 = 0
            java.lang.Object r1 = r0.L$1
            androidx.compose.foundation.gestures.DragEvent$DragStopped r1 = (androidx.compose.foundation.gestures.DragEvent.DragStopped) r1
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.gestures.DragGestureNode r2 = (androidx.compose.foundation.gestures.DragGestureNode) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L5d
        L39:
            kotlin.ResultKt.throwOnFailure(r10)
            r2 = r8
            androidx.compose.foundation.interaction.DragInteraction$Start r3 = r2.dragInteraction
            if (r3 == 0) goto L65
            r4 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = r2.interactionSource
            if (r5 == 0) goto L60
            androidx.compose.foundation.interaction.DragInteraction$Stop r6 = new androidx.compose.foundation.interaction.DragInteraction$Stop
            r6.<init>(r3)
            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
            r0.L$0 = r2
            r0.L$1 = r9
            r7 = 1
            r0.label = r7
            java.lang.Object r3 = r5.emit(r6, r0)
            if (r3 != r1) goto L5b
            return r1
        L5b:
            r1 = r9
            r9 = r4
        L5d:
            r4 = r9
            r9 = r1
        L60:
            r1 = 0
            r2.dragInteraction = r1
        L65:
            long r3 = r9.getVelocity()
            r2.mo385onDragStoppedTH1AsA0(r3)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.processDragStop(androidx.compose.foundation.gestures.DragEvent$DragStopped, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processDragCancel(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.DragGestureNode.C02451
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1 r0 = (androidx.compose.foundation.gestures.DragGestureNode.C02451) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1 r0 = new androidx.compose.foundation.gestures.DragGestureNode$processDragCancel$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            switch(r2) {
                case 0: goto L35;
                case 1: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L2c:
            r1 = 0
            java.lang.Object r2 = r0.L$0
            androidx.compose.foundation.gestures.DragGestureNode r2 = (androidx.compose.foundation.gestures.DragGestureNode) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L56
        L35:
            kotlin.ResultKt.throwOnFailure(r9)
            r2 = r8
            androidx.compose.foundation.interaction.DragInteraction$Start r3 = r2.dragInteraction
            if (r3 == 0) goto L5d
            r4 = 0
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = r2.interactionSource
            if (r5 == 0) goto L58
            androidx.compose.foundation.interaction.DragInteraction$Cancel r6 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r6.<init>(r3)
            androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
            r0.L$0 = r2
            r7 = 1
            r0.label = r7
            java.lang.Object r3 = r5.emit(r6, r0)
            if (r3 != r1) goto L55
            return r1
        L55:
            r1 = r4
        L56:
            r4 = r1
        L58:
            r1 = 0
            r2.dragInteraction = r1
        L5d:
            androidx.compose.ui.unit.Velocity$Companion r1 = androidx.compose.ui.unit.Velocity.INSTANCE
            long r3 = r1.m6945getZero9UxMQ8M()
            r2.mo385onDragStoppedTH1AsA0(r3)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureNode.processDragCancel(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void disposeInteractionSource() {
        DragInteraction.Start interaction = this.dragInteraction;
        if (interaction != null) {
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                mutableInteractionSource.tryEmit(new DragInteraction.Cancel(interaction));
            }
            this.dragInteraction = null;
        }
    }

    public static /* synthetic */ void update$default(DragGestureNode dragGestureNode, Function1 function1, boolean z, MutableInteractionSource mutableInteractionSource, Orientation orientation, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        }
        if ((i & 1) != 0) {
            function1 = dragGestureNode.canDrag;
        }
        if ((i & 2) != 0) {
            z = dragGestureNode.enabled;
        }
        if ((i & 4) != 0) {
            mutableInteractionSource = dragGestureNode.interactionSource;
        }
        if ((i & 8) != 0) {
            orientation = dragGestureNode.orientationLock;
        }
        dragGestureNode.update(function1, z, mutableInteractionSource, orientation, (i & 16) != 0 ? false : z2);
    }

    public final void update(Function1<? super PointerInputChange, Boolean> canDrag, boolean enabled, MutableInteractionSource interactionSource, Orientation orientationLock, boolean shouldResetPointerInputHandling) {
        SuspendingPointerInputModifierNode suspendingPointerInputModifierNode;
        boolean resetPointerInputHandling = shouldResetPointerInputHandling;
        this.canDrag = canDrag;
        if (this.enabled != enabled) {
            this.enabled = enabled;
            if (!enabled) {
                disposeInteractionSource();
                SuspendingPointerInputModifierNode it = this.pointerInputNode;
                if (it != null) {
                    undelegate(it);
                }
                this.pointerInputNode = null;
            }
            resetPointerInputHandling = true;
        }
        if (!Intrinsics.areEqual(this.interactionSource, interactionSource)) {
            disposeInteractionSource();
            this.interactionSource = interactionSource;
        }
        if (this.orientationLock != orientationLock) {
            this.orientationLock = orientationLock;
            resetPointerInputHandling = true;
        }
        if (!resetPointerInputHandling || (suspendingPointerInputModifierNode = this.pointerInputNode) == null) {
            return;
        }
        suspendingPointerInputModifierNode.resetPointerInputHandler();
    }
}
