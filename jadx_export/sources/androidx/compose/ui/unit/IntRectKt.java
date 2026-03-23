package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

/* compiled from: IntRect.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0006\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a \u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\f\u0010\u0015\u001a\u00020\u0001*\u00020\u0016H\u0007\u001a\f\u0010\u0017\u001a\u00020\u0016*\u00020\u0001H\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"IntRect", "Landroidx/compose/ui/unit/IntRect;", "topLeft", "Landroidx/compose/ui/unit/IntOffset;", "bottomRight", "IntRect-E1MhUcY", "(JJ)Landroidx/compose/ui/unit/IntRect;", "offset", "size", "Landroidx/compose/ui/unit/IntSize;", "IntRect-VbeCjmY", "center", "radius", "", "IntRect-ar5cAso", "(JI)Landroidx/compose/ui/unit/IntRect;", "lerp", "start", "stop", "fraction", "", "roundToIntRect", "Landroidx/compose/ui/geometry/Rect;", "toRect", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IntRectKt {
    /* renamed from: IntRect-VbeCjmY, reason: not valid java name */
    public static final IntRect m6857IntRectVbeCjmY(long offset, long size) {
        return new IntRect(IntOffset.m6825getXimpl(offset), IntOffset.m6826getYimpl(offset), IntOffset.m6825getXimpl(offset) + IntSize.m6867getWidthimpl(size), IntOffset.m6826getYimpl(offset) + IntSize.m6866getHeightimpl(size));
    }

    /* renamed from: IntRect-E1MhUcY, reason: not valid java name */
    public static final IntRect m6856IntRectE1MhUcY(long topLeft, long bottomRight) {
        return new IntRect(IntOffset.m6825getXimpl(topLeft), IntOffset.m6826getYimpl(topLeft), IntOffset.m6825getXimpl(bottomRight), IntOffset.m6826getYimpl(bottomRight));
    }

    /* renamed from: IntRect-ar5cAso, reason: not valid java name */
    public static final IntRect m6858IntRectar5cAso(long center, int radius) {
        return new IntRect(IntOffset.m6825getXimpl(center) - radius, IntOffset.m6826getYimpl(center) - radius, IntOffset.m6825getXimpl(center) + radius, IntOffset.m6826getYimpl(center) + radius);
    }

    public static final IntRect lerp(IntRect start, IntRect stop, float fraction) {
        return new IntRect(MathHelpersKt.lerp(start.getLeft(), stop.getLeft(), fraction), MathHelpersKt.lerp(start.getTop(), stop.getTop(), fraction), MathHelpersKt.lerp(start.getRight(), stop.getRight(), fraction), MathHelpersKt.lerp(start.getBottom(), stop.getBottom(), fraction));
    }

    public static final Rect toRect(IntRect $this$toRect) {
        return new Rect($this$toRect.getLeft(), $this$toRect.getTop(), $this$toRect.getRight(), $this$toRect.getBottom());
    }

    public static final IntRect roundToIntRect(Rect $this$roundToIntRect) {
        float $this$fastRoundToInt$iv = $this$roundToIntRect.getLeft();
        int iRound = Math.round($this$fastRoundToInt$iv);
        float $this$fastRoundToInt$iv2 = $this$roundToIntRect.getTop();
        int iRound2 = Math.round($this$fastRoundToInt$iv2);
        float $this$fastRoundToInt$iv3 = $this$roundToIntRect.getRight();
        int iRound3 = Math.round($this$fastRoundToInt$iv3);
        float $this$fastRoundToInt$iv4 = $this$roundToIntRect.getBottom();
        return new IntRect(iRound, iRound2, iRound3, Math.round($this$fastRoundToInt$iv4));
    }
}
