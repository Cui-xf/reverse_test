package androidx.compose.foundation.layout;

import androidx.compose.animation.ChangeSize$$ExternalSyntheticBackport0;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: Box.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\t\u0010\b\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J,\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/layout/BoxMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "alignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "(Landroidx/compose/ui/Alignment;Z)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class BoxMeasurePolicy implements MeasurePolicy {
    private final Alignment alignment;
    private final boolean propagateMinConstraints;

    /* renamed from: component1, reason: from getter */
    private final Alignment getAlignment() {
        return this.alignment;
    }

    /* renamed from: component2, reason: from getter */
    private final boolean getPropagateMinConstraints() {
        return this.propagateMinConstraints;
    }

    public static /* synthetic */ BoxMeasurePolicy copy$default(BoxMeasurePolicy boxMeasurePolicy, Alignment alignment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            alignment = boxMeasurePolicy.alignment;
        }
        if ((i & 2) != 0) {
            z = boxMeasurePolicy.propagateMinConstraints;
        }
        return boxMeasurePolicy.copy(alignment, z);
    }

    public final BoxMeasurePolicy copy(Alignment alignment, boolean propagateMinConstraints) {
        return new BoxMeasurePolicy(alignment, propagateMinConstraints);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxMeasurePolicy)) {
            return false;
        }
        BoxMeasurePolicy boxMeasurePolicy = (BoxMeasurePolicy) other;
        return Intrinsics.areEqual(this.alignment, boxMeasurePolicy.alignment) && this.propagateMinConstraints == boxMeasurePolicy.propagateMinConstraints;
    }

    public int hashCode() {
        return (this.alignment.hashCode() * 31) + ChangeSize$$ExternalSyntheticBackport0.m(this.propagateMinConstraints);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    public String toString() {
        return "BoxMeasurePolicy(alignment=" + this.alignment + ", propagateMinConstraints=" + this.propagateMinConstraints + ')';
    }

    public BoxMeasurePolicy(Alignment alignment, boolean propagateMinConstraints) {
        this.alignment = alignment;
        this.propagateMinConstraints = propagateMinConstraints;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo34measure3p2s80s(final MeasureScope $this$measure_u2d3p2s80s, final List<? extends Measurable> list, long constraints) {
        long jM6626copyZbe2FdA;
        Placeable placeable;
        final int boxHeight;
        int boxHeight2;
        if (list.isEmpty()) {
            return MeasureScope.CC.layout$default($this$measure_u2d3p2s80s, Constraints.m6638getMinWidthimpl(constraints), Constraints.m6637getMinHeightimpl(constraints), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope $this$layout) {
                }
            }, 4, null);
        }
        if (this.propagateMinConstraints) {
            jM6626copyZbe2FdA = constraints;
        } else {
            jM6626copyZbe2FdA = Constraints.m6626copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(constraints) : 0);
        }
        long contentConstraints = jM6626copyZbe2FdA;
        if (list.size() == 1) {
            final Measurable measurable = list.get(0);
            if (!BoxKt.getMatchesParentSize(measurable)) {
                placeable = measurable.mo5535measureBRTryo0(contentConstraints);
                int boxWidth = Math.max(Constraints.m6638getMinWidthimpl(constraints), placeable.getWidth());
                boxHeight = Math.max(Constraints.m6637getMinHeightimpl(constraints), placeable.getHeight());
                boxHeight2 = boxWidth;
            } else {
                int boxWidth2 = Constraints.m6638getMinWidthimpl(constraints);
                int boxHeight3 = Constraints.m6637getMinHeightimpl(constraints);
                placeable = measurable.mo5535measureBRTryo0(Constraints.INSTANCE.m6646fixedJhjzzOo(Constraints.m6638getMinWidthimpl(constraints), Constraints.m6637getMinHeightimpl(constraints)));
                boxHeight = boxHeight3;
                boxHeight2 = boxWidth2;
            }
            final int boxWidth3 = boxHeight2;
            final Placeable placeable2 = placeable;
            return MeasureScope.CC.layout$default($this$measure_u2d3p2s80s, boxWidth3, boxHeight, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$2
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
                    BoxKt.placeInBox($this$layout, placeable2, measurable, $this$measure_u2d3p2s80s.getLayoutDirection(), boxWidth3, boxHeight, this.alignment);
                }
            }, 4, null);
        }
        final Placeable[] placeables = new Placeable[list.size()];
        final Ref.IntRef boxWidth4 = new Ref.IntRef();
        boxWidth4.element = Constraints.m6638getMinWidthimpl(constraints);
        final Ref.IntRef boxHeight4 = new Ref.IntRef();
        boxHeight4.element = Constraints.m6637getMinHeightimpl(constraints);
        int size = list.size();
        int index$iv = 0;
        for (int index$iv2 = 0; index$iv2 < size; index$iv2++) {
            Object item$iv = list.get(index$iv2);
            Measurable measurable2 = (Measurable) item$iv;
            int index = index$iv2;
            if (!BoxKt.getMatchesParentSize(measurable2)) {
                Placeable placeable3 = measurable2.mo5535measureBRTryo0(contentConstraints);
                placeables[index] = placeable3;
                boxWidth4.element = Math.max(boxWidth4.element, placeable3.getWidth());
                boxHeight4.element = Math.max(boxHeight4.element, placeable3.getHeight());
            } else {
                index$iv = 1;
            }
        }
        if (index$iv != 0) {
            long matchParentSizeConstraints = ConstraintsKt.Constraints(boxWidth4.element != Integer.MAX_VALUE ? boxWidth4.element : 0, boxWidth4.element, boxHeight4.element != Integer.MAX_VALUE ? boxHeight4.element : 0, boxHeight4.element);
            int size2 = list.size();
            for (int index$iv3 = 0; index$iv3 < size2; index$iv3++) {
                Object item$iv2 = list.get(index$iv3);
                Measurable measurable3 = (Measurable) item$iv2;
                int index2 = index$iv3;
                if (BoxKt.getMatchesParentSize(measurable3)) {
                    placeables[index2] = measurable3.mo5535measureBRTryo0(matchParentSizeConstraints);
                }
            }
        }
        return MeasureScope.CC.layout$default($this$measure_u2d3p2s80s, boxWidth4.element, boxHeight4.element, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                Placeable[] placeableArr = placeables;
                List<Measurable> list2 = list;
                MeasureScope measureScope = $this$measure_u2d3p2s80s;
                Ref.IntRef intRef = boxWidth4;
                Ref.IntRef intRef2 = boxHeight4;
                BoxMeasurePolicy boxMeasurePolicy = this;
                int index$iv4 = 0;
                int length = placeableArr.length;
                int i = 0;
                while (i < length) {
                    Placeable placeable4 = placeableArr[i];
                    Intrinsics.checkNotNull(placeable4, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
                    Measurable measurable4 = list2.get(index$iv4);
                    BoxKt.placeInBox($this$layout, placeable4, measurable4, measureScope.getLayoutDirection(), intRef.element, intRef2.element, boxMeasurePolicy.alignment);
                    i++;
                    index$iv4++;
                }
            }
        }, 4, null);
    }
}
