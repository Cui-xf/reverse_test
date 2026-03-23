package androidx.compose.ui.text.caches;

import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LruCache.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0019J\u0006\u0010\u0007\u001a\u00020\u0005J/\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00028\u00012\b\u0010\u001f\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u001bJ\u0006\u0010\b\u001a\u00020\u0005J\u0015\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\u001d\u0010#\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001¢\u0006\u0002\u0010%J\u0006\u0010\u0013\u001a\u00020\u0005J\u0015\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010(\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010)J\u001d\u0010*\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010)J\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010,J$\u0010-\u001a\u0002H.\"\u0004\b\u0002\u0010.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H.00H\u0080\b¢\u0006\u0004\b1\u00102J\b\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000bj\b\u0012\u0004\u0012\u00028\u0000`\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000ej\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00058G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u00066"}, d2 = {"Landroidx/compose/ui/text/caches/LruCache;", "K", "V", "", "maxSize", "", "(I)V", "createCount", "evictionCount", "hitCount", "keySet", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "missCount", "monitor", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "putCount", "<set-?>", "size", "()I", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "evictAll", "get", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "resize", "safeSizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "sizeOf", "snapshot", "", "synchronizedValue", "R", "block", "Lkotlin/Function0;", "synchronizedValue$ui_text_release", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toString", "", "trimToSize", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class LruCache<K, V> {
    public static final int $stable = 8;
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashSet<K> keySet;
    private final HashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private final SynchronizedObject monitor = Synchronization_jvmKt.createSynchronizedObject();
    private int putCount;
    private int size;

    public final int size() {
        int i;
        SynchronizedObject lock$iv$iv = this.monitor;
        synchronized (lock$iv$iv) {
            i = this.size;
        }
        return i;
    }

    public LruCache(int maxSize) {
        if (!(maxSize > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        this.maxSize = maxSize;
        this.map = new HashMap<>(0, 0.75f);
        this.keySet = new LinkedHashSet<>();
    }

    public void resize(int maxSize) {
        if (!(maxSize > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        SynchronizedObject lock$iv = this.monitor;
        synchronized (lock$iv) {
            this.maxSize = maxSize;
            Unit unit = Unit.INSTANCE;
        }
        trimToSize(maxSize);
    }

    public final V get(K key) {
        SynchronizedObject lock$iv = this.monitor;
        synchronized (lock$iv) {
            V v = this.map.get(key);
            if (v != null) {
                this.keySet.remove(key);
                this.keySet.add(key);
                this.hitCount++;
                return v;
            }
            this.missCount++;
            V vCreate = create(key);
            if (vCreate == null) {
                return null;
            }
            SynchronizedObject lock$iv2 = this.monitor;
            synchronized (lock$iv2) {
                this.createCount++;
                V vPut = this.map.put(key, vCreate);
                this.keySet.remove(key);
                this.keySet.add(key);
                if (vPut != null) {
                    this.map.put(key, vPut);
                    v = vPut;
                } else {
                    this.size = size() + safeSizeOf(key, vCreate);
                }
                Unit unit = Unit.INSTANCE;
            }
            if (v != null) {
                entryRemoved(false, key, vCreate, v);
                return v;
            }
            trimToSize(this.maxSize);
            return vCreate;
        }
    }

    public final V put(K key, V value) {
        V vPut;
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        SynchronizedObject lock$iv = this.monitor;
        synchronized (lock$iv) {
            this.putCount++;
            this.size = size() + safeSizeOf(key, value);
            vPut = this.map.put(key, value);
            if (vPut != null) {
                this.size = size() - safeSizeOf(key, vPut);
            }
            if (this.keySet.contains(key)) {
                this.keySet.remove(key);
            }
            this.keySet.add(key);
        }
        if (vPut != null) {
            entryRemoved(false, key, vPut, value);
        }
        trimToSize(this.maxSize);
        return vPut;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a2, code lost:
    
        throw new java.lang.IllegalStateException("map/keySet size inconsistency");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void trimToSize(int r9) {
        /*
            r8 = this;
        L1:
            r0 = 0
            r1 = 0
            androidx.compose.ui.text.platform.SynchronizedObject r2 = r8.monitor
            r3 = 0
            monitor-enter(r2)
            r4 = 0
            int r5 = r8.size()     // Catch: java.lang.Throwable -> La3
            if (r5 < 0) goto L9a
            java.util.HashMap<K, V> r5 = r8.map     // Catch: java.lang.Throwable -> La3
            boolean r5 = r5.isEmpty()     // Catch: java.lang.Throwable -> La3
            if (r5 == 0) goto L1d
            int r5 = r8.size()     // Catch: java.lang.Throwable -> La3
            if (r5 != 0) goto L9a
        L1d:
            java.util.HashMap<K, V> r5 = r8.map     // Catch: java.lang.Throwable -> La3
            boolean r5 = r5.isEmpty()     // Catch: java.lang.Throwable -> La3
            java.util.LinkedHashSet<K> r6 = r8.keySet     // Catch: java.lang.Throwable -> La3
            boolean r6 = r6.isEmpty()     // Catch: java.lang.Throwable -> La3
            if (r5 != r6) goto L9a
            int r5 = r8.size()     // Catch: java.lang.Throwable -> La3
            r6 = 1
            if (r5 <= r9) goto L84
            java.util.HashMap<K, V> r5 = r8.map     // Catch: java.lang.Throwable -> La3
            boolean r5 = r5.isEmpty()     // Catch: java.lang.Throwable -> La3
            if (r5 != 0) goto L84
            java.util.LinkedHashSet<K> r5 = r8.keySet     // Catch: java.lang.Throwable -> La3
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch: java.lang.Throwable -> La3
            java.lang.Object r5 = kotlin.collections.CollectionsKt.first(r5)     // Catch: java.lang.Throwable -> La3
            r0 = r5
            java.util.HashMap<K, V> r5 = r8.map     // Catch: java.lang.Throwable -> La3
            java.util.Map r5 = (java.util.Map) r5     // Catch: java.lang.Throwable -> La3
            java.lang.Object r5 = r5.get(r0)     // Catch: java.lang.Throwable -> La3
            if (r5 == 0) goto L7b
            r1 = r5
            java.util.HashMap<K, V> r5 = r8.map     // Catch: java.lang.Throwable -> La3
            java.util.Map r5 = (java.util.Map) r5     // Catch: java.lang.Throwable -> La3
            java.util.Map r5 = kotlin.jvm.internal.TypeIntrinsics.asMutableMap(r5)     // Catch: java.lang.Throwable -> La3
            r5.remove(r0)     // Catch: java.lang.Throwable -> La3
            java.util.LinkedHashSet<K> r5 = r8.keySet     // Catch: java.lang.Throwable -> La3
            java.util.Collection r5 = (java.util.Collection) r5     // Catch: java.lang.Throwable -> La3
            java.util.Collection r5 = kotlin.jvm.internal.TypeIntrinsics.asMutableCollection(r5)     // Catch: java.lang.Throwable -> La3
            r5.remove(r0)     // Catch: java.lang.Throwable -> La3
            int r5 = r8.size()     // Catch: java.lang.Throwable -> La3
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.lang.Throwable -> La3
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch: java.lang.Throwable -> La3
            int r7 = r8.safeSizeOf(r0, r1)     // Catch: java.lang.Throwable -> La3
            int r5 = r5 - r7
            r8.size = r5     // Catch: java.lang.Throwable -> La3
            int r5 = r8.evictionCount     // Catch: java.lang.Throwable -> La3
            int r5 = r5 + r6
            r8.evictionCount = r5     // Catch: java.lang.Throwable -> La3
            goto L84
        L7b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> La3
            java.lang.String r6 = "inconsistent state"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> La3
            throw r5     // Catch: java.lang.Throwable -> La3
        L84:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> La3
            monitor-exit(r2)
            if (r0 != 0) goto L8e
            if (r1 != 0) goto L8e
        L8d:
            return
        L8e:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            r2 = 0
            r8.entryRemoved(r6, r0, r1, r2)
            goto L1
        L9a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> La3
            java.lang.String r6 = "map/keySet size inconsistency"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> La3
            throw r5     // Catch: java.lang.Throwable -> La3
        La3:
            r4 = move-exception
            monitor-exit(r2)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.caches.LruCache.trimToSize(int):void");
    }

    public final V remove(K key) {
        V vRemove;
        if (key == null) {
            throw new NullPointerException();
        }
        SynchronizedObject lock$iv = this.monitor;
        synchronized (lock$iv) {
            vRemove = this.map.remove(key);
            this.keySet.remove(key);
            if (vRemove != null) {
                this.size = size() - safeSizeOf(key, vRemove);
            }
            Unit unit = Unit.INSTANCE;
        }
        if (vRemove != null) {
            entryRemoved(false, key, vRemove, null);
        }
        return vRemove;
    }

    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
    }

    protected V create(K key) {
        return null;
    }

    private final int safeSizeOf(K key, V value) {
        int result = sizeOf(key, value);
        if (!(result >= 0)) {
            throw new IllegalStateException(("Negative size: " + key + '=' + value).toString());
        }
        return result;
    }

    protected int sizeOf(K key, V value) {
        return 1;
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int maxSize() {
        int i;
        SynchronizedObject lock$iv$iv = this.monitor;
        synchronized (lock$iv$iv) {
            i = this.maxSize;
        }
        return i;
    }

    public final int hitCount() {
        int i;
        SynchronizedObject lock$iv$iv = this.monitor;
        synchronized (lock$iv$iv) {
            i = this.hitCount;
        }
        return i;
    }

    public final int missCount() {
        int i;
        SynchronizedObject lock$iv$iv = this.monitor;
        synchronized (lock$iv$iv) {
            i = this.missCount;
        }
        return i;
    }

    public final int createCount() {
        int i;
        SynchronizedObject lock$iv$iv = this.monitor;
        synchronized (lock$iv$iv) {
            i = this.createCount;
        }
        return i;
    }

    public final int putCount() {
        int i;
        SynchronizedObject lock$iv$iv = this.monitor;
        synchronized (lock$iv$iv) {
            i = this.putCount;
        }
        return i;
    }

    public final int evictionCount() {
        int i;
        SynchronizedObject lock$iv$iv = this.monitor;
        synchronized (lock$iv$iv) {
            i = this.evictionCount;
        }
        return i;
    }

    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap;
        SynchronizedObject lock$iv = this.monitor;
        synchronized (lock$iv) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            Iterator<K> it = this.keySet.iterator();
            while (it.hasNext()) {
                K next = it.next();
                V v = this.map.get(next);
                Intrinsics.checkNotNull(v);
                linkedHashMap2.put(next, v);
            }
            linkedHashMap = linkedHashMap2;
        }
        return linkedHashMap;
    }

    public String toString() {
        String str;
        SynchronizedObject lock$iv = this.monitor;
        synchronized (lock$iv) {
            int accesses = this.hitCount + this.missCount;
            int hitPercent = accesses != 0 ? (this.hitCount * 100) / accesses : 0;
            str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + hitPercent + "%]";
        }
        return str;
    }

    public final <R> R synchronizedValue$ui_text_release(Function0<? extends R> block) {
        R rInvoke;
        SynchronizedObject lock$iv = this.monitor;
        synchronized (lock$iv) {
            rInvoke = block.invoke();
        }
        return rInvoke;
    }
}
