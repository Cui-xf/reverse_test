package androidx.compose.runtime;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SnapshotFloatState.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001!B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0015\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u0018H\u0096\u0002J\"\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0006R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Landroidx/compose/runtime/SnapshotMutableFloatStateImpl;", "Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/MutableFloatState;", "Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "", "value", "(F)V", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "floatValue", "getFloatValue", "()F", "setFloatValue", "next", "Landroidx/compose/runtime/SnapshotMutableFloatStateImpl$FloatStateStateRecord;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "component1", "()Ljava/lang/Float;", "component2", "Lkotlin/Function1;", "", "mergeRecords", "previous", "current", "applied", "prependStateRecord", "toString", "", "FloatStateStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.runtime.SnapshotMutableFloatStateImpl, reason: from toString */
/* loaded from: classes.dex */
public class MutableFloatState extends StateObjectImpl implements androidx.compose.runtime.MutableFloatState, SnapshotMutableState<Float> {
    public static final int $stable = 0;
    private FloatStateStateRecord next;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.MutableFloatState, androidx.compose.runtime.FloatState, androidx.compose.runtime.State
    public /* synthetic */ Float getValue() {
        return MutableFloatState.CC.$default$getValue((androidx.compose.runtime.MutableFloatState) this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Float, java.lang.Object] */
    @Override // androidx.compose.runtime.State
    public /* bridge */ /* synthetic */ Float getValue() {
        return getValue();
    }

    @Override // androidx.compose.runtime.MutableFloatState
    public /* synthetic */ void setValue(float f) {
        setFloatValue(f);
    }

    @Override // androidx.compose.runtime.MutableState
    public /* bridge */ /* synthetic */ void setValue(Float f) {
        setValue(f.floatValue());
    }

    public MutableFloatState(float value) {
        FloatStateStateRecord it = new FloatStateStateRecord(value);
        if (Snapshot.INSTANCE.isInSnapshot()) {
            FloatStateStateRecord next = new FloatStateStateRecord(value);
            next.setSnapshotId$runtime_release(1);
            it.setNext$runtime_release(next);
        }
        this.next = it;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.next;
    }

    @Override // androidx.compose.runtime.MutableFloatState, androidx.compose.runtime.FloatState
    public float getFloatValue() {
        return ((FloatStateStateRecord) SnapshotKt.readable(this.next, this)).getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    @Override // androidx.compose.runtime.MutableFloatState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setFloatValue(float r14) {
        /*
            r13 = this;
            androidx.compose.runtime.SnapshotMutableFloatStateImpl$FloatStateStateRecord r0 = r13.next
            androidx.compose.runtime.snapshots.StateRecord r0 = (androidx.compose.runtime.snapshots.StateRecord) r0
            r1 = 0
            androidx.compose.runtime.snapshots.StateRecord r2 = androidx.compose.runtime.snapshots.SnapshotKt.current(r0)
            androidx.compose.runtime.SnapshotMutableFloatStateImpl$FloatStateStateRecord r2 = (androidx.compose.runtime.MutableFloatState.FloatStateStateRecord) r2
            r3 = 0
            float r4 = r2.getValue()
            r5 = 0
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 23
            r8 = 1
            r9 = 0
            if (r6 < r7) goto L20
            int r6 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r6 != 0) goto L1e
            goto L37
        L1e:
            r8 = 0
            goto L37
        L20:
            boolean r6 = androidx.compose.runtime.internal.FloatingPointEquality_androidKt.isNan(r4)
            if (r6 != 0) goto L36
            boolean r6 = androidx.compose.runtime.internal.FloatingPointEquality_androidKt.isNan(r14)
            if (r6 != 0) goto L36
            int r6 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r6 != 0) goto L32
            r6 = 1
            goto L33
        L32:
            r6 = 0
        L33:
            if (r6 == 0) goto L36
            goto L37
        L36:
            r8 = 0
        L37:
            if (r8 != 0) goto L76
            androidx.compose.runtime.SnapshotMutableFloatStateImpl$FloatStateStateRecord r4 = r13.next
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
            androidx.compose.runtime.SnapshotMutableFloatStateImpl$FloatStateStateRecord r11 = (androidx.compose.runtime.MutableFloatState.FloatStateStateRecord) r11     // Catch: java.lang.Throwable -> L73
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.MutableFloatState.setFloatValue(float):void");
    }

    @Override // androidx.compose.runtime.snapshots.SnapshotMutableState
    public SnapshotMutationPolicy<Float> getPolicy() {
        return SnapshotStateKt.structuralEqualityPolicy();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.MutableState
    public Float component1() {
        return Float.valueOf(getFloatValue());
    }

    @Override // androidx.compose.runtime.MutableState
    public Function1<Float, Unit> component2() {
        return new Function1<Float, Unit>() { // from class: androidx.compose.runtime.SnapshotMutableFloatStateImpl.component2.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                invoke(f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float it) {
                MutableFloatState.this.setFloatValue(it);
            }
        };
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
        this.next = (FloatStateStateRecord) value;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    @Override // androidx.compose.runtime.snapshots.StateObjectImpl, androidx.compose.runtime.snapshots.StateObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.compose.runtime.snapshots.StateRecord mergeRecords(androidx.compose.runtime.snapshots.StateRecord r10, androidx.compose.runtime.snapshots.StateRecord r11, androidx.compose.runtime.snapshots.StateRecord r12) {
        /*
            r9 = this;
            java.lang.String r0 = "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11, r0)
            r1 = r11
            androidx.compose.runtime.SnapshotMutableFloatStateImpl$FloatStateStateRecord r1 = (androidx.compose.runtime.MutableFloatState.FloatStateStateRecord) r1
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r0)
            r0 = r12
            androidx.compose.runtime.SnapshotMutableFloatStateImpl$FloatStateStateRecord r0 = (androidx.compose.runtime.MutableFloatState.FloatStateStateRecord) r0
            float r2 = r1.getValue()
            float r3 = r0.getValue()
            r4 = 0
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 23
            r7 = 1
            r8 = 0
            if (r5 < r6) goto L27
            int r5 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r5 != 0) goto L25
            goto L3e
        L25:
            r7 = 0
            goto L3e
        L27:
            boolean r5 = androidx.compose.runtime.internal.FloatingPointEquality_androidKt.isNan(r2)
            if (r5 != 0) goto L3d
            boolean r5 = androidx.compose.runtime.internal.FloatingPointEquality_androidKt.isNan(r3)
            if (r5 != 0) goto L3d
            int r5 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r5 != 0) goto L39
            r5 = 1
            goto L3a
        L39:
            r5 = 0
        L3a:
            if (r5 == 0) goto L3d
            goto L3e
        L3d:
            r7 = 0
        L3e:
            if (r7 == 0) goto L43
            r2 = r11
            goto L44
        L43:
            r2 = 0
        L44:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.MutableFloatState.mergeRecords(androidx.compose.runtime.snapshots.StateRecord, androidx.compose.runtime.snapshots.StateRecord, androidx.compose.runtime.snapshots.StateRecord):androidx.compose.runtime.snapshots.StateRecord");
    }

    public String toString() {
        StateRecord $this$withCurrent$iv = this.next;
        FloatStateStateRecord it = (FloatStateStateRecord) SnapshotKt.current($this$withCurrent$iv);
        return "MutableFloatState(value=" + it.getValue() + ")@" + hashCode();
    }

    /* compiled from: SnapshotFloatState.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\b\u0010\n\u001a\u00020\u0001H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000b"}, d2 = {"Landroidx/compose/runtime/SnapshotMutableFloatStateImpl$FloatStateStateRecord;", "Landroidx/compose/runtime/snapshots/StateRecord;", "value", "", "(F)V", "getValue", "()F", "setValue", "assign", "", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.SnapshotMutableFloatStateImpl$FloatStateStateRecord */
    private static final class FloatStateStateRecord extends StateRecord {
        private float value;

        public final float getValue() {
            return this.value;
        }

        public final void setValue(float f) {
            this.value = f;
        }

        public FloatStateStateRecord(float value) {
            this.value = value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutableFloatStateImpl.FloatStateStateRecord");
            this.value = ((FloatStateStateRecord) value).value;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new FloatStateStateRecord(this.value);
        }
    }
}
