package androidx.compose.runtime.collection;

import androidx.autofill.HintConstants;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScopeMap.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u000f\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u001b\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011J9\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00028\u00002!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00130\u0015H\u0086\b¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001b0\u001aJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0016\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001fJ9\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000e0\u0015H\u0086\b¢\u0006\u0002\u0010!J\u001b\u0010\"\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010%J.\u0010&\u001a\u00020\u000e2#\b\u0004\u0010'\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00130\u0015H\u0086\bJ\u001b\u0010(\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006*"}, d2 = {"Landroidx/compose/runtime/collection/ScopeMap;", "Key", "", "Scope", "()V", "map", "Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "size", "", "getSize", "()I", "add", "", "key", "scope", "(Ljava/lang/Object;Ljava/lang/Object;)V", "anyScopeOf", "", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "asMap", "", "", "clear", "contains", "element", "(Ljava/lang/Object;)Z", "forEachScopeOf", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeScope", "(Ljava/lang/Object;)V", "removeScopeIf", "predicate", "set", "value", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScopeMap<Key, Scope> {
    public static final int $stable = 8;
    private final MutableScatterMap<Object, Object> map = ScatterMapKt.mutableScatterMapOf();

    public final MutableScatterMap<Object, Object> getMap() {
        return this.map;
    }

    public final int getSize() {
        return this.map.get_size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r9v1, types: [androidx.collection.MutableScatterSet] */
    public final void add(Key key, Scope scope) {
        Scope scope2;
        MutableScatterMap<Object, Object> mutableScatterMap = this.map;
        int iFindInsertIndex = mutableScatterMap.findInsertIndex(key);
        boolean z = iFindInsertIndex < 0;
        MutableScatterSet mutableScatterSet = z ? null : mutableScatterMap.values[iFindInsertIndex];
        if (mutableScatterSet == null) {
            scope2 = scope;
        } else {
            if (mutableScatterSet instanceof MutableScatterSet) {
                Intrinsics.checkNotNull(mutableScatterSet, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.add$lambda$0>");
                mutableScatterSet.add(scope);
            } else if (mutableScatterSet != scope) {
                ?? mutableScatterSet2 = new MutableScatterSet(0, 1, null);
                Intrinsics.checkNotNull(mutableScatterSet, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.add$lambda$0");
                mutableScatterSet2.add(mutableScatterSet);
                mutableScatterSet2.add(scope);
                scope2 = mutableScatterSet2;
            }
            scope2 = mutableScatterSet;
        }
        if (z) {
            int i = ~iFindInsertIndex;
            mutableScatterMap.keys[i] = key;
            mutableScatterMap.values[i] = scope2;
            return;
        }
        mutableScatterMap.values[iFindInsertIndex] = scope2;
    }

    public final void set(Key key, Scope value) {
        this.map.set(key, value);
    }

    public final boolean contains(Key element) {
        return this.map.containsKey(element);
    }

    public final void forEachScopeOf(Key key, Function1<? super Scope, Unit> block) {
        char c;
        Object value = getMap().get(key);
        if (value != null) {
            if (value instanceof MutableScatterSet) {
                ScatterSet this_$iv = (MutableScatterSet) value;
                Object[] k$iv = this_$iv.elements;
                long[] m$iv$iv = this_$iv.metadata;
                int lastIndex$iv$iv = m$iv$iv.length - 2;
                int i$iv$iv = 0;
                if (0 > lastIndex$iv$iv) {
                    return;
                }
                while (true) {
                    long slot$iv$iv = m$iv$iv[i$iv$iv];
                    ScatterSet this_$iv2 = this_$iv;
                    if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) != -9187201950435737472L) {
                        int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                        for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                            long value$iv$iv$iv = 255 & slot$iv$iv;
                            if (!(value$iv$iv$iv < 128)) {
                                c = '\b';
                            } else {
                                int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                                c = '\b';
                                block.invoke(k$iv[index$iv$iv]);
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
                    this_$iv = this_$iv2;
                }
            } else {
                block.invoke(value);
            }
        }
    }

    public final boolean anyScopeOf(Key key, Function1<? super Scope, Boolean> block) {
        char c;
        Object value$iv = getMap().get(key);
        if (value$iv == null) {
            return false;
        }
        if (!(value$iv instanceof MutableScatterSet)) {
            return block.invoke(value$iv).booleanValue();
        }
        ScatterSet this_$iv$iv = (MutableScatterSet) value$iv;
        int $i$f$forEach = 0;
        Object[] k$iv$iv = this_$iv$iv.elements;
        long[] m$iv$iv$iv = this_$iv$iv.metadata;
        int lastIndex$iv$iv$iv = m$iv$iv$iv.length - 2;
        int i$iv$iv$iv = 0;
        if (0 > lastIndex$iv$iv$iv) {
            return false;
        }
        while (true) {
            long slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
            ScatterSet this_$iv$iv2 = this_$iv$iv;
            int $i$f$forEach2 = $i$f$forEach;
            long $this$maskEmptyOrDeleted$iv$iv$iv$iv = ((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L);
            if ($this$maskEmptyOrDeleted$iv$iv$iv$iv != -9187201950435737472L) {
                int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                for (int j$iv$iv$iv = 0; j$iv$iv$iv < bitCount$iv$iv$iv; j$iv$iv$iv++) {
                    long value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                    int $i$f$isFull = value$iv$iv$iv$iv < 128 ? 1 : 0;
                    if ($i$f$isFull == 0) {
                        c = '\b';
                    } else {
                        int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv;
                        c = '\b';
                        Object it = k$iv$iv[index$iv$iv$iv];
                        if (block.invoke(it).booleanValue()) {
                            return true;
                        }
                    }
                    slot$iv$iv$iv >>= c;
                }
                if (bitCount$iv$iv$iv != 8) {
                    return false;
                }
            }
            if (i$iv$iv$iv == lastIndex$iv$iv$iv) {
                return false;
            }
            i$iv$iv$iv++;
            $i$f$forEach = $i$f$forEach2;
            this_$iv$iv = this_$iv$iv2;
        }
    }

    public final void clear() {
        this.map.clear();
    }

    public final boolean remove(Key key, Scope scope) {
        Object value = this.map.get(key);
        if (value == null) {
            return false;
        }
        if (value instanceof MutableScatterSet) {
            MutableScatterSet set = (MutableScatterSet) value;
            boolean removed = set.remove(scope);
            if (removed && set.isEmpty()) {
                this.map.remove(key);
            }
            return removed;
        }
        if (!Intrinsics.areEqual(value, scope)) {
            return false;
        }
        this.map.remove(key);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void removeScopeIf(kotlin.jvm.functions.Function1<? super Scope, java.lang.Boolean> r46) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.ScopeMap.removeScopeIf(kotlin.jvm.functions.Function1):void");
    }

    public final void removeScope(Scope scope) {
        char c;
        MutableScatterMap this_$iv = this.map;
        MutableScatterMap this_$iv$iv = this_$iv;
        long[] m$iv$iv = this_$iv$iv.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 > lastIndex$iv$iv) {
            return;
        }
        while (true) {
            long slot$iv$iv = m$iv$iv[i$iv$iv];
            long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
            if ($this$maskEmptyOrDeleted$iv$iv$iv != -9187201950435737472L) {
                int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                    long value$iv$iv$iv = 255 & slot$iv$iv;
                    boolean zIsEmpty = false;
                    if (!(value$iv$iv$iv < 128)) {
                        c = '\b';
                    } else {
                        int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                        c = '\b';
                        Object obj = this_$iv.keys[index$iv$iv];
                        Object value = this_$iv.values[index$iv$iv];
                        if (value instanceof MutableScatterSet) {
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScope$lambda$3>");
                            MutableScatterSet set = (MutableScatterSet) value;
                            set.remove(scope);
                            zIsEmpty = set.isEmpty();
                        } else if (value == scope) {
                            zIsEmpty = true;
                        }
                        if (zIsEmpty) {
                            this_$iv.removeValueAt(index$iv$iv);
                        }
                    }
                    slot$iv$iv >>= c;
                }
                if (bitCount$iv$iv != 8) {
                    return;
                }
            }
            if (i$iv$iv == lastIndex$iv$iv) {
                return;
            } else {
                i$iv$iv++;
            }
        }
    }

    public final Map<Key, Set<Scope>> asMap() {
        HashMap result;
        ScatterMap this_$iv;
        int $i$f$forEach;
        Object[] k$iv;
        ScatterMap this_$iv2;
        int $i$f$forEach2;
        Object[] k$iv2;
        Set setMutableSetOf;
        HashMap result2 = new HashMap();
        ScatterMap this_$iv3 = this.map;
        int $i$f$forEach3 = 0;
        Object[] k$iv3 = this_$iv3.keys;
        Object[] v$iv = this_$iv3.values;
        long[] m$iv$iv = this_$iv3.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                result = result2;
                if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                    this_$iv = this_$iv3;
                    $i$f$forEach = $i$f$forEach3;
                    k$iv = k$iv3;
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int j$iv$iv = 0;
                    while (j$iv$iv < bitCount$iv$iv) {
                        long value$iv$iv$iv = 255 & slot$iv$iv;
                        if (!(value$iv$iv$iv < 128)) {
                            this_$iv2 = this_$iv3;
                            $i$f$forEach2 = $i$f$forEach3;
                            k$iv2 = k$iv3;
                        } else {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            Object key = k$iv3[index$iv$iv];
                            this_$iv2 = this_$iv3;
                            Object value = v$iv[index$iv$iv];
                            $i$f$forEach2 = $i$f$forEach3;
                            HashMap map = result;
                            k$iv2 = k$iv3;
                            Intrinsics.checkNotNull(key, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap.asMap$lambda$4");
                            if (value instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.asMap$lambda$4>");
                                MutableScatterSet set = (MutableScatterSet) value;
                                setMutableSetOf = set.asSet();
                            } else {
                                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.asMap$lambda$4");
                                setMutableSetOf = SetsKt.mutableSetOf(value);
                            }
                            map.put(key, setMutableSetOf);
                        }
                        slot$iv$iv >>= 8;
                        j$iv$iv++;
                        this_$iv3 = this_$iv2;
                        $i$f$forEach3 = $i$f$forEach2;
                        k$iv3 = k$iv2;
                    }
                    this_$iv = this_$iv3;
                    $i$f$forEach = $i$f$forEach3;
                    k$iv = k$iv3;
                    if (bitCount$iv$iv != 8) {
                        break;
                    }
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    break;
                }
                i$iv$iv++;
                result2 = result;
                this_$iv3 = this_$iv;
                $i$f$forEach3 = $i$f$forEach;
                k$iv3 = k$iv;
            }
        } else {
            result = result2;
        }
        return result;
    }
}
