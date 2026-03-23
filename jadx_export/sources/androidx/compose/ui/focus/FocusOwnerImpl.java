package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.autofill.HintConstants;
import androidx.collection.MutableLongSet;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: FocusOwnerImpl.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001Bª\u0001\u0012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012:\u0010\u0006\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007\u0012!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004¢\u0006\u0002\u0010\u0014J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u000eH\u0016J2\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u001a\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\b4\u00105J(\u00106\u001a\u00020\u000e2\u0006\u00102\u001a\u0002032\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020<H\u0016J:\u0010=\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010\f2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000e0\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\n\u0010B\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010C\u001a\u00020\u0005H\u0002J\u001a\u0010D\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\b\u0010G\u001a\u00020\u0005H\u0016J$\u0010H\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016ø\u0001\u0000¢\u0006\u0002\bIJ\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020LH\u0016J\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020MH\u0016J\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\"H\u0016J$\u0010N\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u001a\u0010Q\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0002ø\u0001\u0000¢\u0006\u0004\bR\u00105J\u000e\u0010S\u001a\u0004\u0018\u00010T*\u00020UH\u0002J3\u0010V\u001a\u0004\u0018\u0001HW\"\n\b\u0000\u0010W\u0018\u0001*\u00020X*\u00020U2\f\u0010Y\u001a\b\u0012\u0004\u0012\u0002HW0ZH\u0082\bø\u0001\u0000¢\u0006\u0004\b[\u0010\\Jg\u0010]\u001a\u00020\u0005\"\n\b\u0000\u0010W\u0018\u0001*\u00020U*\u00020U2\f\u0010Y\u001a\b\u0012\u0004\u0012\u0002HW0Z2\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u0002HW\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u0002HW\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bø\u0001\u0000¢\u0006\u0004\ba\u0010bR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0006\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006c"}, d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "onRequestApplyChangesListener", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "onRequestFocusForOwner", "Lkotlin/Function2;", "Landroidx/compose/ui/focus/FocusDirection;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "focusDirection", "Landroidx/compose/ui/geometry/Rect;", "previouslyFocusedRect", "", "onMoveFocusInterop", "onClearFocusForOwner", "onFocusRectInterop", "onLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "focusTransactionManager", "Landroidx/compose/ui/focus/FocusTransactionManager;", "getFocusTransactionManager", "()Landroidx/compose/ui/focus/FocusTransactionManager;", "keysCurrentlyDown", "Landroidx/collection/MutableLongSet;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui_release", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui_release", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "rootState", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "clearFocus", "force", "refreshFocusEvents", "clearOwnerFocus", "clearFocus-I7lrPNg", "(ZZZI)Z", "dispatchInterceptedSoftKeyboardEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchKeyEvent", "onFocusedItem", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchRotaryEvent", NotificationCompat.CATEGORY_EVENT, "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "focusSearch", "focusedRect", "onFound", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "getFocusRect", "invalidateOwnerFocusState", "moveFocus", "moveFocus-3ESFkO8", "(I)Z", "releaseFocus", "requestFocusForOwner", "requestFocusForOwner-7o62pno", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "takeFocus", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "validateKeyEvent", "validateKeyEvent-ZmokQxo", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DelegatableNode;", "nearestAncestorIncludingSelf", "T", "", "type", "Landroidx/compose/ui/node/NodeKind;", "nearestAncestorIncludingSelf-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "traverseAncestorsIncludingSelf", "onPreVisit", "onVisit", "onPostVisit", "traverseAncestorsIncludingSelf-QFhIj7k", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusOwnerImpl implements FocusOwner {
    public static final int $stable = 8;
    private final FocusInvalidationManager focusInvalidationManager;
    private MutableLongSet keysCurrentlyDown;
    private final Function0<Unit> onClearFocusForOwner;
    private final Function0<Rect> onFocusRectInterop;
    private final Function0<LayoutDirection> onLayoutDirection;
    private final Function1<FocusDirection, Boolean> onMoveFocusInterop;
    private final Function2<FocusDirection, Rect, Boolean> onRequestFocusForOwner;
    private FocusTargetNode rootFocusNode = new FocusTargetNode();
    private final FocusTransactionManager focusTransactionManager = new FocusTransactionManager();
    private final Modifier modifier = FocusPropertiesKt.focusProperties(Modifier.INSTANCE, new Function1<FocusProperties, Unit>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FocusProperties focusProperties) {
            invoke2(focusProperties);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FocusProperties $this$focusProperties) {
            $this$focusProperties.setCanFocus(false);
        }
    }).then(new ModifierNodeElement<FocusTargetNode>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$2
        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* renamed from: create */
        public FocusTargetNode getNode() {
            return this.this$0.getRootFocusNode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(FocusTargetNode node) {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
            $this$inspectableProperties.setName("RootFocusTarget");
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public int hashCode() {
            return this.this$0.getRootFocusNode().hashCode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public boolean equals(Object other) {
            return other == this;
        }
    });

    /* compiled from: FocusOwnerImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FocusOwnerImpl(Function1<? super Function0<Unit>, Unit> function1, Function2<? super FocusDirection, ? super Rect, Boolean> function2, Function1<? super FocusDirection, Boolean> function12, Function0<Unit> function0, Function0<Rect> function02, Function0<? extends LayoutDirection> function03) {
        this.onRequestFocusForOwner = function2;
        this.onMoveFocusInterop = function12;
        this.onClearFocusForOwner = function0;
        this.onFocusRectInterop = function02;
        this.onLayoutDirection = function03;
        this.focusInvalidationManager = new FocusInvalidationManager(function1, new FocusOwnerImpl$focusInvalidationManager$1(this));
    }

    /* renamed from: getRootFocusNode$ui_release, reason: from getter */
    public final FocusTargetNode getRootFocusNode() {
        return this.rootFocusNode;
    }

    public final void setRootFocusNode$ui_release(FocusTargetNode focusTargetNode) {
        this.rootFocusNode = focusTargetNode;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusTransactionManager getFocusTransactionManager() {
        return this.focusTransactionManager;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: requestFocusForOwner-7o62pno */
    public boolean mo3877requestFocusForOwner7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect) {
        return this.onRequestFocusForOwner.invoke(focusDirection, previouslyFocusedRect).booleanValue();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: takeFocus-aToIllA */
    public boolean mo3878takeFocusaToIllA(final int focusDirection, Rect previouslyFocusedRect) {
        Boolean boolMo3876focusSearchULY8qGw = mo3876focusSearchULY8qGw(focusDirection, previouslyFocusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$takeFocus$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode it) {
                Boolean boolM3896requestFocusMxy_nc0 = FocusTransactionsKt.m3896requestFocusMxy_nc0(it, focusDirection);
                return Boolean.valueOf(boolM3896requestFocusMxy_nc0 != null ? boolM3896requestFocusMxy_nc0.booleanValue() : false);
            }
        });
        if (boolMo3876focusSearchULY8qGw != null) {
            return boolMo3876focusSearchULY8qGw.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void releaseFocus() {
        FocusTransactionManager $this$iv = getFocusTransactionManager();
        if (!$this$iv.ongoingTransaction) {
            try {
                $this$iv.beginTransaction();
                FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
                return;
            } finally {
                $this$iv.commitTransaction();
            }
        }
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public void clearFocus(boolean force) {
        mo3873clearFocusI7lrPNg(force, true, true, FocusDirection.INSTANCE.m3865getExitdhqQ8s());
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: clearFocus-I7lrPNg */
    public boolean mo3873clearFocusI7lrPNg(boolean force, boolean refreshFocusEvents, boolean clearOwnerFocus, int focusDirection) {
        boolean clearedFocusSuccessfully;
        FocusTransactionManager this_$iv = getFocusTransactionManager();
        FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 = new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$clearFocus$clearedFocusSuccessfully$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        };
        try {
            if (this_$iv.ongoingTransaction) {
                this_$iv.cancelTransaction();
            }
            this_$iv.beginTransaction();
            if (focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1 != null) {
                MutableVector this_$iv$iv = this_$iv.cancellationListener;
                this_$iv$iv.add(focusOwnerImpl$clearFocus$clearedFocusSuccessfully$1);
            }
            if (!force) {
                switch (WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m3892performCustomClearFocusMxy_nc0(this.rootFocusNode, focusDirection).ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        clearedFocusSuccessfully = false;
                        break;
                    default:
                        clearedFocusSuccessfully = FocusTransactionsKt.clearFocus(this.rootFocusNode, force, refreshFocusEvents);
                        break;
                }
            } else {
                clearedFocusSuccessfully = FocusTransactionsKt.clearFocus(this.rootFocusNode, force, refreshFocusEvents);
            }
            if (clearedFocusSuccessfully && clearOwnerFocus) {
                this.onClearFocusForOwner.invoke();
            }
            return clearedFocusSuccessfully;
        } finally {
            this_$iv.commitTransaction();
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Boolean] */
    @Override // androidx.compose.ui.focus.FocusManager
    /* renamed from: moveFocus-3ESFkO8 */
    public boolean mo3872moveFocus3ESFkO8(final int focusDirection) {
        final Ref.ObjectRef requestFocusSuccess = new Ref.ObjectRef();
        requestFocusSuccess.element = false;
        Boolean focusSearchSuccess = mo3876focusSearchULY8qGw(focusDirection, this.onFocusRectInterop.invoke(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$focusSearchSuccess$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Boolean] */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode it) {
                requestFocusSuccess.element = FocusTransactionsKt.m3896requestFocusMxy_nc0(it, focusDirection);
                Boolean bool = requestFocusSuccess.element;
                return Boolean.valueOf(bool != null ? bool.booleanValue() : false);
            }
        });
        if (focusSearchSuccess == null || requestFocusSuccess.element == 0) {
            return false;
        }
        if (Intrinsics.areEqual((Object) focusSearchSuccess, (Object) true) && Intrinsics.areEqual((Object) requestFocusSuccess.element, (Object) true)) {
            return true;
        }
        if (FocusOwnerImplKt.m3883is1dFocusSearch3ESFkO8(focusDirection)) {
            boolean clearFocus = mo3873clearFocusI7lrPNg(false, true, false, focusDirection);
            return clearFocus && mo3878takeFocusaToIllA(focusDirection, null);
        }
        return this.onMoveFocusInterop.invoke(FocusDirection.m3854boximpl(focusDirection)).booleanValue();
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: focusSearch-ULY8qGw */
    public Boolean mo3876focusSearchULY8qGw(int focusDirection, Rect focusedRect, final Function1<? super FocusTargetNode, Boolean> onFound) {
        final FocusTargetNode source = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (source != null) {
            FocusRequester customDest = FocusTraversalKt.m3897customFocusSearchOMvw8(source, focusDirection, this.onLayoutDirection.invoke());
            if (Intrinsics.areEqual(customDest, FocusRequester.INSTANCE.getCancel())) {
                return null;
            }
            if (!Intrinsics.areEqual(customDest, FocusRequester.INSTANCE.getDefault())) {
                return Boolean.valueOf(customDest.findFocusTargetNode$ui_release(onFound));
            }
        } else {
            source = null;
        }
        return FocusTraversalKt.m3898focusSearch0X8WOeE(this.rootFocusNode, focusDirection, this.onLayoutDirection.invoke(), focusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusSearch$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode it) {
                boolean zBooleanValue;
                if (Intrinsics.areEqual(it, source)) {
                    zBooleanValue = false;
                } else {
                    if (Intrinsics.areEqual(it, this.getRootFocusNode())) {
                        throw new IllegalStateException("Focus search landed at the root.".toString());
                    }
                    zBooleanValue = onFound.invoke(it).booleanValue();
                }
                return Boolean.valueOf(zBooleanValue);
            }
        });
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchKeyEvent-YhN2O0w */
    public boolean mo3875dispatchKeyEventYhN2O0w(KeyEvent keyEvent, Function0<Boolean> onFocusedItem) {
        String str;
        int i;
        Object obj;
        Modifier.Node focusedKeyInputNode;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv;
        NodeChain nodes;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv2;
        DelegatableNode $this$nearestAncestor_u2d64DMado$iv3;
        Modifier.Node node;
        int count$iv$iv$iv;
        Modifier.Node node2;
        MutableVector mutableVector;
        Modifier.Node node3;
        Modifier.Node node4;
        Object obj2;
        FocusTargetNode activeFocusTarget;
        String str2;
        NodeChain nodes2;
        FocusTargetNode activeFocusTarget2;
        String str3;
        FocusTargetNode activeFocusTarget3;
        String str4;
        FocusTargetNode activeFocusTarget4;
        String str5;
        MutableVector mutableVector2;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv;
        int i2;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
        int i3;
        MutableVector mutableVector3;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
        int i4;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
        int i5;
        MutableVector mutableVector4;
        DelegatableNode $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
        int type$iv;
        FocusOwnerImpl this_$iv;
        NodeChain nodes3;
        DelegatableNode $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
        FocusOwnerImpl this_$iv2;
        FocusOwnerImpl this_$iv3;
        int count$iv$iv$iv$iv;
        MutableVector mutableVector5;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            throw new IllegalStateException("Dispatching key event while focus system is invalidated.".toString());
        }
        if (!m3882validateKeyEventZmokQxo(keyEvent)) {
            return false;
        }
        FocusTargetNode activeFocusTarget5 = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        String str6 = "visitAncestors called on an unattached node";
        int i6 = 1;
        if (activeFocusTarget5 == null || (focusedKeyInputNode = lastLocalKeyInputNode(activeFocusTarget5)) == null) {
            if (activeFocusTarget5 != null) {
                FocusTargetNode $this$nearestAncestorIncludingSelf_u2d64DMado$iv = activeFocusTarget5;
                int iM5778constructorimpl = NodeKind.m5778constructorimpl(8192);
                if (!$this$nearestAncestorIncludingSelf_u2d64DMado$iv.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                }
                Modifier.Node node$iv$iv$iv = $this$nearestAncestorIncludingSelf_u2d64DMado$iv.getNode();
                LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$nearestAncestorIncludingSelf_u2d64DMado$iv);
                loop10: while (true) {
                    if (layout$iv$iv$iv == null) {
                        str = str6;
                        i = 8192;
                        obj2 = null;
                        break;
                    }
                    Modifier.Node head$iv$iv$iv = layout$iv$iv$iv.getNodes().getHead();
                    if ((head$iv$iv$iv.getAggregateChildKindSet() & iM5778constructorimpl) != 0) {
                        while (node$iv$iv$iv != null) {
                            if ((node$iv$iv$iv.getKindSet() & iM5778constructorimpl) != 0) {
                                Modifier.Node it$iv$iv = node$iv$iv$iv;
                                MutableVector mutableVector6 = null;
                                Modifier.Node nodePop = it$iv$iv;
                                i = 8192;
                                while (nodePop != null) {
                                    if (nodePop instanceof KeyInputModifierNode) {
                                        obj2 = nodePop;
                                        str = str6;
                                        break loop10;
                                    }
                                    Modifier.Node this_$iv$iv$iv$iv = nodePop;
                                    if (((this_$iv$iv$iv$iv.getKindSet() & iM5778constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                                        int count$iv$iv$iv2 = 0;
                                        DelegatingNode this_$iv$iv$iv$iv2 = (DelegatingNode) nodePop;
                                        Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv$iv2.getDelegate();
                                        while (node$iv$iv$iv$iv != null) {
                                            Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                            if ((next$iv$iv$iv.getKindSet() & iM5778constructorimpl) != 0) {
                                                count$iv$iv$iv2++;
                                                if (count$iv$iv$iv2 == i6) {
                                                    nodePop = next$iv$iv$iv;
                                                    activeFocusTarget4 = activeFocusTarget5;
                                                    str5 = str6;
                                                } else {
                                                    if (mutableVector6 == null) {
                                                        activeFocusTarget4 = activeFocusTarget5;
                                                        str5 = str6;
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                    } else {
                                                        activeFocusTarget4 = activeFocusTarget5;
                                                        str5 = str6;
                                                        mutableVector2 = mutableVector6;
                                                    }
                                                    Modifier.Node theNode$iv$iv$iv = nodePop;
                                                    if (theNode$iv$iv$iv != null) {
                                                        if (mutableVector2 != null) {
                                                            Boolean.valueOf(mutableVector2.add(theNode$iv$iv$iv));
                                                        }
                                                        nodePop = null;
                                                    }
                                                    if (mutableVector2 != null) {
                                                        Boolean.valueOf(mutableVector2.add(next$iv$iv$iv));
                                                    }
                                                    mutableVector6 = mutableVector2;
                                                }
                                            } else {
                                                activeFocusTarget4 = activeFocusTarget5;
                                                str5 = str6;
                                            }
                                            node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                                            activeFocusTarget5 = activeFocusTarget4;
                                            str6 = str5;
                                            i6 = 1;
                                        }
                                        activeFocusTarget3 = activeFocusTarget5;
                                        str4 = str6;
                                        if (count$iv$iv$iv2 == 1) {
                                            activeFocusTarget5 = activeFocusTarget3;
                                            str6 = str4;
                                            i6 = 1;
                                        } else {
                                            nodePop = DelegatableNodeKt.pop(mutableVector6);
                                            activeFocusTarget5 = activeFocusTarget3;
                                            str6 = str4;
                                            i6 = 1;
                                        }
                                    } else {
                                        activeFocusTarget3 = activeFocusTarget5;
                                        str4 = str6;
                                        nodePop = DelegatableNodeKt.pop(mutableVector6);
                                        activeFocusTarget5 = activeFocusTarget3;
                                        str6 = str4;
                                        i6 = 1;
                                    }
                                }
                                activeFocusTarget2 = activeFocusTarget5;
                                str3 = str6;
                            } else {
                                activeFocusTarget2 = activeFocusTarget5;
                                str3 = str6;
                            }
                            node$iv$iv$iv = node$iv$iv$iv.getParent();
                            activeFocusTarget5 = activeFocusTarget2;
                            str6 = str3;
                            i6 = 1;
                        }
                        activeFocusTarget = activeFocusTarget5;
                        str2 = str6;
                    } else {
                        activeFocusTarget = activeFocusTarget5;
                        str2 = str6;
                    }
                    layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
                    node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes2 = layout$iv$iv$iv.getNodes()) == null) ? null : nodes2.getTail();
                    activeFocusTarget5 = activeFocusTarget;
                    str6 = str2;
                    i6 = 1;
                }
                KeyInputModifierNode keyInputModifierNode = (KeyInputModifierNode) obj2;
                if (keyInputModifierNode != null) {
                    focusedKeyInputNode = keyInputModifierNode.getNode();
                }
            } else {
                str = "visitAncestors called on an unattached node";
                i = 8192;
            }
            DelegatableNode $this$nearestAncestor_u2d64DMado$iv4 = this.rootFocusNode;
            int iM5778constructorimpl2 = NodeKind.m5778constructorimpl(i);
            if (!$this$nearestAncestor_u2d64DMado$iv4.getNode().getIsAttached()) {
                throw new IllegalStateException(str.toString());
            }
            Modifier.Node node$iv$iv$iv2 = $this$nearestAncestor_u2d64DMado$iv4.getNode().getParent();
            LayoutNode layout$iv$iv$iv2 = DelegatableNodeKt.requireLayoutNode($this$nearestAncestor_u2d64DMado$iv4);
            loop14: while (true) {
                if (layout$iv$iv$iv2 == null) {
                    obj = null;
                    break;
                }
                Modifier.Node head$iv$iv$iv2 = layout$iv$iv$iv2.getNodes().getHead();
                if ((head$iv$iv$iv2.getAggregateChildKindSet() & iM5778constructorimpl2) != 0) {
                    while (node$iv$iv$iv2 != null) {
                        if ((node$iv$iv$iv2.getKindSet() & iM5778constructorimpl2) != 0) {
                            Modifier.Node it$iv$iv2 = node$iv$iv$iv2;
                            MutableVector mutableVector7 = null;
                            Modifier.Node nodePop2 = it$iv$iv2;
                            while (nodePop2 != null) {
                                if (nodePop2 instanceof KeyInputModifierNode) {
                                    obj = nodePop2;
                                    break loop14;
                                }
                                Modifier.Node this_$iv$iv$iv$iv3 = nodePop2;
                                if (((this_$iv$iv$iv$iv3.getKindSet() & iM5778constructorimpl2) != 0) && (nodePop2 instanceof DelegatingNode)) {
                                    int count$iv$iv$iv3 = 0;
                                    DelegatingNode this_$iv$iv$iv$iv4 = (DelegatingNode) nodePop2;
                                    Modifier.Node node$iv$iv$iv$iv2 = this_$iv$iv$iv$iv4.getDelegate();
                                    while (node$iv$iv$iv$iv2 != null) {
                                        Modifier.Node next$iv$iv$iv2 = node$iv$iv$iv$iv2;
                                        if ((next$iv$iv$iv2.getKindSet() & iM5778constructorimpl2) != 0) {
                                            count$iv$iv$iv3++;
                                            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                            if (count$iv$iv$iv3 == 1) {
                                                node = next$iv$iv$iv2;
                                            } else {
                                                if (mutableVector7 == null) {
                                                    count$iv$iv$iv = count$iv$iv$iv3;
                                                    node2 = nodePop2;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    count$iv$iv$iv = count$iv$iv$iv3;
                                                    node2 = nodePop2;
                                                    mutableVector = mutableVector7;
                                                }
                                                Modifier.Node theNode$iv$iv$iv2 = node2;
                                                if (theNode$iv$iv$iv2 != null) {
                                                    if (mutableVector != null) {
                                                        Boolean.valueOf(mutableVector.add(theNode$iv$iv$iv2));
                                                    }
                                                    node3 = null;
                                                } else {
                                                    node3 = node2;
                                                }
                                                if (mutableVector != null) {
                                                    node4 = node3;
                                                    Boolean.valueOf(mutableVector.add(next$iv$iv$iv2));
                                                } else {
                                                    node4 = node3;
                                                }
                                                node = node4;
                                                count$iv$iv$iv3 = count$iv$iv$iv;
                                                mutableVector7 = mutableVector;
                                            }
                                        } else {
                                            $this$nearestAncestor_u2d64DMado$iv3 = $this$nearestAncestor_u2d64DMado$iv4;
                                            node = nodePop2;
                                        }
                                        node$iv$iv$iv$iv2 = node$iv$iv$iv$iv2.getChild();
                                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv3;
                                        nodePop2 = node;
                                    }
                                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                    Modifier.Node node5 = nodePop2;
                                    if (count$iv$iv$iv3 == 1) {
                                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                        nodePop2 = node5;
                                    } else {
                                        nodePop2 = DelegatableNodeKt.pop(mutableVector7);
                                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                    }
                                } else {
                                    $this$nearestAncestor_u2d64DMado$iv2 = $this$nearestAncestor_u2d64DMado$iv4;
                                    nodePop2 = DelegatableNodeKt.pop(mutableVector7);
                                    $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv2;
                                }
                            }
                        }
                        node$iv$iv$iv2 = node$iv$iv$iv2.getParent();
                        $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv4;
                    }
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv4;
                } else {
                    $this$nearestAncestor_u2d64DMado$iv = $this$nearestAncestor_u2d64DMado$iv4;
                }
                layout$iv$iv$iv2 = layout$iv$iv$iv2.getParent$ui_release();
                node$iv$iv$iv2 = (layout$iv$iv$iv2 == null || (nodes = layout$iv$iv$iv2.getNodes()) == null) ? null : nodes.getTail();
                $this$nearestAncestor_u2d64DMado$iv4 = $this$nearestAncestor_u2d64DMado$iv;
            }
            KeyInputModifierNode keyInputModifierNode2 = (KeyInputModifierNode) obj;
            focusedKeyInputNode = keyInputModifierNode2 != null ? keyInputModifierNode2.getNode() : null;
        } else {
            str = "visitAncestors called on an unattached node";
            i = 8192;
        }
        if (focusedKeyInputNode == null) {
            return false;
        }
        Modifier.Node $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv3 = focusedKeyInputNode;
        int count$iv$iv$iv$iv2 = NodeKind.m5778constructorimpl(i);
        FocusOwnerImpl this_$iv4 = this;
        List ancestors$iv = null;
        if (!$this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv3.getNode().getIsAttached()) {
            throw new IllegalStateException(str.toString());
        }
        Modifier.Node node$iv$iv$iv$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv3.getNode().getParent();
        LayoutNode layout$iv$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv3);
        while (layout$iv$iv$iv$iv != null) {
            Modifier.Node head$iv$iv$iv$iv = layout$iv$iv$iv$iv.getNodes().getHead();
            if ((head$iv$iv$iv$iv.getAggregateChildKindSet() & count$iv$iv$iv$iv2) != 0) {
                while (node$iv$iv$iv$iv3 != null) {
                    if ((node$iv$iv$iv$iv3.getKindSet() & count$iv$iv$iv$iv2) != 0) {
                        Modifier.Node it$iv$iv$iv = node$iv$iv$iv$iv3;
                        MutableVector mutableVector8 = null;
                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv3;
                        Modifier.Node theNode$iv$iv$iv$iv = it$iv$iv$iv;
                        while (theNode$iv$iv$iv$iv != null) {
                            int type$iv2 = count$iv$iv$iv$iv2;
                            if (theNode$iv$iv$iv$iv instanceof KeyInputModifierNode) {
                                Modifier.Node node6 = theNode$iv$iv$iv$iv;
                                if (ancestors$iv == null) {
                                    Object result$iv$iv = new ArrayList();
                                    ancestors$iv = (List) result$iv$iv;
                                }
                                ancestors$iv.add(node6);
                                this_$iv2 = this_$iv4;
                            } else {
                                Modifier.Node this_$iv$iv$iv$iv$iv = theNode$iv$iv$iv$iv;
                                if (((this_$iv$iv$iv$iv$iv.getKindSet() & type$iv2) != 0) && (theNode$iv$iv$iv$iv instanceof DelegatingNode)) {
                                    int count$iv$iv$iv$iv3 = 0;
                                    DelegatingNode this_$iv$iv$iv$iv$iv2 = (DelegatingNode) theNode$iv$iv$iv$iv;
                                    Modifier.Node node$iv$iv$iv$iv$iv = this_$iv$iv$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv$iv$iv != null) {
                                        Modifier.Node next$iv$iv$iv$iv = node$iv$iv$iv$iv$iv;
                                        if ((next$iv$iv$iv$iv.getKindSet() & type$iv2) != 0) {
                                            count$iv$iv$iv$iv3++;
                                            Modifier.Node node7 = theNode$iv$iv$iv$iv;
                                            if (count$iv$iv$iv$iv3 == 1) {
                                                theNode$iv$iv$iv$iv = next$iv$iv$iv$iv;
                                                this_$iv3 = this_$iv4;
                                            } else {
                                                if (mutableVector8 == null) {
                                                    count$iv$iv$iv$iv = count$iv$iv$iv$iv3;
                                                    this_$iv3 = this_$iv4;
                                                    mutableVector5 = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    count$iv$iv$iv$iv = count$iv$iv$iv$iv3;
                                                    this_$iv3 = this_$iv4;
                                                    mutableVector5 = mutableVector8;
                                                }
                                                if (node7 != null) {
                                                    if (mutableVector5 != null) {
                                                        Boolean.valueOf(mutableVector5.add(node7));
                                                    }
                                                    node7 = null;
                                                }
                                                if (mutableVector5 != null) {
                                                    Boolean.valueOf(mutableVector5.add(next$iv$iv$iv$iv));
                                                }
                                                mutableVector8 = mutableVector5;
                                                theNode$iv$iv$iv$iv = node7;
                                                count$iv$iv$iv$iv3 = count$iv$iv$iv$iv;
                                            }
                                        } else {
                                            this_$iv3 = this_$iv4;
                                        }
                                        node$iv$iv$iv$iv$iv = node$iv$iv$iv$iv$iv.getChild();
                                        this_$iv4 = this_$iv3;
                                    }
                                    Modifier.Node node8 = theNode$iv$iv$iv$iv;
                                    this_$iv2 = this_$iv4;
                                    if (count$iv$iv$iv$iv3 == 1) {
                                        count$iv$iv$iv$iv2 = type$iv2;
                                        theNode$iv$iv$iv$iv = node8;
                                        this_$iv4 = this_$iv2;
                                    }
                                } else {
                                    this_$iv2 = this_$iv4;
                                }
                            }
                            theNode$iv$iv$iv$iv = DelegatableNodeKt.pop(mutableVector8);
                            count$iv$iv$iv$iv2 = type$iv2;
                            this_$iv4 = this_$iv2;
                        }
                    } else {
                        $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv3;
                    }
                    node$iv$iv$iv$iv3 = node$iv$iv$iv$iv3.getParent();
                    $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv2;
                    count$iv$iv$iv$iv2 = count$iv$iv$iv$iv2;
                    this_$iv4 = this_$iv4;
                }
                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv3;
                type$iv = count$iv$iv$iv$iv2;
                this_$iv = this_$iv4;
            } else {
                $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv3;
                type$iv = count$iv$iv$iv$iv2;
                this_$iv = this_$iv4;
            }
            layout$iv$iv$iv$iv = layout$iv$iv$iv$iv.getParent$ui_release();
            node$iv$iv$iv$iv3 = (layout$iv$iv$iv$iv == null || (nodes3 = layout$iv$iv$iv$iv.getNodes()) == null) ? null : nodes3.getTail();
            $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv3 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv;
            count$iv$iv$iv$iv2 = type$iv;
            this_$iv4 = this_$iv;
        }
        DelegatableNode $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv4 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv3;
        int type$iv3 = count$iv$iv$iv$iv2;
        if (ancestors$iv != null) {
            List $this$fastForEachReversed$iv$iv = ancestors$iv;
            int size = $this$fastForEachReversed$iv$iv.size() - 1;
            if (size >= 0) {
                do {
                    int index$iv$iv = size;
                    size--;
                    Object item$iv$iv = $this$fastForEachReversed$iv$iv.get(index$iv$iv);
                    KeyInputModifierNode it = (KeyInputModifierNode) item$iv$iv;
                    if (it.mo204onPreKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                } while (size >= 0);
            }
            Unit unit = Unit.INSTANCE;
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv4.getNode();
        int i7 = 0;
        MutableVector mutableVector9 = null;
        Modifier.Node nodePop3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
        while (nodePop3 != null) {
            if (nodePop3 instanceof KeyInputModifierNode) {
                KeyInputModifierNode it2 = (KeyInputModifierNode) nodePop3;
                if (it2.mo204onPreKeyEventZmokQxo(keyEvent)) {
                    return true;
                }
                $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                i4 = i7;
            } else {
                Modifier.Node this_$iv$iv$iv = nodePop3;
                if (((this_$iv$iv$iv.getKindSet() & type$iv3) != 0) && (nodePop3 instanceof DelegatingNode)) {
                    int count$iv$iv = 0;
                    DelegatingNode this_$iv$iv$iv2 = (DelegatingNode) nodePop3;
                    Modifier.Node node$iv$iv$iv3 = this_$iv$iv$iv2.getDelegate();
                    while (node$iv$iv$iv3 != null) {
                        Modifier.Node next$iv$iv = node$iv$iv$iv3;
                        if ((next$iv$iv.getKindSet() & type$iv3) != 0) {
                            count$iv$iv++;
                            if (count$iv$iv == 1) {
                                nodePop3 = next$iv$iv;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                i5 = i7;
                            } else {
                                if (mutableVector9 == null) {
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                    i5 = i7;
                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                } else {
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                                    i5 = i7;
                                    mutableVector4 = mutableVector9;
                                }
                                mutableVector9 = mutableVector4;
                                Modifier.Node theNode$iv$iv = nodePop3;
                                if (theNode$iv$iv != null) {
                                    if (mutableVector9 != null) {
                                        Boolean.valueOf(mutableVector9.add(theNode$iv$iv));
                                    }
                                    nodePop3 = null;
                                }
                                if (mutableVector9 != null) {
                                    Boolean.valueOf(mutableVector9.add(next$iv$iv));
                                }
                            }
                        } else {
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                            i5 = i7;
                        }
                        node$iv$iv$iv3 = node$iv$iv$iv3.getChild();
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv$iv4;
                        i7 = i5;
                    }
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                    i4 = i7;
                    MutableVector mutableVector10 = mutableVector9;
                    if (count$iv$iv == 1) {
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
                        i7 = i4;
                        mutableVector9 = mutableVector10;
                    } else {
                        mutableVector9 = mutableVector10;
                    }
                } else {
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv$iv5;
                    i4 = i7;
                }
            }
            nodePop3 = DelegatableNodeKt.pop(mutableVector9);
            $this$dispatchForKind_u2d6rFNWt0$iv$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv$iv3;
            i7 = i4;
        }
        if (onFocusedItem.invoke().booleanValue()) {
            return true;
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k$iv4.getNode();
        int i8 = 0;
        MutableVector mutableVector11 = null;
        Modifier.Node nodePop4 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
        while (nodePop4 != null) {
            if (nodePop4 instanceof KeyInputModifierNode) {
                KeyInputModifierNode it3 = (KeyInputModifierNode) nodePop4;
                if (it3.mo202onKeyEventZmokQxo(keyEvent)) {
                    return true;
                }
                $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                i2 = i8;
            } else {
                Modifier.Node this_$iv$iv$iv3 = nodePop4;
                if (((this_$iv$iv$iv3.getKindSet() & type$iv3) != 0) && (nodePop4 instanceof DelegatingNode)) {
                    int count$iv$iv2 = 0;
                    DelegatingNode this_$iv$iv$iv4 = (DelegatingNode) nodePop4;
                    Modifier.Node node$iv$iv$iv4 = this_$iv$iv$iv4.getDelegate();
                    while (node$iv$iv$iv4 != null) {
                        Modifier.Node next$iv$iv2 = node$iv$iv$iv4;
                        if ((next$iv$iv2.getKindSet() & type$iv3) != 0) {
                            count$iv$iv2++;
                            if (count$iv$iv2 == 1) {
                                nodePop4 = next$iv$iv2;
                                $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                i3 = i8;
                            } else {
                                if (mutableVector11 == null) {
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                    i3 = i8;
                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                } else {
                                    $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                                    i3 = i8;
                                    mutableVector3 = mutableVector11;
                                }
                                mutableVector11 = mutableVector3;
                                Modifier.Node theNode$iv$iv2 = nodePop4;
                                if (theNode$iv$iv2 != null) {
                                    if (mutableVector11 != null) {
                                        Boolean.valueOf(mutableVector11.add(theNode$iv$iv2));
                                    }
                                    nodePop4 = null;
                                }
                                if (mutableVector11 != null) {
                                    Boolean.valueOf(mutableVector11.add(next$iv$iv2));
                                }
                            }
                        } else {
                            $this$dispatchForKind_u2d6rFNWt0$iv$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                            i3 = i8;
                        }
                        node$iv$iv$iv4 = node$iv$iv$iv4.getChild();
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv$iv2;
                        i8 = i3;
                    }
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                    i2 = i8;
                    MutableVector mutableVector12 = mutableVector11;
                    if (count$iv$iv2 == 1) {
                        $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
                        i8 = i2;
                        mutableVector11 = mutableVector12;
                    } else {
                        mutableVector11 = mutableVector12;
                    }
                } else {
                    $this$dispatchForKind_u2d6rFNWt0$iv$iv = $this$dispatchForKind_u2d6rFNWt0$iv$iv6;
                    i2 = i8;
                }
            }
            nodePop4 = DelegatableNodeKt.pop(mutableVector11);
            $this$dispatchForKind_u2d6rFNWt0$iv$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv$iv;
            i8 = i2;
        }
        if (ancestors$iv != null) {
            List $this$fastForEach$iv$iv = ancestors$iv;
            int size2 = $this$fastForEach$iv$iv.size();
            for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                Object item$iv$iv2 = $this$fastForEach$iv$iv.get(index$iv$iv2);
                KeyInputModifierNode it4 = (KeyInputModifierNode) item$iv$iv2;
                if (it4.mo202onKeyEventZmokQxo(keyEvent)) {
                    return true;
                }
            }
            Unit unit2 = Unit.INSTANCE;
        }
        Unit unit3 = Unit.INSTANCE;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    public boolean mo3874dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent keyEvent) {
        int i;
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode;
        Modifier.Node node;
        int i2;
        Modifier.Node node2;
        int i3;
        MutableVector mutableVector;
        Modifier.Node node3;
        int i4;
        Modifier.Node node4;
        int i5;
        MutableVector mutableVector2;
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode2;
        int i6;
        NodeChain nodes;
        int i7;
        Modifier.Node node5;
        int i8;
        Modifier.Node node6;
        int i9;
        MutableVector mutableVector3;
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode3;
        FocusTargetNode focusTargetNode;
        NodeChain nodes2;
        FocusTargetNode focusTargetNode2;
        FocusTargetNode focusTargetNode3;
        FocusTargetNode focusTargetNode4;
        MutableVector mutableVector4;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            throw new IllegalStateException("Dispatching intercepted soft keyboard event while focus system is invalidated.".toString());
        }
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        int i10 = 1;
        if (focusTargetNodeFindActiveFocusNode != null) {
            FocusTargetNode focusTargetNode5 = focusTargetNodeFindActiveFocusNode;
            int iM5778constructorimpl = NodeKind.m5778constructorimpl(131072);
            if (!focusTargetNode5.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node node7 = focusTargetNode5.getNode();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode5);
            loop0: while (true) {
                if (layoutNodeRequireLayoutNode == null) {
                    i = 131072;
                    softKeyboardInterceptionModifierNode3 = null;
                    break;
                }
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM5778constructorimpl) != 0) {
                    while (node7 != null) {
                        if ((node7.getKindSet() & iM5778constructorimpl) != 0) {
                            MutableVector mutableVector5 = null;
                            Modifier.Node nodePop = node7;
                            i = 131072;
                            while (nodePop != 0) {
                                if (nodePop instanceof SoftKeyboardInterceptionModifierNode) {
                                    softKeyboardInterceptionModifierNode3 = nodePop;
                                    break loop0;
                                }
                                if (((nodePop.getKindSet() & iM5778constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                                    int i11 = 0;
                                    Modifier.Node delegate = nodePop.getDelegate();
                                    nodePop = nodePop;
                                    while (delegate != null) {
                                        Modifier.Node node8 = delegate;
                                        if ((node8.getKindSet() & iM5778constructorimpl) != 0) {
                                            i11++;
                                            if (i11 == i10) {
                                                nodePop = node8;
                                                focusTargetNode4 = focusTargetNode5;
                                            } else {
                                                if (mutableVector5 == null) {
                                                    focusTargetNode4 = focusTargetNode5;
                                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    focusTargetNode4 = focusTargetNode5;
                                                    mutableVector4 = mutableVector5;
                                                }
                                                Object obj = nodePop;
                                                nodePop = nodePop;
                                                if (obj != null) {
                                                    if (mutableVector4 != null) {
                                                        mutableVector4.add(obj);
                                                    }
                                                    nodePop = 0;
                                                }
                                                if (mutableVector4 != null) {
                                                    mutableVector4.add(node8);
                                                }
                                                mutableVector5 = mutableVector4;
                                            }
                                        } else {
                                            focusTargetNode4 = focusTargetNode5;
                                        }
                                        delegate = delegate.getChild();
                                        focusTargetNode5 = focusTargetNode4;
                                        i10 = 1;
                                        nodePop = nodePop;
                                    }
                                    focusTargetNode3 = focusTargetNode5;
                                    if (i11 == 1) {
                                        focusTargetNode5 = focusTargetNode3;
                                        i10 = 1;
                                    } else {
                                        nodePop = DelegatableNodeKt.pop(mutableVector5);
                                        focusTargetNode5 = focusTargetNode3;
                                        i10 = 1;
                                    }
                                } else {
                                    focusTargetNode3 = focusTargetNode5;
                                    nodePop = DelegatableNodeKt.pop(mutableVector5);
                                    focusTargetNode5 = focusTargetNode3;
                                    i10 = 1;
                                }
                            }
                            focusTargetNode2 = focusTargetNode5;
                        } else {
                            focusTargetNode2 = focusTargetNode5;
                        }
                        node7 = node7.getParent();
                        focusTargetNode5 = focusTargetNode2;
                        i10 = 1;
                    }
                    focusTargetNode = focusTargetNode5;
                } else {
                    focusTargetNode = focusTargetNode5;
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                node7 = (layoutNodeRequireLayoutNode == null || (nodes2 = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
                focusTargetNode5 = focusTargetNode;
                i10 = 1;
            }
            softKeyboardInterceptionModifierNode = softKeyboardInterceptionModifierNode3;
        } else {
            i = 131072;
            softKeyboardInterceptionModifierNode = null;
        }
        if (softKeyboardInterceptionModifierNode == null) {
            return false;
        }
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode4 = softKeyboardInterceptionModifierNode;
        int iM5778constructorimpl2 = NodeKind.m5778constructorimpl(i);
        ArrayList arrayList = null;
        if (!softKeyboardInterceptionModifierNode4.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent = softKeyboardInterceptionModifierNode4.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(softKeyboardInterceptionModifierNode4);
        while (layoutNodeRequireLayoutNode2 != null) {
            if ((layoutNodeRequireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & iM5778constructorimpl2) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM5778constructorimpl2) != 0) {
                        MutableVector mutableVector6 = null;
                        Modifier.Node nodePop2 = parent;
                        while (nodePop2 != null) {
                            SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode5 = softKeyboardInterceptionModifierNode4;
                            if (nodePop2 instanceof SoftKeyboardInterceptionModifierNode) {
                                Modifier.Node node9 = nodePop2;
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(node9);
                                i7 = iM5778constructorimpl2;
                                node5 = parent;
                            } else if (((nodePop2.getKindSet() & iM5778constructorimpl2) != 0) && (nodePop2 instanceof DelegatingNode)) {
                                int i12 = 0;
                                Modifier.Node delegate2 = ((DelegatingNode) nodePop2).getDelegate();
                                while (delegate2 != null) {
                                    Modifier.Node node10 = delegate2;
                                    if ((node10.getKindSet() & iM5778constructorimpl2) != 0) {
                                        i12++;
                                        i8 = iM5778constructorimpl2;
                                        if (i12 == 1) {
                                            nodePop2 = node10;
                                            node6 = parent;
                                        } else {
                                            if (mutableVector6 == null) {
                                                i9 = i12;
                                                node6 = parent;
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            } else {
                                                i9 = i12;
                                                node6 = parent;
                                                mutableVector3 = mutableVector6;
                                            }
                                            Modifier.Node node11 = nodePop2;
                                            if (node11 != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(node11);
                                                }
                                                nodePop2 = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(node10);
                                            }
                                            mutableVector6 = mutableVector3;
                                            i12 = i9;
                                        }
                                    } else {
                                        i8 = iM5778constructorimpl2;
                                        node6 = parent;
                                    }
                                    delegate2 = delegate2.getChild();
                                    iM5778constructorimpl2 = i8;
                                    parent = node6;
                                }
                                i7 = iM5778constructorimpl2;
                                node5 = parent;
                                if (i12 == 1) {
                                    softKeyboardInterceptionModifierNode4 = softKeyboardInterceptionModifierNode5;
                                    iM5778constructorimpl2 = i7;
                                    parent = node5;
                                }
                            } else {
                                i7 = iM5778constructorimpl2;
                                node5 = parent;
                            }
                            nodePop2 = DelegatableNodeKt.pop(mutableVector6);
                            softKeyboardInterceptionModifierNode4 = softKeyboardInterceptionModifierNode5;
                            iM5778constructorimpl2 = i7;
                            parent = node5;
                        }
                    }
                    parent = parent.getParent();
                    softKeyboardInterceptionModifierNode4 = softKeyboardInterceptionModifierNode4;
                    iM5778constructorimpl2 = iM5778constructorimpl2;
                }
                softKeyboardInterceptionModifierNode2 = softKeyboardInterceptionModifierNode4;
                i6 = iM5778constructorimpl2;
            } else {
                softKeyboardInterceptionModifierNode2 = softKeyboardInterceptionModifierNode4;
                i6 = iM5778constructorimpl2;
            }
            layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui_release();
            parent = (layoutNodeRequireLayoutNode2 == null || (nodes = layoutNodeRequireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            softKeyboardInterceptionModifierNode4 = softKeyboardInterceptionModifierNode2;
            iM5778constructorimpl2 = i6;
        }
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode6 = softKeyboardInterceptionModifierNode4;
        int i13 = iM5778constructorimpl2;
        if (arrayList != null) {
            List list = arrayList;
            int size = list.size() - 1;
            if (size >= 0) {
                do {
                    int i14 = size;
                    size--;
                    if (((SoftKeyboardInterceptionModifierNode) list.get(i14)).mo4945onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                } while (size >= 0);
            }
        }
        Modifier.Node node12 = softKeyboardInterceptionModifierNode6.getNode();
        int i15 = 0;
        MutableVector mutableVector7 = null;
        Modifier.Node nodePop3 = node12;
        while (nodePop3 != null) {
            if (nodePop3 instanceof SoftKeyboardInterceptionModifierNode) {
                if (((SoftKeyboardInterceptionModifierNode) nodePop3).mo4945onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                    return true;
                }
                node3 = node12;
                i4 = i15;
            } else if (((nodePop3.getKindSet() & i13) != 0) && (nodePop3 instanceof DelegatingNode)) {
                int i16 = 0;
                Modifier.Node delegate3 = ((DelegatingNode) nodePop3).getDelegate();
                while (delegate3 != null) {
                    Modifier.Node node13 = delegate3;
                    if ((node13.getKindSet() & i13) != 0) {
                        i16++;
                        if (i16 == 1) {
                            nodePop3 = node13;
                            node4 = node12;
                            i5 = i15;
                        } else {
                            if (mutableVector7 == null) {
                                node4 = node12;
                                i5 = i15;
                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                            } else {
                                node4 = node12;
                                i5 = i15;
                                mutableVector2 = mutableVector7;
                            }
                            mutableVector7 = mutableVector2;
                            Modifier.Node node14 = nodePop3;
                            if (node14 != null) {
                                if (mutableVector7 != null) {
                                    mutableVector7.add(node14);
                                }
                                nodePop3 = null;
                            }
                            if (mutableVector7 != null) {
                                mutableVector7.add(node13);
                            }
                        }
                    } else {
                        node4 = node12;
                        i5 = i15;
                    }
                    delegate3 = delegate3.getChild();
                    node12 = node4;
                    i15 = i5;
                }
                node3 = node12;
                i4 = i15;
                MutableVector mutableVector8 = mutableVector7;
                if (i16 == 1) {
                    node12 = node3;
                    i15 = i4;
                    mutableVector7 = mutableVector8;
                } else {
                    mutableVector7 = mutableVector8;
                }
            } else {
                node3 = node12;
                i4 = i15;
            }
            nodePop3 = DelegatableNodeKt.pop(mutableVector7);
            node12 = node3;
            i15 = i4;
        }
        Modifier.Node node15 = softKeyboardInterceptionModifierNode6.getNode();
        int i17 = 0;
        MutableVector mutableVector9 = null;
        Modifier.Node nodePop4 = node15;
        while (nodePop4 != null) {
            if (nodePop4 instanceof SoftKeyboardInterceptionModifierNode) {
                if (((SoftKeyboardInterceptionModifierNode) nodePop4).mo4944onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                    return true;
                }
                node = node15;
                i2 = i17;
            } else if (((nodePop4.getKindSet() & i13) != 0) && (nodePop4 instanceof DelegatingNode)) {
                int i18 = 0;
                Modifier.Node delegate4 = ((DelegatingNode) nodePop4).getDelegate();
                while (delegate4 != null) {
                    Modifier.Node node16 = delegate4;
                    if ((node16.getKindSet() & i13) != 0) {
                        i18++;
                        if (i18 == 1) {
                            nodePop4 = node16;
                            node2 = node15;
                            i3 = i17;
                        } else {
                            if (mutableVector9 == null) {
                                node2 = node15;
                                i3 = i17;
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            } else {
                                node2 = node15;
                                i3 = i17;
                                mutableVector = mutableVector9;
                            }
                            mutableVector9 = mutableVector;
                            Modifier.Node node17 = nodePop4;
                            if (node17 != null) {
                                if (mutableVector9 != null) {
                                    mutableVector9.add(node17);
                                }
                                nodePop4 = null;
                            }
                            if (mutableVector9 != null) {
                                mutableVector9.add(node16);
                            }
                        }
                    } else {
                        node2 = node15;
                        i3 = i17;
                    }
                    delegate4 = delegate4.getChild();
                    node15 = node2;
                    i17 = i3;
                }
                node = node15;
                i2 = i17;
                MutableVector mutableVector10 = mutableVector9;
                if (i18 == 1) {
                    node15 = node;
                    i17 = i2;
                    mutableVector9 = mutableVector10;
                } else {
                    mutableVector9 = mutableVector10;
                }
            } else {
                node = node15;
                i2 = i17;
            }
            nodePop4 = DelegatableNodeKt.pop(mutableVector9);
            node15 = node;
            i17 = i2;
        }
        if (arrayList == null) {
            return false;
        }
        List list2 = arrayList;
        int size2 = list2.size();
        for (int i19 = 0; i19 < size2; i19++) {
            if (((SoftKeyboardInterceptionModifierNode) list2.get(i19)).mo4944onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // androidx.compose.ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(RotaryScrollEvent event) {
        int i;
        RotaryInputModifierNode rotaryInputModifierNode;
        Modifier.Node node;
        int i2;
        Modifier.Node node2;
        int i3;
        MutableVector mutableVector;
        Modifier.Node node3;
        int i4;
        Modifier.Node node4;
        int i5;
        MutableVector mutableVector2;
        RotaryInputModifierNode rotaryInputModifierNode2;
        int i6;
        NodeChain nodes;
        int i7;
        Modifier.Node node5;
        int i8;
        Modifier.Node node6;
        int i9;
        MutableVector mutableVector3;
        RotaryInputModifierNode rotaryInputModifierNode3;
        FocusTargetNode focusTargetNode;
        NodeChain nodes2;
        FocusTargetNode focusTargetNode2;
        FocusTargetNode focusTargetNode3;
        FocusTargetNode focusTargetNode4;
        MutableVector mutableVector4;
        if (this.focusInvalidationManager.hasPendingInvalidation()) {
            throw new IllegalStateException("Dispatching rotary event while focus system is invalidated.".toString());
        }
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        int i10 = 1;
        if (focusTargetNodeFindActiveFocusNode != null) {
            FocusTargetNode focusTargetNode5 = focusTargetNodeFindActiveFocusNode;
            int iM5778constructorimpl = NodeKind.m5778constructorimpl(16384);
            if (!focusTargetNode5.getNode().getIsAttached()) {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
            Modifier.Node node7 = focusTargetNode5.getNode();
            LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode5);
            loop0: while (true) {
                if (layoutNodeRequireLayoutNode == null) {
                    i = 16384;
                    rotaryInputModifierNode3 = null;
                    break;
                }
                if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & iM5778constructorimpl) != 0) {
                    while (node7 != null) {
                        if ((node7.getKindSet() & iM5778constructorimpl) != 0) {
                            MutableVector mutableVector5 = null;
                            Modifier.Node nodePop = node7;
                            i = 16384;
                            while (nodePop != 0) {
                                if (nodePop instanceof RotaryInputModifierNode) {
                                    rotaryInputModifierNode3 = nodePop;
                                    break loop0;
                                }
                                if (((nodePop.getKindSet() & iM5778constructorimpl) != 0) && (nodePop instanceof DelegatingNode)) {
                                    int i11 = 0;
                                    Modifier.Node delegate = nodePop.getDelegate();
                                    nodePop = nodePop;
                                    while (delegate != null) {
                                        Modifier.Node node8 = delegate;
                                        if ((node8.getKindSet() & iM5778constructorimpl) != 0) {
                                            i11++;
                                            if (i11 == i10) {
                                                nodePop = node8;
                                                focusTargetNode4 = focusTargetNode5;
                                            } else {
                                                if (mutableVector5 == null) {
                                                    focusTargetNode4 = focusTargetNode5;
                                                    mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    focusTargetNode4 = focusTargetNode5;
                                                    mutableVector4 = mutableVector5;
                                                }
                                                Object obj = nodePop;
                                                nodePop = nodePop;
                                                if (obj != null) {
                                                    if (mutableVector4 != null) {
                                                        mutableVector4.add(obj);
                                                    }
                                                    nodePop = 0;
                                                }
                                                if (mutableVector4 != null) {
                                                    mutableVector4.add(node8);
                                                }
                                                mutableVector5 = mutableVector4;
                                            }
                                        } else {
                                            focusTargetNode4 = focusTargetNode5;
                                        }
                                        delegate = delegate.getChild();
                                        focusTargetNode5 = focusTargetNode4;
                                        i10 = 1;
                                        nodePop = nodePop;
                                    }
                                    focusTargetNode3 = focusTargetNode5;
                                    if (i11 == 1) {
                                        focusTargetNode5 = focusTargetNode3;
                                        i10 = 1;
                                    } else {
                                        nodePop = DelegatableNodeKt.pop(mutableVector5);
                                        focusTargetNode5 = focusTargetNode3;
                                        i10 = 1;
                                    }
                                } else {
                                    focusTargetNode3 = focusTargetNode5;
                                    nodePop = DelegatableNodeKt.pop(mutableVector5);
                                    focusTargetNode5 = focusTargetNode3;
                                    i10 = 1;
                                }
                            }
                            focusTargetNode2 = focusTargetNode5;
                        } else {
                            focusTargetNode2 = focusTargetNode5;
                        }
                        node7 = node7.getParent();
                        focusTargetNode5 = focusTargetNode2;
                        i10 = 1;
                    }
                    focusTargetNode = focusTargetNode5;
                } else {
                    focusTargetNode = focusTargetNode5;
                }
                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
                node7 = (layoutNodeRequireLayoutNode == null || (nodes2 = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes2.getTail();
                focusTargetNode5 = focusTargetNode;
                i10 = 1;
            }
            rotaryInputModifierNode = rotaryInputModifierNode3;
        } else {
            i = 16384;
            rotaryInputModifierNode = null;
        }
        if (rotaryInputModifierNode == null) {
            return false;
        }
        RotaryInputModifierNode rotaryInputModifierNode4 = rotaryInputModifierNode;
        int iM5778constructorimpl2 = NodeKind.m5778constructorimpl(i);
        ArrayList arrayList = null;
        if (!rotaryInputModifierNode4.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent = rotaryInputModifierNode4.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(rotaryInputModifierNode4);
        while (layoutNodeRequireLayoutNode2 != null) {
            if ((layoutNodeRequireLayoutNode2.getNodes().getHead().getAggregateChildKindSet() & iM5778constructorimpl2) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & iM5778constructorimpl2) != 0) {
                        MutableVector mutableVector6 = null;
                        Modifier.Node nodePop2 = parent;
                        while (nodePop2 != null) {
                            RotaryInputModifierNode rotaryInputModifierNode5 = rotaryInputModifierNode4;
                            if (nodePop2 instanceof RotaryInputModifierNode) {
                                Modifier.Node node9 = nodePop2;
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(node9);
                                i7 = iM5778constructorimpl2;
                                node5 = parent;
                            } else if (((nodePop2.getKindSet() & iM5778constructorimpl2) != 0) && (nodePop2 instanceof DelegatingNode)) {
                                int i12 = 0;
                                Modifier.Node delegate2 = ((DelegatingNode) nodePop2).getDelegate();
                                while (delegate2 != null) {
                                    Modifier.Node node10 = delegate2;
                                    if ((node10.getKindSet() & iM5778constructorimpl2) != 0) {
                                        i12++;
                                        i8 = iM5778constructorimpl2;
                                        if (i12 == 1) {
                                            nodePop2 = node10;
                                            node6 = parent;
                                        } else {
                                            if (mutableVector6 == null) {
                                                i9 = i12;
                                                node6 = parent;
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            } else {
                                                i9 = i12;
                                                node6 = parent;
                                                mutableVector3 = mutableVector6;
                                            }
                                            Modifier.Node node11 = nodePop2;
                                            if (node11 != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(node11);
                                                }
                                                nodePop2 = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(node10);
                                            }
                                            mutableVector6 = mutableVector3;
                                            i12 = i9;
                                        }
                                    } else {
                                        i8 = iM5778constructorimpl2;
                                        node6 = parent;
                                    }
                                    delegate2 = delegate2.getChild();
                                    iM5778constructorimpl2 = i8;
                                    parent = node6;
                                }
                                i7 = iM5778constructorimpl2;
                                node5 = parent;
                                if (i12 == 1) {
                                    rotaryInputModifierNode4 = rotaryInputModifierNode5;
                                    iM5778constructorimpl2 = i7;
                                    parent = node5;
                                }
                            } else {
                                i7 = iM5778constructorimpl2;
                                node5 = parent;
                            }
                            nodePop2 = DelegatableNodeKt.pop(mutableVector6);
                            rotaryInputModifierNode4 = rotaryInputModifierNode5;
                            iM5778constructorimpl2 = i7;
                            parent = node5;
                        }
                    }
                    parent = parent.getParent();
                    rotaryInputModifierNode4 = rotaryInputModifierNode4;
                    iM5778constructorimpl2 = iM5778constructorimpl2;
                }
                rotaryInputModifierNode2 = rotaryInputModifierNode4;
                i6 = iM5778constructorimpl2;
            } else {
                rotaryInputModifierNode2 = rotaryInputModifierNode4;
                i6 = iM5778constructorimpl2;
            }
            layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui_release();
            parent = (layoutNodeRequireLayoutNode2 == null || (nodes = layoutNodeRequireLayoutNode2.getNodes()) == null) ? null : nodes.getTail();
            rotaryInputModifierNode4 = rotaryInputModifierNode2;
            iM5778constructorimpl2 = i6;
        }
        RotaryInputModifierNode rotaryInputModifierNode6 = rotaryInputModifierNode4;
        int i13 = iM5778constructorimpl2;
        if (arrayList != null) {
            List list = arrayList;
            int size = list.size() - 1;
            if (size >= 0) {
                do {
                    int i14 = size;
                    size--;
                    if (((RotaryInputModifierNode) list.get(i14)).onPreRotaryScrollEvent(event)) {
                        return true;
                    }
                } while (size >= 0);
            }
        }
        Modifier.Node node12 = rotaryInputModifierNode6.getNode();
        int i15 = 0;
        MutableVector mutableVector7 = null;
        Modifier.Node nodePop3 = node12;
        while (nodePop3 != null) {
            if (nodePop3 instanceof RotaryInputModifierNode) {
                if (((RotaryInputModifierNode) nodePop3).onPreRotaryScrollEvent(event)) {
                    return true;
                }
                node3 = node12;
                i4 = i15;
            } else if (((nodePop3.getKindSet() & i13) != 0) && (nodePop3 instanceof DelegatingNode)) {
                int i16 = 0;
                Modifier.Node delegate3 = ((DelegatingNode) nodePop3).getDelegate();
                while (delegate3 != null) {
                    Modifier.Node node13 = delegate3;
                    if ((node13.getKindSet() & i13) != 0) {
                        i16++;
                        if (i16 == 1) {
                            nodePop3 = node13;
                            node4 = node12;
                            i5 = i15;
                        } else {
                            if (mutableVector7 == null) {
                                node4 = node12;
                                i5 = i15;
                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                            } else {
                                node4 = node12;
                                i5 = i15;
                                mutableVector2 = mutableVector7;
                            }
                            mutableVector7 = mutableVector2;
                            Modifier.Node node14 = nodePop3;
                            if (node14 != null) {
                                if (mutableVector7 != null) {
                                    mutableVector7.add(node14);
                                }
                                nodePop3 = null;
                            }
                            if (mutableVector7 != null) {
                                mutableVector7.add(node13);
                            }
                        }
                    } else {
                        node4 = node12;
                        i5 = i15;
                    }
                    delegate3 = delegate3.getChild();
                    node12 = node4;
                    i15 = i5;
                }
                node3 = node12;
                i4 = i15;
                MutableVector mutableVector8 = mutableVector7;
                if (i16 == 1) {
                    node12 = node3;
                    i15 = i4;
                    mutableVector7 = mutableVector8;
                } else {
                    mutableVector7 = mutableVector8;
                }
            } else {
                node3 = node12;
                i4 = i15;
            }
            nodePop3 = DelegatableNodeKt.pop(mutableVector7);
            node12 = node3;
            i15 = i4;
        }
        Modifier.Node node15 = rotaryInputModifierNode6.getNode();
        int i17 = 0;
        MutableVector mutableVector9 = null;
        Modifier.Node nodePop4 = node15;
        while (nodePop4 != null) {
            if (nodePop4 instanceof RotaryInputModifierNode) {
                if (((RotaryInputModifierNode) nodePop4).onRotaryScrollEvent(event)) {
                    return true;
                }
                node = node15;
                i2 = i17;
            } else if (((nodePop4.getKindSet() & i13) != 0) && (nodePop4 instanceof DelegatingNode)) {
                int i18 = 0;
                Modifier.Node delegate4 = ((DelegatingNode) nodePop4).getDelegate();
                while (delegate4 != null) {
                    Modifier.Node node16 = delegate4;
                    if ((node16.getKindSet() & i13) != 0) {
                        i18++;
                        if (i18 == 1) {
                            nodePop4 = node16;
                            node2 = node15;
                            i3 = i17;
                        } else {
                            if (mutableVector9 == null) {
                                node2 = node15;
                                i3 = i17;
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            } else {
                                node2 = node15;
                                i3 = i17;
                                mutableVector = mutableVector9;
                            }
                            mutableVector9 = mutableVector;
                            Modifier.Node node17 = nodePop4;
                            if (node17 != null) {
                                if (mutableVector9 != null) {
                                    mutableVector9.add(node17);
                                }
                                nodePop4 = null;
                            }
                            if (mutableVector9 != null) {
                                mutableVector9.add(node16);
                            }
                        }
                    } else {
                        node2 = node15;
                        i3 = i17;
                    }
                    delegate4 = delegate4.getChild();
                    node15 = node2;
                    i17 = i3;
                }
                node = node15;
                i2 = i17;
                MutableVector mutableVector10 = mutableVector9;
                if (i18 == 1) {
                    node15 = node;
                    i17 = i2;
                    mutableVector9 = mutableVector10;
                } else {
                    mutableVector9 = mutableVector10;
                }
            } else {
                node = node15;
                i2 = i17;
            }
            nodePop4 = DelegatableNodeKt.pop(mutableVector9);
            node15 = node;
            i17 = i2;
        }
        if (arrayList == null) {
            return false;
        }
        List list2 = arrayList;
        int size2 = list2.size();
        for (int i19 = 0; i19 < size2; i19++) {
            if (((RotaryInputModifierNode) list2.get(i19)).onRotaryScrollEvent(event)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusTargetNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusEventModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public void scheduleInvalidation(FocusPropertiesModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOwnerFocusState() {
        if (this.rootFocusNode.getFocusState() == FocusStateImpl.Inactive) {
            this.onClearFocusForOwner.invoke();
        }
    }

    /* renamed from: traverseAncestorsIncludingSelf-QFhIj7k, reason: not valid java name */
    private final /* synthetic */ <T extends DelegatableNode> void m3881traverseAncestorsIncludingSelfQFhIj7k(DelegatableNode $this$traverseAncestorsIncludingSelf_u2dQFhIj7k, int type, Function1<? super T, Unit> function1, Function0<Unit> function0, Function1<? super T, Unit> function12) {
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv;
        int i;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv2;
        int i2;
        List ancestors;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv3;
        List ancestors2;
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv4;
        int size;
        int i3;
        DelegatableNode $this$ancestors_u2d64DMado$iv;
        int i4;
        NodeChain nodes;
        int i5;
        DelegatableNode $this$ancestors_u2d64DMado$iv2;
        int i6;
        DelegatableNode $this$ancestors_u2d64DMado$iv3;
        int i7;
        int i8;
        Object result$iv;
        int count$iv$iv$iv;
        Function1<? super T, Unit> function13 = function1;
        int count$iv$iv$iv2 = 0;
        DelegatableNode $this$ancestors_u2d64DMado$iv4 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k;
        int i9 = 0;
        Object result$iv2 = null;
        if (!$this$ancestors_u2d64DMado$iv4.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node node$iv$iv$iv = $this$ancestors_u2d64DMado$iv4.getNode().getParent();
        LayoutNode layout$iv$iv$iv = DelegatableNodeKt.requireLayoutNode($this$ancestors_u2d64DMado$iv4);
        while (layout$iv$iv$iv != null) {
            Modifier.Node head$iv$iv$iv = layout$iv$iv$iv.getNodes().getHead();
            if ((head$iv$iv$iv.getAggregateChildKindSet() & type) != 0) {
                while (node$iv$iv$iv != null) {
                    if ((node$iv$iv$iv.getKindSet() & type) != 0) {
                        Modifier.Node it$iv$iv = node$iv$iv$iv;
                        Object stack$iv$iv$iv = null;
                        Modifier.Node this_$iv$iv$iv$iv = it$iv$iv;
                        while (this_$iv$iv$iv$iv != null) {
                            int i10 = count$iv$iv$iv2;
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if (this_$iv$iv$iv$iv instanceof Object) {
                                Modifier.Node node = this_$iv$iv$iv$iv;
                                if (result$iv2 == null) {
                                    Object result$iv3 = new ArrayList();
                                    result$iv2 = (List) result$iv3;
                                }
                                $this$ancestors_u2d64DMado$iv3 = $this$ancestors_u2d64DMado$iv4;
                                ((List) result$iv2).add(node);
                                i7 = i9;
                            } else {
                                $this$ancestors_u2d64DMado$iv3 = $this$ancestors_u2d64DMado$iv4;
                                if (((this_$iv$iv$iv$iv.getKindSet() & type) != 0) && (this_$iv$iv$iv$iv instanceof DelegatingNode)) {
                                    int count$iv$iv$iv3 = 0;
                                    DelegatingNode this_$iv$iv$iv$iv2 = (DelegatingNode) this_$iv$iv$iv$iv;
                                    Modifier.Node node$iv$iv$iv$iv = this_$iv$iv$iv$iv2.getDelegate();
                                    while (node$iv$iv$iv$iv != null) {
                                        DelegatingNode this_$iv$iv$iv$iv3 = this_$iv$iv$iv$iv2;
                                        Modifier.Node next$iv$iv$iv = node$iv$iv$iv$iv;
                                        if ((next$iv$iv$iv.getKindSet() & type) != 0) {
                                            count$iv$iv$iv3++;
                                            i8 = i9;
                                            if (count$iv$iv$iv3 == 1) {
                                                this_$iv$iv$iv$iv = next$iv$iv$iv;
                                                result$iv = result$iv2;
                                            } else {
                                                Object mutableVector = (MutableVector) stack$iv$iv$iv;
                                                if (mutableVector == null) {
                                                    count$iv$iv$iv = count$iv$iv$iv3;
                                                    result$iv = result$iv2;
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                } else {
                                                    count$iv$iv$iv = count$iv$iv$iv3;
                                                    result$iv = result$iv2;
                                                }
                                                stack$iv$iv$iv = mutableVector;
                                                Modifier.Node theNode$iv$iv$iv = this_$iv$iv$iv$iv;
                                                if (theNode$iv$iv$iv != null) {
                                                    MutableVector mutableVector2 = (MutableVector) stack$iv$iv$iv;
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(theNode$iv$iv$iv);
                                                    }
                                                    this_$iv$iv$iv$iv = null;
                                                }
                                                MutableVector mutableVector3 = (MutableVector) stack$iv$iv$iv;
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(next$iv$iv$iv);
                                                }
                                                count$iv$iv$iv3 = count$iv$iv$iv;
                                            }
                                        } else {
                                            i8 = i9;
                                            result$iv = result$iv2;
                                        }
                                        node$iv$iv$iv$iv = node$iv$iv$iv$iv.getChild();
                                        this_$iv$iv$iv$iv2 = this_$iv$iv$iv$iv3;
                                        i9 = i8;
                                        result$iv2 = result$iv;
                                    }
                                    i7 = i9;
                                    Object result$iv4 = result$iv2;
                                    if (count$iv$iv$iv3 == 1) {
                                        count$iv$iv$iv2 = i10;
                                        $this$ancestors_u2d64DMado$iv4 = $this$ancestors_u2d64DMado$iv3;
                                        i9 = i7;
                                        result$iv2 = result$iv4;
                                    } else {
                                        result$iv2 = result$iv4;
                                    }
                                } else {
                                    i7 = i9;
                                    result$iv2 = result$iv2;
                                }
                            }
                            this_$iv$iv$iv$iv = DelegatableNodeKt.pop((MutableVector) stack$iv$iv$iv);
                            count$iv$iv$iv2 = i10;
                            $this$ancestors_u2d64DMado$iv4 = $this$ancestors_u2d64DMado$iv3;
                            i9 = i7;
                        }
                        i5 = count$iv$iv$iv2;
                        $this$ancestors_u2d64DMado$iv2 = $this$ancestors_u2d64DMado$iv4;
                        i6 = i9;
                    } else {
                        i5 = count$iv$iv$iv2;
                        $this$ancestors_u2d64DMado$iv2 = $this$ancestors_u2d64DMado$iv4;
                        i6 = i9;
                    }
                    node$iv$iv$iv = node$iv$iv$iv.getParent();
                    count$iv$iv$iv2 = i5;
                    $this$ancestors_u2d64DMado$iv4 = $this$ancestors_u2d64DMado$iv2;
                    i9 = i6;
                }
                i3 = count$iv$iv$iv2;
                $this$ancestors_u2d64DMado$iv = $this$ancestors_u2d64DMado$iv4;
                i4 = i9;
            } else {
                i3 = count$iv$iv$iv2;
                $this$ancestors_u2d64DMado$iv = $this$ancestors_u2d64DMado$iv4;
                i4 = i9;
            }
            layout$iv$iv$iv = layout$iv$iv$iv.getParent$ui_release();
            node$iv$iv$iv = (layout$iv$iv$iv == null || (nodes = layout$iv$iv$iv.getNodes()) == null) ? null : nodes.getTail();
            count$iv$iv$iv2 = i3;
            $this$ancestors_u2d64DMado$iv4 = $this$ancestors_u2d64DMado$iv;
            i9 = i4;
        }
        List ancestors3 = (List) result$iv2;
        if (ancestors3 != null && ancestors3.size() - 1 >= 0) {
            do {
                int index$iv = size;
                size--;
                Object item$iv = ancestors3.get(index$iv);
                function13.invoke(item$iv);
            } while (size >= 0);
        }
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv5 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k.getNode();
        Object stack$iv = null;
        Modifier.Node node$iv = $this$dispatchForKind_u2d6rFNWt0$iv5;
        while (node$iv != null) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (node$iv instanceof Object) {
                function13.invoke(node$iv);
                ancestors = ancestors3;
                $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv5;
            } else {
                Modifier.Node this_$iv$iv = node$iv;
                if (((this_$iv$iv.getKindSet() & type) != 0) && (node$iv instanceof DelegatingNode)) {
                    int count$iv = 0;
                    DelegatingNode this_$iv$iv2 = (DelegatingNode) node$iv;
                    Modifier.Node node$iv$iv = this_$iv$iv2.getDelegate();
                    while (node$iv$iv != null) {
                        Modifier.Node next$iv = node$iv$iv;
                        if ((next$iv.getKindSet() & type) != 0) {
                            count$iv++;
                            if (count$iv == 1) {
                                node$iv = next$iv;
                                ancestors2 = ancestors3;
                                $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                            } else {
                                Object obj = (MutableVector) stack$iv;
                                if (obj == null) {
                                    ancestors2 = ancestors3;
                                    $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                                    Object mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                    obj = mutableVector4;
                                } else {
                                    ancestors2 = ancestors3;
                                    $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                                }
                                stack$iv = obj;
                                Modifier.Node theNode$iv = node$iv;
                                if (theNode$iv != null) {
                                    MutableVector mutableVector5 = (MutableVector) stack$iv;
                                    if (mutableVector5 != null) {
                                        mutableVector5.add(theNode$iv);
                                    }
                                    node$iv = null;
                                }
                                MutableVector mutableVector6 = (MutableVector) stack$iv;
                                if (mutableVector6 != null) {
                                    mutableVector6.add(next$iv);
                                }
                            }
                        } else {
                            ancestors2 = ancestors3;
                            $this$dispatchForKind_u2d6rFNWt0$iv4 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                        }
                        node$iv$iv = node$iv$iv.getChild();
                        ancestors3 = ancestors2;
                        $this$dispatchForKind_u2d6rFNWt0$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv4;
                    }
                    ancestors = ancestors3;
                    $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                    if (count$iv == 1) {
                        function13 = function1;
                        ancestors3 = ancestors;
                        $this$dispatchForKind_u2d6rFNWt0$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv3;
                    }
                } else {
                    ancestors = ancestors3;
                    $this$dispatchForKind_u2d6rFNWt0$iv3 = $this$dispatchForKind_u2d6rFNWt0$iv5;
                }
            }
            node$iv = DelegatableNodeKt.pop((MutableVector) stack$iv);
            function13 = function1;
            ancestors3 = ancestors;
            $this$dispatchForKind_u2d6rFNWt0$iv5 = $this$dispatchForKind_u2d6rFNWt0$iv3;
        }
        List ancestors4 = ancestors3;
        function0.invoke();
        Modifier.Node $this$dispatchForKind_u2d6rFNWt0$iv6 = $this$traverseAncestorsIncludingSelf_u2dQFhIj7k.getNode();
        int i11 = 0;
        Object stack$iv2 = null;
        Modifier.Node node$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv6;
        while (node$iv2 != null) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (node$iv2 instanceof Object) {
                function12.invoke(node$iv2);
                $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv6;
                i = i11;
            } else {
                Modifier.Node this_$iv$iv3 = node$iv2;
                if (((this_$iv$iv3.getKindSet() & type) != 0) && (node$iv2 instanceof DelegatingNode)) {
                    int count$iv2 = 0;
                    DelegatingNode this_$iv$iv4 = (DelegatingNode) node$iv2;
                    Modifier.Node node$iv$iv2 = this_$iv$iv4.getDelegate();
                    while (node$iv$iv2 != null) {
                        Modifier.Node next$iv2 = node$iv$iv2;
                        if ((next$iv2.getKindSet() & type) != 0) {
                            count$iv2++;
                            if (count$iv2 == 1) {
                                node$iv2 = next$iv2;
                                $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv6;
                                i2 = i11;
                            } else {
                                Object obj2 = (MutableVector) stack$iv2;
                                if (obj2 == null) {
                                    $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv6;
                                    i2 = i11;
                                    Object mutableVector7 = new MutableVector(new Modifier.Node[16], 0);
                                    obj2 = mutableVector7;
                                } else {
                                    $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv6;
                                    i2 = i11;
                                }
                                stack$iv2 = obj2;
                                Modifier.Node theNode$iv2 = node$iv2;
                                if (theNode$iv2 != null) {
                                    MutableVector mutableVector8 = (MutableVector) stack$iv2;
                                    if (mutableVector8 != null) {
                                        mutableVector8.add(theNode$iv2);
                                    }
                                    node$iv2 = null;
                                }
                                MutableVector mutableVector9 = (MutableVector) stack$iv2;
                                if (mutableVector9 != null) {
                                    mutableVector9.add(next$iv2);
                                }
                            }
                        } else {
                            $this$dispatchForKind_u2d6rFNWt0$iv2 = $this$dispatchForKind_u2d6rFNWt0$iv6;
                            i2 = i11;
                        }
                        node$iv$iv2 = node$iv$iv2.getChild();
                        $this$dispatchForKind_u2d6rFNWt0$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv2;
                        i11 = i2;
                    }
                    $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv6;
                    i = i11;
                    if (count$iv2 == 1) {
                        $this$dispatchForKind_u2d6rFNWt0$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv;
                        i11 = i;
                    }
                } else {
                    $this$dispatchForKind_u2d6rFNWt0$iv = $this$dispatchForKind_u2d6rFNWt0$iv6;
                    i = i11;
                }
            }
            node$iv2 = DelegatableNodeKt.pop((MutableVector) stack$iv2);
            $this$dispatchForKind_u2d6rFNWt0$iv6 = $this$dispatchForKind_u2d6rFNWt0$iv;
            i11 = i;
        }
        if (ancestors4 != null) {
            int size2 = ancestors4.size();
            for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
                Object item$iv2 = ancestors4.get(index$iv2);
                function12.invoke(item$iv2);
            }
        }
    }

    /* renamed from: nearestAncestorIncludingSelf-64DMado, reason: not valid java name */
    private final /* synthetic */ <T> T m3880nearestAncestorIncludingSelf64DMado(DelegatableNode delegatableNode, int i) {
        int i2;
        boolean z;
        DelegatableNode delegatableNode2;
        int i3;
        int i4;
        Modifier.Node node;
        NodeChain nodes;
        int i5;
        boolean z2;
        DelegatableNode delegatableNode3;
        int i6;
        int i7;
        DelegatableNode delegatableNode4;
        int i8;
        int i9;
        DelegatableNode delegatableNode5;
        int i10;
        int i11;
        int i12;
        int i13 = 0;
        boolean z3 = true;
        DelegatableNode delegatableNode6 = delegatableNode;
        int i14 = 0;
        int i15 = i;
        if (!delegatableNode6.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node node2 = delegatableNode6.getNode();
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode6);
        while (layoutNodeRequireLayoutNode != null) {
            if ((layoutNodeRequireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & i15) != 0) {
                while (node2 != null) {
                    if ((node2.getKindSet() & i15) != 0) {
                        Object obj = null;
                        Modifier.Node nodePop = node2;
                        while (nodePop != null) {
                            int i16 = i13;
                            boolean z4 = z3;
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if (nodePop instanceof Object) {
                                return (T) nodePop;
                            }
                            if (((nodePop.getKindSet() & i) != 0 ? 1 : 0) == 0 || !(nodePop instanceof DelegatingNode)) {
                                delegatableNode4 = delegatableNode6;
                                i8 = i14;
                                i9 = i15;
                                nodePop = DelegatableNodeKt.pop((MutableVector) obj);
                                i13 = i16;
                                z3 = z4;
                                delegatableNode6 = delegatableNode4;
                                i14 = i8;
                                i15 = i9;
                            } else {
                                int i17 = 0;
                                Modifier.Node delegate = ((DelegatingNode) nodePop).getDelegate();
                                while (delegate != null) {
                                    Modifier.Node node3 = delegate;
                                    if ((node3.getKindSet() & i) != 0) {
                                        i17++;
                                        delegatableNode5 = delegatableNode6;
                                        if (i17 == 1) {
                                            nodePop = node3;
                                            i10 = i14;
                                            i11 = i15;
                                        } else {
                                            MutableVector mutableVector = (MutableVector) obj;
                                            if (mutableVector == null) {
                                                i12 = i17;
                                                i10 = i14;
                                                i11 = i15;
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            } else {
                                                i12 = i17;
                                                i10 = i14;
                                                i11 = i15;
                                            }
                                            obj = mutableVector;
                                            Modifier.Node node4 = nodePop;
                                            if (node4 != null) {
                                                MutableVector mutableVector2 = (MutableVector) obj;
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(node4);
                                                }
                                                nodePop = null;
                                            }
                                            MutableVector mutableVector3 = (MutableVector) obj;
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(node3);
                                            }
                                            i17 = i12;
                                        }
                                    } else {
                                        delegatableNode5 = delegatableNode6;
                                        i10 = i14;
                                        i11 = i15;
                                    }
                                    delegate = delegate.getChild();
                                    delegatableNode6 = delegatableNode5;
                                    i14 = i10;
                                    i15 = i11;
                                }
                                delegatableNode4 = delegatableNode6;
                                i8 = i14;
                                i9 = i15;
                                if (i17 == 1) {
                                    i13 = i16;
                                    z3 = z4;
                                    delegatableNode6 = delegatableNode4;
                                    i14 = i8;
                                    i15 = i9;
                                } else {
                                    nodePop = DelegatableNodeKt.pop((MutableVector) obj);
                                    i13 = i16;
                                    z3 = z4;
                                    delegatableNode6 = delegatableNode4;
                                    i14 = i8;
                                    i15 = i9;
                                }
                            }
                        }
                        i5 = i13;
                        z2 = z3;
                        delegatableNode3 = delegatableNode6;
                        i6 = i14;
                        i7 = i15;
                    } else {
                        i5 = i13;
                        z2 = z3;
                        delegatableNode3 = delegatableNode6;
                        i6 = i14;
                        i7 = i15;
                    }
                    node2 = node2.getParent();
                    i13 = i5;
                    z3 = z2;
                    delegatableNode6 = delegatableNode3;
                    i14 = i6;
                    i15 = i7;
                }
                i2 = i13;
                z = z3;
                delegatableNode2 = delegatableNode6;
                i3 = i14;
                i4 = i15;
                node = null;
            } else {
                i2 = i13;
                z = z3;
                delegatableNode2 = delegatableNode6;
                i3 = i14;
                i4 = i15;
                node = null;
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            node2 = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? node : nodes.getTail();
            i13 = i2;
            z3 = z;
            delegatableNode6 = delegatableNode2;
            i14 = i3;
            i15 = i4;
        }
        return null;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public Rect getFocusRect() {
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (focusTargetNodeFindActiveFocusNode != null) {
            return FocusTraversalKt.focusRect(focusTargetNodeFindActiveFocusNode);
        }
        return null;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public FocusState getRootState() {
        return this.rootFocusNode.getFocusState();
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode $this$lastLocalKeyInputNode) {
        Modifier.Node node = null;
        int mask$iv = NodeKind.m5778constructorimpl(1024) | NodeKind.m5778constructorimpl(8192);
        boolean value$iv$iv$iv = $this$lastLocalKeyInputNode.getNode().getIsAttached();
        if (!value$iv$iv$iv) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node self$iv$iv = $this$lastLocalKeyInputNode.getNode();
        if ((self$iv$iv.getAggregateChildKindSet() & mask$iv) != 0) {
            for (Modifier.Node next$iv$iv = self$iv$iv.getChild(); next$iv$iv != null; next$iv$iv = next$iv$iv.getChild()) {
                if ((next$iv$iv.getKindSet() & mask$iv) != 0) {
                    Modifier.Node modifierNode = next$iv$iv;
                    if ((modifierNode.getKindSet() & NodeKind.m5778constructorimpl(1024)) != 0) {
                        return node;
                    }
                    node = modifierNode;
                }
            }
        }
        return node;
    }

    /* renamed from: validateKeyEvent-ZmokQxo, reason: not valid java name */
    private final boolean m3882validateKeyEventZmokQxo(KeyEvent keyEvent) {
        long keyCode = KeyEvent_androidKt.m5257getKeyZmokQxo(keyEvent);
        int iM5258getTypeZmokQxo = KeyEvent_androidKt.m5258getTypeZmokQxo(keyEvent);
        if (KeyEventType.m5250equalsimpl0(iM5258getTypeZmokQxo, KeyEventType.INSTANCE.m5254getKeyDownCS__XNY())) {
            MutableLongSet it = this.keysCurrentlyDown;
            if (it == null) {
                it = new MutableLongSet(3);
                this.keysCurrentlyDown = it;
            }
            it.plusAssign(keyCode);
        } else if (KeyEventType.m5250equalsimpl0(iM5258getTypeZmokQxo, KeyEventType.INSTANCE.m5255getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (!(mutableLongSet != null && mutableLongSet.contains(keyCode))) {
                return false;
            }
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (mutableLongSet2 != null) {
                mutableLongSet2.remove(keyCode);
            }
        }
        return true;
    }
}
