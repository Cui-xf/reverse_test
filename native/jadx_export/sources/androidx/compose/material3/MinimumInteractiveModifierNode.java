package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.NodeMeasuringIntrinsics;
import kotlin.Metadata;

/* compiled from: InteractiveComponentSize.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"Landroidx/compose/material3/MinimumInteractiveModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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

    /* JADX WARN: Removed duplicated region for block: B:9:0x0047  */
    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.compose.ui.layout.MeasureResult mo86measure3p2s80s(androidx.compose.ui.layout.MeasureScope r13, androidx.compose.ui.layout.Measurable r14, long r15) {
        /*
            r12 = this;
            r0 = r12
            androidx.compose.ui.node.CompositionLocalConsumerModifierNode r0 = (androidx.compose.ui.node.CompositionLocalConsumerModifierNode) r0
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.material3.InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            java.lang.Object r0 = androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt.currentValueOf(r0, r1)
            androidx.compose.ui.unit.Dp r0 = (androidx.compose.ui.unit.Dp) r0
            float r0 = r0.m6707unboximpl()
            r1 = 0
            r2 = 0
            float r3 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m6693constructorimpl(r3)
            r2 = 0
            float r3 = kotlin.ranges.RangesKt.coerceAtLeast(r0, r1)
            float r0 = androidx.compose.ui.unit.Dp.m6693constructorimpl(r3)
            androidx.compose.ui.layout.Placeable r1 = r14.mo5535measureBRTryo0(r15)
            boolean r2 = r12.getIsAttached()
            r3 = 0
            if (r2 == 0) goto L47
            r2 = r0
            r4 = 0
            boolean r5 = java.lang.Float.isNaN(r2)
            if (r5 != 0) goto L47
            r2 = 0
            r4 = 0
            float r5 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m6693constructorimpl(r5)
            int r2 = androidx.compose.ui.unit.Dp.m6692compareTo0680j_4(r0, r2)
            if (r2 <= 0) goto L47
            r2 = 1
            goto L48
        L47:
            r2 = 0
        L48:
            r4 = r0
            r5 = 0
            boolean r6 = java.lang.Float.isNaN(r4)
            if (r6 != 0) goto L54
            int r3 = r13.mo361roundToPx0680j_4(r0)
        L54:
            if (r2 == 0) goto L5f
            int r4 = r1.getWidth()
            int r4 = java.lang.Math.max(r4, r3)
            goto L63
        L5f:
            int r4 = r1.getWidth()
        L63:
            r6 = r4
            if (r2 == 0) goto L71
            int r4 = r1.getHeight()
            int r4 = java.lang.Math.max(r4, r3)
            r7 = r4
            goto L76
        L71:
            int r4 = r1.getHeight()
            r7 = r4
        L76:
            androidx.compose.material3.MinimumInteractiveModifierNode$measure$1 r4 = new androidx.compose.material3.MinimumInteractiveModifierNode$measure$1
            r4.<init>()
            r9 = r4
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r10 = 4
            r11 = 0
            r8 = 0
            r5 = r13
            androidx.compose.ui.layout.MeasureResult r4 = androidx.compose.ui.layout.MeasureScope.CC.layout$default(r5, r6, r7, r8, r9, r10, r11)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MinimumInteractiveModifierNode.mo86measure3p2s80s(androidx.compose.ui.layout.MeasureScope, androidx.compose.ui.layout.Measurable, long):androidx.compose.ui.layout.MeasureResult");
    }
}
