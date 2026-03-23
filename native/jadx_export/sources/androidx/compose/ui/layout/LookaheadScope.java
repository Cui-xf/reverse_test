package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;

/* compiled from: LookaheadScope.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J2\u0010\u0007\u001a\u00020\b*\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u000f\u001a\u00020\u0003*\u00020\u0003H&R\u0016\u0010\u0002\u001a\u00020\u0003*\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/layout/LookaheadScope;", "", "lookaheadScopeCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getLookaheadScopeCoordinates", "(Landroidx/compose/ui/layout/Placeable$PlacementScope;)Landroidx/compose/ui/layout/LayoutCoordinates;", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "sourceCoordinates", "relativeToSource", "includeMotionFrameOfReference", "", "localLookaheadPositionOf-au-aQtc", "(Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "toLookaheadCoordinates", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface LookaheadScope {
    LayoutCoordinates getLookaheadScopeCoordinates(Placeable.PlacementScope placementScope);

    /* renamed from: localLookaheadPositionOf-au-aQtc */
    long mo104localLookaheadPositionOfauaQtc(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, long j, boolean z);

    LayoutCoordinates toLookaheadCoordinates(LayoutCoordinates layoutCoordinates);

    /* compiled from: LookaheadScope.kt */
    /* renamed from: androidx.compose.ui.layout.LookaheadScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* renamed from: localLookaheadPositionOf-au-aQtc$default, reason: not valid java name */
        public static /* synthetic */ long m5569localLookaheadPositionOfauaQtc$default(LookaheadScope lookaheadScope, LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, long j, boolean z, int i, Object obj) {
            long jM3961getZeroF1C5BW0;
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localLookaheadPositionOf-au-aQtc");
            }
            if ((i & 2) == 0) {
                jM3961getZeroF1C5BW0 = j;
            } else {
                jM3961getZeroF1C5BW0 = Offset.INSTANCE.m3961getZeroF1C5BW0();
            }
            return lookaheadScope.mo104localLookaheadPositionOfauaQtc(layoutCoordinates, layoutCoordinates2, jM3961getZeroF1C5BW0, (i & 4) != 0 ? true : z);
        }
    }
}
