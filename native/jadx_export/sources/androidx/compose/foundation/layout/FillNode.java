package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.NodeMeasuringIntrinsics;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* compiled from: Size.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J&\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/FillNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "direction", "Landroidx/compose/foundation/layout/Direction;", "fraction", "", "(Landroidx/compose/foundation/layout/Direction;F)V", "getDirection", "()Landroidx/compose/foundation/layout/Direction;", "setDirection", "(Landroidx/compose/foundation/layout/Direction;)V", "getFraction", "()F", "setFraction", "(F)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class FillNode extends Modifier.Node implements LayoutModifierNode {
    private Direction direction;
    private float fraction;

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.maxHeight$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode.maxIntrinsicHeight.1
            /* JADX INFO: Access modifiers changed from: package-private */
            public AnonymousClass1() {
            }

            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo5688measure3p2s80s(MeasureScope $this$maxHeight, Measurable intrinsicMeasurable2, long constraints) {
                return LayoutModifierNode.this.mo86measure3p2s80s($this$maxHeight, intrinsicMeasurable2, constraints);
            }
        }, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.maxWidth$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode.maxIntrinsicWidth.1
            /* JADX INFO: Access modifiers changed from: package-private */
            public C06061() {
            }

            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo5688measure3p2s80s(MeasureScope $this$maxWidth, Measurable intrinsicMeasurable2, long constraints) {
                return LayoutModifierNode.this.mo86measure3p2s80s($this$maxWidth, intrinsicMeasurable2, constraints);
            }
        }, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.minHeight$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode.minIntrinsicHeight.1
            /* JADX INFO: Access modifiers changed from: package-private */
            public C06071() {
            }

            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo5688measure3p2s80s(MeasureScope $this$minHeight, Measurable intrinsicMeasurable2, long constraints) {
                return LayoutModifierNode.this.mo86measure3p2s80s($this$minHeight, intrinsicMeasurable2, constraints);
            }
        }, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return NodeMeasuringIntrinsics.INSTANCE.minWidth$ui_release(new NodeMeasuringIntrinsics.MeasureBlock() { // from class: androidx.compose.ui.node.LayoutModifierNode.minIntrinsicWidth.1
            /* JADX INFO: Access modifiers changed from: package-private */
            public C06081() {
            }

            @Override // androidx.compose.ui.node.NodeMeasuringIntrinsics.MeasureBlock
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo5688measure3p2s80s(MeasureScope $this$minWidth, Measurable intrinsicMeasurable2, long constraints) {
                return LayoutModifierNode.this.mo86measure3p2s80s($this$minWidth, intrinsicMeasurable2, constraints);
            }
        }, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public final Direction getDirection() {
        return this.direction;
    }

    public final void setDirection(Direction direction) {
        this.direction = direction;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final void setFraction(float f) {
        this.fraction = f;
    }

    public FillNode(Direction direction, float fraction) {
        this.direction = direction;
        this.fraction = fraction;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo86measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        int minWidth;
        int width;
        int minHeight;
        int height;
        if (Constraints.m6632getHasBoundedWidthimpl(constraints) && this.direction != Direction.Vertical) {
            float $this$fastRoundToInt$iv = Constraints.m6636getMaxWidthimpl(constraints) * this.fraction;
            int iRound = Math.round($this$fastRoundToInt$iv);
            int $i$f$fastRoundToInt = Constraints.m6638getMinWidthimpl(constraints);
            width = RangesKt.coerceIn(iRound, $i$f$fastRoundToInt, Constraints.m6636getMaxWidthimpl(constraints));
            minWidth = width;
        } else {
            minWidth = Constraints.m6638getMinWidthimpl(constraints);
            width = Constraints.m6636getMaxWidthimpl(constraints);
        }
        if (Constraints.m6631getHasBoundedHeightimpl(constraints) && this.direction != Direction.Horizontal) {
            float $this$fastRoundToInt$iv2 = Constraints.m6635getMaxHeightimpl(constraints) * this.fraction;
            int iRound2 = Math.round($this$fastRoundToInt$iv2);
            int $i$f$fastRoundToInt2 = Constraints.m6637getMinHeightimpl(constraints);
            height = RangesKt.coerceIn(iRound2, $i$f$fastRoundToInt2, Constraints.m6635getMaxHeightimpl(constraints));
            minHeight = height;
        } else {
            minHeight = Constraints.m6637getMinHeightimpl(constraints);
            height = Constraints.m6635getMaxHeightimpl(constraints);
        }
        final Placeable placeable = measurable.mo5535measureBRTryo0(ConstraintsKt.Constraints(minWidth, width, minHeight, height));
        return MeasureScope.CC.layout$default($this$measure_u2d3p2s80s, placeable.getWidth(), placeable.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FillNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope $this$layout) {
                Placeable.PlacementScope.placeRelative$default($this$layout, placeable, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
