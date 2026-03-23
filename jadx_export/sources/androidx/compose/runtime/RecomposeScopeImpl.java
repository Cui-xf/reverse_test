package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectIntMap;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.compose.runtime.tooling.RecomposeScopeObserver;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecomposeScopeImpl.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010;\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u000eJ\u001c\u0010>\u001a\u0010\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0010\u0018\u00010?2\u0006\u0010A\u001a\u00020\u000fJ\b\u0010B\u001a\u00020\u0010H\u0016J\u0010\u0010C\u001a\u00020D2\b\u0010\u0016\u001a\u0004\u0018\u000103J\u0010\u0010E\u001a\u00020\u00122\b\u0010F\u001a\u0004\u0018\u000103J\u0015\u0010G\u001a\u00020H2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\bIJ\u001c\u0010J\u001a\u00020\u00102\n\u0010K\u001a\u0006\u0012\u0002\b\u0003022\b\u0010\u0016\u001a\u0004\u0018\u000103J\u000e\u0010L\u001a\u00020\u00122\u0006\u0010K\u001a\u000203J\u0006\u0010M\u001a\u00020\u0010J\u0006\u0010N\u001a\u00020\u0010J\u0006\u0010O\u001a\u00020\u0010J\u000e\u0010P\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u000fJ\"\u0010Q\u001a\u00020\u00102\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\rH\u0016J*\u0010R\u001a\u00020\u0012*\u0006\u0012\u0002\b\u0003022\u0018\u0010S\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u000302\u0012\u0006\u0012\u0004\u0018\u00010301H\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u001aR\u0011\u0010\"\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0014R\u001a\u0010#\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b%\u0010&R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u001aR$\u0010*\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u001aR$\u0010-\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128@@BX\u0080\u000e¢\u0006\f\u001a\u0004\b.\u0010\u0014\"\u0004\b/\u0010\u001aR\"\u00100\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u000302\u0012\u0006\u0012\u0004\u0018\u000103\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00106\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b7\u0010\u0014\"\u0004\b8\u0010\u001aR\u0011\u00109\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b:\u0010\u0014¨\u0006U"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl;", "Landroidx/compose/runtime/ScopeUpdateScope;", "Landroidx/compose/runtime/RecomposeScope;", "owner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "(Landroidx/compose/runtime/RecomposeScopeOwner;)V", "anchor", "Landroidx/compose/runtime/Anchor;", "getAnchor", "()Landroidx/compose/runtime/Anchor;", "setAnchor", "(Landroidx/compose/runtime/Anchor;)V", "block", "Lkotlin/Function2;", "Landroidx/compose/runtime/Composer;", "", "", "canRecompose", "", "getCanRecompose", "()Z", "currentToken", "value", "defaultsInScope", "getDefaultsInScope", "setDefaultsInScope", "(Z)V", "defaultsInvalid", "getDefaultsInvalid", "setDefaultsInvalid", "flags", "forcedRecompose", "getForcedRecompose", "setForcedRecompose", "isConditional", "observer", "Landroidx/compose/runtime/tooling/RecomposeScopeObserver;", "getObserver$annotations", "()V", "requiresRecompose", "getRequiresRecompose", "setRequiresRecompose", "rereading", "getRereading", "setRereading", "skipped", "getSkipped$runtime_release", "setSkipped", "trackedDependencies", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/DerivedState;", "", "trackedInstances", "Landroidx/collection/MutableObjectIntMap;", "used", "getUsed", "setUsed", "valid", "getValid", "adoptedBy", "compose", "composer", "end", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "token", "invalidate", "invalidateForResult", "Landroidx/compose/runtime/InvalidationResult;", "isInvalidFor", "instances", "observe", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "observe$runtime_release", "recordDerivedStateValue", "instance", "recordRead", "release", "rereadTrackedInstances", "scopeSkipped", "start", "updateScope", "checkDerivedStateChanged", "dependencies", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RecomposeScopeImpl implements ScopeUpdateScope, RecomposeScope {
    private Anchor anchor;
    private Function2<? super Composer, ? super Integer, Unit> block;
    private int currentToken;
    private int flags;
    private RecomposeScopeObserver observer;
    private RecomposeScopeOwner owner;
    private MutableScatterMap<DerivedState<?>, Object> trackedDependencies;
    private MutableObjectIntMap<Object> trackedInstances;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    private static /* synthetic */ void getObserver$annotations() {
    }

    public RecomposeScopeImpl(RecomposeScopeOwner owner) {
        this.owner = owner;
    }

    public final Anchor getAnchor() {
        return this.anchor;
    }

    public final void setAnchor(Anchor anchor) {
        this.anchor = anchor;
    }

    public final boolean getValid() {
        if (this.owner == null) {
            return false;
        }
        Anchor anchor = this.anchor;
        return anchor != null ? anchor.getValid() : false;
    }

    public final boolean getCanRecompose() {
        return this.block != null;
    }

    public final boolean getUsed() {
        return (this.flags & 1) != 0;
    }

    public final void setUsed(boolean value) {
        int i = this.flags;
        if (value) {
            this.flags = i | 1;
        } else {
            this.flags = i & (-2);
        }
    }

    public final boolean getDefaultsInScope() {
        return (this.flags & 2) != 0;
    }

    public final void setDefaultsInScope(boolean value) {
        int i = this.flags;
        if (value) {
            this.flags = i | 2;
        } else {
            this.flags = i & (-3);
        }
    }

    public final boolean getDefaultsInvalid() {
        return (this.flags & 4) != 0;
    }

    public final void setDefaultsInvalid(boolean value) {
        int i = this.flags;
        if (value) {
            this.flags = i | 4;
        } else {
            this.flags = i & (-5);
        }
    }

    public final boolean getRequiresRecompose() {
        return (this.flags & 8) != 0;
    }

    public final void setRequiresRecompose(boolean value) {
        int i = this.flags;
        if (value) {
            this.flags = i | 8;
        } else {
            this.flags = i & (-9);
        }
    }

    public final void compose(Composer composer) {
        Unit unit;
        Function2 block = this.block;
        RecomposeScopeObserver observer = this.observer;
        if (observer != null && block != null) {
            observer.onBeginScopeComposition(this);
            try {
                block.invoke(composer, 1);
                return;
            } finally {
                observer.onEndScopeComposition(this);
            }
        }
        if (block != null) {
            block.invoke(composer, 1);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("Invalid restart scope".toString());
        }
    }

    public final CompositionObserverHandle observe$runtime_release(final RecomposeScopeObserver observer) {
        Object lock$iv = RecomposeScopeImplKt.callbackLock;
        synchronized (lock$iv) {
            this.observer = observer;
            Unit unit = Unit.INSTANCE;
        }
        return new CompositionObserverHandle() { // from class: androidx.compose.runtime.RecomposeScopeImpl$observe$2
            @Override // androidx.compose.runtime.tooling.CompositionObserverHandle
            public void dispose() {
                Object lock$iv2 = RecomposeScopeImplKt.callbackLock;
                RecomposeScopeImpl recomposeScopeImpl = this.this$0;
                RecomposeScopeObserver recomposeScopeObserver = observer;
                synchronized (lock$iv2) {
                    if (Intrinsics.areEqual(recomposeScopeImpl.observer, recomposeScopeObserver)) {
                        recomposeScopeImpl.observer = null;
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        };
    }

    public final InvalidationResult invalidateForResult(Object value) {
        InvalidationResult invalidationResultInvalidate;
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        return (recomposeScopeOwner == null || (invalidationResultInvalidate = recomposeScopeOwner.invalidate(this, value)) == null) ? InvalidationResult.IGNORED : invalidationResultInvalidate;
    }

    public final void release() {
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner != null) {
            recomposeScopeOwner.recomposeScopeReleased(this);
        }
        this.owner = null;
        this.trackedInstances = null;
        this.trackedDependencies = null;
        RecomposeScopeObserver recomposeScopeObserver = this.observer;
        if (recomposeScopeObserver != null) {
            recomposeScopeObserver.onScopeDisposed(this);
        }
    }

    public final void adoptedBy(RecomposeScopeOwner owner) {
        this.owner = owner;
    }

    @Override // androidx.compose.runtime.RecomposeScope
    public void invalidate() {
        RecomposeScopeOwner recomposeScopeOwner = this.owner;
        if (recomposeScopeOwner != null) {
            recomposeScopeOwner.invalidate(this, null);
        }
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public void updateScope(Function2<? super Composer, ? super Integer, Unit> block) {
        this.block = block;
    }

    private final boolean getRereading() {
        return (this.flags & 32) != 0;
    }

    private final void setRereading(boolean value) {
        int i = this.flags;
        if (value) {
            this.flags = i | 32;
        } else {
            this.flags = i & (-33);
        }
    }

    public final boolean getForcedRecompose() {
        return (this.flags & 64) != 0;
    }

    public final void setForcedRecompose(boolean value) {
        int i = this.flags;
        if (value) {
            this.flags = i | 64;
        } else {
            this.flags = i & (-65);
        }
    }

    public final boolean getSkipped$runtime_release() {
        return (this.flags & 16) != 0;
    }

    private final void setSkipped(boolean value) {
        int i = this.flags;
        if (value) {
            this.flags = i | 16;
        } else {
            this.flags = i & (-17);
        }
    }

    public final void start(int token) {
        this.currentToken = token;
        setSkipped(false);
    }

    public final void scopeSkipped() {
        setSkipped(true);
    }

    public final boolean recordRead(Object instance) {
        if (getRereading()) {
            return false;
        }
        MutableObjectIntMap it = this.trackedInstances;
        if (it == null) {
            it = new MutableObjectIntMap(0, 1, null);
            this.trackedInstances = it;
        }
        int token = it.put(instance, this.currentToken, -1);
        return token == this.currentToken;
    }

    public final void recordDerivedStateValue(DerivedState<?> instance, Object value) {
        MutableScatterMap it = this.trackedDependencies;
        if (it == null) {
            it = new MutableScatterMap(0, 1, null);
            this.trackedDependencies = it;
        }
        it.set(instance, value);
    }

    public final boolean isConditional() {
        return this.trackedDependencies != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00a4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ae A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isInvalidFor(java.lang.Object r28) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.RecomposeScopeImpl.isInvalidFor(java.lang.Object):boolean");
    }

    private final boolean checkDerivedStateChanged(DerivedState<?> derivedState, MutableScatterMap<DerivedState<?>, Object> mutableScatterMap) {
        Intrinsics.checkNotNull(derivedState, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
        SnapshotMutationPolicy policy = derivedState.getPolicy();
        if (policy == null) {
            policy = SnapshotStateKt.structuralEqualityPolicy();
        }
        return !policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), mutableScatterMap.get(derivedState));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void rereadTrackedInstances() throws java.lang.Throwable {
        /*
            r25 = this;
            r1 = r25
            androidx.compose.runtime.RecomposeScopeOwner r0 = r1.owner
            if (r0 == 0) goto La6
            r2 = r0
            r3 = 0
            androidx.collection.MutableObjectIntMap<java.lang.Object> r0 = r1.trackedInstances
            if (r0 == 0) goto La6
            r4 = r0
            r5 = 0
            r0 = 1
            r1.setRereading(r0)
            r7 = r4
            androidx.collection.ObjectIntMap r7 = (androidx.collection.ObjectIntMap) r7     // Catch: java.lang.Throwable -> La0
            r8 = 0
            java.lang.Object[] r9 = r7.keys     // Catch: java.lang.Throwable -> La0
            int[] r10 = r7.values     // Catch: java.lang.Throwable -> La0
            r11 = r7
            r12 = 0
            long[] r13 = r11.metadata     // Catch: java.lang.Throwable -> La0
            int r14 = r13.length     // Catch: java.lang.Throwable -> La0
            int r14 = r14 + (-2)
            r15 = 0
            if (r15 > r14) goto L93
        L25:
            r16 = r13[r15]     // Catch: java.lang.Throwable -> L8f
            r18 = r16
            r20 = 0
            r0 = r18
            r19 = r7
            long r6 = ~r0     // Catch: java.lang.Throwable -> L8f
            r21 = 7
            long r6 = r6 << r21
            long r6 = r6 & r0
            r21 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r0 = r6 & r21
            int r6 = (r0 > r21 ? 1 : (r0 == r21 ? 0 : -1))
            if (r6 == 0) goto L85
            int r0 = r15 - r14
            int r0 = ~r0     // Catch: java.lang.Throwable -> L8f
            int r0 = r0 >>> 31
            r1 = 8
            int r0 = 8 - r0
            r6 = 0
        L4a:
            if (r6 >= r0) goto L7f
            r21 = 255(0xff, double:1.26E-321)
            long r21 = r16 & r21
            r7 = 0
            r23 = 128(0x80, double:6.3E-322)
            int r20 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r20 >= 0) goto L59
            r7 = 1
            goto L5a
        L59:
            r7 = 0
        L5a:
            if (r7 == 0) goto L76
            int r7 = r15 << 3
            int r7 = r7 + r6
            r20 = r7
            r21 = 0
            r22 = r9[r20]     // Catch: java.lang.Throwable -> L8f
            r23 = r10[r20]     // Catch: java.lang.Throwable -> L8f
            r23 = r22
            r22 = 0
            r1 = r23
            r24 = 8
            r2.recordReadOf(r1)     // Catch: java.lang.Throwable -> L8f
            goto L78
        L76:
            r24 = 8
        L78:
            long r16 = r16 >> r24
            int r6 = r6 + 1
            r1 = 8
            goto L4a
        L7f:
            r24 = 8
            r1 = 8
            if (r0 != r1) goto L96
        L85:
            if (r15 == r14) goto L95
            int r15 = r15 + 1
            r0 = 1
            r1 = r25
            r7 = r19
            goto L25
        L8f:
            r0 = move-exception
            r1 = r25
            goto La1
        L93:
            r19 = r7
        L95:
        L96:
            r6 = 0
            r1 = r25
            r1.setRereading(r6)
            goto La6
        La0:
            r0 = move-exception
        La1:
            r6 = 0
            r1.setRereading(r6)
            throw r0
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.RecomposeScopeImpl.rereadTrackedInstances():void");
    }

    public final Function1<Composition, Unit> end(final int token) {
        char c;
        final MutableObjectIntMap instances = this.trackedInstances;
        if (instances == null) {
            return null;
        }
        int i = 0;
        if (!getSkipped$runtime_release()) {
            MutableObjectIntMap this_$iv = instances;
            int $i$f$any = 0;
            Object[] k$iv$iv = this_$iv.keys;
            int[] v$iv$iv = this_$iv.values;
            long[] m$iv$iv$iv = this_$iv.metadata;
            int lastIndex$iv$iv$iv = m$iv$iv$iv.length - 2;
            int i$iv$iv$iv = 0;
            boolean z = false;
            if (0 <= lastIndex$iv$iv$iv) {
                loop0: while (true) {
                    long slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
                    int i2 = i;
                    ObjectIntMap this_$iv2 = this_$iv;
                    int $i$f$any2 = $i$f$any;
                    long $this$maskEmptyOrDeleted$iv$iv$iv$iv = ((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L);
                    if ($this$maskEmptyOrDeleted$iv$iv$iv$iv == -9187201950435737472L) {
                        if (i$iv$iv$iv == lastIndex$iv$iv$iv) {
                            break;
                        }
                        i$iv$iv$iv++;
                        this_$iv = this_$iv2;
                        $i$f$any = $i$f$any2;
                        i = i2;
                    } else {
                        int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                        int j$iv$iv$iv = 0;
                        while (true) {
                            if (j$iv$iv$iv >= bitCount$iv$iv$iv) {
                                if (bitCount$iv$iv$iv != 8) {
                                    break;
                                }
                            } else {
                                long value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                                int $i$f$isFull = value$iv$iv$iv$iv < 128 ? 1 : 0;
                                if ($i$f$isFull != 0) {
                                    int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv;
                                    Object obj = k$iv$iv[index$iv$iv$iv];
                                    int value$iv = v$iv$iv[index$iv$iv$iv];
                                    c = '\b';
                                    int instanceToken = value$iv != token ? 1 : 0;
                                    if (instanceToken != 0) {
                                        z = true;
                                        break loop0;
                                    }
                                } else {
                                    c = '\b';
                                }
                                slot$iv$iv$iv >>= c;
                                j$iv$iv$iv++;
                            }
                        }
                    }
                }
            }
            if (z) {
                return new Function1<Composition, Unit>() { // from class: androidx.compose.runtime.RecomposeScopeImpl$end$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Composition composition) {
                        invoke2(composition);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Composition composition) {
                        int i3;
                        RecomposeScopeImpl recomposeScopeImpl;
                        int $i$f$removeIf;
                        int i4;
                        RecomposeScopeImpl recomposeScopeImpl2;
                        int $i$f$removeIf2;
                        char c2;
                        if (this.this$0.currentToken == token && Intrinsics.areEqual(instances, this.this$0.trackedInstances) && (composition instanceof CompositionImpl)) {
                            MutableObjectIntMap this_$iv3 = instances;
                            int i5 = token;
                            RecomposeScopeImpl recomposeScopeImpl3 = this.this$0;
                            int $i$f$removeIf3 = 0;
                            MutableObjectIntMap this_$iv$iv = this_$iv3;
                            long[] m$iv$iv = this_$iv$iv.metadata;
                            int lastIndex$iv$iv = m$iv$iv.length - 2;
                            int i$iv$iv = 0;
                            if (0 > lastIndex$iv$iv) {
                                return;
                            }
                            while (true) {
                                long slot$iv$iv = m$iv$iv[i$iv$iv];
                                if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                                    i3 = i5;
                                    recomposeScopeImpl = recomposeScopeImpl3;
                                    $i$f$removeIf = $i$f$removeIf3;
                                } else {
                                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                                    int j$iv$iv = 0;
                                    while (j$iv$iv < bitCount$iv$iv) {
                                        long value$iv$iv$iv = 255 & slot$iv$iv;
                                        if (!(value$iv$iv$iv < 128)) {
                                            i4 = i5;
                                            recomposeScopeImpl2 = recomposeScopeImpl3;
                                            $i$f$removeIf2 = $i$f$removeIf3;
                                            c2 = '\b';
                                        } else {
                                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                                            c2 = '\b';
                                            Object instance = this_$iv3.keys[index$iv$iv];
                                            $i$f$removeIf2 = $i$f$removeIf3;
                                            int instanceToken2 = this_$iv3.values[index$iv$iv];
                                            boolean shouldRemove = instanceToken2 != i5;
                                            if (!shouldRemove) {
                                                i4 = i5;
                                                recomposeScopeImpl2 = recomposeScopeImpl3;
                                            } else {
                                                i4 = i5;
                                                ((CompositionImpl) composition).removeObservation$runtime_release(instance, recomposeScopeImpl3);
                                                if (!(instance instanceof DerivedState)) {
                                                    recomposeScopeImpl2 = recomposeScopeImpl3;
                                                } else {
                                                    recomposeScopeImpl2 = recomposeScopeImpl3;
                                                    ((CompositionImpl) composition).removeDerivedStateObservation$runtime_release((DerivedState) instance);
                                                    MutableScatterMap mutableScatterMap = recomposeScopeImpl2.trackedDependencies;
                                                    if (mutableScatterMap != null) {
                                                        mutableScatterMap.remove(instance);
                                                    }
                                                }
                                            }
                                            if (shouldRemove) {
                                                this_$iv3.removeValueAt(index$iv$iv);
                                            }
                                        }
                                        slot$iv$iv >>= c2;
                                        j$iv$iv++;
                                        $i$f$removeIf3 = $i$f$removeIf2;
                                        i5 = i4;
                                        recomposeScopeImpl3 = recomposeScopeImpl2;
                                    }
                                    i3 = i5;
                                    recomposeScopeImpl = recomposeScopeImpl3;
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
                                i5 = i3;
                                recomposeScopeImpl3 = recomposeScopeImpl;
                            }
                        }
                    }
                };
            }
        }
        return null;
    }

    /* compiled from: RecomposeScopeImpl.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ#\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000¢\u0006\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/runtime/RecomposeScopeImpl$Companion;", "", "()V", "adoptAnchoredScopes", "", "slots", "Landroidx/compose/runtime/SlotWriter;", "anchors", "", "Landroidx/compose/runtime/Anchor;", "newOwner", "Landroidx/compose/runtime/RecomposeScopeOwner;", "adoptAnchoredScopes$runtime_release", "hasAnchoredRecomposeScopes", "", "Landroidx/compose/runtime/SlotTable;", "hasAnchoredRecomposeScopes$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void adoptAnchoredScopes$runtime_release(SlotWriter slots, List<Anchor> anchors, RecomposeScopeOwner newOwner) {
            if (anchors.isEmpty()) {
                return;
            }
            int size = anchors.size();
            for (int index$iv = 0; index$iv < size; index$iv++) {
                Object item$iv = anchors.get(index$iv);
                Anchor anchor = (Anchor) item$iv;
                Object objSlot = slots.slot(anchor, 0);
                RecomposeScopeImpl recomposeScope = objSlot instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) objSlot : null;
                if (recomposeScope != null) {
                    recomposeScope.adoptedBy(newOwner);
                }
            }
        }

        public final boolean hasAnchoredRecomposeScopes$runtime_release(SlotTable slots, List<Anchor> anchors) {
            boolean z;
            if (anchors.isEmpty()) {
                return false;
            }
            int index$iv$iv = 0;
            int size = anchors.size();
            while (true) {
                if (index$iv$iv < size) {
                    Object item$iv$iv = anchors.get(index$iv$iv);
                    Anchor it = (Anchor) item$iv$iv;
                    if (slots.ownsAnchor(it) && (slots.slot$runtime_release(slots.anchorIndex(it), 0) instanceof RecomposeScopeImpl)) {
                        z = true;
                        break;
                    }
                    index$iv$iv++;
                } else {
                    z = false;
                    break;
                }
            }
            return z;
        }
    }
}
