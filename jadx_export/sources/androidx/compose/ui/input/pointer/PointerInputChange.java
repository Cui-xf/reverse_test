package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PointerEvent.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B[\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0002\u0010\u0011BQ\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0014Bu\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0002\u0010\u001bBa\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0002\u0010\u001cJ\u0006\u0010<\u001a\u00020=Jt\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\u0086\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\bE\u0010FJl\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\bG\u0010HJt\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\bI\u0010JJj\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010LJz\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020\u00072\b\b\u0002\u0010A\u001a\u00020\t2\b\b\u0002\u0010B\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u0010\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ\b\u0010O\u001a\u00020PH\u0016R\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001fR&\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00138\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001f\u001a\u0004\b\"\u0010#R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188GX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0017\u0010*\u001a\u00020\t8F¢\u0006\f\u0012\u0004\b+\u0010\u001f\u001a\u0004\b*\u0010,R\"\u0010\u001a\u001a\u00020\u0007X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b-\u0010(\"\u0004\b.\u0010/R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010)\u001a\u0004\b0\u0010(R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010,R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0019\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010)\u001a\u0004\b4\u0010(R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b5\u0010,R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u0019\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010)\u001a\u0004\b7\u0010(R\u0019\u0010\u000e\u001a\u00020\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010:\u001a\u0004\b8\u00109R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010(\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "uptimeMillis", "", "position", "Landroidx/compose/ui/geometry/Offset;", "pressed", "", "previousUptimeMillis", "previousPosition", "previousPressed", "isInitiallyConsumed", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "scrollDelta", "(JJJZJJZZIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "consumed", "Landroidx/compose/ui/input/pointer/ConsumedData;", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "pressure", "", "historical", "", "Landroidx/compose/ui/input/pointer/HistoricalChange;", "originalEventPosition", "(JJJZFJJZZILjava/util/List;JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "(JJJZFJJZZIJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "_historical", "get_historical$annotations", "()V", "<set-?>", "getConsumed$annotations", "getConsumed", "()Landroidx/compose/ui/input/pointer/ConsumedData;", "getHistorical$annotations", "getHistorical", "()Ljava/util/List;", "getId-J3iCeTQ", "()J", "J", "isConsumed", "isConsumed$annotations", "()Z", "getOriginalEventPosition-F1C5BW0$ui_release", "setOriginalEventPosition-k-4lQ0M$ui_release", "(J)V", "getPosition-F1C5BW0", "getPressed", "getPressure", "()F", "getPreviousPosition-F1C5BW0", "getPreviousPressed", "getPreviousUptimeMillis", "getScrollDelta-F1C5BW0", "getType-T8wyACA", "()I", "I", "getUptimeMillis", "consume", "", "copy", "currentTime", "currentPosition", "currentPressed", "previousTime", "copy-Tn9QgHE", "(JJJZFJJZIJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-wbzehF4", "(JJJZFJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-Ezr-O64", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;I)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-0GkPj7c", "(JJJZJJZLandroidx/compose/ui/input/pointer/ConsumedData;IJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-JKmWfYY", "(JJJZJJZIJ)Landroidx/compose/ui/input/pointer/PointerInputChange;", "copy-OHpmEuE", "(JJJZJJZILjava/util/List;J)Landroidx/compose/ui/input/pointer/PointerInputChange;", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerInputChange {
    public static final int $stable = 0;
    private List<HistoricalChange> _historical;
    private ConsumedData consumed;
    private final long id;
    private long originalEventPosition;
    private final long position;
    private final boolean pressed;
    private final float pressure;
    private final long previousPosition;
    private final boolean previousPressed;
    private final long previousUptimeMillis;
    private final long scrollDelta;
    private final int type;
    private final long uptimeMillis;

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, i, j6);
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, List list, long j6, long j7, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, i, (List<HistoricalChange>) list, j6, j7);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another constructor with `scrollDelta` and without `ConsumedData` instead", replaceWith = @ReplaceWith(expression = "this(id, uptimeMillis, position, pressed, previousUptimeMillis, previousPosition, previousPressed, consumed.downChange || consumed.positionChange, type, Offset.Zero)", imports = {}))
    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j4, j5, z2, consumedData, i);
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, boolean z3, int i, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j4, j5, z2, z3, i, j6);
    }

    @Deprecated(message = "use isConsumed and consume() pair of methods instead")
    public static /* synthetic */ void getConsumed$annotations() {
    }

    public static /* synthetic */ void getHistorical$annotations() {
    }

    private static /* synthetic */ void get_historical$annotations() {
    }

    public static /* synthetic */ void isConsumed$annotations() {
    }

    private PointerInputChange(long id, long uptimeMillis, long position, boolean pressed, float pressure, long previousUptimeMillis, long previousPosition, boolean previousPressed, boolean isInitiallyConsumed, int type, long scrollDelta) {
        this.id = id;
        this.uptimeMillis = uptimeMillis;
        this.position = position;
        this.pressed = pressed;
        this.pressure = pressure;
        this.previousUptimeMillis = previousUptimeMillis;
        this.previousPosition = previousPosition;
        this.previousPressed = previousPressed;
        this.type = type;
        this.scrollDelta = scrollDelta;
        this.originalEventPosition = Offset.INSTANCE.m3961getZeroF1C5BW0();
        this.consumed = new ConsumedData(isInitiallyConsumed, isInitiallyConsumed);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, long j6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        int iM5484getTouchT8wyACA;
        long jM3961getZeroF1C5BW0;
        if ((i2 & 512) == 0) {
            iM5484getTouchT8wyACA = i;
        } else {
            iM5484getTouchT8wyACA = PointerType.INSTANCE.m5484getTouchT8wyACA();
        }
        if ((i2 & 1024) == 0) {
            jM3961getZeroF1C5BW0 = j6;
        } else {
            jM3961getZeroF1C5BW0 = Offset.INSTANCE.m3961getZeroF1C5BW0();
        }
        this(j, j2, j3, z, f, j4, j5, z2, z3, iM5484getTouchT8wyACA, jM3961getZeroF1C5BW0, (DefaultConstructorMarker) null);
    }

    /* renamed from: getId-J3iCeTQ, reason: not valid java name and from getter */
    public final long getId() {
        return this.id;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    /* renamed from: getPosition-F1C5BW0, reason: not valid java name and from getter */
    public final long getPosition() {
        return this.position;
    }

    public final boolean getPressed() {
        return this.pressed;
    }

    public final float getPressure() {
        return this.pressure;
    }

    public final long getPreviousUptimeMillis() {
        return this.previousUptimeMillis;
    }

    /* renamed from: getPreviousPosition-F1C5BW0, reason: not valid java name and from getter */
    public final long getPreviousPosition() {
        return this.previousPosition;
    }

    public final boolean getPreviousPressed() {
        return this.previousPressed;
    }

    /* renamed from: getType-T8wyACA, reason: not valid java name and from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: getScrollDelta-F1C5BW0, reason: not valid java name and from getter */
    public final long getScrollDelta() {
        return this.scrollDelta;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, boolean z3, int i, long j6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        int iM5484getTouchT8wyACA;
        long jM3961getZeroF1C5BW0;
        if ((i2 & 256) == 0) {
            iM5484getTouchT8wyACA = i;
        } else {
            iM5484getTouchT8wyACA = PointerType.INSTANCE.m5484getTouchT8wyACA();
        }
        if ((i2 & 512) == 0) {
            jM3961getZeroF1C5BW0 = j6;
        } else {
            jM3961getZeroF1C5BW0 = Offset.INSTANCE.m3961getZeroF1C5BW0();
        }
        this(j, j2, j3, z, j4, j5, z2, z3, iM5484getTouchT8wyACA, jM3961getZeroF1C5BW0, (DefaultConstructorMarker) null);
    }

    private PointerInputChange(long id, long uptimeMillis, long position, boolean pressed, long previousUptimeMillis, long previousPosition, boolean previousPressed, boolean isInitiallyConsumed, int type, long scrollDelta) {
        this(id, uptimeMillis, position, pressed, 1.0f, previousUptimeMillis, previousPosition, previousPressed, isInitiallyConsumed, type, scrollDelta, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        int iM5484getTouchT8wyACA;
        if ((i2 & 256) == 0) {
            iM5484getTouchT8wyACA = i;
        } else {
            iM5484getTouchT8wyACA = PointerType.INSTANCE.m5484getTouchT8wyACA();
        }
        this(j, j2, j3, z, j4, j5, z2, consumedData, iM5484getTouchT8wyACA, (DefaultConstructorMarker) null);
    }

    private PointerInputChange(long id, long uptimeMillis, long position, boolean pressed, long previousUptimeMillis, long previousPosition, boolean previousPressed, ConsumedData consumed, int type) {
        this(id, uptimeMillis, position, pressed, 1.0f, previousUptimeMillis, previousPosition, previousPressed, consumed.getDownChange() || consumed.getPositionChange(), type, Offset.INSTANCE.m3961getZeroF1C5BW0(), (DefaultConstructorMarker) null);
    }

    private PointerInputChange(long id, long uptimeMillis, long position, boolean pressed, float pressure, long previousUptimeMillis, long previousPosition, boolean previousPressed, boolean isInitiallyConsumed, int type, List<HistoricalChange> list, long scrollDelta, long originalEventPosition) {
        this(id, uptimeMillis, position, pressed, pressure, previousUptimeMillis, previousPosition, previousPressed, isInitiallyConsumed, type, scrollDelta, (DefaultConstructorMarker) null);
        this._historical = list;
        this.originalEventPosition = originalEventPosition;
    }

    public final List<HistoricalChange> getHistorical() {
        List<HistoricalChange> list = this._historical;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* renamed from: getOriginalEventPosition-F1C5BW0$ui_release, reason: not valid java name and from getter */
    public final long getOriginalEventPosition() {
        return this.originalEventPosition;
    }

    /* renamed from: setOriginalEventPosition-k-4lQ0M$ui_release, reason: not valid java name */
    public final void m5408setOriginalEventPositionk4lQ0M$ui_release(long j) {
        this.originalEventPosition = j;
    }

    public final boolean isConsumed() {
        return this.consumed.getDownChange() || this.consumed.getPositionChange();
    }

    public final void consume() {
        this.consumed.setDownChange(true);
        this.consumed.setPositionChange(true);
    }

    public final ConsumedData getConsumed() {
        return this.consumed;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another copy() method with scrollDelta parameter instead", replaceWith = @ReplaceWith(expression = "copy(id,currentTime, currentPosition, currentPressed, previousTime,previousPosition, previousPressed, consumed, type, this.scrollDelta)", imports = {}))
    /* renamed from: copy-Ezr-O64, reason: not valid java name */
    public final /* synthetic */ PointerInputChange m5397copyEzrO64(long id, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition, boolean previousPressed, ConsumedData consumed, int type) {
        PointerInputChange pointerInputChange = new PointerInputChange(id, currentTime, currentPosition, currentPressed, this.pressure, previousTime, previousPosition, previousPressed, consumed.getDownChange() || consumed.getPositionChange(), type, getHistorical(), this.scrollDelta, this.originalEventPosition, null);
        this.consumed = consumed;
        return pointerInputChange;
    }

    /* renamed from: copy-JKmWfYY$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m5392copyJKmWfYY$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, int i, long j6, int i2, Object obj) {
        long j7;
        long j8;
        long j9 = (i2 & 1) != 0 ? pointerInputChange.id : j;
        long j10 = (i2 & 2) != 0 ? pointerInputChange.uptimeMillis : j2;
        long j11 = (i2 & 4) != 0 ? pointerInputChange.position : j3;
        boolean z3 = (i2 & 8) != 0 ? pointerInputChange.pressed : z;
        long j12 = (i2 & 16) != 0 ? pointerInputChange.previousUptimeMillis : j4;
        long j13 = (i2 & 32) != 0 ? pointerInputChange.previousPosition : j5;
        boolean z4 = (i2 & 64) != 0 ? pointerInputChange.previousPressed : z2;
        int i3 = (i2 & 128) != 0 ? pointerInputChange.type : i;
        if ((i2 & 256) != 0) {
            j7 = j9;
            j8 = pointerInputChange.scrollDelta;
        } else {
            j7 = j9;
            j8 = j6;
        }
        return pointerInputChange.m5398copyJKmWfYY(j7, j10, j11, z3, j12, j13, z4, i3, j8);
    }

    /* renamed from: copy-JKmWfYY, reason: not valid java name */
    public final PointerInputChange m5398copyJKmWfYY(long id, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition, boolean previousPressed, int type, long scrollDelta) {
        return m5401copywbzehF4(id, currentTime, currentPosition, currentPressed, this.pressure, previousTime, previousPosition, previousPressed, type, getHistorical(), scrollDelta);
    }

    /* renamed from: copy-0GkPj7c$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m5390copy0GkPj7c$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, long j6, int i2, Object obj) {
        long j7;
        long j8;
        long j9 = (i2 & 1) != 0 ? pointerInputChange.id : j;
        long j10 = (i2 & 2) != 0 ? pointerInputChange.uptimeMillis : j2;
        long j11 = (i2 & 4) != 0 ? pointerInputChange.position : j3;
        boolean z3 = (i2 & 8) != 0 ? pointerInputChange.pressed : z;
        long j12 = (i2 & 16) != 0 ? pointerInputChange.previousUptimeMillis : j4;
        long j13 = (i2 & 32) != 0 ? pointerInputChange.previousPosition : j5;
        boolean z4 = (i2 & 64) != 0 ? pointerInputChange.previousPressed : z2;
        int i3 = (i2 & 256) != 0 ? pointerInputChange.type : i;
        if ((i2 & 512) != 0) {
            j7 = j9;
            j8 = pointerInputChange.scrollDelta;
        } else {
            j7 = j9;
            j8 = j6;
        }
        return pointerInputChange.m5396copy0GkPj7c(j7, j10, j11, z3, j12, j13, z4, consumedData, i3, j8);
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use copy() instead without `consumed` parameter to create a shallow copy or a constructor to create a new PointerInputChange", replaceWith = @ReplaceWith(expression = "copy(id, currentTime, currentPosition, currentPressed, previousTime, previousPosition, previousPressed, type, scrollDelta)", imports = {}))
    /* renamed from: copy-0GkPj7c, reason: not valid java name */
    public final PointerInputChange m5396copy0GkPj7c(long id, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition, boolean previousPressed, ConsumedData consumed, int type, long scrollDelta) {
        PointerInputChange pointerInputChange = new PointerInputChange(id, currentTime, currentPosition, currentPressed, this.pressure, previousTime, previousPosition, previousPressed, consumed.getDownChange() || consumed.getPositionChange(), type, getHistorical(), scrollDelta, this.originalEventPosition, null);
        this.consumed = consumed;
        return pointerInputChange;
    }

    /* renamed from: copy-Tn9QgHE$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m5394copyTn9QgHE$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, int i, long j6, int i2, Object obj) {
        long j7;
        long j8;
        long j9 = (i2 & 1) != 0 ? pointerInputChange.id : j;
        long j10 = (i2 & 2) != 0 ? pointerInputChange.uptimeMillis : j2;
        long j11 = (i2 & 4) != 0 ? pointerInputChange.position : j3;
        boolean z3 = (i2 & 8) != 0 ? pointerInputChange.pressed : z;
        float f2 = (i2 & 16) != 0 ? pointerInputChange.pressure : f;
        long j12 = (i2 & 32) != 0 ? pointerInputChange.previousUptimeMillis : j4;
        long j13 = (i2 & 64) != 0 ? pointerInputChange.previousPosition : j5;
        boolean z4 = (i2 & 128) != 0 ? pointerInputChange.previousPressed : z2;
        int i3 = (i2 & 256) != 0 ? pointerInputChange.type : i;
        if ((i2 & 512) != 0) {
            j7 = j9;
            j8 = pointerInputChange.scrollDelta;
        } else {
            j7 = j9;
            j8 = j6;
        }
        return pointerInputChange.m5400copyTn9QgHE(j7, j10, j11, z3, f2, j12, j13, z4, i3, j8);
    }

    /* renamed from: copy-Tn9QgHE, reason: not valid java name */
    public final PointerInputChange m5400copyTn9QgHE(long id, long currentTime, long currentPosition, boolean currentPressed, float pressure, long previousTime, long previousPosition, boolean previousPressed, int type, long scrollDelta) {
        PointerInputChange it = new PointerInputChange(id, currentTime, currentPosition, currentPressed, pressure, previousTime, previousPosition, previousPressed, false, type, getHistorical(), scrollDelta, this.originalEventPosition, null);
        it.consumed = this.consumed;
        return it;
    }

    /* renamed from: copy-OHpmEuE$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m5393copyOHpmEuE$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, int i, List list, long j6, int i2, Object obj) {
        long j7;
        long j8;
        long j9 = (i2 & 1) != 0 ? pointerInputChange.id : j;
        long j10 = (i2 & 2) != 0 ? pointerInputChange.uptimeMillis : j2;
        long j11 = (i2 & 4) != 0 ? pointerInputChange.position : j3;
        boolean z3 = (i2 & 8) != 0 ? pointerInputChange.pressed : z;
        long j12 = (i2 & 16) != 0 ? pointerInputChange.previousUptimeMillis : j4;
        long j13 = (i2 & 32) != 0 ? pointerInputChange.previousPosition : j5;
        boolean z4 = (i2 & 64) != 0 ? pointerInputChange.previousPressed : z2;
        int i3 = (i2 & 128) != 0 ? pointerInputChange.type : i;
        if ((i2 & 512) != 0) {
            j7 = j9;
            j8 = pointerInputChange.scrollDelta;
        } else {
            j7 = j9;
            j8 = j6;
        }
        return pointerInputChange.m5399copyOHpmEuE(j7, j10, j11, z3, j12, j13, z4, i3, list, j8);
    }

    /* renamed from: copy-OHpmEuE, reason: not valid java name */
    public final PointerInputChange m5399copyOHpmEuE(long id, long currentTime, long currentPosition, boolean currentPressed, long previousTime, long previousPosition, boolean previousPressed, int type, List<HistoricalChange> historical, long scrollDelta) {
        return m5401copywbzehF4(id, currentTime, currentPosition, currentPressed, this.pressure, previousTime, previousPosition, previousPressed, type, historical, scrollDelta);
    }

    /* renamed from: copy-wbzehF4$default, reason: not valid java name */
    public static /* synthetic */ PointerInputChange m5395copywbzehF4$default(PointerInputChange pointerInputChange, long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, int i, List list, long j6, int i2, Object obj) {
        List list2;
        long j7;
        long j8 = (i2 & 1) != 0 ? pointerInputChange.id : j;
        long j9 = (i2 & 2) != 0 ? pointerInputChange.uptimeMillis : j2;
        long j10 = (i2 & 4) != 0 ? pointerInputChange.position : j3;
        boolean z3 = (i2 & 8) != 0 ? pointerInputChange.pressed : z;
        float f2 = (i2 & 16) != 0 ? pointerInputChange.pressure : f;
        long j11 = (i2 & 32) != 0 ? pointerInputChange.previousUptimeMillis : j4;
        long j12 = (i2 & 64) != 0 ? pointerInputChange.previousPosition : j5;
        boolean z4 = (i2 & 128) != 0 ? pointerInputChange.previousPressed : z2;
        int i3 = (i2 & 256) != 0 ? pointerInputChange.type : i;
        long j13 = j8;
        List historical = (i2 & 512) != 0 ? pointerInputChange.getHistorical() : list;
        if ((i2 & 1024) != 0) {
            list2 = historical;
            j7 = pointerInputChange.scrollDelta;
        } else {
            list2 = historical;
            j7 = j6;
        }
        return pointerInputChange.m5401copywbzehF4(j13, j9, j10, z3, f2, j11, j12, z4, i3, list2, j7);
    }

    /* renamed from: copy-wbzehF4, reason: not valid java name */
    public final PointerInputChange m5401copywbzehF4(long id, long currentTime, long currentPosition, boolean currentPressed, float pressure, long previousTime, long previousPosition, boolean previousPressed, int type, List<HistoricalChange> historical, long scrollDelta) {
        PointerInputChange it = new PointerInputChange(id, currentTime, currentPosition, currentPressed, pressure, previousTime, previousPosition, previousPressed, false, type, historical, scrollDelta, this.originalEventPosition, null);
        it.consumed = this.consumed;
        return it;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PointerInputChange(id=").append((Object) PointerId.m5388toStringimpl(this.id)).append(", uptimeMillis=").append(this.uptimeMillis).append(", position=").append((Object) Offset.m3953toStringimpl(this.position)).append(", pressed=").append(this.pressed).append(", pressure=").append(this.pressure).append(", previousUptimeMillis=").append(this.previousUptimeMillis).append(", previousPosition=").append((Object) Offset.m3953toStringimpl(this.previousPosition)).append(", previousPressed=").append(this.previousPressed).append(", isConsumed=").append(isConsumed()).append(", type=").append((Object) PointerType.m5479toStringimpl(this.type)).append(", historical=").append(getHistorical()).append(",scrollDelta=");
        sb.append((Object) Offset.m3953toStringimpl(this.scrollDelta)).append(')');
        return sb.toString();
    }
}
