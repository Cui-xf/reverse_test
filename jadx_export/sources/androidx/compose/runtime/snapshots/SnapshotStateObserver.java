package androidx.compose.runtime.snapshots;

import androidx.autofill.HintConstants;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: SnapshotStateObserver.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0001\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u00017B.\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\tJ\u0016\u0010\u001d\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0002J\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0001J)\u0010!\u001a\u00020\u00052!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u0003J\b\u0010#\u001a\u00020\u0015H\u0002J&\u0010$\u001a\u00020\u0011\"\b\b\u0000\u0010%*\u00020\u00012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u001d\u0010'\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\bJ\u001e\u0010)\u001a\u00020\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010+\u001a\u00020\rH\u0007J?\u0010,\u001a\u00020\u0005\"\b\b\u0000\u0010%*\u00020\u00012\u0006\u0010 \u001a\u0002H%2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0002J\u001d\u00100\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u0003H\u0082\bJ\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\u0005H\u0002J\u0006\u00104\u001a\u00020\u0005J\u0006\u00105\u001a\u00020\u0005J\u0016\u00106\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007R&\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "callback", "(Lkotlin/jvm/functions/Function1;)V", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "currentMap", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "currentMapThreadId", "", "isPaused", "", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "pendingChanges", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "readObserver", "sendingNotifications", "addChanges", "set", "clear", "scope", "clearIf", "predicate", "drainChanges", "ensureMap", "T", "onChanged", "forEachScopeMap", "block", "notifyChanges", "changes", "snapshot", "observeReads", "onValueChangedForScope", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "removeChanges", "removeScopeMapIf", "report", "", "sendNotifications", "start", "stop", "withNoObservations", "ObservedScopeMap", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private ObserverHandle applyUnsubscribe;
    private ObservedScopeMap currentMap;
    private boolean isPaused;
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private boolean sendingNotifications;
    private final AtomicReference<Object> pendingChanges = new AtomicReference<>(null);
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver = new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1
        {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, Snapshot snapshot) {
            invoke2(set, snapshot);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Set<? extends Object> set, Snapshot snapshot) {
            this.this$0.addChanges(set);
            if (this.this$0.drainChanges()) {
                this.this$0.sendNotifications();
            }
        }
    };
    private final Function1<Object, Unit> readObserver = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
            invoke2(p1);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object state) {
            if (!this.this$0.isPaused) {
                MutableVector mutableVector = this.this$0.observedScopeMaps;
                SnapshotStateObserver snapshotStateObserver = this.this$0;
                synchronized (mutableVector) {
                    SnapshotStateObserver.ObservedScopeMap observedScopeMap = snapshotStateObserver.currentMap;
                    Intrinsics.checkNotNull(observedScopeMap);
                    observedScopeMap.recordRead(state);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    };
    private final MutableVector<ObservedScopeMap> observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    private long currentMapThreadId = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> function1) {
        this.onChangedExecutor = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean drainChanges() {
        boolean z;
        synchronized (this.observedScopeMaps) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean hasValues = false;
        while (true) {
            Set notifications = removeChanges();
            if (notifications == null) {
                return hasValues;
            }
            synchronized (this.observedScopeMaps) {
                MutableVector this_$iv$iv = this.observedScopeMaps;
                int size$iv$iv = this_$iv$iv.getSize();
                if (size$iv$iv > 0) {
                    int i$iv$iv = 0;
                    Object[] content$iv$iv = this_$iv$iv.getContent();
                    do {
                        ObservedScopeMap scopeMap = (ObservedScopeMap) content$iv$iv[i$iv$iv];
                        hasValues = scopeMap.recordInvalidation(notifications) || hasValues;
                        i$iv$iv++;
                    } while (i$iv$iv < size$iv$iv);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendNotifications() {
        this.onChangedExecutor.invoke(new Function0<Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver.sendNotifications.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                do {
                    MutableVector mutableVector = SnapshotStateObserver.this.observedScopeMaps;
                    SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                    synchronized (mutableVector) {
                        if (!snapshotStateObserver.sendingNotifications) {
                            snapshotStateObserver.sendingNotifications = true;
                            try {
                                MutableVector this_$iv = snapshotStateObserver.observedScopeMaps;
                                int size$iv = this_$iv.getSize();
                                if (size$iv > 0) {
                                    int i$iv = 0;
                                    Object[] content$iv = this_$iv.getContent();
                                    do {
                                        ObservedScopeMap scopeMap = (ObservedScopeMap) content$iv[i$iv];
                                        scopeMap.notifyInvalidatedScopes();
                                        i$iv++;
                                    } while (i$iv < size$iv);
                                }
                                snapshotStateObserver.sendingNotifications = false;
                            } finally {
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                } while (SnapshotStateObserver.this.drainChanges());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void addChanges(Set<? extends Object> set) {
        Object old;
        Collection collectionPlus;
        do {
            old = this.pendingChanges.get();
            if (old == null) {
                collectionPlus = set;
            } else if (old instanceof Set) {
                collectionPlus = CollectionsKt.listOf((Object[]) new Set[]{old, set});
            } else {
                if (!(old instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                collectionPlus = CollectionsKt.plus((Collection) old, (Iterable) CollectionsKt.listOf(set));
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, old, collectionPlus));
    }

    private final Set<Object> removeChanges() {
        Object old;
        Set result;
        Object obj;
        do {
            old = this.pendingChanges.get();
            Object objSubList = null;
            if (old == null) {
                return null;
            }
            if (old instanceof Set) {
                result = (Set) old;
                obj = null;
            } else if (old instanceof List) {
                result = (Set) ((List) old).get(0);
                if (((List) old).size() == 2) {
                    objSubList = ((List) old).get(1);
                } else if (((List) old).size() > 2) {
                    objSubList = ((List) old).subList(1, ((List) old).size());
                }
                obj = objSubList;
            } else {
                report();
                throw new KotlinNothingValueException();
            }
        } while (!MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.pendingChanges, old, obj));
        return result;
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    private final void forEachScopeMap(Function1<? super ObservedScopeMap, Unit> block) {
        synchronized (this.observedScopeMaps) {
            MutableVector this_$iv = this.observedScopeMaps;
            int size$iv = this_$iv.getSize();
            if (size$iv > 0) {
                int i$iv = 0;
                Object[] content$iv = this_$iv.getContent();
                do {
                    block.invoke(content$iv[i$iv]);
                    i$iv++;
                } while (i$iv < size$iv);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void removeScopeMapIf(Function1<? super ObservedScopeMap, Boolean> block) {
        synchronized (this.observedScopeMaps) {
            MutableVector this_$iv = this.observedScopeMaps;
            int gap$iv = 0;
            int size$iv = this_$iv.getSize();
            for (int i$iv = 0; i$iv < size$iv; i$iv++) {
                if (block.invoke(this_$iv.getContent()[i$iv]).booleanValue()) {
                    gap$iv++;
                } else if (gap$iv > 0) {
                    this_$iv.getContent()[i$iv - gap$iv] = this_$iv.getContent()[i$iv];
                }
            }
            ArraysKt.fill(this_$iv.getContent(), (Object) null, size$iv - gap$iv, size$iv);
            this_$iv.setSize(size$iv - gap$iv);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final <T> void observeReads(T scope, Function1<? super T, Unit> onValueChangedForScope, Function0<Unit> block) {
        ObservedScopeMap scopeMap;
        synchronized (this.observedScopeMaps) {
            scopeMap = ensureMap(onValueChangedForScope);
        }
        boolean oldPaused = this.isPaused;
        ObservedScopeMap oldMap = this.currentMap;
        long oldThreadId = this.currentMapThreadId;
        if (oldThreadId != -1) {
            boolean value$iv = oldThreadId == ActualJvm_jvmKt.currentThreadId();
            if (!value$iv) {
                PreconditionsKt.throwIllegalArgumentException("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + oldThreadId + "), currentThread={id=" + ActualJvm_jvmKt.currentThreadId() + ", name=" + ActualJvm_jvmKt.currentThreadName() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
            }
        }
        try {
            this.isPaused = false;
            this.currentMap = scopeMap;
            this.currentMapThreadId = Thread.currentThread().getId();
            scopeMap.observe(scope, this.readObserver, block);
        } finally {
            this.currentMap = oldMap;
            this.isPaused = oldPaused;
            this.currentMapThreadId = oldThreadId;
        }
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(expression = "Snapshot.withoutReadObservation(block)", imports = {"androidx.compose.runtime.snapshots.Snapshot"}))
    public final void withNoObservations(Function0<Unit> block) {
        boolean oldPaused = this.isPaused;
        this.isPaused = true;
        try {
            block.invoke();
        } finally {
            this.isPaused = oldPaused;
        }
    }

    public final void clear(Object scope) {
        synchronized (this.observedScopeMaps) {
            MutableVector this_$iv$iv = this.observedScopeMaps;
            int gap$iv$iv = 0;
            int size$iv$iv = this_$iv$iv.getSize();
            for (int i$iv$iv = 0; i$iv$iv < size$iv$iv; i$iv$iv++) {
                ObservedScopeMap it = this_$iv$iv.getContent()[i$iv$iv];
                it.clearScopeObservations(scope);
                if (!it.hasScopeObservations()) {
                    gap$iv$iv++;
                } else if (gap$iv$iv > 0) {
                    this_$iv$iv.getContent()[i$iv$iv - gap$iv$iv] = this_$iv$iv.getContent()[i$iv$iv];
                }
            }
            ArraysKt.fill(this_$iv$iv.getContent(), (Object) null, size$iv$iv - gap$iv$iv, size$iv$iv);
            this_$iv$iv.setSize(size$iv$iv - gap$iv$iv);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearIf(Function1<Object, Boolean> predicate) {
        synchronized (this.observedScopeMaps) {
            MutableVector this_$iv$iv = this.observedScopeMaps;
            int gap$iv$iv = 0;
            int size$iv$iv = this_$iv$iv.getSize();
            for (int i$iv$iv = 0; i$iv$iv < size$iv$iv; i$iv$iv++) {
                ObservedScopeMap scopeMap = this_$iv$iv.getContent()[i$iv$iv];
                scopeMap.removeScopeIf(predicate);
                if (!scopeMap.hasScopeObservations()) {
                    gap$iv$iv++;
                } else if (gap$iv$iv > 0) {
                    this_$iv$iv.getContent()[i$iv$iv - gap$iv$iv] = this_$iv$iv.getContent()[i$iv$iv];
                }
            }
            ArraysKt.fill(this_$iv$iv.getContent(), (Object) null, size$iv$iv - gap$iv$iv, size$iv$iv);
            this_$iv$iv.setSize(size$iv$iv - gap$iv$iv);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.INSTANCE.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    public final void notifyChanges(Set<? extends Object> changes, Snapshot snapshot) {
        this.applyObserver.invoke(changes, snapshot);
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            MutableVector this_$iv$iv = this.observedScopeMaps;
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                do {
                    ObservedScopeMap scopeMap = (ObservedScopeMap) content$iv$iv[i$iv$iv];
                    scopeMap.clear();
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final <T> ObservedScopeMap ensureMap(Function1<? super T, Unit> onChanged) {
        Object item$iv;
        MutableVector this_$iv = this.observedScopeMaps;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            do {
                item$iv = content$iv[i$iv];
                ObservedScopeMap it = (ObservedScopeMap) item$iv;
                if (it.getOnChanged() == onChanged) {
                    break;
                }
                i$iv++;
            } while (i$iv < size$iv);
            item$iv = null;
        } else {
            item$iv = null;
        }
        ObservedScopeMap scopeMap = (ObservedScopeMap) item$iv;
        if (scopeMap == null) {
            Intrinsics.checkNotNull(onChanged, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
            ObservedScopeMap map = new ObservedScopeMap((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(onChanged, 1));
            this.observedScopeMaps.add(map);
            return map;
        }
        return scopeMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SnapshotStateObserver.kt */
    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001H\u0002J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0004J0\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040)J\u0014\u0010*\u001a\u00020$2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010,J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0001J.\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0002J\u0018\u00100\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002J)\u00101\u001a\u00020\u00042!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020$0\u0003J\u0012\u00105\u001a\u00020\u00042\n\u00106\u001a\u0006\u0012\u0002\b\u00030\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R6\u0010\u0017\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "onChanged", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "currentScope", "currentScopeReads", "Landroidx/collection/MutableObjectIntMap;", "currentToken", "", "dependencyToDerivedStates", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/DerivedState;", "deriveStateScopeCount", "derivedStateObserver", "Landroidx/compose/runtime/DerivedStateObserver;", "getDerivedStateObserver", "()Landroidx/compose/runtime/DerivedStateObserver;", "invalidated", "Landroidx/collection/MutableScatterSet;", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "recordedDerivedStateValues", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "scopeToValues", "Landroidx/collection/MutableScatterMap;", "statesToReread", "Landroidx/compose/runtime/collection/MutableVector;", "valueToScopes", "clear", "clearObsoleteStateReads", "scope", "clearScopeObservations", "hasScopeObservations", "", "notifyInvalidatedScopes", "observe", "readObserver", "block", "Lkotlin/Function0;", "recordInvalidation", "changes", "", "recordRead", "value", "recordedValues", "removeObservation", "removeScopeIf", "predicate", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "rereadDerivedState", "derivedState", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class ObservedScopeMap {
        private Object currentScope;
        private MutableObjectIntMap<Object> currentScopeReads;
        private int deriveStateScopeCount;
        private final MutableScatterSet<Object> invalidated;
        private final Function1<Object, Unit> onChanged;
        private final MutableScatterMap<Object, MutableObjectIntMap<Object>> scopeToValues;
        private int currentToken = -1;
        private final ScopeMap<Object, Object> valueToScopes = new ScopeMap<>();
        private final MutableVector<DerivedState<?>> statesToReread = new MutableVector<>(new DerivedState[16], 0);
        private final DerivedStateObserver derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(DerivedState<?> derivedState) {
                this.this$0.deriveStateScopeCount++;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(DerivedState<?> derivedState) {
                SnapshotStateObserver.ObservedScopeMap observedScopeMap = this.this$0;
                observedScopeMap.deriveStateScopeCount--;
            }
        };
        private final ScopeMap<Object, DerivedState<?>> dependencyToDerivedStates = new ScopeMap<>();
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues = new HashMap<>();

        public ObservedScopeMap(Function1<Object, Unit> function1) {
            this.onChanged = function1;
            int i = 0;
            int i2 = 1;
            DefaultConstructorMarker defaultConstructorMarker = null;
            this.scopeToValues = new MutableScatterMap<>(i, i2, defaultConstructorMarker);
            this.invalidated = new MutableScatterSet<>(i, i2, defaultConstructorMarker);
        }

        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final DerivedStateObserver getDerivedStateObserver() {
            return this.derivedStateObserver;
        }

        public final void recordRead(Object value) {
            Object scope = this.currentScope;
            Intrinsics.checkNotNull(scope);
            int i = this.currentToken;
            MutableObjectIntMap it = this.currentScopeReads;
            if (it == null) {
                it = new MutableObjectIntMap(0, 1, null);
                this.currentScopeReads = it;
                this.scopeToValues.set(scope, it);
                Unit unit = Unit.INSTANCE;
            }
            recordRead(value, i, scope, it);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x00bf  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void recordRead(java.lang.Object r30, int r31, java.lang.Object r32, androidx.collection.MutableObjectIntMap<java.lang.Object> r33) {
            /*
                Method dump skipped, instructions count: 252
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap.recordRead(java.lang.Object, int, java.lang.Object, androidx.collection.MutableObjectIntMap):void");
        }

        public final void observe(Object scope, Function1<Object, Unit> readObserver, Function0<Unit> block) {
            Object previousScope = this.currentScope;
            MutableObjectIntMap previousReads = this.currentScopeReads;
            int previousToken = this.currentToken;
            this.currentScope = scope;
            this.currentScopeReads = this.scopeToValues.get(scope);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            DerivedStateObserver observer$iv = this.derivedStateObserver;
            MutableVector observers$iv = SnapshotStateKt.derivedStateObservers();
            try {
                observers$iv.add(observer$iv);
                Snapshot.INSTANCE.observe(readObserver, null, block);
                observers$iv.removeAt(observers$iv.getSize() - 1);
                Object obj = this.currentScope;
                Intrinsics.checkNotNull(obj);
                clearObsoleteStateReads(obj);
                this.currentScope = previousScope;
                this.currentScopeReads = previousReads;
                this.currentToken = previousToken;
            } catch (Throwable th) {
                observers$iv.removeAt(observers$iv.getSize() - 1);
                throw th;
            }
        }

        private final void clearObsoleteStateReads(Object scope) {
            int currentToken;
            int $i$f$removeIf;
            int currentToken2;
            int $i$f$removeIf2;
            char c;
            int currentToken3 = this.currentToken;
            MutableObjectIntMap this_$iv = this.currentScopeReads;
            if (this_$iv == null) {
                return;
            }
            int $i$f$removeIf3 = 0;
            MutableObjectIntMap this_$iv$iv = this_$iv;
            long[] m$iv$iv = this_$iv$iv.metadata;
            int lastIndex$iv$iv = m$iv$iv.length - 2;
            int i$iv$iv = 0;
            if (0 > lastIndex$iv$iv) {
                return;
            }
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                    currentToken = currentToken3;
                    $i$f$removeIf = $i$f$removeIf3;
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int j$iv$iv = 0;
                    while (j$iv$iv < bitCount$iv$iv) {
                        long value$iv$iv$iv = 255 & slot$iv$iv;
                        if (!(value$iv$iv$iv < 128)) {
                            currentToken2 = currentToken3;
                            $i$f$removeIf2 = $i$f$removeIf3;
                            c = '\b';
                        } else {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            c = '\b';
                            Object value = this_$iv.keys[index$iv$iv];
                            $i$f$removeIf2 = $i$f$removeIf3;
                            int token = this_$iv.values[index$iv$iv];
                            boolean z = token != currentToken3;
                            boolean willRemove = z;
                            if (!willRemove) {
                                currentToken2 = currentToken3;
                            } else {
                                currentToken2 = currentToken3;
                                removeObservation(scope, value);
                            }
                            if (z) {
                                this_$iv.removeValueAt(index$iv$iv);
                            }
                        }
                        slot$iv$iv >>= c;
                        j$iv$iv++;
                        $i$f$removeIf3 = $i$f$removeIf2;
                        currentToken3 = currentToken2;
                    }
                    currentToken = currentToken3;
                    $i$f$removeIf = $i$f$removeIf3;
                    if (bitCount$iv$iv != 8) {
                        return;
                    }
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    return;
                }
                i$iv$iv++;
                $i$f$removeIf3 = $i$f$removeIf;
                currentToken3 = currentToken;
            }
        }

        public final void clearScopeObservations(Object scope) {
            char c;
            MutableObjectIntMap recordedValues = this.scopeToValues.remove(scope);
            if (recordedValues == null) {
                return;
            }
            MutableObjectIntMap this_$iv = recordedValues;
            Object[] k$iv = this_$iv.keys;
            int[] v$iv = this_$iv.values;
            long[] m$iv$iv = this_$iv.metadata;
            int lastIndex$iv$iv = m$iv$iv.length - 2;
            int i$iv$iv = 0;
            if (0 > lastIndex$iv$iv) {
                return;
            }
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                MutableObjectIntMap recordedValues2 = recordedValues;
                ObjectIntMap this_$iv2 = this_$iv;
                if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) != -9187201950435737472L) {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                        long value$iv$iv$iv = 255 & slot$iv$iv;
                        if (!(value$iv$iv$iv < 128)) {
                            c = '\b';
                        } else {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            c = '\b';
                            Object value = k$iv[index$iv$iv];
                            int i = v$iv[index$iv$iv];
                            removeObservation(scope, value);
                        }
                        slot$iv$iv >>= c;
                    }
                    if (bitCount$iv$iv != 8) {
                        return;
                    }
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    return;
                }
                i$iv$iv++;
                recordedValues = recordedValues2;
                this_$iv = this_$iv2;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x00e5  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void removeScopeIf(kotlin.jvm.functions.Function1<java.lang.Object, java.lang.Boolean> r51) {
            /*
                Method dump skipped, instructions count: 364
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap.removeScopeIf(kotlin.jvm.functions.Function1):void");
        }

        public final boolean hasScopeObservations() {
            return this.scopeToValues.isNotEmpty();
        }

        private final void removeObservation(Object scope, Object value) {
            this.valueToScopes.remove(value, scope);
            if ((value instanceof DerivedState) && !this.valueToScopes.contains(value)) {
                this.dependencyToDerivedStates.removeScope(value);
                this.recordedDerivedStateValues.remove(value);
            }
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        /* JADX WARN: Removed duplicated region for block: B:109:0x0345 A[PHI: r34
          0x0345: PHI (r34v16 'hasValues' boolean) = (r34v15 'hasValues' boolean), (r34v17 'hasValues' boolean) binds: [B:96:0x0307, B:108:0x0343] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:173:0x0537  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x01d9 A[EDGE_INSN: B:63:0x01d9->B:338:0x0233 BREAK  A[LOOP:4: B:49:0x0186->B:64:0x01db], PHI: r34
          0x01d9: PHI (r34v26 'hasValues' boolean) = (r34v25 'hasValues' boolean), (r34v27 'hasValues' boolean) binds: [B:50:0x019e, B:62:0x01d7] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean recordInvalidation(java.util.Set<? extends java.lang.Object> r79) {
            /*
                Method dump skipped, instructions count: 2399
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap.recordInvalidation(java.util.Set):boolean");
        }

        public final void rereadDerivedState(DerivedState<?> derivedState) {
            Object value$iv;
            ScatterSet this_$iv$iv;
            Object value$iv2;
            ScatterSet this_$iv$iv2;
            int j$iv$iv$iv;
            char c;
            MutableObjectIntMap it;
            MutableScatterMap scopeToValues = this.scopeToValues;
            int token = SnapshotKt.currentSnapshot().getId();
            ScopeMap this_$iv = this.valueToScopes;
            int $i$f$forEachScopeOf = 0;
            Object value$iv3 = this_$iv.getMap().get(derivedState);
            if (value$iv3 == null) {
                return;
            }
            if (!(value$iv3 instanceof MutableScatterSet)) {
                MutableObjectIntMap<Object> it2 = scopeToValues.get(value$iv3);
                if (it2 == null) {
                    it2 = new MutableObjectIntMap(0, 1, null);
                    scopeToValues.set(value$iv3, it2);
                    Unit unit = Unit.INSTANCE;
                }
                recordRead(derivedState, token, value$iv3, it2);
                return;
            }
            ScatterSet this_$iv$iv3 = (MutableScatterSet) value$iv3;
            int $i$f$forEach = 0;
            Object[] k$iv$iv = this_$iv$iv3.elements;
            long[] m$iv$iv$iv = this_$iv$iv3.metadata;
            int lastIndex$iv$iv$iv = m$iv$iv$iv.length - 2;
            int i$iv$iv$iv = 0;
            if (0 > lastIndex$iv$iv$iv) {
                return;
            }
            while (true) {
                long slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
                int $i$f$forEach2 = $i$f$forEach;
                ScopeMap this_$iv2 = this_$iv;
                int $i$f$forEachScopeOf2 = $i$f$forEachScopeOf;
                if ((((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L)) != -9187201950435737472L) {
                    int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                    int j$iv$iv$iv2 = 0;
                    while (j$iv$iv$iv2 < bitCount$iv$iv$iv) {
                        long value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                        int $i$f$isFull = value$iv$iv$iv$iv < 128 ? 1 : 0;
                        if ($i$f$isFull != 0) {
                            int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv2;
                            c = '\b';
                            Object scope = k$iv$iv[index$iv$iv$iv];
                            MutableObjectIntMap<Object> mutableObjectIntMap = scopeToValues.get(scope);
                            if (mutableObjectIntMap == null) {
                                value$iv2 = value$iv3;
                                this_$iv$iv2 = this_$iv$iv3;
                                j$iv$iv$iv = j$iv$iv$iv2;
                                it = new MutableObjectIntMap(0, 1, null);
                                scopeToValues.set(scope, it);
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                value$iv2 = value$iv3;
                                this_$iv$iv2 = this_$iv$iv3;
                                j$iv$iv$iv = j$iv$iv$iv2;
                                it = mutableObjectIntMap;
                            }
                            recordRead(derivedState, token, scope, it);
                        } else {
                            value$iv2 = value$iv3;
                            this_$iv$iv2 = this_$iv$iv3;
                            j$iv$iv$iv = j$iv$iv$iv2;
                            c = '\b';
                        }
                        slot$iv$iv$iv >>= c;
                        j$iv$iv$iv2 = j$iv$iv$iv + 1;
                        value$iv3 = value$iv2;
                        this_$iv$iv3 = this_$iv$iv2;
                    }
                    value$iv = value$iv3;
                    this_$iv$iv = this_$iv$iv3;
                    if (bitCount$iv$iv$iv != 8) {
                        return;
                    }
                } else {
                    value$iv = value$iv3;
                    this_$iv$iv = this_$iv$iv3;
                }
                if (i$iv$iv$iv == lastIndex$iv$iv$iv) {
                    return;
                }
                i$iv$iv$iv++;
                this_$iv = this_$iv2;
                $i$f$forEachScopeOf = $i$f$forEachScopeOf2;
                $i$f$forEach = $i$f$forEach2;
                value$iv3 = value$iv;
                this_$iv$iv3 = this_$iv$iv;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void notifyInvalidatedScopes() {
            /*
                r21 = this;
                r0 = r21
                androidx.collection.MutableScatterSet<java.lang.Object> r1 = r0.invalidated
                r2 = r1
                androidx.collection.ScatterSet r2 = (androidx.collection.ScatterSet) r2
                kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r3 = r0.onChanged
                r4 = 0
                java.lang.Object[] r5 = r2.elements
                r6 = r2
                r7 = 0
                long[] r8 = r6.metadata
                int r9 = r8.length
                int r9 = r9 + (-2)
                r10 = 0
                if (r10 > r9) goto L74
            L18:
                r11 = r8[r10]
                r13 = r11
                r15 = 0
                r16 = r1
                long r0 = ~r13
                r17 = 7
                long r0 = r0 << r17
                long r0 = r0 & r13
                r17 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r0 = r0 & r17
                int r13 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
                if (r13 == 0) goto L6b
                int r0 = r10 - r9
                int r0 = ~r0
                int r0 = r0 >>> 31
                r1 = 8
                int r0 = 8 - r0
                r13 = 0
            L39:
                if (r13 >= r0) goto L65
                r14 = 255(0xff, double:1.26E-321)
                long r14 = r14 & r11
                r17 = 0
                r18 = 128(0x80, double:6.3E-322)
                int r20 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
                if (r20 >= 0) goto L49
                r18 = 1
                goto L4b
            L49:
                r18 = 0
            L4b:
                if (r18 == 0) goto L5c
                int r14 = r10 << 3
                int r14 = r14 + r13
                r15 = r14
                r17 = 0
                r18 = 8
                r1 = r5[r15]
                r3.invoke(r1)
                goto L5e
            L5c:
                r18 = 8
            L5e:
                long r11 = r11 >> r18
                int r13 = r13 + 1
                r1 = 8
                goto L39
            L65:
                r18 = 8
                r1 = 8
                if (r0 != r1) goto L77
            L6b:
                if (r10 == r9) goto L76
                int r10 = r10 + 1
                r0 = r21
                r1 = r16
                goto L18
            L74:
                r16 = r1
            L76:
            L77:
                r16.clear()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap.notifyInvalidatedScopes():void");
        }
    }
}
