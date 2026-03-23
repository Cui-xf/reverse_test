package androidx.compose.ui.node;

import androidx.collection.MutableObjectFloatMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.Ruler;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LookaheadDelegate.kt */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000 e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001eB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010?\u001a\u00020@2\u0006\u0010!\u001a\u00020\"2\u0006\u0010A\u001a\u000205H\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH&J\u0017\u0010F\u001a\u00020@2\b\u0010G\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0002\bHJ\u0010\u0010F\u001a\u00020@2\u0006\u0010I\u001a\u00020JH\u0002J\u0010\u0010K\u001a\u00020\u00002\u0006\u0010A\u001a\u000205H\u0002J\u0016\u0010L\u001a\u00020M2\u0006\u0010A\u001a\u0002052\u0006\u0010N\u001a\u00020MJ\u0011\u0010O\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0086\u0002J\u0010\u0010P\u001a\u00020@2\u0006\u0010A\u001a\u000205H\u0002J`\u0010Q\u001a\u00020&2\u0006\u0010R\u001a\u00020C2\u0006\u0010S\u001a\u00020C2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020C0U2\u0019\u0010V\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020@\u0018\u00010W¢\u0006\u0002\bX2\u0017\u0010Y\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020@0W¢\u0006\u0002\bXH\u0016J&\u0010Z\u001a\u00020@2\u001c\u0010[\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\"07j\b\u0012\u0004\u0012\u00020\"`806H\u0002J\u0016\u0010\\\u001a\u00020@2\u0006\u0010A\u001a\u0002052\u0006\u0010]\u001a\u00020MJ\u0016\u0010^\u001a\u00020@2\u0006\u0010A\u001a\u0002052\u0006\u0010]\u001a\u00020MJ\r\u0010_\u001a\u00020@H ¢\u0006\u0002\b`J\f\u0010a\u001a\u00020@*\u00020bH\u0004J\u0014\u0010c\u001a\u00020\u0013*\u00020\"2\u0006\u0010d\u001a\u00020\"H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u001aR\u0012\u0010!\u001a\u00020\"X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0012\u0010%\u001a\u00020&X \u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\rR\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0018\u0010/\u001a\u000200X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b1\u00102R2\u00103\u001a&\u0012\u0004\u0012\u000205\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\"07j\b\u0012\u0004\u0012\u00020\"`806\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00109\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0016\u0010<\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010>\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006f"}, d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/MeasureScopeWithLayoutNode;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "()V", "_rulerScope", "Landroidx/compose/ui/layout/RulerScope;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "isLookingAhead", "isLookingAhead$annotations", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "(Z)V", "isPlacingForAlignment", "isPlacingForAlignment$ui_release", "setPlacingForAlignment$ui_release", "isShallowPlacing", "isShallowPlacing$ui_release", "setShallowPlacing$ui_release", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "parent", "getParent", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "position", "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "()J", "rulerReaders", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/Ruler;", "Landroidx/collection/MutableScatterSet;", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/node/WeakReference;", "rulerScope", "getRulerScope", "()Landroidx/compose/ui/layout/RulerScope;", "rulerValues", "Landroidx/collection/MutableObjectFloatMap;", "rulerValuesCache", "addRulerReader", "", "ruler", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "captureRulers", "result", "captureRulers$ui_release", "placeableResult", "Landroidx/compose/ui/node/PlaceableResult;", "findAncestorRulerDefiner", "findRulerValue", "", "defaultValue", "get", "invalidateChildrenOfDefiningRuler", "layout", "width", "height", "alignmentLines", "", "rulers", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "placementBlock", "notifyRulerValueChange", "layoutNodes", "provideRelativeRulerValue", "value", "provideRulerValue", "replace", "replace$ui_release", "invalidateAlignmentLinesFromPositionChange", "Landroidx/compose/ui/node/NodeCoordinator;", "isLayoutNodeAncestor", "ancestor", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LookaheadCapablePlaceable extends Placeable implements MeasureScopeWithLayoutNode, MotionReferencePlacementDelegate {
    public static final int $stable = 0;
    private static final Function1<PlaceableResult, Unit> onCommitAffectingRuler = new Function1<PlaceableResult, Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$Companion$onCommitAffectingRuler$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PlaceableResult placeableResult) {
            invoke2(placeableResult);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PlaceableResult result) {
            if (result.isValidOwnerScope()) {
                result.getPlaceable().captureRulers(result);
            }
        }
    };
    private RulerScope _rulerScope;
    private boolean isPlacedUnderMotionFrameOfReference;
    private boolean isPlacingForAlignment;
    private boolean isShallowPlacing;
    private final Placeable.PlacementScope placementScope = PlaceableKt.PlacementScope(this);
    private MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> rulerReaders;
    private MutableObjectFloatMap<Ruler> rulerValues;
    private MutableObjectFloatMap<Ruler> rulerValuesCache;

    public static /* synthetic */ void isLookingAhead$annotations() {
    }

    public abstract int calculateAlignmentLine(AlignmentLine alignmentLine);

    public abstract AlignmentLinesOwner getAlignmentLinesOwner();

    public abstract LookaheadCapablePlaceable getChild();

    public abstract LayoutCoordinates getCoordinates();

    public abstract boolean getHasMeasureResult();

    @Override // androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public abstract LayoutNode getLayoutNode();

    public abstract MeasureResult getMeasureResult$ui_release();

    public abstract LookaheadCapablePlaceable getParent();

    /* renamed from: getPosition-nOcc-ac, reason: not valid java name */
    public abstract long getPosition();

    @Override // androidx.compose.ui.layout.MeasureScope
    public /* synthetic */ MeasureResult layout(int i, int i2, Map map, Function1 function1) {
        return MeasureScope.CC.$default$layout(this, i, i2, map, function1);
    }

    public abstract void replace$ui_release();

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx--R2X_6o */
    public /* synthetic */ int mo360roundToPxR2X_6o(long j) {
        return Density.CC.m6657$default$roundToPxR2X_6o(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public /* synthetic */ int mo361roundToPx0680j_4(float f) {
        return Density.CC.m6658$default$roundToPx0680j_4(this, f);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* renamed from: toDp-GaN1DYA */
    public /* synthetic */ float mo362toDpGaN1DYA(long j) {
        return FontScaling.CC.m6802$default$toDpGaN1DYA(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo363toDpu2uoSUM(float f) {
        return Density.CC.m6659$default$toDpu2uoSUM(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo364toDpu2uoSUM(int i) {
        return Density.CC.m6660$default$toDpu2uoSUM((Density) this, i);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public /* synthetic */ long mo365toDpSizekrfVVM(long j) {
        return Density.CC.m6661$default$toDpSizekrfVVM(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public /* synthetic */ float mo366toPxR2X_6o(long j) {
        return Density.CC.m6662$default$toPxR2X_6o(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public /* synthetic */ float mo367toPx0680j_4(float f) {
        return Density.CC.m6663$default$toPx0680j_4(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return Density.CC.$default$toRect(this, dpRect);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public /* synthetic */ long mo368toSizeXkaWNTQ(long j) {
        return Density.CC.m6664$default$toSizeXkaWNTQ(this, j);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* renamed from: toSp-0xMU5do */
    public /* synthetic */ long mo369toSp0xMU5do(float f) {
        return FontScaling.CC.m6803$default$toSp0xMU5do(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo370toSpkPz2Gy4(float f) {
        return Density.CC.m6665$default$toSpkPz2Gy4(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo371toSpkPz2Gy4(int i) {
        return Density.CC.m6666$default$toSpkPz2Gy4((Density) this, i);
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    /* renamed from: isPlacedUnderMotionFrameOfReference, reason: from getter */
    public boolean getIsPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public void setPlacedUnderMotionFrameOfReference(boolean z) {
        this.isPlacedUnderMotionFrameOfReference = z;
    }

    public final RulerScope getRulerScope() {
        RulerScope rulerScope = this._rulerScope;
        return rulerScope == null ? new RulerScope() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$rulerScope$1
            @Override // androidx.compose.ui.unit.Density
            /* renamed from: roundToPx--R2X_6o */
            public /* synthetic */ int mo360roundToPxR2X_6o(long j) {
                return Density.CC.m6657$default$roundToPxR2X_6o(this, j);
            }

            @Override // androidx.compose.ui.unit.Density
            /* renamed from: roundToPx-0680j_4 */
            public /* synthetic */ int mo361roundToPx0680j_4(float f) {
                return Density.CC.m6658$default$roundToPx0680j_4(this, f);
            }

            @Override // androidx.compose.ui.unit.FontScaling
            /* renamed from: toDp-GaN1DYA */
            public /* synthetic */ float mo362toDpGaN1DYA(long j) {
                return FontScaling.CC.m6802$default$toDpGaN1DYA(this, j);
            }

            @Override // androidx.compose.ui.unit.Density
            /* renamed from: toDp-u2uoSUM */
            public /* synthetic */ float mo363toDpu2uoSUM(float f) {
                return Density.CC.m6659$default$toDpu2uoSUM(this, f);
            }

            @Override // androidx.compose.ui.unit.Density
            /* renamed from: toDp-u2uoSUM */
            public /* synthetic */ float mo364toDpu2uoSUM(int i) {
                return Density.CC.m6660$default$toDpu2uoSUM((Density) this, i);
            }

            @Override // androidx.compose.ui.unit.Density
            /* renamed from: toDpSize-k-rfVVM */
            public /* synthetic */ long mo365toDpSizekrfVVM(long j) {
                return Density.CC.m6661$default$toDpSizekrfVVM(this, j);
            }

            @Override // androidx.compose.ui.unit.Density
            /* renamed from: toPx--R2X_6o */
            public /* synthetic */ float mo366toPxR2X_6o(long j) {
                return Density.CC.m6662$default$toPxR2X_6o(this, j);
            }

            @Override // androidx.compose.ui.unit.Density
            /* renamed from: toPx-0680j_4 */
            public /* synthetic */ float mo367toPx0680j_4(float f) {
                return Density.CC.m6663$default$toPx0680j_4(this, f);
            }

            @Override // androidx.compose.ui.unit.Density
            public /* synthetic */ Rect toRect(DpRect dpRect) {
                return Density.CC.$default$toRect(this, dpRect);
            }

            @Override // androidx.compose.ui.unit.Density
            /* renamed from: toSize-XkaWNTQ */
            public /* synthetic */ long mo368toSizeXkaWNTQ(long j) {
                return Density.CC.m6664$default$toSizeXkaWNTQ(this, j);
            }

            @Override // androidx.compose.ui.unit.FontScaling
            /* renamed from: toSp-0xMU5do */
            public /* synthetic */ long mo369toSp0xMU5do(float f) {
                return FontScaling.CC.m6803$default$toSp0xMU5do(this, f);
            }

            @Override // androidx.compose.ui.unit.Density
            /* renamed from: toSp-kPz2Gy4 */
            public /* synthetic */ long mo370toSpkPz2Gy4(float f) {
                return Density.CC.m6665$default$toSpkPz2Gy4(this, f);
            }

            @Override // androidx.compose.ui.unit.Density
            /* renamed from: toSp-kPz2Gy4 */
            public /* synthetic */ long mo371toSpkPz2Gy4(int i) {
                return Density.CC.m6666$default$toSpkPz2Gy4((Density) this, i);
            }

            @Override // androidx.compose.ui.layout.RulerScope
            public LayoutCoordinates getCoordinates() {
                this.this$0.getLayoutNode().getLayoutDelegate().onCoordinatesUsed();
                return this.this$0.getCoordinates();
            }

            @Override // androidx.compose.ui.layout.RulerScope
            public void provides(Ruler $this$provides, float value) {
                this.this$0.provideRulerValue($this$provides, value);
            }

            @Override // androidx.compose.ui.layout.RulerScope
            public void providesRelative(VerticalRuler $this$providesRelative, float value) {
                this.this$0.provideRelativeRulerValue($this$providesRelative, value);
            }

            @Override // androidx.compose.ui.unit.Density
            public float getDensity() {
                return this.this$0.getDensity();
            }

            @Override // androidx.compose.ui.unit.FontScaling
            public float getFontScale() {
                return this.this$0.getFontScale();
            }
        } : rulerScope;
    }

    @Override // androidx.compose.ui.layout.Measured
    public final int get(AlignmentLine alignmentLine) {
        int measuredPosition;
        int iM6826getYimpl;
        if (!getHasMeasureResult() || (measuredPosition = calculateAlignmentLine(alignmentLine)) == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (alignmentLine instanceof VerticalAlignmentLine) {
            iM6826getYimpl = IntOffset.m6825getXimpl(getApparentToRealOffset());
        } else {
            iM6826getYimpl = IntOffset.m6826getYimpl(getApparentToRealOffset());
        }
        return iM6826getYimpl + measuredPosition;
    }

    /* renamed from: isShallowPlacing$ui_release, reason: from getter */
    public final boolean getIsShallowPlacing() {
        return this.isShallowPlacing;
    }

    public final void setShallowPlacing$ui_release(boolean z) {
        this.isShallowPlacing = z;
    }

    /* renamed from: isPlacingForAlignment$ui_release, reason: from getter */
    public final boolean getIsPlacingForAlignment() {
        return this.isPlacingForAlignment;
    }

    public final void setPlacingForAlignment$ui_release(boolean z) {
        this.isPlacingForAlignment = z;
    }

    public final Placeable.PlacementScope getPlacementScope() {
        return this.placementScope;
    }

    protected final void invalidateAlignmentLinesFromPositionChange(NodeCoordinator $this$invalidateAlignmentLinesFromPositionChange) {
        AlignmentLines alignmentLines;
        NodeCoordinator wrapped = $this$invalidateAlignmentLinesFromPositionChange.getWrapped();
        if (!Intrinsics.areEqual(wrapped != null ? wrapped.getLayoutNode() : null, $this$invalidateAlignmentLinesFromPositionChange.getLayoutNode())) {
            $this$invalidateAlignmentLinesFromPositionChange.getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            return;
        }
        AlignmentLinesOwner parentAlignmentLinesOwner = $this$invalidateAlignmentLinesFromPositionChange.getAlignmentLinesOwner().getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner == null || (alignmentLines = parentAlignmentLinesOwner.getAlignmentLines()) == null) {
            return;
        }
        alignmentLines.onAlignmentsChanged();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return false;
    }

    public final float findRulerValue(Ruler ruler, float defaultValue) {
        if (this.isPlacingForAlignment) {
            return defaultValue;
        }
        LookaheadCapablePlaceable p = this;
        while (true) {
            MutableObjectFloatMap<Ruler> mutableObjectFloatMap = p.rulerValues;
            float rulerValue = mutableObjectFloatMap != null ? mutableObjectFloatMap.getOrDefault(ruler, Float.NaN) : Float.NaN;
            if (!Float.isNaN(rulerValue)) {
                p.addRulerReader(getLayoutNode(), ruler);
                return ruler.calculateCoordinate$ui_release(rulerValue, p.getCoordinates(), getCoordinates());
            }
            LookaheadCapablePlaceable parent = p.getParent();
            if (parent == null) {
                p.addRulerReader(getLayoutNode(), ruler);
                return defaultValue;
            }
            p = parent;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void addRulerReader(androidx.compose.ui.node.LayoutNode r48, androidx.compose.ui.layout.Ruler r49) {
        /*
            Method dump skipped, instructions count: 525
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LookaheadCapablePlaceable.addRulerReader(androidx.compose.ui.node.LayoutNode, androidx.compose.ui.layout.Ruler):void");
    }

    private final LookaheadCapablePlaceable findAncestorRulerDefiner(Ruler ruler) {
        LookaheadCapablePlaceable p = this;
        while (true) {
            MutableObjectFloatMap<Ruler> mutableObjectFloatMap = p.rulerValues;
            boolean z = false;
            if (mutableObjectFloatMap != null && mutableObjectFloatMap.contains(ruler)) {
                z = true;
            }
            if (z) {
                return p;
            }
            LookaheadCapablePlaceable parent = p.getParent();
            if (parent == null) {
                return p;
            }
            p = parent;
        }
    }

    private final boolean isLayoutNodeAncestor(LayoutNode $this$isLayoutNodeAncestor, LayoutNode ancestor) {
        if ($this$isLayoutNodeAncestor == ancestor) {
            return true;
        }
        LayoutNode parent$ui_release = $this$isLayoutNodeAncestor.getParent$ui_release();
        if (parent$ui_release != null) {
            return isLayoutNodeAncestor(parent$ui_release, ancestor);
        }
        return false;
    }

    private final void invalidateChildrenOfDefiningRuler(Ruler ruler) {
        LookaheadCapablePlaceable definer = findAncestorRulerDefiner(ruler);
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = definer.rulerReaders;
        MutableScatterSet readers = mutableScatterMap != null ? mutableScatterMap.remove(ruler) : null;
        if (readers != null) {
            notifyRulerValueChange(readers);
        }
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult layout(final int width, final int height, final Map<AlignmentLine, Integer> alignmentLines, final Function1<? super RulerScope, Unit> rulers, final Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        boolean value$iv$iv = (width & ViewCompat.MEASURED_STATE_MASK) == 0 && ((-16777216) & height) == 0;
        if (!value$iv$iv) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + width + " x " + height + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable.layout.1
            @Override // androidx.compose.ui.layout.MeasureResult
            /* renamed from: getWidth, reason: from getter */
            public int get$width() {
                return width;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            /* renamed from: getHeight, reason: from getter */
            public int get$height() {
                return height;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return alignmentLines;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Function1<RulerScope, Unit> getRulers() {
                return rulers;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void placeChildren() {
                placementBlock.invoke(this.getPlacementScope());
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void captureRulers$ui_release(androidx.compose.ui.layout.MeasureResult r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            if (r1 == 0) goto L10
            androidx.compose.ui.node.PlaceableResult r2 = new androidx.compose.ui.node.PlaceableResult
            r2.<init>(r1, r0)
            r0.captureRulers(r2)
            goto L95
        L10:
            androidx.collection.MutableScatterMap<androidx.compose.ui.layout.Ruler, androidx.collection.MutableScatterSet<java.lang.ref.WeakReference<androidx.compose.ui.node.LayoutNode>>> r2 = r0.rulerReaders
            if (r2 == 0) goto L87
            androidx.collection.ScatterMap r2 = (androidx.collection.ScatterMap) r2
            r3 = 0
            java.lang.Object[] r4 = r2.values
            r5 = r2
            r6 = 0
            long[] r7 = r5.metadata
            int r8 = r7.length
            int r8 = r8 + (-2)
            r9 = 0
            if (r9 > r8) goto L84
        L23:
            r10 = r7[r9]
            r12 = r10
            r14 = 0
            r15 = r2
            long r1 = ~r12
            r16 = 7
            long r1 = r1 << r16
            long r1 = r1 & r12
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r1 = r1 & r16
            int r12 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r12 == 0) goto L7c
            int r1 = r9 - r8
            int r1 = ~r1
            int r1 = r1 >>> 31
            r2 = 8
            int r1 = 8 - r1
            r12 = 0
        L43:
            if (r12 >= r1) goto L76
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r10
            r16 = 0
            r17 = 128(0x80, double:6.3E-322)
            int r19 = (r13 > r17 ? 1 : (r13 == r17 ? 0 : -1))
            if (r19 >= 0) goto L53
            r17 = 1
            goto L55
        L53:
            r17 = 0
        L55:
            if (r17 == 0) goto L6d
            int r13 = r9 << 3
            int r13 = r13 + r12
            r14 = r13
            r16 = 0
            r17 = r4[r14]
            r18 = 8
            r2 = r17
            androidx.collection.MutableScatterSet r2 = (androidx.collection.MutableScatterSet) r2
            r17 = 0
            r0.notifyRulerValueChange(r2)
            goto L6f
        L6d:
            r18 = 8
        L6f:
            long r10 = r10 >> r18
            int r12 = r12 + 1
            r2 = 8
            goto L43
        L76:
            r18 = 8
            r2 = 8
            if (r1 != r2) goto L86
        L7c:
            if (r9 == r8) goto L85
            int r9 = r9 + 1
            r1 = r21
            r2 = r15
            goto L23
        L84:
            r15 = r2
        L85:
        L86:
        L87:
            androidx.collection.MutableScatterMap<androidx.compose.ui.layout.Ruler, androidx.collection.MutableScatterSet<java.lang.ref.WeakReference<androidx.compose.ui.node.LayoutNode>>> r1 = r0.rulerReaders
            if (r1 == 0) goto L8e
            r1.clear()
        L8e:
            androidx.collection.MutableObjectFloatMap<androidx.compose.ui.layout.Ruler> r1 = r0.rulerValues
            if (r1 == 0) goto L95
            r1.clear()
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LookaheadCapablePlaceable.captureRulers$ui_release(androidx.compose.ui.layout.MeasureResult):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void captureRulers(final androidx.compose.ui.node.PlaceableResult r37) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LookaheadCapablePlaceable.captureRulers(androidx.compose.ui.node.PlaceableResult):void");
    }

    private final void notifyRulerValueChange(MutableScatterSet<WeakReference<LayoutNode>> layoutNodes) {
        ScatterSet this_$iv;
        ScatterSet this_$iv2;
        MutableScatterSet<WeakReference<LayoutNode>> this_$iv3 = layoutNodes;
        Object[] k$iv = this_$iv3.elements;
        long[] m$iv$iv = this_$iv3.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 > lastIndex$iv$iv) {
            return;
        }
        while (true) {
            long slot$iv$iv = m$iv$iv[i$iv$iv];
            long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
            if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                this_$iv = this_$iv3;
            } else {
                int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                int j$iv$iv = 0;
                while (j$iv$iv < bitCount$iv$iv) {
                    long value$iv$iv$iv = 255 & slot$iv$iv;
                    if (!(value$iv$iv$iv < 128)) {
                        this_$iv2 = this_$iv3;
                    } else {
                        int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                        WeakReference layoutNodeRef = (WeakReference) k$iv[index$iv$iv];
                        LayoutNode layoutNode = (LayoutNode) layoutNodeRef.get();
                        if (layoutNode == null) {
                            this_$iv2 = this_$iv3;
                        } else if (isLookingAhead()) {
                            this_$iv2 = this_$iv3;
                            layoutNode.requestLookaheadRelayout$ui_release(false);
                        } else {
                            this_$iv2 = this_$iv3;
                            layoutNode.requestRelayout$ui_release(false);
                        }
                    }
                    slot$iv$iv >>= 8;
                    j$iv$iv++;
                    this_$iv3 = this_$iv2;
                }
                this_$iv = this_$iv3;
                if (bitCount$iv$iv != 8) {
                    return;
                }
            }
            if (i$iv$iv == lastIndex$iv$iv) {
                return;
            }
            i$iv$iv++;
            this_$iv3 = this_$iv;
        }
    }

    public final void provideRulerValue(Ruler ruler, float value) {
        MutableObjectFloatMap it = this.rulerValues;
        if (it == null) {
            it = new MutableObjectFloatMap(0, 1, null);
            this.rulerValues = it;
        }
        it.set(ruler, value);
    }

    public final void provideRelativeRulerValue(Ruler ruler, float value) {
        float width;
        MutableObjectFloatMap it = this.rulerValues;
        if (it == null) {
            it = new MutableObjectFloatMap(0, 1, null);
            this.rulerValues = it;
        }
        if (getLayoutDirection() == LayoutDirection.Ltr) {
            width = value;
        } else {
            width = getWidth() - value;
        }
        it.set(ruler, width);
    }
}
