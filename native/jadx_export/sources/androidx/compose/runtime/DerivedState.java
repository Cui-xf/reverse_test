package androidx.compose.runtime;

import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DerivedState.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001'B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ:\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010&\u001a\u00020#H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u0004\u0018\u00018\u00008G¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011¨\u0006("}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState;", "T", "Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/DerivedState;", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "currentRecord", "Landroidx/compose/runtime/DerivedState$Record;", "getCurrentRecord", "()Landroidx/compose/runtime/DerivedState$Record;", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "()Ljava/lang/Object;", "first", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "value", "getValue", "current", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readable", "forceDependencyReads", "", "displayValue", "", "prependStateRecord", "", "toString", "ResultRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.runtime.DerivedSnapshotState, reason: from toString */
/* loaded from: classes.dex */
final class DerivedState<T> extends StateObjectImpl implements androidx.compose.runtime.DerivedState<T> {
    private final Function0<T> calculation;
    private ResultRecord<T> first = new ResultRecord<>();
    private final SnapshotMutationPolicy<T> policy;

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    @Override // androidx.compose.runtime.DerivedState
    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DerivedState(Function0<? extends T> function0, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        this.calculation = function0;
        this.policy = snapshotMutationPolicy;
    }

    /* compiled from: DerivedState.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 +*\u0004\b\u0001\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001+B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\u0002H\u0016J\u001a\u0010$\u001a\u00020%2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030'2\u0006\u0010(\u001a\u00020)J\u001a\u0010*\u001a\u00020\u00152\n\u0010&\u001a\u0006\u0012\u0002\b\u00030'2\u0006\u0010(\u001a\u00020)R\u0014\u0010\u0005\u001a\u00028\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019¨\u0006,"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/DerivedState$Record;", "()V", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "dependencies", "Landroidx/collection/ObjectIntMap;", "Landroidx/compose/runtime/snapshots/StateObject;", "getDependencies", "()Landroidx/collection/ObjectIntMap;", "setDependencies", "(Landroidx/collection/ObjectIntMap;)V", "result", "", "getResult", "setResult", "(Ljava/lang/Object;)V", "resultHash", "", "getResultHash", "()I", "setResultHash", "(I)V", "validSnapshotId", "getValidSnapshotId", "setValidSnapshotId", "validSnapshotWriteCount", "getValidSnapshotWriteCount", "setValidSnapshotWriteCount", "assign", "", "value", "create", "isValid", "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readableHash", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.DerivedSnapshotState$ResultRecord */
    public static final class ResultRecord<T> extends StateRecord implements DerivedState.Record<T> {
        private ObjectIntMap<StateObject> dependencies = ObjectIntMapKt.emptyObjectIntMap();
        private Object result = Unset;
        private int resultHash;
        private int validSnapshotId;
        private int validSnapshotWriteCount;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;
        private static final Object Unset = new Object();

        /* compiled from: DerivedState.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord$Companion;", "", "()V", "Unset", "getUnset", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* renamed from: androidx.compose.runtime.DerivedSnapshotState$ResultRecord$Companion, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Object getUnset() {
                return ResultRecord.Unset;
            }
        }

        public final int getValidSnapshotId() {
            return this.validSnapshotId;
        }

        public final void setValidSnapshotId(int i) {
            this.validSnapshotId = i;
        }

        public final int getValidSnapshotWriteCount() {
            return this.validSnapshotWriteCount;
        }

        public final void setValidSnapshotWriteCount(int i) {
            this.validSnapshotWriteCount = i;
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public ObjectIntMap<StateObject> getDependencies() {
            return this.dependencies;
        }

        public void setDependencies(ObjectIntMap<StateObject> objectIntMap) {
            this.dependencies = objectIntMap;
        }

        public final Object getResult() {
            return this.result;
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        public final int getResultHash() {
            return this.resultHash;
        }

        public final void setResultHash(int i) {
            this.resultHash = i;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState.ResultRecord>");
            ResultRecord other = (ResultRecord) value;
            setDependencies(other.getDependencies());
            this.result = other.result;
            this.resultHash = other.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new ResultRecord();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean isValid(androidx.compose.runtime.DerivedState<?> r9, androidx.compose.runtime.snapshots.Snapshot r10) {
            /*
                r8 = this;
                r0 = 0
                java.lang.Object r1 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
                r2 = 0
                monitor-enter(r1)
                r3 = 0
                int r4 = r8.validSnapshotId     // Catch: java.lang.Throwable -> L56
                int r5 = r10.getId()     // Catch: java.lang.Throwable -> L56
                r6 = 0
                r7 = 1
                if (r4 != r5) goto L1d
                int r4 = r8.validSnapshotWriteCount     // Catch: java.lang.Throwable -> L56
                int r5 = r10.getWriteCount()     // Catch: java.lang.Throwable -> L56
                if (r4 == r5) goto L1b
                goto L1d
            L1b:
                r3 = 0
                goto L1e
            L1d:
                r3 = 1
            L1e:
                monitor-exit(r1)
                java.lang.Object r0 = r8.result
                java.lang.Object r1 = androidx.compose.runtime.DerivedState.ResultRecord.Unset
                if (r0 == r1) goto L33
                if (r3 == 0) goto L31
                int r0 = r8.resultHash
                int r1 = r8.readableHash(r9, r10)
                if (r0 != r1) goto L33
            L31:
                r6 = 1
                goto L34
            L33:
            L34:
                if (r6 == 0) goto L55
                if (r3 == 0) goto L55
                r0 = 0
                java.lang.Object r1 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
                r2 = 0
                monitor-enter(r1)
                r4 = 0
                int r5 = r10.getId()     // Catch: java.lang.Throwable -> L52
                r8.validSnapshotId = r5     // Catch: java.lang.Throwable -> L52
                int r5 = r10.getWriteCount()     // Catch: java.lang.Throwable -> L52
                r8.validSnapshotWriteCount = r5     // Catch: java.lang.Throwable -> L52
                kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L52
                monitor-exit(r1)
                goto L55
            L52:
                r4 = move-exception
                monitor-exit(r1)
                throw r4
            L55:
                return r6
            L56:
                r3 = move-exception
                monitor-exit(r1)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.DerivedState.ResultRecord.isValid(androidx.compose.runtime.DerivedState, androidx.compose.runtime.snapshots.Snapshot):boolean");
        }

        /* JADX WARN: Removed duplicated region for block: B:70:0x0158  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int readableHash(androidx.compose.runtime.DerivedState<?> r32, androidx.compose.runtime.snapshots.Snapshot r33) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 371
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.DerivedState.ResultRecord.readableHash(androidx.compose.runtime.DerivedState, androidx.compose.runtime.snapshots.Snapshot):int");
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public T getCurrentValue() {
            return (T) this.result;
        }
    }

    public final StateRecord current(Snapshot snapshot) {
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshot), snapshot, false, this.calculation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x026e A[Catch: all -> 0x02d4, TRY_LEAVE, TryCatch #1 {, blocks: (B:95:0x0231, B:97:0x0244, B:99:0x024a, B:105:0x025c, B:106:0x026e), top: B:144:0x0231 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final androidx.compose.runtime.DerivedState.ResultRecord<T> currentRecord(androidx.compose.runtime.DerivedState.ResultRecord<T> r36, androidx.compose.runtime.snapshots.Snapshot r37, boolean r38, kotlin.jvm.functions.Function0<? extends T> r39) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 779
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.DerivedState.currentRecord(androidx.compose.runtime.DerivedSnapshotState$ResultRecord, androidx.compose.runtime.snapshots.Snapshot, boolean, kotlin.jvm.functions.Function0):androidx.compose.runtime.DerivedSnapshotState$ResultRecord");
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState>");
        this.first = (ResultRecord) value;
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        Function1<Object, Unit> readObserver = Snapshot.INSTANCE.getCurrent().getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(this);
        }
        Snapshot current = Snapshot.INSTANCE.getCurrent();
        return (T) currentRecord((ResultRecord) SnapshotKt.current(this.first, current), current, true, this.calculation).getResult();
    }

    @Override // androidx.compose.runtime.DerivedState
    public DerivedState.Record<T> getCurrentRecord() {
        Snapshot snapshot = Snapshot.INSTANCE.getCurrent();
        ResultRecord<T> record = (ResultRecord) SnapshotKt.current(this.first, snapshot);
        return currentRecord(record, snapshot, false, this.calculation);
    }

    public String toString() {
        StateRecord $this$withCurrent$iv = this.first;
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }

    public final T getDebuggerDisplayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        if (resultRecord.isValid(this, Snapshot.INSTANCE.getCurrent())) {
            return (T) resultRecord.getResult();
        }
        return null;
    }

    private final String displayValue() {
        StateRecord $this$withCurrent$iv = this.first;
        ResultRecord it = (ResultRecord) SnapshotKt.current($this$withCurrent$iv);
        if (it.isValid(this, Snapshot.INSTANCE.getCurrent())) {
            return String.valueOf(it.getResult());
        }
        return "<Not calculated>";
    }
}
