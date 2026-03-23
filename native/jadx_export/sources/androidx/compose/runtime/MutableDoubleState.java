package androidx.compose.runtime;

import androidx.compose.runtime.MutableDoubleState;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapshotDoubleState.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001!B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0015\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u0018H\u0096\u0002J\"\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R$\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Landroidx/compose/runtime/SnapshotMutableDoubleStateImpl;", "Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/MutableDoubleState;", "Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "", "value", "(D)V", "doubleValue", "getDoubleValue", "()D", "setDoubleValue", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "next", "Landroidx/compose/runtime/SnapshotMutableDoubleStateImpl$DoubleStateStateRecord;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "component1", "()Ljava/lang/Double;", "component2", "Lkotlin/Function1;", "", "mergeRecords", "previous", "current", "applied", "prependStateRecord", "toString", "", "DoubleStateStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.runtime.SnapshotMutableDoubleStateImpl, reason: from toString */
/* loaded from: classes.dex */
public class MutableDoubleState extends StateObjectImpl implements androidx.compose.runtime.MutableDoubleState, SnapshotMutableState<Double> {
    public static final int $stable = 0;
    private DoubleStateStateRecord next;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.MutableDoubleState, androidx.compose.runtime.DoubleState, androidx.compose.runtime.State
    public /* synthetic */ Double getValue() {
        return MutableDoubleState.CC.$default$getValue((androidx.compose.runtime.MutableDoubleState) this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Double, java.lang.Object] */
    @Override // androidx.compose.runtime.State
    public /* bridge */ /* synthetic */ Double getValue() {
        return getValue();
    }

    @Override // androidx.compose.runtime.MutableDoubleState
    public /* synthetic */ void setValue(double d) {
        setDoubleValue(d);
    }

    @Override // androidx.compose.runtime.MutableState
    public /* bridge */ /* synthetic */ void setValue(Double d) {
        setValue(d.doubleValue());
    }

    public MutableDoubleState(double value) {
        DoubleStateStateRecord it = new DoubleStateStateRecord(value);
        if (Snapshot.INSTANCE.isInSnapshot()) {
            DoubleStateStateRecord next = new DoubleStateStateRecord(value);
            next.setSnapshotId$runtime_release(1);
            it.setNext$runtime_release(next);
        }
        this.next = it;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.MutableDoubleState, androidx.compose.runtime.DoubleState
    public double getDoubleValue() {
        return ((DoubleStateStateRecord) SnapshotKt.readable(this.next, this)).getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    @Override // androidx.compose.runtime.MutableDoubleState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setDoubleValue(double r14) {
        /*
            r13 = this;
            androidx.compose.runtime.SnapshotMutableDoubleStateImpl$DoubleStateStateRecord r0 = r13.next
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0
            r1 = 0
            androidx.compose.runtime.snapshots.StateRecord r2 = androidx.compose.runtime.snapshots.SnapshotKt.current(r0)
            androidx.compose.runtime.SnapshotMutableDoubleStateImpl$DoubleStateStateRecord r2 = (androidx.compose.runtime.MutableDoubleState.DoubleStateStateRecord) r2
            r3 = 0
            double r4 = r2.getValue()
            r6 = 0
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 23
            r9 = 1
            r10 = 0
            if (r7 < r8) goto L20
            int r7 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r7 != 0) goto L1e
            goto L37
        L1e:
            r9 = 0
            goto L37
        L20:
            boolean r7 = androidx.compose.runtime.internal.FloatingPointEquality_androidKt.isNan(r4)
            if (r7 != 0) goto L36
            boolean r7 = androidx.compose.runtime.internal.FloatingPointEquality_androidKt.isNan(r14)
            if (r7 != 0) goto L36
            int r7 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r7 != 0) goto L32
            r7 = 1
            goto L33
        L32:
            r7 = 0
        L33:
            if (r7 == 0) goto L36
            goto L37
        L36:
            r9 = 0
        L37:
            if (r9 != 0) goto L76
            androidx.compose.runtime.SnapshotMutableDoubleStateImpl$DoubleStateStateRecord r4 = r13.next
            androidx.compose.runtime.snapshots.StateRecord r4 = (androidx.compose.runtime.snapshots.StateRecord) r4
            r5 = 0
            r6 = 0
            androidx.compose.runtime.snapshots.Snapshot r6 = androidx.compose.runtime.snapshots.SnapshotKt.getSnapshotInitializer()
            r7 = 0
            java.lang.Object r8 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            r9 = 0
            monitor-enter(r8)
            r10 = 0
            androidx.compose.runtime.snapshots.Snapshot$Companion r11 = androidx.compose.runtime.snapshots.Snapshot.INSTANCE     // Catch: java.lang.Throwable -> L73
            androidx.compose.runtime.snapshots.Snapshot r11 = r11.getCurrent()     // Catch: java.lang.Throwable -> L73
            r6 = r11
            r11 = r13
            androidx.compose.runtime.snapshots.StateObject r11 = (androidx.compose.runtime.snapshots.StateObject) r11     // Catch: java.lang.Throwable -> L73
            r12 = r2
            androidx.compose.runtime.snapshots.StateRecord r12 = (androidx.compose.runtime.snapshots.StateRecord) r12     // Catch: java.lang.Throwable -> L73
            androidx.compose.runtime.snapshots.StateRecord r11 = androidx.compose.runtime.snapshots.SnapshotKt.overwritableRecord(r4, r11, r6, r12)     // Catch: java.lang.Throwable -> L73
            androidx.compose.runtime.SnapshotMutableDoubleStateImpl$DoubleStateStateRecord r11 = (androidx.compose.runtime.MutableDoubleState.DoubleStateStateRecord) r11     // Catch: java.lang.Throwable -> L73
            r12 = 0
            r11.setValue(r14)     // Catch: java.lang.Throwable -> L73
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L73
            monitor-exit(r8)
            r7 = 0
            r8 = r13
            androidx.compose.runtime.snapshots.StateObject r8 = (androidx.compose.runtime.snapshots.StateObject) r8
            androidx.compose.runtime.snapshots.SnapshotKt.notifyWrite(r6, r8)
            goto L76
        L73:
            r10 = move-exception
            monitor-exit(r8)
            throw r10
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.MutableDoubleState.setDoubleValue(double):void");
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public SnapshotMutationPolicy<Double> getPolicy() {
        return SnapshotStateKt.structuralEqualityPolicy();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.MutableState
    public Double component1() {
        return Double.valueOf(getDoubleValue());
    }

    @Override // androidx.compose.runtime.MutableState
    public Function1<Double, Unit> component2() {
        return new Function1<Double, Unit>() { // from class: androidx.compose.runtime.SnapshotMutableDoubleStateImpl.component2.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Double d) {
                invoke(d.doubleValue());
                return Unit.INSTANCE;
            }

            public final void invoke(double it) {
                MutableDoubleState.this.setDoubleValue(it);
            }
        };
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
        this.next = (DoubleStateStateRecord) value;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    @Override // androidx.compose.runtime.snapshots.StateObjectImpl, androidx.compose.runtime.snapshots.StateObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.compose.runtime.snapshots.StateRecord mergeRecords(androidx.compose.runtime.snapshots.StateRecord r12, androidx.compose.runtime.snapshots.StateRecord r13, androidx.compose.runtime.snapshots.StateRecord r14) {
        /*
            r11 = this;
            java.lang.String r0 = "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r0)
            r1 = r13
            androidx.compose.runtime.SnapshotMutableDoubleStateImpl$DoubleStateStateRecord r1 = (androidx.compose.runtime.MutableDoubleState.DoubleStateStateRecord) r1
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14, r0)
            r0 = r14
            androidx.compose.runtime.SnapshotMutableDoubleStateImpl$DoubleStateStateRecord r0 = (androidx.compose.runtime.MutableDoubleState.DoubleStateStateRecord) r0
            double r2 = r1.getValue()
            double r4 = r0.getValue()
            r6 = 0
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 23
            r9 = 1
            r10 = 0
            if (r7 < r8) goto L27
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 != 0) goto L25
            goto L3e
        L25:
            r9 = 0
            goto L3e
        L27:
            boolean r7 = androidx.compose.runtime.internal.FloatingPointEquality_androidKt.isNan(r2)
            if (r7 != 0) goto L3d
            boolean r7 = androidx.compose.runtime.internal.FloatingPointEquality_androidKt.isNan(r4)
            if (r7 != 0) goto L3d
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 != 0) goto L39
            r7 = 1
            goto L3a
        L39:
            r7 = 0
        L3a:
            if (r7 == 0) goto L3d
            goto L3e
        L3d:
            r9 = 0
        L3e:
            if (r9 == 0) goto L43
            r2 = r13
            goto L44
        L43:
            r2 = 0
        L44:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.MutableDoubleState.mergeRecords(androidx.compose.runtime.snapshots.StateRecord, androidx.compose.runtime.snapshots.StateRecord, androidx.compose.runtime.snapshots.StateRecord):androidx.compose.runtime.snapshots.StateRecord");
    }

    public String toString() {
        StateRecord $this$withCurrent$iv = this.next;
        DoubleStateStateRecord it = (DoubleStateStateRecord) SnapshotKt.current($this$withCurrent$iv);
        return "MutableDoubleState(value=" + it.getValue() + ")@" + hashCode();
    }

    /* compiled from: SnapshotDoubleState.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\b\u0010\n\u001a\u00020\u0001H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000b"}, d2 = {"Landroidx/compose/runtime/SnapshotMutableDoubleStateImpl$DoubleStateStateRecord;", "Landroidx/compose/runtime/snapshots/StateRecord;", "value", "", "(D)V", "getValue", "()D", "setValue", "assign", "", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.SnapshotMutableDoubleStateImpl$DoubleStateStateRecord */
    private static final class DoubleStateStateRecord extends StateRecord {
        private double value;

        public final double getValue() {
            return this.value;
        }

        public final void setValue(double d) {
            this.value = d;
        }

        public DoubleStateStateRecord(double value) {
            this.value = value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableDoubleStateImpl.DoubleStateStateRecord");
            this.value = ((DoubleStateStateRecord) value).value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new DoubleStateStateRecord(this.value);
        }
    }
}
