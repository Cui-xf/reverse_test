package androidx.compose.material;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.NodeMeasuringIntrinsics;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* compiled from: InteractiveComponentSize.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"Landroidx/compose/material/MinimumInteractiveModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MinimumInteractiveModifierNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, LayoutModifierNode {
    public static final int $stable = 0;

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

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo86measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        final int width;
        final int height;
        boolean enforcement = getIsAttached() && ((Boolean) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentEnforcement())).booleanValue();
        long size = InteractiveComponentSizeKt.minimumInteractiveComponentSize;
        final Placeable placeable = measurable.mo5535measureBRTryo0(constraints);
        if (enforcement) {
            width = Math.max(placeable.getWidth(), $this$measure_u2d3p2s80s.mo361roundToPx0680j_4(DpSize.m6791getWidthD9Ej5fM(size)));
        } else {
            width = placeable.getWidth();
        }
        if (enforcement) {
            height = Math.max(placeable.getHeight(), $this$measure_u2d3p2s80s.mo361roundToPx0680j_4(DpSize.m6789getHeightD9Ej5fM(size)));
        } else {
            height = placeable.getHeight();
        }
        return MeasureScope.CC.layout$default($this$measure_u2d3p2s80s, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.MinimumInteractiveModifierNode$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                int centerX = MathKt.roundToInt((width - placeable.getWidth()) / 2.0f);
                int centerY = MathKt.roundToInt((height - placeable.getHeight()) / 2.0f);
                Placeable.PlacementScope.place$default($this$layout, placeable, centerX, centerY, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
