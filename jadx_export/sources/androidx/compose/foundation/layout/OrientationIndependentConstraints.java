package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* compiled from: RowColumnImpl.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081@\u0018\u00002\u00020\u0001B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0007\u0010\rB\u0011\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000fJ;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0011J\u0015\u0010 \u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b!\u0010\"J\u0015\u0010#\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b$\u0010\"J\u0013\u0010%\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010\u000fJ\u001b\u0010'\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010\rJ\u0010\u0010)\u001a\u00020*HÖ\u0001¢\u0006\u0004\b+\u0010,R\u0012\u0010\u0006\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0005\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0012\u0010\u0004\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0002\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u000e\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015\u0088\u0001\u000e\u0092\u0001\u00020\n\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006-"}, d2 = {"Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "", "mainAxisMin", "", "mainAxisMax", "crossAxisMin", "crossAxisMax", "constructor-impl", "(IIII)J", "c", "Landroidx/compose/ui/unit/Constraints;", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)J", "value", "(J)J", "getCrossAxisMax-impl", "(J)I", "getCrossAxisMin-impl", "getMainAxisMax-impl", "getMainAxisMin-impl", "J", "copy", "copy-yUG9Ft0", "(JIIII)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "maxHeight", "maxHeight-impl", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)I", "maxWidth", "maxWidth-impl", "stretchCrossAxis", "stretchCrossAxis-q4ezo7Y", "toBoxConstraints", "toBoxConstraints-OenEA2s", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class OrientationIndependentConstraints {
    private final long value;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ OrientationIndependentConstraints m647boximpl(long j) {
        return new OrientationIndependentConstraints(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static long m649constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m653equalsimpl(long j, Object obj) {
        return (obj instanceof OrientationIndependentConstraints) && Constraints.m6629equalsimpl0(j, ((OrientationIndependentConstraints) obj).getValue());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m654equalsimpl0(long j, long j2) {
        return Constraints.m6629equalsimpl0(j, j2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m659hashCodeimpl(long j) {
        return Constraints.m6639hashCodeimpl(j);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m664toStringimpl(long j) {
        return "OrientationIndependentConstraints(value=" + ((Object) Constraints.m6641toStringimpl(j)) + ')';
    }

    public boolean equals(Object obj) {
        return m653equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m659hashCodeimpl(this.value);
    }

    public String toString() {
        return m664toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getValue() {
        return this.value;
    }

    private /* synthetic */ OrientationIndependentConstraints(long value) {
        this.value = value;
    }

    /* renamed from: getMainAxisMin-impl, reason: not valid java name */
    public static final int m658getMainAxisMinimpl(long arg0) {
        return Constraints.m6638getMinWidthimpl(arg0);
    }

    /* renamed from: getMainAxisMax-impl, reason: not valid java name */
    public static final int m657getMainAxisMaximpl(long arg0) {
        return Constraints.m6636getMaxWidthimpl(arg0);
    }

    /* renamed from: getCrossAxisMin-impl, reason: not valid java name */
    public static final int m656getCrossAxisMinimpl(long arg0) {
        return Constraints.m6637getMinHeightimpl(arg0);
    }

    /* renamed from: getCrossAxisMax-impl, reason: not valid java name */
    public static final int m655getCrossAxisMaximpl(long arg0) {
        return Constraints.m6635getMaxHeightimpl(arg0);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m648constructorimpl(int mainAxisMin, int mainAxisMax, int crossAxisMin, int crossAxisMax) {
        return m649constructorimpl(ConstraintsKt.Constraints(mainAxisMin, mainAxisMax, crossAxisMin, crossAxisMax));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m650constructorimpl(long c, LayoutOrientation orientation) {
        return m648constructorimpl(orientation == LayoutOrientation.Horizontal ? Constraints.m6638getMinWidthimpl(c) : Constraints.m6637getMinHeightimpl(c), orientation == LayoutOrientation.Horizontal ? Constraints.m6636getMaxWidthimpl(c) : Constraints.m6635getMaxHeightimpl(c), orientation == LayoutOrientation.Horizontal ? Constraints.m6637getMinHeightimpl(c) : Constraints.m6638getMinWidthimpl(c), orientation == LayoutOrientation.Horizontal ? Constraints.m6635getMaxHeightimpl(c) : Constraints.m6636getMaxWidthimpl(c));
    }

    /* renamed from: stretchCrossAxis-q4ezo7Y, reason: not valid java name */
    public static final long m662stretchCrossAxisq4ezo7Y(long arg0) {
        int iM6637getMinHeightimpl;
        int iM6638getMinWidthimpl = Constraints.m6638getMinWidthimpl(arg0);
        int iM6636getMaxWidthimpl = Constraints.m6636getMaxWidthimpl(arg0);
        if (Constraints.m6635getMaxHeightimpl(arg0) != Integer.MAX_VALUE) {
            iM6637getMinHeightimpl = Constraints.m6635getMaxHeightimpl(arg0);
        } else {
            iM6637getMinHeightimpl = Constraints.m6637getMinHeightimpl(arg0);
        }
        return m648constructorimpl(iM6638getMinWidthimpl, iM6636getMaxWidthimpl, iM6637getMinHeightimpl, Constraints.m6635getMaxHeightimpl(arg0));
    }

    /* renamed from: toBoxConstraints-OenEA2s, reason: not valid java name */
    public static final long m663toBoxConstraintsOenEA2s(long arg0, LayoutOrientation orientation) {
        return orientation == LayoutOrientation.Horizontal ? ConstraintsKt.Constraints(Constraints.m6638getMinWidthimpl(arg0), Constraints.m6636getMaxWidthimpl(arg0), Constraints.m6637getMinHeightimpl(arg0), Constraints.m6635getMaxHeightimpl(arg0)) : ConstraintsKt.Constraints(Constraints.m6637getMinHeightimpl(arg0), Constraints.m6635getMaxHeightimpl(arg0), Constraints.m6638getMinWidthimpl(arg0), Constraints.m6636getMaxWidthimpl(arg0));
    }

    /* renamed from: maxWidth-impl, reason: not valid java name */
    public static final int m661maxWidthimpl(long arg0, LayoutOrientation orientation) {
        if (orientation == LayoutOrientation.Horizontal) {
            return Constraints.m6636getMaxWidthimpl(arg0);
        }
        return Constraints.m6635getMaxHeightimpl(arg0);
    }

    /* renamed from: maxHeight-impl, reason: not valid java name */
    public static final int m660maxHeightimpl(long arg0, LayoutOrientation orientation) {
        if (orientation == LayoutOrientation.Horizontal) {
            return Constraints.m6635getMaxHeightimpl(arg0);
        }
        return Constraints.m6636getMaxWidthimpl(arg0);
    }

    /* renamed from: copy-yUG9Ft0, reason: not valid java name */
    public static final long m651copyyUG9Ft0(long arg0, int mainAxisMin, int mainAxisMax, int crossAxisMin, int crossAxisMax) {
        return m648constructorimpl(mainAxisMin, mainAxisMax, crossAxisMin, crossAxisMax);
    }
}
