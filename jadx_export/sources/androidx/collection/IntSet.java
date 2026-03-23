package androidx.collection;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IntSet.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J:\u0010\u0011\u001a\u00020\u00122!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00120\u0014H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010\u0018\u001a\u00020\u0012J:\u0010\u0018\u001a\u00020\u00122!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00120\u0014H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0011\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0004H\u0086\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0007J:\u0010\u001a\u001a\u00020\u00042!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00120\u0014H\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0013\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0016\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0080\b¢\u0006\u0002\b\u001eJ\t\u0010\u001f\u001a\u00020\u0004H\u0086\bJ:\u0010\u001f\u001a\u00020\u00042!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00120\u0014H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010 \u001a\u00020!2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020!0\u0014H\u0086\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010#\u001a\u00020!2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b($\u0012\u0004\u0012\u00020!0\u0014H\u0081\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u0010%\u001a\u00020\u0004H\u0016J\u0006\u0010&\u001a\u00020\u0012J\u0006\u0010'\u001a\u00020\u0012J:\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020+H\u0007JT\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020\u00042\b\b\u0002\u0010/\u001a\u00020+2\u0014\b\u0004\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020+0\u0014H\u0087\bø\u0001\u0000J\u0006\u00101\u001a\u00020\u0012J\b\u00102\u001a\u00020)H\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u0018\u0010\f\u001a\u00020\r8\u0000@\u0000X\u0081\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0002R\u0011\u0010\u000f\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\b\u0082\u0001\u00013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00064"}, d2 = {"Landroidx/collection/IntSet;", "", "()V", "_capacity", "", "_size", "capacity", "getCapacity", "()I", "elements", "", "getElements$annotations", "metadata", "", "getMetadata$annotations", "size", "getSize", "all", "", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "element", "any", "contains", "count", "equals", "other", "findElementIndex", "findElementIndex$collection", "first", "forEach", "", "block", "forEachIndex", "index", "hashCode", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "none", "toString", "Landroidx/collection/MutableIntSet;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class IntSet {
    public int _capacity;
    public int _size;
    public int[] elements;
    public long[] metadata;

    public /* synthetic */ IntSet(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void getElements$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final String joinToString(CharSequence separator) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i, null, 16, null);
    }

    private IntSet() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.elements = IntSetKt.getEmptyIntArray();
    }

    /* renamed from: getCapacity, reason: from getter */
    public final int get_capacity() {
        return this._capacity;
    }

    public final int getSize() {
        return this._size;
    }

    public final boolean any() {
        return this._size != 0;
    }

    public final boolean none() {
        return this._size == 0;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int first() {
        /*
            r20 = this;
            r0 = 0
            r1 = r20
            r2 = 0
            int[] r3 = r1.elements
            r4 = r1
            r5 = 0
            long[] r6 = r4.metadata
            int r7 = r6.length
            int r7 = r7 + (-2)
            r8 = 0
            if (r8 > r7) goto L5a
        L12:
            r9 = r6[r8]
            r11 = r9
            r13 = 0
            long r14 = ~r11
            r16 = 7
            long r14 = r14 << r16
            long r14 = r14 & r11
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r14 & r16
            int r13 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r13 == 0) goto L55
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = 0
        L31:
            if (r13 >= r11) goto L53
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 0
            r17 = 128(0x80, double:6.3E-322)
            int r19 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r19 >= 0) goto L41
            r17 = 1
            goto L43
        L41:
            r17 = 0
        L43:
            if (r17 == 0) goto L4f
            int r12 = r8 << 3
            int r12 = r12 + r13
            r14 = r12
            r15 = 0
            r16 = r3[r14]
            r17 = 0
            return r16
        L4f:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L31
        L53:
            if (r11 != r12) goto L5b
        L55:
            if (r8 == r7) goto L5a
            int r8 = r8 + 1
            goto L12
        L5a:
        L5b:
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
            java.lang.String r2 = "The IntSet is empty"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntSet.first():int");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int first(kotlin.jvm.functions.Function1<? super java.lang.Integer, java.lang.Boolean> r22) {
        /*
            r21 = this;
            r0 = r22
            java.lang.String r1 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = 0
            r2 = r21
            r3 = 0
            int[] r4 = r2.elements
            r5 = r2
            r6 = 0
            long[] r7 = r5.metadata
            int r8 = r7.length
            int r8 = r8 + (-2)
            r9 = 0
            if (r9 > r8) goto L88
        L1b:
            r10 = r7[r9]
            r12 = r10
            r14 = 0
            r15 = r1
            r16 = r2
            long r1 = ~r12
            r17 = 7
            long r1 = r1 << r17
            long r1 = r1 & r12
            r17 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r1 = r1 & r17
            int r12 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r12 == 0) goto L80
            int r1 = r9 - r8
            int r1 = ~r1
            int r1 = r1 >>> 31
            r2 = 8
            int r1 = 8 - r1
            r12 = 0
        L3d:
            if (r12 >= r1) goto L7a
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r10
            r17 = 0
            r18 = 128(0x80, double:6.3E-322)
            int r20 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
            if (r20 >= 0) goto L4d
            r18 = 1
            goto L4f
        L4d:
            r18 = 0
        L4f:
            if (r18 == 0) goto L71
            int r13 = r9 << 3
            int r13 = r13 + r12
            r14 = r13
            r17 = 0
            r18 = r4[r14]
            r19 = 0
            r20 = 8
            java.lang.Integer r2 = java.lang.Integer.valueOf(r18)
            java.lang.Object r2 = r0.invoke(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L6e
            return r18
        L6e:
            goto L73
        L71:
            r20 = 8
        L73:
            long r10 = r10 >> r20
            int r12 = r12 + 1
            r2 = 8
            goto L3d
        L7a:
            r20 = 8
            r2 = 8
            if (r1 != r2) goto L8c
        L80:
            if (r9 == r8) goto L8b
            int r9 = r9 + 1
            r1 = r15
            r2 = r16
            goto L1b
        L88:
            r15 = r1
            r16 = r2
        L8b:
        L8c:
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
            java.lang.String r2 = "Could not find a match"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntSet.first(kotlin.jvm.functions.Function1):int");
    }

    public final void forEachIndex(Function1<? super Integer, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long[] m = this.metadata;
        int lastIndex = m.length - 2;
        int i = 0;
        if (0 > lastIndex) {
            return;
        }
        while (true) {
            long slot = m[i];
            long $this$maskEmptyOrDeleted$iv = ((~slot) << 7) & slot & (-9187201950435737472L);
            if ($this$maskEmptyOrDeleted$iv != -9187201950435737472L) {
                int bitCount = 8 - ((~(i - lastIndex)) >>> 31);
                for (int j = 0; j < bitCount; j++) {
                    long value$iv = 255 & slot;
                    if (value$iv < 128) {
                        int index = (i << 3) + j;
                        block.invoke(Integer.valueOf(index));
                    }
                    slot >>= 8;
                }
                if (bitCount != 8) {
                    return;
                }
            }
            if (i == lastIndex) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void forEach(Function1<? super Integer, Unit> block) {
        char c;
        Intrinsics.checkNotNullParameter(block, "block");
        int[] k = this.elements;
        long[] m$iv = this.metadata;
        int lastIndex$iv = m$iv.length - 2;
        int i$iv = 0;
        if (0 > lastIndex$iv) {
            return;
        }
        while (true) {
            long slot$iv = m$iv[i$iv];
            long $this$maskEmptyOrDeleted$iv$iv = ((~slot$iv) << 7) & slot$iv & (-9187201950435737472L);
            if ($this$maskEmptyOrDeleted$iv$iv != -9187201950435737472L) {
                int bitCount$iv = 8 - ((~(i$iv - lastIndex$iv)) >>> 31);
                for (int j$iv = 0; j$iv < bitCount$iv; j$iv++) {
                    long value$iv$iv = 255 & slot$iv;
                    if (!(value$iv$iv < 128)) {
                        c = '\b';
                    } else {
                        int index$iv = (i$iv << 3) + j$iv;
                        c = '\b';
                        block.invoke(Integer.valueOf(k[index$iv]));
                    }
                    slot$iv >>= c;
                }
                if (bitCount$iv != 8) {
                    return;
                }
            }
            if (i$iv == lastIndex$iv) {
                return;
            } else {
                i$iv++;
            }
        }
    }

    public final boolean all(Function1<? super Integer, Boolean> predicate) {
        char c;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int[] k$iv = this.elements;
        long[] m$iv$iv = this.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 > lastIndex$iv$iv) {
            return true;
        }
        while (true) {
            long slot$iv$iv = m$iv$iv[i$iv$iv];
            long slot$iv$iv2 = slot$iv$iv;
            if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) != -9187201950435737472L) {
                int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                    long value$iv$iv$iv = slot$iv$iv2 & 255;
                    if (!(value$iv$iv$iv < 128)) {
                        c = '\b';
                    } else {
                        int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                        int element = k$iv[index$iv$iv];
                        c = '\b';
                        if (!predicate.invoke(Integer.valueOf(element)).booleanValue()) {
                            return false;
                        }
                    }
                    slot$iv$iv2 >>= c;
                }
                if (bitCount$iv$iv != 8) {
                    return true;
                }
            }
            if (i$iv$iv == lastIndex$iv$iv) {
                return true;
            }
            i$iv$iv++;
        }
    }

    public final boolean any(Function1<? super Integer, Boolean> predicate) {
        char c;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int[] k$iv = this.elements;
        long[] m$iv$iv = this.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 > lastIndex$iv$iv) {
            return false;
        }
        while (true) {
            long slot$iv$iv = m$iv$iv[i$iv$iv];
            long slot$iv$iv2 = slot$iv$iv;
            if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) != -9187201950435737472L) {
                int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                    long value$iv$iv$iv = slot$iv$iv2 & 255;
                    if (!(value$iv$iv$iv < 128)) {
                        c = '\b';
                    } else {
                        int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                        int element = k$iv[index$iv$iv];
                        c = '\b';
                        if (predicate.invoke(Integer.valueOf(element)).booleanValue()) {
                            return true;
                        }
                    }
                    slot$iv$iv2 >>= c;
                }
                if (bitCount$iv$iv != 8) {
                    return false;
                }
            }
            if (i$iv$iv == lastIndex$iv$iv) {
                return false;
            }
            i$iv$iv++;
        }
    }

    /* renamed from: count, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public final int count(Function1<? super Integer, Boolean> predicate) {
        char c;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int $i$f$count = 0;
        int count = 0;
        int[] k$iv = this.elements;
        long[] m$iv$iv = this.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                int $i$f$count2 = $i$f$count;
                int count2 = count;
                if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                    count = count2;
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                        long value$iv$iv$iv = 255 & slot$iv$iv;
                        if (!(value$iv$iv$iv < 128)) {
                            c = '\b';
                        } else {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            int element = k$iv[index$iv$iv];
                            c = '\b';
                            if (predicate.invoke(Integer.valueOf(element)).booleanValue()) {
                                count2++;
                            }
                        }
                        slot$iv$iv >>= c;
                    }
                    if (bitCount$iv$iv != 8) {
                        return count2;
                    }
                    count = count2;
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    break;
                }
                i$iv$iv++;
                $i$f$count = $i$f$count2;
            }
        }
        return count;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0082, code lost:
    
        r8 = (((~r2) << 6) & r2) & (-9187201950435737472L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x008f, code lost:
    
        if (r8 == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0092, code lost:
    
        r8 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean contains(int r25) {
        /*
            r24 = this;
            r0 = r25
            r1 = r24
            r2 = 0
            r3 = 0
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r4 = r4 * r0
            int r5 = r4 << 16
            r3 = r4 ^ r5
            r4 = 0
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r5 = r1._capacity
            r6 = 0
            int r6 = r3 >>> 7
            r6 = r6 & r5
            r7 = 0
        L1b:
            long[] r8 = r1.metadata
            r9 = 0
            int r10 = r6 >> 3
            r11 = r6 & 7
            int r11 = r11 << 3
            r12 = r8[r10]
            long r12 = r12 >>> r11
            int r14 = r10 + 1
            r14 = r8[r14]
            int r16 = 64 - r11
            long r14 = r14 << r16
            r16 = r2
            r17 = r3
            long r2 = (long) r11
            long r2 = -r2
            r18 = 63
            long r2 = r2 >> r18
            long r2 = r2 & r14
            long r2 = r2 | r12
            r8 = r2
            r10 = 0
            long r11 = (long) r4
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r11 = r11 * r13
            long r11 = r11 ^ r8
            long r13 = r11 - r13
            r18 = r2
            long r2 = ~r11
            long r2 = r2 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r2 = r2 & r13
        L55:
            r8 = r2
            r10 = 0
            r20 = 0
            int r15 = (r8 > r20 ? 1 : (r8 == r20 ? 0 : -1))
            if (r15 == 0) goto L5f
            r8 = 1
            goto L60
        L5f:
            r8 = 0
        L60:
            if (r8 == 0) goto L82
            r8 = r2
            r10 = 0
            r20 = r8
            r15 = 0
            int r22 = java.lang.Long.numberOfTrailingZeros(r20)
            int r15 = r22 >> 3
            int r15 = r15 + r6
            r8 = r15 & r5
            int[] r9 = r1.elements
            r9 = r9[r8]
            if (r9 != r0) goto L78
            goto L93
        L78:
            r9 = r2
            r11 = 0
            r20 = 1
            long r20 = r9 - r20
            long r9 = r9 & r20
            r2 = r9
            goto L55
        L82:
            r8 = r18
            r10 = 0
            long r11 = ~r8
            r23 = 6
            long r11 = r11 << r23
            long r11 = r11 & r8
            long r8 = r11 & r13
            int r10 = (r8 > r20 ? 1 : (r8 == r20 ? 0 : -1))
            if (r10 == 0) goto L99
        L92:
            r8 = -1
        L93:
            if (r8 < 0) goto L97
            r11 = 1
            goto L98
        L97:
            r11 = 0
        L98:
            return r11
        L99:
            int r7 = r7 + 8
            int r8 = r6 + r7
            r6 = r8 & r5
            r2 = r16
            r3 = r17
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntSet.contains(int):boolean");
    }

    public static /* synthetic */ String joinToString$default(IntSet intSet, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i2 & 1) != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        return intSet.joinToString(charSequence, charSequence2, charSequence3, i, (i2 & 16) != 0 ? "..." : charSequence4);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated) {
        char c;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        StringBuilder $this$joinToString_u24lambda_u2413 = new StringBuilder();
        int i = 0;
        $this$joinToString_u24lambda_u2413.append(prefix);
        int index = 0;
        IntSet this_$iv = this;
        int $i$f$forEach = 0;
        int[] k$iv = this_$iv.elements;
        long[] m$iv$iv = this_$iv.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            loop0: while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                int i2 = i;
                int index2 = index;
                IntSet this_$iv2 = this_$iv;
                int $i$f$forEach2 = $i$f$forEach;
                long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv != -9187201950435737472L) {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int index3 = index2;
                    for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                        long value$iv$iv$iv = slot$iv$iv & 255;
                        if (value$iv$iv$iv < 128) {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            c = '\b';
                            int element = k$iv[index$iv$iv];
                            if (index3 == limit) {
                                $this$joinToString_u24lambda_u2413.append(truncated);
                                break loop0;
                            }
                            if (index3 != 0) {
                                $this$joinToString_u24lambda_u2413.append(separator);
                            }
                            $this$joinToString_u24lambda_u2413.append(element);
                            index3++;
                        } else {
                            c = '\b';
                        }
                        slot$iv$iv >>= c;
                    }
                    if (bitCount$iv$iv != 8) {
                        break;
                    }
                    index = index3;
                } else {
                    index = index2;
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    break;
                }
                i$iv$iv++;
                this_$iv = this_$iv2;
                $i$f$forEach = $i$f$forEach2;
                i = i2;
            }
        }
        $this$joinToString_u24lambda_u2413.append(postfix);
        String string = $this$joinToString_u24lambda_u2413.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String joinToString$default(IntSet $this, CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, Function1 transform, int i, Object obj) {
        char c;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        CharSequence separator2 = (i & 1) != 0 ? ", " : separator;
        CharSequence prefix2 = (i & 2) != 0 ? "" : prefix;
        CharSequence postfix2 = (i & 4) != 0 ? "" : postfix;
        int limit2 = (i & 8) != 0 ? -1 : limit;
        CharSequence truncated2 = (i & 16) != 0 ? "..." : truncated;
        Intrinsics.checkNotNullParameter(separator2, "separator");
        Intrinsics.checkNotNullParameter(prefix2, "prefix");
        Intrinsics.checkNotNullParameter(postfix2, "postfix");
        Intrinsics.checkNotNullParameter(truncated2, "truncated");
        Intrinsics.checkNotNullParameter(transform, "transform");
        StringBuilder $this$joinToString_u24lambda_u2415 = new StringBuilder();
        int i2 = 0;
        $this$joinToString_u24lambda_u2415.append(prefix2);
        int index = 0;
        IntSet this_$iv = $this;
        int $i$f$forEach = 0;
        int[] k$iv = this_$iv.elements;
        long[] m$iv$iv = this_$iv.metadata;
        int $i$f$joinToString = m$iv$iv.length;
        int lastIndex$iv$iv = $i$f$joinToString - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            loop0: while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                int i3 = i2;
                int index2 = index;
                IntSet this_$iv2 = this_$iv;
                int $i$f$forEach2 = $i$f$forEach;
                long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv != -9187201950435737472L) {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int index3 = index2;
                    for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                        long value$iv$iv$iv = slot$iv$iv & 255;
                        if (value$iv$iv$iv < 128) {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            int element = k$iv[index$iv$iv];
                            if (index3 == limit2) {
                                $this$joinToString_u24lambda_u2415.append(truncated2);
                                break loop0;
                            }
                            if (index3 != 0) {
                                $this$joinToString_u24lambda_u2415.append(separator2);
                            }
                            c = '\b';
                            $this$joinToString_u24lambda_u2415.append((CharSequence) transform.invoke(Integer.valueOf(element)));
                            index3++;
                        } else {
                            c = '\b';
                        }
                        slot$iv$iv >>= c;
                    }
                    if (bitCount$iv$iv != 8) {
                        break;
                    }
                    index = index3;
                } else {
                    index = index2;
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    break;
                }
                i$iv$iv++;
                this_$iv = this_$iv2;
                $i$f$forEach = $i$f$forEach2;
                i2 = i3;
            }
        }
        $this$joinToString_u24lambda_u2415.append(postfix2);
        String string = $this$joinToString_u24lambda_u2415.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, Function1<? super Integer, ? extends CharSequence> transform) {
        int index;
        char c;
        CharSequence separator2 = separator;
        Intrinsics.checkNotNullParameter(separator2, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        Intrinsics.checkNotNullParameter(transform, "transform");
        StringBuilder $this$joinToString_u24lambda_u2415 = new StringBuilder();
        int i = 0;
        $this$joinToString_u24lambda_u2415.append(prefix);
        int index2 = 0;
        IntSet this_$iv = this;
        int $i$f$forEach = 0;
        int[] k$iv = this_$iv.elements;
        long[] m$iv$iv = this_$iv.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            loop0: while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                int i2 = i;
                int index3 = index2;
                IntSet this_$iv2 = this_$iv;
                int $i$f$forEach2 = $i$f$forEach;
                long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv != -9187201950435737472L) {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int j$iv$iv = 0;
                    index = index3;
                    while (j$iv$iv < bitCount$iv$iv) {
                        long value$iv$iv$iv = slot$iv$iv & 255;
                        if (value$iv$iv$iv < 128) {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            int element = k$iv[index$iv$iv];
                            c = '\b';
                            if (index == limit) {
                                $this$joinToString_u24lambda_u2415.append(truncated);
                                break loop0;
                            }
                            if (index != 0) {
                                $this$joinToString_u24lambda_u2415.append(separator2);
                            }
                            $this$joinToString_u24lambda_u2415.append(transform.invoke(Integer.valueOf(element)));
                            index++;
                        } else {
                            c = '\b';
                        }
                        slot$iv$iv >>= c;
                        j$iv$iv++;
                        separator2 = separator;
                    }
                    if (bitCount$iv$iv != 8) {
                        break;
                    }
                } else {
                    index = index3;
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    break;
                }
                i$iv$iv++;
                separator2 = separator;
                index2 = index;
                this_$iv = this_$iv2;
                $i$f$forEach = $i$f$forEach2;
                i = i2;
            }
        }
        $this$joinToString_u24lambda_u2415.append(postfix);
        String string = $this$joinToString_u24lambda_u2415.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005b A[PHI: r0
      0x005b: PHI (r0v3 'hash' int) = (r0v2 'hash' int), (r0v4 'hash' int) binds: [B:5:0x0025, B:15:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int hashCode() {
        /*
            r20 = this;
            r0 = 0
            r1 = r20
            r2 = 0
            int[] r3 = r1.elements
            r4 = r1
            r5 = 0
            long[] r6 = r4.metadata
            int r7 = r6.length
            int r7 = r7 + (-2)
            r8 = 0
            if (r8 > r7) goto L60
        L12:
            r9 = r6[r8]
            r11 = r9
            r13 = 0
            long r14 = ~r11
            r16 = 7
            long r14 = r14 << r16
            long r14 = r14 & r11
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r14 & r16
            int r13 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r13 == 0) goto L5b
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = 0
        L31:
            if (r13 >= r11) goto L59
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 0
            r17 = 128(0x80, double:6.3E-322)
            int r19 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r19 >= 0) goto L41
            r17 = 1
            goto L43
        L41:
            r17 = 0
        L43:
            if (r17 == 0) goto L55
            int r14 = r8 << 3
            int r14 = r14 + r13
            r15 = r14
            r16 = 0
            r17 = r3[r15]
            r18 = 0
            int r0 = r0 + r17
        L55:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L31
        L59:
            if (r11 != r12) goto L61
        L5b:
            if (r8 == r7) goto L60
            int r8 = r8 + 1
            goto L12
        L60:
        L61:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntSet.hashCode():int");
    }

    public boolean equals(Object other) {
        char c;
        if (other == this) {
            return true;
        }
        if (!(other instanceof IntSet) || ((IntSet) other)._size != this._size) {
            return false;
        }
        IntSet this_$iv = this;
        int[] k$iv = this_$iv.elements;
        long[] m$iv$iv = this_$iv.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 > lastIndex$iv$iv) {
            return true;
        }
        while (true) {
            long slot$iv$iv = m$iv$iv[i$iv$iv];
            IntSet this_$iv2 = this_$iv;
            if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) != -9187201950435737472L) {
                int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                    long value$iv$iv$iv = 255 & slot$iv$iv;
                    if (value$iv$iv$iv < 128) {
                        int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                        int element = k$iv[index$iv$iv];
                        c = '\b';
                        if (!((IntSet) other).contains(element)) {
                            return false;
                        }
                    } else {
                        c = '\b';
                    }
                    slot$iv$iv >>= c;
                }
                if (bitCount$iv$iv != 8) {
                    return true;
                }
            }
            if (i$iv$iv == lastIndex$iv$iv) {
                return true;
            }
            i$iv$iv++;
            this_$iv = this_$iv2;
        }
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0081, code lost:
    
        r8 = (((~r2) << 6) & r2) & (-9187201950435737472L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x008e, code lost:
    
        if (r8 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0091, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int findElementIndex$collection(int r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = 0
            r3 = 0
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r4 = r4 * r1
            int r5 = r4 << 16
            r3 = r4 ^ r5
            r4 = 0
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r5 = r0._capacity
            r6 = 0
            int r6 = r3 >>> 7
            r6 = r6 & r5
            r7 = 0
        L1b:
            long[] r8 = r0.metadata
            r9 = 0
            int r10 = r6 >> 3
            r11 = r6 & 7
            int r11 = r11 << 3
            r12 = r8[r10]
            long r12 = r12 >>> r11
            int r14 = r10 + 1
            r14 = r8[r14]
            int r16 = 64 - r11
            long r14 = r14 << r16
            r16 = r2
            r17 = r3
            long r2 = (long) r11
            long r2 = -r2
            r18 = 63
            long r2 = r2 >> r18
            long r2 = r2 & r14
            long r2 = r2 | r12
            r8 = r2
            r10 = 0
            long r11 = (long) r4
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r11 = r11 * r13
            long r11 = r11 ^ r8
            long r13 = r11 - r13
            r18 = r2
            long r2 = ~r11
            long r2 = r2 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r2 = r2 & r13
        L55:
            r8 = r2
            r10 = 0
            r11 = 0
            int r15 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r15 == 0) goto L5f
            r15 = 1
            goto L60
        L5f:
            r15 = 0
        L60:
            if (r15 == 0) goto L81
            r8 = r2
            r10 = 0
            r11 = r8
            r15 = 0
            int r20 = java.lang.Long.numberOfTrailingZeros(r11)
            int r11 = r20 >> 3
            int r11 = r11 + r6
            r8 = r11 & r5
            int[] r9 = r0.elements
            r9 = r9[r8]
            if (r9 != r1) goto L77
            return r8
        L77:
            r9 = r2
            r11 = 0
            r20 = 1
            long r20 = r9 - r20
            long r9 = r9 & r20
            r2 = r9
            goto L55
        L81:
            r8 = r18
            r10 = 0
            r20 = r11
            long r11 = ~r8
            r15 = 6
            long r11 = r11 << r15
            long r11 = r11 & r8
            long r8 = r11 & r13
            int r10 = (r8 > r20 ? 1 : (r8 == r20 ? 0 : -1))
            if (r10 == 0) goto L93
        L91:
            r2 = -1
            return r2
        L93:
            int r7 = r7 + 8
            int r8 = r6 + r7
            r6 = r8 & r5
            r2 = r16
            r3 = r17
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.IntSet.findElementIndex$collection(int):int");
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, Function1<? super Integer, ? extends CharSequence> transform) {
        StringBuilder sb;
        char c;
        CharSequence separator2 = separator;
        Intrinsics.checkNotNullParameter(separator2, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int $i$f$joinToString = 0;
        StringBuilder $this$joinToString_u24lambda_u2415$iv = new StringBuilder();
        int i = 0;
        $this$joinToString_u24lambda_u2415$iv.append(prefix);
        int index$iv = 0;
        int[] k$iv$iv = this.elements;
        long[] m$iv$iv$iv = this.metadata;
        int $i$f$joinToString2 = m$iv$iv$iv.length;
        int lastIndex$iv$iv$iv = $i$f$joinToString2 - 2;
        int i$iv$iv$iv = 0;
        if (0 <= lastIndex$iv$iv$iv) {
            loop0: while (true) {
                long slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
                int $i$f$joinToString3 = $i$f$joinToString;
                sb = $this$joinToString_u24lambda_u2415$iv;
                int i2 = i;
                int index$iv2 = index$iv;
                long $this$maskEmptyOrDeleted$iv$iv$iv$iv = ((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv$iv != -9187201950435737472L) {
                    int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                    int j$iv$iv$iv = 0;
                    index$iv = index$iv2;
                    while (j$iv$iv$iv < bitCount$iv$iv$iv) {
                        long value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                        if (value$iv$iv$iv$iv < 128) {
                            int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv;
                            int element$iv = k$iv$iv[index$iv$iv$iv];
                            c = '\b';
                            if (index$iv == limit) {
                                $this$joinToString_u24lambda_u2415$iv.append(truncated$iv);
                                break loop0;
                            }
                            if (index$iv != 0) {
                                $this$joinToString_u24lambda_u2415$iv.append(separator2);
                            }
                            $this$joinToString_u24lambda_u2415$iv.append(transform.invoke(Integer.valueOf(element$iv)));
                            index$iv++;
                        } else {
                            c = '\b';
                        }
                        slot$iv$iv$iv >>= c;
                        j$iv$iv$iv++;
                        separator2 = separator;
                    }
                    if (bitCount$iv$iv$iv != 8) {
                        break;
                    }
                } else {
                    index$iv = index$iv2;
                }
                if (i$iv$iv$iv == lastIndex$iv$iv$iv) {
                    break;
                }
                i$iv$iv$iv++;
                separator2 = separator;
                i = i2;
                $i$f$joinToString = $i$f$joinToString3;
                $this$joinToString_u24lambda_u2415$iv = sb;
            }
        } else {
            sb = $this$joinToString_u24lambda_u2415$iv;
        }
        $this$joinToString_u24lambda_u2415$iv.append(postfix);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, Function1<? super Integer, ? extends CharSequence> transform) {
        StringBuilder sb;
        char c;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int $i$f$joinToString = 0;
        StringBuilder $this$joinToString_u24lambda_u2415$iv = new StringBuilder();
        int i = 0;
        $this$joinToString_u24lambda_u2415$iv.append(prefix);
        int index$iv = 0;
        int[] k$iv$iv = this.elements;
        long[] m$iv$iv$iv = this.metadata;
        int $i$f$joinToString2 = m$iv$iv$iv.length;
        int lastIndex$iv$iv$iv = $i$f$joinToString2 - 2;
        int i$iv$iv$iv = 0;
        if (0 <= lastIndex$iv$iv$iv) {
            loop0: while (true) {
                long slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
                int $i$f$joinToString3 = $i$f$joinToString;
                sb = $this$joinToString_u24lambda_u2415$iv;
                int i2 = i;
                int index$iv2 = index$iv;
                long $this$maskEmptyOrDeleted$iv$iv$iv$iv = ((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv$iv == -9187201950435737472L) {
                    index$iv = index$iv2;
                } else {
                    int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                    index$iv = index$iv2;
                    for (int j$iv$iv$iv = 0; j$iv$iv$iv < bitCount$iv$iv$iv; j$iv$iv$iv++) {
                        long value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                        if (!(value$iv$iv$iv$iv < 128)) {
                            c = '\b';
                        } else {
                            int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv;
                            int element$iv = k$iv$iv[index$iv$iv$iv];
                            if (index$iv == -1) {
                                $this$joinToString_u24lambda_u2415$iv.append(truncated$iv);
                                break loop0;
                            }
                            if (index$iv != 0) {
                                $this$joinToString_u24lambda_u2415$iv.append(separator);
                            }
                            c = '\b';
                            $this$joinToString_u24lambda_u2415$iv.append(transform.invoke(Integer.valueOf(element$iv)));
                            index$iv++;
                        }
                        slot$iv$iv$iv >>= c;
                    }
                    if (bitCount$iv$iv$iv != 8) {
                        break;
                    }
                }
                if (i$iv$iv$iv == lastIndex$iv$iv$iv) {
                    break;
                }
                i$iv$iv$iv++;
                i = i2;
                $i$f$joinToString = $i$f$joinToString3;
                $this$joinToString_u24lambda_u2415$iv = sb;
            }
        } else {
            sb = $this$joinToString_u24lambda_u2415$iv;
        }
        $this$joinToString_u24lambda_u2415$iv.append(postfix);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, Function1<? super Integer, ? extends CharSequence> transform) {
        StringBuilder sb;
        char c;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int $i$f$joinToString = 0;
        StringBuilder $this$joinToString_u24lambda_u2415$iv = new StringBuilder();
        int i = 0;
        $this$joinToString_u24lambda_u2415$iv.append(prefix);
        int index$iv = 0;
        int[] k$iv$iv = this.elements;
        long[] m$iv$iv$iv = this.metadata;
        int $i$f$joinToString2 = m$iv$iv$iv.length;
        int lastIndex$iv$iv$iv = $i$f$joinToString2 - 2;
        int i$iv$iv$iv = 0;
        if (0 <= lastIndex$iv$iv$iv) {
            loop0: while (true) {
                long slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
                int $i$f$joinToString3 = $i$f$joinToString;
                sb = $this$joinToString_u24lambda_u2415$iv;
                int i2 = i;
                int index$iv2 = index$iv;
                long $this$maskEmptyOrDeleted$iv$iv$iv$iv = ((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv$iv != -9187201950435737472L) {
                    int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                    index$iv = index$iv2;
                    for (int j$iv$iv$iv = 0; j$iv$iv$iv < bitCount$iv$iv$iv; j$iv$iv$iv++) {
                        long value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                        if (value$iv$iv$iv$iv < 128) {
                            int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv;
                            int element$iv = k$iv$iv[index$iv$iv$iv];
                            if (index$iv == -1) {
                                $this$joinToString_u24lambda_u2415$iv.append(truncated$iv);
                                break loop0;
                            }
                            if (index$iv != 0) {
                                $this$joinToString_u24lambda_u2415$iv.append(separator);
                            }
                            c = '\b';
                            $this$joinToString_u24lambda_u2415$iv.append(transform.invoke(Integer.valueOf(element$iv)));
                            index$iv++;
                        } else {
                            c = '\b';
                        }
                        slot$iv$iv$iv >>= c;
                    }
                    if (bitCount$iv$iv$iv != 8) {
                        break;
                    }
                } else {
                    index$iv = index$iv2;
                }
                if (i$iv$iv$iv == lastIndex$iv$iv$iv) {
                    break;
                }
                i$iv$iv$iv++;
                i = i2;
                $i$f$joinToString = $i$f$joinToString3;
                $this$joinToString_u24lambda_u2415$iv = sb;
            }
        } else {
            sb = $this$joinToString_u24lambda_u2415$iv;
        }
        $this$joinToString_u24lambda_u2415$iv.append(postfix$iv);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(CharSequence separator, Function1<? super Integer, ? extends CharSequence> transform) {
        StringBuilder sb;
        char c;
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int $i$f$joinToString = 0;
        StringBuilder $this$joinToString_u24lambda_u2415$iv = new StringBuilder();
        int i = 0;
        $this$joinToString_u24lambda_u2415$iv.append(prefix$iv);
        int index$iv = 0;
        int[] k$iv$iv = this.elements;
        long[] m$iv$iv$iv = this.metadata;
        int lastIndex$iv$iv$iv = m$iv$iv$iv.length - 2;
        int i$iv$iv$iv = 0;
        if (0 <= lastIndex$iv$iv$iv) {
            loop0: while (true) {
                long slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
                int $i$f$joinToString2 = $i$f$joinToString;
                sb = $this$joinToString_u24lambda_u2415$iv;
                int i2 = i;
                int index$iv2 = index$iv;
                long $this$maskEmptyOrDeleted$iv$iv$iv$iv = ((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv$iv != -9187201950435737472L) {
                    int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                    index$iv = index$iv2;
                    for (int j$iv$iv$iv = 0; j$iv$iv$iv < bitCount$iv$iv$iv; j$iv$iv$iv++) {
                        long value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                        if (value$iv$iv$iv$iv < 128) {
                            int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv;
                            int element$iv = k$iv$iv[index$iv$iv$iv];
                            if (index$iv == -1) {
                                $this$joinToString_u24lambda_u2415$iv.append(truncated$iv);
                                break loop0;
                            }
                            if (index$iv != 0) {
                                $this$joinToString_u24lambda_u2415$iv.append(separator);
                            }
                            c = '\b';
                            $this$joinToString_u24lambda_u2415$iv.append(transform.invoke(Integer.valueOf(element$iv)));
                            index$iv++;
                        } else {
                            c = '\b';
                        }
                        slot$iv$iv$iv >>= c;
                    }
                    if (bitCount$iv$iv$iv != 8) {
                        break;
                    }
                } else {
                    index$iv = index$iv2;
                }
                if (i$iv$iv$iv == lastIndex$iv$iv$iv) {
                    break;
                }
                i$iv$iv$iv++;
                i = i2;
                $i$f$joinToString = $i$f$joinToString2;
                $this$joinToString_u24lambda_u2415$iv = sb;
            }
        } else {
            sb = $this$joinToString_u24lambda_u2415$iv;
        }
        $this$joinToString_u24lambda_u2415$iv.append(postfix$iv);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public final String joinToString(Function1<? super Integer, ? extends CharSequence> transform) {
        StringBuilder sb;
        char c;
        Intrinsics.checkNotNullParameter(transform, "transform");
        int $i$f$joinToString = 0;
        StringBuilder $this$joinToString_u24lambda_u2415$iv = new StringBuilder();
        int i = 0;
        $this$joinToString_u24lambda_u2415$iv.append(prefix$iv);
        int index$iv = 0;
        int[] k$iv$iv = this.elements;
        long[] m$iv$iv$iv = this.metadata;
        int lastIndex$iv$iv$iv = m$iv$iv$iv.length - 2;
        int i$iv$iv$iv = 0;
        if (0 <= lastIndex$iv$iv$iv) {
            loop0: while (true) {
                long slot$iv$iv$iv = m$iv$iv$iv[i$iv$iv$iv];
                int $i$f$joinToString2 = $i$f$joinToString;
                sb = $this$joinToString_u24lambda_u2415$iv;
                int i2 = i;
                int index$iv2 = index$iv;
                long $this$maskEmptyOrDeleted$iv$iv$iv$iv = ((~slot$iv$iv$iv) << 7) & slot$iv$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv$iv != -9187201950435737472L) {
                    int bitCount$iv$iv$iv = 8 - ((~(i$iv$iv$iv - lastIndex$iv$iv$iv)) >>> 31);
                    index$iv = index$iv2;
                    for (int j$iv$iv$iv = 0; j$iv$iv$iv < bitCount$iv$iv$iv; j$iv$iv$iv++) {
                        long value$iv$iv$iv$iv = slot$iv$iv$iv & 255;
                        if (value$iv$iv$iv$iv < 128) {
                            int index$iv$iv$iv = (i$iv$iv$iv << 3) + j$iv$iv$iv;
                            int element$iv = k$iv$iv[index$iv$iv$iv];
                            if (index$iv == -1) {
                                $this$joinToString_u24lambda_u2415$iv.append(truncated$iv);
                                break loop0;
                            }
                            if (index$iv != 0) {
                                $this$joinToString_u24lambda_u2415$iv.append(separator$iv);
                            }
                            c = '\b';
                            $this$joinToString_u24lambda_u2415$iv.append(transform.invoke(Integer.valueOf(element$iv)));
                            index$iv++;
                        } else {
                            c = '\b';
                        }
                        slot$iv$iv$iv >>= c;
                    }
                    if (bitCount$iv$iv$iv != 8) {
                        break;
                    }
                } else {
                    index$iv = index$iv2;
                }
                if (i$iv$iv$iv == lastIndex$iv$iv$iv) {
                    break;
                }
                i$iv$iv$iv++;
                i = i2;
                $i$f$joinToString = $i$f$joinToString2;
                $this$joinToString_u24lambda_u2415$iv = sb;
            }
        } else {
            sb = $this$joinToString_u24lambda_u2415$iv;
        }
        $this$joinToString_u24lambda_u2415$iv.append(postfix$iv);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
