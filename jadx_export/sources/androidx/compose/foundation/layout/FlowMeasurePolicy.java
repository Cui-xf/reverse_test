package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.animation.ChangeSize$$ExternalSyntheticBackport0;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.foundation.layout.FlowLineMeasurePolicy;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlowLayout.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\u0016\u0010+\u001a\u00020\nHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\t\u0010.\u001a\u00020\fHÆ\u0003J\u0016\u0010/\u001a\u00020\nHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010-J\t\u00101\u001a\u00020\u000fHÂ\u0003J\t\u00102\u001a\u00020\u000fHÂ\u0003J\t\u00103\u001a\u00020\u0012HÂ\u0003Jm\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106J\u0013\u00107\u001a\u00020\u00042\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u000fHÖ\u0001JD\u0010;\u001a\u00020\u000f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001c0=2\u0006\u0010>\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J$\u0010@\u001a\u00020\u000f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001c0=2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fJD\u0010C\u001a\u00020\u000f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001c0=2\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010E\u001a\u00020FHÖ\u0001J(\u0010G\u001a\u00020\u000f*\u00020H2\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0=0=2\u0006\u0010I\u001a\u00020\u000fH\u0016J(\u0010J\u001a\u00020\u000f*\u00020H2\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0=0=2\u0006\u0010A\u001a\u00020\u000fH\u0016J2\u0010K\u001a\u00020L*\u00020M2\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0=0=2\u0006\u0010O\u001a\u00020PH\u0016ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJ(\u0010S\u001a\u00020\u000f*\u00020H2\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0=0=2\u0006\u0010I\u001a\u00020\u000fH\u0016J(\u0010T\u001a\u00020\u000f*\u00020H2\u0012\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0=0=2\u0006\u0010A\u001a\u00020\u000fH\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\r\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0019R\u0016\u0010\t\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0016R.\u0010\u001a\u001a\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010 \u001a\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001d¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR.\u0010\"\u001a\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001d¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR.\u0010$\u001a\u001f\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\u0002\b\u001d¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006U"}, d2 = {"Landroidx/compose/foundation/layout/FlowMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "isHorizontal", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisArrangementSpacing", "maxItemsInMainAxis", "", "maxLines", "overflow", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "F", "getHorizontalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "()Z", "maxCrossAxisIntrinsicItemSize", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "Lkotlin/ExtensionFunctionType;", "getMaxCrossAxisIntrinsicItemSize", "()Lkotlin/jvm/functions/Function3;", "maxMainAxisIntrinsicItemSize", "getMaxMainAxisIntrinsicItemSize", "minCrossAxisIntrinsicItemSize", "getMinCrossAxisIntrinsicItemSize", "minMainAxisIntrinsicItemSize", "getMinMainAxisIntrinsicItemSize", "getVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "component1", "component2", "component3", "component4", "component4-D9Ej5fM", "()F", "component5", "component6", "component6-D9Ej5fM", "component7", "component8", "component9", "copy", "copy-QuyCDyQ", "(ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/CrossAxisAlignment;FIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/foundation/layout/FlowMeasurePolicy;", "equals", "other", "", "hashCode", "intrinsicCrossAxisSize", "measurables", "", "mainAxisAvailable", "crossAxisSpacing", "maxIntrinsicMainAxisSize", "height", "arrangementSpacing", "minIntrinsicMainAxisSize", "crossAxisAvailable", "toString", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class FlowMeasurePolicy implements MultiContentMeasurePolicy, FlowLineMeasurePolicy {
    private final CrossAxisAlignment crossAxisAlignment;
    private final float crossAxisArrangementSpacing;
    private final Arrangement.Horizontal horizontalArrangement;
    private final boolean isHorizontal;
    private final float mainAxisSpacing;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxCrossAxisIntrinsicItemSize;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxMainAxisIntrinsicItemSize;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minCrossAxisIntrinsicItemSize;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minMainAxisIntrinsicItemSize;
    private final FlowLayoutOverflowState overflow;
    private final Arrangement.Vertical verticalArrangement;

    public /* synthetic */ FlowMeasurePolicy(boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment, float f2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, horizontal, vertical, f, crossAxisAlignment, f2, i, i2, flowLayoutOverflowState);
    }

    /* renamed from: component4-D9Ej5fM, reason: not valid java name and from getter */
    private final float getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    /* renamed from: component6-D9Ej5fM, reason: not valid java name and from getter */
    private final float getCrossAxisArrangementSpacing() {
        return this.crossAxisArrangementSpacing;
    }

    /* renamed from: component7, reason: from getter */
    private final int getMaxItemsInMainAxis() {
        return this.maxItemsInMainAxis;
    }

    /* renamed from: component8, reason: from getter */
    private final int getMaxLines() {
        return this.maxLines;
    }

    /* renamed from: component9, reason: from getter */
    private final FlowLayoutOverflowState getOverflow() {
        return this.overflow;
    }

    /* renamed from: copy-QuyCDyQ$default, reason: not valid java name */
    public static /* synthetic */ FlowMeasurePolicy m627copyQuyCDyQ$default(FlowMeasurePolicy flowMeasurePolicy, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, CrossAxisAlignment crossAxisAlignment, float f2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = flowMeasurePolicy.isHorizontal;
        }
        if ((i3 & 2) != 0) {
            horizontal = flowMeasurePolicy.horizontalArrangement;
        }
        if ((i3 & 4) != 0) {
            vertical = flowMeasurePolicy.verticalArrangement;
        }
        if ((i3 & 8) != 0) {
            f = flowMeasurePolicy.mainAxisSpacing;
        }
        if ((i3 & 16) != 0) {
            crossAxisAlignment = flowMeasurePolicy.crossAxisAlignment;
        }
        if ((i3 & 32) != 0) {
            f2 = flowMeasurePolicy.crossAxisArrangementSpacing;
        }
        if ((i3 & 64) != 0) {
            i = flowMeasurePolicy.maxItemsInMainAxis;
        }
        if ((i3 & 128) != 0) {
            i2 = flowMeasurePolicy.maxLines;
        }
        if ((i3 & 256) != 0) {
            flowLayoutOverflowState = flowMeasurePolicy.overflow;
        }
        int i4 = i2;
        FlowLayoutOverflowState flowLayoutOverflowState2 = flowLayoutOverflowState;
        float f3 = f2;
        int i5 = i;
        CrossAxisAlignment crossAxisAlignment2 = crossAxisAlignment;
        Arrangement.Vertical vertical2 = vertical;
        return flowMeasurePolicy.m628copyQuyCDyQ(z, horizontal, vertical2, f, crossAxisAlignment2, f3, i5, i4, flowLayoutOverflowState2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsHorizontal() {
        return this.isHorizontal;
    }

    /* renamed from: component2, reason: from getter */
    public final Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    /* renamed from: component3, reason: from getter */
    public final Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    /* renamed from: component5, reason: from getter */
    public final CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    /* renamed from: copy-QuyCDyQ, reason: not valid java name */
    public final FlowMeasurePolicy m628copyQuyCDyQ(boolean isHorizontal, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, float mainAxisSpacing, CrossAxisAlignment crossAxisAlignment, float crossAxisArrangementSpacing, int maxItemsInMainAxis, int maxLines, FlowLayoutOverflowState overflow) {
        return new FlowMeasurePolicy(isHorizontal, horizontalArrangement, verticalArrangement, mainAxisSpacing, crossAxisAlignment, crossAxisArrangementSpacing, maxItemsInMainAxis, maxLines, overflow, null);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy, androidx.compose.foundation.layout.RowColumnMeasurePolicy
    /* renamed from: createConstraints-xF2OJ5Q */
    public /* synthetic */ long mo595createConstraintsxF2OJ5Q(int i, int i2, int i3, int i4, boolean z) {
        return FlowLineMeasurePolicy.CC.m617$default$createConstraintsxF2OJ5Q(this, i, i2, i3, i4, z);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy, androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public /* synthetic */ int crossAxisSize(Placeable placeable) {
        return FlowLineMeasurePolicy.CC.$default$crossAxisSize(this, placeable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowMeasurePolicy)) {
            return false;
        }
        FlowMeasurePolicy flowMeasurePolicy = (FlowMeasurePolicy) other;
        return this.isHorizontal == flowMeasurePolicy.isHorizontal && Intrinsics.areEqual(this.horizontalArrangement, flowMeasurePolicy.horizontalArrangement) && Intrinsics.areEqual(this.verticalArrangement, flowMeasurePolicy.verticalArrangement) && Dp.m6698equalsimpl0(this.mainAxisSpacing, flowMeasurePolicy.mainAxisSpacing) && Intrinsics.areEqual(this.crossAxisAlignment, flowMeasurePolicy.crossAxisAlignment) && Dp.m6698equalsimpl0(this.crossAxisArrangementSpacing, flowMeasurePolicy.crossAxisArrangementSpacing) && this.maxItemsInMainAxis == flowMeasurePolicy.maxItemsInMainAxis && this.maxLines == flowMeasurePolicy.maxLines && Intrinsics.areEqual(this.overflow, flowMeasurePolicy.overflow);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public /* synthetic */ int getCrossAxisPosition(Placeable placeable, RowColumnParentData rowColumnParentData, int i, LayoutDirection layoutDirection, int i2) {
        return FlowLineMeasurePolicy.CC.$default$getCrossAxisPosition(this, placeable, rowColumnParentData, i, layoutDirection, i2);
    }

    public int hashCode() {
        return (((((((((((((((ChangeSize$$ExternalSyntheticBackport0.m(this.isHorizontal) * 31) + this.horizontalArrangement.hashCode()) * 31) + this.verticalArrangement.hashCode()) * 31) + Dp.m6699hashCodeimpl(this.mainAxisSpacing)) * 31) + this.crossAxisAlignment.hashCode()) * 31) + Dp.m6699hashCodeimpl(this.crossAxisArrangementSpacing)) * 31) + this.maxItemsInMainAxis) * 31) + this.maxLines) * 31) + this.overflow.hashCode();
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy, androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public /* synthetic */ int mainAxisSize(Placeable placeable) {
        return FlowLineMeasurePolicy.CC.$default$mainAxisSize(this, placeable);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy, androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public /* synthetic */ MeasureResult placeHelper(Placeable[] placeableArr, MeasureScope measureScope, int i, int[] iArr, int i2, int i3, int[] iArr2, int i4, int i5, int i6) {
        return FlowLineMeasurePolicy.CC.$default$placeHelper(this, placeableArr, measureScope, i, iArr, i2, i3, iArr2, i4, i5, i6);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy, androidx.compose.foundation.layout.RowColumnMeasurePolicy
    public /* synthetic */ void populateMainAxisPositions(int i, int[] iArr, int[] iArr2, MeasureScope measureScope) {
        FlowLineMeasurePolicy.CC.$default$populateMainAxisPositions(this, i, iArr, iArr2, measureScope);
    }

    public String toString() {
        return "FlowMeasurePolicy(isHorizontal=" + this.isHorizontal + ", horizontalArrangement=" + this.horizontalArrangement + ", verticalArrangement=" + this.verticalArrangement + ", mainAxisSpacing=" + ((Object) Dp.m6704toStringimpl(this.mainAxisSpacing)) + ", crossAxisAlignment=" + this.crossAxisAlignment + ", crossAxisArrangementSpacing=" + ((Object) Dp.m6704toStringimpl(this.crossAxisArrangementSpacing)) + ", maxItemsInMainAxis=" + this.maxItemsInMainAxis + ", maxLines=" + this.maxLines + ", overflow=" + this.overflow + ')';
    }

    private FlowMeasurePolicy(boolean isHorizontal, Arrangement.Horizontal horizontalArrangement, Arrangement.Vertical verticalArrangement, float mainAxisSpacing, CrossAxisAlignment crossAxisAlignment, float crossAxisArrangementSpacing, int maxItemsInMainAxis, int maxLines, FlowLayoutOverflowState overflow) {
        this.isHorizontal = isHorizontal;
        this.horizontalArrangement = horizontalArrangement;
        this.verticalArrangement = verticalArrangement;
        this.mainAxisSpacing = mainAxisSpacing;
        this.crossAxisAlignment = crossAxisAlignment;
        this.crossAxisArrangementSpacing = crossAxisArrangementSpacing;
        this.maxItemsInMainAxis = maxItemsInMainAxis;
        this.maxLines = maxLines;
        this.overflow = overflow;
        this.maxMainAxisIntrinsicItemSize = isHorizontal() ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$maxMainAxisIntrinsicItemSize$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable $this$null, int i, int h) {
                return Integer.valueOf($this$null.maxIntrinsicWidth(h));
            }
        } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$maxMainAxisIntrinsicItemSize$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable $this$null, int i, int w) {
                return Integer.valueOf($this$null.maxIntrinsicHeight(w));
            }
        };
        this.maxCrossAxisIntrinsicItemSize = isHorizontal() ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$maxCrossAxisIntrinsicItemSize$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable $this$null, int i, int w) {
                return Integer.valueOf($this$null.maxIntrinsicHeight(w));
            }
        } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$maxCrossAxisIntrinsicItemSize$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable $this$null, int i, int h) {
                return Integer.valueOf($this$null.maxIntrinsicWidth(h));
            }
        };
        this.minCrossAxisIntrinsicItemSize = isHorizontal() ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$minCrossAxisIntrinsicItemSize$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable $this$null, int i, int w) {
                return Integer.valueOf($this$null.minIntrinsicHeight(w));
            }
        } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$minCrossAxisIntrinsicItemSize$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable $this$null, int i, int h) {
                return Integer.valueOf($this$null.minIntrinsicWidth(h));
            }
        };
        this.minMainAxisIntrinsicItemSize = isHorizontal() ? new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$minMainAxisIntrinsicItemSize$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable $this$null, int i, int h) {
                return Integer.valueOf($this$null.minIntrinsicWidth(h));
            }
        } : new Function3<IntrinsicMeasurable, Integer, Integer, Integer>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$minMainAxisIntrinsicItemSize$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num, Integer num2) {
                return invoke(intrinsicMeasurable, num.intValue(), num2.intValue());
            }

            public final Integer invoke(IntrinsicMeasurable $this$null, int i, int w) {
                return Integer.valueOf($this$null.minIntrinsicHeight(w));
            }
        };
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public Arrangement.Horizontal getHorizontalArrangement() {
        return this.horizontalArrangement;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public Arrangement.Vertical getVerticalArrangement() {
        return this.verticalArrangement;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult mo629measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List<? extends List<? extends Measurable>> list, long constraints) {
        LayoutOrientation layoutOrientation;
        if (this.maxLines == 0 || this.maxItemsInMainAxis == 0 || list.isEmpty() || (Constraints.m6635getMaxHeightimpl(constraints) == 0 && this.overflow.getType$foundation_layout_release() != FlowLayoutOverflow.OverflowType.Visible)) {
            return MeasureScope.CC.layout$default($this$measure_u2d3p2s80s, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$measure$1
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
        List list2 = (List) CollectionsKt.first((List) list);
        if (!list2.isEmpty()) {
            List list3 = (List) CollectionsKt.getOrNull(list, 1);
            Measurable seeMoreMeasurable = list3 != null ? (Measurable) CollectionsKt.firstOrNull(list3) : null;
            List list4 = (List) CollectionsKt.getOrNull(list, 2);
            Measurable collapseMeasurable = list4 != null ? (Measurable) CollectionsKt.firstOrNull(list4) : null;
            this.overflow.setItemCount$foundation_layout_release(list2.size());
            this.overflow.m609setOverflowMeasurableshBUhpc$foundation_layout_release(this, seeMoreMeasurable, collapseMeasurable, constraints);
            FlowMeasurePolicy flowMeasurePolicy = this;
            Iterator it = list2.iterator();
            float f = this.mainAxisSpacing;
            float f2 = this.crossAxisArrangementSpacing;
            if (isHorizontal()) {
                layoutOrientation = LayoutOrientation.Horizontal;
            } else {
                layoutOrientation = LayoutOrientation.Vertical;
            }
            return FlowLayoutKt.m605breakDownItemsdi9J0FM($this$measure_u2d3p2s80s, flowMeasurePolicy, it, f, f2, OrientationIndependentConstraints.m650constructorimpl(constraints, layoutOrientation), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }
        return MeasureScope.CC.layout$default($this$measure_u2d3p2s80s, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$measure$2
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

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends List<? extends IntrinsicMeasurable>> list, int height) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        flowLayoutOverflowState.m610setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3) : null, isHorizontal(), ConstraintsKt.Constraints$default(0, 0, 0, height, 7, null));
        if (isHorizontal()) {
            List<? extends IntrinsicMeasurable> listEmptyList = (List) CollectionsKt.firstOrNull((List) list);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return minIntrinsicMainAxisSize(listEmptyList, height, $this$minIntrinsicWidth.mo361roundToPx0680j_4(this.mainAxisSpacing), $this$minIntrinsicWidth.mo361roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }
        List<? extends IntrinsicMeasurable> listEmptyList2 = (List) CollectionsKt.firstOrNull((List) list);
        if (listEmptyList2 == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        return intrinsicCrossAxisSize(listEmptyList2, height, $this$minIntrinsicWidth.mo361roundToPx0680j_4(this.mainAxisSpacing), $this$minIntrinsicWidth.mo361roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends List<? extends IntrinsicMeasurable>> list, int width) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        flowLayoutOverflowState.m610setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3) : null, isHorizontal(), ConstraintsKt.Constraints$default(0, width, 0, 0, 13, null));
        if (isHorizontal()) {
            List<? extends IntrinsicMeasurable> listEmptyList = (List) CollectionsKt.firstOrNull((List) list);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return intrinsicCrossAxisSize(listEmptyList, width, $this$minIntrinsicHeight.mo361roundToPx0680j_4(this.mainAxisSpacing), $this$minIntrinsicHeight.mo361roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }
        List<? extends IntrinsicMeasurable> listEmptyList2 = (List) CollectionsKt.firstOrNull((List) list);
        if (listEmptyList2 == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        return minIntrinsicMainAxisSize(listEmptyList2, width, $this$minIntrinsicHeight.mo361roundToPx0680j_4(this.mainAxisSpacing), $this$minIntrinsicHeight.mo361roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends List<? extends IntrinsicMeasurable>> list, int width) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        flowLayoutOverflowState.m610setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3) : null, isHorizontal(), ConstraintsKt.Constraints$default(0, width, 0, 0, 13, null));
        if (isHorizontal()) {
            List<? extends IntrinsicMeasurable> listEmptyList = (List) CollectionsKt.firstOrNull((List) list);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return intrinsicCrossAxisSize(listEmptyList, width, $this$maxIntrinsicHeight.mo361roundToPx0680j_4(this.mainAxisSpacing), $this$maxIntrinsicHeight.mo361roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }
        List<? extends IntrinsicMeasurable> listEmptyList2 = (List) CollectionsKt.firstOrNull((List) list);
        if (listEmptyList2 == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        return maxIntrinsicMainAxisSize(listEmptyList2, width, $this$maxIntrinsicHeight.mo361roundToPx0680j_4(this.mainAxisSpacing));
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends List<? extends IntrinsicMeasurable>> list, int height) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.overflow;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        flowLayoutOverflowState.m610setOverflowMeasurableshBUhpc$foundation_layout_release(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3) : null, isHorizontal(), ConstraintsKt.Constraints$default(0, 0, 0, height, 7, null));
        if (!isHorizontal()) {
            List<? extends IntrinsicMeasurable> listEmptyList = (List) CollectionsKt.firstOrNull((List) list);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return intrinsicCrossAxisSize(listEmptyList, height, $this$maxIntrinsicWidth.mo361roundToPx0680j_4(this.mainAxisSpacing), $this$maxIntrinsicWidth.mo361roundToPx0680j_4(this.crossAxisArrangementSpacing), this.maxItemsInMainAxis, this.maxLines, this.overflow);
        }
        List<? extends IntrinsicMeasurable> listEmptyList2 = (List) CollectionsKt.firstOrNull((List) list);
        if (listEmptyList2 == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        return maxIntrinsicMainAxisSize(listEmptyList2, height, $this$maxIntrinsicWidth.mo361roundToPx0680j_4(this.mainAxisSpacing));
    }

    public final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> measurables, int crossAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, FlowLayoutOverflowState overflow) {
        return FlowLayoutKt.minIntrinsicMainAxisSize(measurables, this.minMainAxisIntrinsicItemSize, this.minCrossAxisIntrinsicItemSize, crossAxisAvailable, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis, maxLines, overflow);
    }

    public final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> measurables, int height, int arrangementSpacing) {
        return FlowLayoutKt.maxIntrinsicMainAxisSize(measurables, this.maxMainAxisIntrinsicItemSize, height, arrangementSpacing, this.maxItemsInMainAxis);
    }

    public final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> measurables, int mainAxisAvailable, int mainAxisSpacing, int crossAxisSpacing, int maxItemsInMainAxis, int maxLines, FlowLayoutOverflowState overflow) {
        return IntIntPair.m24getFirstimpl(FlowLayoutKt.intrinsicCrossAxisSize((List<? extends IntrinsicMeasurable>) measurables, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) this.minMainAxisIntrinsicItemSize, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) this.minCrossAxisIntrinsicItemSize, mainAxisAvailable, mainAxisSpacing, crossAxisSpacing, maxItemsInMainAxis, maxLines, overflow));
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxMainAxisIntrinsicItemSize() {
        return this.maxMainAxisIntrinsicItemSize;
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxCrossAxisIntrinsicItemSize() {
        return this.maxCrossAxisIntrinsicItemSize;
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinCrossAxisIntrinsicItemSize() {
        return this.minCrossAxisIntrinsicItemSize;
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinMainAxisIntrinsicItemSize() {
        return this.minMainAxisIntrinsicItemSize;
    }
}
