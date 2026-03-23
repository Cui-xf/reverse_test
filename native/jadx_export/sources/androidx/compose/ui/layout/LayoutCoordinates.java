package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: LayoutCoordinates.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H¦\u0002J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u0003H&J\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH&ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J.\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010#\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u001a\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001fH&ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u001a\u0010*\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b+\u0010)J\u001a\u0010,\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001fH&ø\u0001\u0000¢\u0006\u0004\b-\u0010)J\u001a\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b0\u0010)J\"\u00101\u001a\u0002022\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u00103\u001a\u000204H\u0016ø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001a\u00107\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u001a\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u001fH&ø\u0001\u0000¢\u0006\u0004\b<\u0010)R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u00020\u0014X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006=À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/LayoutCoordinates;", "", "introducesMotionFrameOfReference", "", "getIntroducesMotionFrameOfReference$annotations", "()V", "getIntroducesMotionFrameOfReference", "()Z", "isAttached", "parentCoordinates", "getParentCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "get", "", "alignmentLine", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "clipBounds", "localPositionOf", "Landroidx/compose/ui/geometry/Offset;", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "includeMotionFrameOfReference", "localPositionOf-S_NoaFU", "(Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "(J)J", "localToScreen", "localToScreen-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "screenToLocal", "relativeToScreen", "screenToLocal-MK-Hz9U", "transformFrom", "", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformToScreen", "transformToScreen-58bKbWc", "([F)V", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface LayoutCoordinates {
    int get(AlignmentLine alignmentLine);

    boolean getIntroducesMotionFrameOfReference();

    LayoutCoordinates getParentCoordinates();

    LayoutCoordinates getParentLayoutCoordinates();

    Set<AlignmentLine> getProvidedAlignmentLines();

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo5537getSizeYbymL2g();

    boolean isAttached();

    Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds);

    /* renamed from: localPositionOf-R5De75A, reason: not valid java name */
    long mo5538localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource);

    /* renamed from: localPositionOf-S_NoaFU, reason: not valid java name */
    long mo5539localPositionOfS_NoaFU(LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference);

    /* renamed from: localToRoot-MK-Hz9U, reason: not valid java name */
    long mo5540localToRootMKHz9U(long relativeToLocal);

    /* renamed from: localToScreen-MK-Hz9U, reason: not valid java name */
    long mo5541localToScreenMKHz9U(long relativeToLocal);

    /* renamed from: localToWindow-MK-Hz9U, reason: not valid java name */
    long mo5542localToWindowMKHz9U(long relativeToLocal);

    /* renamed from: screenToLocal-MK-Hz9U, reason: not valid java name */
    long mo5543screenToLocalMKHz9U(long relativeToScreen);

    /* renamed from: transformFrom-EL8BTi8, reason: not valid java name */
    void mo5544transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix);

    /* renamed from: transformToScreen-58bKbWc, reason: not valid java name */
    void mo5545transformToScreen58bKbWc(float[] matrix);

    /* renamed from: windowToLocal-MK-Hz9U, reason: not valid java name */
    long mo5546windowToLocalMKHz9U(long relativeToWindow);

    /* compiled from: LayoutCoordinates.kt */
    /* renamed from: androidx.compose.ui.layout.LayoutCoordinates$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$getIntroducesMotionFrameOfReference(LayoutCoordinates _this) {
            return false;
        }

        /* renamed from: $default$screenToLocal-MK-Hz9U, reason: not valid java name */
        public static long m5549$default$screenToLocalMKHz9U(LayoutCoordinates _this, long relativeToScreen) {
            return Offset.INSTANCE.m3960getUnspecifiedF1C5BW0();
        }

        /* renamed from: $default$localToScreen-MK-Hz9U, reason: not valid java name */
        public static long m5548$default$localToScreenMKHz9U(LayoutCoordinates _this, long relativeToLocal) {
            return Offset.INSTANCE.m3960getUnspecifiedF1C5BW0();
        }

        /* renamed from: localPositionOf-S_NoaFU$default, reason: not valid java name */
        public static /* synthetic */ long m5557localPositionOfS_NoaFU$default(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, long j, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localPositionOf-S_NoaFU");
            }
            if ((i & 2) != 0) {
                j = Offset.INSTANCE.m3961getZeroF1C5BW0();
            }
            if ((i & 4) != 0) {
                z = true;
            }
            return layoutCoordinates.mo5539localPositionOfS_NoaFU(layoutCoordinates2, j, z);
        }

        /* renamed from: $default$localPositionOf-S_NoaFU, reason: not valid java name */
        public static long m5547$default$localPositionOfS_NoaFU(LayoutCoordinates _this, LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference) {
            throw new UnsupportedOperationException("localPositionOf is not implemented on this LayoutCoordinates");
        }

        public static /* synthetic */ Rect localBoundingBoxOf$default(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: localBoundingBoxOf");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            return layoutCoordinates.localBoundingBoxOf(layoutCoordinates2, z);
        }

        /* renamed from: $default$transformFrom-EL8BTi8, reason: not valid java name */
        public static void m5550$default$transformFromEL8BTi8(LayoutCoordinates _this, LayoutCoordinates sourceCoordinates, float[] matrix) {
            throw new UnsupportedOperationException("transformFrom is not implemented on this LayoutCoordinates");
        }

        /* renamed from: $default$transformToScreen-58bKbWc, reason: not valid java name */
        public static void m5551$default$transformToScreen58bKbWc(LayoutCoordinates _this, float[] matrix) {
            throw new UnsupportedOperationException("transformToScreen is not implemented on this LayoutCoordinates");
        }
    }

    /* compiled from: LayoutCoordinates.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getIntroducesMotionFrameOfReference$annotations() {
        }

        @Deprecated
        public static boolean getIntroducesMotionFrameOfReference(LayoutCoordinates $this) {
            return CC.$default$getIntroducesMotionFrameOfReference($this);
        }

        @Deprecated
        /* renamed from: screenToLocal-MK-Hz9U, reason: not valid java name */
        public static long m5561screenToLocalMKHz9U(LayoutCoordinates $this, long relativeToScreen) {
            return CC.m5549$default$screenToLocalMKHz9U($this, relativeToScreen);
        }

        @Deprecated
        /* renamed from: localToScreen-MK-Hz9U, reason: not valid java name */
        public static long m5560localToScreenMKHz9U(LayoutCoordinates $this, long relativeToLocal) {
            return CC.m5548$default$localToScreenMKHz9U($this, relativeToLocal);
        }

        @Deprecated
        /* renamed from: localPositionOf-S_NoaFU, reason: not valid java name */
        public static long m5558localPositionOfS_NoaFU(LayoutCoordinates $this, LayoutCoordinates sourceCoordinates, long relativeToSource, boolean includeMotionFrameOfReference) {
            return CC.m5547$default$localPositionOfS_NoaFU($this, sourceCoordinates, relativeToSource, includeMotionFrameOfReference);
        }

        @Deprecated
        /* renamed from: transformFrom-EL8BTi8, reason: not valid java name */
        public static void m5562transformFromEL8BTi8(LayoutCoordinates $this, LayoutCoordinates sourceCoordinates, float[] matrix) {
            CC.m5550$default$transformFromEL8BTi8($this, sourceCoordinates, matrix);
        }

        @Deprecated
        /* renamed from: transformToScreen-58bKbWc, reason: not valid java name */
        public static void m5563transformToScreen58bKbWc(LayoutCoordinates $this, float[] matrix) {
            CC.m5551$default$transformToScreen58bKbWc($this, matrix);
        }
    }
}
