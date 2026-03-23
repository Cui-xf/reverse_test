package androidx.compose.ui.platform;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Metadata;

/* compiled from: ViewConfiguration.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0005R\u0012\u0010\u0015\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000bø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/ViewConfiguration;", "", "doubleTapMinTimeMillis", "", "getDoubleTapMinTimeMillis", "()J", "doubleTapTimeoutMillis", "getDoubleTapTimeoutMillis", "handwritingGestureLineMargin", "", "getHandwritingGestureLineMargin", "()F", "handwritingSlop", "getHandwritingSlop", "longPressTimeoutMillis", "getLongPressTimeoutMillis", "maximumFlingVelocity", "getMaximumFlingVelocity", "minimumTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "getMinimumTouchTargetSize-MYxV2XQ", "touchSlop", "getTouchSlop", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ViewConfiguration {
    long getDoubleTapMinTimeMillis();

    long getDoubleTapTimeoutMillis();

    float getHandwritingGestureLineMargin();

    float getHandwritingSlop();

    long getLongPressTimeoutMillis();

    float getMaximumFlingVelocity();

    /* renamed from: getMinimumTouchTargetSize-MYxV2XQ */
    long mo5699getMinimumTouchTargetSizeMYxV2XQ();

    float getTouchSlop();

    /* compiled from: ViewConfiguration.kt */
    /* renamed from: androidx.compose.ui.platform.ViewConfiguration$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static float $default$getHandwritingSlop(ViewConfiguration _this) {
            return 2.0f;
        }

        /* renamed from: $default$getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
        public static long m5931$default$getMinimumTouchTargetSizeMYxV2XQ(ViewConfiguration _this) {
            return DpKt.m6715DpSizeYgX7TsA(Dp.m6693constructorimpl(48), Dp.m6693constructorimpl(48));
        }

        public static float $default$getMaximumFlingVelocity(ViewConfiguration _this) {
            return Float.MAX_VALUE;
        }

        public static float $default$getHandwritingGestureLineMargin(ViewConfiguration _this) {
            return 16.0f;
        }
    }

    /* compiled from: ViewConfiguration.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static float getHandwritingSlop(ViewConfiguration $this) {
            return CC.$default$getHandwritingSlop($this);
        }

        @Deprecated
        /* renamed from: getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
        public static long m5933getMinimumTouchTargetSizeMYxV2XQ(ViewConfiguration $this) {
            return CC.m5931$default$getMinimumTouchTargetSizeMYxV2XQ($this);
        }

        @Deprecated
        public static float getMaximumFlingVelocity(ViewConfiguration $this) {
            return CC.$default$getMaximumFlingVelocity($this);
        }

        @Deprecated
        public static float getHandwritingGestureLineMargin(ViewConfiguration $this) {
            return CC.$default$getHandwritingGestureLineMargin($this);
        }
    }
}
